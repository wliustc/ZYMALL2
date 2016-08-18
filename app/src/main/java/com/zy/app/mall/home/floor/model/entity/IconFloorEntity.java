package com.zy.app.mall.home.floor.model.entity;

import com.zy.app.mall.home.floor.a.b.MallFloorCommonUtil;
import com.zy.common.entity.AppEntry;
import com.zy.common.utils.DPIUtil;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by robin on 16-7-5.
 */
public class IconFloorEntity extends FloorEntity {
    protected String mAppCenterCode = "appcenter";
    protected String mBgUrl = "";
    protected int mFirstUnitRightPadding = this.mLastUnitLeftPadding;
    protected int mImageSize = DPIUtil.getWidthByDesignValue720(64);
    protected int mItemCountPreRow = 3;
    protected int mLastUnitLeftPadding = 0;
    protected int mLayoutButoomPadding = DPIUtil.getWidthByDesignValue720(25);
    protected int mLayoutLeftPadding = 0;
    protected int mLayoutRightPadding = this.mLayoutLeftPadding;
    protected int mLayoutTopPadding = DPIUtil.getWidthByDesignValue720(31);
    protected List<AppEntry> mList = null;
    protected int mRedDotAll = 0;
    protected int mRowCount = 1;
    protected int mRowTopPadding = DPIUtil.getWidthByDesignValue720(22);
    protected int mTextColor = -8092023;
    protected float mTextSizePx = DPIUtil.getWidthByDesignValue720(23);
    protected int mTextTopMargin = DPIUtil.getWidthByDesignValue720(7);

    public IconFloorEntity()
    {
        this.mLayoutHeight = DPIUtil.getWidthByDesignValue720(276);
    }

    public String getAppCenterCode()
    {
        return this.mAppCenterCode;
    }

    public AppEntry getAppEntryByPos(int paramInt)
    {
        if ((this.mList == null) || (this.mList.size() <= paramInt))
            return null;
        return (AppEntry)this.mList.get(paramInt);
    }

    public String getBgUrl()
    {
        return this.mBgUrl;
    }

    public int getFirstUnitRightPadding()
    {
        return this.mFirstUnitRightPadding;
    }

    public int getIconRealCount()
    {
        if (this.mList == null)
            return 0;
        return this.mList.size();
    }

    public int getIconShowCount()
    {
        int i = getIconRealCount();
        if (i < getMaxIconItemCount())
            return i;
        return getMaxIconItemCount();
    }

    public int getImageSize()
    {
        return this.mImageSize;
    }

    public int getItemCountPreRow()
    {
        return this.mItemCountPreRow;
    }

    public int getLastUnitLeftPadding()
    {
        return this.mLastUnitLeftPadding;
    }

    public int getLayoutBotoomPadding()
    {
        return this.mLayoutButoomPadding;
    }

    public int getLayoutLeftPadding()
    {
        return this.mLayoutLeftPadding;
    }

    public int getLayoutRightPadding()
    {
        return this.mLayoutRightPadding;
    }

    public int getLayoutTopPadding()
    {
        return this.mLayoutTopPadding;
    }

    public int getMaxIconItemCount()
    {
        return this.mItemCountPreRow * this.mRowCount;
    }

    public int getRedDotAll()
    {
        return this.mRedDotAll;
    }

    public int getRowTopPadding()
    {
        return this.mRowTopPadding;
    }

    public int getTextColor()
    {
        return this.mTextColor;
    }

    public float getTextSizePx()
    {
        return this.mTextSizePx;
    }

    public int getTextTopMargin()
    {
        return this.mTextTopMargin;
    }

    public boolean isAppCenterCode(String paramString)
    {
        return (paramString != null) && (paramString.equals(getAppCenterCode()));
    }

    public boolean isAppEntryListHasEnoughItem()
    {
        return (this.mList != null) && (this.mList.size() >= getMaxIconItemCount());
    }

    public boolean isRedDotAll()
    {
        return this.mRedDotAll != 0;
    }

    public void setAppEntryList(List<AppEntry> paramList)
    {
        if (paramList == null)
            this.mList = null;
        if (this.mList == null)
            this.mList = new ArrayList();
        this.mList.clear();
        this.mList.addAll(paramList);
    }

    public void setBgUrl(String paramString)
    {
        this.mBgUrl = MallFloorCommonUtil.null2Str(paramString);
    }

    public void setItemCountPreRow(int paramInt)
    {
        if (paramInt <= 0)
            return;
        this.mItemCountPreRow = paramInt;
    }

    public void setRedDotAll(int paramInt)
    {
        if ((paramInt != 0) && (paramInt != 1))
            return;
        this.mRedDotAll = paramInt;
    }

    public void setRowCount(int paramInt)
    {
        if (paramInt <= 0)
            return;
        this.mRowCount = paramInt;
    }

    public void setTextColor(String paramString)
    {
        this.mTextColor = MallFloorCommonUtil.str2Color(paramString, this.mTextColor);
    }
}
