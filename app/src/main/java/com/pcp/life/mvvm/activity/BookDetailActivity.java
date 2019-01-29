package com.pcp.life.mvvm.activity;

import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;

import com.pcp.life.BR;
import com.pcp.life.R;
import com.pcp.life.databinding.ActivityBookDetailBinding;
import com.pcp.life.mvvm.bean.book.BookInfo;
import com.pcp.life.mvvm.vm.activity_vm.BookDetailViewModel;
import com.pcp.life.utils.ConstUtil;

import me.goldze.mvvmhabit.base.BaseActivity;

public class BookDetailActivity extends BaseActivity<ActivityBookDetailBinding, BookDetailViewModel> {

    @Override
    public int initContentView(Bundle bundle) {
        return R.layout.activity_book_detail;
    }

    @Override
    public int initVariableId() {
        return BR.bookDetailVM;
    }

    @Override
    public void initData() {

        viewModel.bookInfo.set((BookInfo) getIntent().getSerializableExtra(ConstUtil.BOOKINFO));


    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK) {
            finish();
            Log.d("finish", "onKeyDown: ");
        }
        return super.onKeyDown(keyCode, event);
    }
}
