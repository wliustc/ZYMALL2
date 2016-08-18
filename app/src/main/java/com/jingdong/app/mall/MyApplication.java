package com.jingdong.app.mall;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.v4.app.Fragment;

import com.jingdong.app.mall.MainFrameActivity;
import com.jingdong.common.BaseApplication;
import com.zy.app.mall.R;

/**
 * Created by Robin on 2016/4/14.
 */
public class MyApplication extends BaseApplication {
    public static final String a = MyApplication.class.getSimpleName();

    public static MyApplication getInstance()
    {
        return (MyApplication)instance;
    }

    @Override
    public Drawable getDefalutDrawble() {
        return getResources().getDrawable(R.drawable.image_logo);//2130839465
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
