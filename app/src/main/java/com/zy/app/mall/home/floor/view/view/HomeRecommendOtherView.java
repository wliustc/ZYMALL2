package com.zy.app.mall.home.floor.view.view;

import android.content.Context;
import android.content.Intent;
import android.graphics.Rect;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.facebook.drawee.view.SimpleDraweeView;
import com.jingdong.app.mall.home.floor.b.FloorImageLoadCtrl;
import com.jingdong.common.sample.jshop.JshopMainShopActivity;
import com.zy.app.mall.R;
import com.zy.app.mall.home.JDHomeFragment;
import com.zy.app.mall.home.floor.a.a.Constants;
import com.zy.app.mall.home.floor.model.entity.HomeDNAEntity;
import com.zy.app.mall.home.floor.model.entity.HomeProductEntity;
import com.zy.app.mall.home.floor.model.entity.HomeRecommendEntity;
import com.zy.app.mall.home.floor.model.entity.HomeShopEntity;
import com.zy.app.mall.home.floor.view.view.DragFloatView;
import com.zy.common.channel.common.utils.JumpUtil;
import com.zy.common.utils.DPIUtil;
import com.zy.common.utils.ImageUtil;
import com.zy.common.utils.JDImageUtils;
import com.zy.common.utils.JDMtaUtils;
import com.zy.common.utils.Log;

import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Robin on 2016/6/19.
 */
public class HomeRecommendOtherView extends ViewGroup {
    private final int a = (DPIUtil.getWidth() - DPIUtil.dip2px(14.0F)) / 2;
    private final int b = this.a * 504 / 346;
    private List<SimpleDraweeView> c;
    private List<Rect> d;
    private List<Rect> e;
    private Rect f;
    private Rect g;
    private Rect h;
    private LinearLayout i;
    private LinearLayout j;
    private LinearLayout k;
    private SimpleDraweeView l;
    private LinearLayout m;
    private TextView n;
    private TextView o;
    private TextView p;
    private TextView q;
    private TextView r;
    private TextView s;
    private int t;
    private int u;

    public HomeRecommendOtherView(Context paramContext) {
        super(paramContext);
        ImageUtil.inflate(paramContext, R.layout.home_recommend_other_view, this);  //2130903593
        a();
        b();
    }

    public HomeRecommendOtherView(Context paramContext, AttributeSet paramAttributeSet) {
        super(paramContext, paramAttributeSet);
        ImageUtil.inflate(paramContext, R.layout.home_recommend_other_view, this);  //2130903593
        a();
        b();
    }

    public HomeRecommendOtherView(Context paramContext, AttributeSet paramAttributeSet, int paramInt) {
        super(paramContext, paramAttributeSet, paramInt);
        ImageUtil.inflate(paramContext, R.layout.home_recommend_other_view, this);  //2130903593
        a();
        b();
    }

    private void a() {
        this.c = new ArrayList();

        for (int i1 = 0; i1 < 4; i1++) {
            SimpleDraweeView draweeView = new SimpleDraweeView(getContext());
            addView((View) draweeView, i1);
            this.c.add(draweeView);

        }
        this.i = ((LinearLayout) findViewById(R.id.home_other_shop_layout));  //2131168497
        this.j = ((LinearLayout) findViewById(R.id.home_other_dna_layout));  //2131168504
        Object localObject = new LinearLayout.LayoutParams(this.a, -2);
        this.j.setLayoutParams((ViewGroup.LayoutParams) localObject);
        this.l = ((SimpleDraweeView) findViewById(R.id.home_other_big_img));  //2131168496
        this.n = ((TextView) findViewById(R.id.home_other_shop_name));      //2131168498
        this.n.setMaxWidth(this.a - DPIUtil.dip2px(20.0F));
        this.o = ((TextView) findViewById(R.id.home_other_shop_follow));      //2131168499
        this.p = ((TextView) findViewById(R.id.home_other_shop_self));      //2131168500
        this.q = ((TextView) findViewById(R.id.home_other_shop_enter));      //2131168506
        this.k = ((LinearLayout) findViewById(R.id.home_other_dna_name_layout));  //2131168501
        this.r = ((TextView) findViewById(R.id.home_other_dna_name));      //2131168502
        this.s = ((TextView) findViewById(R.id.home_other_dna_description));      //2131168505
        this.m = ((LinearLayout) findViewById(R.id.home_other_bottom_layout));  //2131168503
    }

