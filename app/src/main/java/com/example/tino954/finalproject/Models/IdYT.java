package com.example.tino954.finalproject.Models;

/**
 * Created by tino954 on 22/03/2017.
 */

public class IdYT {

    /*"id": {
    "kind": string,
    "videoId": string,
    "channelId": string,
    "playlistId": string
  }*/

    private String kind;
    private String videoID;
    private String channelId;
    private String playlistID;

    public String getKind() {
        return kind;
    }

    public void setKind(String kind) {
        this.kind = kind;
    }

    public String getVideoID() {
        return videoID;
    }

    public void setVideoID(String videoID) {
        this.videoID = videoID;
    }

    public String getChannelId() {
        return channelId;
    }

    public void setChannelId(String channelId) {
        this.channelId = channelId;
    }

    public String getPlaylistID() {
        return playlistID;
    }

    public void setPlaylistID(String playlistID) {
        this.playlistID = playlistID;
    }
}
