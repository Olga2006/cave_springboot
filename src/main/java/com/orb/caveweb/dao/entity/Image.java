package com.orb.caveweb.dao.entity;

import javax.persistence.Column;

public class Image {

    @Column(name = "url")
    private String url;

    public Image() {
    }

    public Image(String url) {
        this.url = url;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
