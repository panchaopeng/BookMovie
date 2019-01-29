package com.pcp.life.binding;

import android.databinding.BindingAdapter;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.pcp.life.application.MyApplication;

import me.goldze.mvvmhabit.base.AppManager;

public class ImgBindingAdapter {

    @BindingAdapter(value = {"urlCustom"}, requireAll = false)
    public static void setImageUri(ImageView imageView, String url) {

        if (imageView.getContext() != null){
            //使用Glide框架加载图片
            //如果不使用Activity的getApplicationContext，旋转时会报错
            //理由：Glide是在子线程加载图片的，当Activity销毁时，Glide却还在加载。
            // 我们把加载图片的周期延长到APP的生命周期就不会报错了，
            Glide.with(AppManager.getAppManager().currentActivity().getApplicationContext())
                    .load(url)
                    .apply(MyApplication.getGlideOptions())
                    .into(imageView);


        }


    }
}
