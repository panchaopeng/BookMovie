package com.pcp.life.utils.request;

import android.content.Context;
import android.support.annotation.NonNull;

import com.lzy.okgo.OkGo;
import com.lzy.okgo.model.Response;
import com.pcp.life.callback.IOnLoadMoreListener;
import com.pcp.life.callback.IOnRefreshListener;
import com.pcp.life.mvvm.bean.movie.MovieInfo;
import com.pcp.life.net.callback.JsonCallback;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.listener.OnLoadMoreListener;
import com.scwang.smartrefresh.layout.listener.OnRefreshListener;

import me.goldze.mvvmhabit.utils.ToastUtils;

public class Movie_Refresh_LoadMoreUtil {

    private static int start;
    private static int count;
    //private static IOnRefreshListener newItemListener = null;

    //static String baseUrl = "https://api.douban.com/v2/book/search?tag=流行";

    //刷新或第一次请求
    public static void refresh_or_firstRequest(Context context, String baseUrl, int custom_count,
                                               int custom_start,
                                               SmartRefreshLayout refreshLayout,
                                               IOnRefreshListener refreshListener) {


        //===下拉刷新或第一次加载页面
        refreshLayout.setOnRefreshListener(new OnRefreshListener() {
            @Override
            public void onRefresh(@NonNull RefreshLayout refresh) {


                //每页的数据
                count = custom_count;
                //当前第几页
                start = custom_start;
                //refresh_url = baseUrl + "&&start=" + start + "&&count=" + count;


                OkGo.<MovieInfo>get(baseUrl + "&start=" + start + "&count=" + count).tag(context).execute(new JsonCallback<MovieInfo>() {
                    @Override
                    public void onSuccess(Response<MovieInfo> response) {

                        if (response.body().getSubjects().size() > 0 && refreshListener != null) {
                            //将数据往外抛，让外部处理
                            refreshListener.onSuccessToRefresh(response.body().getSubjects());
                            refresh.finishRefresh(100);//传入false表示刷新失败

                        } else {
                            refresh.finishRefresh(false);//结束刷新（刷新失败）
                            ToastUtils.showShort("没有更多数据");
                        }


                    }

                    @Override
                    public void onError(Response<MovieInfo> response) {
                        refresh.finishRefresh(false);//结束刷新（刷新失败）
                        RequestErrorUtil.onError(context, response.getException());

                    }
                });


            }
        });

    }

    //下拉
    public static void loadMore(Context context, String baseUrl, int custom_count,
                                SmartRefreshLayout refreshLayout,
                                IOnLoadMoreListener loadMoreListener) {


        //===上拉加载
        refreshLayout.setOnLoadMoreListener(new OnLoadMoreListener() {
            @Override
            public void onLoadMore(RefreshLayout loadMore) {


                //每页的数据
                //count = 20;
                //当前第几页
                start = start + custom_count;
                //loadMore_url = baseUrl + "&&start=" + start + "&&count=" + count;

                OkGo.<MovieInfo>get(baseUrl + "&start=" + start + "&count=" + count).tag(context).execute(new JsonCallback<MovieInfo>() {
                    @Override
                    public void onSuccess(Response<MovieInfo> response) {
                        if (response.body().getSubjects().size() > 0 && loadMoreListener != null) {
                            //将数据往外抛，让外部处理
                            loadMoreListener.onSuccessToLoadMore(response.body().getSubjects());
                            loadMore.finishLoadMore(100);//传入false表示刷新失败


                        } else {
                            loadMore.finishLoadMore(false);//结束刷新（刷新失败）
                            ToastUtils.showShort("没有更多数据");
                        }
                    }

                    @Override
                    public void onError(Response<MovieInfo> response) {
                        loadMore.finishLoadMore(false); //结束加载（加载失败）
                        RequestErrorUtil.onError(context,response.getException());

                    }
                });


            }
        });


    }

}
