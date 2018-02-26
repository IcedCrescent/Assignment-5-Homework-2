package com.example.qklahpita.draw;

import android.Manifest;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.os.Build;
import android.os.Environment;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.github.clans.fab.FloatingActionButton;
import com.github.clans.fab.FloatingActionMenu;

import java.io.File;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private static final int REQUEST_PERMISSION = 1; //use any number if you wish
    private static final String TAG = "MainActivity";
    private FloatingActionButton fbCamera;
    private FloatingActionButton fbBrush;
    private FloatingActionMenu fbMenu;
    private GridView gvImages;
    private LinearLayout noImage;
    private android.support.design.widget.FloatingActionButton fbDelete;
    private int nPrevSelGridItem;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setupPermission();
        setupUI();

//        nPrevSelGridItem = -1;
//        gvImages.setChoiceMode(AbsListView.CHOICE_MODE_MULTIPLE_MODAL);
//        gvImages.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//            View viewPrev;
//            @Override
//            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//                fbDelete.setVisibility(View.VISIBLE);
//                try {
//                    if (nPrevSelGridItem != -1) {
//                        viewPrev = gvImages.getChildAt(nPrevSelGridItem);
//                        viewPrev.setBackgroundColor(Color.WHITE);
//                    }
//                    nPrevSelGridItem = position;
//                    if (nPrevSelGridItem == position) {
//                        view.setBackgroundColor(getResources().getColor(R.color.colorPrimaryDark));
//                    }
//                } catch (Exception e) {
//                    e.printStackTrace();
//                }
//            }
//        });

    }

    private void setupPermission() {
        if (Build.VERSION.SDK_INT >= 23) {
            if (checkSelfPermission(Manifest.permission.WRITE_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED) {
                ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE}, REQUEST_PERMISSION);
            }
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        if (requestCode == REQUEST_PERMISSION) {
            if (grantResults[0] == PackageManager.PERMISSION_DENIED) {
                AlertDialog.Builder builder = new AlertDialog.Builder(this);
                builder.setTitle("Warning!").setMessage("Cấp quyền đi thằng loz")
                        .setPositiveButton("Ừ", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                ActivityCompat.requestPermissions(MainActivity.this, new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE}, REQUEST_PERMISSION);
                            }
                        })
                        .setNegativeButton("Đéo", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                MainActivity.this.finish();
                            }
                        })
                        .show();
            }
        }
    }

    private void setupUI() {
        fbCamera = findViewById(R.id.fb_camera);
        fbBrush = findViewById(R.id.fb_brush);
        fbMenu = findViewById(R.id.fb_menu);
        gvImages = findViewById(R.id.gv_images);
        noImage = findViewById(R.id.ll_noimage);
        fbDelete = findViewById(R.id.fb_delete);

        fbCamera.setOnClickListener(this);
        fbBrush.setOnClickListener(this);
    }

    @Override
    protected void onStart() {
        super.onStart();
        checkStorage();
        final GridImageAdapter gridImageAdapter = new GridImageAdapter(this);
        gvImages.setAdapter(gridImageAdapter);
        gvImages.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                final AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                final AlertDialog alert = builder.create();
                builder.setTitle("Delete image?")
                        .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                alert.dismiss();
                            }
                        })
                        .setNegativeButton("No", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                alert.cancel();
                            }
                        })
                        .show();
                return true;
            }
        });
    }

    @Override
    public void onClick(View view) {
        Intent intent = new Intent(this, DrawActivity.class);

        if (view.getId() == R.id.fb_camera)
            intent.putExtra("camera_mode", true);
        else
            intent.putExtra("camera_mode", false);
        startActivity(intent);

        fbMenu.close(false);
    }

    void checkStorage() {
        File directory = new File("/sdcard/Draw Image");
        File[] contents = directory.listFiles();
        Log.d(TAG, "checkStorage: " + Environment.getExternalStorageDirectory().toString());
        Log.d(TAG, "checkStorage: " + (contents.length));
        // the directory file is not really a directory..
        if (contents == null) {
            Log.d(TAG, "checkStorage: directory not exists");
        }
        // Folder is empty
        else if (contents.length == 0) {
            noImage.setVisibility(View.VISIBLE);
        }
        // Folder contains files
        else {
            noImage.setVisibility(View.INVISIBLE);
        }
    }
}
