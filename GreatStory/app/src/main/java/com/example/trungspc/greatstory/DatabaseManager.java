package com.example.trungspc.greatstory;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

import static android.content.ContentValues.TAG;

/**
 * Created by Trung's PC on 3/4/2018.
 */

public class DatabaseManager {

    private static final String TAG = "DatabaseManager";

    private static final String TABLE_SHORT_STORY = "tbl_short_story";

    private SQLiteDatabase sqLiteDatabase;
    private AssetHelper assetHelper;

    private static DatabaseManager databaseManager;

    public DatabaseManager(Context context) {
        assetHelper = new AssetHelper(context);
    }

    public  static DatabaseManager getInstance(Context context) {
        if (databaseManager == null) {
            databaseManager = new DatabaseManager(context);
        }
        return databaseManager;
    }

    public List<StoryCard> getAllStory() {
        List<StoryCard> lstStories = new ArrayList<>();
        sqLiteDatabase = assetHelper.getReadableDatabase();

        Cursor cursor = sqLiteDatabase.rawQuery("SELECT * FROM " + TABLE_SHORT_STORY, null);
        cursor.moveToFirst();

        while (!cursor.isAfterLast()) {
            lstStories.add(new StoryCard(cursor.getInt(0), cursor.getString(2), cursor.getString(5), cursor.getString(1)));
            cursor.moveToNext();
        }

        return lstStories;
    }
}
