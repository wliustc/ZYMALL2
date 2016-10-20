package com.zy.common.ranking.bean;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;

/**
 * Created by Robin on 2016/10/21.
 */
public class RankAddress implements Parcelable {
    public static final Parcelable.Creator<RankAddress> CREATOR = new Parcelable.Creator<RankAddress>(){
        @Override
        public RankAddress createFromParcel(Parcel source) {
            return new RankAddress(source);
        }

        @Override
        public RankAddress[] newArray(int size) {
            return new RankAddress[size];
        }
    };
    private String areaAbTest;
    private String cityId;
    private String cityName;
    private String proviceId;
    private String proviceName;
    private boolean useProvinceData;

    public RankAddress()
    {
    }

    protected RankAddress(Parcel paramParcel)
    {
        this.proviceId = paramParcel.readString();
        this.proviceName = paramParcel.readString();
        this.cityId = paramParcel.readString();
        this.cityName = paramParcel.readString();
        if (paramParcel.readByte() != 0);
        for (boolean bool = true; ; bool = false)
        {
            this.useProvinceData = bool;
            this.areaAbTest = paramParcel.readString();
            return;
        }
    }

    public RankAddress(String paramString1, String paramString2, String paramString3, String paramString4, boolean paramBoolean)
    {
        this.proviceId = paramString1;
        this.proviceName = paramString2;
        this.cityId = paramString3;
        this.cityName = paramString4;
        this.useProvinceData = paramBoolean;
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
        if ((paramObject instanceof RankAddress))
        {
            String str1 = ((RankAddress)paramObject).proviceId;
            String str2 = ((RankAddress)paramObject).cityId;
            boolean bool = ((RankAddress)paramObject).useProvinceData;
            return (equals(str1, this.proviceId)) && (equals(str2, this.cityId)) && (bool == this.useProvinceData);
        }
        return false;
    }

    public String getAreaAbTest()
    {
        return this.areaAbTest;
    }

    public String getCityId()
    {
        return this.cityId;
    }

    public String getCityName()
    {
        if (!TextUtils.isEmpty(this.cityName))
            this.cityName = this.cityName.replace("市", "");
        return this.cityName;
    }

    public String getProviceId()
    {
        return this.proviceId;
    }

    public String getProviceName()
    {
        if (!TextUtils.isEmpty(this.proviceName))
            this.proviceName = this.proviceName.replace("省", "");
        return this.proviceName;
    }

    public boolean isUseProvinceData()
    {
        return this.useProvinceData;
    }

    public void setAreaAbTest(String paramString)
    {
        this.areaAbTest = paramString;
    }

    public void setCityId(String paramString)
    {
        this.cityId = paramString;
    }

    public void setCityName(String paramString)
    {
        this.cityName = paramString;
    }

    public void setProviceId(String paramString)
    {
        this.proviceId = paramString;
    }

    public void setProviceName(String paramString)
    {
        this.proviceName = paramString;
    }

    public void setUseProvinceData(boolean paramBoolean)
    {
        this.useProvinceData = paramBoolean;
    }

    public String toString()
    {
        return "ProvinceId: " + this.proviceId + ", ProvinceName: " + this.proviceName + ", cityId: " + this.cityId + ", cityName: " + this.cityName + ", useProvinceData: " + this.useProvinceData;
    }

    public void writeToParcel(Parcel paramParcel, int paramInt)
    {
        paramParcel.writeString(this.proviceId);
        paramParcel.writeString(this.proviceName);
        paramParcel.writeString(this.cityId);
        paramParcel.writeString(this.cityName);
        byte b = 0;
        if (this.useProvinceData)
            b = 1;

            paramParcel.writeByte(b);
            paramParcel.writeString(this.areaAbTest);
            return;

    }
}
