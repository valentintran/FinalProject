package com.example.tino954.finalproject.Models;

/**
 * Created by tino954 on 22/03/2017.
 */

public class ThumbnailYT {
    /*"thumbnails": {
      (key): {
        "url": string,
        "width": unsigned integer,
        "height": unsigned integer
      }
    }*/

    private MediumThumbnail medium;

    public MediumThumbnail getMedium() {
        return medium;
    }

    public void setMedium(MediumThumbnail medium) {
        this.medium = medium;
    }
}
