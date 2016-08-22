package com.jingdong.app.mall.faxian.view.view;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.LinearLayout;

/**
 * Created by robin on 16-8-22.
 */
public class AuthorPageView extends LinearLayout {
    private static String TAG = AuthorPageView.class.getName();
    public static boolean isAnimStart = false;
    public static boolean isShow = true;

    public AuthorPageView(Context context) {
        super(context);
    }

    public AuthorPageView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public AuthorPageView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public AuthorPageView(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }
}
