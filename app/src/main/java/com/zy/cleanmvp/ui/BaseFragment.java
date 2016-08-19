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

import com.jingdong.common.BaseActivity;
import com.jingdong.common.BaseApplication;
import com.zy.common.utils.JDMtaUtils;
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

    /**
     * called once the fragment is associated with its activity
     * @param paramActivity
     */
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

    /**
     * called to do initial creation of the fragment
     * @param paramBundle
     */
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

    /**
     * creates and returns the view hierarchy associated with the fragment
     * @param paramLayoutInflater
     * @param paramViewGroup
     * @param paramBundle
     * @return
     */
    @Override
    public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle) {
        return this.rootView;
    }

    /**
     * tells the fragment that its activity has completed its own {@link Activity#onCreate Activity.onCreaate}
     * @param paramBundle
     */
    @Override
    public void onActivityCreated(Bundle paramBundle) {
        if (Log.D)
            Log.d(TAG, "onActivityCreated() >> " + getClass().getName());
        super.onActivityCreated(paramBundle);
    }

    /**
     * makes the fragment visible to the user (based on its containing activity being started)
     */
    @Override
    public void onStart() {
        if (Log.D)
            Log.d(TAG, "onStart() >> " + getClass().getName());
        super.onStart();
        add();
    }

    /**
     * makes the fragment interacting with the user (based on its containing activity being resumed).
     */
    @Override
    public void onResume() {
        if (Log.D)
            Log.d(TAG, "onResume() >> " + getClass().getName());
        this.thisActivity.setSubRootView((ViewGroup) this.rootView);
        if (this.isUseBasePV)
            JDMtaUtils.sendPagePv(this.thisActivity, this, getPageParam(), this.page_id, this.shop_id);
        super.onResume();
    }

    @Override
    public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent) {
        if (Log.D)
            Log.d(TAG, "onActivityResult() >> " + getClass().getName());
        super.onActivityResult(paramInt1, paramInt2, paramIntent);
    }

    /**
     * fragment is no longer interacting with the user either because its activity is being paused or a fragment operation is modifying it in the activity.
     */
    @Override
    public void onPause() {
        if (Log.D)
            Log.d(TAG, "onPause() >> " + getClass().getName());
        super.onPause();
    }

    /**
     * fragment is no longer visible to the user either  because its activity is being stopped or a fragment operation is modifying it  in the activity.
     */
    @Override
    public void onStop() {
        super.onStop();
        if (this.needRemoveviewOnStop)
            remove();
    }

    /**
     * allows the fragment to clean up resources  associated with its View.
     */
    @Override
    public void onDestroyView() {
        if (Log.D)
            Log.d(TAG, "onDestroyView() >> " + getClass().getName());
        super.onDestroyView();
        remove();
    }

    /**
     * called to do final cleanup of the fragment's state.
     */
    @Override
    public void onDestroy() {
        if (Log.D)
            Log.d(TAG, "onDestroy() >> " + getClass().getName());
        super.onDestroy();
        if (Log.D)
            BaseApplication.getInstance().watchLeakFragment(this);
    }

    /**
     * called immediately prior to the fragment no longer   being associated with its activity
     */
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

    public void add() {
        try {
            if ((this.isStoped) && (this.rootView != null))
                if (this.rootView.getParent() == null) {//if-nez v0, :cond_6
                    if (Log.D)
                        Log.d(TAG, "onStart() rootView.getParent() is null-->> " + getClass().getName());
                    if (this.mViewGroup != null) {//if-eqz v0, :cond_4
                        if (Log.D)
                            Log.d(TAG, "onStart() add view-->> " + getClass().getName());
                        this.mViewGroup.removeView(this.rootView);
                        this.mViewGroup.addView(this.rootView);
                    } else {
                        ViewGroup localViewGroup = (ViewGroup) getView().getParent();
                        if (localViewGroup != null) {
                            if (Log.D)
                                Log.d(TAG, "onStart() remove add view-->> " + getClass().getName());
                            localViewGroup.removeView(this.rootView);
                            localViewGroup.addView(this.rootView);
                        }
                    }//:cond_2 :goto_0
                    this.isStoped = false;
                    return;
                } else {//cond_6
                    if (Log.D)
                        Log.d(TAG, "onStart() rootView.getParent() not null-->> " + getClass().getName());
                }
        } catch (Exception localException) {
            if (Log.D)
                localException.printStackTrace();
        }
        return;
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

    public void post(Runnable paramRunnable) {
        if (this.thisActivity != null) {
            this.thisActivity.post(paramRunnable);
            return;
        }
        this.handler.post(paramRunnable);
    }

    public void post(Runnable paramRunnable, int paramInt) {
        if (this.thisActivity != null) {
            this.thisActivity.post(paramRunnable, paramInt);
            return;
        }
        this.handler.postDelayed(paramRunnable, paramInt);
    }

    public String getPageParam() {
        return "";
    }

    public boolean isMoveTaskBack() {
        return this.isMoveTaskBack;
    }

    public void setIsUseBasePV(boolean paramBoolean)
    {
        this.isUseBasePV = paramBoolean;
    }

    public void setMoveTaskBack(boolean paramBoolean)
    {
        this.isMoveTaskBack = paramBoolean;
    }

    protected void setPageId(String paramString)
    {
        this.page_id = paramString;
    }

    protected void setShopId(String paramString)
    {
        this.shop_id = paramString;
    }

    public String getFragmentString(int paramInt)
    {
        if (isAdded())
            return getString(paramInt);
        return "";
    }

    public int getFragmentTextColor(int paramInt)
    {
        if (isAdded())
            return getResources().getColor(paramInt);
        return 0;
    }
}
