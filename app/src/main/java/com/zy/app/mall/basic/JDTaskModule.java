package com.zy.app.mall.basic;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.text.TextUtils;

import com.jingdong.app.mall.MainFrameActivity;
import com.jingdong.app.mall.MyApplication;
import com.zy.app.mall.R;
import com.zy.common.utils.Log;

/**
 * Created by Robin on 2016/5/19.
 */
public class JDTaskModule {
    private static final String TAG = "JDTaskModule";
    private static final BackStackManager backStackManager = BackStackManager.getInstance();
    private Bundle bundle;
    protected boolean forResult = false;
    protected boolean inHistory = true;
    private boolean init = false;
    private boolean isNeedClearBackStack = false;
    private boolean isNoShowAgain;
    private int optCount;
    private JDTaskModule prev;
    protected int requestCode = -1;

    private boolean checkBackStack() {
        JDTaskModule localJDTaskModule = getPrev();
        if (localJDTaskModule != null && (localJDTaskModule.isInHistory() || backStackManager.d().isNoShowAgain()))
            return true;
        return false;

    }

    private MainFrameActivity getFrameActivity() {

        while (this.optCount < 5) {
            if (MyApplication.getInstance().getMainFrameActivity() != null)
                return MyApplication.getInstance().getMainFrameActivity();

            this.optCount += 1;
            if (Log.D)
                Log.d("JDTaskModule", "getFrameActivity() optCount : " + this.optCount);
            try {
                Thread.sleep(50L);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }


        }
        this.optCount = 0;
        return null;

    }

    public void addAndCommit(int paramInt, Fragment paramFragment) {
        addAndCommit(paramInt, paramFragment, null);
    }

    public void addAndCommit(int paramInt, Fragment paramFragment, String paramString) {
        if (Log.D)
            Log.d("JDTaskModule", "addAndCommit -->> ");
        FragmentTransaction localFragmentTransaction = MyApplication.getInstance().getMainFrameActivity().getSupportFragmentManager().beginTransaction();
        localFragmentTransaction.add(paramInt, paramFragment);
        boolean bool = checkBackStack();
        if (Log.D)
            Log.d("JDTaskModule", "checkBackStack:" + bool);
        if (bool) {
            if (Log.D)
                Log.d("JDTaskModule", "addToBackStack() -->> fragment:" + getPrev());
            localFragmentTransaction.addToBackStack(paramString);
        }
        localFragmentTransaction.commitAllowingStateLoss();
    }

    public void addAndCommit(Fragment paramFragment) {
        addAndCommit(getFragmentContentById(), paramFragment);
    }

    public void addAndCommit(Fragment paramFragment, String paramString) {
        addAndCommit(getFragmentContentById(), paramFragment, paramString);
    }

    public void addFragmentForResult(Fragment paramFragment, int paramInt) {
        paramFragment.getArguments().putInt("requestCode", paramInt);
        addAndCommit(getFragmentContentById(), paramFragment);
    }

    public void beforeLeave(boolean paramBoolean) {
    }

    protected void doInit() {
    }

    protected void doShow() {
    }

    public Bundle getBundle() {
        if (this.bundle == null)
            return new Bundle();
        return this.bundle;
    }

    public int getFragmentContentById() {
        return R.id.content_layout;
    }

    public JDTaskModule getPrev() {
        return this.prev;
    }

    public void init() {
        doInit();
        this.init = true;
    }

    public boolean isInHistory() {
        return this.inHistory;
    }

    public boolean isInit() {
        return this.init;
    }

    public boolean isNeedClearBackStack() {
        return this.isNeedClearBackStack;
    }

    public boolean isNoShowAgain() {
        return this.isNoShowAgain;
    }

    public boolean premise() {
        return true;
    }

    public void replaceAndCommit(int paramInt, Fragment paramFragment) {
        replaceAndCommit(paramInt, paramFragment, null);
    }

    public void replaceAndCommit(int paramInt, Fragment paramFragment, String paramString) {
        try {
            MainFrameActivity frameActivity = getFrameActivity();
            if (frameActivity == null)
                return;
            FragmentManager supportFragmentManager = frameActivity.getSupportFragmentManager();
            FragmentTransaction transaction = supportFragmentManager.beginTransaction();
            if (TextUtils.isEmpty(paramString)) {
                if (paramFragment.isAdded())
                    transaction.remove(paramFragment);
                else
                    transaction.replace(paramInt, paramFragment);
            } else {
                Fragment fragmentByTag = supportFragmentManager.findFragmentByTag(paramString);
                if (fragmentByTag != null) {//if-eqz v0, :cond_5
                    if (fragmentByTag.isAdded())//if-eqz v2, :cond_4
                        transaction.remove(fragmentByTag);
                    else
                        transaction.replace(paramInt, fragmentByTag, paramString);
                } else if (paramFragment.isAdded())
                    transaction.remove(paramFragment);
                else
                    transaction.replace(paramInt, paramFragment, paramString);
            }
            //:goto_1
            transaction.setTransitionStyle(android.R.style.Animation_Translucent);//16973827
            transaction.commitAllowingStateLoss();
            return;

        } catch (Throwable e) {
            if (Log.D)
                e.printStackTrace();
        }
        return;
    }

    public void replaceAndCommit(Fragment paramFragment) {
        replaceAndCommit(getFragmentContentById(), paramFragment);
    }

    public void replaceAndCommit(Fragment paramFragment, Integer paramInteger) {
        replaceAndCommit(getFragmentContentById(), paramFragment, paramInteger.toString());
    }

    public void replaceAndCommit(Fragment paramFragment, String paramString) {
        replaceAndCommit(getFragmentContentById(), paramFragment, paramString);
    }

    public void replaceFragmentForResult(Fragment paramFragment, int paramInt) {
        paramFragment.getArguments().putInt("requestCode", paramInt);
        replaceAndCommit(getFragmentContentById(), paramFragment);
    }

    public void replaceFragmentForResult(Fragment paramFragment, int paramInt1, int paramInt2) {
        paramFragment.getArguments().putInt("requestCode", paramInt2);
        replaceAndCommit(paramInt1, paramFragment);
    }

    public void setBundle(Bundle paramBundle) {
        this.bundle = paramBundle;
    }

    public void setInHistory(boolean paramBoolean) {
        this.inHistory = paramBoolean;
    }

    public void setNeedClearBackStack(boolean paramBoolean) {
        this.isNeedClearBackStack = paramBoolean;
    }

    public void setNoShowAgain(boolean paramBoolean) {
        this.isNoShowAgain = paramBoolean;
    }

    public void setPrev(JDTaskModule paramJDTaskModule) {
        this.prev = paramJDTaskModule;
    }

    public void show() {
        doShow();
    }
}
