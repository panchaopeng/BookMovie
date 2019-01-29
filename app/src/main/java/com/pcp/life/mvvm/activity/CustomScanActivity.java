package com.pcp.life.mvvm.activity;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.hardware.Camera;
import android.os.Bundle;
import android.provider.MediaStore;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.king.zxing.CaptureActivity;
import com.king.zxing.util.CodeUtils;
import com.pcp.life.R;
import com.pcp.life.utils.ConstUtil;
import com.pcp.life.utils.UriUtils;

import butterknife.OnClick;


public class CustomScanActivity extends CaptureActivity {

    @Override
    public int getLayoutId() {
        return R.layout.activity_custom_scan;
    }

    @Override
    public void onCreate(Bundle icicle) {
        super.onCreate(icicle);

        //设置标题
//        TextView tvTitle = findViewById(R.id.scan_title);
//        tvTitle.setText(getIntent().getStringExtra(MainActivity.KEY_TITLE));

        //设置播放Beep声音
        getBeepManager().setPlayBeep(true);
        //设置震动
        getBeepManager().setVibrate(true);
    }

    //关灯
    private void offFlash() {
        Camera camera = getCameraManager().getOpenCamera().getCamera();
        Camera.Parameters parameters = camera.getParameters();
        parameters.setFlashMode(Camera.Parameters.FLASH_MODE_OFF);
        camera.setParameters(parameters);
    }

    //开灯
    public void openFlash() {
        Camera camera = getCameraManager().getOpenCamera().getCamera();
        Camera.Parameters parameters = camera.getParameters();
        parameters.setFlashMode(Camera.Parameters.FLASH_MODE_TORCH);
        camera.setParameters(parameters);
    }


    private void clickFlash(View v) {

        //判断手机是否支持闪光灯
        if (getPackageManager().hasSystemFeature(PackageManager.FEATURE_CAMERA_FLASH)) {
            if (v.isSelected()) {
                offFlash();
                v.setSelected(false);
            } else {
                openFlash();
                v.setSelected(true);
            }
        } else {
            Toast.makeText(this, "当前设备没有闪光灯", Toast.LENGTH_LONG).show();

        }


    }


    @OnClick({R.id.scan_finish, R.id.scan_album, R.id.scan_flash})
    public void OnClick(View view) {
        switch (view.getId()) {
            case R.id.scan_finish:
                finish();
                break;
            case R.id.scan_flash:
                clickFlash(view);
                break;
            case R.id.scan_album:
                //Toast.makeText(this, "相册", Toast.LENGTH_SHORT).show();
                startPhotoCode();
                break;
        }
    }

    private void startPhotoCode() {
        Intent pickIntent = new Intent(Intent.ACTION_PICK,
                MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
        pickIntent.setDataAndType(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, "image/*");
        //从相册选择图片并回调处理
        startActivityForResult(pickIntent, ConstUtil.REQUEST_CODE_PHOTO);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == RESULT_OK && data != null) {
            switch (requestCode) {

                case ConstUtil.REQUEST_CODE_PHOTO:
                    parsePhoto(data);
                    break;
            }

        }
    }

    private void parsePhoto(Intent data) {
        try {
            final String path = UriUtils.INSTANCE.getImagePath(this, data);
            Log.d("Jenly", "path:" + path);
            if (TextUtils.isEmpty(path)) {
                return;
            }
            //异步解析
            asyncThread(new Runnable() {
                @Override
                public void run() {
                    final String result = CodeUtils.parseCode(path);
                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
//                        Log.d("Jenly","result:" + result);
//                        Toast.makeText(getContext(),result,Toast.LENGTH_SHORT).show();

                            // && BookDetailUtil.isNumeric(result)
                            if (result != null && result.length() > 0) {
                                Intent search = new Intent(CustomScanActivity.this, BookSearchActivity.class);
                                search.putExtra(ConstUtil.SEARCH_WORD, result.trim());
                                startActivity(search);
                                //关闭扫描Activity
                                finish();
                            } else {
                                Toast.makeText(CustomScanActivity.this, "不是二/一维码图片,请重新选择", Toast.LENGTH_SHORT).show();

                            }

                        }
                    });

                }
            });
        } catch (Exception e) {
            Toast.makeText(CustomScanActivity.this, "不是二/一维码图片,请重新选择", Toast.LENGTH_SHORT).show();

        }

    }

    private void asyncThread(Runnable runnable) {
        new Thread(runnable).start();
    }
}
