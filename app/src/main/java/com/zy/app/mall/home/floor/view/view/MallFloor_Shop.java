package com.zy.app.mall.home.floor.view.view;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.jingdong.app.mall.home.ScrollStopListener;
import com.jingdong.app.mall.home.floor.d.a.ShopFloorEngine;
import com.jingdong.app.mall.utils.CommonUtil;
import com.jingdong.common.sample.jshop.JshopDynaFragmentActivity;
import com.zy.app.mall.R;
import com.zy.app.mall.home.floor.a.a.Constants;
import com.zy.app.mall.home.floor.d.b.MallShopFloorPresenter;
import com.zy.app.mall.home.floor.model.entity.ShopFloorEntity;
import com.zy.app.mall.home.floor.view.adapter.MallShopFloorRecyclerAdapter;
import com.zy.app.mall.home.floor.view.baseUI.IMallListItemFloorUI;
import com.zy.app.mall.home.floor.view.baseUI.MallBaseFloor;
import com.zy.app.mall.utils.MyActivity;
import com.zy.common.entity.HomeFloorNewElement;
import com.zy.common.utils.ImageUtil;
import com.zy.common.utils.JDMtaUtils;
import com.zy.common.utils.Log;

import java.lang.reflect.Field;

/**
 * Created by robin on 16-7-27.
 */
