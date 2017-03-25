package com.example.tino954.finalproject.ViewHolders;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.tino954.finalproject.Interfaces.OnVideoSelectedListener;
import com.example.tino954.finalproject.Models.VideoEntry;
import com.example.tino954.finalproject.R;

/**
 * Created by tino954 on 17/03/2017.
 */

public class VideoViewHolder extends RecyclerView.ViewHolder {

    private TextView videoName;
    private ImageView imageView;
    private Context mContext;


    private OnVideoSelectedListener onVideoSelectedListener;

    public VideoViewHolder(Context context, View itemView) {
        super(itemView);
        mContext = context;

        videoName = (TextView) itemView.findViewById(R.id.name);
        imageView = (ImageView) itemView.findViewById(R.id.img);
    }

    public void bind(final VideoEntry video) {

        videoName.setText(video.getName());
        Glide.with(mContext).load(video.getId()).into(imageView);

        itemView.setOnClickListener(v -> {
            if (onVideoSelectedListener == null) {
                return;
            }
            onVideoSelectedListener.onVideoSelected(video);
        });
    }

    public void setOnVideoSelectedListener(OnVideoSelectedListener onVideoSelectedListener) {
        this.onVideoSelectedListener = onVideoSelectedListener;
    }
}
