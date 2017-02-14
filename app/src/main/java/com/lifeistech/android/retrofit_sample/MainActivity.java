package com.lifeistech.android.retrofit_sample;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.lifeistech.android.retrofit_sample.androidOS.AndroidOS;
import com.lifeistech.android.retrofit_sample.androidOS.AndroidOSConnect;
import com.lifeistech.android.retrofit_sample.androidOS.AndroidRetrofit;
import com.lifeistech.android.retrofit_sample.androidOS.model.AndroidOSjson;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    static ListView listView;
    static CustomAdapter adapter;
    static ArrayList<AndroidOSjson> androidOSs =new ArrayList<AndroidOSjson>();

    //使用するコネクタを生成
    AndroidOSConnect connect = new AndroidRetrofit();

    final AndroidOS androidOS = new AndroidOS();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.list_view_main);

        listView = (ListView)findViewById(R.id.listView);

        //OS情報の取得
        androidOS.create(connect, new AndroidOSConnect.AndroidListener() {

            @Override
            public void onSuccess(List<AndroidOSjson> jsonList) {
                //nameだけとりだす
                ArrayList<AndroidOSjson> androidOSes = new ArrayList<>();

                for (AndroidOSjson d : jsonList) {
                    androidOSes.add(d);
                }

                renew(androidOSes);
            }

            @Override
            public void onFailed(String error) {
                Log.d("TAG", error);
            }

        });

        adapter = new CustomAdapter(getApplicationContext(), R.layout.list_view_main, androidOSs);
        listView.setAdapter(adapter);

        listView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {

                String itemId = ((CustomAdapter)listView.getAdapter()).getItem(position).getId();

                androidOS.delete(connect, itemId);

                androidOS.showall(connect, new AndroidOSConnect.AndroidListener() {

                    @Override
                    public void onSuccess(List<AndroidOSjson> jsonList) {
                        //nameだけとりだす
                        ArrayList<AndroidOSjson> androidOSes = new ArrayList<>();

                        for (AndroidOSjson d : jsonList) {
                            androidOSes.add(d);
                        }

                        renew(androidOSes);

                    }

                    @Override
                    public void onFailed(String error) {
                        Log.d("TAG", error);
                    }
                });

                return false;
            }
        });

    }

    static public void renew(final ArrayList<AndroidOSjson> androidOSArray) {

        androidOSs.clear();
        androidOSs.addAll(androidOSArray);
        adapter.notifyDataSetChanged();

    }

    public void add(View v) {
        Intent intent = new Intent(this, EditActivity.class);
        startActivity(intent);
    }

}
