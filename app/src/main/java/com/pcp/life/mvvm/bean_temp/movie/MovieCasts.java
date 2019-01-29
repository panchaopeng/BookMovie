package com.pcp.life.mvvm.bean_temp.movie;

import java.io.Serializable;

public class MovieCasts implements Serializable {

    private String alt;
    private MovieImages avatars;
    private String name;
    private String id;

    public String getAlt() {
        return alt;
    }

    public MovieImages getAvatars() {
        return avatars;
    }

    public String getName() {
        return name;
    }

    public String getId() {
        return id;
    }

    @Override
    public String toString() {
        return "MovieCasts{" +
                "alt='" + alt + '\'' +
                ", avatars=" + avatars +
                ", name='" + name + '\'' +
                ", id='" + id + '\'' +
                '}';
    }
}
