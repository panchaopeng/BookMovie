package com.pcp.life.mvvm.vm.item_vm.movie;

import android.databinding.ObservableField;
import android.os.Bundle;
import android.support.annotation.NonNull;

import com.pcp.life.mvvm.activity.MovieDetailActivity;
import com.pcp.life.mvvm.bean_temp.movie.Movie;
import com.pcp.life.utils.BookDetailUtil;
import com.pcp.life.utils.ConstUtil;

import me.goldze.mvvmhabit.base.BaseViewModel;
import me.goldze.mvvmhabit.base.ItemViewModel;
import me.goldze.mvvmhabit.binding.command.BindingAction;
import me.goldze.mvvmhabit.binding.command.BindingCommand;
import me.goldze.mvvmhabit.utils.ToastUtils;

public class RecycleRecentMovieItemVM extends ItemViewModel<BaseViewModel> {

    public ObservableField<Movie> movie = new ObservableField<>();

    public RecycleRecentMovieItemVM(@NonNull BaseViewModel viewModel, Movie entity) {
        super(viewModel);
        this.movie.set(entity);


    }

    //评分
    public float rating(){

        return movie.get().getRating().getAverage() / 2;
    }

    //电影类型 / 年份
    public String introduce(){

        return BookDetailUtil.formatListToString(movie.get().getGenres()) + " / " + movie.get().getYear();
    }



    //item点击事件
    public BindingCommand itemClick = new BindingCommand(new BindingAction() {
        @Override
        public void call() {
            //点击弹出当前位置
            //ToastUtils.showShort(viewModel.observableList.indexOf(RecycleRecentMovieItemVM.this) + "");

            if (movie.get().getId().length() > 0 ){

                Bundle movieBundle = new Bundle();
                movieBundle.putSerializable(ConstUtil.MOVIE_ID,movie.get().getId());
                //跳转到图书详情页面
                viewModel.startActivity(MovieDetailActivity.class,movieBundle);

            }else {
                ToastUtils.showShort("该电影缺失记录");
            }

        }
    });








}
