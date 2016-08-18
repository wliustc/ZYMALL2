package com.zy.app.mall.home.floor.view.baseUI;

import android.graphics.Bitmap;

import com.zy.cleanmvp.presenter.IBaseUI;
import com.zy.common.entity.HomeFloorNewElement;
import com.zy.common.entity.HomeFloorNewModel;

/**
 * Created by Robin on 2016/5/16.
 */
//d
public interface IMallFloorUI extends IBaseUI {
    public abstract Object a(HomeFloorNewElement paramHomeFloorNewElement, int paramInt1, int paramInt2, int paramInt3, Object paramObject);

    public abstract void a(int paramInt);

    public abstract void a(int paramInt1, int paramInt2, int paramInt3, int paramInt4);

    public abstract void a(Bitmap paramBitmap);

    public abstract void a(HomeFloorNewModel paramHomeFloorNewModel);

    public abstract void a(boolean paramBoolean);

    public abstract void b();

    public abstract void b(int paramInt1, int paramInt2);

    public abstract void c();

    public abstract void d();

    public abstract void setBackgroundResource(int paramInt);

    public abstract void setPadding(int paramInt1, int paramInt2, int paramInt3, int paramInt4);
}
