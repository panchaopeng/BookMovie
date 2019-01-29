package com.pcp.life.mvvm.fragment.second_fragment.book;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.pcp.life.BR;
import com.pcp.life.R;
import com.pcp.life.base.BaseLazyFragment;
import com.pcp.life.databinding.FragmentBookCultureBinding;
import com.pcp.life.mvvm.vm.second_vm.book.SCBook_CultureViewModel;


public class SCBook_CultureFragment extends BaseLazyFragment<FragmentBookCultureBinding,SCBook_CultureViewModel> {

    public static String TAG = "lazy";

    @Override
    public int initContentView(LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        return R.layout.fragment_book_culture;
    }

    @Override
    public int initVariableId() {
        return BR.cultureBookViewModel;
    }

    @Override
    public void lazyLoadData() {
        Log.d(TAG, "Culture: ");
        Log.d("checkpcp", "Culture: ");

        //第一次请求网络数据,同时监听下拉刷新
        viewModel.requestNetWork(binding.cultureRefreshLayout,binding.cultureRecycle);
        //监听下拉加载
        viewModel.loadMore(binding.cultureRefreshLayout,binding.cultureRecycle);
    }


}
