package com.pcp.life.mvvm.activity;

import android.databinding.Observable;
import android.os.Bundle;

import com.lzy.okgo.OkGo;
import com.lzy.okgo.model.Response;
import com.pcp.life.BR;
import com.pcp.life.R;
import com.pcp.life.databinding.ActivityMovieDetailBinding;
import com.pcp.life.mvvm.bean.movie.MovieDetail;
import com.pcp.life.mvvm.vm.activity_vm.MovieDetailViewModel;
import com.pcp.life.net.callback.DialogCallback;
import com.pcp.life.utils.ConstUtil;
import com.pcp.life.utils.request.RequestErrorUtil;

import me.goldze.mvvmhabit.base.BaseActivity;

public class MovieDetailActivity extends BaseActivity<ActivityMovieDetailBinding,MovieDetailViewModel> {


    @Override
    public int initContentView(Bundle bundle) {
        return R.layout.activity_movie_detail;
    }

    @Override
    public int initVariableId() {
        return BR.movieDetailVM;
    }

    @Override
    public void initData() {
        viewModel.movie_id.set(getIntent().getStringExtra(ConstUtil.MOVIE_ID));

        //根据电影Id来获取详细的电影信息
        OkGo.<MovieDetail>get(viewModel.searchMovieUrl.get() + viewModel.movie_id.get())
                .tag(this)
                .execute(new DialogCallback<MovieDetail>(this) {
                    @Override
                    public void onSuccess(Response<MovieDetail> response) {
                        viewModel.movieDetail.set(response.body());

                    }

                    @Override
                    public void onError(Response<MovieDetail> response) {
                        RequestErrorUtil.onError(MovieDetailActivity.this, response.getException());
                    }
                });

    }

    @Override
    public void initViewObservable() {
        viewModel.movieDetail.addOnPropertyChangedCallback(new Observable.OnPropertyChangedCallback() {
            @Override
            public void onPropertyChanged(Observable sender, int propertyId) {
                //设置导演以及主演信息
                viewModel.setDirectors();
            }
        });
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        OkGo.getInstance().cancelTag(this);
    }
}
