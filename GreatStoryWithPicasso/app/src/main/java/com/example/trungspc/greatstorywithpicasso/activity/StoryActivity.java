package com.example.trungspc.greatstorywithpicasso.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.trungspc.greatstorywithpicasso.R;
import com.example.trungspc.greatstorywithpicasso.dal.DatabaseManager;
import com.example.trungspc.greatstorywithpicasso.model.StoryCard;
import com.squareup.picasso.Picasso;

public class StoryActivity extends AppCompatActivity{

    private static final String TAG = "StoryActivity";
    StoryCard story;
    ImageView ivBack;
    ImageView ivStory;
    TextView tvTitle;
    TextView tvAuthor;
    TextView tvStory;
    ImageView bookmark;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_story);
        story = (StoryCard) getIntent().getSerializableExtra("story");
        setupUI();
    }

    private void setupUI() {
        if (getSupportActionBar() != null)
            getSupportActionBar().hide();

        ivBack = findViewById(R.id.iv_back);
        ivStory = findViewById(R.id.iv_story);
        tvTitle = findViewById(R.id.tv_title);
        tvAuthor = findViewById(R.id.tv_author);
        tvStory = findViewById(R.id.tv_story);
        bookmark = findViewById(R.id.iv_bookmark);

        Picasso.get().load(story.getImgUrl()).into(ivStory);
        tvTitle.setText(story.getTitle());
        tvAuthor.setText(story.getAuthor());
        tvStory.setText(story.getDescription());
        bookmark.setImageResource((story.getIsBookmarked()==0) ? R.drawable.ic_bookmark_border_white_24dp : R.drawable.ic_bookmark_yellow_24dp);
    }


    public void backClick(View view) {
        onBackPressed();
    }

    public void bookmarkClicked(View view) {
        story.setBookmark(story.getIsBookmarked()==0 ? 1 : 0);
        bookmark.setImageResource(story.getIsBookmarked()==0 ? R.drawable.ic_bookmark_border_white_24dp : R.drawable.ic_bookmark_yellow_24dp);
        DatabaseManager.getInstance(this).bookmarkStory(story.getId(), story.getIsBookmarked());
    }
}
