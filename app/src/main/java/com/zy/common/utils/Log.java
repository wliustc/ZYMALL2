package com.zy.common.utils;

/**
 * Created by Robin on 2016/4/6.
 */
public class Log {
    public static final boolean D = true;
    public static final boolean E = false;
    public static final boolean I = false;
    public static final boolean V = false;
    public static final boolean W = false;

    public static void e(String tag, String message) {
        android.util.Log.e(tag, message);
    }

    public static void d(String tag, String message) {
        android.util.Log.d(tag, message);
    }

    public static void i(String tag, String message) {
        android.util.Log.i(tag, message);
    }

    public static void install(){
        //TODO: 该方法未实现
    }

    public static void unInstall() {
//        if (mLogCore != null)
//        {
//            mLogCore.b();
//            mLogCore = null;
//            mBaseApplication = null;
//        }
    }

    public static void v(String sdkUtils, String s, Exception localException) {

    }

    public static void v(String tag, String message) {
        android.util.Log.v(tag, message);
    }
}
