package com.zy.app.mall.home.floor.model.entity;

import com.zy.common.entity.GoodShopModel;
import com.zy.common.utils.DPIUtil;

import java.util.List;

/**
 * Created by robin on 16-7-28.
 */
public class ShopFloorEntity extends ListItemFloorEntity<GoodShopModel>{
    protected String mCatigoriesStr;
    protected GoodShopModel mModelToJump = null;
    protected int mViewPagerImgMargin = DPIUtil.getWidthByDesignValue720(6);
    protected int mViewPagerItemMargin = DPIUtil.getWidthByDesignValue720(9);
    protected int mViewPagerLeftImgWidth = DPIUtil.getWidthByDesignValue720(200);
    protected int mViewPagerRightImgWidth = DPIUtil.getWidthByDesignValue720(97);

    public ShopFloorEntity()
    {
        this.mLayoutHeight = 0;
        this.mListItemCountLimit = 4;
    }

    public String getCatigoriesStr()
    {
        return this.mCatigoriesStr;
    }

    public List<GoodShopModel> getList()
    {
        return getItemList();
    }

    public GoodShopModel getModelToJump()
    {
        return this.mModelToJump;
    }

    public int getViewPagerImgMargin()
    {
        return this.mViewPagerImgMargin;
    }

    public int getViewPagerItemMargin()
    {
        return this.mViewPagerItemMargin;
    }

    public int getViewPagerLeftImgWidth()
    {
        return this.mViewPagerLeftImgWidth;
    }

    public int getViewPagerRightImgWidth()
    {
        return this.mViewPagerRightImgWidth;
    }

    public void setCatigoriesStr(String paramString)
    {
        this.mCatigoriesStr = paramString;
    }

    public void setModelToJump(GoodShopModel paramGoodShopModel)
    {
        this.mModelToJump = paramGoodShopModel;
    }
}
