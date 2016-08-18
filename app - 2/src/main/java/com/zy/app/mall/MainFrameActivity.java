package com.zy.app.mall;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Handler;

import com.zy.app.mall.basic.ApplicationManager;
import com.zy.app.mall.basic.JDUntil;
import com.zy.app.mall.navigationbar.NavigationFragment;
import com.zy.app.mall.utils.MyActivity;
import com.zy.common.BaseApplication;
import com.zy.common.ScrollableTabActivity;
import com.zy.common.frame.IMainActivity;
import com.zy.common.frame.IMyActivity;
import com.zy.common.utils.Log;
import com.zy.common.utils.TimerUntil;

/**
 * Created by Robin on 2016/4/14.
 */
public class MainFrameActivity extends MyActivity implements IMainActivity, ScrollableTabActivity {
    public static boolean a = true;
    private Handler handler;
    public boolean needCheckNet = true;
    private int lastIndex;

    @Override
    public void e() {

    }

    @Override
    public Handler getHandler() {
        return this.handler;
    }

    @Override
    public Activity getThisActivity() {
        return this;
    }

    @Override
    public boolean l() {
        return false;
    }

    @Override
    public IMyActivity n() {
        return null;
    }

    @Override
    public void startActivity(Intent paramIntent) {

    }

    @Override
    protected void onCreate(Bundle paramBundle) {
        this.needCheckNet = false;
        if (getIntent() == null) {
            finish();
            return;
        }
        if (JDUntil.hasSmartBar())
            setTheme(R.style.MeizuTheme);
        else if (getIntent().getBooleanExtra("from_launch", false))
            setTheme(R.style.splashTheme);
        setNetworkModel(false);
        TimerUntil.a = System.currentTimeMillis();
        BaseApplication.getInstance().setMainFrameActivity(this);

        try {
            Resources resources = getResources();
            Configuration configuration = resources.getConfiguration();
            configuration.fontScale = 1.0F;//设置默认字体
            resources.updateConfiguration(configuration, resources.getDisplayMetrics());
            this.handler = new Handler();
            ApplicationManager.a(getSupportFragmentManager());
            super.onCreate(paramBundle);
            setContentView(R.layout.app_jd_fragment_activity);
            if (paramBundle != null) {
                this.lastIndex = paramBundle.getInt("lastIndex");
                a = false;
            }

            if ((paramBundle == null) || (this.lastIndex != 0)) {
                NavigationFragment fragment = NavigationFragment.a(this.lastIndex);
                getSupportFragmentManager().beginTransaction().replace(R.id.navigation_fragment, fragment, "JDNavigationBarFragment").commit();//2131165833
            }
        }catch (Throwable t) {
            if (Log.E)
                t.printStackTrace();
        }
    }
}
