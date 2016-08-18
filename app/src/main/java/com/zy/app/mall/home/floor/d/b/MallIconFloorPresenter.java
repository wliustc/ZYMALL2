package com.zy.app.mall.home.floor.d.b;

import android.graphics.Bitmap;
import android.text.TextUtils;
import android.view.View;

import com.zy.app.mall.home.floor.a.a.MallFloorEvent;
import com.zy.app.mall.home.floor.d.a.IconFloorEngine;
import com.zy.app.mall.home.floor.d.b.MallFloorPresenter;
import com.zy.app.mall.home.floor.model.entity.IconFloorEntity;
import com.zy.app.mall.home.floor.view.baseUI.IMallIconFloorUI;
import com.zy.app.util.image.assist.JDFailReason;
import com.zy.app.util.image.listener.JDImageLoadingListener;
import com.zy.common.entity.AppEntry;
import com.zy.common.entity.HomeFloorNewElements;
import com.zy.common.entity.HomeFloorNewModel;
import com.zy.common.utils.JDImageUtils;

import org.greenrobot.eventbus.Subscribe;

/**
 * Created by robin on 16-7-5.
 */
//e
public class MallIconFloorPresenter extends MallFloorPresenter<IconFloorEntity, IconFloorEngine, IMallIconFloorUI>
{
    public MallIconFloorPresenter(Class<IconFloorEntity> paramClass, Class<IconFloorEngine> paramClass1)
    {
        super(paramClass, paramClass1);
    }

    public final int a()
    {
        return this.mFloorEntity.getIconShowCount();
    }

    public final String a(AppEntry paramAppEntry)
    {
        if (this.mFloorEntity.isAppCenterCode(paramAppEntry.getAppCode()))
            return this.mFloorEntity.getRedDotAll() + "_" + paramAppEntry.getName();
        return "0_" + paramAppEntry.getName();
    }

    public final void a(int paramInt)
    {
        this.mFloorEntity.setItemCountPreRow(paramInt);
    }

    protected final void a(MallFloorEvent paramb) {
        if (getUI() != null) {
            String str = paramb.getType();
            int i = -1;
            switch (str.hashCode()) {
                case 49://:pswitch_0
                    if (str.equals("1"))
                        i = 0;
                    break;
            }
            switch (i) {
                default:
                    super.onEventMainThread(paramb);
                    break;
                case 0:
                    getUI().a(this.mFloorEntity.getItemCountPreRow(), this.mFloorEntity.getRowTopPadding());
                    break;
            }
        }
    }

    protected final void a(HomeFloorNewModel paramHomeFloorNewModel, HomeFloorNewElements paramHomeFloorNewElements)
    {
        final IMallIconFloorUI ui = getUI();
        if (ui != null){
            ui.setPadding(this.mFloorEntity.getLayoutLeftPadding(), this.mFloorEntity.getLayoutTopPadding(), this.mFloorEntity.getLayoutRightPadding(), this.mFloorEntity.getLayoutBotoomPadding());
            if (!this.mFloorEntity.isAppEntryListHasEnoughItem())
            {
                ui.a(false);
            }else {
                if (!TextUtils.isEmpty(this.mFloorEntity.getBgUrl()))
                    JDImageUtils.loadImage(this.mFloorEntity.getBgUrl(), new JDImageLoadingListener(){//f(this, ui)
                        @Override
                        public void onLoadingCancelled(String paramString, View paramView) {

                        }

                        @Override
                        public void onLoadingComplete(String paramString, View paramView, Bitmap paramBitmap) {
                            ui.a(paramBitmap);
                        }

                        @Override
                        public void onLoadingFailed(String paramString, View paramView, JDFailReason paramJDFailReason) {
                            ui.c();
                        }

                        @Override
                        public void onLoadingStarted(String paramString, View paramView) {

                        }
                    });
                else
                    ui.c();
                ui.a(true);
            }
        }
        return;
    }

    public final boolean a(String paramString)
    {
        return this.mFloorEntity.isAppCenterCode(paramString);
    }

    public final int b()
    {
        return this.mFloorEntity.getItemCountPreRow();
    }

    public final void b(int paramInt)
    {
        this.mFloorEntity.setRowCount(paramInt);
    }

    public final void b(HomeFloorNewModel paramHomeFloorNewModel, HomeFloorNewElements paramHomeFloorNewElements)
    {
        if (getUI() != null)
            getUI().b();
        super.b(paramHomeFloorNewModel, paramHomeFloorNewElements);
    }

    public final int c()
    {
        return this.mFloorEntity.getFirstUnitRightPadding();
    }

    public final AppEntry c(int paramInt)
    {
        return this.mFloorEntity.getAppEntryByPos(paramInt);
    }

    public final int d()
    {
        return this.mFloorEntity.getLastUnitLeftPadding();
    }

    public final int e()
    {
        return this.mFloorEntity.getImageSize();
    }

    public final int f()
    {
        return this.mFloorEntity.getTextTopMargin();
    }

    public final float g()
    {
        return this.mFloorEntity.getTextSizePx();
    }

    public final int h()
    {
        return this.mFloorEntity.getTextColor();
    }

    public final boolean i()
    {
        return this.mFloorEntity.isRedDotAll();
    }

    public final boolean j()
    {
        return this.mFloorEntity.isAppEntryListHasEnoughItem();
    }
}
