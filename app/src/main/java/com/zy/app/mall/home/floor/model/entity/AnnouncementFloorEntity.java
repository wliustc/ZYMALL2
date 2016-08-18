package com.zy.app.mall.home.floor.model.entity;

import com.zy.app.mall.home.floor.a.b.MallFloorCommonUtil;
import com.zy.app.mall.home.floor.model.entity.FloorEntity;
import com.zy.common.entity.HomeFloorNewElement;
import com.zy.common.utils.DPIUtil;

import java.util.ArrayList;

/**
 * Created by Robin on 2016/7/6.
 */
public class AnnouncementFloorEntity extends FloorEntity {
    private final int START_DELAY_TIME = 1000;
    private float mBgRadii = DPIUtil.getWidthByDesignValue720(10);
    private ArrayList<HomeFloorNewElement> mElementList;
    private int mImageHeight = DPIUtil.getWidthByDesignValue720(32);
    private int mImageWidth = DPIUtil.getWidthByDesignValue720(132);
    private int mInnerMargin = DPIUtil.getWidthByDesignValue720(10);
    private String mLeftImageUrl;
    private int mRotateTime = 4;
    private int mTextSizeDp = 14;

    public AnnouncementFloorEntity()
    {
        this.mLayoutHeight = DPIUtil.getWidthByDesignValue720(68);
        this.mLayoutLeftRightMargin = DPIUtil.getWidthByDesignValue720(20);
    }

    public float getBgRadii()
    {
        return this.mBgRadii;
    }

    public int getImageHeight()
    {
        return this.mImageHeight;
    }

    public int getImageWidth()
    {
        return this.mImageWidth;
    }

    public int getInnerMargin()
    {
        return this.mInnerMargin;
    }

    public String getLeftImageUrl()
    {
        return this.mLeftImageUrl;
    }

    public HomeFloorNewElement getListItem(int paramInt)
    {
        int i = getListItemCount();
        if ((paramInt < 0) || (paramInt >= i))
            return null;
        return (HomeFloorNewElement)this.mElementList.get(paramInt);
    }

    public int getListItemCount()
    {
        if (this.mElementList == null)
            return 0;
        return this.mElementList.size();
    }

    public int getRotateTime()
    {
        return this.mRotateTime;
    }

    public int getStartDelayTime()
    {
        return START_DELAY_TIME;
    }

    public float getTextSizeDp()
    {
        return this.mTextSizeDp;
    }

    public boolean isListEmpty()
    {
        return (this.mElementList == null) || (this.mElementList.isEmpty());
    }

    public void setElementList(ArrayList<HomeFloorNewElement> paramArrayList)
    {
        if (paramArrayList != null) {
            if (this.mElementList == null)
                this.mElementList = new ArrayList();
            else
                this.mElementList.clear();
            this.mElementList.addAll(paramArrayList);
        }
        return;

    }

    public void setLeftImageUrl(String paramString)
    {
        this.mLeftImageUrl = MallFloorCommonUtil.null2Str(paramString);
    }

    public void setRotateTime(int paramInt)
    {
        if (paramInt >= 0)
        this.mRotateTime = paramInt;
    }
}
