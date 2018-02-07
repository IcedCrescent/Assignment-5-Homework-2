package com.example.trungspc.thirdassignment;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.GridView;

public class MainActivity extends AppCompatActivity {

    private GridView gvFlags;

    String[] flagNameList = {
            "Vietnam",
            "Canada",
            "Russia",
            "England",
            "USA",
            "Japan",
    };
    int[] imgId = {
            R.drawable.vn,
            R.drawable.ca,
            R.drawable.ru,
            R.drawable.gb,
            R.drawable.us,
            R.drawable.jp,
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setupUI();
    }

    private void setupUI() {
        CustomGridAdapter adapterViewAndroid = new CustomGridAdapter(MainActivity.this,flagNameList, imgId);
        gvFlags = (GridView) findViewById(R.id.gv_flags);
        gvFlags.setAdapter(adapterViewAndroid);
    }
}
