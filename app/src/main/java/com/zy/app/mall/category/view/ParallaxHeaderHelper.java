package com.zy.app.mall.category.view;

import android.annotation.SuppressLint;
import android.os.Build;
import android.support.v4.util.SparseArrayCompat;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.AbsListView;
import android.widget.TextView;

import com.zy.app.mall.category.adapter.ScrollTabHolderPagerAdapter;

/**
 * Created by robin on 16-8-22.
 */
@SuppressLint({"NewApi"})
public class ParallaxHeaderHelper implements ViewPager.OnPageChangeListener, NestedViewPager._B, ScrollTabHolder {
    public static int a = 1;
    private static final boolean b = (Integer.valueOf(Build.VERSION.SDK_INT).intValue() < 11);
    private static final int c = 4;
    private View mHeader;
    private PagerSlidingTabStrip e;
    private boolean f = true;
    private int mHeaderHeight;
    private int h;
    private NestedViewPager i;
    private ScrollTabHolderPagerAdapter j;
    private TextView mInfo;
    private int l = 0;
    private int m = 0;
    private _H n = null;

//    static
//    {
//        boolean bool = true;
//        a = 1;
//        c = 4;
//        if (Integer.valueOf(Build.VERSION.SDK_INT).intValue() >= 11)
//        while (true)
//        {
//            b = bool;
//            return;
//            bool = false;
//        }
//    }

    public final void a()
    {
        this.e.setViewPager(this.i);
    }

    public final void a(View header, int headerHeight)
    {
        this.mHeader = header;
        this.mHeaderHeight = headerHeight;
    }

    public final void a(AbsListView paramAbsListView, int paramInt1, int paramInt2)
    {
        View localView2;
        View localView1;
        if (this.i.getCurrentItem() == paramInt2) {//if-ne v0, p3, :cond_1
            localView2 = paramAbsListView.getChildAt(0);
            if (localView2 != null){//if-nez v0, :cond_2
                localView1 = localView2;
                if (localView2.getHeight() == 0) {//if-nez v1, :cond_4
                    localView1 = paramAbsListView.getChildAt(1);
                    if (localView1 == null)//if-nez v0, :cond_3
                    {
                        paramInt1 = 0;
                    }else
                        this.m = 1;
                }//:cond_4
                paramInt2 = paramAbsListView.getFirstVisiblePosition();
                paramInt1 = paramInt2;
                if (paramInt2 >= this.m)
                    paramInt1 = paramInt2 - this.m;
                int i1 = localView1.getTop();
                paramInt2 = 0;
                if (paramInt1 > 0)
                    paramInt2 = this.mHeaderHeight;
                paramInt1 = localView1.getHeight() * paramInt1 - i1 + paramInt2;

            }else
                paramInt1 = 0;
            //:goto_0
            if (!b){//if-eqz v1, :cond_7
                //break label191;
                if (this.mInfo != null)
                    this.mInfo.setText(String.valueOf(paramInt1));
                if (this.f)
                    this.mHeader.setTranslationY(Math.max(-paramInt1, this.h));
                else
                    this.mHeader.setTranslationY(-paramInt1);
                return;
            }
            if (this.f) //if-eqz v1, :cond_6
                this.l = (-Math.max(-paramInt1, this.h));
            else
                this.l = paramInt1;
            if (this.mInfo != null)
                this.mInfo.setText(String.valueOf(paramInt1));
            this.mHeader.scrollTo(0, this.l);
            this.mHeader.postInvalidate();
        }//:cond_1
        return;
    }

    public final void a(TextView info)
    {
        this.mInfo = info;
    }

    public final void a(NestedViewPager paramNestedViewPager, ScrollTabHolderPagerAdapter paramScrollTabHolderPagerAdapter)
    {
        this.i = paramNestedViewPager;
        this.i.setOffscreenPageLimit(c);
        this.j = paramScrollTabHolderPagerAdapter;
        this.j.a(this);
        boolean i1 = true;
        if (this.i.getAdapter() == null)
            i1 = false;
            this.i.setAdapter(paramScrollTabHolderPagerAdapter);
            this.i.a(this);
            if (i1)
                paramScrollTabHolderPagerAdapter.notifyDataSetChanged();
            return;
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
        ScrollTabHolder scrollTabHolder = null;
        if (paramInt2 > 0)
        {
            paramInt2 = this.i.getCurrentItem();
            SparseArrayCompat<ScrollTabHolder> compat = this.j.a();
            if (paramInt1 < paramInt2){
                scrollTabHolder = compat.valueAt(paramInt1);
            }else{
                scrollTabHolder = compat.valueAt(paramInt1 + 1);
            }

        }
        if(b)
        {//if-eqz v1, :cond_2
            scrollTabHolder.b(this.mHeader.getHeight() - this.l);
            this.mHeader.postInvalidate();
        }else {
            scrollTabHolder.b((int) (this.mHeader.getHeight() + this.mHeader.getTranslationY()));
        }
    }

    public void onPageSelected(int paramInt)
    {
        if (this.n != null)
        {
            this.n.a(paramInt, a);
            a = 1;
        }
        ScrollTabHolder locali = this.j.a().valueAt(paramInt);
        if (locali != null)//if-eqz v0, :cond_1
        {
            if (b)
            {//if-eqz v1, :cond_2
                locali.b(this.mHeader.getHeight() - this.l);
                this.mHeader.postInvalidate();
            }else
                locali.b((int)(this.mHeader.getHeight() + this.mHeader.getTranslationY()));
        }
        return;

    }

    public interface _H
    {
        public void a(int paramInt1, int paramInt2);
    }
}
