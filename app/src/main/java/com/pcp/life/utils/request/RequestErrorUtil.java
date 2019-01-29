package com.pcp.life.utils.request;

import android.content.Context;
import android.widget.Toast;

import java.net.ConnectException;
import java.net.SocketTimeoutException;
import java.net.UnknownHostException;

public class RequestErrorUtil {


    public static void onError(Context context, Throwable t){

        //Throwable t = response.getException();
        if (t instanceof SocketTimeoutException) {
            Toast.makeText(context, "网络异常，请刷新重试", Toast.LENGTH_SHORT).show();
        } else if (t instanceof ConnectException) {
            Toast.makeText(context, "网络异常，请刷新重试", Toast.LENGTH_SHORT).show();

        } else if (t instanceof UnknownHostException) {
            Toast.makeText(context, "网络异常，请刷新重试", Toast.LENGTH_SHORT).show();

        } else {
            Toast.makeText(context, "未查询到相关数据", Toast.LENGTH_SHORT).show();

        }


    }
}
