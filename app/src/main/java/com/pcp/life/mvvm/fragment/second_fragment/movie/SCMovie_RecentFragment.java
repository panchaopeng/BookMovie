package com.pcp.life.mvvm.fragment.second_fragment.movie;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.pcp.life.BR;
import com.pcp.life.R;
import com.pcp.life.base.BaseLazyFragment;
import com.pcp.life.databinding.SecondMovieRecentBinding;
import com.pcp.life.mvvm.vm.second_vm.movie.SCMovie_RecentViewModel;

public class SCMovie_RecentFragment extends BaseLazyFragment<SecondMovieRecentBinding,SCMovie_RecentViewModel> {

    public static String TAG = "lazy";

    @Override
    public int initContentView(LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        return R.layout.second_movie_recent;
    }

    @Override
    public int initVariableId() {
        return BR.recentMovieVM;
    }

    @Override
    public void lazyLoadData() {
        Log.d(TAG, "Popular: ");
        Log.d("checkpcp", "Popular: ");
        //第一次请求网络数据,同时监听下拉刷新
        viewModel.requestRecentMovie(binding.recentMovieRefresh);
        //监听下拉加载
        viewModel.recentMovieLoadMore(binding.recentMovieRefresh,binding.recentMovieRecycle);

    }

}
