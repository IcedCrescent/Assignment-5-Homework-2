package com.example.trungspc.greatstorywithpicasso;

import android.app.Application;
import android.content.Context;

/**
 * Created by Trung's PC on 3/12/2018.
 */

public class App extends Application {
    private static Context mContext;

    @Override
    public void onCreate() {
        super.onCreate();
        mContext = this;
    }

    public static Context getContext() {
        return mContext;
    }
}
