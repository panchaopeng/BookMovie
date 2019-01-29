package com.pcp.life.mvvm.bean.movie;

import com.pcp.life.mvvm.bean_temp.movie.DetailCasts;
import com.pcp.life.mvvm.bean_temp.movie.DetailDirectors;
import com.pcp.life.mvvm.bean_temp.movie.DetailImages;
import com.pcp.life.mvvm.bean_temp.movie.DetailRating;

import java.io.Serializable;
import java.util.List;

public class MovieDetail implements Serializable {

    private DetailRating rating;
    private double reviews_count;
    private double wish_count;
    private String douban_site;
    private String year;
    private DetailImages images;
    private String alt;
    private String id;
    private String mobile_url;
    private String title;
    private double do_count;
    private String share_url;
    private double seasons_count;
    private String schedule_url;
    private double episodes_count;
    private List<String> countries;
    private List<String> genres;
    private double collect_count;
    private List<DetailCasts> casts;
    private String current_season;
    private String original_title;
    private String summary;
    private String subtype;
    private List<DetailDirectors> directors;
    private double comments_count;
    private double ratings_count;
    private List<String> aka;

    @Override
    public String toString() {
        return "MovieDetail{" +
                "rating=" + rating +
                ", reviews_count=" + reviews_count +
                ", wish_count=" + wish_count +
                ", douban_site='" + douban_site + '\'' +
                ", year='" + year + '\'' +
                ", images=" + images +
                ", alt='" + alt + '\'' +
                ", id='" + id + '\'' +
                ", mobile_url='" + mobile_url + '\'' +
                ", title='" + title + '\'' +
                ", do_count=" + do_count +
                ", share_url='" + share_url + '\'' +
                ", seasons_count=" + seasons_count +
                ", schedule_url='" + schedule_url + '\'' +
                ", episodes_count=" + episodes_count +
                ", countries=" + countries +
                ", genres=" + genres +
                ", collect_count=" + collect_count +
                ", casts=" + casts +
                ", current_season='" + current_season + '\'' +
                ", original_title='" + original_title + '\'' +
                ", summary='" + summary + '\'' +
                ", subtype='" + subtype + '\'' +
                ", directors=" + directors +
                ", comments_count=" + comments_count +
                ", ratings_count=" + ratings_count +
                ", aka=" + aka +
                '}';
    }

    public DetailRating getRating() {
        return rating;
    }

    public double getReviews_count() {
        return reviews_count;
    }

    public double getWish_count() {
        return wish_count;
    }

    public String getDouban_site() {
        return douban_site;
    }

    public String getYear() {
        return year;
    }

    public DetailImages getImages() {
        return images;
    }

    public String getAlt() {
        return alt;
    }

    public String getId() {
        return id;
    }

    public String getMobile_url() {
        return mobile_url;
    }

    public String getTitle() {
        return title;
    }

    public double getDo_count() {
        return do_count;
    }

    public String getShare_url() {
        return share_url;
    }

    public double getSeasons_count() {
        return seasons_count;
    }

    public String getSchedule_url() {
        return schedule_url;
    }

    public double getEpisodes_count() {
        return episodes_count;
    }

    public List<String> getCountries() {
        return countries;
    }

    public List<String> getGenres() {
        return genres;
    }

    public double getCollect_count() {
        return collect_count;
    }

    public List<DetailCasts> getCasts() {
        return casts;
    }

    public String getCurrent_season() {
        return current_season;
    }

    public String getOriginal_title() {
        return original_title;
    }

    public String getSummary() {
        return summary;
    }

    public String getSubtype() {
        return subtype;
    }

    public List<DetailDirectors> getDirectors() {
        return directors;
    }

    public double getComments_count() {
        return comments_count;
    }

    public double getRatings_count() {
        return ratings_count;
    }

    public List<String> getAka() {
        return aka;
    }
}
