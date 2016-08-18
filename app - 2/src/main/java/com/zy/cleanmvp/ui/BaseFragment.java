package com.zy.cleanmvp.ui;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.Fragment;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.zy.common.BaseActivity;
import com.zy.common.BaseApplication;
import com.zy.common.utils.Log;

import java.lang.reflect.Field;

/**
 * Created by Robin on 2016/4/18.
 */
public abstract class BaseFragment extends Fragment {
    private static final String TAG = BaseFragment.class.getSimpleName();
    private Handler handler = new Handler();
    private boolean isMoveTaskBack;
    private boolean isStoped;
    protected boolean isUseBasePV = true;
    //protected HttpGroupWithNPS mHttpGroupWithNPS;
    private ViewGroup mViewGroup;
    protected boolean needRemoveviewOnStop = true;
    protected String page_id = "";
    protected View rootView;
    protected String shop_id = "";
    public BaseActivity thisActivity;

    public abstract View onCreateViews(LayoutInflater layoutInflater, Bundle bundle);
    public abstract boolean onKeyDown(int paramInt, KeyEvent keyEvent);

    @Override
    public void onActivityCreated(Bundle paramBundle) {
        if (Log.D)
            Log.d(TAG, "onActivityCreated() >> " + getClass().getName());
        super.onActivityCreated(paramBundle);
    }

    @Override
    public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent) {
        if (Log.D)
            Log.d(TAG, "onActivityResult() >> " + getClass().getName());
        super.onActivityResult(paramInt1, paramInt2, paramIntent);
    }

    @Override
    public void onAttach(Activity paramActivity) {
        super.onAttach(paramActivity);
        try {
            this.thisActivity = ((BaseActivity) paramActivity);
            return;
        } catch (Exception e) {
            if (Log.D) ;
            e.printStackTrace();
        }
    }

    @Override
    public void onCreate(Bundle paramBundle) {
        if (Log.D)
            Log.d(TAG, "onCreate() >> " + getClass().getName());
        super.onCreate(paramBundle);
        if (this.rootView == null) ;
        try {
            this.rootView = onCreateViews(this.thisActivity.getLayoutInflater(), paramBundle);
            return;
        } catch (Throwable e) {
            e.printStackTrace();
        }
    }

    @Override
    public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle) {
        return this.rootView;
    }

    @Override
    public void onDestroy() {
        if (Log.D)
            Log.d(TAG, "onDestroy() >> " + getClass().getName());
        super.onDestroy();
        if (Log.D)
            BaseApplication.getInstance().watchLeakFragment(this);
    }

    @Override
    public void onDestroyView() {
        if (Log.D)
            Log.d(TAG, "onDestroyView() >> " + getClass().getName());
        super.onDestroyView();
        remove();
    }

    @Override
    public void onDetach() {
        if (Log.D)
            Log.d(TAG, "onDetach() >> " + getClass().getName());
        super.onDetach();
        try {
            Field localField = Fragment.class.getDeclaredField("mChildFragmentManager");
            localField.setAccessible(true);
            localField.set(this, null);
            return;
        } catch (NoSuchFieldException localNoSuchFieldException) {
            throw new RuntimeException(localNoSuchFieldException);
        } catch (IllegalAccessException localIllegalAccessException) {
            throw new RuntimeException(localIllegalAccessException);
        }
    }

    public void remove() {
        try {
            if (this.rootView != null) {
                this.mViewGroup = ((ViewGroup) this.rootView.getParent());
                if (this.mViewGroup != null) {
                    if (Log.D)
                        Log.d(TAG, "onStop() remove-->> " + getClass().getName());
                    this.isStoped = true;
                    this.mViewGroup.removeView(this.rootView);
                }
            }
            return;
        } catch (Exception e) {
            if (Log.D) ;
            e.printStackTrace();
        }
    }

    public void onPause()
    {
        if (Log.D)
            Log.d(TAG, "onPause() >> " + getClass().getName());
        super.onPause();
    }

    public void onResume()
    {
        if (Log.D)
            Log.d(TAG, "onResume() >> " + getClass().getName());
        this.thisActivity.setSubRootView((ViewGroup)this.rootView);
        if (this.isUseBasePV)
            JDMtaUtils.sendPagePv(this.thisActivity, this, getPageParam(), this.page_id, this.shop_id);
        super.onResume();
    }

    public void onStart()
    {
        if (Log.D)
            Log.d(TAG, "onStart() >> " + getClass().getName());
        super.onStart();
        add();
    }

    public void onStop()
    {
        super.onStop();
        if (this.needRemoveviewOnStop)
            remove();
    }

    public void post(Runnable paramRunnable)
    {
        if (this.thisActivity != null)
        {
            this.thisActivity.post(paramRunnable);
            return;
        }
        this.handler.post(paramRunnable);
    }

    public void post(Runnable paramRunnable, int paramInt)
    {
        if (this.thisActivity != null)
        {
            this.thisActivity.post(paramRunnable, paramInt);
            return;
        }
        this.handler.postDelayed(paramRunnable, paramInt);
    }


}
