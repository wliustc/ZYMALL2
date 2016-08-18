package com.zy.cleanmvp.presenter;

import com.zy.cleanmvp.common.BaseEvent;

import org.greenrobot.eventbus.EventBus;

/**
 * Created by Robin on 2016/5/19.
 */
public abstract class BaseInteractor
{
    public abstract void cancleIO();

    public abstract void clearState(int paramInt);

    public void postEvent(BaseEvent paramBaseEvent)
    {
        EventBus.getDefault().post(paramBaseEvent);
    }
}