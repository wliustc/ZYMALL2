package com.zy.cleanmvp.ui;

import android.os.Bundle;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.zy.cleanmvp.common.BaseEvent;
import com.zy.cleanmvp.presenter.BaseNavigator;
import com.zy.cleanmvp.presenter.BasePresenter;
import com.zy.cleanmvp.presenter.IBaseUI;

import org.greenrobot.eventbus.EventBus;

/**
 * Created by Robin on 2016/5/4.
 */
public abstract class MvpBaseFragment<P extends BasePresenter, N extends BaseNavigator> extends BaseFragment
        implements IBaseUI {
    private final String TAG = MvpBaseFragment.class.getSimpleName();
    private N navigator;
    protected P presenter = null;

    private void initDependency()
    {
        if (this.presenter == null)
            this.presenter = createPresenter();
        if (this.navigator == null)
            this.navigator = createNavigator();
    }

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

    public boolean isRetain()
    {
        return false;
    }

    public void onCreate(Bundle paramBundle)
    {
        super.onCreate(paramBundle);
        initDependency();
    }

    public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
    {
        ButterKnife.bind(this, this.rootView);
        return super.onCreateView(paramLayoutInflater, paramViewGroup, paramBundle);
    }

    public void onDestroy()
    {
        super.onDestroy();
        if (this.presenter != null)
            this.presenter.detachUI(this);
    }

    public void onDestroyView()
    {
        super.onDestroyView();
        ButterKnife.unbind(this);
    }

    public void onEvent(BaseEvent paramBaseEvent)
    {
    }

    public void onStart()
    {
        super.onStart();
        if (this.presenter != null)
            this.presenter.attachUI(this);
        if (!EventBus.getDefault().isRegistered(this))
            EventBus.getDefault().register(this);
    }

    public void onStop()
    {
        super.onStop();
        if (this.presenter != null)
            this.presenter.suspend();
        EventBus.getDefault().unregister(this);
    }

    protected void setPresenter(P paramP)
    {
        this.presenter = paramP;
    }

    @Override
    public void showToast(String paramString) {
        Toast.makeText(getActivity(), paramString, Toast.LENGTH_SHORT).show();
    }
}
