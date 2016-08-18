package com.zy.app.mall.utils.ui.view;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;

import com.zy.common.utils.Log;

/**
 * Created by Robin on 2016/6/17.
 */
public class CarouselFigureViewPager extends ViewPager
        implements View.OnTouchListener {
    protected boolean a = false;
    private ViewGroup b;
    private ViewPager.OnPageChangeListener c;
    private View.OnTouchListener d;
    private boolean e = true;
    private ViewPager.OnPageChangeListener f = new ViewPager.OnPageChangeListener() {//o(this);
        private float b = -1.0F;
        private float c = -1.0F;

        @Override
        public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
            if ((CarouselFigureViewPager.this.a) && (CarouselFigureViewPager.this.getAdapter() != null)) {
                final int i = CarouselFigureViewPager.synthetic_a(CarouselFigureViewPager.this, position);
                if ((positionOffset == 0.0F) && (this.b == 0.0F) && ((position == 0) || (position == CarouselFigureViewPager.this.getAdapter().getCount() - 1)))
                    CarouselFigureViewPager.this.post(new Runnable() {//p(this, i)
                        @Override
                        public void run() {
                            CarouselFigureViewPager.this.setCurrentItem(i, false);
                        }
                    });
            }
            //:cond_1
            this.b = positionOffset;
            position = CarouselFigureViewPager.this.a(position);
            if (CarouselFigureViewPager.this.c != null) {//if-eqz v1, :cond_2
                if ((CarouselFigureViewPager.this.getAdapter() != null) && (position != CarouselFigureViewPager.this.a() - 1))
                    CarouselFigureViewPager.this.c.onPageScrolled(position, positionOffset, positionOffsetPixels);
                else if (positionOffset > 0.5D)
                    CarouselFigureViewPager.this.c.onPageScrolled(0, 0.0F, 0);
                else
                    CarouselFigureViewPager.this.c.onPageScrolled(position, 0.0F, 0);

            }
            //:cond_2
            //:goto_0
            return;
        }

        @Override
        public void onPageSelected(int position) {
            position = CarouselFigureViewPager.this.a(position);
            if (this.c != position) {
                this.c = position;
                if (CarouselFigureViewPager.this.c != null)
                    CarouselFigureViewPager.this.c.onPageSelected(position);
            }
        }

        @Override
        public void onPageScrollStateChanged(int state) {
            if ((CarouselFigureViewPager.this.getAdapter() != null) && (CarouselFigureViewPager.this.a)) {
                int i = CarouselFigureViewPager.this.getCurrentItem();
                if ((state == 0) && ((i == 0) || (i == CarouselFigureViewPager.this.getAdapter().getCount() - 1))) {
                    i = CarouselFigureViewPager.synthetic_a(CarouselFigureViewPager.this, i);
                    CarouselFigureViewPager.this.setCurrentItem(i, false);
                }
            }
            if (CarouselFigureViewPager.this.c != null)
                CarouselFigureViewPager.this.c.onPageScrollStateChanged(state);
        }
    };

    private static int synthetic_a(CarouselFigureViewPager carouselFigureViewPager, int paramInt) {
        if (carouselFigureViewPager.a) {//if-eqz v1, :cond_0
            if (carouselFigureViewPager.a() > 1) {//if-le v1, v0, :cond_0
                if (paramInt == 0)//if-nez p1, :cond_1
                    paramInt = carouselFigureViewPager.a();
                else {
                    if (paramInt == carouselFigureViewPager.a() + 1)//if-ne p1, v1, :cond_0
                        return 1;
                }
            }
        }
        //:cond_0
        return paramInt;
    }

    public CarouselFigureViewPager(Context paramContext) {
        super(paramContext);
    }

    public CarouselFigureViewPager(Context paramContext, AttributeSet paramAttributeSet) {
        super(paramContext, paramAttributeSet);
    }

    public final int a() {
        if (getAdapter() == null)
            return 0;
        if ((this.a) && (getAdapter().getCount() > 3))
            return getAdapter().getCount() - 2;
        return getAdapter().getCount();
    }

    public final int a(int paramInt) {
        if (getAdapter() != null) {//if-nez v1, :cond_1
            //:cond_1
            if (this.a) {//if-eqz v1, :cond_0
                int j = a();
                if (j == 0)
                    paramInt = 0;
                else {
                    int i = (paramInt - 1) % j;
                    paramInt = i;
                    if (i < 0)
                        paramInt = i + j;
                }
            }
        } else
            paramInt = 0;
        //:cond_0
        //:goto_0
        return paramInt;
    }

    public final void a(ViewGroup paramViewGroup, boolean paramBoolean) {
        this.b = paramViewGroup;
        this.a = paramBoolean;
        super.setOnTouchListener(this);
        super.setOnPageChangeListener(this.f);
    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent paramMotionEvent) {
        switch (paramMotionEvent.getAction()) {
            case 0:
                if (this.d != null)
                    this.d.onTouch(null, paramMotionEvent);
        }
        return super.dispatchTouchEvent(paramMotionEvent);
    }

    @Override
    protected void onAttachedToWindow() {
        if (this.e)
            super.onAttachedToWindow();
        this.e = false;
    }

    @Override
    public boolean onTouch(View paramView, MotionEvent paramMotionEvent) {
        if (this.d != null)
            this.d.onTouch(paramView, paramMotionEvent);
        switch (paramMotionEvent.getAction()) {
            case 2: //:pswitch_0
                if (this.b != null)
                    this.b.requestDisallowInterceptTouchEvent(true);
                break;
            case 1: //:pswitch_1
            case 3:
                if (this.b != null)
                    this.b.requestDisallowInterceptTouchEvent(false);
                if (this.d != null)
                    this.d.onTouch(paramView, paramMotionEvent);
        }
        try {
            onTouchEvent(paramMotionEvent);
        } catch (Throwable e) {
            if (Log.E) ;
            e.printStackTrace();
        }
        return true;
    }

    @Override
    public void setAdapter(PagerAdapter paramPagerAdapter) {
        super.setAdapter(paramPagerAdapter);
        if ((this.a) && (paramPagerAdapter.getCount() > 1))
            setCurrentItem(1, false);
    }

    @Override
    public void setOnPageChangeListener(ViewPager.OnPageChangeListener paramOnPageChangeListener) {
        this.c = paramOnPageChangeListener;
    }

    @Override
    public void setOnTouchListener(View.OnTouchListener paramOnTouchListener) {
        this.d = paramOnTouchListener;
    }
}
