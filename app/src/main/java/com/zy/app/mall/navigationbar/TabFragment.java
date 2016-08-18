package com.zy.app.mall.navigationbar;

import android.os.Bundle;

import com.jingdong.app.mall.navigationbar.NavigationOptHelper;
import com.zy.cleanmvp.presenter.BaseNavigator;
import com.zy.cleanmvp.presenter.BasePresenter;
import com.zy.cleanmvp.ui.MvpBaseFragment;

/**
 * Created by Robin on 2016/5/4.
 */
public abstract class TabFragment<P extends BasePresenter, N extends BaseNavigator> extends MvpBaseFragment implements INavigationPage{
    /**
     * navigation-click
     * old--> paramInt1  now--> paramInt2
     */
    public abstract void a(int paramInt1, int paramInt2);

    protected BaseNavigator createNavigator()
    {
        return null;
    }

    protected BasePresenter createPresenter()
    {
        return null;
    }

    protected void setPresenter(BasePresenter paramBasePresenter)
    {
        super.setPresenter(paramBasePresenter);
    }

    protected P getPresenter()
    {
        return (P) super.getPresenter();
    }

    public void hideProgress()
    {
    }

    @Override
    public void onCreate(Bundle paramBundle)
    {
        super.onCreate(paramBundle);
        a(NavigationOptHelper.getInstance().b(), NavigationOptHelper.getInstance().lastIndex);
        NavigationOptHelper.getInstance().a(NavigationOptHelper.getInstance().lastIndex);
    }

    public void showProgress()
    {
    }
}
