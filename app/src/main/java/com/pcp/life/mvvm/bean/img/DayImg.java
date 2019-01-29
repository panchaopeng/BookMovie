package com.pcp.life.mvvm.bean.img;

import com.pcp.life.mvvm.bean_temp.img.DayImages;
import com.pcp.life.mvvm.bean_temp.img.Tooltips;

import java.io.Serializable;
import java.util.List;

public class DayImg implements Serializable {

    private List<DayImages> images;
    private Tooltips tooltips;

    public List<DayImages> getImages() {
        return images;
    }

    public Tooltips getTooltips() {
        return tooltips;
    }

    @Override
    public String toString() {
        return "DayImg{" +
                "images=" + images +
                ", tooltips=" + tooltips +
                '}';
    }
}
