package com.pcp.life.mvvm.bean_temp.book;

import java.io.Serializable;

public class ImagesBean implements Serializable {

    private String small;
    private String large;
    private String medium;

    @Override
    public String toString() {
        return "ImagesBean{" +
                "small='" + small + '\'' +
                ", large='" + large + '\'' +
                ", medium='" + medium + '\'' +
                '}';
    }

    public String getSmall() {
        return small;
    }

    public String getLarge() {
        return large;
    }

    public String getMedium() {
        return medium;
    }
}
