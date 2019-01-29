package com.pcp.life.mvvm.bean_temp.book;

import java.io.Serializable;

public class RatingBean implements Serializable {

    private int max;
    private int numRaters;
    private float average;
    private int min;

    @Override
    public String toString() {
        return "RatingBean{" +
                "max=" + max +
                ", numRaters=" + numRaters +
                ", average=" + average +
                ", min=" + min +
                '}';
    }

    public int getMax() {
        return max;
    }

    public int getNumRaters() {
        return numRaters;
    }

    public float getAverage() {
        return average;
    }

    public int getMin() {
        return min;
    }
}
