package com.example.trungspc.session3;

import android.content.DialogInterface;
import android.support.v4.content.res.ResourcesCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.RadioButton;

import com.flask.colorpicker.ColorPickerView;
import com.flask.colorpicker.OnColorSelectedListener;
import com.flask.colorpicker.builder.ColorPickerClickListener;
import com.flask.colorpicker.builder.ColorPickerDialogBuilder;

public class DrawActivity extends AppCompatActivity implements View.OnClickListener {

    private final String accentColor = String.format("#%06X", (0xFFFFFF & R.color.colorAccent));
    //private static final int DIALOG_ID = 0;
    private static final String TAG = "DrawActivity";
    private ImageView ivColor;
    private ImageView ivDone;
    private RadioButton rbThin, rbMedium, rbStrong;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_draw);
        Log.d(TAG, "onCreate: " + R.color.colorAccent);

        setupUI();
    }

    private void setupUI() {
        ivColor = findViewById(R.id.iv_color);
        ivDone = findViewById(R.id.iv_done);
        rbThin = findViewById(R.id.rb_thin);
        rbMedium = findViewById(R.id.rb_medium);
        rbStrong = findViewById(R.id.rb_strong);

        ivColor.setOnClickListener(this);
        ivDone.setOnClickListener(this);
        rbThin.setOnClickListener(this);
        rbMedium.setOnClickListener(this);
        rbStrong.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        //both ImageView use the same onClick func for easier maintenance
        switch (view.getId()) {
            case R.id.iv_color: {
                ColorPickerDialogBuilder
                        .with(this)
                        .setTitle("Choose a color")
                        .initialColor(ResourcesCompat.getColor(getResources(), R.color.colorAccent, null))
                        .wheelType(ColorPickerView.WHEEL_TYPE.FLOWER)
                        .density(12)
                        .setOnColorSelectedListener(new OnColorSelectedListener() {
                            @Override
                            public void onColorSelected(int selectedColor) {
                                Log.d(TAG, "onColorSelected: " + selectedColor);
                            }
                        })
                        .setPositiveButton("Ok", new ColorPickerClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int selectedColor, Integer[] allColors) {

                            }
                        })
                        .setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                            }
                        })
                        .build()
                        .show();
                break;
            }
            case R.id.iv_done: {

                break;
            }
            case R.id.rb_thin:
                Log.d(TAG, "Radio Button: Thin");
                break;
            case R.id.rb_medium:
                Log.d(TAG, "Radio Button: Medium");
                break;
            case R.id.rb_strong:
                Log.d(TAG, "Radio Button: Strong");
                break;
        }
    }


}
