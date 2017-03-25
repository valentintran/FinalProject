package com.example.tino954.finalproject.Activities;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import com.example.tino954.finalproject.Const.DeveloperKey;
import com.example.tino954.finalproject.R;
import com.google.android.youtube.player.YouTubeBaseActivity;
import com.google.android.youtube.player.YouTubeInitializationResult;
import com.google.android.youtube.player.YouTubePlayer;
import com.google.android.youtube.player.YouTubePlayer.ErrorReason;
import com.google.android.youtube.player.YouTubePlayer.PlaybackEventListener;
import com.google.android.youtube.player.YouTubePlayer.PlayerStateChangeListener;
import com.google.android.youtube.player.YouTubePlayer.Provider;
import com.google.android.youtube.player.YouTubePlayerView;


public class ShowVideoActivity extends YouTubeBaseActivity implements YouTubePlayer.OnInitializedListener {

    private static final String VIDEO_ID = "VIDEO_ID";
    private static final String VIDEO_TITLE = "VIDEO_TITLE";
    private static final String VIDEO_DESCRIPTION = "VIDEO_DESCRIPTION";
    private static final String VIDEO_CHANNEL = "VIDEO_CHANNEL";

    private static final String API_KEY = DeveloperKey.DEVELOPER_KEY;
    private String videoId;

    public static void start(Context context, String videoId, String videoTitle,String videoChannel, String videoDescription) {
        Intent intent = new Intent(context, ShowVideoActivity.class);
        intent.putExtra(VIDEO_ID, videoId);
        intent.putExtra(VIDEO_TITLE, videoTitle);
        intent.putExtra(VIDEO_CHANNEL, videoChannel);
        intent.putExtra(VIDEO_DESCRIPTION, videoDescription);
        context.startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_video);

        videoId = getIntent().getStringExtra(VIDEO_ID);
        String videoTitle = getIntent().getStringExtra(VIDEO_TITLE);
        String videoDescription = getIntent().getStringExtra(VIDEO_DESCRIPTION);
        String videoChannel = getIntent().getStringExtra(VIDEO_CHANNEL);

        YouTubePlayerView youTubePlayerView = (YouTubePlayerView) findViewById(R.id.videoPlayer);
        TextView tvTitle = (TextView) findViewById(R.id.tvTitle);
        TextView tvDescription = (TextView) findViewById(R.id.tvDescription);
        TextView tvChannel = (TextView) findViewById(R.id.tvChannel);

        tvTitle.setText(videoTitle);
        tvDescription.setText(videoDescription);
        tvChannel.setText(videoChannel);

        youTubePlayerView.initialize(API_KEY, this);
    }

    @Override
    public void onInitializationSuccess(Provider provider, YouTubePlayer youTubePlayer, boolean b) {
        youTubePlayer.setPlayerStateChangeListener(playerStateChangeListener);
        youTubePlayer.setPlaybackEventListener(playbackEventListener);

        if(!b) {
            youTubePlayer.loadVideo(videoId);
        }
    }

    @Override
    public void onInitializationFailure(Provider provider, YouTubeInitializationResult youTubeInitializationResult) {
        Toast.makeText(this, "Failure to Initialize!", Toast.LENGTH_LONG).show();
    }

    private PlaybackEventListener playbackEventListener = new PlaybackEventListener() {
        @Override
        public void onBuffering(boolean arg0) {
        }
        @Override
        public void onPaused() {
        }
        @Override
        public void onPlaying() {
        }
        @Override
        public void onSeekTo(int arg0) {
        }
        @Override
        public void onStopped() {
        }
    };
    private PlayerStateChangeListener playerStateChangeListener = new PlayerStateChangeListener() {
        @Override
        public void onAdStarted() {
        }
        @Override
        public void onError(ErrorReason arg0) {
        }
        @Override
        public void onLoaded(String arg0) {
        }
        @Override
        public void onLoading() {
        }
        @Override
        public void onVideoEnded() {
        }
        @Override
        public void onVideoStarted() {
        }
    };
}
