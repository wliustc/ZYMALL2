package com.zy.app.mall.home.floor.model.entity;

import com.zy.common.utils.DPIUtil;

/**
 * Created by robin on 16-7-14.
 */
public class Left1RightNFloorEntity extends UseBigBgFloorEntity{
    protected int mImageBorderColor = -1;
    protected int mImageBorderWidth = 0;
    protected boolean mIsHaveDivider = true;
    protected int mLayoutPadding = 0;
    protected int mLeftItemWidth = 0;
    protected int mRightItemCount = 1;

    public Left1RightNFloorEntity()
    {
        this.mItemDividerWidth = 2;
        this.mElementsSizeLimit = 2;
    }

    public int getImageBorderColor()
    {
        return this.mImageBorderColor;
    }

    public int getImageBorderWidth()
    {
        return this.mImageBorderWidth;
    }

    public boolean getIsHaveDivider()
    {
        return this.mIsHaveDivider;
    }

    public int getLayoutPadding()
    {
        return this.mLayoutPadding;
    }

    public int getLeftItemWidth()
    {
        return this.mLeftItemWidth;
    }

    public int getRightItemCount()
    {
        if (this.mRightItemCount <= 0)
            return 2;
        return this.mRightItemCount;
    }

    public void setImageBorderWidth(int paramInt)
    {
        this.mImageBorderWidth = DPIUtil.getWidthByDesignValue720(paramInt);
    }

    public void setIsHaveDivider(boolean paramBoolean)
    {
        this.mIsHaveDivider = paramBoolean;
    }

    public void setLayoutPaddingBy720Design(int paramInt)
    {
        this.mLayoutPadding = DPIUtil.getWidthByDesignValue720(paramInt);
    }

    public void setLeftItemWidthBy720Design(int paramInt)
    {
        this.mLeftItemWidth = DPIUtil.getWidthByDesignValue720(paramInt);
    }

    public void setRightItemCount(int paramInt)
    {
        this.mRightItemCount = paramInt;
    }

}
