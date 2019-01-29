package com.pcp.life.mvvm.fragment.second_fragment.book;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.pcp.life.BR;
import com.pcp.life.R;
import com.pcp.life.base.BaseLazyFragment;
import com.pcp.life.databinding.FragmentBookLifeBinding;
import com.pcp.life.mvvm.vm.second_vm.book.SCBook_LifeViewModel;

public class SCBook_LifeFragment extends BaseLazyFragment<FragmentBookLifeBinding,SCBook_LifeViewModel> {

    public static String TAG = "lazy";

    @Override
    public int initContentView(LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        return R.layout.fragment_book_life;
    }

    @Override
    public int initVariableId() {
        return BR.lifeBookViewModel;
    }

    @Override
    public void lazyLoadData() {
        Log.d(TAG, "Life: ");
        Log.d("checkpcp", "Life: ");

        //第一次请求网络数据,同时监听下拉刷新
        viewModel.requestNetWork(binding.lifeRefreshLayout,binding.lifeRecycle);
        //监听下拉加载
        viewModel.loadMore(binding.lifeRefreshLayout,binding.lifeRecycle);
    }


}
