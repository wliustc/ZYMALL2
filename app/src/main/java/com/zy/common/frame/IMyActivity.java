package com.zy.common.frame;

import android.app.Activity;
import android.content.Intent;
import android.os.Handler;

import com.zy.common.utils.HttpGroup;

/**
 * Created by Robin on 2016/4/6.
 */
public interface IMyActivity {
    public abstract void addDestroyListener(IDestroyListener destroyListener); //(a parama);

    public abstract void addLogoutListener(ILogoutListener paramb);//(b paramb);

    public abstract void addPauseListener(IPauseListener paramd);//d

    public abstract void addResumeListener(IResumeListener parame); //e

    public abstract void finish();

    public abstract Handler getHandler();

    public abstract HttpGroup getHttpGroupaAsynPool();

    public abstract HttpGroup getHttpGroupaAsynPool(int paramInt);

    public abstract String getStringFromPreference(String paramString);

    public abstract Activity getThisActivity();

    public abstract void onHideModal();

    public abstract void onShowModal();

    public abstract void post(Runnable paramRunnable);

    public abstract void post(Runnable paramRunnable, int paramInt);

    public abstract void putBooleanToPreference(String paramString, Boolean paramBoolean);

    public abstract void removeDestroyListener(IDestroyListener parama);

    public abstract void removeLogoutListener(ILogoutListener paramb);

    public abstract void removePauseListener(IPauseListener paramd);

    public abstract void removeResumeListener(IResumeListener parame);

    public abstract void startActivityForResultNoException(Intent paramIntent, int paramInt);

    public abstract void startActivityForResultNoExceptionStatic(Activity paramActivity, Intent paramIntent, int paramInt);

    public abstract void startActivityInFrame(Intent paramIntent);

    public abstract void startActivityInFrameWithNoNavigation(Intent paramIntent);

    public abstract void startActivityNoException(Intent paramIntent);
}
