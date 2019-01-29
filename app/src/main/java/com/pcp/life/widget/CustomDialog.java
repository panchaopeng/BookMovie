package com.pcp.life.widget;

import android.app.Activity;
import android.app.Dialog;
import android.view.KeyEvent;
import android.view.WindowManager;

import com.pcp.life.R;


public class CustomDialog extends Dialog{


    public CustomDialog(Activity activity) {
        super(activity, R.style.CustomDialog);
        initView();
    }
    //监听手机屏幕上的按键
    //此处监听返回键
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        switch (keyCode){
            case KeyEvent.KEYCODE_BACK:
                if(CustomDialog.this.isShowing())
                    CustomDialog.this.dismiss();
                break;
        }
        return true;
    }

    private void initView() {
        setContentView(R.layout.dialog_view);
        //提示文字：加载中
        //((TextView)findViewById(R.id.tvcontent)).setText(content);
        //设置点击Dialog外部任意区域关闭Dialog
        setCanceledOnTouchOutside(true);
        WindowManager.LayoutParams attributes = getWindow().getAttributes();
        //设置自定义Dialog的alpha值
        attributes.alpha=0.8f;
        getWindow().setAttributes(attributes);
        //点击外部区域不能取消
        setCancelable(false);
    }
}
