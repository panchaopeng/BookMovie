package com.pcp.life.mvvm.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;

import com.allen.library.SuperTextView;
import com.pcp.life.BR;
import com.pcp.life.R;
import com.pcp.life.base.BaseLazyFragment;
import com.pcp.life.databinding.FragmentMineBinding;
import com.pcp.life.mvvm.vm.FMineViewModel;
import com.pcp.life.utils.glide.GlideCatchUtil;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;
import me.goldze.mvvmhabit.base.AppManager;

public class MineFragment extends BaseLazyFragment<FragmentMineBinding, FMineViewModel> {


    @BindView(R.id.avatar)
    ImageView avatar;
    @BindView(R.id.version)
    SuperTextView version;
    @BindView(R.id.cache)
    SuperTextView cache;
    @BindView(R.id.github)
    SuperTextView github;
    @BindView(R.id.exit)
    Button exit;
    Unbinder unbinder;

    private View mineRootView = null;

    public void updateGlideCache() {
        binding.cache.setRightString(GlideCatchUtil.getInstance().getCacheSize());
    }


    @Override
    public int initContentView(LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        return R.layout.fragment_mine;
    }

    @Override
    public int initVariableId() {
        return BR.fMine;
    }


    @Override
    public void lazyLoadData() {

    }


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        mineRootView = super.onCreateView(inflater, container, savedInstanceState);
        unbinder = ButterKnife.bind(this,mineRootView );

        //设置头像
        viewModel.requestAvatar(this,avatar);


        //获取版本号
        viewModel.appVersion(version);


        //获取Glide缓存大小
        viewModel.appGlideSize(cache);


        //github地址
        viewModel.startGitHub(github);


        return mineRootView;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    @OnClick(R.id.exit)
    public void onViewClicked() {
        AppManager.getAppManager().AppExit();

    }
}
