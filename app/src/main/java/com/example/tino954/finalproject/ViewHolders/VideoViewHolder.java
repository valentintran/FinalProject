package com.example.tino954.finalproject.ViewHolders;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.tino954.finalproject.Interfaces.OnVideoSelectedListener;
import com.example.tino954.finalproject.Models.VideoEntry;
import com.example.tino954.finalproject.R;

/**
 * Created by tino954 on 17/03/2017.
 */

public class VideoViewHolder extends RecyclerView.ViewHolder {

    private TextView videoName;
    private ImageView img;

    private OnVideoSelectedListener onVideoSelectedListener;


    public VideoViewHolder(View itemView) {
        super(itemView);

        videoName = (TextView) itemView.findViewById(R.id.name);
        img = (ImageView) itemView.findViewById(R.id.img);
    }

    public void bind(final VideoEntry video) {

        videoName.setText(video.getName());
        itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (onVideoSelectedListener == null) {
                    return;
                }
                onVideoSelectedListener.onVideoSelected(video);
            }
        });
    }

    public void setOnVideoSelectedListener(OnVideoSelectedListener onVideoSelectedListener) {
        this.onVideoSelectedListener = onVideoSelectedListener;
    }
}
