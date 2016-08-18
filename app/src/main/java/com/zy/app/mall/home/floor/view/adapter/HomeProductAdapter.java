package com.zy.app.mall.home.floor.view.adapter;

import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.widget.AbsListView;
import android.widget.BaseAdapter;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.facebook.drawee.view.SimpleDraweeView;
import com.jingdong.app.mall.home.HSimilarProductListActivity;
import com.jingdong.app.mall.home.floor.view.view.HomeFooterView;
import com.jingdong.app.mall.product.ProductDetailActivity;
import com.jingdong.app.mall.utils.StartActivityUtils;
import com.jingdong.common.BaseActivity;
import com.zy.app.mall.R;
import com.zy.app.mall.home.JDHomeFragment;
import com.jingdong.app.mall.home.floor.b.FloorImageLoadCtrl;
import com.zy.app.mall.home.floor.a.a.Constants;
import com.zy.app.mall.home.floor.model.entity.HomeProductEntity;
import com.zy.app.mall.home.floor.model.entity.HomeRecommendEntity;
import com.zy.app.mall.home.floor.model.entity.HomeRecommendTwoEntity;
import com.zy.app.mall.home.floor.view.view.HomeRecommendOtherView;
import com.zy.common.entity.SourceEntity;
import com.zy.common.utils.DPIUtil;
import com.zy.common.utils.ImageUtil;
import com.zy.common.utils.JDMtaUtils;
import com.zy.common.utils.Log;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Robin on 2016/5/28.
 */
public class HomeProductAdapter extends BaseAdapter {
    private final int a = (DPIUtil.getWidth() - DPIUtil.dip2px(14.0F)) / 2;
    private final int b = this.a * 504 / 346 + DPIUtil.dip2px(5.0F);
    private final int c = 0;
    private final int d = 1;
    private final int e = 2;
    private final int f = 3;
    private final int g = 4;
    private JDHomeFragment h;
    private BaseActivity i;
    private List<HomeRecommendTwoEntity> j;
    private String k;
    private String l;
    private HomeFooterView m;

    public HomeProductAdapter(List<HomeRecommendTwoEntity> paramList, JDHomeFragment paramJDHomeFragment, String paramString1, String paramString2, HomeFooterView paramHomeFooterView)
    {
        this.h = paramJDHomeFragment;
        this.i = paramJDHomeFragment.thisActivity;
        this.k = paramString1;
        this.l = paramString2;
        this.m = paramHomeFooterView;
        if (this.j == null)
            this.j = new ArrayList();
        a(null, true);
    }

    public final void a(List<HomeRecommendTwoEntity> paramList, boolean paramBoolean)
    {
        if (paramBoolean)
            this.j.clear();
        if ((paramList != null) && (!paramList.isEmpty()))
            this.j.addAll(paramList);
    }

    public final int getCount()
    {
        return (this.m==null?0:1) + this.j.size();
    }

    public final Object getItem(int paramInt)
    {
        return null;
    }

    public final long getItemId(int paramInt)
    {
        return paramInt;
    }

    public final int getItemViewType(int paramInt)
    {
        if ((paramInt == getCount() - 1) && (this.m != null))
            return 4;
        if ((this.j != null) && (this.j.size() > paramInt) && (this.j.get(paramInt).isAllProduct()))
            return 0;
        if ((this.j != null) && (this.j.size() > paramInt) && (this.j.get(paramInt).isLeftProduct()))
            return 1;
        if ((this.j != null) && (this.j.size() > paramInt) && (this.j.get(paramInt).isRightProduct()))
            return 2;
        return 3;
    }

    public final View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
    {
        RecyclerView.ViewHolder viewHolder = null;
        int n = getItemViewType(paramInt);//v1
        Object localObject;
        if (paramView == null) {//if-nez p2, :cond_1
            AbsListView.LayoutParams v2 = new AbsListView.LayoutParams(-1, this.b);
            switch (n)
            {
                case 0:
                case 1:
                case 2:
                case 3:
                    View v3 = ImageUtil.inflate(R.layout.home_recommend_item, null);//2130903591
                    v3.setLayoutParams(v2);
                    viewHolder = new _A(this, v3, n);
                    break;
                case 4:
                    viewHolder = new HomeProductAdapter.SimpleViewHolder(this, this.m);
                    break;
            }

            paramView = viewHolder.itemView;
            paramView.setTag(viewHolder);
        }else{//:cond_1
            viewHolder = (RecyclerView.ViewHolder)paramView.getTag();
        }
        //:goto_1
            if (viewHolder != null)
            {//if-eqz v1, :cond_0
                n = getItemViewType(paramInt);
                if (n != 4) {
                    HomeRecommendTwoEntity twoEntity = (HomeRecommendTwoEntity) this.j.get(paramInt);
                    switch (n){
                        case 0:
                        case 1:
                        case 2:
                        case 3:
                            ((_A)viewHolder).a((HomeRecommendTwoEntity)twoEntity, paramInt);
                            break;
                    }
                }
            }
        return (View)paramView;
    }

