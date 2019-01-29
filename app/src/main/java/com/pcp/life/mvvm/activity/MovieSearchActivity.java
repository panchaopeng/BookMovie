package com.pcp.life.mvvm.activity;

import android.content.Intent;
import android.os.Bundle;
import android.speech.RecognizerIntent;
import android.text.TextUtils;
import android.view.Menu;
import android.view.MenuItem;

import com.miguelcatalan.materialsearchview.MaterialSearchView;
import com.pcp.life.BR;
import com.pcp.life.R;
import com.pcp.life.databinding.ActivityMovieSearchBinding;
import com.pcp.life.mvvm.vm.activity_vm.MovieSearchViewModel;

import java.util.ArrayList;

import me.goldze.mvvmhabit.base.BaseActivity;

public class MovieSearchActivity extends BaseActivity<ActivityMovieSearchBinding,MovieSearchViewModel> {

    private MaterialSearchView searchView;


    @Override
    public int initContentView(Bundle bundle) {
        return R.layout.activity_movie_search;
    }

    @Override
    public int initVariableId() {
        return BR.movieSearchVM;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        searchView = binding.movieSearchView;

        initToolBar("");
        initSearch();
    }

    private void initToolBar(String title) {
        setSupportActionBar(binding.toolbar);
        if (getSupportActionBar() != null) {
            getSupportActionBar().setTitle(title);
        }
    }

    private void initSearch() {

        //查询监听
        searchView.setOnQueryTextListener(new MaterialSearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                //Do some magic

                //设置搜索参数为标题
                initToolBar(query);

                //请求数据与下拉刷新
                viewModel.getMoiveList(binding.movieSearchRefreshLayout,query);
                //请求数据与上拉加载
                viewModel.loadMore(binding.movieSearchRefreshLayout,binding.movieSearchRecycle,query);

                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {

                //一秒后查询
//                new Timer().schedule(new TimerTask() {
//                    @Override
//                    public void run() {
//                        //getSuggetions(newText);
//                    }
//                }, 300);


                return false;
            }


        });

        //当SearchView关闭或开启时的操作
        searchView.setOnSearchViewListener(new MaterialSearchView.SearchViewListener() {
            @Override
            public void onSearchViewShown() {
                //Do some magic
            }

            @Override
            public void onSearchViewClosed() {
                //Do some magic
            }
        });

        //关闭声音图标
        searchView.setVoiceSearch(false);

        //如果SearchView不是查询状态，则打开查询状态（无动画），并弹出键盘
        if (!searchView.isSearchOpen()) {
            searchView.showSearch(false);
            searchView.showKeyboard(searchView);
        }


    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_book_search, menu);

        MenuItem item = menu.findItem(R.id.action_search);
        searchView.setMenuItem(item);

        return true;
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == MaterialSearchView.REQUEST_VOICE && resultCode == RESULT_OK) {
            ArrayList<String> matches = data.getStringArrayListExtra(RecognizerIntent.EXTRA_RESULTS);
            if (matches != null && matches.size() > 0) {
                String searchWrd = matches.get(0);
                if (!TextUtils.isEmpty(searchWrd)) {
                    searchView.setQuery(searchWrd, false);
                }
            }

            return;
        }
        super.onActivityResult(requestCode, resultCode, data);
    }

    @Override
    public void onBackPressed() {
        if (searchView.isSearchOpen()) {
            searchView.closeSearch();
        } else {
            super.onBackPressed();
        }
    }

}
