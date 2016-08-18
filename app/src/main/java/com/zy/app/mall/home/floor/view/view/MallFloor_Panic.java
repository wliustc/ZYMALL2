package com.zy.app.mall.home.floor.view.view;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Handler;
import android.os.Looper;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.facebook.common.soloader.SoLoaderShim;
import com.facebook.drawee.view.SimpleDraweeView;
import com.jingdong.app.mall.home.ScrollStopListener;
import com.jingdong.app.mall.miaosha.MiaoShaActivity;
import com.jingdong.app.mall.utils.CommonUtil;
import com.jingdong.app.mall.utils.StartActivityUtils;
import com.jingdong.common.entity.Product;
import com.zy.app.mall.R;
import com.zy.app.mall.home.floor.a.a.Constants;
import com.zy.app.mall.home.floor.d.a.PanicFloorEngine;
import com.zy.app.mall.home.floor.d.b.MallPanicFloorPresenter;
import com.zy.app.mall.home.floor.model.entity.PanicFloorEntity;
import com.zy.app.mall.home.floor.view.adapter.MallListItemPagerAdapter;
import com.zy.app.mall.home.floor.view.adapter.MallPanicFloorAdapter;
import com.zy.app.mall.home.floor.view.baseUI.IMallPanicFloorUI;
import com.zy.app.mall.home.floor.view.baseUI.MallBaseFloor;
import com.zy.app.mall.utils.ui.view.DateDrawable;
import com.zy.app.mall.utils.ui.view.HomeViewPager;
import com.zy.common.entity.HomeFloorNewElement;
import com.zy.common.entity.SourceEntity;
import com.zy.common.utils.ImageUtil;
import com.zy.common.utils.JDMtaUtils;
import com.zy.common.utils.Log;

/**
 * Created by Robin on 2016/6/22.
 */
public class MallFloor_Panic extends MallBaseFloor<MallPanicFloorPresenter> implements IMallPanicFloorUI {

    private ScrollStopListener h = null;
    private boolean i = false;
    private HomeViewPager j = null;
    private Handler mHandler = new Handler(Looper.getMainLooper());

    public MallFloor_Panic(Context context) {
        super(context);
    }

    public MallFloor_Panic(Context paramContext, AttributeSet paramAttributeSet) {
        super(paramContext, paramAttributeSet);
    }

    public MallFloor_Panic(Context paramContext, AttributeSet paramAttributeSet, int paramInt) {
        super(paramContext, paramAttributeSet, paramInt);
    }

    private void a(View paramView) {
        RelativeLayout relativeLayout = (RelativeLayout) paramView.findViewById(R.id.layout_limit_buy_time);//2131165816
        SimpleDraweeView localSimpleDraweeView = new SimpleDraweeView(getContext());
        DateDrawable dateDrawable = new DateDrawable();
        Object localObject = (MallPanicFloorPresenter) i();
        ((MallPanicFloorPresenter) localObject).a(dateDrawable);
        MallPanicFloorPresenter.c(dateDrawable);
        localSimpleDraweeView.setImageDrawable(dateDrawable);
        localObject = new RelativeLayout.LayoutParams(((MallPanicFloorPresenter) localObject).M(), ((MallPanicFloorPresenter) localObject).N());
        ((RelativeLayout.LayoutParams) localObject).addRule(CENTER_IN_PARENT, TRUE);
        relativeLayout.setGravity(Gravity.CENTER | Gravity.AXIS_PULL_BEFORE);//19
        relativeLayout.addView(localSimpleDraweeView, (ViewGroup.LayoutParams) localObject);
        try {
            i().b(dateDrawable);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private synchronized View b(int paramInt1, int paramInt2, int paramInt3) {
        if (i().b())
            return null;
        if (this.j == null) {
            this.j = new HomeViewPager(getContext(), this.f);
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, paramInt1);
            layoutParams.setMargins(layoutParams.leftMargin, paramInt2, layoutParams.rightMargin, 0);
            this.j.setLayoutParams((ViewGroup.LayoutParams) layoutParams);
            this.j.setOnPageChangeListener(new ViewPager.OnPageChangeListener(){//aa(this)
                private boolean b;
                private int c;
                private int d = 0;
                @Override
                public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
                    if (MallFloor_Panic.this.j.getAdapter() != null) {
                        if ((position != MallFloor_Panic.this.j.getAdapter().getCount() - 4) || (positionOffset <= 0.25D) || (positionOffsetPixels < this.c))
                            this.b = true;
                        else
                            this.b = false;
                    }
                    this.c = positionOffsetPixels;
                    return;
                }

                @Override
                public void onPageSelected(int position) {
                    if (position >= MallFloor_Panic.this.j.getAdapter().getCount() - 3)
                        MallFloor_Panic.this.j.setCurrentItem(MallFloor_Panic.this.j.getAdapter().getCount() - 4);
                }

                @Override
                public void onPageScrollStateChanged(int state) {
                    if ((this.b) && ((state == 2) || (state == 0)))
                    {
                        this.b = false;
                        MallFloor_Panic.this.i().j();
                    }
                    if ((state != 0) && (this.d == 0))
                        MallFloor_Panic.this.a("Home_Seckill_Slide", MallFloor_Panic.this.i().a(false));
                    this.d = state;
                }
            });
        }
        MallPanicFloorAdapter adapter = new MallPanicFloorAdapter(getContext(), i());
        adapter.a(i());
        this.j.setAdapter(adapter);
        return this.j;
    }

