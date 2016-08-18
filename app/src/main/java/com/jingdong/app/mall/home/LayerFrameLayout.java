package com.jingdong.app.mall.home;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.FrameLayout;

import com.zy.common.entity.HomeLayerParamEntity;

/**
 * Created by Robin on 2016/5/17.
 */
public class LayerFrameLayout extends FrameLayout {
    private Context mContext;
    private static final String LOGIN_PATH = "/user/login.action";
    public static boolean isHomeTabNow = true;
    private LayerFrameLayout.LayerStateChangeListener mStateChangeListener;

    public LayerFrameLayout(Context context)
    {
        super(context, null);
    }

    public LayerFrameLayout(Context context, AttributeSet paramAttributeSet)
    {
        super(context, paramAttributeSet);
        this.mContext = context;
        init();
    }

    private void init() {
    }

    public void onResume() {
    }

    public void onPause() {
    }

    public void showLayer(HomeLayerParamEntity paramHomeLayerParamEntity) {

    }

    public void setStateChangeListener(LayerFrameLayout.LayerStateChangeListener paramLayerStateChangeListener)
    {
        this.mStateChangeListener = paramLayerStateChangeListener;
    }

    public abstract interface LayerStateChangeListener
    {
        public abstract void onRemove();

        public abstract void onShow();
    }
}
