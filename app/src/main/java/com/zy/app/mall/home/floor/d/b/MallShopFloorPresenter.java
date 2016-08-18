package com.zy.app.mall.home.floor.d.b;

import com.jingdong.app.mall.home.floor.d.a.ShopFloorEngine;
import com.zy.app.mall.home.floor.model.entity.ShopFloorEntity;
import com.zy.app.mall.home.floor.view.baseUI.IMallListItemFloorUI;
import com.zy.common.entity.GoodShopModel;

import java.util.List;

/**
 * Created by robin on 16-7-28.
 */
//n
public class MallShopFloorPresenter extends MallListItemFloorPresenter<ShopFloorEntity, ShopFloorEngine, IMallListItemFloorUI>{
    public MallShopFloorPresenter(Class paramClass1, Class paramClass2)
    {
        super(paramClass1, paramClass2);
    }

    public final void A()
    {
        if (this.mFloorEntity.getItemListSize() > this.mFloorEntity.getListItemCountLimit())
        {
            GoodShopModel localGoodShopModel = this.mFloorEntity.getModelToJump();
            localGoodShopModel.getSourceValue();
            localGoodShopModel.getShopCategoriesId();
            getUI();
            this.mFloorEntity.getCatigoriesStr();
        }
    }

    public final void B()
    {
    }

    public final String C()
    {
        return this.mFloorEntity.getCatigoriesStr();
    }

    public final List<GoodShopModel> D()
    {
        return this.mFloorEntity.getList();
    }

    public final int E()
    {
        return this.mFloorEntity.getViewPagerLeftImgWidth();
    }

    public final int F()
    {
        return this.mFloorEntity.getViewPagerRightImgWidth();
    }

    public final int G()
    {
        return this.mFloorEntity.getViewPagerImgMargin();
    }

    public final void c(int paramInt)
    {
        GoodShopModel localGoodShopModel = (GoodShopModel)this.mFloorEntity.getItemByPosition(paramInt);
        localGoodShopModel.getShopCategoriesId();
        localGoodShopModel.getSourceValue();
        getUI();
        this.mFloorEntity.getCatigoriesStr();
    }
}
