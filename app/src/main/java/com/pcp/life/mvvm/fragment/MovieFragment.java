package com.pcp.life.mvvm.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.flyco.tablayout.listener.OnTabSelectListener;
import com.pcp.life.BR;
import com.pcp.life.R;
import com.pcp.life.adpter.BasePagerAdapter;
import com.pcp.life.base.BaseLazyFragment;
import com.pcp.life.databinding.FragmentMovieBinding;
import com.pcp.life.mvvm.vm.FMovieViewModel;

public class MovieFragment extends BaseLazyFragment<FragmentMovieBinding, FMovieViewModel> {


    private static final String TAG = "MovieFragment";

    private BasePagerAdapter mAdapter;


    @Override
    public int initContentView(LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        return R.layout.fragment_movie;
    }

    @Override
    public int initVariableId() {
        return BR.fMovie;
    }


    @Override
    public void initData() {
        setTabLayout();

        Log.d("checkpcp", "MovieFragment: ");
    }

    @Override
    public void lazyLoadData() {

    }

    private void setTabLayout() {

        //======设置Adapter
        //getFragmentManager()所得到的是在Activity里fragment的父容器的管理器，
        //getChildFragmentManager()所得到的是在fragment里子fragment的父容器的管理器。
        mAdapter = new BasePagerAdapter(getChildFragmentManager(),
                viewModel.mFragments.get(),
                viewModel.mTitles.get());

        binding.movieViewPager.setAdapter(mAdapter);
        //设置当前Fragment
        binding.movieViewPager.setCurrentItem(0);
        //设置ViewPager
        binding.movieSlidingTabLayout.setViewPager(binding.movieViewPager);


        //监听选择事件
        binding.movieSlidingTabLayout.setOnTabSelectListener(new OnTabSelectListener() {
            @Override
            public void onTabSelect(int position) {
                Log.d(TAG, "onTabSelect: " + position);

            }

            @Override
            public void onTabReselect(int position) {
                Log.d(TAG, "onTabReselect: " + position);

            }

        });

    }



}
