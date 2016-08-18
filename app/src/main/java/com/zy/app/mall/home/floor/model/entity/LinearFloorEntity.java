package com.zy.app.mall.home.floor.model.entity;

import java.util.ArrayList;

/**
 * Created by robin on 16-7-22.
 */
public class LinearFloorEntity extends UseBigBgFloorEntity{
    protected int mItemCount = 1;
    protected int mItemPadding = 0;
    protected ArrayList<Integer> mItemsWidths = new ArrayList();

    public LinearFloorEntity()
    {
        this.mItemDividerWidth = 2;
    }

    public int getItemViewCount()
    {
        return this.mItemCount;
    }

    public int getItemWidth(int paramInt)
    {
        if ((paramInt < 0) || (paramInt >= this.mItemsWidths.size()))
            return 0;
        return ((Integer)this.mItemsWidths.get(paramInt)).intValue();
    }

    public boolean isHaveItemWidths()
    {
        return !this.mItemsWidths.isEmpty();
    }

    public void setItemCount(int paramInt)
    {
        if (paramInt <= 0)
            return;
        this.mItemCount = paramInt;
    }

    public void setItemDividerWidth(int paramInt)
    {
        if (paramInt < 0)
            return;
        this.mItemDividerWidth = paramInt;
    }

    public void setItemPadding(int paramInt)
    {
        if (paramInt < 0)
            return;
        this.mItemPadding = paramInt;
    }

    public void setItemsWidth(ArrayList<Integer> paramArrayList)
    {
        if (paramArrayList != null)
        {
            this.mItemsWidths.clear();
            this.mItemsWidths.addAll(paramArrayList);
        }
    }
}
