package com.zy.app.mall.searchRefactor.view.Activity;

import com.zy.app.mall.searchRefactor.b.b.a.SearchPresenter;
import com.zy.app.mall.searchRefactor.view.a.IMySearchUI;
import com.zy.cleanmvp.presenter.BaseNavigator;
import com.zy.cleanmvp.ui.MvpBaseActivity;

/**
 * Created by Robin on 2016/5/16.
 */
public class SearchActivity extends MvpBaseActivity<SearchPresenter, BaseNavigator>
        implements IMySearchUI {
    @Override
    public void hideProgress() {

    }

    @Override
    public boolean isRetain() {
        return false;
    }

    @Override
    public void showProgress() {

    }

    @Override
    protected int createLayout() {
        return 0;
    }

    @Override
    protected BaseNavigator createNavigator() {
        return null;
    }

    @Override
    protected SearchPresenter createPresenter() {
        return null;
    }

    @Override
    public void showToast(String paramString) {

    }
}
