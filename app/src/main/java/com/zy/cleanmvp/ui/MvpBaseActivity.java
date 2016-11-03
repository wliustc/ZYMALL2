package com.zy.cleanmvp.ui;

import android.os.Bundle;
import android.widget.Toast;

import com.zy.cleanmvp.common.BaseEvent;
import com.zy.cleanmvp.presenter.BaseNavigator;
import com.zy.cleanmvp.presenter.BasePresenter;
import com.zy.cleanmvp.presenter.IBaseUI;
import com.zy.common.BaseActivity;
import com.zy.common.utils.Log;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;

import butterknife.ButterKnife;

/**
 * Created by Robin on 2016/11/3.
 */
public abstract class MvpBaseActivity<P extends BasePresenter, N extends BaseNavigator> extends BaseActivity
        implements IBaseUI {
    private final String TAG = MvpBaseActivity.class.getSimpleName();
    protected N navigator;
    protected P presenter = null;

    protected abstract int createLayout();

    protected abstract N createNavigator();

    protected abstract P createPresenter();

    protected N getNavigator()
    {
        if (this.navigator == null)
            this.navigator = createNavigator();
        if (this.navigator == null)
            throw new NullPointerException("navigator is null ! you should create a navigator.");
        return this.navigator;
    }

    protected P getPresenter()
    {
        if (this.presenter == null)
            this.presenter = createPresenter();
        if (this.presenter == null)
            throw new NullPointerException("presenter is null ! you should create a presenter.");
        return this.presenter;
    }

    protected void initDependency()
    {
        if (this.presenter == null)
            this.presenter = createPresenter();
        if (this.navigator == null)
            this.navigator = createNavigator();
    }

    protected void onCreate(Bundle paramBundle)
    {
        super.onCreate(paramBundle);
        initDependency();
        if (createLayout() == 0)
        {
            Log.d(this.TAG, "createLayout() returned 0, If you don't want to use createLayout(), but implement your own view,you have to override setContentView();");
            return;
        }
        setContentView(createLayout());
        ButterKnife.bind(this);
    }

    protected void onDestroy()
    {
        super.onDestroy();
        if (this.presenter != null)
            this.presenter.detachUI(this);
    }

    @Subscribe
    public void onEvent(BaseEvent paramBaseEvent)
    {
    }

    protected void onStart()
    {
        super.onStart();
        if (this.presenter != null)
            this.presenter.attachUI(this);
        if (!EventBus.getDefault().isRegistered(this))
            EventBus.getDefault().register(this);
    }

    protected void onStop()
    {
        super.onStop();
        if (this.presenter != null)
            this.presenter.suspend();
        EventBus.getDefault().unregister(this);
    }

    public void onTrimMemory(int paramInt)
    {
        super.onTrimMemory(paramInt);
        if (this.presenter != null)
            this.presenter.onTrimMemory(paramInt);
    }

    @Deprecated
    public void setContentView(int paramInt)
    {
        super.setContentView(paramInt);
    }

    protected void setPresenter(P paramP)
    {
        this.presenter = paramP;
    }

    public void showToast(String paramString)
    {
        Toast.makeText(this, paramString, Toast.LENGTH_SHORT).show();
    }
}
