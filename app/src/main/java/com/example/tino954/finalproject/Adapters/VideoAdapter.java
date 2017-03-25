package com.example.tino954.finalproject.Adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.tino954.finalproject.Interfaces.OnVideoSelectedListener;
import com.example.tino954.finalproject.Models.VideoEntries;
import com.example.tino954.finalproject.R;
import com.example.tino954.finalproject.ViewHolders.VideoViewHolder;

/**
 * Created by tino954 on 17/03/2017.
 */

public class VideoAdapter extends RecyclerView.Adapter<VideoViewHolder> {

    private final VideoEntries videoEntries;
    private OnVideoSelectedListener onVideoSelectedListener;
    private Context mContext;

    public VideoAdapter(Context context, VideoEntries videoEntries) {
        mContext = context;
        this.videoEntries = videoEntries;
    }

    @Override
    public VideoViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.viewholder_video, parent, false);
        return new VideoViewHolder(mContext,view);
    }

    @Override
    public void onBindViewHolder(VideoViewHolder holder, int position) {
        holder.setOnVideoSelectedListener(onVideoSelectedListener);
        holder.bind(videoEntries.get(position));
    }

    @Override
    public int getItemCount() {
        return videoEntries != null ? videoEntries.size() : 0 ;
    }

    public void setOnVideoSelectedListener (OnVideoSelectedListener onVideoSelectedListener) {
        this.onVideoSelectedListener = onVideoSelectedListener;
    }
}
