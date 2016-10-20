package com.zy.common.ranking.bean;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.List;

/**
 * Created by Robin on 2016/10/21.
 */
public class RankList {
    private String abFlag;
    private String areaAbTest;
    private String cate2IdName;
    private List<RankList.CateListEntity> cateList;
    private String code;
    private String promptUrl;
    private List<RankList.RankListEntity> rankList;
    private String rankTitle;
    private String shareContent;
    private String shareTitle;
    private String shareUrl;
    private String testType;

    public String getAbFlag()
    {
        return this.abFlag;
    }

    public String getAreaAbTest()
    {
        return this.areaAbTest;
    }

    public String getCate2IdName()
    {
        return this.cate2IdName;
    }

    public List<CateListEntity> getCateList()
    {
        return this.cateList;
    }

    public String getCode()
    {
        return this.code;
    }

    public String getPromptUrl()
    {
        return this.promptUrl;
    }

    public List<RankList.RankListEntity> getRankList()
    {
        return this.rankList;
    }

    public String getRankTitle()
    {
        return this.rankTitle;
    }

    public String getShareContent()
    {
        return this.shareContent;
    }

    public String getShareTitle()
    {
        return this.shareTitle;
    }

    public String getShareUrl()
    {
        return this.shareUrl;
    }

    public String getTestType()
    {
        return this.testType;
    }

    public void setAbFlag(String paramString)
    {
        this.abFlag = paramString;
    }

    public void setAreaAbTest(String paramString)
    {
        this.areaAbTest = paramString;
    }

    public void setCate2IdName(String paramString)
    {
        this.cate2IdName = paramString;
    }

    public void setCateList(List<RankList.CateListEntity> paramList)
    {
        this.cateList = paramList;
    }

    public void setCode(String paramString)
    {
        this.code = paramString;
    }

    public void setPromptUrl(String paramString)
    {
        this.promptUrl = paramString;
    }

    public void setRankList(List<RankList.RankListEntity> paramList)
    {
        this.rankList = paramList;
    }

    public void setRankTitle(String paramString)
    {
        this.rankTitle = paramString;
    }

    public void setShareContent(String paramString)
    {
        this.shareContent = paramString;
    }

    public void setShareTitle(String paramString)
    {
        this.shareTitle = paramString;
    }

    public void setShareUrl(String paramString)
    {
        this.shareUrl = paramString;
    }

    public void setTestType(String paramString)
    {
        this.testType = paramString;
    }

    public static class CateListEntity
            implements Parcelable
    {
        public static final Parcelable.Creator<CateListEntity> CREATOR = new Parcelable.Creator<RankList.CateListEntity>(){//RankList.CateListEntity.1()
            @Override
            public CateListEntity createFromParcel(Parcel source) {
                return new CateListEntity(source);
            }

            @Override
            public CateListEntity[] newArray(int size) {
                return new CateListEntity[size];
            }
        };
        private String cateId;
        private String cateName;
        private boolean isNew;

        public CateListEntity()
        {
        }

        protected CateListEntity(Parcel paramParcel)
        {
            this.cateId = paramParcel.readString();
            this.cateName = paramParcel.readString();
            if (paramParcel.readByte() != 0);
            for (boolean bool = true; ; bool = false)
            {
                this.isNew = bool;
                return;
            }
        }

        public static boolean equals(Object paramObject1, Object paramObject2)
        {
            return (paramObject1 == paramObject2) || ((paramObject1 != null) && (paramObject1.equals(paramObject2)));
        }

        public int describeContents()
        {
            return 0;
        }

        public boolean equals(Object paramObject)
        {
            if (paramObject == this)
                return true;
            if ((paramObject instanceof CateListEntity))
                return equals(((CateListEntity)paramObject).cateId, this.cateId);
            return false;
        }

        public String getCateId()
        {
            return this.cateId;
        }

        public String getCateName()
        {
            return this.cateName;
        }

        public boolean isNew()
        {
            return this.isNew;
        }

        public void setCateId(String paramString)
        {
            this.cateId = paramString;
        }

        public void setCateName(String paramString)
        {
            this.cateName = paramString;
        }

        public void setIsNew(boolean paramBoolean)
        {
            this.isNew = paramBoolean;
        }

        public void writeToParcel(Parcel paramParcel, int paramInt)
        {
            paramParcel.writeString(this.cateId);
            paramParcel.writeString(this.cateName);
            if (this.isNew);
            for (byte b = 1; ; b = 0)
            {
                paramParcel.writeByte(b);
                return;
            }
        }
    }

    public static class RankListEntity
    {
        private String rankId;
        private String rankName;
        private String toast;

        public String getRankId()
        {
            return this.rankId;
        }

        public String getRankName()
        {
            return this.rankName;
        }

        public String getToast()
        {
            return this.toast;
        }

        public void setRankId(String paramString)
        {
            this.rankId = paramString;
        }

        public void setRankName(String paramString)
        {
            this.rankName = paramString;
        }

        public void setToast(String paramString)
        {
            this.toast = paramString;
        }
    }
}
