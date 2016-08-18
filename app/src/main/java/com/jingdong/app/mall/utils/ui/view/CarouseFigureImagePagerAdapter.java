package com.jingdong.app.mall.utils.ui.view;

import android.content.Context;
import android.graphics.Bitmap;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.facebook.drawee.view.SimpleDraweeView;
import com.jingdong.app.mall.utils.CommonUtil;
import com.zy.app.mall.R;
import com.zy.app.mall.home.floor.view.view.DragFloatView;
import com.zy.app.util.image.JDDisplayImageOptions;
import com.zy.common.res.StringUtil;
import com.zy.common.ui.ExceptionDrawable;
import com.zy.common.utils.JDImageUtils;

/**
 * Created by Robin on 2016/6/15.
 */
public class CarouseFigureImagePagerAdapter extends PagerAdapter {
    private Context a;
    private boolean b;
    private DataPresenter c;
    private ImageView d;
    private ImageView e;
    private JDDisplayImageOptions f;

    public CarouseFigureImagePagerAdapter(Context paramContext, boolean paramBoolean, DataPresenter paraml)
    {
        this.a = paramContext;
        this.b = paramBoolean;
        this.c = paraml;
        b();
    }

    private int a(int paramInt)
    {
        int i = paramInt;
        if (this.b)
        {
            i = paramInt;
            if (this.c.size() > 1)
            {
                paramInt = (paramInt - 1) % this.c.size();
                i = paramInt;
                if (paramInt < 0)
                    i = paramInt + this.c.size();
            }
        }
        return i;
    }

    private void a(ImageView paramImageView, String paramString, JDDisplayImageOptions paramJDDisplayImageOptions)
    {
        if (this.f == null)
        {
            if (paramJDDisplayImageOptions == null)
                this.f = new JDDisplayImageOptions().resetViewBeforeLoading(false).showImageOnFail(new ExceptionDrawable(a.getString(R.string.app_name)));
            else
                this.f = paramJDDisplayImageOptions;
        }

            this.f.bitmapConfig(Bitmap.Config.RGB_565);
            if ((paramImageView.getTag(R.id.image_last_url) == null)  //if-eqz v0, :cond_4
                    || (paramString == null)                        //p2, :cond_4
                    || (paramString.equals(paramImageView.getTag(R.id.image_last_url)))   //if-eqz v0, :cond_4
                    || (paramImageView.getTag(JDImageUtils.STATUS_TAG) != null          //if-nez v0, :cond_3
                        && paramImageView.getTag(JDImageUtils.STATUS_TAG).equals(Integer.valueOf(JDImageUtils.STATUS_FAILED))    //if-eqz v0, :cond_1
                        )
                    ) {//2131165370    //if-eqz v0, :cond_4
                    //:cond_4                 break label112;
                if (paramImageView.getTag(R.id.image_last_url) != null)//2131165370
                    JDImageUtils.displayImage(paramString, paramImageView, this.f, false);
                else
                    JDImageUtils.displayImage(paramString, paramImageView, this.f, true);

                    paramImageView.setTag(R.id.image_last_url, paramString);
            }
        //:cond_1
        //:goto_1
            return;
    }

    private boolean a()
    {
        if (this.c != null &&this.b &&this.c.size() >= 2)
              return true;
        return false;
    }

    private void b()
    {
        if (!a())
            return;
        if (this.d == null)
            this.d = c();
        if (this.e == null)
            this.e = c();
        a(this.e, this.c.getImage(this.c.size() - 1), this.c.getDisplayImageOptions());
    }

    private ImageView c()
    {
        SimpleDraweeView localSimpleDraweeView = new SimpleDraweeView(this.a);
        localSimpleDraweeView.setPadding(0, 0, 0, 0);
        localSimpleDraweeView.setScaleType(ImageView.ScaleType.FIT_XY);
        localSimpleDraweeView.setOnClickListener(new View.OnClickListener(){//k(this)
            @Override
            public void onClick(View v) {
                if (!CommonUtil.getInstance().isCanClick())
                    return;
                int i = CarouseFigureImagePagerAdapter.this.a(v.getId());
                if(CarouseFigureImagePagerAdapter.this.c != null)
                    CarouseFigureImagePagerAdapter.this.c.onClick(i);
            }
        });
        return localSimpleDraweeView;
    }

    @Override
    public void destroyItem(ViewGroup paramViewGroup, int paramInt, Object paramObject)
    {
        paramViewGroup.removeView((View)paramObject);
    }

    @Override
    public int getCount()
    {
        int count = 0;
        if (this.c != null)
        {
            if (a())
                count = 2;
            count += this.c.size();
        }
        return count;
    }

    @Override
    public Object instantiateItem(ViewGroup paramViewGroup, int paramInt)
    {
        ImageView localImageView = null;
        try
        {
            if ((this.b) && (this.d != null) && (paramInt == 1))
                localImageView = this.d;
            else if ((this.b) && (this.e != null) && (paramInt == getCount() - 2))
                localImageView = this.e;
            else
                localImageView = c();

                localImageView.setId(paramInt);
                ((ViewPager)paramViewGroup).addView(localImageView);
                a(localImageView, this.c.getImage(a(paramInt)), this.c.getDisplayImageOptions());
        }
        catch (java.lang.Exception e)
        {
            localImageView = new SimpleDraweeView(this.a);
        }
        return  localImageView;
    }

    @Override
    public boolean isViewFromObject(View paramView, Object paramObject)
    {
        return paramView == paramObject;
    }

    @Override
    public void notifyDataSetChanged()
    {
        b();
        super.notifyDataSetChanged();
    }

    //l
    public interface DataPresenter {
        //public abstract int a();
        public abstract int size();

        //public abstract String a(int paramInt);
        public abstract String getImage(int paramInt);

        //public abstract JDDisplayImageOptions b();
        public abstract JDDisplayImageOptions getDisplayImageOptions();

        public abstract void onClick(int paramInt);
    }
}
