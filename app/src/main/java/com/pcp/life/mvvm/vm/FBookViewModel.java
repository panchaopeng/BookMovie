package com.pcp.life.mvvm.vm;

import android.app.Application;
import android.content.Intent;
import android.databinding.ObservableField;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.ActivityOptionsCompat;
import android.support.v4.app.Fragment;

import com.pcp.life.R;
import com.pcp.life.mvvm.activity.BookSearchActivity;
import com.pcp.life.mvvm.activity.CustomScanActivity;
import com.pcp.life.mvvm.fragment.second_fragment.book.SCBook_CultureFragment;
import com.pcp.life.mvvm.fragment.second_fragment.book.SCBook_LifeFragment;
import com.pcp.life.mvvm.fragment.second_fragment.book.SCBook_PopularFragment;
import com.pcp.life.utils.ConstUtil;

import java.util.ArrayList;

import me.goldze.mvvmhabit.base.AppManager;
import me.goldze.mvvmhabit.base.BaseViewModel;
import me.goldze.mvvmhabit.binding.command.BindingAction;
import me.goldze.mvvmhabit.binding.command.BindingCommand;

public class FBookViewModel extends BaseViewModel {



    public FBookViewModel(@NonNull Application application) {
        super(application);

    }

    public ObservableField<String[]> mTitles = new ObservableField<>();
    public ObservableField<SCBook_PopularFragment> popularFragment = new ObservableField<>();
    public ObservableField<SCBook_CultureFragment> cultureFragment = new ObservableField<>();
    public ObservableField<SCBook_LifeFragment> lifeFragment = new ObservableField<>();
    public ObservableField<ArrayList<Fragment>> mFragments = new ObservableField<>();

    //点击扫描时，动态申请照相机权限
    public ObservableField<Boolean> cameraFlag = new ObservableField<>(false);

    @Override
    public void onCreate() {
        super.onCreate();
        mTitles.set(new String[]{"流行", "文化", "生活"});
        popularFragment.set(new SCBook_PopularFragment());
        cultureFragment.set(new SCBook_CultureFragment());
        lifeFragment.set(new SCBook_LifeFragment());
        mFragments.set( new ArrayList<Fragment>(){
            {
                add(popularFragment.get());
                add(cultureFragment.get());
                add(lifeFragment.get());
            }
        });

    }

    //搜索图书
    public BindingCommand bookSearchCommand = new BindingCommand(new BindingAction() {
        @Override
        public void call() {
            //ToastUtils.showShort("搜索");
            startActivity(BookSearchActivity.class);
        }
    });

    //扫码图书的ISBN码或关键词
    public BindingCommand scanCommand = new BindingCommand(new BindingAction() {
        @Override
        public void call() {

            ActivityOptionsCompat optionsCompat = ActivityOptionsCompat.makeCustomAnimation(
                    AppManager.getAppManager().currentActivity(),
                    R.anim.in,R.anim.out);

            Intent intent = new Intent(AppManager.getAppManager().currentActivity(), CustomScanActivity.class);
            //intent.putExtra(KEY_TITLE,title);

            //扫描结果回传到MainActivity处理
            ActivityCompat.startActivityForResult(
                    AppManager.getAppManager().currentActivity(),
                    intent,
                    ConstUtil.REQUEST_CODE_SCAN,
                    optionsCompat.toBundle());

        }
    });



}
