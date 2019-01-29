package com.pcp.life.mvvm.fragment.second_fragment.movie;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.pcp.life.BR;
import com.pcp.life.R;
import com.pcp.life.base.BaseLazyFragment;
import com.pcp.life.databinding.SecondMovieTopBinding;
import com.pcp.life.mvvm.vm.second_vm.movie.SCMovie_TopViewModel;

public class SCMovie_TopFragment extends BaseLazyFragment<SecondMovieTopBinding,SCMovie_TopViewModel> {

    public static String TAG = "lazy";

    @Override
    public int initContentView(LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        return R.layout.second_movie_top;
    }

    @Override
    public int initVariableId() {
        return BR.topMoveVM;
    }



    @Override
    public void lazyLoadData() {
        Log.d(TAG, "Popular: ");
        Log.d("checkpcp", "Popular: ");
        //第一次请求网络数据,同时监听下拉刷新
        viewModel.requestNetWork(binding.topMovieRefresh);
        //监听下拉加载
        viewModel.loadMore(binding.topMovieRefresh,binding.topMovieRecycle);

    }



}
