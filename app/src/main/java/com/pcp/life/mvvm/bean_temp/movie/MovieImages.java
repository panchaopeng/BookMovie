package com.pcp.life.mvvm.bean_temp.movie;

import java.io.Serializable;

public class MovieImages implements Serializable {

    private String small;
    private String large;
    private String medium;

    public String getSmall() {
        return small;
    }

    public String getLarge() {
        return large;
    }

    public String getMedium() {
        return medium;
    }

    @Override
    public String toString() {
        return "MovieImages{" +
                "small='" + small + '\'' +
                ", large='" + large + '\'' +
                ", medium='" + medium + '\'' +
                '}';
    }
}
