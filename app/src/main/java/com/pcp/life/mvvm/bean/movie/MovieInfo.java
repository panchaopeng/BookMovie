package com.pcp.life.mvvm.bean.movie;

import com.pcp.life.mvvm.bean_temp.movie.Movie;

import java.io.Serializable;
import java.util.List;

public class MovieInfo implements Serializable {

    private int count;
    private int start;
    private int total;
    private List<Movie> subjects;
    private String title;

    public int getCount() {
        return count;
    }

    public int getStart() {
        return start;
    }

    public int getTotal() {
        return total;
    }

    public List<Movie> getSubjects() {
        return subjects;
    }

    public String getTitle() {
        return title;
    }

    @Override
    public String toString() {
        return "MovieInfo{" +
                "count=" + count +
                ", start=" + start +
                ", total=" + total +
                ", subjects=" + subjects +
                ", title='" + title + '\'' +
                '}';
    }
}
