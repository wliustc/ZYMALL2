package com.zy.app.mall.utils.ui.view;

import android.content.Context;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;

import com.zy.common.utils.Log;

/**
 * Created by Robin on 2016/6/22.
 */
public class HomeViewPager extends ViewPager
        implements View.OnTouchListener{
    private ViewGroup a;
    private boolean b = true;
    private boolean c = true;

    public HomeViewPager(Context paramContext, AttributeSet paramAttributeSet)
    {
        super(paramContext, paramAttributeSet);
        setOnTouchListener(this);
    }

    public HomeViewPager(Context paramContext, ViewGroup paramViewGroup)
    {
        super(paramContext);
        this.a = paramViewGroup;
        setOnTouchListener(this);
    }

    protected void onAttachedToWindow()
    {
        if (this.b)
            super.onAttachedToWindow();
        this.b = false;
    }

    public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
    {
        switch (paramMotionEvent.getAction())
        {
            case 2://:pswitch_0
            default:
                if (this.a != null)
                this.a.requestDisallowInterceptTouchEvent(true);
                break;
            case 1://:pswitch_1
            case 3://:pswitch_1
                try
                {
                        if (this.a != null)
                        this.a.requestDisallowInterceptTouchEvent(false);
                }
                catch (Throwable e)
                {
                    if (Log.E)
                        e.printStackTrace();
                    return true;
                }
        }
        onTouchEvent(paramMotionEvent);
        return true;
    }

    public void scrollTo(int paramInt1, int paramInt2)
    {
        if (this.c)
            super.scrollTo(paramInt1, paramInt2);
    }
}
