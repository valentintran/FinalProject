package com.example.tino954.finalproject.Activities;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import com.example.tino954.finalproject.Const.DeveloperKey;
import com.example.tino954.finalproject.R;
import com.google.android.youtube.player.YouTubeBaseActivity;
import com.google.android.youtube.player.YouTubeInitializationResult;
import com.google.android.youtube.player.YouTubePlayer;
import com.google.android.youtube.player.YouTubePlayerView;


public class ShowVideoActivity extends YouTubeBaseActivity{

    private static final String VIDEO = "VIDEO";
    private static String id;
    private static final String API_KEY = DeveloperKey.DEVELOPER_KEY;
    YouTubePlayer.OnInitializedListener onInitializedListener;

    public static void start(Context context, String id) {
        Intent intent = new Intent(context, ShowVideoActivity.class);
        intent.putExtra(VIDEO, id);
        context.startActivity(intent);

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_video);

        id = getIntent().getStringExtra(VIDEO);

        YouTubePlayerView videoPlayer = (YouTubePlayerView) findViewById(R.id.videoPlayer);

        onInitializedListener = new YouTubePlayer.OnInitializedListener() {
            @Override
            public void onInitializationSuccess(YouTubePlayer.Provider provider, YouTubePlayer youTubePlayer, boolean wasRestored) {
                youTubePlayer.loadVideo(id);
            }

            @Override
            public void onInitializationFailure(YouTubePlayer.Provider provider, YouTubeInitializationResult youTubeInitializationResult) {
            }
        };

        videoPlayer.initialize(API_KEY, onInitializedListener);
    }

}
