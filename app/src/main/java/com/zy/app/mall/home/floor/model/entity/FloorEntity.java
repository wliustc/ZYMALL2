package com.zy.app.mall.home.floor.model.entity;

import android.graphics.Point;

import com.zy.app.mall.R;
import com.zy.app.mall.home.floor.a.b.MallFloorCommonUtil;
import com.zy.common.utils.DPIUtil;

/**
 * Created by Robin on 2016/6/5.
 */
public class FloorEntity  implements ISeparationFloorEntity {
    protected final int RIGHTCORNER_TEXTCOLORRES_DEFAULT = 2131100414;
    protected final int TITLECOLORRES_DEFAULT = 2131100413;
    protected int mBottomDividerHeight = 1;
    protected int mDividerColor = -1;
    protected int mDividerColorRes = 2131100412;
    protected int mElementsSizeLimit = 1;
    protected boolean mHasRightCorner = false;
    protected boolean mIsShowTitle = false;
    protected int mItemDividerColor = -1;
    protected int mItemDividerColorRes = 2131100412;
    protected int mItemDividerWidth = 0;
    protected int mLayoutHeight = 0;
    protected int mLayoutLeftRightMargin = 0;
    protected int mLayoutTopBottomMargin = 0;
    protected int mLayoutWidth = DPIUtil.getWidth();
    protected Point mPtImgSize = new Point(DPIUtil.getWidthByDesignValue720(133), this.mTitleImgDefaultHeight);
    protected int mRightCornerRightMargin = DPIUtil.getWidthByDesignValue720(10);
    protected String mRightCornerText = "";
    protected int mRightCornerTextColor = 0xFF000000;
    protected int mRightCornerTextSizePx = DPIUtil.getWidthByDesignValue720(22);
    protected MallFloorCommonUtil._F mSeparationParams = new MallFloorCommonUtil._F();
    protected int mTitleBarBottomMargin = DPIUtil.getWidthByDesignValue720(24);
    protected int mTitleBarHeight = DPIUtil.getWidthByDesignValue720(70);
    protected int mTitleBarLeftMargin = DPIUtil.getWidthByDesignValue720(15);
    protected int mTitleBarRightMargin = 0;
    protected int mTitleBarTopMargin = DPIUtil.getWidthByDesignValue720(20);
    protected int mTitleCenterHeight = DPIUtil.getWidthByDesignValue720(58);
    protected int mTitleImgDefaultHeight = DPIUtil.getWidthByDesignValue720(57);
    protected String mTitleImgUrl = "";
    protected String mTitleText = "";
    protected int mTitleTextColor = 0xFF000000;
    protected Point mTitleTextPadding = new Point(0, DPIUtil.getWidthByDesignValue720(10));
    protected int mTitleTextSizePx = DPIUtil.getWidthByDesignValue720(32);
    protected int mTopDividerHeight = 0;

    public int getBottomDividerHeight()
    {
        return this.mBottomDividerHeight;
    }

    public int getDividerColor()
    {
        return this.mDividerColor;
    }

    public int getDividerColorRes()
    {
        return this.mDividerColorRes;
    }

    public int getItemDividerColor()
    {
        return this.mItemDividerColor;
    }

    public int getItemDividerColorRes()
    {
        return this.mItemDividerColorRes;
    }

    public int getItemDividerWidth()
    {
        return this.mItemDividerWidth;
    }

    public int getLayoutHeight()
    {
        return this.mLayoutHeight;
    }

    public int getLayoutLeftRightMargin()
    {
        return this.mLayoutLeftRightMargin;
    }

    public int getLayoutTopBottomMargin()
    {
        return this.mLayoutTopBottomMargin;
    }

    public int getLayoutWidth()
    {
        return this.mLayoutWidth;
    }

    public int getLimitElementSize()
    {
        return this.mElementsSizeLimit;
    }

    public int getRightCornerRightMargin()
    {
        return this.mRightCornerRightMargin;
    }

    public String getRightCornerText()
    {
        return this.mRightCornerText;
    }

    public int getRightCornerTextColorResValue()
    {
        return R.color.new_home_title_right;//2131100414;
    }

    public int getRightCornerTextSizePx()
    {
        return this.mRightCornerTextSizePx;
    }

    @Override
    public MallFloorCommonUtil._G getSeparationDownloadParams(int paramInt)
    {
        return this.mSeparationParams.a(paramInt);
    }

    @Override
    public MallFloorCommonUtil._F getSeparationParams()
    {
        return this.mSeparationParams;
    }

    public int getTitleBarBottomMargin()
    {
        return this.mTitleBarBottomMargin;
    }

    public int getTitleBarHeight()
    {
        return this.mTitleBarHeight;
    }

    public int getTitleBarLeftMargin()
    {
        return this.mTitleBarLeftMargin;
    }

    public int getTitleBarRightMargin()
    {
        return this.mTitleBarRightMargin;
    }

