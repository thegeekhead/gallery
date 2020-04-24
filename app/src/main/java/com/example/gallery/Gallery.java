package com.example.gallery;

public class Gallery {
    private String mUrl_s;
    private String mTitle;

    public Gallery(String title,  String url_s) {
        this.mTitle=title;
        this.mUrl_s=url_s;
    }

    public String getTitle() {
        return mTitle;
    }

    public String getUrl_s() {
        return mUrl_s;
    }


}
