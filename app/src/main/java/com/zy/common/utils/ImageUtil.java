package com.zy.common.utils;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.jingdong.common.BaseApplication;
import com.jingdong.common.utils.cache.GlobalImageCache;
import com.zy.common.frame.IMainActivity;
import com.zy.common.frame.IMyActivity;

/**
 * Created by Robin on 2016/5/16.
 */
public class ImageUtil {
    private static LayoutInflater getLayoutInflater()
    {
        IMyActivity currentMyActivity = BaseApplication.getInstance().getCurrentMyActivity();
        IMainActivity mainFrameActivity = BaseApplication.getInstance().getMainFrameActivity();
        if (currentMyActivity != null)
            return getLayoutInflater(currentMyActivity.getThisActivity());
        if (mainFrameActivity != null)
            return getLayoutInflater(mainFrameActivity.getThisActivity());
        return getLayoutInflater(BaseApplication.getInstance());
    }

    private static LayoutInflater getLayoutInflater(Context paramContext)
    {
        return (LayoutInflater)paramContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    public static View inflate(int paramInt, ViewGroup paramViewGroup) {
        try
        {
            View localView = getLayoutInflater().inflate(paramInt, paramViewGroup);
            return localView;
        }
        catch (Throwable localThrowable)
        {
            try {
                GlobalImageCache.getLruBitmapCache().a();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return getLayoutInflater().inflate(paramInt, paramViewGroup);
    }

    public static View inflate(int paramInt, ViewGroup paramViewGroup, boolean paramBoolean)
    {
        try
        {
            View localView = getLayoutInflater().inflate(paramInt, paramViewGroup, paramBoolean);
            return localView;
        }
        catch (Throwable localThrowable)
        {
            GlobalImageCache.getLruBitmapCache().a();
        }
        return getLayoutInflater().inflate(paramInt, paramViewGroup, paramBoolean);
    }

    public static View inflate(Context paramContext, int paramInt, ViewGroup paramViewGroup)
    {
        try
        {
            View localView = getLayoutInflater(paramContext).inflate(paramInt, paramViewGroup);
            return localView;
        }
        catch (Throwable localThrowable)
        {
            GlobalImageCache.getLruBitmapCache().a();
        }
        return getLayoutInflater(paramContext).inflate(paramInt, paramViewGroup);
    }
}
