package com.zy.app.mall;

import android.content.Context;
import android.support.v4.app.Fragment;

import com.zy.common.BaseApplication;

/**
 * Created by Robin on 2016/4/14.
 */
public class MyApplication extends BaseApplication {
    public static final String a = MyApplication.class.getSimpleName();

    public static MyApplication getInstance()
    {
        return (MyApplication)instance;
    }

    public MainFrameActivity getMainFrameActivity()
    {
        if ((this.mainFrameActivity != null) && ((this.mainFrameActivity instanceof MainFrameActivity)))
            return (MainFrameActivity)this.mainFrameActivity;
        return null;
    }

    @Override
    public void startMainFrameActivity(Context paramContext) {

    }

    @Override
    public void watchLeakFragment(Fragment paramFragment) {

    }
}
