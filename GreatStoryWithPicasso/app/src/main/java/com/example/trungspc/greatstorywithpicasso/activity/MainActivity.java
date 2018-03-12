package com.example.trungspc.greatstorywithpicasso.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;

import com.example.trungspc.greatstorywithpicasso.R;
import com.example.trungspc.greatstorywithpicasso.RVAdapter;
import com.example.trungspc.greatstorywithpicasso.dal.DatabaseManager;
import com.example.trungspc.greatstorywithpicasso.model.StoryCard;

import java.util.List;

public class MainActivity extends AppCompatActivity{

    private static final String TAG = "MainActivity";
    private RecyclerView rv;
    private List<StoryCard> stories;
    private CardView cvStory;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rv = findViewById(R.id.rv_recycled_view);
        cvStory = findViewById(R.id.cv);

        LinearLayoutManager llm = new LinearLayoutManager(this);
        rv.setLayoutManager(llm);
        rv.setHasFixedSize(true);
    }

    @Override
    protected void onStart() {
        Log.d(TAG, "onStart: called");
        super.onStart();
        initializeData();
        initializeAdapter();
    }

    public void initializeData() {
        stories = DatabaseManager.getInstance(this).getAllStory();

    }

    private void initializeAdapter() {
        RVAdapter adapter = new RVAdapter(stories);
        rv.setAdapter(adapter);
    }

    public void posistionAction(View view) {
        Intent intent = new Intent(this, StoryActivity.class);
        intent.putExtra("story", stories.get((int) view.getTag()));
        startActivity(intent);
    }
}
