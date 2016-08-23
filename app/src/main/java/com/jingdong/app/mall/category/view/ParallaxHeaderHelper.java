package com.jingdong.app.mall.category.view;

import android.annotation.SuppressLint;
import android.os.Build;
import android.support.v4.util.SparseArrayCompat;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.AbsListView;
import android.widget.TextView;

import com.jingdong.common.deeplinkhelper._B;
import com.zy.app.mall.category.adapter.ScrollTabHolderPagerAdapter;
import com.zy.app.mall.category.view.NestedViewPager;
import com.zy.app.mall.category.view.PagerSlidingTabStrip;

/**
 * Created by robin on 16-8-22.
 */
@SuppressLint({"NewApi"})
public class ParallaxHeaderHelper implements ViewPager.OnPageChangeListener, NestedViewPager._B, ScrollTabHolder._I {
    public static int a;
    private static final boolean b;
    private static final int c;
    private View d;
    private PagerSlidingTabStrip e;
    private boolean f = true;
    private int g;
    private int h;
    private NestedViewPager i;
    private ScrollTabHolderPagerAdapter j;
    private TextView k;
    private int l = 0;
    private int m = 0;
    private _H n = null;

    static
    {
        boolean bool = true;
        a = 1;
        c = 4;
        if (Integer.valueOf(Build.VERSION.SDK_INT).intValue() < 11);
        while (true)
        {
            b = bool;
            return;
            bool = false;
        }
    }

    public final void a()
    {
        this.e.setViewPager(this.i);
    }

    public final void a(View paramView, int paramInt)
    {
        this.d = paramView;
        this.g = paramInt;
    }

    public final void a(AbsListView paramAbsListView, int paramInt1, int paramInt2)
    {
        View localView2;
        if (this.i.getCurrentItem() == paramInt2)
        {
            localView2 = paramAbsListView.getChildAt(0);
            if (localView2 != null)
                break label90;
            paramInt1 = 0;
        }
        label52: label90: View localView1;
        while (true)
        {
            if (!b)
                break label191;
            if (!this.f)
                break label183;
            this.l = (-Math.max(-paramInt1, this.h));
            if (this.k != null)
                this.k.setText(String.valueOf(paramInt1));
            this.d.scrollTo(0, this.l);
            this.d.postInvalidate();
            return;
            localView1 = localView2;
            if (localView2.getHeight() != 0)
                break;
            localView1 = paramAbsListView.getChildAt(1);
            if (localView1 == null)
            {
                paramInt1 = 0;
                continue;
            }
            this.m = 1;
        }
        paramInt2 = paramAbsListView.getFirstVisiblePosition();
        paramInt1 = paramInt2;
        if (paramInt2 >= this.m)
            paramInt1 = paramInt2 - this.m;
        int i1 = localView1.getTop();
        if (paramInt1 > 0);
        for (paramInt2 = this.g; ; paramInt2 = 0)
        {
            i1 = -i1;
            paramInt1 = localView1.getHeight() * paramInt1 + i1 + paramInt2;
            break;
            label183: this.l = paramInt1;
            break label52;
            label191: if (this.k != null)
                this.k.setText(String.valueOf(paramInt1));
            if (this.f)
            {
                this.d.setTranslationY(Math.max(-paramInt1, this.h));
                return;
            }
            this.d.setTranslationY(-paramInt1);
            return;
        }
    }

    public final void a(TextView paramTextView)
    {
        this.k = paramTextView;
    }

    public final void a(NestedViewPager paramNestedViewPager, ScrollTabHolderPagerAdapter paramScrollTabHolderPagerAdapter)
    {
        this.i = paramNestedViewPager;
        this.i.setOffscreenPageLimit(c);
        this.j = paramScrollTabHolderPagerAdapter;
        this.j.a(this);
        if (this.i.getAdapter() != null);
        for (int i1 = 1; ; i1 = 0)
        {
            this.i.setAdapter(paramScrollTabHolderPagerAdapter);
            this.i.a(this);
            if (i1 != 0)
                paramScrollTabHolderPagerAdapter.notifyDataSetChanged();
            return;
        }
    }

    public final void a(PagerSlidingTabStrip paramPagerSlidingTabStrip, int paramInt, boolean paramBoolean)
    {
        this.e = paramPagerSlidingTabStrip;
        this.e.delegatePageListener = this;
        this.h = (-paramInt);
        this.f = true;
    }

    public final void a(_H paramh)
    {
        this.n = paramh;
    }

    public final void b(int paramInt)
    {
    }

    public void onPageScrollStateChanged(int paramInt)
    {
    }

    public void onPageScrolled(int paramInt1, float paramFloat, int paramInt2)
    {
        if (paramInt2 > 0)
        {
            paramInt2 = this.i.getCurrentItem();
            localObject = this.j.a();
            if (paramInt1 >= paramInt2)
                break label70;
        }
        label70: for (Object localObject = (i)((SparseArrayCompat)localObject).valueAt(paramInt1); b; localObject = (i)((SparseArrayCompat)localObject).valueAt(paramInt1 + 1))
        {
            ((ScrollTabHolder._I)localObject).b(this.d.getHeight() - this.l);
            this.d.postInvalidate();
            return;
        }
        ((ScrollTabHolder._I)localObject).b((int)(this.d.getHeight() + this.d.getTranslationY()));
    }

    public void onPageSelected(int paramInt)
    {
        if (this.n != null)
        {
            this.n.a(paramInt, a);
            a = 1;
        }
        ScrollTabHolder._I locali = (ScrollTabHolder._I)this.j.a().valueAt(paramInt);
        if (locali != null)
        {
            if (b)
            {
                locali.b(this.d.getHeight() - this.l);
                this.d.postInvalidate();
            }
        }
        else
            return;
        locali.b((int)(this.d.getHeight() + this.d.getTranslationY()));
    }

    public interface _H
    {
        public void a(int paramInt1, int paramInt2);
    }
}
