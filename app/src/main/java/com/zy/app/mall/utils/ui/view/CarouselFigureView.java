package com.zy.app.mall.utils.ui.view;

import android.content.Context;
import android.os.Handler;
import android.os.Message;
import android.support.v4.view.ViewPager;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.facebook.drawee.view.SimpleDraweeView;
import com.jingdong.app.mall.home.floor.b.IFloorFigureView;
import com.jingdong.app.mall.utils.ui.view.CarouseFigureImagePagerAdapter;
import com.zy.app.mall.R;
import com.zy.cleanmvp.common.BaseEvent;
import com.zy.common.BaseActivity;
import com.zy.common.channel.common.a.ChannelEvent;
import com.zy.common.utils.DPIUtil;
import com.zy.common.utils.Log;

import org.greenrobot.eventbus.EventBus;

/**
 * Created by robin on 16-8-25.
 */
public class CarouselFigureView extends FrameLayout
        implements ViewPager.OnPageChangeListener, IFloorFigureView {
    protected CarouselFigureViewPager a;
    private BaseActivity b;
    private LinearLayout c;
    private int d = DPIUtil.dip2px(13.0F);
    private int e = DPIUtil.dip2px(13.0F);
    private int f = DPIUtil.dip2px(7.0F);
    private int g = R.drawable.icon_gallery_point_white;//2130839424
    private int h = R.drawable.icon_gallery_point_grey;//2130839423
    private int i;
    private long j = -1L;
    private final int k = 4000;
    private final int l = 2000;
    private boolean m;
    private boolean n;
    private boolean o;
    private String p;
    private Handler q = new Handler(){//m(this)
        @Override
        public void handleMessage(Message msg) {
            if (!CarouselFigureView.this.o) {//if-eqz v0, :cond_1
                if ((CarouselFigureView.this.a != null) && (CarouselFigureView.this.a.getChildCount() > 1) && (CarouselFigureView.this.a.getAdapter() != null) && (CarouselFigureView.this.a.getAdapter().getCount() >= 2)){
                    long l = 0;
                    try
                    {
                        l = ((Long)msg.obj).longValue();
                    }
                    catch (java.lang.Exception paramMessage)
                    {
                    }
                    if (CarouselFigureView.this.j - l == 0L){
                        int i = msg.what;
                        if (CarouselFigureView.this.m)
                        {
                            if ((i == 0) && (CarouselFigureView.this.a.getCurrentItem() != 0))
                            {
                                CarouselFigureView.this.a.setCurrentItem(CarouselFigureView.this.a.a() + 1);
                            }else if (i == CarouselFigureView.this.a.a() + 1)
                            {
                                CarouselFigureView.this.a.setCurrentItem(2);
                            }else {
                                CarouselFigureView.this.a.setCurrentItem(i + 1);
                            }
                        }
                        CarouselFigureView.this.a.setCurrentItem((i + 1) % CarouselFigureView.this.a.getAdapter().getCount());
                    }
                }
            }
            return;
        }
    };

    private boolean r = true;
    private View s;

    public CarouselFigureView(Context paramContext)
    {
        super(paramContext);
    }

    public CarouselFigureView(Context paramContext, AttributeSet paramAttributeSet)
    {
        super(paramContext, paramAttributeSet);
    }

    private static boolean a(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
    {
        return (paramInt1 <= paramInt3 + paramInt4) && (paramInt1 >= paramInt3 - paramInt2);
    }

    private synchronized void b(int paramInt) {

        if (this.a != null) {//if-eqz v0, :cond_0
            boolean bool = this.n;
            if (bool) {//if-nez v0, :cond_1
                this.j = System.currentTimeMillis();
                Message localMessage = Message.obtain();
                localMessage.what = this.a.getCurrentItem();
                localMessage.obj = Long.valueOf(this.j);
                this.q.sendMessageDelayed(localMessage, paramInt);
            }
        }
        return;
    }

    private void c(int paramInt)
    {
        if (this.c != null)
        {
            ImageView localImageView = (ImageView)this.c.getChildAt(paramInt);
            if (localImageView != null)
                localImageView.setImageResource(this.g);
        }
        this.i = paramInt;
    }

    public final void a()
    {
        this.j = System.currentTimeMillis();
        this.o = true;
    }

    public final void a(int paramInt) {

        if (Log.D)
            Log.d("CarouselFigureView", " -->> createCursor size = " + paramInt);
        if (paramInt <= 0)//if-gtz p1, :cond_2
            setVisibility(View.GONE);
        else {
            if (getVisibility() == View.GONE)
                setVisibility(View.VISIBLE);
            if (paramInt < 2) {
                this.c.setVisibility(View.GONE);
                return;
            }
            if (this.c.getVisibility() == View.GONE)
                this.c.setVisibility(View.VISIBLE);
            this.c.removeAllViews();
            LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(this.d, this.e);
            localLayoutParams.gravity = Gravity.CENTER;
            localLayoutParams.setMargins(0, 0, this.f, 0);
            for (int i1 = 0; (i1 < paramInt) && (paramInt > 1); i1++) {
                SimpleDraweeView localSimpleDraweeView = new SimpleDraweeView(this.b);
                localSimpleDraweeView.setLayoutParams(localLayoutParams);
                localSimpleDraweeView.setScaleType(ImageView.ScaleType.CENTER);
                localSimpleDraweeView.setImageResource(this.h);
                this.c.addView(localSimpleDraweeView);
            }
            c(this.a.a(this.a.getCurrentItem()));
            if (this.c.getParent() == null)
                addView(this.c);
        }
        return;
    }

    @Override
    public final void setFigureViewAdapterDataPresenter(final CarouseFigureImagePagerAdapter.DataPresenter paraml)
    {
        if ((this.b != null) && (this.a != null) && (paraml != null))
            this.b.post(new Runnable(){//n(this, paraml)
                @Override
                public void run() {
                    CarouselFigureView.this.a.setAdapter(new CarouseFigureImagePagerAdapter(CarouselFigureView.this.b, CarouselFigureView.this.m, paraml));
                    CarouselFigureView.this.a(CarouselFigureView.this.a.a());
                    CarouselFigureView.this.b(4000);
                }
            });
    }

    public final void a(BaseActivity paramBaseActivity, ViewGroup paramViewGroup, int paramInt)
    {
        a(paramBaseActivity, paramViewGroup, paramInt, true, true, 0);
    }

    public final void a(BaseActivity paramBaseActivity, ViewGroup paramViewGroup, int paramInt1, boolean paramBoolean1, boolean paramBoolean2, int paramInt2)
    {
        this.b = paramBaseActivity;
        this.m = true;
        this.n = true;
        if (this.a == null)
        {//if-nez v0, :cond_0
            this.a = new CarouselFigureViewPager(paramBaseActivity);
            LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, paramInt1);
            layoutParams.setMargins(0, 0, 0, 0);
            this.a.setLayoutParams(layoutParams);
            this.a.setOnPageChangeListener(this);
            addView(this.a);
        }
        if (this.c == null) {//if-nez v0, :cond_1
            this.c = new LinearLayout(getContext());
            LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
            if (paramInt2 <= 0) {//if-lez p6, :cond_2
                paramInt2 = DPIUtil.dip2px(6.0F);
            }
            layoutParams.setMargins(0, 0, 0, paramInt2);
            layoutParams.gravity = Gravity.BOTTOM | Gravity.CENTER_HORIZONTAL;//81;
            this.c.setPadding(0, 0, 0, 0);
            this.c.setOrientation(LinearLayout.HORIZONTAL);//0
            this.c.setLayoutParams(layoutParams);
        }
            this.a.a(paramViewGroup, true);
            return;
    }

    public final void a(boolean paramBoolean, View paramView)
    {
        this.r = false;
        this.s = paramView;
    }

    public final void a_(String paramString)
    {
        this.p = paramString;
    }

    public final void b()
    {
        this.o = false;
        b(2000);
    }

    protected void onAttachedToWindow()
    {
        super.onAttachedToWindow();
        if (!EventBus.getDefault().isRegistered(this))
            EventBus.getDefault().register(this);
    }

    protected void onDetachedFromWindow()
    {
        super.onDetachedFromWindow();
        EventBus.getDefault().unregister(this);
    }

    public void onEventMainThread(BaseEvent paramBaseEvent)
    {
        if ((paramBaseEvent.getMessage() == null) || (TextUtils.isEmpty(this.p)) || (this.p.equals(paramBaseEvent.getMessage()))){
            String str = paramBaseEvent.getType();
            int i1 = -1;
            switch (str.hashCode())
            {
                default:
                case -1116667178://:sswitch_0
                    if (str.equals("channel_module_on_scroll"))//if-eqz v1, :cond_2
                        i1 = 0;
                    break;
                case -2086537376://:sswitch_1
                    if (str.equals("channel_module_onpause"))
                        i1 = 1;
                    break;
                case 741540253: //:sswitch_2
                    if (str.equals("channel_module_scroll_stop"))
                        i1 = 2;
                    break;
                case -197254141://:sswitch_3
                    if (str.equals("channel_module_onresume"))
                        i1 = 3;
                    break;
            }
            //:cond_2
            //:goto_1
            switch (i1)
            {
                case 0://:pswitch_0
                case 1://:pswitch_0
                    a();
                    return;
                case 2://:pswitch_1
                case 3://:pswitch_1
                    if (paramBaseEvent instanceof ChannelEvent){//if-eqz v0, :cond_0
                        if ((!this.r) && (this.s != null)){//if-nez v0, :cond_3 if-eqz v0, :cond_3
                            if (a(((ChannelEvent)paramBaseEvent).b(), ((ChannelEvent)paramBaseEvent).c(), this.s.getTop(), this.s.getHeight()))//if-eqz v0, :cond_0
                                b();
                        }else {//:cond_3
                            if (a(((ChannelEvent)paramBaseEvent).b(), ((ChannelEvent)paramBaseEvent).c(), getTop(), getHeight()))//if-eqz v0, :cond_0
                                b();
                        }
                    }
            }
        }
        return;
    }

    public void onPageScrollStateChanged(int paramInt)
    {
    }

    public void onPageScrolled(int paramInt1, float paramFloat, int paramInt2)
    {
    }

    public void onPageSelected(int paramInt)
    {
        int i1 = this.i;
        if (this.c != null)
        {
            ImageView localImageView = (ImageView)this.c.getChildAt(i1);
            if (localImageView != null)
                localImageView.setImageResource(this.h);
        }
        c(paramInt);
        b(4000);
    }


}
