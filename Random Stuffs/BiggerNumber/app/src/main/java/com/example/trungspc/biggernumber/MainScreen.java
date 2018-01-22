package com.example.trungspc.biggernumber;

import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class MainScreen extends AppCompatActivity {
    private int num1, num2;
    private int points;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_screen);

        points = 0;
        pickRandomNumbers();

    }

    private void pickRandomNumbers() {
        Random rand = new Random();
        num1 = rand.nextInt(10);
        while (true) {
            num2 = rand.nextInt(10);
            if (num2 == num1)
                continue;
            break;
        }
        Button leftBtn = (Button) findViewById(R.id.buttonLeft);
        leftBtn.setText(Integer.toString(num1));
        Button rightBtn = (Button) findViewById(R.id.buttonRight);
        rightBtn.setText(Integer.toString(num2));
    }

    public void leftButtonClick(View view) {
        if (num1 >= num2) {
            points++;
        }
        else {
            points--;
            Toast.makeText(this, "You SUCK", Toast.LENGTH_SHORT).show();
        }
        TextView tv = (TextView) findViewById(R.id.score_field);
        tv.setText("Scores: " + points);

        pickRandomNumbers();

        checkScore();
    }

    public void rightButtonClick(View view) {
        if (num2 >= num1)
            points++;
        else {
            points--;
            Toast.makeText(this, "You SUCK", Toast.LENGTH_SHORT).show();
        }
        TextView tv = (TextView) findViewById(R.id.score_field);
        tv.setText("Scores: " + points);

        pickRandomNumbers();

        checkScore();
    }

    public void checkScore() {
        if (points % 5 == 0)
            Toast.makeText(this, "Great job!", Toast.LENGTH_SHORT).show();
        if (points <= 0) {
            AlertDialog.Builder alert = new AlertDialog.Builder(this);
            alert.setTitle("GAME OVER");
            alert.setMessage("Seriously?");
            alert.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {
                    pickRandomNumbers();
                    points = 0;
                    TextView tv = (TextView) findViewById(R.id.score_field);
                    tv.setText("Scores: 0");
                }
            });
            alert.show();
        }
    }
}
