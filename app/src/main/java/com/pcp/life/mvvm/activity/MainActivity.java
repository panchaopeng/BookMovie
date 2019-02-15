package com.pcp.life.mvvm.activity;

import android.Manifest;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.widget.Toast;

import com.king.zxing.Intents;
import com.pcp.life.BR;
import com.pcp.life.R;
import com.pcp.life.databinding.ActivityMainBinding;
import com.pcp.life.mvvm.fragment.BookFragment;
import com.pcp.life.mvvm.fragment.MineFragment;
import com.pcp.life.mvvm.fragment.MovieFragment;
import com.pcp.life.mvvm.vm.activity_vm.MainViewModel;
import com.pcp.life.utils.ConstUtil;
import com.pcp.life.utils.SystemPermissionUtil;
import com.pcp.life.widget.BottomBar;
import com.tbruyelle.rxpermissions2.RxPermissions;

import me.goldze.mvvmhabit.base.BaseActivity;

public class MainActivity extends BaseActivity<ActivityMainBinding, MainViewModel> {

    //======全局参数
    //用于退出程序用，搭配onKeyDown
    //private long preTime;

    //======解决Fragment重叠的一些参考
    //参考文章：https://blog.csdn.net/yuzhiqiang_1993/article/details/75014591


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //申请系统相关权限
        //创建监听权限的接口对象
        requestPermission();

        initBottomBar();

    }

    @Override
    public int initContentView(Bundle savedInstanceState) {
        return R.layout.activity_main;
    }

    @Override
    public int initVariableId() {
        return BR.main;
    }


    private void initBottomBar() {

        binding.bottomBar.setContainer(R.id.main_container)
                .setIconWidth(32)
                .setIconHeight(32)
                .setTitleSize(12)
                .setTitleIconMargin(3)
                .setTitleBeforeAndAfterColor(
                        "#8a8a8a",
                        "#1296db")
                .addItem(BookFragment.class,
                        "图书",
                        R.drawable.vector_drawable_book_normal,
                        R.drawable.vector_drawable_book_pressed)
                .addItem(MovieFragment.class,
                        "电影",
                        R.drawable.vector_drawable_movie_normal,
                        R.drawable.vector_drawable_movie_pressed)
                .addItem(MineFragment.class,
                        "我的",
                        R.drawable.vector_drawable_mine_normal,
                        R.drawable.vector_drawable_mine_pressed)
                .setFirstChecked(0)
                .selectedListener(new BottomBar.IOnTabSelected() {
                    @Override
                    public void onTabSelectedAfterInit(int position,Fragment fragment) {
                        if (position == 2){
                            ((MineFragment)fragment).updateGlideCache();
                        }
                    }
                })
                .build();
    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == RESULT_OK && data != null) {
            switch (requestCode) {
                //接收扫描回传的结果
                case ConstUtil.REQUEST_CODE_SCAN:
                    String result = data.getStringExtra(Intents.Scan.RESULT);
                    if (result != null && result.length() > 0) {
                        Intent search = new Intent(MainActivity.this, BookSearchActivity.class);
                        search.putExtra(ConstUtil.SEARCH_WORD, result.trim());
                        startActivity(search);
                    } else {
                        Toast.makeText(MainActivity.this, "解析内容为空，请重新扫描", Toast.LENGTH_SHORT).show();

                    }
                    break;

            }

        }
    }

    @Override
    public void onBackPressed() {
        //实现Home键效果
        //super.onBackPressed();这句话一定要注掉,不然又去调用默认的back处理方式了
        Intent i = new Intent(Intent.ACTION_MAIN);
        i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        i.addCategory(Intent.CATEGORY_HOME);
        startActivity(i);
    }

    public void requestPermission() {
        RxPermissions rxPermissions = new RxPermissions(this);
        rxPermissions
                .requestEachCombined(Manifest.permission.CAMERA)
                .subscribe(permission -> { // will emit 1 Permission object
                    if (permission.granted) {
                        // All permissions are granted !

                    } else if (permission.shouldShowRequestPermissionRationale) {
                        // At least one denied permission without ask never again

                        //跳转到系统设置页面
                        SystemPermissionUtil.setSystemPermission(this);

                    } else {
                        // At least one denied permission with ask never again
                        // Need to go to the settings
                        //跳转到系统设置页面
                        SystemPermissionUtil.setSystemPermission(this);
                    }
                });
    }


    //
//    @Override
//    public boolean onKeyDown(int keyCode, KeyEvent event) {
//        if (keyCode == KeyEvent.KEYCODE_BACK) {
//            //退出程序
//            long currentTime = new Date().getTime();
//            // 如果时间间隔大于2秒，不处理
//            if ((currentTime - preTime) > 2000) {
//                // 显示消息
//                Toast.makeText(this, "再按一次退出程序", Toast.LENGTH_SHORT).show();
//                //更新时间
//                preTime = currentTime;
//                //截获事件，不再处理
//                return true;
//            }
//
//
//        }
//        //退出所有的Activity
//        AppManager.getAppManager().AppExit();
//
//        return super.onKeyDown(keyCode, event);
//    }
}
