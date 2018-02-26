package com.example.qklahpita.draw;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.text.Layout;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.BaseAdapter;
import android.widget.ImageView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Trung's PC on 2/4/2018.
 */

public class GridImageAdapter extends BaseAdapter {
    List<ImageModel> imageModelList = ImageUtils.getListImage();
    Context context;


    public GridImageAdapter(Context context) {
        this.context = context;
    }

    @Override
    public int getCount() {
        return imageModelList.size();
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
    public View getView(int position, View convertView, ViewGroup parent) {

        //create image view
        ImageView imageView = new ImageView(context);
        imageView.setLayoutParams(new AbsListView.LayoutParams(AbsListView.LayoutParams.MATCH_PARENT, 400)); //height can be whatever you wish
        imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
        imageView.setPadding(5, 5, 5, 5);
        imageView.setCropToPadding(true);

        //set image
        Bitmap bitmap = BitmapFactory.decodeFile(imageModelList.get(position).path);
        imageView.setImageBitmap(bitmap);

        return imageView;
    }
}
