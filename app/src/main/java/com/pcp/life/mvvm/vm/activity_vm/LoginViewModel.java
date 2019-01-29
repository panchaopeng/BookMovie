package com.pcp.life.mvvm.vm.activity_vm;

import android.app.Application;
import android.arch.lifecycle.MutableLiveData;
import android.support.annotation.NonNull;
import android.view.View;

import com.pcp.life.mvvm.activity.MainActivity;

import me.goldze.mvvmhabit.base.AppManager;
import me.goldze.mvvmhabit.base.BaseViewModel;
import me.goldze.mvvmhabit.binding.command.BindingAction;
import me.goldze.mvvmhabit.binding.command.BindingCommand;
import me.goldze.mvvmhabit.binding.command.BindingConsumer;
import me.goldze.mvvmhabit.utils.ToastUtils;

public class LoginViewModel extends BaseViewModel {

    //===初始化属性

    //输入的用户名
    public MutableLiveData<String> etUserName = new MutableLiveData<>();
    //输入的密码
    public MutableLiveData<String> etPassword = new MutableLiveData<>();
    //清除用户名的图标是否可见
    public MutableLiveData<Integer> clearVisible = new MutableLiveData<>();
    //用户名获取焦点，密码是否可见
    public MutableLiveData<Boolean> passwordEye = new MutableLiveData<>();
    //密码获取焦点，光标移至末尾
    public MutableLiveData<Boolean> passwordFocus = new MutableLiveData<>();

    public LoginViewModel(@NonNull Application application) {
        super(application);
    }

    @Override
    public void onCreate() {
        super.onCreate();
        etUserName.setValue("");
        etPassword.setValue("");
        clearVisible.setValue(View.INVISIBLE);
        passwordEye.setValue(false);
        passwordFocus.setValue(false);

    }

    //    用户名输入框是否获得焦点
    public BindingCommand<Boolean> focusUserName = new BindingCommand<Boolean>(new BindingConsumer<Boolean>() {
        @Override
        public void call(Boolean aBoolean) {
            if (aBoolean && etUserName.getValue().trim().length() > 0){
                clearVisible.setValue(View.VISIBLE);
            }else {
                clearVisible.setValue(View.INVISIBLE);
            }
        }
    });

    //    密码输入框是否获得焦点
    public BindingCommand<Boolean> focusPassword = new BindingCommand<Boolean>(new BindingConsumer<Boolean>() {
        @Override
        public void call(Boolean aBoolean) {
            passwordFocus.setValue(aBoolean);
        }
    });

    //    点击清除用户名
    public BindingCommand clearCommand = new BindingCommand(new BindingAction() {
        @Override
        public void call() {
            etUserName.setValue("");
        }
    });

    //    点击密码是否可见
    public BindingCommand passwordCommand = new BindingCommand(new BindingAction() {
        @Override
        public void call() {
            passwordEye.setValue(!passwordEye.getValue());
        }
    });

    //    点击登录按钮
    public BindingCommand loginCommand = new BindingCommand(new BindingAction() {
        @Override
        public void call() {
            if (etUserName.getValue().trim().length() > 0 && etPassword.getValue().trim().length() >0){
                startActivity(MainActivity.class);
                AppManager.getAppManager().finishActivity();
                //ToastUtils.showShort(etUserName.getValue() + etPassword.getValue());
            }else {
                ToastUtils.showShort("账号/密码不能为空");
            }

        }
    });

}
