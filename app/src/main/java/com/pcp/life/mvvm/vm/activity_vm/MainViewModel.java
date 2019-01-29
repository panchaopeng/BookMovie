package com.pcp.life.mvvm.vm.activity_vm;

import android.app.Application;
import android.databinding.ObservableField;
import android.support.annotation.NonNull;

import com.pcp.life.mvvm.fragment.BookFragment;
import com.pcp.life.mvvm.fragment.MineFragment;
import com.pcp.life.mvvm.fragment.MovieFragment;

import me.goldze.mvvmhabit.base.BaseViewModel;

public class MainViewModel extends BaseViewModel {

    public MainViewModel(@NonNull Application application) {
        super(application);
    }

    @Override
    public void onCreate() {
        super.onCreate();


    }


}
