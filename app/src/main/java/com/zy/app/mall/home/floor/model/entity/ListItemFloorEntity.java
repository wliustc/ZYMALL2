package com.zy.app.mall.home.floor.model.entity;

import android.content.Context;
import android.graphics.Typeface;
import android.text.TextUtils;

import com.zy.app.mall.home.floor.a.b.MallFloorCommonUtil;
import com.zy.common.utils.DPIUtil;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Robin on 2016/6/16.
 */
public class ListItemFloorEntity<T> extends FloorEntity {
    public final int VIEW_CHANGE_INTERVAL = 4000;
    protected String mAdvertImg;
    protected String mAdvertJump;
    protected int mContentHeight = DPIUtil.dip2px(120.0F);
    protected int mContentWidth = (int)Math.floor(DPIUtil.getWidth() / 3.5D);
    protected boolean mIsHaveAdvert = false;
    protected int mListItemCountLimit = 0;
    protected List<T> mLsItemTmp = new ArrayList();
    protected List<T> mLsItems = new ArrayList();
    protected ListItemFloorEntity<T>.MaiDianData mMaiDianData = new ListItemFloorEntity.MaiDianData(this);
    protected String mRcJumpType = "";
    protected Typeface mSpecialTextTypeFace = null;
    protected int mViewPagerBottomMargin = DPIUtil.getWidthByDesignValue720(30);
    protected int mViewPagerTopMargin = DPIUtil.getWidthByDesignValue720(24);

    public String getAdvertImgUrl()
    {
        return this.mAdvertImg;
    }

    public String getAdvertJump()
    {
        return this.mAdvertJump;
    }

    public int getContentHeight()
    {
        return this.mContentHeight;
    }

    public int getContentWidth()
    {
        return this.mContentWidth;
    }

    public T getItemByPosition(int paramInt)
    {
        if (getItemListSize() <= paramInt)
            return null;
        return this.mLsItems.get(paramInt);
    }

    public List<T> getItemList()
    {
        return this.mLsItems;
    }

    public int getItemListSize()
    {
        if (this.mLsItems == null)
            return 0;
        return this.mLsItems.size();
    }

    public Object getLastItem()
    {
        if (isItemListEmpty())
            return Long.valueOf(0L);
        return getListLastItem(this.mLsItems);
    }

    public int getListItemCountLimit()
    {
        return this.mListItemCountLimit;
    }

    public T getListLastItem(List<T> paramList)
    {
        if (isListEmpty(paramList))
            return null;
        return paramList.get(paramList.size() - 1);
    }

    public String getMaiDianSourceValue(boolean paramBoolean)
    {
        if (paramBoolean)
            return this.mMaiDianData.rcSourceValue;
        return this.mMaiDianData.sourceValue;
    }

    public String getRcJumpType()
    {
        return this.mRcJumpType;
    }

    public Typeface getSpecialTextTypeFace(Context paramContext)
    {
        if (this.mSpecialTextTypeFace == null)
            this.mSpecialTextTypeFace = Typeface.createFromAsset(paramContext.getAssets(), "font/number.ttf");
        return this.mSpecialTextTypeFace;
    }

    public boolean isHaveAdvert()
    {
        return (this.mIsHaveAdvert) && (!TextUtils.isEmpty(this.mAdvertImg));
    }

    public boolean isItemListEmpty()
    {
        return isListEmpty(this.mLsItems);
    }

    public boolean isListEmpty(List<T> paramList)
    {
        return (paramList == null) || (paramList.size() == 0);
    }

    public void removeLastItem()
    {
        if (!isItemListEmpty())
            this.mLsItems.remove(this.mLsItems.size() - 1);
    }

    public void removeListLastItem(List<T> paramList)
    {
        if (!isListEmpty(paramList))
            paramList.remove(paramList.size() - 1);
    }

    public void resetItemList(List<T> paramList)
    {
        this.mLsItems.clear();
        if (paramList != null)
            this.mLsItems.addAll(paramList);
    }

    public void resetItemListFromTmp()
    {
        resetItemList(this.mLsItemTmp);
    }

    public void resetItemTmpList(List<T> paramList)
    {
        this.mLsItemTmp.clear();
        if (paramList != null)
            this.mLsItemTmp.addAll(paramList);
    }

    public void setAdvertImg(String paramString)
    {
        if (paramString == null)
            this.mAdvertImg = "";
        else
            this.mAdvertImg = paramString;
        if(this.mAdvertImg.equalsIgnoreCase("null")){
            this.mAdvertImg = "";
            this.mIsHaveAdvert = false;
        }else
            this.mIsHaveAdvert = true;
        return;
    }

    public void setAdvertJump(String paramString)
    {
        this.mAdvertJump = MallFloorCommonUtil.null2Str(paramString);
    }

    public void setMaiDianData(String paramString1, String paramString2)
    {
        this.mMaiDianData.setData(paramString1, paramString2);
    }

    public void setRcJumpType(String paramString)
    {
        this.mRcJumpType = MallFloorCommonUtil.null2Str(paramString);
    }

    public class MaiDianData
    {
        protected String rcSourceValue;
        protected String sourceValue;

        public MaiDianData(ListItemFloorEntity paramListItemFloorEntity)
        {
        }

        public String getRcSourceValue()
        {
            return this.rcSourceValue;
        }

        public String getSourceValue()
        {
            return this.sourceValue;
        }

        public void setData(String paramString1, String paramString2)
        {
            this.rcSourceValue = MallFloorCommonUtil.null2Str(paramString1);
            this.sourceValue = MallFloorCommonUtil.null2Str(paramString2);
        }
    }
}