    public int getTitleBarTopMargin()
    {
        return this.mTitleBarTopMargin;
    }

    public int getTitleCenterHeight()
    {
        return this.mTitleCenterHeight;
    }

    public int getTitleImgDefaultHeight()
    {
        return this.mTitleImgDefaultHeight;
    }

    public Point getTitleImgSize()
    {
        return this.mPtImgSize;
    }

    public String getTitleImgUrl()
    {
        return this.mTitleImgUrl;
    }

    public String getTitleText()
    {
        return this.mTitleText;
    }

    public int getTitleTextColor()
    {
        return this.mTitleTextColor;
    }

    public int getTitleTextColorResValue()
    {
        return R.color.new_home_title;//2131100413;
    }

    public Point getTitleTextPadding()
    {
        return this.mTitleTextPadding;
    }

    public int getTitleTextSizePx()
    {
        return this.mTitleTextSizePx;
    }

    public int getTopDividerHeight()
    {
        return this.mTopDividerHeight;
    }

    public boolean hasBottomDivider()
    {
        return getBottomDividerHeight() > 0;
    }

    public boolean hasItemDivider()
    {
        return getItemDividerWidth() > 0;
    }

    public boolean hasRightCorner()
    {
        return this.mHasRightCorner;
    }

    public boolean hasTopDivider()
    {
        return getTopDividerHeight() > 0;
    }

    public boolean isShowTitle()
    {
        return this.mIsShowTitle;
    }

    public void setBottomDividerHeight(int paramInt)
    {
        this.mBottomDividerHeight = paramInt;
    }

    public void setElementsSizeLimit(int paramInt)
    {
        this.mElementsSizeLimit = paramInt;
    }

    public void setHasRightCorner(boolean paramBoolean)
    {
        this.mHasRightCorner = paramBoolean;
    }

    public void setIsShowTitle(boolean paramBoolean)
    {
        this.mIsShowTitle = paramBoolean;
    }

    public void setLayoutHeightBy720Design(int paramInt)
    {
        if (paramInt < 0)
            return;
        if (paramInt == 0)
        {
            this.mLayoutHeight = 0;
            return;
        }
        this.mLayoutHeight = DPIUtil.getWidthByDesignValue720(paramInt);
    }

    public void setLayoutWidthBy720Design(int paramInt)
    {
        if (paramInt < 0)
            return;
        if (paramInt == 0)
        {
            this.mLayoutWidth = 0;
            return;
        }
        this.mLayoutWidth = DPIUtil.getWidthByDesignValue720(paramInt);
    }

    public void setRightCornerText(String paramString)
    {
        this.mRightCornerText = paramString;
    }

    @Override
    public void setSeparationImgMargin(Point paramPoint)
    {
        this.mSeparationParams.s = paramPoint;
    }

    @Override
    public void setSeparationImgPos(MallFloorCommonUtil._D paramd)
    {
        this.mSeparationParams.p = paramd;
    }

    @Override
    public void setSeparationImgWidthHeightBy720Design(int paramInt1, int paramInt2)
    {
        this.mSeparationParams.q = DPIUtil.getWidthByDesignValue720(paramInt1);
        this.mSeparationParams.r = DPIUtil.getWidthByDesignValue720(paramInt2);
    }

    @Override
    public void setSeparationLabelCharCountLimit(int paramInt)
    {
        this.mSeparationParams.n = paramInt;
    }

    @Override
    public void setSeparationLabelMargin(Point paramPoint)
    {
        this.mSeparationParams.m = paramPoint;
    }

    @Override
    public void setSeparationLabelPadding(Point paramPoint)
    {
        this.mSeparationParams.o = paramPoint;
    }

    @Override
    public void setSeparationLabelPos(int paramInt)
    {
        this.mSeparationParams.l = paramInt;
    }

    @Override
    public void setSeparationLabelTextSizeDp(float paramFloat)
    {
        this.mSeparationParams.textSize1 = paramFloat;
    }

    @Override
    public void setSeparationSubTitleCharCountLimit(int paramInt)
    {
        this.mSeparationParams.i = paramInt;
    }

    @Override
    public void setSeparationTitleCharCountLimit(int paramInt)
    {
        this.mSeparationParams.e = paramInt;
    }

    @Override
    public void setSeparationTitleMargin(Point paramPoint)
    {
        this.mSeparationParams.d = paramPoint;
    }

    public void setTitleImgSize(Point paramPoint)
    {
        if ((paramPoint == null) || (paramPoint.equals(0, 0)))
            return;
        this.mPtImgSize = paramPoint;
    }

    public void setTitleImgUrl(String paramString)
    {
        this.mTitleImgUrl = paramString;
    }

    public void setTitleText(String paramString)
    {
        this.mTitleText = paramString;
    }

    public void setTitleTextColor(int paramInt)
    {
        this.mTitleTextColor = paramInt;
    }
}
