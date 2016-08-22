package com.zy.app.mall.category.view;

import android.content.Context;
import android.os.Build;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;

/**
 * Created by robin on 16-8-22.
 */
public class NestedViewPager extends ViewPager {
    private PagerAdapter a;
    private boolean b = false;
    private _B c = null;

    public NestedViewPager(Context paramContext)
    {
        super(paramContext);
    }

    public NestedViewPager(Context paramContext, AttributeSet paramAttributeSet)
    {
        super(paramContext, paramAttributeSet);
    }

    public final void a(_B paramb)
    {
        this.c = paramb;
    }

    protected void onAttachedToWindow()
    {
        super.onAttachedToWindow();
        this.b = true;
        if ((getAdapter() == null) && (this.a != null))
        {
            super.setAdapter(this.a);
            if (this.c != null)
                this.c.a();
        }
    }

    protected void onDetachedFromWindow()
    {
        super.onDetachedFromWindow();
        this.b = false;
    }

    public void setAdapter(PagerAdapter paramPagerAdapter)
    {
        if (Build.VERSION.SDK_INT >= 19)
            this.b = isLaidOut();
        if (this.b)
        {
            super.setAdapter(paramPagerAdapter);
            if (this.c != null)
                this.c.a();
            return;
        }
        this.a = paramPagerAdapter;
    }

    public interface _B
    {
        public void a();
    }
}
