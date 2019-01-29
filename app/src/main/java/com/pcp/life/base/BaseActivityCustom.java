package com.pcp.life.base;

import android.arch.lifecycle.ViewModelProviders;
import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;


public abstract class BaseActivityCustom extends AppCompatActivity {
    //根视图
    protected View rootView;

    private ViewDataBinding mBinding;

    //获取布局文件
    protected abstract int getLayoutId();
    //获取布局文件里的ViewModel ID
    protected abstract int getVariableId();
    //获取ViewModel实例
    protected abstract Class getViewModelClass();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initOnCreateBeforeBinding();
        mBinding = DataBindingUtil.setContentView(this, getLayoutId());
        mBinding.setVariable(getVariableId(),ViewModelProviders.of(this).get(getViewModelClass()));
        mBinding.setLifecycleOwner(this);
        initOnCreateAfterBinding();
    }

    public void initOnCreateAfterBinding() {
    }
    public void initOnCreateBeforeBinding() {
    }
}
