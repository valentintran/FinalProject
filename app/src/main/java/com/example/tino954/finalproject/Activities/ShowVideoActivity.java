package com.example.tino954.finalproject.Activities;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.example.tino954.finalproject.Const.DeveloperKey;
import com.example.tino954.finalproject.R;
import com.google.android.youtube.player.YouTubeStandalonePlayer;


public class ShowVideoActivity extends AppCompatActivity {

    private static final String VIDEO = "VIDEO";
    private String id;

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
        Intent intent = YouTubeStandalonePlayer.createVideoIntent(ShowVideoActivity.this, DeveloperKey.DEVELOPER_KEY, id, 0, true, true);
        startActivity(intent);
    }
}
