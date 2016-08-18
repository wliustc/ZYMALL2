package com.zy.app.mall.home.floor.view.baseUI;

import com.jingdong.common.entity.Product;

/**
 * Created by Robin on 2016/6/22.
 */
public interface IMallPanicFloorUI extends IMallListItemFloorUI {
    public abstract void a(int paramInt1, int paramInt2, int paramInt3);

    public abstract void a(Product paramProduct, boolean paramBoolean);

    public abstract void a(Long paramLong);

    public abstract void a(String paramString1, String paramString2);

    public abstract void f();

    public abstract void g();
}
