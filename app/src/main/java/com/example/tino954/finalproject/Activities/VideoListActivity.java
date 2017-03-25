package com.example.tino954.finalproject.Activities;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.tino954.finalproject.Adapters.VideoAdapter;
import com.example.tino954.finalproject.Const.DeveloperKey;
import com.example.tino954.finalproject.Interfaces.OnVideoSelectedListener;
import com.example.tino954.finalproject.Models.Item;
import com.example.tino954.finalproject.Models.SearchResult;
import com.example.tino954.finalproject.Models.VideoEntries;
import com.example.tino954.finalproject.Models.VideoEntry;
import com.example.tino954.finalproject.R;
import com.google.gson.Gson;

import java.util.List;

public class VideoListActivity extends AppCompatActivity implements OnVideoSelectedListener {

    private static final String VIDEO_SEARCH_URL = "https://www.googleapis.com/youtube/v3/search?part=snippet";
    private RecyclerView recyclerView;
    private List<Item> items;
    private VideoEntries videoEntries = new VideoEntries();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_video_list);

        String request = getIntent().getStringExtra("request");
        request = request.replaceAll("\\s", "+");
        recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        getVideos(request);

    }

    private void getVideos(String query) {
        StringRequest videosRequest = new StringRequest(VIDEO_SEARCH_URL + "&q=" + query +
                "&maxResults=50&type=video&key=" + DeveloperKey.DEVELOPER_KEY, response -> {
                    SearchResult searchResult = new Gson().fromJson(response, SearchResult.class);
                    items = searchResult.getItems();

                    for(int i=0; i<items.size(); i++) {
                        VideoEntry videoEntry = new VideoEntry();

                        videoEntry.setName(items.get(i).getSnippet().getTitle());
                        videoEntry.setId(items.get(i).getId().getVideoId());
                        videoEntry.setUrl(items.get(i).getSnippet().getThumbnails().getDefault().getUrl());
                        videoEntry.setDescription(items.get(i).getSnippet().getDescription());
                        videoEntry.setChannel(items.get(i).getSnippet().getChannelTitle());

                        videoEntries.add(i,videoEntry);
                    }
                    setAdapter(videoEntries);
                }, error -> Log.e("Videos", "error"));

        Volley.newRequestQueue(this).add(videosRequest);
    }

    private void setAdapter(VideoEntries videoEntries) {
        VideoAdapter adapter = new VideoAdapter(this,videoEntries);
        adapter.setOnVideoSelectedListener(this);
        recyclerView.setAdapter(adapter);
    }

    @Override
    public void onVideoSelected(VideoEntry video) {
        ShowVideoActivity.start(this, video.getId(), video.getName(),video.getChannel(), video.getDescription());
    }
}
