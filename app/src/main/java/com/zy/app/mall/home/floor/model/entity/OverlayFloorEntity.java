package com.zy.app.mall.home.floor.model.entity;

import com.zy.app.mall.home.floor.a.b.MallFloorCommonUtil;
import com.zy.common.utils.DPIUtil;

/**
 * Created by robin on 16-7-27.
 */
public class OverlayFloorEntity extends FloorEntity{
    protected int mInerImgWidth = DPIUtil.getWidthByDesignValue720(420);
    protected int mInerPadding = DPIUtil.getWidthByDesignValue720(13);
    protected int mInerPaddingLeft = DPIUtil.getWidthByDesignValue720(20);
    protected int mOuterImgHeight = DPIUtil.getWidthByDesignValue720(250);
    protected MallFloorCommonUtil._D mOverlayPosEnum = MallFloorCommonUtil._D.LEFT_TOP;

    public OverlayFloorEntity()
    {
        this.mLayoutHeight = this.mOuterImgHeight;
        this.mElementsSizeLimit = 2;
    }

    public int getInerImgWidth()
    {
        return this.mInerImgWidth;
    }

    public int getInerPadding()
    {
        return this.mInerPadding;
    }

    public int getInerPaddingLeft()
    {
        return this.mInerPaddingLeft;
    }

    public MallFloorCommonUtil._D getOverlayPos()
    {
        return this.mOverlayPosEnum;
    }
}
