package com.retrofit.wjh.modelapp2.Utils;

import android.util.Log;

import com.retrofit.wjh.modelapp2.App.AppConfig;

/**
 * Created by wujh on 2016/5/20.
 * Email:1049334820@qq.com
 */
public class LogUtil {
    public static void logV(String TAG, String msg) {
        if (AppConfig.DEBUG) {
            Log.v(TAG, msg);
        }
    }

    public static void logI(String TAG, String msg) {
        if (AppConfig.DEBUG) {
            Log.i(TAG, msg);
        }
    }

    public static void logE(String TAG, String msg) {
        if (AppConfig.DEBUG) {
            Log.e(TAG, msg);
        }
    }

    public static void logW(String TAG, String msg) {
        if (AppConfig.DEBUG) {
            Log.w(TAG, msg);
        }
    }

    public static void logD(String TAG, String msg) {
        if (AppConfig.DEBUG) {
            Log.d(TAG, msg);
        }
    }
}
