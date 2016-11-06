package com.jingdong.common;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Process;
import android.os.SystemClock;
import android.support.v4.app.Fragment;

import com.zy.common.frame.IMainActivity;
import com.zy.common.frame.IMyActivity;
import com.zy.common.utils.CommonUtil;
import com.zy.common.utils.DPIUtil;
import com.zy.common.utils.Log;

/**
 * Created by Robin on 2016/4/14.
 */
public abstract class BaseApplication extends Application {

    private static int APP_DOWNLOAD_NOTIFICATION;
    private static String APP_UPDATE_FAILED;
    private static final String TAG = BaseApplication.class.getSimpleName();
    private static boolean canExitInToastTime = false;
    protected static BaseApplication instance;
    public static boolean isShowActivity;

    public static long startRealTime;
    public static long startTime;
    private IMyActivity activity;

    private IMyActivity homeMainActivity;
    protected IMainActivity mainFrameActivity;

    public static BaseApplication getInstance()
    {
        return instance;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        if (Log.D)
            Log.d("MyApplication", "MyApplication onCreate() -->> Process.myPid() " + Process.myPid());
        super.onCreate();
        //Thread.setDefaultUncaughtExceptionHandler();
        CommonUtil.getJdSharedPreferences().edit().putInt("runStage", 0).commit();
        startTime = SystemClock.uptimeMillis();
        startRealTime = SystemClock.elapsedRealtime();

        DPIUtil.setDensity(getResources().getDisplayMetrics().density);
    }

    @Override
    protected void attachBaseContext(Context base) {
        super.attachBaseContext(base);

        instance = this;
    }

    public IMyActivity getCurrentMyActivity()
    {
        if (Log.D)
        {
            if (this.mainFrameActivity == null)
                Log.d("MyApplication", "xxx mainFrameActivity -->>  mainFrameActivity is null");
            else{
                Log.d("MyApplication", "xxx mainFrameActivity -->> " + this.mainFrameActivity);
            }

        }
        if (this.activity != null)
        {
            return this.activity;

        }else if (this.mainFrameActivity != null)
        {
            Activity localActivity = this.mainFrameActivity.getThisActivity();
            if (Log.D)
                Log.d("MyApplication", "xxx activity -->> " + localActivity);
            if ((localActivity instanceof IMyActivity))
                return (IMyActivity)localActivity;
        }
        return null;
    }

    public abstract Drawable getDefalutDrawble();

    public IMainActivity getMainFrameActivity()
    {
        return this.mainFrameActivity;
    }

    public void setCurrentMyActivity(IMyActivity paramIMyActivity)
    {
        this.activity = paramIMyActivity;
    }

    public void setHomeMainActivity(IMyActivity paramIMyActivity)
    {
        this.homeMainActivity = paramIMyActivity;
    }

    public void setMainFrameActivity(IMainActivity paramc)
    {
        this.mainFrameActivity = paramc;
    }

    public abstract void startMainFrameActivity(Context paramContext);

    public abstract void watchLeakFragment(Fragment paramFragment);

    public static void exitControl() {
    }

    public static void exitAll() {

    }

    public static void exitDialog() {
    }
}
