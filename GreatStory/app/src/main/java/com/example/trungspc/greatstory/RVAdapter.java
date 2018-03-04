package com.example.trungspc.greatstory;

import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

/**
 * Created by Trung's PC on 3/4/2018.
 */

public class RVAdapter extends RecyclerView.Adapter<RVAdapter.StoryViewHolder> {
    public static class StoryViewHolder extends RecyclerView.ViewHolder {

        CardView cv;
        TextView storyTitle;
        TextView storyAuthor;
        ImageView storyImg;

        StoryViewHolder(View itemView) {
            super(itemView);
            cv = (CardView) itemView.findViewById(R.id.cv);
            storyTitle = (TextView) itemView.findViewById(R.id.tv_story_title);
            storyAuthor = (TextView) itemView.findViewById(R.id.tv_story_author);
            storyImg = (ImageView) itemView.findViewById(R.id.iv_story_photo);
        }
    }

    List<StoryCard> stories;

    RVAdapter(List<StoryCard> stories) {
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
        new DownloadImageTask(holder.storyImg).execute(stories.get(position).getImgUrl());
    }

    @Override
    public int getItemCount() {
        return stories.size();
    }
}
