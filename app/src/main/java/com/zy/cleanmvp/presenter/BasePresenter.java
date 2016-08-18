package com.zy.cleanmvp.presenter;

import android.content.Intent;

import com.zy.cleanmvp.common.BaseEvent;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.SubscriberExceptionEvent;

import java.lang.ref.WeakReference;

/**
 * Created by Robin on 2016/5/4.
 */
public abstract class BasePresenter <UI extends IBaseUI>{
    private static final String TAG = "BasePresenter";
    protected boolean isShow = false;
    protected WeakReference<UI> mUI = null;


    @Subscribe
    public abstract void onEvent(BaseEvent paramBaseEvent);

    @Subscribe
    public abstract void onEventMainThread(BaseEvent paramBaseEvent);

    @Subscribe
    public void onEvent(SubscriberExceptionEvent event){
        event.throwable.printStackTrace();
    }

    protected abstract void onAttach(UI paramUI);

    protected abstract void onDetach(UI paramUI);

    protected abstract void onSuspend();

    protected abstract UI createNullObject();

    public BasePresenter()
    {
        if (!EventBus.getDefault().isRegistered(this))
            EventBus.getDefault().register(this);
    }

    public void attachUI(UI paramUI)
    {
        if ((paramUI != null) && (!this.isShow))
        {
            if (!EventBus.getDefault().isRegistered(this))
                EventBus.getDefault().register(this);
            this.mUI = new WeakReference(paramUI);
            this.isShow = true;
            onAttach(paramUI);
        }
    }

    public void detachUI(UI paramUI)
    {
        if (paramUI != null)
        {
            this.mUI = null;
            onDetach(paramUI);
            EventBus.getDefault().unregister(this);
        }
    }

    public UI getUI()
    {
        if (this.mUI != null)
            return (UI) this.mUI.get();
        return createNullObject();
    }

    public boolean handleIntent(Intent paramIntent)
    {
        return false;
    }

    public boolean isShow()
    {
        return this.isShow;
    }


    public void onTrimMemory(int paramInt)
    {
    }

    public void setIsShow(boolean paramBoolean)
    {
        this.isShow = paramBoolean;
    }

    public void suspend()
    {
        if (this.isShow)
            this.isShow = false;
        onSuspend();
    }
}
