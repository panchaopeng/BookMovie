package com.pcp.life.mvvm.vm.activity_vm;

import android.app.Application;
import android.databinding.ObservableArrayList;
import android.databinding.ObservableField;
import android.databinding.ObservableList;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;

import com.pcp.life.BR;
import com.pcp.life.R;
import com.pcp.life.callback.IOnISBNListener;
import com.pcp.life.callback.IOnLoadMoreListener;
import com.pcp.life.callback.IOnRefreshListener;
import com.pcp.life.mvvm.activity.BookDetailActivity;
import com.pcp.life.mvvm.bean.book.BookInfo;
import com.pcp.life.mvvm.vm.item_vm.book.RecycleBookItemVM;
import com.pcp.life.utils.ConstUtil;
import com.pcp.life.utils.request.Book_Refresh_LoadMoreUtil;
import com.pcp.life.utils.request.ISBNRequesetUtil;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;

import java.util.List;

import me.goldze.mvvmhabit.base.AppManager;
import me.goldze.mvvmhabit.base.BaseViewModel;
import me.tatarka.bindingcollectionadapter2.BindingRecyclerViewAdapter;
import me.tatarka.bindingcollectionadapter2.ItemBinding;

public class SearchViewModel extends BaseViewModel {

    public SearchViewModel(@NonNull Application application) {
        super(application);

    }


    public static String isbnSearchUrl = "https://api.douban.com/v2/book/isbn/";
    public static String searWordUrl = "https://api.douban.com/v2/book/search?q=";
    //每页的数据
    public ObservableField<Integer> count = new ObservableField<>(20);
    //当前第几页
    public ObservableField<Integer> start = new ObservableField<>(0);

    //给RecyclerView添加ObservableList
    public ObservableList<RecycleBookItemVM> observableList = new ObservableArrayList<>();
    //给RecyclerView添加ItemBinding
    public ItemBinding<RecycleBookItemVM> itemBinding = ItemBinding.of(BR.popularItem, R.layout.recycle_book_popular);
    //给RecyclerView添加Adpter，请使用自定义的Adapter继承BindingRecyclerViewAdapter，重写onBindBinding方法
    public final BindingRecyclerViewAdapter<RecycleBookItemVM> adapter = new BindingRecyclerViewAdapter<>();


    //关键字查询图书
    public void getListBook(SmartRefreshLayout smartRefreshLayout, RecyclerView recyclerView,String query) {

        //第一次请求数据，同时开启自动下拉刷新
        smartRefreshLayout.autoRefresh();
        Book_Refresh_LoadMoreUtil.refresh_or_firstRequest(AppManager.getAppManager().currentActivity(),
                searWordUrl + query, count.get(), start.get(),
                smartRefreshLayout,
                new IOnRefreshListener<List<BookInfo>>() {
                    @Override
                    public void onSuccessToRefresh(List<BookInfo> bookInfo) {

                        //清除列表
                        observableList.clear();
                        //将实体赋给observableList
                        setBookInfo(bookInfo);

                    }
                });

        //上拉加载
        Book_Refresh_LoadMoreUtil.loadMore(AppManager.getAppManager().currentActivity(),
                searWordUrl + query, count.get(),
                smartRefreshLayout,
                new IOnLoadMoreListener<List<BookInfo>>() {
                    @Override
                    public void onSuccessToLoadMore(List<BookInfo> bookInfo) {
                        //记录当前数据总数，用来notify
                        int size = observableList.size();
                        //将实体赋给observableList
                        setBookInfo(bookInfo);
                        //通知数据改变
                        recyclerView.getAdapter().notifyItemRangeChanged(size,observableList.size());
                        //滑动到下拉刷新完成时的第一条数据
                        recyclerView.smoothScrollToPosition(size);
                    }
                });


    }

    //ISBN查询图书
    public void getBookFromISBN(SmartRefreshLayout smartRefreshLayout,String isbn) {

        //第一次请求数据，同时开启自动下拉刷新
        smartRefreshLayout.autoRefresh();
        ISBNRequesetUtil.requesetISBN(AppManager.getAppManager().currentActivity(),
                isbnSearchUrl + isbn, smartRefreshLayout,
                new IOnISBNListener<BookInfo>() {
                    @Override
                    public void onSuccessToISBN(BookInfo bookInfo) {

                        Bundle bookInfoBundle = new Bundle();
                        bookInfoBundle.putSerializable(ConstUtil.BOOKINFO,bookInfo);
                        startActivity(BookDetailActivity.class,bookInfoBundle);

                        finish();
                    }
                });
    }

    private void setBookInfo(List<BookInfo> bookInfo) {

        for (BookInfo entity : bookInfo) {
            RecycleBookItemVM itemViewModel = new RecycleBookItemVM(this, entity);
            //双向绑定动态添加Item
            observableList.add(itemViewModel);
        }
    }
}