    public final int getViewTypeCount()
    {
        return 5;
    }

    private static class _A extends RecyclerView.ViewHolder{
        private HomeProductAdapter.OneProductViewHolder a;
        private HomeProductAdapter.OneProductViewHolder b;
        private _D c;
        private _D d;
        private int e;
        private HomeProductAdapter f;

        public _A(HomeProductAdapter paramHomeProductAdapter, View paramView, int paramInt)
        {
            super(paramView);
            this.e = paramInt;
            this.f = paramHomeProductAdapter;
            if (paramInt == 0)
            {
                this.a = a(paramView, R.id.home_product_item_layout_left);  //2131168493
                this.b = a(paramView, R.id.home_product_item_layout_right);  //2131168494
            }else if (paramInt == 1)
            {
                this.a = a(paramView, R.id.home_product_item_layout_left);  //2131168493
                this.d = b(paramView, R.id.home_other_item_layout_right);  //2131168495
                return;
            }else if (paramInt != 2) {
                this.c = b(paramView, R.id.home_other_item_layout_left);  //2131168492
                this.b = a(paramView, R.id.home_product_item_layout_right);  //2131168494
                return;
            }else if (paramInt == 3) {
                this.c = b(paramView, R.id.home_other_item_layout_left);  //2131168492
                this.d = b(paramView, R.id.home_other_item_layout_right);  //2131168495
            }
            return;
        }

        private HomeProductAdapter.OneProductViewHolder a(View paramView, int paramInt)
        {
            ViewStub viewStub = (ViewStub)paramView.findViewById(paramInt);
            if (viewStub != null)
            {
                paramView = viewStub.inflate();
                return new HomeProductAdapter.OneProductViewHolder(this.f, paramView);
            }
            return null;
        }

        private static void a(HomeProductAdapter.OneProductViewHolder paramOneProductViewHolder, HomeProductEntity paramHomeProductEntity, int paramInt)
        {
            if ((paramHomeProductEntity != null) && (paramOneProductViewHolder != null)){
                String str = paramHomeProductEntity.getImageUrl();
                FloorImageLoadCtrl.a(paramOneProductViewHolder.a, str);
                HomeProductAdapter.OneProductViewHolder.synthetic_a(paramOneProductViewHolder, paramHomeProductEntity, paramInt);
            }
                return;
        }

        private static void a(_D paramd, HomeRecommendEntity paramHomeRecommendEntity, int paramInt)
        {
            if ((paramHomeRecommendEntity == null) || (paramd == null))
                return;
            if ((paramHomeRecommendEntity != null) && (paramd.a != null))
            paramd.a.a(paramHomeRecommendEntity, paramInt);
        }

        private _D b(View paramView, int paramInt)
        {
            ViewStub viewStub = (ViewStub)paramView.findViewById(paramInt);
            if (viewStub != null)
            {
                paramView = viewStub.inflate();
                return new _D(this.f, paramView);
            }
            return null;
        }

        public final void a(HomeRecommendTwoEntity paramHomeRecommendTwoEntity, int paramInt)
        {
            if (paramHomeRecommendTwoEntity != null){
                if (this.e == 0)
                {
                    a(this.a, paramHomeRecommendTwoEntity.getRecommendEntityLeft().getProduct(), paramInt * 2);
                    a(this.b, paramHomeRecommendTwoEntity.getRecommendEntityRight().getProduct(), paramInt * 2 + 1);
                    return;
                }else if (this.e == 1)
                {
                    a(this.a, paramHomeRecommendTwoEntity.getRecommendEntityLeft().getProduct(), paramInt * 2);
                    a(this.d, paramHomeRecommendTwoEntity.getRecommendEntityRight(), paramInt * 2 + 1);
                    return;
                }else if (this.e == 2) {
                    a(this.c, paramHomeRecommendTwoEntity.getRecommendEntityLeft(), paramInt * 2);
                    a(this.b, paramHomeRecommendTwoEntity.getRecommendEntityRight().getProduct(), paramInt * 2 + 1);
                    return;
                }else if (this.e == 3){
                    a(this.c, paramHomeRecommendTwoEntity.getRecommendEntityLeft(), paramInt * 2);
                    a(this.d, paramHomeRecommendTwoEntity.getRecommendEntityRight(), paramInt * 2 + 1);
                }
            }

                return;

            }


    }

    static final class _D extends RecyclerView.ViewHolder
    {
        HomeRecommendOtherView a;

        public _D(HomeProductAdapter paramHomeProductAdapter, View paramView)
        {
            super(paramView);
            if ((paramView instanceof HomeRecommendOtherView))
                this.a = ((HomeRecommendOtherView)paramView);
        }
    }

    private static class SimpleViewHolder extends RecyclerView.ViewHolder{
        public SimpleViewHolder(HomeProductAdapter paramHomeProductAdapter, View paramView){
            super(paramView);
        }
    }

    private static class OneProductViewHolder extends RecyclerView.ViewHolder{
        SimpleDraweeView a;
        RelativeLayout b;
        TextView c;
        TextView d;
        TextView e;
        HomeProductAdapter f;

