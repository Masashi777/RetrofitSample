package com.lifeistech.android.retrofit_sample;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.lifeistech.android.retrofit_sample.androidOS.AndroidOS;
import com.lifeistech.android.retrofit_sample.androidOS.AndroidOSConnect;
import com.lifeistech.android.retrofit_sample.androidOS.AndroidRetrofit;
import com.lifeistech.android.retrofit_sample.androidOS.model.AndroidOSjson;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Masashi Hamaguchi on 2017/02/14.
 */

public class EditActivity extends AppCompatActivity {

    TextView editVersion;
    TextView editCodename;
    TextView editReference;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.edit_view);

        editVersion = (EditText)findViewById(R.id.editVersion);
        editCodename = (EditText)findViewById(R.id.editCodename);
        editReference = (EditText)findViewById(R.id.editReference);

    }

    public void send(View v) {

        //使用するコネクタを生成
        AndroidOSConnect connect = new AndroidRetrofit();

        AndroidOS androidOS = new AndroidOS();
        androidOS.createAndroidOS(connect, editVersion.getText().toString(), editCodename.getText().toString(), editReference.getText().toString(), new AndroidOSConnect.AndroidListener() {

            @Override
            public void onSuccess(List<AndroidOSjson> json) {
                //nameだけとりだす
                ArrayList<AndroidOSjson> androidOSes = new ArrayList<>();

                for (AndroidOSjson d : json) {
                    androidOSes.add(d);
                }

                MainActivity.renew(androidOSes);
            }

            @Override
            public void onFailed(String error) {
                Log.d("TAG", error);
            }

        });

        finish();

    }


}
