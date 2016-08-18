package com.zy.common.utils;

import android.content.Context;
import android.view.Display;
import android.view.WindowManager;

import com.zy.common.BaseApplication;

/**
 * Created by Robin on 2016/4/6.
 */
public class DPIUtil {
    private static Display defaultDisplay;
    private static float mDensity = 160.0F;

    public static int dip2px(float paramFloat)
    {
        return (int)(mDensity * paramFloat + 0.5F);
    }

    public static Display getDefaultDisplay()
    {
        if (defaultDisplay == null)
            defaultDisplay = ((WindowManager) BaseApplication.getInstance().getSystemService(Context.WINDOW_SERVICE/*"window"*/)).getDefaultDisplay();
        return defaultDisplay;
    }

    public static float getDensity()
    {
        return mDensity;
    }

    public static int getHeight()
    {
        return getDefaultDisplay().getHeight();
    }

    public static int getWidth()
    {
        return getDefaultDisplay().getWidth();
    }

    public static int getWidthByDesignValue(int paramInt1, int paramInt2)
    {
        return getWidth() * paramInt1 / paramInt2;
    }

    public static int getWidthByDesignValue720(int paramInt)
    {
        return getWidthByDesignValue(paramInt, 720);
    }

    public static int percentHeight(float paramFloat)
    {
        return (int)(getHeight() * paramFloat);
    }

    public static int percentWidth(float paramFloat)
    {
        return (int)(getWidth() * paramFloat);
    }

    public static int px2dip(Context paramContext, float paramFloat)
    {
        return (int)(paramFloat / mDensity + 0.5F);
    }

    public static int px2sp(Context paramContext, float paramFloat)
    {
        return (int)(paramFloat / paramContext.getResources().getDisplayMetrics().scaledDensity + 0.5F);
    }

    public static void setDensity(float paramFloat)
    {
        mDensity = paramFloat;
        if (Log.D)
            Log.d("DPIUtil", " -->> density=" + paramFloat);
    }

    public static int sp2px(Context paramContext, float paramFloat)
    {
        return (int)(paramContext.getResources().getDisplayMetrics().scaledDensity * (paramFloat - 0.5F));
    }
}
