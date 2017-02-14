package com.lifeistech.android.retrofit_sample.androidOS;

import android.util.Log;

import com.lifeistech.android.retrofit_sample.androidOS.model.AndroidOSjson;

import java.util.List;

import retrofit.Callback;
import retrofit.RestAdapter;
import retrofit.RetrofitError;
import retrofit.client.Response;
import retrofit.http.GET;
import retrofit.http.Path;
import retrofit.http.Query;

/**
 * Created by Masashi Hamaguchi on 2017/02/07.
 */

public class AndroidRetrofit extends AndroidOSConnect {

    public interface AndroidApiService{
        @GET(REQUEST_PATH)
        public void request(@Query("version") String version, @Query("codename") String codename, @Query("reference") String reference, Callback<List<AndroidOSjson>> cb);

        @GET(REQUEST_DELETE)
        public void delete(@Path("id") String id,Callback<Response> callback);

        @GET(REQUEST_SHOWALL)
        public void showall(Callback<List<AndroidOSjson>> cd);
    }

    public void request(final String version, final String codename, final String reference, final AndroidListener listener) {
        RestAdapter restAdapter = new RestAdapter.Builder()
                .setEndpoint(REQUEST_DOMAIN)
                .setLogLevel(RestAdapter.LogLevel.FULL)
                .build();

        AndroidApiService service = restAdapter.create(AndroidApiService.class);

        service.request(version, codename, reference, new Callback<List<AndroidOSjson>>() {
            @Override
            public void success(List<AndroidOSjson> androidOSjson, Response response) {
                listener.onSuccess(androidOSjson);
                Log.e("RetrofitResult", "Create Success");
            }

            @Override
            public void failure(RetrofitError error) {
                listener.onFailed(error.toString());
                Log.e("TAG", error.toString());
            }
        });
    }

    public void delete(final String id) {
        RestAdapter restAdapter = new RestAdapter.Builder()
                .setEndpoint(REQUEST_DOMAIN)
                .setLogLevel(RestAdapter.LogLevel.FULL)
                .build();

        AndroidApiService service = restAdapter.create(AndroidApiService.class);

        service.delete(id, new Callback<Response>() {

            @Override
            public void success(Response response, Response response2) {
                Log.e("RetrofitResult", "Delete Success");
            }

            @Override
            public void failure(RetrofitError error) {
                Log.e("TAG", error.toString());
            }
        });
    }

    public void showall(final AndroidListener listener) {
        RestAdapter restAdapter = new RestAdapter.Builder()
                .setEndpoint(REQUEST_DOMAIN)
                .setLogLevel(RestAdapter.LogLevel.FULL)
                .build();

        AndroidApiService service = restAdapter.create(AndroidApiService.class);

        service.showall(new Callback<List<AndroidOSjson>>() {
            @Override
            public void success(List<AndroidOSjson> androidOSjson, Response response) {
                listener.onSuccess(androidOSjson);
                Log.e("RetrofitResult", "success");
            }

            @Override
            public void failure(RetrofitError error) {
                listener.onFailed(error.toString());
                Log.e("TAG", error.toString());
            }
        });
    }

}
