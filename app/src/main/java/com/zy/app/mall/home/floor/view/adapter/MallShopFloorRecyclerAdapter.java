package com.zy.app.mall.home.floor.view.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.facebook.drawee.view.SimpleDraweeView;

import com.jingdong.app.mall.home.floor.b.FloorImageLoadCtrl;
import com.jingdong.common.sample.jshop.JshopDynaFragmentActivity;
import com.zy.app.mall.R;
import com.zy.app.mall.home.floor.a.a.Constants;
import com.zy.app.mall.home.floor.d.b.MallShopFloorPresenter;
import com.zy.app.mall.home.floor.view.view.MallFloor_Shop;
import com.zy.app.mall.utils.MyActivity;
import com.zy.app.mall.utils.ui.HeaderFooterRecyclerAdapter;
import com.zy.common.entity.GoodShopModel;
import com.zy.common.utils.DPIUtil;
import com.zy.common.utils.JDMtaUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by robin on 16-7-28.
 */
public class MallShopFloorRecyclerAdapter extends HeaderFooterRecyclerAdapter {
    public List<GoodShopModel> a;
    private Context b;
    private MallShopFloorPresenter c;
    private LayoutInflater d;
    private _O e;

    public MallShopFloorRecyclerAdapter(Context paramContext) {
        this(paramContext, null);
    }

    private MallShopFloorRecyclerAdapter(Context paramContext, List<GoodShopModel> paramList) {
        this.b = paramContext;
        this.d = LayoutInflater.from(paramContext);
        this.a = new ArrayList<GoodShopModel>();
    }

    public final int a() {
        return this.a.size();
    }

    public final RecyclerView.ViewHolder a(ViewGroup paramViewGroup) {
        return new _P(this, this.d.inflate(R.layout.home_shop_recycler_view_item, paramViewGroup, false));//2130903597
    }

    public final void a(RecyclerView.ViewHolder paramViewHolder, final int paramInt) {
        final GoodShopModel localGoodShopModel = (GoodShopModel) this.a.get(paramInt);
        _P localp = (_P) paramViewHolder;
        if (paramInt == 0)//if-nez p2, :cond_2
            ((RecyclerView.LayoutParams) localp.b.getLayoutParams()).setMargins(DPIUtil.dip2px(5.0F), 0, DPIUtil.dip2px(5.0F), 0);
        else
            ((RecyclerView.LayoutParams) localp.b.getLayoutParams()).setMargins(0, 0, DPIUtil.dip2px(5.0F), 0);
        String str = localGoodShopModel.getShopCategoriesTitle();
        if (str.length() > 4)
            str = str.substring(0, 4);
        localp.c.setText(str);
        int i = 10;
        if (localGoodShopModel.getShopCategoriesCount() > 0)
            i = localGoodShopModel.getShopCategoriesCount();

        String text = "<font color='#f63838'>" + i + "</font>家";
        localp.d.setText(Html.fromHtml(text));
        localp.e.setText(localGoodShopModel.getShopName());
        FloorImageLoadCtrl.a(localp.f, localGoodShopModel.getShopImage(), true);
        ArrayList<GoodShopModel.WareModel> list = localGoodShopModel.getWareList();
        if (list.size() > 2) {
            FloorImageLoadCtrl.a(localp.g, (list.get(0)).imgPath, false);
            FloorImageLoadCtrl.a(localp.h, (list.get(1)).imgPath, false);
            FloorImageLoadCtrl.a(localp.i, (list.get(2)).imgPath, false);
        }
        localp.itemView.setOnClickListener(new View.OnClickListener(){//n(this, localGoodShopModel, localp, paramInt)
            @Override
            public void onClick(View view) {
                int i = localGoodShopModel.getShopCategoriesId();
                Object localObject = new Intent(MallShopFloorRecyclerAdapter.this.b, JshopDynaFragmentActivity.class);

                String v0 = "";
                if (i != 0)
                    v0 = i+"";
                ((Intent)localObject).putExtra("cid", v0);
                ((Intent)localObject).putExtra("categories", MallShopFloorRecyclerAdapter.this.c.C());
                ((Intent)localObject).putExtra("currentTab", 3);
                Context context = MallShopFloorRecyclerAdapter.this.b;
                ((MyActivity)context).startActivityInFrame((Intent)localObject);
                ((MyActivity)context).overridePendingTransition(R.anim.jshop_right_in, R.anim.mall_floor_shop_stay);//2130968623, 2130968632
                if (MallShopFloorRecyclerAdapter.this.e != null)
                    MallShopFloorRecyclerAdapter.this.e.a(paramInt);

                String str = MallFloor_Shop.class.getName();
                StringBuilder localStringBuilder = new StringBuilder("1_0_CMSDP");
                localStringBuilder.append(v0);
                    JDMtaUtils.onClickWithPageId((Context)context, "Home_Floor", str, localStringBuilder.toString(), Constants.b);
                    return;

            }
        });
        return;

    }

    public final void a(MallShopFloorPresenter paramn) {
        this.c = paramn;
    }

    public final void a(_O paramo) {
        this.e = paramo;
    }

    public final MallShopFloorPresenter b() {
        return this.c;
    }

    public final String c() {
        return this.c.C();
    }

    public final String d() {
        return this.c.a(false);
    }

    public interface _O {
        public void a(int paramInt);
    }

    final class _P extends RecyclerView.ViewHolder {
        private View b;
        private TextView c;
        private TextView d;
        private TextView e;
        private SimpleDraweeView f;
        private SimpleDraweeView g;
        private SimpleDraweeView h;
        private SimpleDraweeView i;

        public _P(MallShopFloorRecyclerAdapter paramMallShopFloorRecyclerAdapter, View paramView) {
            super(paramView);
            this.b = paramView;
            this.c = ((TextView) paramView.findViewById(R.id.home_shop_category_name));//2131168530
            this.d = ((TextView) paramView.findViewById(R.id.home_shop_category_count));//2131168531
            this.f = ((SimpleDraweeView) paramView.findViewById(R.id.home_shop_shop_image));//2131168533
            this.e = ((TextView) paramView.findViewById(R.id.home_shop_shop_name));//2131168534
            this.g = ((SimpleDraweeView) paramView.findViewById(R.id.home_shop_product_image1));//2131168535
            this.h = ((SimpleDraweeView) paramView.findViewById(R.id.home_shop_product_image2));//2131168536
            this.i = ((SimpleDraweeView) paramView.findViewById(R.id.home_shop_product_image3));//2131168537
        }
    }
}
