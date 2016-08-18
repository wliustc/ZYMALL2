package com.zy.app.mall.basic;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;

import com.zy.app.mall.MainFrameActivity;
import com.zy.app.mall.MyApplication;
import com.zy.common.utils.Log;

/**
 * Created by Robin on 2016/4/14.
 */
public class ApplicationManager {
    public static int a = -1;
    private static final MainFrameActivity c = MyApplication.getInstance().getMainFrameActivity();
    private static FragmentManager fragmentManager;

    public static void a(Fragment paramFragment)
    {
        if (paramFragment != null);
        try
        {
            FragmentTransaction transaction = fragmentManager.beginTransaction();
            transaction.remove(paramFragment);
            transaction.setTransition(4099);
            transaction.commitAllowingStateLoss();
            return;
        }
        catch (Exception e)
        {
            if (Log.D)
            e.printStackTrace();
        }
    }

    public static void a(FragmentManager paramFragmentManager)
    {
        fragmentManager = paramFragmentManager;
    }

}
