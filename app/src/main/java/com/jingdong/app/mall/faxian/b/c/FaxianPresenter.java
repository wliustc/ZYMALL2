package com.jingdong.app.mall.faxian.b.c;

import com.jingdong.app.mall.faxian.b.d.IFaxianUI;
import com.zy.cleanmvp.common.BaseEvent;
import com.zy.cleanmvp.presenter.BasePresenter;

/**
 * Created by Robin on 2016/5/19.
 */
//d
public class FaxianPresenter extends BasePresenter<IFaxianUI> {
    @Override
    protected IFaxianUI createNullObject() {
        return null;
    }

    @Override
    protected void onAttach(IFaxianUI paramUI) {

    }

    @Override
    protected void onDetach(IFaxianUI paramUI) {

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
