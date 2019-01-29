package com.pcp.life.mvvm.bean.book;

import java.io.Serializable;
import java.util.List;

public class ListBookInfo implements Serializable {

    private int count;
    private int start;
    private int total;
    private List<BookInfo> books;

    public int getCount() {
        return count;
    }

    public int getStart() {
        return start;
    }

    public int getTotal() {
        return total;
    }

    public List<BookInfo> getBooks() {
        return books;
    }

    @Override
    public String toString() {
        return "ListBookInfo{" +
                "count=" + count +
                ", start=" + start +
                ", total=" + total +
                ", books=" + books +
                '}';
    }
}
