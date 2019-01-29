package com.pcp.life.mvvm.bean.book;

import com.pcp.life.mvvm.bean_temp.book.ImagesBean;
import com.pcp.life.mvvm.bean_temp.book.RatingBean;
import com.pcp.life.mvvm.bean_temp.book.TagsBean;

import java.io.Serializable;
import java.util.List;

public class BookInfo implements Serializable {


    private RatingBean rating;
    private String subtitle;
    private String pubdate;
    private String origin_title;
    private String image;
    private String binding;
    private String catalog;
    private String pages;
    private ImagesBean images;
    private String alt;
    private String id;
    private String publisher;
    private String isbn10;
    private String isbn13;
    private String title;
    private String url;
    private String alt_title;
    private String author_intro;
    private String summary;
    private String price;
    private List<String> author;
    private List<TagsBean> tags;
    private List<String> translator;

    @Override
    public String toString() {
        return "BookInfo{" +
                "rating=" + rating +
                ", subtitle='" + subtitle + '\'' +
                ", pubdate='" + pubdate + '\'' +
                ", origin_title='" + origin_title + '\'' +
                ", image='" + image + '\'' +
                ", binding='" + binding + '\'' +
                ", catalog='" + catalog + '\'' +
                ", pages='" + pages + '\'' +
                ", images=" + images +
                ", alt='" + alt + '\'' +
                ", id='" + id + '\'' +
                ", publisher='" + publisher + '\'' +
                ", isbn10='" + isbn10 + '\'' +
                ", isbn13='" + isbn13 + '\'' +
                ", title='" + title + '\'' +
                ", url='" + url + '\'' +
                ", alt_title='" + alt_title + '\'' +
                ", author_intro='" + author_intro + '\'' +
                ", summary='" + summary + '\'' +
                ", price='" + price + '\'' +
                ", author=" + author +
                ", tags=" + tags +
                ", translator=" + translator +
                '}';
    }

    public RatingBean getRating() {
        return rating;
    }

    public String getSubtitle() {
        return subtitle;
    }

    public String getPubdate() {
        return pubdate;
    }

    public String getOrigin_title() {
        return origin_title;
    }

    public String getImage() {
        return image;
    }

    public String getBinding() {
        return binding;
    }

    public String getCatalog() {
        return catalog;
    }

    public String getPages() {
        return pages;
    }

    public ImagesBean getImages() {
        return images;
    }

    public String getAlt() {
        return alt;
    }

    public String getId() {
        return id;
    }

    public String getPublisher() {
        return publisher;
    }

    public String getIsbn10() {
        return isbn10;
    }

    public String getIsbn13() {
        return isbn13;
    }

    public String getTitle() {
        return title;
    }

    public String getUrl() {
        return url;
    }

    public String getAlt_title() {
        return alt_title;
    }

    public String getAuthor_intro() {
        return author_intro;
    }

    public String getSummary() {
        return summary;
    }

    public String getPrice() {
        return price;
    }

    public List<String> getAuthor() {
        return author;
    }

    public List<TagsBean> getTags() {
        return tags;
    }

    public List<String> getTranslator() {
        return translator;
    }
}
