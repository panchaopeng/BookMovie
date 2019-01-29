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
import com.pcp.life.databinding.FragmentBookBinding;
import com.pcp.life.mvvm.vm.FBookViewModel;

public class BookFragment extends BaseLazyFragment<FragmentBookBinding, FBookViewModel> {

    private static final String TAG = "BookFragment";

    private BasePagerAdapter mAdapter;

    @Override
    public int initContentView(LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        return R.layout.fragment_book;
    }

    @Override
    public int initVariableId() {

        return BR.fBook;
    }



    @Override
    public void initData() {
        setTabLayout();
        Log.d("checkpcp", "BookFragment: ");

    }

    @Override
    public void lazyLoadData() {

    }

    private void setTabLayout() {


        //添加Fragment到MyPagerAdapter
//        mFragments.add(viewModel.popularFragment.getValue());
//        mFragments.add(viewModel.cultureFragment.getValue());
//        mFragments.add(viewModel.lifeFragment.getValue());


        //======设置Adapter
        //getFragmentManager()所得到的是在Activity里fragment的父容器的管理器，
        //getChildFragmentManager()所得到的是在fragment里子fragment的父容器的管理器。
        mAdapter = new BasePagerAdapter(getChildFragmentManager(),
                viewModel.mFragments.get(),
                viewModel.mTitles.get());
        binding.bookViewPager.setAdapter(mAdapter);
        //设置当前Fragment
        binding.bookViewPager.setCurrentItem(0);
        //设置ViewPager
        binding.bookSlidingTabLayout.setViewPager(binding.bookViewPager);


        //监听选择事件
        binding.bookSlidingTabLayout.setOnTabSelectListener(new OnTabSelectListener() {
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
