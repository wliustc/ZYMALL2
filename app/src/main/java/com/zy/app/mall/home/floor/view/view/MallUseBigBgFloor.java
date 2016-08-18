package com.zy.app.mall.home.floor.view.view;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;

import com.zy.app.mall.home.floor.d.b.MallUseBigBgFloorPresenter;
import com.zy.app.mall.home.floor.view.baseUI.IMallUseBigBgFloorUI;
import com.zy.app.mall.home.floor.view.baseUI.MallBaseFloor;
import com.zy.app.util.image.assist.JDFailReason;
import com.zy.app.util.image.listener.JDImageLoadingListener;
import com.zy.common.entity.HomeFloorNewElement;
import com.zy.common.utils.JDImageUtils;

/**
 * Created by robin on 16-7-15.
 */
public abstract class MallUseBigBgFloor<P extends MallUseBigBgFloorPresenter> extends MallBaseFloor<P>
implements IMallUseBigBgFloorUI {
    public MallUseBigBgFloor(Context paramContext)
    {
        super(paramContext);
    }

    public MallUseBigBgFloor(Context context, AttributeSet attrs)
    {
        super(context, attrs);
    }

    public MallUseBigBgFloor(Context context, AttributeSet attrs, int defStyleAttr)
    {
        super(context, attrs, defStyleAttr);
    }

    public final void a(Bitmap paramBitmap)
    {
        if (paramBitmap == null)
        {
            setBackgroundDrawable(null);
            return;
        }
        setBackgroundDrawable(new BitmapDrawable(getContext().getResources(), paramBitmap));
    }

    public final void a(final HomeFloorNewElement paramHomeFloorNewElement)
    {
        String str = paramHomeFloorNewElement.getImg();
        if ((str == null) || (str.isEmpty()))
            return;
        if (!TextUtils.isEmpty(str))
        {
            JDImageUtils.loadImage(str, new JDImageLoadingListener(){//am(this, paramHomeFloorNewElement)
                @Override
                public void onLoadingCancelled(String paramString, View paramView) {
                    MallUseBigBgFloor.this.m();
                }

                @Override
                public void onLoadingComplete(String paramString, View paramView, Bitmap paramBitmap) {
                    MallUseBigBgFloor.this.a(paramBitmap);
                    if (paramBitmap != null)
                        MallUseBigBgFloor.this.a(MallUseBigBgFloor.this, paramHomeFloorNewElement);
                }

                @Override
                public void onLoadingFailed(String paramString, View paramView, JDFailReason paramJDFailReason) {
                    MallUseBigBgFloor.this.setBackgroundDrawable(null);
                }

                @Override
                public void onLoadingStarted(String paramString, View paramView) {
                    MallUseBigBgFloor.this.l();
                }
            });
            return;
        }
        setBackgroundDrawable(null);
    }

    public final void c()
    {
        setBackgroundDrawable(null);
    }

    public final void c(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
    {
        ((MallUseBigBgFloorPresenter)i()).a(20, 100, 20, 20);
    }

    public final void c(boolean paramBoolean)
    {
        ((MallUseBigBgFloorPresenter)i()).a(true);
    }
}
