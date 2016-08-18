package com.zy.cleanmvp.presenter;

/**
 * Created by Robin on 2016/5/4.
 */
public interface IBaseUI {
    public abstract void hideProgress();

    public abstract boolean isRetain();

    public abstract void showProgress();

    public abstract void showToast(String paramString);
}
