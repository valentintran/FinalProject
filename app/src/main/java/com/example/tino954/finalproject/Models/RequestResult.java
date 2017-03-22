package com.example.tino954.finalproject.Models;

import java.util.List;

/**
 * Created by tino954 on 17/03/2017.
 */

public class RequestResult {
    /*{
   "kind":"youtube#searchListResponse",
   "etag":etag,
   "nextPageToken":string,
   "prevPageToken":string,
   "regionCode":string,
   "pageInfo":{
      "totalResults":integer,
      "resultsPerPage":integer
   },
   "items":[
      {
         "kind":"youtube#searchResult",
         "etag":etag,
         "id":{
            "kind":string,
            "videoId":string,
            "channelId":string,
            "playlistId":string
         },
         "snippet":{
            "publishedAt":datetime,
            "channelId":string,
            "title":string,
            "description":string,
            "thumbnails":{
               (key):{
                  "url":string,
                  "width":unsigned integer,
                  "height":unsigned integer
               }
            },
            "channelTitle":string,
            "liveBroadcastContent":string
         }
      },
      {
         "kind":"youtube#searchResult",
         "etag":etag,
         "id":{
            "kind":string,
            "videoId":string,
            "channelId":string,
            "playlistId":string
         },
         "snippet":{
            "publishedAt":datetime,
            "channelId":string,
            "title":string,
            "description":string,
            "thumbnails":{
               (key):{
                  "url":string,
                  "width":unsigned integer,
                  "height":unsigned integer
               }
            },
            "channelTitle":string,
            "liveBroadcastContent":string
         }
      }
   ]
}*/


    private String kind;
    private String etag;
    private String nextPageToken;
    private String regionCode;
    private PageInfoYT pageInfo;
    private List<ItemYT> items;

    public String getKind() {
        return kind;
    }

    public void setKind(String kind) {
        this.kind = kind;
    }

    public String getEtag() {
        return etag;
    }

    public void setEtag(String etag) {
        this.etag = etag;
    }

    public String getNextPageToken() {
        return nextPageToken;
    }

    public void setNextPageToken(String nextPageToken) {
        this.nextPageToken = nextPageToken;
    }

    public String getRegionCode() {
        return regionCode;
    }

    public void setRegionCode(String regionCode) {
        this.regionCode = regionCode;
    }

    public PageInfoYT getPageInfo() {
        return pageInfo;
    }

    public void setPageInfo(PageInfoYT pageInfo) {
        this.pageInfo = pageInfo;
    }

    public List<ItemYT> getItems() {
        return items;
    }

    public void setItems(List<ItemYT> items) {
        this.items = items;
    }
}

