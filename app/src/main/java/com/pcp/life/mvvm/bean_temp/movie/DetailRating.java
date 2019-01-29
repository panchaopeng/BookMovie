package com.pcp.life.mvvm.bean_temp.movie;

import java.io.Serializable;

public class DetailRating implements Serializable {

    private int max;
    private float average;
    private String stars;
    private int min;

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

    @Override
    public String toString() {
        return "DetailRating{" +
                "max=" + max +
                ", average=" + average +
                ", stars='" + stars + '\'' +
                ", min=" + min +
                '}';
    }
}
