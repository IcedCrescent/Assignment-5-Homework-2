package com.example.trungspc.secondassignment;

import android.content.Context;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Layout;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.github.clans.fab.FloatingActionMenu;

import java.lang.reflect.Field;
import java.util.Random;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private static final String TAG = "MainActivity";
    final Class drawableClass = R.drawable.class;
    final Field[] fields = drawableClass.getFields();
    final Random rand = new Random();
    private FloatingActionMenu fbMenu;
    private LinearLayout linearLayout;
    private ImageView image;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        fbMenu = findViewById(R.id.fb_menu);
        fbMenu.setOnClickListener(this);

        linearLayout = findViewById(R.id.ll_layout);
    }

    @Override
    public void onClick(View v) {
//        int rnd = rand.nextInt(fields.length);
//        Log.d(TAG, "onClick: " + rnd);
//        CustomImageView myImage = new CustomImageView(this);
//        try {
//            int resID = fields[rnd].getInt(drawableClass);
//            myImage.setImageResource(resID);
//            myImage.measure(linearLayout.getWidth(), linearLayout.getHeight());
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        linearLayout.addView(myImage);
//        fbMenu.close(false);
        Log.d(TAG, "onClick: ");
        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT);
        image.setImageResource(R.drawable.food_1);
        image.setLayoutParams(params);
        linearLayout.addView(image);
    }
}

