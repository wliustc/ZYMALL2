package com.zy.app.mall.home.floor.model.entity;

/**
 * Created by robin on 16-7-14.
 */
public class UseBigBgFloorEntity extends FloorEntity{
    protected int mInnerLayoutHeight = 0;
    protected int mInnerLayoutMarginBottom = 0;
    protected int mInnerLayoutMarginLeft = 0;
    protected int mInnerLayoutMarginRight = 0;
    protected int mInnerLayoutMarginTop = 0;
    protected boolean mIsUseBigBg = false;

    public int getInnerLayoutHeight()
    {
        if (this.mInnerLayoutHeight <= 0)
            return getLayoutHeight();
        return this.mInnerLayoutHeight;
    }

    public int getInnerLayoutMarginBottom()
    {
        return this.mInnerLayoutMarginBottom;
    }

    public int getInnerLayoutMarginLeft()
    {
        return this.mInnerLayoutMarginLeft;
    }

    public int getInnerLayoutMarginRight()
    {
        return this.mInnerLayoutMarginRight;
    }

    public int getInnerLayoutMarginTop()
    {
        return this.mInnerLayoutMarginTop;
    }

    public boolean isUseBigBg()
    {
        return this.mIsUseBigBg;
    }

    public void setInnerLayoutMargin(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
    {
        int j = 0;
        int i = paramInt1;
        if (paramInt1 < 0)
            i = 0;
        this.mInnerLayoutMarginLeft = i;
        paramInt1 = paramInt2;
        if (paramInt2 < 0)
            paramInt1 = 0;
        this.mInnerLayoutMarginTop = paramInt1;
        paramInt1 = paramInt3;
        if (paramInt3 < 0)
            paramInt1 = 0;
        this.mInnerLayoutMarginRight = paramInt1;
        if (paramInt4 < 0);
        for (paramInt1 = j; ; paramInt1 = paramInt4)
        {
            this.mInnerLayoutMarginBottom = paramInt1;
            this.mInnerLayoutHeight = (this.mLayoutHeight - this.mInnerLayoutMarginTop - this.mInnerLayoutMarginBottom);
            if (this.mInnerLayoutHeight < 0)
                this.mInnerLayoutHeight = getLayoutHeight();
            return;
        }
    }

    public void setIsUseBigBg(boolean paramBoolean)
    {
        this.mIsUseBigBg = paramBoolean;
    }
}
