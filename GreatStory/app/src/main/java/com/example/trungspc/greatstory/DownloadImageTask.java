package com.example.trungspc.greatstory;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.util.Log;
import android.widget.ImageView;

import java.io.InputStream;

/**
 * Created by Trung's PC on 3/4/2018.
 */

public class DownloadImageTask extends AsyncTask<String, Void, Bitmap> {
    ImageView ivTest;

    public DownloadImageTask(ImageView ivTest) {
        this.ivTest = ivTest;
    }

    @Override
    protected Bitmap doInBackground(String... urls) {
        String urlDisplay = urls[0];
        Bitmap mIcon = null;
        try {
            InputStream in = new java.net.URL(urlDisplay).openStream();
            mIcon = BitmapFactory.decodeStream(in);
        } catch (Exception e) {
            Log.e("Error", e.getMessage());
            e.printStackTrace();
        }
        return mIcon;
    }

    protected void onPostExecute(Bitmap result) {
        ivTest.setImageBitmap(result);
    }
}
