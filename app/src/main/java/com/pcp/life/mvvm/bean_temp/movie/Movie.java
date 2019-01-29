package com.pcp.life.mvvm.bean_temp.movie;

import java.io.Serializable;
import java.util.List;

public class Movie implements Serializable {

    private MovieRating rating;
    private List<String> genres;
    private String title;
    private List<MovieCasts> casts;
    private double collect_count;
    private String original_title;
    private String subtype;
    private List<MovieDirectors> directors;
    private String year;
    private MovieImages images;
    private String alt;
    private String id;

    @Override
    public String toString() {
        return "Movie{" +
                "rating=" + rating +
                ", genres=" + genres +
                ", title='" + title + '\'' +
                ", casts=" + casts +
                ", collect_count=" + collect_count +
                ", original_title='" + original_title + '\'' +
                ", subtype='" + subtype + '\'' +
                ", directors=" + directors +
                ", year='" + year + '\'' +
                ", images=" + images +
                ", alt='" + alt + '\'' +
                ", id='" + id + '\'' +
                '}';
    }

    public MovieRating getRating() {
        return rating;
    }

    public List<String> getGenres() {
        return genres;
    }

    public String getTitle() {
        return title;
    }

    public List<MovieCasts> getCasts() {
        return casts;
    }

    public double getCollect_count() {
        return collect_count;
    }

    public String getOriginal_title() {
        return original_title;
    }

    public String getSubtype() {
        return subtype;
    }

    public List<MovieDirectors> getDirectors() {
        return directors;
    }

    public String getYear() {
        return year;
    }

    public MovieImages getImages() {
        return images;
    }

    public String getAlt() {
        return alt;
    }

    public String getId() {
        return id;
    }
}
