package com.zy.app.mall.home.floor.view.view;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.TextView;

import com.jingdong.common.sample.jshop.JshopDynaFragmentActivity;
import com.zy.app.mall.R;
import com.zy.app.mall.home.floor.a.a.Constants;
import com.zy.app.mall.home.floor.view.adapter.MallShopFloorRecyclerAdapter;
import com.zy.app.mall.utils.MyActivity;
import com.zy.app.mall.utils.ui.HeaderFooterRecyclerAdapter;
import com.zy.common.utils.DPIUtil;
import com.zy.common.utils.JDMtaUtils;

/**
 * Created by robin on 16-7-28.
 */
public class MallFloor_ShopRecyclerView extends RecyclerView {
    Context a;
    float b;
    float c;
    private int d;
    private boolean e = true;
    private int f;
    private final float g = 1.5F;
    private int h = 0;
    private RecyclerView.OnScrollListener i = new RecyclerView.OnScrollListener() {//ah(this)
        @Override
        public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
            super.onScrollStateChanged(recyclerView, newState);
        }

        @Override
        public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
            super.onScrolled(recyclerView, dx, dy);
        }
    };

    public MallFloor_ShopRecyclerView(Context paramContext) {
        super(paramContext);
        a(paramContext);
    }

    public MallFloor_ShopRecyclerView(Context paramContext, AttributeSet paramAttributeSet) {
        super(paramContext, paramAttributeSet);
        a(paramContext);
    }

    private void a(Context paramContext) {
        this.a = paramContext;
        setOnScrollListener(this.i);
        this.d = DPIUtil.dip2px(254.0F);
        this.f = DPIUtil.dip2px(8.0F);
    }

    public boolean onTouchEvent(MotionEvent paramMotionEvent) {
        if (this.b == -1.0F)
            this.b = paramMotionEvent.getRawX();
        switch (paramMotionEvent.getAction()) {
            case 3://:pswitch_0
            case 4://:pswitch_0
            default:
                post(new Runnable(){//al(this)
                    @Override
                    public void run() {
                        if ((MallFloor_ShopRecyclerView.this.getAdapter() != null) && (((HeaderFooterRecyclerAdapter)MallFloor_ShopRecyclerView.this.getAdapter()).e() != null))
                            ((TextView)((HeaderFooterRecyclerAdapter)MallFloor_ShopRecyclerView.this.getAdapter()).e().findViewById(R.id.home_shop_more_blank)).setPadding(0, 0, 0, 0);//2131168528

                    }
                });
                this.b = -1.0F;
                this.c = 1.0F;
                break;
            case 0://:pswitch_1
                this.b = paramMotionEvent.getRawX();
                this.h = 1;
                break;
            case 5://:pswitch_2
                this.b = paramMotionEvent.getRawX();
                this.h = 2;
                break;
            case 2://:pswitch_3
                if (this.h == 1)
                    paramMotionEvent.getRawX();
                else
                    Math.min(paramMotionEvent.getX(0) - this.b, paramMotionEvent.getX(1) - this.b);
                float f1 = paramMotionEvent.getRawX();
                float f2 = this.b;
                this.b = paramMotionEvent.getRawX();
                if (this != null)
                    try {
                        if ((getLayoutManager() != null) && (((LinearLayoutManager) getLayoutManager()).findLastCompletelyVisibleItemPosition() == getAdapter().getItemCount() - 1)) {
                            this.c += -(f1 - f2) / 1.5F;
                            if (this.c > this.f)
                                this.c = this.f;
                            post(new Runnable(){//ai(this)
                                @Override
                                public void run() {
                                    if ((MallFloor_ShopRecyclerView.this.getAdapter() != null) && (((HeaderFooterRecyclerAdapter)MallFloor_ShopRecyclerView.this.getAdapter()).e() != null))
                                        ((TextView)((HeaderFooterRecyclerAdapter)MallFloor_ShopRecyclerView.this.getAdapter()).e().findViewById(R.id.home_shop_more_blank)).setPadding(0, 0, (int)MallFloor_ShopRecyclerView.this.c, 0);//2131168528

                                }
                            });
                        }
                    } catch (Exception localException1) {
                        localException1.printStackTrace();
                    }
                break;
            case 1://:pswitch_4
            case 6://:pswitch_4
                if (this != null)//if-eqz p0, :cond_4
                    try {
                        if (getLayoutManager() != null) {//if-eqz v0, :cond_4
                            if (((LinearLayoutManager) getLayoutManager()).findLastCompletelyVisibleItemPosition() == getAdapter().getItemCount() - 1) {//if-ne v0, v1, :cond_5
                                if (this.c >= this.f) {//if-ltz v0, :cond_4
                                    Intent localIntent = new Intent(this.a, JshopDynaFragmentActivity.class);
                                    localIntent.putExtra("cid", "");
                                    localIntent.putExtra("categories", ((MallShopFloorRecyclerAdapter) getAdapter()).c());
                                    localIntent.putExtra("index", ((MallShopFloorRecyclerAdapter) getAdapter()).b().D().size());
                                    localIntent.putExtra("currentTab", 3);
                                    ((MyActivity) this.a).startActivityInFrame(localIntent);
                                    ((MyActivity) this.a).overridePendingTransition(R.anim.jshop_right_in, R.anim.mall_floor_shop_stay);//2130968623, 2130968632
                                    JDMtaUtils.onClickWithPageId(this.a, "Home_StreetSlideIn", MallFloor_Shop.class.getName(), ((MallShopFloorRecyclerAdapter) getAdapter()).d(), Constants.b);
                                    post(new Runnable(){//aj(this)
                                        @Override
                                        public void run() {
                                            if ((MallFloor_ShopRecyclerView.this.getAdapter() != null) && (((HeaderFooterRecyclerAdapter)MallFloor_ShopRecyclerView.this.getAdapter()).e() != null))
                                                ((TextView)((HeaderFooterRecyclerAdapter)MallFloor_ShopRecyclerView.this.getAdapter()).e().findViewById(R.id.home_shop_more_blank)).setPadding(0, 0, 0, 0);//2131168528

                                        }
                                    });
                                }
                            } else {
                                post(new Runnable(){//ak(this)
                                    @Override
                                    public void run() {
                                        if ((MallFloor_ShopRecyclerView.this.getAdapter() != null) && (((HeaderFooterRecyclerAdapter)MallFloor_ShopRecyclerView.this.getAdapter()).e() != null))
                                            ((TextView)((HeaderFooterRecyclerAdapter)MallFloor_ShopRecyclerView.this.getAdapter()).e().findViewById(R.id.home_shop_more_blank)).setPadding(0, 0, 0, 0);//2131168528

                                    }
                                });
                            }
                        }//:cond_4
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                this.c = 1.0F;
                this.b = -1.0F;
                break;
        }
        //:cond_1
        //:goto_0
        return super.onTouchEvent(paramMotionEvent);
    }
}
