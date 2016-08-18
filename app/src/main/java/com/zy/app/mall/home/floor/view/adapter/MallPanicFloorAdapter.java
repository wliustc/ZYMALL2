package com.zy.app.mall.home.floor.view.adapter;

import android.content.Context;
import android.text.TextUtils;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.facebook.drawee.view.SimpleDraweeView;
import com.jingdong.app.mall.home.floor.b.FloorImageLoadCtrl;
import com.jingdong.common.entity.Product;
import com.zy.app.mall.R;
import com.zy.app.mall.home.floor.d.b.MallPanicFloorPresenter;
import com.zy.common.utils.ImageUtil;

/**
 * Created by Robin on 2016/6/22.
 */
public class MallPanicFloorAdapter extends MallListItemPagerAdapter<MallPanicFloorPresenter>
{
    public MallPanicFloorAdapter(Context context, MallPanicFloorPresenter presenter) {
        super(context, presenter);
    }

    @Override
    protected final View a() {
        RelativeLayout localRelativeLayout = new RelativeLayout(this.mContext);
        localRelativeLayout.setLayoutParams(new RelativeLayout.LayoutParams(this.mFloorPresenter.g(), -2));
        Object localObject2 = super.a();
        Object localObject1 = new RelativeLayout.LayoutParams(this.mFloorPresenter.h() * 216 / 230, this.mFloorPresenter.h());
        if (this.mFloorPresenter.h() * 216 / 230 >= this.mFloorPresenter.g())
            localObject1 = new RelativeLayout.LayoutParams(this.mFloorPresenter.g(), this.mFloorPresenter.g() * 230 / 216);

        ((RelativeLayout.LayoutParams) localObject1).addRule(14);
        ((View) localObject2).setLayoutParams((ViewGroup.LayoutParams) localObject1);
        localRelativeLayout.addView((View) localObject2);
        localObject1 = new TextView(this.mContext);
        localObject2 = new RelativeLayout.LayoutParams(1, this.mFloorPresenter.J());
        ((RelativeLayout.LayoutParams) localObject2).topMargin = this.mFloorPresenter.K();
        ((RelativeLayout.LayoutParams) localObject2).addRule(11);
        ((TextView) localObject1).setLayoutParams((ViewGroup.LayoutParams) localObject2);
        ((TextView) localObject1).setBackgroundColor(this.mContext.getResources().getColor(R.color.product_list_item_divider_color));//2131100518
        localRelativeLayout.addView((View) localObject1);
        return localRelativeLayout;
    }

    @Override
    protected final View a(final int paramInt)
    {
        View localView = ImageUtil.inflate(R.layout.app_home_limit_buy_shitem, null);//2130903156
        localView.setLayoutParams(new LinearLayout.LayoutParams(this.mFloorPresenter.g(), -2));
        Object localObject = (SimpleDraweeView)localView.findViewById(R.id.app_home_limit_buy_icon);//2131165819
        ((SimpleDraweeView)localObject).setScaleType(ImageView.ScaleType.FIT_XY);
        localView.setOnClickListener(new View.OnClickListener(){//k(this, paramInt)
            @Override
            public void onClick(View v) {
                if (MallPanicFloorAdapter.this.mOnClickListener != null)
                    MallPanicFloorAdapter.this.mOnClickListener.b(paramInt);
            }
        });
        Product localProduct = (Product)this.mFloorPresenter.a(paramInt);
        FloorImageLoadCtrl.a((ImageView)localObject, localProduct.getImageUrl());
        localObject = (TextView)localView.findViewById(R.id.app_home_jdprice);//2131165823
        TextView localTextView1 = (TextView)localView.findViewById(R.id.app_home_limit_buy_price);//2131165824
        TextView localTextView2 = (TextView)localView.findViewById(R.id.tv_discount);//2131165820
        localTextView1.setText(this.mContext.getString(R.string.yangjiao) + localProduct.getJdPriceWithOutFormat());//2131230766
        ((TextView)localObject).setText(localProduct.getMiaoShaPrice());
        localTextView1.getPaint().setFlags(17);
        if (!TextUtils.isEmpty(localProduct.getTagText()))
        {//if-nez v0, :cond_0
            int color = this.mFloorPresenter.I();
            if (localProduct.getTagText().length() > paramInt) //if-le v2, v0, :cond_1
                localTextView2.setText(localProduct.getTagText().substring(0, paramInt));
            else
                localTextView2.setText(localProduct.getTagText());

            switch (localProduct.getTagType())
            {
                default:
                    color = R.color.miaosha_tag_red;  //2131100346    7F0602BA
                    break;
                case 1://pswitch_0
                    color = R.color.miaosha_tag_blue;//2131100341  7F0602B5
                    break;
                case 2://pswitch_1
                    color = R.color.miaosha_tag_orange;//2131100344  7F0602B8
                    break;
                case 3://pswitch_2
                    color = R.color.miaosha_tag_red;//2131100346  7F0602BA
                    break;
                case 4://pswitch_3
                    color = R.color.miaosha_tag_blue;//2131100341  7F0602B5
                    break;
                case 5://pswitch_4
                    color = R.color.miaosha_tag_green;//2131100343  7F0602B7
                    break;
                case 6://pswitch_5
                    color = R.color.miaosha_tag_gold;//2131100342  7F0602B6
                    break;
            }
            localTextView2.setBackgroundColor(this.mContext.getResources().getColor(color));
        }
            return localView;
    }

    @Override
    protected final View b()
    {
        LinearLayout localLinearLayout1 = new LinearLayout(this.mContext);
        LinearLayout localLinearLayout2 = new LinearLayout(this.mContext);
        localLinearLayout2.setOrientation(LinearLayout.HORIZONTAL);
        localLinearLayout2.setGravity(Gravity.CENTER_VERTICAL);//16
        int i = this.mFloorPresenter.F();
        localLinearLayout2.setPadding(i, 0, i, 0);
        localLinearLayout2.setLayoutParams(new LinearLayout.LayoutParams(-2, this.mFloorPresenter.G()));
        localLinearLayout1.addView(localLinearLayout2);
        Object localObject = new SimpleDraweeView(this.mContext);
        ((SimpleDraweeView)localObject).setImageResource(R.drawable.home_more_loading_icon);//2130839337
        localLinearLayout2.addView((View)localObject);
        localObject = new TextView(this.mContext);
        ((TextView)localObject).setTextColor(this.mContext.getResources().getColor(R.color.text_color_686868));//2131100636
        ((TextView)localObject).setText("查看全部");
        ((TextView)localObject).setEms(1);
        LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);
        localLayoutParams.leftMargin = this.mFloorPresenter.H();
        localLinearLayout2.addView((View)localObject, localLayoutParams);
        localLinearLayout1.setOnClickListener(new View.OnClickListener(){//j(this)
            @Override
            public void onClick(View v) {
                if (MallPanicFloorAdapter.this.mOnClickListener != null)
                    MallPanicFloorAdapter.this.mOnClickListener.j();
            }
        });
        return (View)localLinearLayout1;
    }

    public float getPageWidth(int paramInt)
    {
        return this.mFloorPresenter.E();
    }
}
