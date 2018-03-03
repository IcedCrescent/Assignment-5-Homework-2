package com.example.trungspc.toiecvocab;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

import static android.content.ContentValues.TAG;

/**
 * Created by Trung's PC on 3/1/2018.
 */

public class DatabaseManager {

    private static final String TAG = "DatabaseManager";

    private static final String TABLE_TOPIC = "tbl_topic";
    private static final String TABLE_WORD = "tbl_word";

    private SQLiteDatabase sqLiteDatabase;
    private AssetHelper assetHelper;

    private static DatabaseManager databaseManager;

    public DatabaseManager(Context context) {
        assetHelper = new AssetHelper(context);
    }

    public static DatabaseManager getInstance(Context context) {
        if (databaseManager == null) {
            databaseManager = new DatabaseManager(context);
        }
        return databaseManager;
    }

    public List<TopicModel> getListTopic() {
        List<TopicModel> lstTopicModels = new ArrayList<>();
        sqLiteDatabase = assetHelper.getReadableDatabase();

        Cursor cursor = sqLiteDatabase.rawQuery("select * from " + TABLE_TOPIC, null);
        cursor.moveToFirst();

        while (!cursor.isAfterLast()) {
            //read data
            int id = cursor.getInt(0);
            String name = cursor.getString(1);
            String imageUrl = cursor.getString(2);
            String category = cursor.getString(3);
            String color = cursor.getString(4);
            String lastTime = cursor.getString(5);
            
            lstTopicModels.add(new TopicModel(id, name, imageUrl, category, color, lastTime));
            //next row
            cursor.moveToNext();
        }

        Log.d(TAG, "getListTopic: " + lstTopicModels);
        
        return lstTopicModels;
    }
}
