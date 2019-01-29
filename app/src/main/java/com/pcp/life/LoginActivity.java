package com.pcp.life;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.text.InputType;
import android.view.View;
import android.view.WindowManager;

import com.pcp.life.databinding.ActivityLoginBinding;
import com.pcp.life.mvvm.vm.activity_vm.LoginViewModel;

import me.goldze.mvvmhabit.base.BaseActivity;


public class LoginActivity extends BaseActivity<ActivityLoginBinding,LoginViewModel> {

    @Override
    public int initContentView(Bundle bundle) {
        return R.layout.activity_login;
    }

    @Override
    public int initVariableId() {
        return BR.login;
    }

    @Override
    public LoginViewModel initViewModel() {
        //View持有ViewModel的引用，如果没有特殊业务处理，这个方法可以不重写
        return ViewModelProviders.of(this).get(LoginViewModel.class);
    }

    @Override
    public void initData() {

        //防止EditText再次获取焦点时键盘会遮挡该ET
        getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_ADJUST_RESIZE);

        //双向绑定MutableLiveData
        binding.setLifecycleOwner(this);
    }

    //    监听属性变化
    @Override
    public void initViewObservable() {
        //监听密码是否可见的图标

        viewModel.passwordEye.observe(this, new Observer<Boolean>() {
            @Override
            public void onChanged(@Nullable Boolean aBoolean) {
                if (viewModel.passwordEye.getValue()){//密码明文
                    binding.imgLoginEye.setImageResource(R.drawable.vector_drawable_login_look);
                    //binding.password.setTransformationMethod(HideReturnsTransformationMethod.getInstance());
                    binding.password.setInputType(InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_VARIATION_VISIBLE_PASSWORD);

                }else{//密文密码要一起写才能起作用 InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_VARIATION_PASSWORD
                    binding.imgLoginEye.setImageResource(R.drawable.vector_drawable_login_unlook);
                    //binding.password.setTransformationMethod(PasswordTransformationMethod.getInstance());
                    binding.password.setInputType(InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_VARIATION_PASSWORD);

                }

                //如果密码框获得焦点，则把光标移到末尾
                if (viewModel.passwordFocus.getValue()){
                    binding.password.setSelection(viewModel.etPassword.getValue().length());

                }


            }
        });


        //监听用户名不为空，则显示右侧清除图标
        viewModel.etUserName.observe(this, new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                if (viewModel.etUserName.getValue().trim().length() > 0){
                    viewModel.clearVisible.setValue(View.VISIBLE);
                }else{
                    viewModel.clearVisible.setValue(View.INVISIBLE);

                }
            }
        });



    }



}