        public OneProductViewHolder(HomeProductAdapter paramHomeProductAdapter, View paramView)
        {
            super(paramView);
            this.a = ((SimpleDraweeView)paramView.findViewById(R.id.home_product_item_img));//2131168507
            this.a.setAspectRatio(1.0F);
            this.b = ((RelativeLayout)paramView.findViewById(R.id.home_product_item_layout));//2131168508
            this.b.setPadding(DPIUtil.dip2px(5.0F), DPIUtil.getWidthByDesignValue720(10), DPIUtil.dip2px(5.0F), DPIUtil.getWidthByDesignValue720(10));
            //home_product_item_yangjiao    2131168510  bpk
            this.c = ((TextView)paramView.findViewById(R.id.home_product_item_name));//2131168509
            this.d = ((TextView)paramView.findViewById(R.id.home_product_item_price));//2131168511
            this.e = ((TextView)paramView.findViewById(R.id.home_product_item_similar));//2131168512
            this.f = paramHomeProductAdapter;
        }

        static void synthetic_a(final OneProductViewHolder paramOneProductViewHolder, final HomeProductEntity paramHomeProductEntity, final int paramInt) {
            paramOneProductViewHolder.c.setText(paramHomeProductEntity.getName());
            paramOneProductViewHolder.d.setText(paramHomeProductEntity.getJdPriceWithOutZero());
            if (paramHomeProductEntity.isLookSimilar()) {
                if (paramOneProductViewHolder.e.getVisibility() == View.GONE)
                    paramOneProductViewHolder.e.setVisibility(View.VISIBLE);
                paramOneProductViewHolder.e.setOnClickListener(new View.OnClickListener() {//b(paramOneProductViewHolder, paramHomeProductEntity))
                    @Override
                    public final void onClick(View paramView) {
                        if ((paramHomeProductEntity != null) && (paramHomeProductEntity.getId() != null))
                            com.jingdong.common.deeplinkhelper._B.a(paramOneProductViewHolder.f.i, String.valueOf(paramHomeProductEntity.getId()), paramHomeProductEntity.getJdPriceWithOutZero(), paramHomeProductEntity.getName(), paramHomeProductEntity.getImageUrl(), 0);
                        try {
                            JDMtaUtils.sendCommonData(paramOneProductViewHolder.f.i, "Home_SimilarView", paramHomeProductEntity.getSourceValue(), "", paramOneProductViewHolder.f.h, "", HSimilarProductListActivity.class, "", Constants.b);
                            return;
                        } catch (Exception e) {
                            if (Log.D)
                                e.printStackTrace();
                        }
                    }
                });
            } else if (paramOneProductViewHolder.e.getVisibility() == View.VISIBLE)
                paramOneProductViewHolder.e.setVisibility(View.GONE);
            paramOneProductViewHolder.itemView.setOnClickListener(new View.OnClickListener() {//c(paramOneProductViewHolder, paramHomeProductEntity, paramInt)
                @Override
                public final void onClick(View paramView) {
                    HomeProductAdapter.OneProductViewHolder.synthetic_b(paramOneProductViewHolder, paramHomeProductEntity, paramInt);
                }
            });
            return;
        }

        static void synthetic_b(OneProductViewHolder paramOneProductViewHolder, HomeProductEntity paramHomeProductEntity, int paramInt)
        {
            String str;
            SourceEntity localSourceEntity;
            Bundle localBundle;
            if ((paramHomeProductEntity != null) && (paramHomeProductEntity.getId() != null))//if-eqz p1, :cond_0
            {
                str = paramHomeProductEntity.getId();
                localSourceEntity = new SourceEntity("indexRecommend", paramHomeProductEntity.getSourceValue());
                localBundle = new Bundle();
                localBundle.putString("id", str);
                if (TextUtils.isEmpty(paramOneProductViewHolder.f.k))   //if-eqz v0, :cond_1
                    str = "";
                else
                    str = paramOneProductViewHolder.f.k;

                //:goto_0
                localBundle.putString("expid", str);
                localBundle.putString("index", String.valueOf(paramInt));
                if (TextUtils.isEmpty(paramOneProductViewHolder.f.l))// if-eqz v0, :cond_2
                    str = "";
                else
                    str =paramOneProductViewHolder.f.l;
                    //:goto_1
                    localBundle.putString("rid", str);
                    localBundle.putString("csku", paramHomeProductEntity.getId().toString());
                    localBundle.putString("targetUrl", paramHomeProductEntity.getTargetUrl());
                    StartActivityUtils.a(paramOneProductViewHolder.f.i, localBundle, localSourceEntity);
                try {
                    JDMtaUtils.sendCommonData(paramOneProductViewHolder.f.i, "Home_Productid", paramHomeProductEntity.getSourceValue(), "", paramOneProductViewHolder.f.h, "", ProductDetailActivity.class, "", Constants.b);
                }catch (Exception e)
                    {
                        if (Log.D)
                        e.printStackTrace();
                    }
            }//
            // :cond_0
            return;

        }
    }
}
