package com.pcp.life.mvvm.bean_temp.book;

import java.io.Serializable;

public class TagsBean implements Serializable {

    private int count;
    private String name;
    private String title;

    @Override
    public String toString() {
        return "TagsBean{" +
                "count=" + count +
                ", name='" + name + '\'' +
                ", title='" + title + '\'' +
                '}';
    }

    public int getCount() {
        return count;
    }

    public String getName() {
        return name;
    }

    public String getTitle() {
        return title;
    }
}
