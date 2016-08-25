package com.jingdong.app.mall.utils.ui.view;

import android.support.v4.view.ViewPager;
import android.widget.FrameLayout;
import android.widget.ImageView;

import com.jingdong.app.mall.home.floor.b.IFloorFigureView;

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
    private int g = 2130839424;
    private int h = 2130839423;
    private int i;
    private long j = -1L;
    private final int k = 4000;
    private final int l = 2000;
    private boolean m;
    private boolean n;
    private boolean o;
    private String p;
    private Handler q = new m(this);
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

    private void b(int paramInt)
    {
        monitorenter;
        try
        {
            if (this.a != null)
            {
                boolean bool = this.n;
                if (bool)
                    break label21;
            }
            while (true)
            {
                return;
                label21: this.j = System.currentTimeMillis();
                Message localMessage = Message.obtain();
                localMessage.what = this.a.getCurrentItem();
                localMessage.obj = Long.valueOf(this.j);
                this.q.sendMessageDelayed(localMessage, paramInt);
            }
        }
        finally
        {
            monitorexit;
        }
        throw localObject;
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

    public final void a(int paramInt)
    {
        int i1 = 0;
        if (Log.D)
            Log.d("CarouselFigureView", " -->> createCursor size = " + paramInt);
        if (paramInt <= 0)
            setVisibility(8);
        do
        {
            return;
            if (getVisibility() == 8)
                setVisibility(0);
            if (paramInt < 2)
            {
                this.c.setVisibility(8);
                return;
            }
            if (this.c.getVisibility() == 8)
                this.c.setVisibility(0);
            this.c.removeAllViews();
            LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(this.d, this.e);
            localLayoutParams.gravity = 17;
            localLayoutParams.setMargins(0, 0, this.f, 0);
            while ((i1 < paramInt) && (paramInt > 1))
            {
                SimpleDraweeView localSimpleDraweeView = new SimpleDraweeView(this.b);
                localSimpleDraweeView.setLayoutParams(localLayoutParams);
                localSimpleDraweeView.setScaleType(ImageView.ScaleType.CENTER);
                localSimpleDraweeView.setImageResource(this.h);
                this.c.addView(localSimpleDraweeView);
                i1 += 1;
            }
            c(this.a.a(this.a.getCurrentItem()));
        }
        while (this.c.getParent() != null);
        addView(this.c);
    }

    public final void a(l paraml)
    {
        if ((this.b != null) && (this.a != null) && (paraml != null))
            this.b.post(new n(this, paraml));
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
        {
            this.a = new CarouselFigureViewPager(paramBaseActivity);
            paramBaseActivity = new FrameLayout.LayoutParams(-1, paramInt1);
            paramBaseActivity.setMargins(0, 0, 0, 0);
            this.a.setLayoutParams(paramBaseActivity);
            this.a.setOnPageChangeListener(this);
            addView(this.a);
        }
        if (this.c == null)
        {
            this.c = new LinearLayout(getContext());
            paramBaseActivity = new FrameLayout.LayoutParams(-2, -2);
            if (paramInt2 <= 0)
                break label167;
        }
        while (true)
        {
            paramBaseActivity.setMargins(0, 0, 0, paramInt2);
            paramBaseActivity.gravity = 81;
            this.c.setPadding(0, 0, 0, 0);
            this.c.setOrientation(0);
            this.c.setLayoutParams(paramBaseActivity);
            this.a.a(paramViewGroup, true);
            return;
            label167: paramInt2 = DPIUtil.dip2px(6.0F);
        }
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
        if ((paramBaseEvent.getMessage() != null) && (!TextUtils.isEmpty(this.p)) && (!this.p.equals(paramBaseEvent.getMessage())));
        do
            while (true)
            {
                return;
                String str = paramBaseEvent.getType();
                int i1 = -1;
                switch (str.hashCode())
                {
                    default:
                    case -1116667178:
                    case -2086537376:
                    case 741540253:
                    case -197254141:
                }
                while (true)
                    switch (i1)
                    {
                        default:
                            return;
                        case 0:
                        case 1:
                            a();
                            return;
                        if (!str.equals("channel_module_on_scroll"))
                            continue;
                        i1 = 0;
                        continue;
                        if (!str.equals("channel_module_onpause"))
                            continue;
                        i1 = 1;
                        continue;
                        if (!str.equals("channel_module_scroll_stop"))
                            continue;
                        i1 = 2;
                        continue;
                        if (!str.equals("channel_module_onresume"))
                            continue;
                        i1 = 3;
                        case 2:
                        case 3:
                    }
                if (!(paramBaseEvent instanceof b))
                    continue;
                if ((this.r) || (this.s == null))
                    break;
                if (!a(((b)paramBaseEvent).b(), ((b)paramBaseEvent).c(), this.s.getTop(), this.s.getHeight()))
                    continue;
                b();
                return;
            }
        while (!a(((b)paramBaseEvent).b(), ((b)paramBaseEvent).c(), getTop(), getHeight()));
        b();
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
