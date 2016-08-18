package com.zy.app.mall.searchRefactor.b.b.a;

import com.zy.app.mall.searchRefactor.view.a.IMySearchUI;
import com.zy.cleanmvp.common.BaseEvent;
import com.zy.cleanmvp.presenter.BasePresenter;

/**
 * Created by Robin on 2016/5/16.
 */
//af
public class SearchPresenter extends BasePresenter<IMySearchUI> {
    @Override
    protected IMySearchUI createNullObject() {
        return null;
    }

    @Override
    protected void onAttach(IMySearchUI paramUI) {

    }

    @Override
    protected void onDetach(IMySearchUI paramUI) {

    }

    @Override
    public void onEvent(BaseEvent paramBaseEvent) {

    }

    @Override
    public void onEventMainThread(BaseEvent paramBaseEvent) {

    }

    @Override
    protected void onSuspend() {

    }
}