    private void a(List<HomeProductEntity> paramList, int paramInt1, int paramInt2) {
        if ((paramList != null) && (this.c != null) && (this.c.size() >= paramInt2)) {
            //:goto_0
            while (paramInt1 < paramInt2) {//if-ge p2, p3, :cond_1
                if ((paramList.size() > paramInt1) && (!TextUtils.isEmpty(((HomeProductEntity) paramList.get(paramInt1)).getImageUrl())))
                    FloorImageLoadCtrl.b((ImageView) this.c.get(paramInt1), ((HomeProductEntity) paramList.get(paramInt1)).getImageUrl());
                else {
                    ((SimpleDraweeView) this.c.get(paramInt1)).setImageBitmap(null);
                    ((SimpleDraweeView) this.c.get(paramInt1)).setTag(R.id.image_last_url, null);//2131165370
                }
                paramInt1 += 1;
            }
        }//:cond_1
    }

    private void b() {
        int i1 = this.a;
        this.d = new ArrayList();
        int i2 = DPIUtil.getWidthByDesignValue720(190);
        int i3 = DPIUtil.getWidthByDesignValue720(63);
        int i4 = (i1 - i2) / 2;
        int i5 = DPIUtil.getWidthByDesignValue720(64);
        Rect localRect = new Rect(i4, i5, i2 + i4, i3 + i5);
        this.d.add(localRect);
        i2 = (i1 - 2) / 2;
        i3 = DPIUtil.getWidthByDesignValue720(254);
        localRect = new Rect(0, i3, i2 + 0, i3 + i2);
        this.d.add(localRect);
        localRect = new Rect(i2 + 2, i3, i1, i2 + i3);
        this.d.add(localRect);
        this.e = new ArrayList();
        i1 = DPIUtil.getWidthByDesignValue720(62);
        i2 = DPIUtil.getWidthByDesignValue720(54);
        i3 = DPIUtil.getWidthByDesignValue720(152);
        localRect = new Rect(i2, i3, i2 + i1, i1 + i3);
        this.e.add(localRect);
        i1 = DPIUtil.getWidthByDesignValue720(78);
        i2 = DPIUtil.getWidthByDesignValue720(192);
        i3 = DPIUtil.getWidthByDesignValue720(111);
        localRect = new Rect(i2, i3, i2 + i1, i1 + i3);
        this.e.add(localRect);
        i1 = DPIUtil.getWidthByDesignValue720(72);
        i2 = DPIUtil.getWidthByDesignValue720(32);
        i3 = DPIUtil.getWidthByDesignValue720(305);
        localRect = new Rect(i2, i3, i2 + i1, i1 + i3);
        this.e.add(localRect);
        i1 = DPIUtil.getWidthByDesignValue720(86);
        i2 = DPIUtil.getWidthByDesignValue720(211);
        i3 = DPIUtil.getWidthByDesignValue720(341);
        localRect = new Rect(i2, i3, i2 + i1, i1 + i3);
        this.e.add(localRect);
        this.f = new Rect(0, DPIUtil.getWidthByDesignValue720(426), this.a, this.b);
        this.g = new Rect(DPIUtil.getWidthByDesignValue720(174) - DPIUtil.dip2px(20.0F)
                , DPIUtil.getWidthByDesignValue720(274) - DPIUtil.dip2px(20.0F)
                , DPIUtil.getWidthByDesignValue720(174) + DPIUtil.dip2px(20.0F)
                , DPIUtil.getWidthByDesignValue720(274) + DPIUtil.dip2px(20.0F));
        this.h = new Rect(this.a + 1, this.b + 1, this.a + 2, this.b + 2);
    }

