package com.pcp.life.mvvm.bean.movie;

import java.io.Serializable;

public class MovieItem implements Serializable {
    private String url;
    private String name;

    public MovieItem(String url, String name) {
        this.url = url;
        this.name = name;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
