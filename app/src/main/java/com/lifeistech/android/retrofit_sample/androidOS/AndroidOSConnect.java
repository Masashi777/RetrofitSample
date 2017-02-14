package com.lifeistech.android.retrofit_sample.androidOS;

import com.lifeistech.android.retrofit_sample.androidOS.model.AndroidOSjson;

import java.io.Serializable;
import java.util.List;

/**
 * Created by Masashi Hamaguchi on 2017/02/07.
 */

public abstract class AndroidOSConnect implements Serializable {

    public static final String REQUEST_DOMAIN = "https://android-api-service.herokuapp.com";
    public static final String REQUEST_PATH = "/createOS";
    public static final String REQUEST_DELETE = "/androidOSs/{id}/delete";
    public static final String REQUEST_SHOWALL = "/showAll";


    public interface AndroidListener {

        public void onSuccess(List<AndroidOSjson> jsonList);

        public void onFailed(String error);

    }

    public interface AndroidDeleteListener {

        public void onSuccess();

        public void onFailed(String error);

    }

    public abstract void request(final String version, final String codename, final String reference, final AndroidListener listener);

    public abstract void delete(final String id,final AndroidDeleteListener listener);

    public abstract void showall(final AndroidListener listener);

}
