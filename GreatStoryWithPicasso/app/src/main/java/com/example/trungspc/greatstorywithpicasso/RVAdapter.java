package com.example.trungspc.greatstorywithpicasso;

import android.content.res.Resources;
import android.graphics.Color;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.trungspc.greatstorywithpicasso.model.StoryCard;
import com.squareup.picasso.Picasso;

import java.util.List;

import static android.content.ContentValues.TAG;

/**
 * Created by Trung's PC on 3/4/2018.
 */

public class RVAdapter extends RecyclerView.Adapter<RVAdapter.StoryViewHolder> {
    public static class StoryViewHolder extends RecyclerView.ViewHolder{
        private static final String TAG = "StoryViewHolder";

        CardView cv;
        TextView storyTitle;
        TextView storyAuthor;
        ImageView storyImg;
        View bookmark;

        StoryViewHolder(View itemView) {
            super(itemView);
            cv = (CardView) itemView.findViewById(R.id.cv);
            storyTitle = (TextView) itemView.findViewById(R.id.tv_story_title);
            storyAuthor = (TextView) itemView.findViewById(R.id.tv_story_author);
            storyImg = (ImageView) itemView.findViewById(R.id.iv_story_photo);
            bookmark = (View) itemView.findViewById(R.id.v_bookmark);
        }

    }

    List<StoryCard> stories;

    public RVAdapter(List<StoryCard> stories) {
        this.stories = stories;
    }

    @Override
    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
    }

    @Override
    public StoryViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.rv_item, parent, false);
        StoryViewHolder svh = new StoryViewHolder(v);
        return svh;
    }

    @Override
    public void onBindViewHolder(StoryViewHolder holder, int position) {
        holder.storyTitle.setText(stories.get(position).getTitle());
        holder.storyAuthor.setText(stories.get(position).getAuthor());
        Picasso.get().load(stories.get(position).getImgUrl()).into(holder.storyImg);
        holder.bookmark.setBackgroundColor((stories.get(position).getIsBookmarked() == 0) ? ContextCompat.getColor(App.getContext(), R.color.colorPrimary) : Color.YELLOW);
        holder.cv.setTag(position);
    }

    @Override
    public int getItemCount() {
        return stories.size();
    }
}
