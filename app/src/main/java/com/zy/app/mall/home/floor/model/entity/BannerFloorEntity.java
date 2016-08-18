package com.zy.app.mall.home.floor.model.entity;

import com.zy.app.mall.R;
import com.zy.app.mall.home.floor.a.b.MallFloorCommonUtil;
import com.zy.app.mall.home.floor.model.entity.ListItemFloorEntity;
import com.zy.common.entity.HomeFloorNewElement;
import com.zy.common.utils.DPIUtil;

import java.util.ArrayList;

/**
 * Created by Robin on 2016/6/16.
 */
public class BannerFloorEntity extends ListItemFloorEntity<HomeFloorNewElement> {
    protected final int VIEW_CHANGE_INTERVAL_RESUME = 1000;
    protected String event_id;
    protected BannerFloorEntity.CarouselPagePadding mCarouselPagePadding = new BannerFloorEntity.CarouselPagePadding(this);
    protected int mCursorHeight = DPIUtil.getWidthByDesignValue720(10);
    protected int mCursorMarginBottom = DPIUtil.getWidthByDesignValue720(10);
    protected int mCursorSpace = DPIUtil.getWidthByDesignValue720(6);
    protected int mCursorWidth = DPIUtil.getWidthByDesignValue720(10);
    protected String mFloorId;
    protected boolean mIsAutoPlay = true;
    protected boolean mIsCarousel = true;
    protected int mLightResource = R.drawable.icon_mall_bannerfloor_point_selected;      //2130839431
    protected int mNormalResource = R.drawable.icon_mall_bannerfloor_point_unselect;     //2130839432
    protected int mScrollDuration = 0;
    protected ArrayList<String> mSourceValues = new ArrayList();

    public BannerFloorEntity.CarouselPagePadding getCarouselPagePadding()
    {
        return this.mCarouselPagePadding;
    }

    public int getCursorHeight()
    {
        return this.mCursorHeight;
    }

    public int getCursorMarginBottom()
    {
        return this.mCursorMarginBottom;
    }

    public int getCursorSpace()
    {
        return this.mCursorSpace;
    }

    public int getCursorWidth()
    {
        return this.mCursorWidth;
    }

    public String getEventId()
    {
        return this.event_id;
    }

    public String getFloorId()
    {
        return this.mFloorId;
    }

    public int getLightResource()
    {
        return this.mLightResource;
    }

    public int getNormalResource()
    {
        return this.mNormalResource;
    }

    public int getScrollDuration()
    {
        return this.mScrollDuration;
    }

    public String getSourceValue(int paramInt)
    {
        if (this.mSourceValues == null)
            return "";
        if ((paramInt < 0) || (paramInt >= this.mSourceValues.size()))
            return "";
        return (String)this.mSourceValues.get(paramInt);
    }

    public boolean isAutoPlay()
    {
        return this.mIsAutoPlay;
    }

    public boolean isCarousel()
    {
        return this.mIsCarousel;
    }

    public void setCarouselPagePadding(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
    {
        this.mCarouselPagePadding = new BannerFloorEntity.CarouselPagePadding(this, paramInt1, paramInt2, paramInt3, paramInt4);
    }

    public void setCursor(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5)
    {
        if (paramInt1 > 0)
            this.mCursorWidth = paramInt1;
        if (paramInt2 > 0)
            this.mCursorHeight = paramInt2;
        if (paramInt3 > 0)
            this.mCursorSpace = paramInt3;
        if (paramInt4 > 0)
            this.mLightResource = paramInt4;
        if (paramInt5 > 0)
            this.mNormalResource = paramInt5;
    }

    public void setEventId(String paramString)
    {
        this.event_id = MallFloorCommonUtil.null2Str(paramString);
    }

    public void setFloorId(String paramString)
    {
        this.mFloorId = MallFloorCommonUtil.null2Str(paramString);
    }

    public void setScrollDuration(int paramInt)
    {
        if (paramInt >= 0)
            this.mScrollDuration = paramInt;
    }

    public void setSourceValues(ArrayList<String> paramArrayList)
    {
        if (this.mSourceValues == null)
            this.mSourceValues = new ArrayList();
        else
            this.mSourceValues.clear();
        this.mSourceValues.addAll(paramArrayList);
        return;

    }


    public class CarouselPagePadding
    {
        public int bottom = 0;
        public int left = 0;
        public int right = 0;
        public int top = 0;

        public CarouselPagePadding(BannerFloorEntity paramBannerFloorEntity)
        {
        }

        public CarouselPagePadding(BannerFloorEntity paramBannerFloorEntity, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
        {
            this.left = DPIUtil.getWidthByDesignValue720(paramInt1);
            this.top = DPIUtil.getWidthByDesignValue720(paramInt2);
            this.right = DPIUtil.getWidthByDesignValue720(paramInt3);
            this.bottom = DPIUtil.getWidthByDesignValue720(paramInt4);
        }
    }
}
