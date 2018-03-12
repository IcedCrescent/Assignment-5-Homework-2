package com.example.trungspc.greatstorywithpicasso.dal;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.trungspc.greatstorywithpicasso.model.StoryCard;

import java.util.ArrayList;
import java.util.List;

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
            int id = cursor.getInt(0);
            String imageUrl = cursor.getString(1);
            String title = cursor.getString(2);
            String desciption = cursor.getString(3);
            String content = cursor.getString(4);
            String author = cursor.getString(5);
            int bookmark = cursor.getInt(6);
            lstStories.add(new StoryCard(id, title, author, imageUrl, desciption, content, bookmark));
            cursor.moveToNext();
        }

        return lstStories;
    }

    public void bookmarkStory(int id, int bookmark) {
        sqLiteDatabase = assetHelper.getWritableDatabase();
        ContentValues newValues = new ContentValues();
        newValues.put("bookmark", bookmark);
        sqLiteDatabase.update(TABLE_SHORT_STORY, newValues, "id = ?", new String[] {String.valueOf(id)});
        sqLiteDatabase.close();
    }
}
