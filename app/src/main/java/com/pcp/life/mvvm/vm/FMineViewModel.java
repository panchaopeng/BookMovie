package com.pcp.life.mvvm.vm;

import android.app.Application;
import android.content.Intent;
import android.databinding.ObservableField;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.widget.ImageView;

import com.allen.library.SuperTextView;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.request.RequestOptions;
import com.lzy.okgo.OkGo;
import com.pcp.life.R;
import com.pcp.life.application.MyApplication;
import com.pcp.life.utils.APKUtil;
import com.pcp.life.utils.glide.GlideCatchUtil;

import me.goldze.mvvmhabit.base.AppManager;
import me.goldze.mvvmhabit.base.BaseViewModel;

public class FMineViewModel extends BaseViewModel {
    public FMineViewModel(@NonNull Application application) {

        super(application);
    }

//    https://www.bing.com/HPImageArchive.aspx?format=js&idx=0&n=1
//
//    idx表示请求的天数序列(倒序);0代表今天、1代表昨天…以此类推
//
//    n表示请求的天数数量(请求几天的图片);1为当天一天、2为昨天和今天

//    public ObservableField<String> baseUrl = new ObservableField<>("https://cn.bing.com");
//    public ObservableField<String> imgUrl = new ObservableField<>("https://www.bing.com/HPImageArchive.aspx?format=js&n=1&idx=");
//    public ObservableField<Integer> autoAdd = new ObservableField<>(0);

    public ObservableField<String> displayUrl = new ObservableField<>();

    public ObservableField<RequestOptions> avatarOptions = new ObservableField<>();
    RequestOptions options;

    @Override
    public void onCreate() {
        super.onCreate();
        displayUrl.set("https://cn.bing.com/az/hprichbg/rb/DivingEmperors_ZH-CN8118506169_1920x1080.jpg");
        options = new RequestOptions()
                .placeholder(R.drawable.vector_drawable_login_white)
                .error(R.drawable.vector_drawable_login_white)
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .skipMemoryCache(true)
                .circleCrop();
        avatarOptions.set(options);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        OkGo.getInstance().cancelTag(this);
    }


    //设置当前哦图像
    public void requestAvatar(Fragment fragment, ImageView avatar){
        Glide.with(fragment)
                .load(displayUrl.get())
                .apply(avatarOptions.get())
                .into(avatar);
    }

    //得到当前版本号
    public void appVersion(SuperTextView version){

      version.setRightString(APKUtil.getVerName(MyApplication.getInstance().getContext()));


    }

    //得到当前Glide缓存大小
    public void appGlideSize(SuperTextView cache){

        cache.setRightString(GlideCatchUtil.getInstance().getCacheSize())
                .setCenterString("单击清除")
                .setCenterTextColor(R.color.gray)
                .setOnSuperTextViewClickListener(new SuperTextView.OnSuperTextViewClickListener() {
                    @Override
                    public void onClickListener(SuperTextView superTextView) {
                        //ToastUtils.showShort("glide");
                        GlideCatchUtil.getInstance().cleanCatchDisk();
                        cache.setRightString(GlideCatchUtil.getInstance().getCacheSize());
                    }
                });
    }


    //跳转到github项目
    public void startGitHub(SuperTextView github){
        github.setOnSuperTextViewClickListener(new SuperTextView.OnSuperTextViewClickListener() {
            @Override
            public void onClickListener(SuperTextView superTextView) {
                //ToastUtils.showShort("github");
                Intent intent = new Intent();
                intent.setAction("android.intent.action.VIEW");
                Uri content_url = Uri.parse("https://github.com/panchaopeng/BookMovie/blob/master/app/src/main/app.apk");
                intent.setData(content_url);
                AppManager.getAppManager().currentActivity().startActivity(intent);
            }
        });

    }



}
