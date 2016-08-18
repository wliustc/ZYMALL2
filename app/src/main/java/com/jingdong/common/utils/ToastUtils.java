package com.jingdong.common.utils;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;

import com.jingdong.common.BaseApplication;
import com.jingdong.common.ui.JDToast;
import com.zy.common.frame.IMyActivity;
import com.zy.common.utils.NetUtils;

/**
 * Created by Robin on 2016/5/31.
 */
public class ToastUtils {
    private static JDToast centerToast;
    private static Handler mHandler;
    private static JDToast sToast = null;

    private static Handler getHandler()
    {
        if (mHandler == null)
            mHandler = new Handler(Looper.getMainLooper());
        return mHandler;
    }

    public static void longToast(int paramInt)
    {
        showToastPrivate(BaseApplication.getInstance(), paramInt, 1);
    }

    public static void longToast(Context paramContext, int paramInt)
    {
        showToastPrivate(paramContext, paramInt, 1);
    }

    public static void longToast(Context paramContext, String paramString)
    {
        showToastPrivate(paramContext, paramString, 1);
    }

    public static void longToast(String paramString)
    {
        showToastPrivate(BaseApplication.getInstance(), paramString, 1);
    }

    public static void shortToast(int paramInt)
    {
        showToastPrivate(BaseApplication.getInstance(), paramInt, 0);
    }

    public static void shortToast(Context paramContext, int paramInt)
    {
        showToastPrivate(paramContext, paramInt, 0);
    }

    public static void shortToast(Context paramContext, String paramString)
    {
        showToastPrivate(paramContext, paramString, 0);
    }

    public static void shortToast(String paramString)
    {
        shortToast(BaseApplication.getInstance(), paramString);
    }

    public static void showToast(IMyActivity paramIMyActivity, String paramString)
    {
        longToast(paramString);
    }

    public static void showToast(String paramString)
    {
        longToast(paramString);
    }

    public static void showToastInCenter(Context paramContext, byte paramByte, String paramString, int paramInt)
    {
//        getHandler().post(new gc(paramContext, paramByte, paramString, paramInt));
    }

    private static void showToastPrivate(Context paramContext, int paramInt1, int paramInt2)
    {
        if (paramContext == null)
            return;
        showToastPrivate(paramContext, paramContext.getString(paramInt1), paramInt2);
    }

    private static void showToastPrivate(Context paramContext, String paramString, int paramInt)
    {
//        getHandler().post(new ga(paramContext, paramString, paramInt));
    }

    private static void showToastPrivateY(Context paramContext, String paramString, int paramInt)
    {
//        getHandler().post(new gb(paramContext, paramString, paramInt));
    }

    public static void showToastWithNetworkAvailable(IMyActivity paramIMyActivity, String paramString)
    {
        if (NetUtils.isNetworkAvailable())
            longToast(paramString);
    }

    public static void showToastY(int paramInt)
    {
        showToastPrivateY(BaseApplication.getInstance(), BaseApplication.getInstance().getString(paramInt), 0);
    }

    public static void showToastY(String paramString)
    {
        showToastPrivateY(BaseApplication.getInstance(), paramString, 0);
    }
}
