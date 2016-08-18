package com.zy.app.mall.navigationbar;

import android.os.Bundle;

import com.jingdong.app.mall.navigationbar.NavigationOptHelper;
import com.zy.cleanmvp.presenter.BaseNavigator;
import com.zy.cleanmvp.presenter.BasePresenter;
import com.zy.cleanmvp.ui.MvpBaseFragment;

/**
 * Created by Robin on 2016/5/4.
 */
public abstract class JDTabFragment<P extends BasePresenter, N extends BaseNavigator> extends MvpBaseFragment<P, N> implements INavigationPage{
    public abstract void a(int paramInt1, int paramInt2);

    protected N createNavigator()
    {
        return null;
    }

    protected P createPresenter()
    {
        return null;
    }

    protected P getPresenter()
    {
        return  super.getPresenter();
    }

    public void hideProgress()
    {
    }

    public void onCreate(Bundle paramBundle)
    {
        super.onCreate(paramBundle);
        a(NavigationOptHelper.getInstance().b(), NavigationOptHelper.getInstance().lastIndex);
        NavigationOptHelper.getInstance().a(NavigationOptHelper.getInstance().lastIndex);
    }

    protected void setPresenter(P paramBasePresenter)
    {
        super.setPresenter(paramBasePresenter);
    }

    public void showProgress()
    {
    }
}
