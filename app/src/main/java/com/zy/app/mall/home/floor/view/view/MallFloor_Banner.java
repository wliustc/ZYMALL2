package com.zy.app.mall.home.floor.view.view;

import android.content.Context;
import android.graphics.Bitmap;
import android.os.Handler;
import android.os.Message;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.Gravity;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.Scroller;

import com.facebook.drawee.view.SimpleDraweeView;
import com.jingdong.app.mall.home.floor.b.IFloorFigureView;
import com.jingdong.app.mall.utils.ui.view.CarouseFigureImagePagerAdapter;
import com.jingdong.common.utils.HttpGroup;
import com.zy.app.mall.home.JDHomeFragment;
import com.zy.app.mall.home.floor.a.b.MallFloorClickUtil;
import com.zy.app.mall.home.floor.b.NewCarouselFigureViewCtrl;
import com.zy.app.mall.home.floor.b.FloorFigureViewCtrl;
import com.zy.app.mall.home.floor.c.FloorMaiDianCtrl;
import com.zy.app.mall.home.floor.c.FloorMainDianData;
import com.zy.app.mall.home.floor.d.a.BannerFloorEngine;
import com.zy.app.mall.home.floor.d.b.MallBannerFloorPresenter;
import com.zy.app.mall.home.floor.model.entity.BannerFloorEntity;
import com.zy.app.mall.home.floor.view.baseUI.IMallBannerFloorUI;
import com.zy.app.mall.home.floor.view.baseUI.MallBaseFloor;
import com.zy.app.mall.utils.ui.view.CarouselFigureViewPager;
import com.zy.common.entity.HomeFloorNewElement;
import com.zy.common.entity.HomeFloorNewElements;
import com.zy.common.entity.HomeFloorNewModel;
import com.zy.common.utils.Log;

import java.lang.reflect.Field;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Observable;
import java.util.Observer;

/**
 * Created by Robin on 2016/6/5.
 */
