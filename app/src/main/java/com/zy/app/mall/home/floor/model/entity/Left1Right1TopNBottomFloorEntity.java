package com.zy.app.mall.home.floor.model.entity;

import com.zy.common.utils.DPIUtil;

/**
 * Created by robin on 16-7-27.
 */
public class Left1Right1TopNBottomFloorEntity extends UseBigBgFloorEntity{
    protected int mLeftItemWidth = 0;
    protected int mRightBottomItemCount = 2;
    protected int mRightTopItemHeight = 0;

    public Left1Right1TopNBottomFloorEntity()
    {
        this.mElementsSizeLimit = 3;
        this.mItemDividerWidth = 2;
    }

    public int getLeftItemWidth()
    {
        return this.mLeftItemWidth;
    }

    public int getRightBottomItemCount()
    {
        return this.mRightBottomItemCount;
    }

    public int getRightTopItemHeight()
    {
        return this.mRightTopItemHeight;
    }

    public void setItemDividerWidth(int paramInt)
    {
        if (paramInt < 0)
            return;
        this.mItemDividerWidth = paramInt;
    }

    public void setLeftItemWidthBy720Design(int paramInt)
    {
        if (paramInt < 0)
            return;
        this.mLeftItemWidth = DPIUtil.getWidthByDesignValue720(paramInt);
    }

    public void setRightBottomItemCount(int paramInt)
    {
        if (paramInt <= 0)
            return;
        this.mRightBottomItemCount = paramInt;
    }

    public void setRightTopItemHeightBy720Design(int paramInt)
    {
        if (paramInt < 0)
            return;
        this.mRightTopItemHeight = DPIUtil.getWidthByDesignValue720(paramInt);
    }
}