public class MallFloor_Shop extends MallBaseFloor<MallShopFloorPresenter>
        implements IMallListItemFloorUI {
    private ScrollStopListener h = null;
    private Context i;
    private boolean j = false;
    private MallFloor_ShopRecyclerView k;
    private MallShopFloorRecyclerAdapter l;
    private RelativeLayout m;

    public MallFloor_Shop(Context paramContext)
    {
        super(paramContext);
        this.i = paramContext;
    }

    public MallFloor_Shop(Context paramContext, AttributeSet paramAttributeSet)
    {
        super(paramContext, paramAttributeSet);
        this.i = paramContext;
    }

    public MallFloor_Shop(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
    {
        super(paramContext, paramAttributeSet, paramInt);
        this.i = paramContext;
    }

    private void f()
    {
        final MallShopFloorPresenter mallShopFloorPresenter = i();
        Object localObject1;
        if ((this.m == null) || (this.k == null))
        {
            this.m = ((RelativeLayout) ImageUtil.inflate(R.layout.home_shop_view, null));//2130903598
            this.k = ((MallFloor_ShopRecyclerView)this.m.findViewById(R.id.home_shop_recycler_view));//2131168540
            localObject1 = new LinearLayoutManager(this.i);
            ((LinearLayoutManager)localObject1).setOrientation(0);
            this.k.setLayoutManager((RecyclerView.LayoutManager)localObject1);
        }
        try
        {
            localObject1 = this.k.getClass().getSuperclass().getDeclaredField("sQuinticInterpolator");
            ((Field)localObject1).setAccessible(true);
            Object localObject2 = new AccelerateDecelerateInterpolator();
            ((Field)localObject1).setAccessible(true);
            ((Field)localObject1).set(this.k, localObject2);
            localObject1 = new MallShopFloorRecyclerAdapter(this.i);
            if (this.l != null)
                this.l.a(new MallShopFloorRecyclerAdapter._O(){
                    public final void a(int paramInt)
                    {
                        if (!CommonUtil.getInstance().isCanClick())
                            Toast.makeText(MallFloor_Shop.this.i, "item click " + paramInt, Toast.LENGTH_SHORT).show();
                    }
                });
            localObject2 = LayoutInflater.from(this.i).inflate(R.layout.home_shop_recycler_view_footer, this.k, false);//2130903596
            ((View)localObject2).setOnClickListener(new View.OnClickListener(){//af(this)
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(MallFloor_Shop.this.i, JshopDynaFragmentActivity.class);
                    intent.putExtra("cid", "");
                    intent.putExtra("categories", (MallFloor_Shop.this.mPresenter).C());
                    intent.putExtra("index", (MallFloor_Shop.this.mPresenter).D().size());
                    intent.putExtra("currentTab", 3);
                    ((MyActivity)MallFloor_Shop.this.i).startActivityInFrame(intent);
                    ((MyActivity)MallFloor_Shop.this.i).overridePendingTransition(R.anim.jshop_right_in, R.anim.mall_floor_shop_stay);//2130968623, 2130968632);
                    JDMtaUtils.onClickWithPageId(MallFloor_Shop.this.i, "Home_StreetSlideIn", MallFloor_Shop.class.getName(), MallFloor_Shop.this.mPresenter.a(false), Constants.b);

                }
            });
            ((MallShopFloorRecyclerAdapter)localObject1).a((View)localObject2);
            ((MallShopFloorRecyclerAdapter)localObject1).a = mallShopFloorPresenter.D();
            ((MallShopFloorRecyclerAdapter)localObject1).a(mallShopFloorPresenter);
            this.k.setAdapter((RecyclerView.Adapter)localObject1);
            ((LinearLayout)this.m.findViewById(R.id.home_shop_left_corner)).setOnClickListener(new View.OnClickListener(){//ae(this, localn)//2131168538
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(MallFloor_Shop.this.i, JshopDynaFragmentActivity.class);
                    intent.putExtra("cid", "");
                    intent.putExtra("categories", mallShopFloorPresenter.C());
                    intent.putExtra("currentTab", 3);
                    ((MyActivity)MallFloor_Shop.this.i).startActivityInFrame(intent);
                    ((MyActivity)MallFloor_Shop.this.i).overridePendingTransition(R.anim.jshop_right_in, R.anim.mall_floor_shop_stay);//2130968623, 2130968632
                    JDMtaUtils.onClickWithPageId(MallFloor_Shop.this.i, "Home_GoodShopMore", MallFloor_Shop.class.getName(), mallShopFloorPresenter.a(true), Constants.b);

                }
            });
            addView(this.m);
            return;
        }
        catch (NoSuchFieldException e)
        {
                e.printStackTrace();
        }
        catch (IllegalAccessException e)
        {
                e.printStackTrace();
        }
    }

    public final Object a(HomeFloorNewElement paramHomeFloorNewElement, int paramInt1, int paramInt2, int paramInt3, Object paramObject)
    {
        return null;
    }

    public final void a()
    {
    }

    public final void a(boolean paramBoolean) {
        int n = VISIBLE;
        if (!paramBoolean)//if-eqz p1, :cond_2
            n = GONE;
        if ((getVisibility() == VISIBLE ^ paramBoolean))
            setVisibility(n);
        return;

    }

    public final void d()
    {
        if (Log.D)
            Log.d("MallFloor_Shop", "onRefreshViewInMainThread");
        MallShopFloorPresenter localn = (MallShopFloorPresenter)i();
        localn.a();
        if ((this.k != null) && (this.k.getAdapter() != null))
            this.k.getAdapter().notifyDataSetChanged();
        if (!localn.b())
        {//if-nez v1, :cond_7
            if (localn.c() > 2)
            {//if-le v0, v1, :cond_5
                if (Log.D)
                    Log.d("MallFloor_Shop", "refreshGoodShopUI");
                removeAllViews();
                localn = (MallShopFloorPresenter)i();
                if (getVisibility() != VISIBLE)
                    setVisibility(VISIBLE);
                if (!localn.b())
                    f();
                a(true);
            }else {
                if (Log.D)
                    Log.d("MallFloor_Shop", "removeAllViews");
                removeAllViews();
                a(false);
            }
        }else {
            if (Log.D)
                Log.d("MallFloor_Shop", "removeAllViews");
            removeAllViews();
            a(false);
        }
    }

    @Override
    protected MallShopFloorPresenter h() {
        return new MallShopFloorPresenter(ShopFloorEntity.class, ShopFloorEngine.class);
    }

    public final void e()
    {
        if (this.h == null)
            this.h = new ScrollStopListener(){

            };
    }

}
