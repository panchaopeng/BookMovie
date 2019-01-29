package com.pcp.life.mvvm.bean_temp.movie;

import java.io.Serializable;

public class MovieRating implements Serializable {

    private int max;
    private float average;
    private String stars;
    private int min;

    @Override
    public String toString() {
        return "MovieRating{" +
                "max=" + max +
                ", average=" + average +
                ", stars='" + stars + '\'' +
                ", min=" + min +
                '}';
    }

    public int getMax() {
        return max;
    }

    public float getAverage() {
        return average;
    }

    public String getStars() {
        return stars;
    }

    public int getMin() {
        return min;
    }
}
