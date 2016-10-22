package com.zy.common.utils;

import android.os.Build;

import com.jingdong.common.BaseApplication;


/**
 * Created by Robin on 2016/5/16.
 */
public class SDKUtils {
    //public static boolean a()
    public static boolean a()
    {
        return Build.VERSION.SDK_INT > Build.VERSION_CODES.DONUT;//4
    }

    //public static boolean b()
    public static boolean b()
    {
        return Build.VERSION.SDK_INT > Build.VERSION_CODES.ECLAIR_MR1;  //7
    }

    //public static boolean c()
    public static boolean c()
    {
        return Build.VERSION.SDK_INT > Build.VERSION_CODES.ECLAIR_0_1;//6
    }

    //public static boolean d()
    public static boolean d()
    {
        return Build.VERSION.SDK_INT >  Build.VERSION_CODES.GINGERBREAD_MR1;//10
    }

    //public static String e()
    public static String e()
    {
        try
        {
            String str = BaseApplication.getInstance().getPackageManager().getPackageInfo(BaseApplication.getInstance().getPackageName(), 0).versionName;
            return str;
        }
        catch (Exception localException)
        {
            if (Log.V)
                Log.v("SDKUtils", "Package name not found", localException);
        }
        return null;
    }
}