    private Intent o() {
        Intent localIntent = new Intent(getContext(), MiaoShaActivity.class);
        localIntent.putExtra("source", new SourceEntity("indexMiaoShaArea", ""));
        localIntent.putExtra("com.360buy:navigationDisplayFlag", -1);
        localIntent.putExtra("com.360buy:clearHistoryFlag", true);
        return localIntent;
    }

    public final Object a(HomeFloorNewElement paramHomeFloorNewElement, int paramInt1, int paramInt2, int paramInt3, Object paramObject) {
        return null;
    }

    public final void a() {
        if ((this.j != null) && (this.j.getAdapter() != null))
            this.j.getAdapter().notifyDataSetChanged();
        setBackgroundColor(0xFFFFFFFF);
        if (Log.D)
            Log.d("MallFloor_Panic", " -->> init()");
    }

    public final void a(final int paramInt1, final int paramInt2, final int paramInt3) {
        removeAllViews();
        ((MallPanicFloorPresenter) i()).a();
        if ((MallFloor_Panic.this.j != null) && (MallFloor_Panic.this.j.getAdapter() != null))
            MallFloor_Panic.this.j.getAdapter().notifyDataSetChanged();
        setVisibility(INVISIBLE);
        View localView1 = b(paramInt1, paramInt2, paramInt3);
        Object localObject1;
        View localView2;
        Object localObject2;
        TextView localTextView;
        if (localView1 != null) {   //if-eqz v3, :cond_2
            localObject1 = (MallPanicFloorPresenter) i();
            localView2 = ImageUtil.inflate(R.layout.app_home_limit_buy_shheader, null);   //2130903155
            ((RelativeLayout) localView2.findViewById(R.id.rlHomeLimitBySHHeader)).setOnClickListener(new View.OnClickListener() {//ab(this) //2131165814
                @Override
                public void onClick(View v) {
                    MallFloor_Panic.this.n();
                }
            });
            localObject2 = (TextView) localView2.findViewById(R.id.tv_limit_buy);   //2131165815
            localTextView = (TextView) localView2.findViewById(R.id.app_limit_buy_header_more);  //2131165817
            View localView3 = localView2.findViewById(R.id.home_miaosha_arrow);  //2131165818
            ((TextView) localObject2).setText(((MallPanicFloorPresenter) localObject1).p() + " · " + ((MallPanicFloorPresenter) localObject1).L());
            ((TextView) localObject2).getPaint().setFakeBoldText(true);
            if (!((MallPanicFloorPresenter) localObject1).q()) {//if-nez v1, :cond_3
                localTextView.setVisibility(GONE);
                localView3.setVisibility(GONE);
            } else {
                localTextView.setText(((MallPanicFloorPresenter) localObject1).r());
                localTextView.setOnClickListener(new View.OnClickListener() {//ac(this)
                    @Override
                    public void onClick(View v) {
                        MallFloor_Panic.this.n();
                    }
                });
            }
            //:goto_0
            a(localView2);
            localObject2 = new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.MATCH_PARENT, RelativeLayout.LayoutParams.WRAP_CONTENT);
            ((RelativeLayout.LayoutParams) localObject2).leftMargin = ((MallPanicFloorPresenter) localObject1).t();
            ((RelativeLayout.LayoutParams) localObject2).topMargin = ((MallPanicFloorPresenter) localObject1).u();
            localView2.setLayoutParams((ViewGroup.LayoutParams) localObject2);
            addView(localView2);
            if ((localView2 != null) && (localView1 != null)) {
                localObject2 = localView1.getLayoutParams();
                localObject1 = localObject2;
                if (localObject2 == null)
                    localObject1 = new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.MATCH_PARENT, RelativeLayout.LayoutParams.WRAP_CONTENT);
                if (localObject1 instanceof RelativeLayout.LayoutParams) {//if-eqz v1, :cond_1
                    localObject1 = (RelativeLayout.LayoutParams) localObject1;
                    ((RelativeLayout.LayoutParams) localObject1).addRule(BELOW, localView2.getId());
                    localView1.setLayoutParams((ViewGroup.LayoutParams) localObject1);
                }
            }
        }
        addView(localView1);
        requestLayout();
        setVisibility(VISIBLE);
        return;
    }

    public final void a(Product paramProduct, boolean paramBoolean) {
        if (CommonUtil.getInstance().isCanClick()) {//if-nez v0, :cond_1
            if (paramBoolean) {
                StartActivityUtils.a(this.e.thisActivity, paramProduct.getId(), paramProduct.getName(), new SourceEntity("indexMiaoShaArea", ""));
                return;
            }
            a(paramProduct.getId());
            try {
                JDMtaUtils.sendCommonData(this.e.thisActivity, "Home_HandSeckill", paramProduct.getSourceValue(), "", this.e, "", MiaoShaActivity.class, "", Constants.b);
                return;
            } catch (Exception e) {
                if (Log.D)
                e.printStackTrace();
            }
        }
        return;

    }

    public final void a(Long paramLong) {
        Intent localIntent = o();
        localIntent.putExtra("productId", paramLong);
        this.e.thisActivity.startActivity(localIntent);
    }

    public final void a(String paramString1, String paramString2) {
        JDMtaUtils.sendCommonData(getContext(), paramString1, paramString2, "", this.e, "", MiaoShaActivity.class, "", Constants.b);
    }

    public final void a(boolean paramBoolean) {
        int k = VISIBLE;
        if (!paramBoolean)
            k = GONE;
        if ((getVisibility() == VISIBLE) ^ paramBoolean)
            setVisibility(k);
        return;
    }

    @Override
    protected MallPanicFloorPresenter h() {
        return new MallPanicFloorPresenter(PanicFloorEntity.class, PanicFloorEngine.class);
    }

    public final void e() {
        if (this.h != null)
            return;
        this.h = new ScrollStopListener(){};//z(this);
    }

    public final void f() {
        Intent localIntent = o();
        getContext().startActivity(localIntent);
    }

    public final void g() {
        Intent localIntent = new Intent(getContext(), MiaoShaActivity.class);
        localIntent.putExtra(MiaoShaActivity.a, MiaoShaActivity.c);
        this.e.thisActivity.startActivity(localIntent);
    }

    protected final void n() {
        if (!CommonUtil.getInstance().isCanClick())
            return;
        MallPanicFloorPresenter locall = i();
        if (locall.D())
            g();
        else
            f();
        try {
            a("Home_SeckillWord", locall.a(true));
        } catch (Exception localException) {
            if (Log.D)
                localException.printStackTrace();
        }
        return;
    }

}
