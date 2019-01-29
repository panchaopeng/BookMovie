package com.pcp.life.mvvm.vm.item_vm.book;

import android.databinding.ObservableField;
import android.os.Bundle;
import android.support.annotation.NonNull;

import com.pcp.life.mvvm.activity.BookDetailActivity;
import com.pcp.life.mvvm.bean.book.BookInfo;
import com.pcp.life.utils.ConstUtil;

import me.goldze.mvvmhabit.base.BaseViewModel;
import me.goldze.mvvmhabit.base.ItemViewModel;
import me.goldze.mvvmhabit.binding.command.BindingAction;
import me.goldze.mvvmhabit.binding.command.BindingCommand;

public class RecycleTopBookItemVM extends ItemViewModel<BaseViewModel> {

    public ObservableField<BookInfo> bookInfo = new ObservableField<>();

    public RecycleTopBookItemVM(@NonNull BaseViewModel viewModel, BookInfo entity) {
        super(viewModel);
        this.bookInfo.set(entity);


    }


    //item点击事件
    public BindingCommand itemClick = new BindingCommand(new BindingAction() {
        @Override
        public void call() {
            //点击弹出当前位置
            //ToastUtils.showShort(viewModel.observableList.indexOf(RecycleBookItemVM.this) + "");

            Bundle bookBundle = new Bundle();
            bookBundle.putSerializable(ConstUtil.BOOKINFO,bookInfo.get());
            //跳转到图书详情页面
            viewModel.startActivity(BookDetailActivity.class,bookBundle);

        }
    });

    //评分 保留一位小数
    public String rating(){

        return bookInfo.get().getRating().getAverage()  + "";

    }






}
