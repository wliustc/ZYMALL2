package com.zy.app.util.image.listener;

import android.graphics.Bitmap;
import android.view.View;

import com.zy.app.util.image.assist.JDFailReason;

/**
 * Created by Robin on 2016/5/22.
 */
public interface JDImageLoadingListener {
    public abstract void onLoadingCancelled(String paramString, View paramView);

    public abstract void onLoadingComplete(String paramString, View paramView, Bitmap paramBitmap);

    public abstract void onLoadingFailed(String paramString, View paramView, JDFailReason paramJDFailReason);

    public abstract void onLoadingStarted(String paramString, View paramView);
}
