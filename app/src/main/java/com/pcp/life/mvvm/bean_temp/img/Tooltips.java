package com.pcp.life.mvvm.bean_temp.img;

public class Tooltips {

    private String loading;
    private String previous;
    private String next;
    private String walle;
    private String walls;

    public String getLoading() {
        return loading;
    }

    public String getPrevious() {
        return previous;
    }

    public String getNext() {
        return next;
    }

    public String getWalle() {
        return walle;
    }

    public String getWalls() {
        return walls;
    }

    @Override
    public String toString() {
        return "Tooltips{" +
                "loading='" + loading + '\'' +
                ", previous='" + previous + '\'' +
                ", next='" + next + '\'' +
                ", walle='" + walle + '\'' +
                ", walls='" + walls + '\'' +
                '}';
    }
}