public class MallFloor_Banner extends MallBaseFloor<MallBannerFloorPresenter>
        implements ViewPager.OnPageChangeListener, View.OnTouchListener, IFloorFigureView, IMallBannerFloorUI, Observer {
    private CarouselFigureViewPager mCarouselFigureViewPager;   //h
    private PagerAdapter mPagerAdapter = null;  //i
    private LinearLayout mLinearLayout;     //j
    private int mCurrentpage;   //k
    private long mCurrentTimeMillis = -1L;
    private boolean m;
    private boolean n;
    private Deque<Object> o = new ArrayDeque(2);
    private Handler mHandler = new Handler(){//v(this)

        @Override
        public void handleMessage(Message msg) {
            if (MallFloor_Banner.this.m)
                return;
            if ((MallFloor_Banner.this.mCarouselFigureViewPager == null) || (MallFloor_Banner.this.mCarouselFigureViewPager.getChildCount() <= 1) || (MallFloor_Banner.this.mCarouselFigureViewPager.getAdapter() == null) || (MallFloor_Banner.this.mCarouselFigureViewPager.getAdapter().getCount() < 2))
                return;
            try {
                long l = ((Long) msg.obj).longValue();
                if (MallFloor_Banner.this.mCurrentTimeMillis - l == 0L) {//if-nez v0, :cond_0
                    int i = msg.what;
                    if (i != MallFloor_Banner.this.mCarouselFigureViewPager.getCurrentItem())//if-eq v0, v1, :cond_5
                        i = MallFloor_Banner.this.mCarouselFigureViewPager.getCurrentItem();
                    //:goto_1
                    if (((MallBannerFloorPresenter) MallFloor_Banner.this.i()).e()) {   //if-eqz v0, :cond_4
                        if ((i == 0) && (MallFloor_Banner.this.mCarouselFigureViewPager.getCurrentItem() != 0)) {//if-eqz v0, :cond_2
                            MallFloor_Banner.this.mCarouselFigureViewPager.setCurrentItem(MallFloor_Banner.this.mCarouselFigureViewPager.a() + 1);
                            //goto/16 :goto_0
                        } else if (i == MallFloor_Banner.this.mCarouselFigureViewPager.a() + 1) {//if-ne v1, v0, :cond_3
                            MallFloor_Banner.this.mCarouselFigureViewPager.setCurrentItem(2);
                        } else
                            MallFloor_Banner.this.mCarouselFigureViewPager.setCurrentItem(i + 1);
                    } else//:cond_4
                        MallFloor_Banner.this.mCarouselFigureViewPager.setCurrentItem((i + 1) % MallFloor_Banner.this.mCarouselFigureViewPager.getAdapter().getCount());
                }
            } catch (java.lang.Exception paramMessage) {
                return;
            }
            //:cond_0
            //:goto_0
        }
    };

    public MallFloor_Banner(Context paramContext, int paramInt) {
        super(paramContext);
        ((MallBannerFloorPresenter) i()).f(paramInt);
    }

    public MallFloor_Banner(Context paramContext, AttributeSet paramAttributeSet) {
        this(paramContext, paramAttributeSet, 0);
    }

    public MallFloor_Banner(Context paramContext, AttributeSet paramAttributeSet, int paramInt) {
        super(paramContext, paramAttributeSet, paramInt);
    }

    private void e() {
        this.m = true;
        this.n = false;
        this.mHandler.removeCallbacksAndMessages(null);
    }

    private void e(int paramInt) {

        if (Log.D)
            Log.d("MallFloor_Banner", " -->> createCursor size = " + paramInt);
        if (paramInt <= 0)//if-gtz p1, :cond_2
            setVisibility(GONE);
        else {
            if (getVisibility() == GONE)
                setVisibility(VISIBLE);
            if (paramInt < 2) {
                this.mLinearLayout.setVisibility(GONE);
                return;
            } else {
                if (this.mLinearLayout.getVisibility() == GONE)
                    this.mLinearLayout.setVisibility(VISIBLE);
                this.mLinearLayout.removeAllViews();
                MallBannerFloorPresenter localc = (MallBannerFloorPresenter) i();
                LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(localc.f(), localc.g());
                layoutParams.gravity = Gravity.CENTER;//17;
                layoutParams.setMargins(0, 0, localc.h(), 0);
                for (int i1 = 0; (i1 < paramInt) && (paramInt > 1); i1++) {
                    SimpleDraweeView localSimpleDraweeView = new SimpleDraweeView(getContext());
                    localSimpleDraweeView.setLayoutParams(layoutParams);
                    localSimpleDraweeView.setScaleType(ImageView.ScaleType.CENTER);
                    localSimpleDraweeView.setImageResource(localc.i());
                    this.mLinearLayout.addView(localSimpleDraweeView);
                }
                g(this.mCarouselFigureViewPager.a(this.mCarouselFigureViewPager.getCurrentItem()));
                if (this.mLinearLayout.getParent() == null)
                    addView(this.mLinearLayout);
            }

        }
        return;
    }

    private synchronized void f(int paramInt) {
        if (this.mCarouselFigureViewPager != null) {//if-eqz v0, :cond_0
            if (((MallBannerFloorPresenter) i()).d()) {//if-nez v0, :cond_1
                this.mCurrentTimeMillis = System.currentTimeMillis();
                Message localMessage = Message.obtain();
                localMessage.what = this.mCarouselFigureViewPager.getCurrentItem();
                localMessage.obj = Long.valueOf(this.mCurrentTimeMillis);
                this.mHandler.sendMessageDelayed(localMessage, paramInt);
            }
        }
        return;
    }

    private void g(int paramInt) {
        if (this.mLinearLayout != null) {
            ImageView localImageView = (ImageView) this.mLinearLayout.getChildAt(paramInt);
            if (localImageView != null)
                localImageView.setImageResource(((MallBannerFloorPresenter) i()).j());
        }
        this.mCurrentpage = paramInt;
    }

    @Override
    public Object a(HomeFloorNewElement paramHomeFloorNewElement, int paramInt1, int paramInt2, int paramInt3, Object paramObject) {
        return null;
    }

    public final void a() {
        this.m = false;
        this.n = true;
        ((MallBannerFloorPresenter) i()).b(this.mCarouselFigureViewPager.a(this.mCarouselFigureViewPager.getCurrentItem()));
        f(((MallBannerFloorPresenter) i()).c());
    }

    @Override
    public void a(int paramInt1, int paramInt2) {
        if (this.mCarouselFigureViewPager != null) {
            if (b(paramInt1, paramInt2, getTop(), getHeight())) {//if-eqz v0, :cond_0
                this.m = false;
                this.n = true;
                ((MallBannerFloorPresenter) i()).b(this.mCarouselFigureViewPager.a(this.mCarouselFigureViewPager.getCurrentItem()));
                f(((MallBannerFloorPresenter) i()).c());
            }
        }
    }

    @Override
    public void a(int layoutHeight, int cursorMarginBottom, int scrollDuration) {
        FloorFigureViewCtrl.getInstance().addObserver(this);
        if (this.mCarouselFigureViewPager == null) {
            this.mCarouselFigureViewPager = new CarouselFigureViewPager(getContext());
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, layoutHeight);
            layoutParams.setMargins(0, 0, 0, 0);
            this.mCarouselFigureViewPager.setLayoutParams(layoutParams);
            this.mCarouselFigureViewPager.setOnPageChangeListener(this);
            this.mCarouselFigureViewPager.setOnTouchListener(this);
            addView(this.mCarouselFigureViewPager);
        }
        if (this.mLinearLayout == null) {
            this.mLinearLayout = new LinearLayout(getContext());
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
            layoutParams.setMargins(0, 0, 0, cursorMarginBottom);
            layoutParams.addRule(12);
            layoutParams.addRule(14);
            this.mLinearLayout.setPadding(0, 0, 0, 0);
            this.mLinearLayout.setOrientation(LinearLayout.HORIZONTAL);
            this.mLinearLayout.setLayoutParams(layoutParams);
        }
        this.mCarouselFigureViewPager.a(this.f, ((MallBannerFloorPresenter) i()).e());
        if (scrollDuration > 0) {
            _W localObject = new _W( this.e.thisActivity);//w(this, this.e.thisActivity)

            ((_W) localObject).a(scrollDuration);
            ((_W) localObject).a(this.mCarouselFigureViewPager);
        }
        this.mPagerAdapter = new CarouseFigureImagePagerAdapter(getContext(), true, (MallBannerFloorPresenter) i());
        if (this.mPagerAdapter != null) {
            this.mCarouselFigureViewPager.setAdapter((PagerAdapter) this.mPagerAdapter);
            e(this.mCarouselFigureViewPager.a());
            f(((MallBannerFloorPresenter) i()).c());
        }
    }


    public final synchronized void a(JDHomeFragment paramJDHomeFragment, HomeFloorNewModel paramHomeFloorNewModel, HomeFloorNewElements paramHomeFloorNewElements, ViewGroup paramViewGroup) {
        super.a(paramJDHomeFragment, paramHomeFloorNewModel, paramHomeFloorNewElements, paramViewGroup);
        new NewCarouselFigureViewCtrl().a(paramJDHomeFragment, this, paramHomeFloorNewModel.getBanner());
        return;
    }

    /*-- implements interface IFloorFigureView --*/
    @Override
    public void setFigureViewAdapterDataPresenter(CarouseFigureImagePagerAdapter.DataPresenter paraml) {
        if ((this.mCarouselFigureViewPager != null) && (paraml != null) && (paraml.size() > 0)) {
            MallBannerFloorPresenter localc = (MallBannerFloorPresenter) i();
            this.mCarouselFigureViewPager.setAdapter(new CarouseFigureImagePagerAdapter(getContext(), localc.e(), paraml));
            e(this.mCarouselFigureViewPager.a());
            f(localc.c());
        }
    }

    @Override
    public final void a(String floorId, String eventId) {
        FloorMainDianData data = new FloorMainDianData(getContext(), eventId, "", this.e);
        FloorMaiDianCtrl.getInstance().a(floorId, data);
    }


    @Override
    public void b(int paramInt1, int paramInt2) {
        super.b(paramInt1, paramInt2);
        a(paramInt1, paramInt2);
    }

    public final void c(int paramInt) {
        ((MallBannerFloorPresenter) i()).d(0);
    }

    public final void c(int paramInt1, int paramInt2, int paramInt3, int paramInt4) {
        ((MallBannerFloorPresenter) i()).a(10, 10, 10, 0);
    }

    public final void d(int paramInt) {
        ((MallBannerFloorPresenter) i()).c(1000);
    }

    public final void k() {
        super.k();
        FloorFigureViewCtrl.getInstance().addObserver(this);
    }

    @Override
    public void onClick(HomeFloorNewElement homeFloorNewElement) {
        if (!TextUtils.isEmpty(homeFloorNewElement.getClickUrl())) {
            String str = homeFloorNewElement.getClickUrl();
            HttpGroup.HttpSetting localHttpSetting = new HttpGroup.HttpSetting();
            localHttpSetting.setUrl(str);
            localHttpSetting.setPost(false);
            this.e.thisActivity.getHttpGroupaAsynPool().add(localHttpSetting);
        }
        MallFloorClickUtil.a(this.e.thisActivity, this, homeFloorNewElement.getSourceValue(), homeFloorNewElement.getParam(), homeFloorNewElement.getJump());
    }

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

    }

    @Override
    public void onPageSelected(int position) {
        int i1 = this.mCurrentpage;
        if (this.mLinearLayout != null) {
            ImageView localImageView = (ImageView) this.mLinearLayout.getChildAt(i1);
            if (localImageView != null)
                localImageView.setImageResource(((MallBannerFloorPresenter) i()).i());
        }
        g(position);
        if (this.n)
            ((MallBannerFloorPresenter) i()).b(position);
        f(((MallBannerFloorPresenter) i()).c());
    }

    @Override
    public void onPageScrollStateChanged(int state) {

    }

    @Override
    public boolean onTouch(View v, MotionEvent event) {
        switch (event.getAction()) {
            case 2: //:pswitch_0
            break;
            case 0://:pswitch_1
                if (!this.m)
                    e();
            break;
            case 1://:pswitch_2
            case 3:
                a();
                break;
        }
        return false;
    }



    @Override
    public void update(Observable observable, Object data)
    {
        if (data == FloorFigureViewCtrl.b.PAUSEALL)
            e();
        else  if (data == FloorFigureViewCtrl.b.RESUMEALL)
            a();
        return;
    }

    public final class _W extends Scroller
    {
        private int b = 2000;

        public _W( Context paramContext)
        {
            super(paramContext);
        }

        public final void a(int paramInt)
        {
            this.b = paramInt;
        }

        public final void a(ViewPager paramViewPager)
        {
            try
            {
                Field localField = ViewPager.class.getDeclaredField("mScroller");
                localField.setAccessible(true);
                localField.set(paramViewPager, this);
                return;
            }
            catch (Exception e)
            {
                e.printStackTrace();
            }
        }

        @Override
        public final void startScroll(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
        {
            super.startScroll(paramInt1, paramInt2, paramInt3, paramInt4, this.b);
        }

        @Override
        public final void startScroll(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5)
        {
            super.startScroll(paramInt1, paramInt2, paramInt3, paramInt4, this.b);
        }
    }

    ///////////////////////////////////////////////////////////////////////////////////////////////
    //.method protected final synthetic h()Lcom/jingdong/app/mall/home/floor/d/b/d;
    //.locals 3
    //
    //        .prologue
    //        .line 55
    //        new-instance v0, Lcom/jingdong/app/mall/home/floor/d/b/c;
    //
    //      const-class v1, Lcom/jingdong/app/mall/home/floor/model/entity/BannerFloorEntity;
    //
    //      const-class v2, Lcom/jingdong/app/mall/home/floor/d/a/b;
    //
    //      invoke-direct {v0, v1, v2}, Lcom/jingdong/app/mall/home/floor/d/b/c;-><init>(Ljava/lang/Class;Ljava/lang/Class;)V
    //
    //      return-object v0
    //.end method
    ///////////////////////////////////////////////////////////////////////////////////////////////
    @Override
    protected MallBannerFloorPresenter h() {
        return new MallBannerFloorPresenter(BannerFloorEntity.class, BannerFloorEngine.class);
    }
}
