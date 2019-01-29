package com.pcp.life.mvvm.vm;

import android.app.Application;
import android.databinding.ObservableField;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;

import com.pcp.life.mvvm.activity.MovieSearchActivity;
import com.pcp.life.mvvm.fragment.second_fragment.movie.SCMovie_RecentFragment;
import com.pcp.life.mvvm.fragment.second_fragment.movie.SCMovie_TopFragment;

import java.util.ArrayList;

import me.goldze.mvvmhabit.base.BaseViewModel;
import me.goldze.mvvmhabit.binding.command.BindingAction;
import me.goldze.mvvmhabit.binding.command.BindingCommand;

public class FMovieViewModel extends BaseViewModel {

    public FMovieViewModel(@NonNull Application application) {
        super(application);

    }

    public ObservableField<String[]> mTitles = new ObservableField<>();
    public ObservableField<SCMovie_RecentFragment> recentFragment = new ObservableField<>();
    public ObservableField<SCMovie_TopFragment> topFragment = new ObservableField<>();
    public ObservableField<ArrayList<Fragment>> mFragments = new ObservableField<>();

    @Override
    public void onCreate() {
        super.onCreate();
        mTitles.set(new String[]{"最近热播", "TOP250"});
        recentFragment.set(new SCMovie_RecentFragment());
        topFragment.set(new SCMovie_TopFragment());

        mFragments.set(new ArrayList<Fragment>(){
            {
                add(recentFragment.get());
                add(topFragment.get());

            }
        });

    }


    //电影搜索点击事件
    public BindingCommand movieSearchCommand = new BindingCommand(new BindingAction() {
        @Override
        public void call() {
            //ToastUtils.showShort("movie");
            startActivity(MovieSearchActivity.class);
        }


    });
}
