package com.zy.common;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentActivity;
import android.view.inputmethod.InputMethodManager;

import com.zy.common.frame.IDestroyListener;
import com.zy.common.frame.ILogoutListener;
import com.zy.common.frame.IMyActivity;
import com.zy.common.frame.IPauseListener;
import com.zy.common.frame.IResumeListener;
import com.zy.common.utils.HttpGroup;

/**
 * Created by Robin on 2016/4/14.
 */
public class BaseActivity  extends FragmentActivity implements IMyActivity {
    private Thread mUiThread;
    protected boolean isOnNetwork = true;

    @Override
    public void addDestroyListener(IDestroyListener destroyListener) {

    }

    @Override
    public void addLogoutListener(ILogoutListener paramb) {

    }

    @Override
    public void addPauseListener(IPauseListener paramd) {

    }

    @Override
    public void addResumeListener(IResumeListener parame) {

    }

    @Override
    public Handler getHandler() {
        return null;
    }

    @Override
    public HttpGroup getHttpGroupaAsynPool() {
        return null;
    }

    @Override
    public HttpGroup getHttpGroupaAsynPool(int paramInt) {
        return null;
    }

    @Override
    public String getStringFromPreference(String paramString) {
        return null;
    }

    @Override
    public Activity getThisActivity() {
        return null;
    }

    @Override
    public void onHideModal() {

    }

    @Override
    public void onShowModal() {

    }

    @Override
    public void post(Runnable paramRunnable) {

    }

    @Override
    public void post(Runnable paramRunnable, int paramInt) {

    }

    @Override
    public void putBooleanToPreference(String paramString, Boolean paramBoolean) {

    }

    @Override
    public void removeDestroyListener(IDestroyListener parama) {

    }

    @Override
    public void removeLogoutListener(ILogoutListener paramb) {

    }

    @Override
    public void removePauseListener(IPauseListener paramd) {

    }

    @Override
    public void removeResumeListener(IResumeListener parame) {

    }

    @Override
    public void startActivityForResultNoException(Intent paramIntent, int paramInt) {

    }

    @Override
    public void startActivityForResultNoExceptionStatic(Activity paramActivity, Intent paramIntent, int paramInt) {

    }

    @Override
    public void startActivityInFrame(Intent paramIntent) {

    }

    @Override
    public void startActivityInFrameWithNoNavigation(Intent paramIntent) {

    }

    @Override
    public void startActivityNoException(Intent paramIntent) {

    }

    public void setNetworkModel(boolean paramBoolean)
    {
        this.isOnNetwork = paramBoolean;
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        BaseApplication.getInstance().setCurrentMyActivity(this);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        this.mUiThread = Thread.currentThread();
        ((InputMethodManager)getSystemService(Context.INPUT_METHOD_SERVICE)).hideSoftInputFromWindow(getWindow().getDecorView().getWindowToken(), 0);
        super.onCreate(savedInstanceState);
    }
}