    public final void a(final HomeRecommendEntity paramHomeRecommendEntity, int paramInt) {
        this.u = paramInt;
        if (this.c != null) {//if-eqz v0, :cond_0
            this.t = paramHomeRecommendEntity.getType();
            if (paramHomeRecommendEntity.getType() == 2) {//if-ne v0, v1, :cond_1
                setBackgroundColor(0);
                this.l.setVisibility(VISIBLE);
                this.i.setVisibility(GONE);
                this.q.setVisibility(GONE);
                this.j.setVisibility(GONE);
                FloorImageLoadCtrl.a(this.l, paramHomeRecommendEntity.getUrl());
                setOnClickListener(new View.OnClickListener(){//m(this, paramHomeRecommendEntity)
                    @Override
                    public void onClick(View v) {
                        try
                        {
                            JumpUtil.a(HomeRecommendOtherView.this.getContext(), paramHomeRecommendEntity.getJump(), 1);
                            JDMtaUtils.sendCommonData(HomeRecommendOtherView.this.getContext(), "Home_MyStreet", paramHomeRecommendEntity.getJump().getSrv(), "", JDHomeFragment.class, "", JshopMainShopActivity.class, "", Constants.b);
                            return;
                        }
                        catch (Exception e)
                        {
                            if (Log.D);
                            e.printStackTrace();
                        }
                    }
                });
            } else if (paramHomeRecommendEntity.getType() == 1) { //if-ne v0, v7, :cond_4
                setBackgroundColor(-1);
                final HomeShopEntity homeShopEntity = paramHomeRecommendEntity.getShop();
                this.l.setVisibility(GONE);
                this.i.setVisibility(VISIBLE);
                this.q.setVisibility(VISIBLE);
                this.j.setVisibility(GONE);
                if ((this.c != null) && (this.c.size() > 0))
                    FloorImageLoadCtrl.c((ImageView) this.c.get(0), homeShopEntity.getLogoUrl());
                a(homeShopEntity.getWareList(), 1, 3);
                this.n.setText(homeShopEntity.getShopName());
                this.o.setText(String.valueOf(homeShopEntity.getFollowCount() + getContext().getResources().getString(R.string.recommend_shopitem_follow)));//2131233517
                if (homeShopEntity.getVenderType() == 1)
                    this.p.setVisibility(VISIBLE);
                else
                    this.p.setVisibility(GONE);
                setOnClickListener(new View.OnClickListener() {//n(this, homeShopEntity)
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent(HomeRecommendOtherView.this.getContext(), JshopMainShopActivity.class);
                        JSONObject localJSONObject = new JSONObject();
                        try {
                            localJSONObject.put("shopId", homeShopEntity.getShopId());
                        } catch (Exception localException) {
                        }
                        //:goto_0
                        intent.putExtra("brand.json", localJSONObject.toString());
                        if (!TextUtils.isEmpty(homeShopEntity.getTargetUrl())) {
                            intent.putExtra("clickType", 1);
                            intent.putExtra("ad.url", homeShopEntity.getTargetUrl());
                        } else if (!TextUtils.isEmpty(homeShopEntity.getClk())) {
                            intent.putExtra("clickType", 2);
                            intent.putExtra("ad.url", homeShopEntity.getClk());
                        }
                        //:cond_0
                        //:goto_1
                        HomeRecommendOtherView.this.getContext().startActivity(intent);
                        try {

                            JDMtaUtils.sendCommonData(HomeRecommendOtherView.this.getContext(), "Home_Shopid", homeShopEntity.getSourceValue(), "", JDHomeFragment.class, "", JshopMainShopActivity.class, "", Constants.b);
                        } catch (Exception e) {
                            if (Log.D) ;
                            e.printStackTrace();
                        }
                        return;
                    }

                });
            } else if (paramHomeRecommendEntity.getType() == 3) {
                setBackgroundColor(0);
                final HomeDNAEntity homeDNAEntity = paramHomeRecommendEntity.getDna();
                this.l.setVisibility(VISIBLE);
                this.i.setVisibility(GONE);
                this.q.setVisibility(GONE);
                this.j.setVisibility(VISIBLE);
                JDImageUtils.displayImage("res:///"+R.drawable.home_product_footview, this.l);//2130839347
                this.l.setTag(R.id.image_last_url, null);//2131165370
                a(homeDNAEntity.getWareList(), 0, 4);
                this.r.setText(homeDNAEntity.getDnaName());
                this.s.setText(homeDNAEntity.getDescription());
                setOnClickListener(new View.OnClickListener(){//o(this, homeDNAEntity)
                    @Override
                    public void onClick(View v) {
                        try
                        {
                            JumpUtil.a(HomeRecommendOtherView.this.getContext(), homeDNAEntity.getJump(), 1);
                            JDMtaUtils.sendCommonData(HomeRecommendOtherView.this.getContext(), "Home_ShoppingGene", homeDNAEntity.getJump().getSrv(), "", JDHomeFragment.class, "", JshopMainShopActivity.class, "", Constants.b);
                            return;
                        }
                        catch (Exception e)
                        {
                            if (Log.D);
                            e.printStackTrace();
                        }
                    }
                });
            }
        }
        return;
    }

    protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4) {
        if ((this.c == null) || (this.d == null) || (this.k == null))

            return;
        Rect localRect = null;
        switch (this.t) {
            case 1://pswitch_0
                this.i.layout(0, DPIUtil.getWidthByDesignValue720(148), this.a, this.b);
                this.k.layout(this.h.left, this.h.top, this.h.right, this.h.bottom);
                this.m.layout(this.f.left, this.f.top, this.f.right, this.f.bottom);
                for (int i=0; i < this.d.size(); i++) {//if-ge v2, v3, :cond_3
                    localRect = (Rect) this.d.get(i);
                    ((SimpleDraweeView) this.c.get(i)).layout(localRect.left, localRect.top, localRect.right, localRect.bottom);
                }
                //:cond_3
                ((SimpleDraweeView) this.c.get(3)).layout(this.h.left, this.h.top, this.h.right, this.h.bottom);
                break;
            case 2://pswitch_1
                this.l.layout(0, 0, this.a, this.b);;
                for (int i=0; i < this.c.size(); i++) {
                    ((SimpleDraweeView) this.c.get(i)).layout(this.h.left, this.h.top, this.h.right, this.h.bottom);
                }
                this.k.layout(this.h.left, this.h.top, this.h.right, this.h.bottom);
                break;
            case 3://pswitch_2
                this.l.layout(0, 0, this.a, this.b);
                this.k.layout(this.g.left, this.g.top, this.g.right, this.g.bottom);
                this.m.layout(this.f.left, this.f.top, this.f.right, this.f.bottom);
                for (int i = 0; i < this.e.size(); i++) {
                    localRect = (Rect) this.e.get(i);
                    ((SimpleDraweeView) this.c.get(i)).layout(localRect.left, localRect.top, localRect.right, localRect.bottom);
                }
                break;
        }


    }

    protected void onMeasure(int paramInt1, int paramInt2) {
        setMeasuredDimension(View.MeasureSpec.getSize(paramInt1), this.b);
        if (this.i != null)
            this.i.measure(this.a, this.b);
        if (this.m != null)
            this.m.measure(this.a, DPIUtil.getWidthByDesignValue720(78));
        if (this.k != null)
            this.k.measure(DPIUtil.dip2px(40.0F), DPIUtil.dip2px(40.0F));
    }
}
