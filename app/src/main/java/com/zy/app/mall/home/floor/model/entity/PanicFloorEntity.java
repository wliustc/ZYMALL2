package com.zy.app.mall.home.floor.model.entity;

import android.graphics.Color;

import com.jingdong.common.entity.Product;
import com.jingdong.common.utils.JSONObjectProxy;
import com.zy.app.mall.home.floor.a.b.MallFloorCommonUtil;
import com.zy.app.mall.home.floor.model.entity.ListItemFloorEntity;
import com.zy.common.utils.DPIUtil;

import java.util.HashMap;

/**
 * Created by Robin on 2016/6/22.
 */
public class PanicFloorEntity extends ListItemFloorEntity<Product> {
    protected final float PAGE_WIDTH = 0.29F;
    protected boolean isTestA = true;
    protected final int mAdvertRightDividerLineHeight = DPIUtil.dip2px(76.0F);
    protected final int mAdvertRightDividerLineTopMargin = DPIUtil.dip2px(4.0F);
    protected PanicFloorEntity.BuyTimeViewData mBuyTimeViewData = new PanicFloorEntity.BuyTimeViewData(this);
    protected final int mDisCountMaxLength = 3;
    protected final int mFootTextViewLeftMargin = DPIUtil.dip2px(6.0F);
    protected final int mInnerLayoutHeight = DPIUtil.dip2px(84.0F);
    protected final int mInnerLayoutLeftRightPadding = DPIUtil.dip2px(7.0F);
    protected int mMiaoshaAdvance = 0;
    protected String mNameText;
    protected String mNextRoundKey;
    protected HashMap<String, JSONObjectProxy> mNextRoundMap = new HashMap();
    protected int mProductItemCountLimit = 4;

    public PanicFloorEntity()
    {
        this.mTitleText = "秒杀";
        this.mTopDividerHeight = 1;
    }

    public void clearNextRoundMap()
    {
        this.mNextRoundMap.clear();
    }

    public int getAdvertRightDividerLineHeight()
    {
        return this.mAdvertRightDividerLineHeight;
    }

    public int getAdvertRightDividerLineTopMargin()
    {
        return this.mAdvertRightDividerLineTopMargin;
    }

    public int getBuyTimeLayoutHeight()
    {
        return this.mBuyTimeViewData.layoutHeight;
    }

    public int getBuyTimeLayoutWidth()
    {
        return this.mBuyTimeViewData.layoutWidth;
    }

    public PanicFloorEntity.BuyTimeViewData getBuyTimeViewData()
    {
        return this.mBuyTimeViewData;
    }

    public int getDisCountMaxLength()
    {
        return 3;
    }

    public int getFootTextViewLeftMargin()
    {
        return this.mFootTextViewLeftMargin;
    }

    public int getInnerLayoutHeight()
    {
        return this.mInnerLayoutHeight;
    }

    public int getInnerLayoutLeftRightPadding()
    {
        return this.mInnerLayoutLeftRightPadding;
    }

    public int getMiaoshaAdvance()
    {
        return this.mMiaoshaAdvance;
    }

    public String getNameText()
    {
        return this.mNameText;
    }

    public JSONObjectProxy getNextRoundObject()
    {
        return (JSONObjectProxy)this.mNextRoundMap.get(this.mNextRoundKey);
    }

    public float getPageWidth()
    {
        return 0.29F;
    }

    public int getViewPagerBottomMargin()
    {
        return this.mViewPagerBottomMargin;
    }

    public int getViewPagerTopMargin()
    {
        return this.mViewPagerTopMargin;
    }

    public boolean isTestA()
    {
        return this.isTestA;
    }

    public void setBuyTimeTimeMillis(long paramLong)
    {
        this.mBuyTimeViewData.timeMillis = paramLong;
    }

    public void setBuyTimeTimeRemain(Long paramLong)
    {
        this.mBuyTimeViewData.timeRemain = paramLong.longValue();
    }

    public void setIsTestA(boolean paramBoolean)
    {
        this.isTestA = paramBoolean;
    }

    public void setMiaoshaAdvance(int paramInt)
    {
        if (paramInt < 0)
        {
            this.mMiaoshaAdvance = 0;
            return;
        }
        this.mMiaoshaAdvance = paramInt;
    }

    public void setNameText(String paramString)
    {
        this.mNameText = MallFloorCommonUtil.null2Str(paramString);
    }

    public void setNextRoundKey(String paramString)
    {
        this.mNextRoundKey = paramString;
    }

    public void setNextRoundObject(JSONObjectProxy paramJSONObjectProxy)
    {
        this.mNextRoundMap.put(this.mNextRoundKey, paramJSONObjectProxy);
    }

    public class BuyTimeViewData {
        protected int backgroundColor = Color.parseColor("#bbbbbb");
        protected int backgroundHeight = DPIUtil.getWidthByDesignValue720(32);
        protected int backgroundWidth = DPIUtil.getWidthByDesignValue720(42);
        protected int layoutHeight = this.backgroundHeight + DPIUtil.dip2px(2.0F) * 2;
        protected int layoutWidth = this.backgroundWidth * 3 + DPIUtil.dip2px(2.0F) * 10;
        protected long timeMillis;
        protected int timePointColor = Color.parseColor("#4e4e4e");
        protected long timeRemain;
        protected int timeTextColor = Color.parseColor("#4e4e4e");
        protected int timeTextSizePx = DPIUtil.getWidthByDesignValue720(24);

        public BuyTimeViewData(PanicFloorEntity paramPanicFloorEntity)
        {
        }

        public int getBackgroundColor()
        {
            return this.backgroundColor;
        }

        public int getBackgroundHeight()
        {
            return this.backgroundHeight;
        }

        public int getBackgroundWidth()
        {
            return this.backgroundWidth;
        }

        public int getLayoutHeight()
        {
            return this.layoutHeight;
        }

        public int getLayoutWidth()
        {
            return this.layoutWidth;
        }

        public long getTimeMillis()
        {
            return this.timeMillis;
        }

        public int getTimePointColor()
        {
            return this.timePointColor;
        }

        public long getTimeRemain()
        {
            return this.timeRemain;
        }

        public int getTimeTextColor()
        {
            return this.timeTextColor;
        }

        public int getTimeTextSizePx()
        {
            return this.timeTextSizePx;
        }
    }
}
