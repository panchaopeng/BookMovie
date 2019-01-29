package com.pcp.life.mvvm.bean_temp.img;

import java.util.List;

public class DayImages {

    private String startdate;
    private String fullstartdate;
    private String enddate;
    private String url;
    private String urlbase;
    private String copyright;
    private String copyrightlink;
    private String title;
    private String quiz;
    private boolean wp;
    private String hsh;
    private int drk;
    private int top;
    private int bot;
    private List<?> hs;

    public String getStartdate() {
        return startdate;
    }

    public String getFullstartdate() {
        return fullstartdate;
    }

    public String getEnddate() {
        return enddate;
    }

    public String getUrl() {
        return url;
    }

    public String getUrlbase() {
        return urlbase;
    }

    public String getCopyright() {
        return copyright;
    }

    public String getCopyrightlink() {
        return copyrightlink;
    }

    public String getTitle() {
        return title;
    }

    public String getQuiz() {
        return quiz;
    }

    public boolean isWp() {
        return wp;
    }

    public String getHsh() {
        return hsh;
    }

    public int getDrk() {
        return drk;
    }

    public int getTop() {
        return top;
    }

    public int getBot() {
        return bot;
    }

    public List<?> getHs() {
        return hs;
    }

    @Override
    public String toString() {
        return "DayImages{" +
                "startdate='" + startdate + '\'' +
                ", fullstartdate='" + fullstartdate + '\'' +
                ", enddate='" + enddate + '\'' +
                ", url='" + url + '\'' +
                ", urlbase='" + urlbase + '\'' +
                ", copyright='" + copyright + '\'' +
                ", copyrightlink='" + copyrightlink + '\'' +
                ", title='" + title + '\'' +
                ", quiz='" + quiz + '\'' +
                ", wp=" + wp +
                ", hsh='" + hsh + '\'' +
                ", drk=" + drk +
                ", top=" + top +
                ", bot=" + bot +
                ", hs=" + hs +
                '}';
    }
}
