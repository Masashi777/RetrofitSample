package com.lifeistech.android.retrofit_sample;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.lifeistech.android.retrofit_sample.androidOS.AndroidOS;
import com.lifeistech.android.retrofit_sample.androidOS.model.AndroidOSjson;

import java.util.ArrayList;

/**
 * Created by Masashi Hamaguchi on 2017/02/13.
 */

public class CustomAdapter extends ArrayAdapter<AndroidOSjson> {

    ArrayList<AndroidOSjson> items;

    public CustomAdapter(Context context, int resource, ArrayList<AndroidOSjson> objects) {
        super(context, resource, objects);
        items = objects;
    }

    @Override
    public int getCount() {
        return items.size();
    }

    @Override
    public AndroidOSjson getItem(int position) {
        return items.get(position);
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        AndroidOSjson item = getItem(position);
        final ViewHolder viewHolder;

        if (convertView != null) {
            viewHolder = (ViewHolder) convertView.getTag();
        } else {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.oslist, parent, false);

            viewHolder = new ViewHolder();
            viewHolder.textView = (TextView) convertView.findViewById(R.id.id);
            viewHolder.textView.setTextColor(Color.BLACK);
            viewHolder.textView2 = (TextView) convertView.findViewById(R.id.version);
            viewHolder.textView2.setTextColor(Color.BLACK);
            viewHolder.textView3 = (TextView) convertView.findViewById(R.id.codename);
            viewHolder.textView3.setTextColor(Color.BLACK);
            viewHolder.textView4 = (TextView) convertView.findViewById(R.id.reference);
            viewHolder.textView4.setTextColor(Color.BLACK);

            convertView.setTag(viewHolder);
        }


        viewHolder.textView.setText(item.getId());
        viewHolder.textView2.setText(item.getVersion());
        viewHolder.textView3.setText(item.getCodename());
        viewHolder.textView4.setText(item.getReference());



        return convertView;
    }

    static class ViewHolder {
        TextView textView;
        TextView textView2;
        TextView textView3;
        TextView textView4;
    }

}
