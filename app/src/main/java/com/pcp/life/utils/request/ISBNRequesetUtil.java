package com.pcp.life.utils.request;

import android.content.Context;
import android.support.annotation.NonNull;

import com.lzy.okgo.OkGo;
import com.lzy.okgo.model.Response;
import com.pcp.life.callback.IOnISBNListener;
import com.pcp.life.mvvm.bean.book.BookInfo;
import com.pcp.life.net.callback.JsonCallback;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.listener.OnRefreshListener;

import me.goldze.mvvmhabit.utils.ToastUtils;

public class ISBNRequesetUtil {

    private static int start;
    private static int count;
    //private static IOnRefreshListener newItemListener = null;

    //static String baseUrl = "https://api.douban.com/v2/book/search?tag=流行";

    //刷新或第一次请求
    public static void requesetISBN(Context context, String baseUrl,
                                    SmartRefreshLayout refreshLayout,
                                    IOnISBNListener isbnListener) {


        //===下拉刷新或第一次加载页面
        refreshLayout.setOnRefreshListener(new OnRefreshListener() {
            @Override
            public void onRefresh(@NonNull RefreshLayout refresh) {

                OkGo.<BookInfo>get(baseUrl).tag(context).execute(new JsonCallback<BookInfo>() {
                    @Override
                    public void onSuccess(Response<BookInfo> response) {

                        if (isbnListener != null) {
                            //将数据往外抛，让外部处理
                            isbnListener.onSuccessToISBN(response.body());
                            refresh.finishRefresh(100);//传入false表示刷新失败

                        } else {
                            refresh.finishRefresh(false);//结束刷新（刷新失败）
                            ToastUtils.showShort("未查询到数据");
                        }


                    }

                    @Override
                    public void onError(Response<BookInfo> response) {
                        refresh.finishRefresh(false);//结束刷新（刷新失败）
                        RequestErrorUtil.onError(context, response.getException());

                    }
                });


            }
        });

    }

}