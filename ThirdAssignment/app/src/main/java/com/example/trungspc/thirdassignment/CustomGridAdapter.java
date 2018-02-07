package com.example.trungspc.thirdassignment;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by Trung's PC on 2/6/2018.
 */

public class CustomGridAdapter extends BaseAdapter {

    String[] countryNames;
    Context context;
    int[] imgID;
    private static LayoutInflater inflater = null;

    public CustomGridAdapter(Context context, String[] countryNames, int[] imgID) {
        this.countryNames = countryNames;
        this.context = context;
        this.imgID = imgID;
    }

    @Override
    public int getCount() {
        return countryNames.length;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        View gridViewAndroid;
        inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        if (convertView == null ) {
            gridViewAndroid = new View(context);
            gridViewAndroid = inflater.inflate(R.layout.custom_gridlayout, null);
            TextView textViewAndroid = (TextView) gridViewAndroid.findViewById(R.id.tv_flag);
            ImageView imageViewAndroid = (ImageView) gridViewAndroid.findViewById(R.id.iv_flag);
            textViewAndroid.setText(countryNames[position]);
            imageViewAndroid.setImageResource(imgID[position]);
        } else {
            gridViewAndroid = (View) convertView;
        }
        return gridViewAndroid;
    }
}
