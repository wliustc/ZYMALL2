package com.zy.app.mall.home.floor.view.adapter;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.facebook.drawee.view.SimpleDraweeView;
import com.jingdong.app.mall.home.floor.b.FloorImageLoadCtrl;
import com.zy.app.mall.home.floor.d.b.MallListItemFloorPresenter;

/**
 * Created by Robin on 2016/6/22.
 */
public abstract class MallListItemPagerAdapter<P extends MallListItemFloorPresenter> extends PagerAdapter {
    protected Context mContext;
    protected P mFloorPresenter = null;
    protected OnClickListener mOnClickListener = null;

    public MallListItemPagerAdapter(Context paramContext, P paramP)
    {
        this.mContext = paramContext;
        this.mFloorPresenter = paramP;
    }

    protected View a()
    {
        SimpleDraweeView simpleDraweeView = new SimpleDraweeView(this.mContext);
        simpleDraweeView.setLayoutParams(new LinearLayout.LayoutParams(this.mFloorPresenter.g(), this.mFloorPresenter.h()));
        simpleDraweeView.setScaleType(ImageView.ScaleType.FIT_XY);
        FloorImageLoadCtrl.a(simpleDraweeView, this.mFloorPresenter.i());
        simpleDraweeView.setOnClickListener(new View.OnClickListener(){//h(this)
            @Override
            public void onClick(View v) {
                if (MallListItemPagerAdapter.this.mOnClickListener != null)
                    MallListItemPagerAdapter.this.mOnClickListener.a(v);
            }
        });
        return simpleDraweeView;
    }


    protected abstract View b();

    protected abstract View a(int paramInt);

    //public final void a(OnClickListener parami)
    public final void a(OnClickListener parami)
    {
        this.mOnClickListener = parami;
    }

    @Override
    public void destroyItem(ViewGroup paramViewGroup, int paramInt, Object paramObject)
    {
        paramViewGroup.removeView((View)paramObject);
    }

    @Override
    public int getCount()
    {
        return this.mFloorPresenter.d();
    }

    @Override
    public Object instantiateItem(ViewGroup viewGroup, int paramInt) {
        View localView;
        if ((this.mFloorPresenter.e()) && (paramInt == 0))
            localView = a();
        else if ((this.mFloorPresenter.f()) && (paramInt == getCount() - 1))
            localView = b();
        else if (this.mFloorPresenter.e())
            localView = a(paramInt - 1);
        else
            localView = a(paramInt);
        viewGroup.addView(localView);
        return localView;
    }

    @Override
    public boolean isViewFromObject(View paramView, Object paramObject)
    {
        return paramView == paramObject;
    }

    public interface OnClickListener
    {
        public void a(View paramView);

        public void b(int paramInt);

        public void j();
    }
}
