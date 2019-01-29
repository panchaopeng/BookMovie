package com.pcp.life.mvvm.vm.activity_vm;

import android.app.Application;
import android.databinding.ObservableField;
import android.support.annotation.NonNull;

import com.pcp.life.mvvm.bean.book.BookInfo;
import com.pcp.life.utils.BookDetailUtil;

import me.goldze.mvvmhabit.base.BaseViewModel;
import me.goldze.mvvmhabit.binding.command.BindingAction;
import me.goldze.mvvmhabit.binding.command.BindingCommand;

public class BookDetailViewModel extends BaseViewModel {

    public ObservableField<BookInfo> bookInfo = new ObservableField<>();
    public static String isbnSearchUrl = "https://api.douban.com/v2/book/isbn/";

    public BookDetailViewModel(@NonNull Application application) {
        super(application);

    }

    //后退
    public BindingCommand backCommand = new BindingCommand(new BindingAction() {
        @Override
        public void call() {
            finish();
        }
    });

    //作者列表
    public String authorList(){

        return BookDetailUtil.formatListToString(bookInfo.get().getAuthor());
    }



    //译者列表
    public String translatorList(){

        return BookDetailUtil.formatListToString(bookInfo.get().getTranslator());
    }

    //作者简介
    public String authorContent(){

        return BookDetailUtil.setContent(bookInfo.get().getAuthor_intro());
    }

    //内容简介
    public String mainContent(){

        return BookDetailUtil.setContent(bookInfo.get().getSummary());
    }

    //目录简介
    public String categoryContent(){

        return  BookDetailUtil.setContent(bookInfo.get().getCatalog());
    }



}
