package com.pcp.life.mvvm.bean_temp.movie;

import java.io.Serializable;

public class DetailImages implements Serializable {

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
        return "DetailImages{" +
                "small='" + small + '\'' +
                ", large='" + large + '\'' +
                ", medium='" + medium + '\'' +
                '}';
    }
}
