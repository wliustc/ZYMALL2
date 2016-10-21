package com.zy.common.entity;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by Robin on 2016/10/21.
 */
public class CatelogyLevelFour implements Parcelable {
    public static final Parcelable.Creator<CatelogyLevelFour> CREATOR = new Parcelable.Creator<CatelogyLevelFour>(){//CatelogyLevelFour.1()
        @Override
        public CatelogyLevelFour createFromParcel(Parcel source) {
            return new CatelogyLevelFour(source);
        }

        @Override
        public CatelogyLevelFour[] newArray(int size) {
            return new CatelogyLevelFour[size];
        }
    };
    private String catalogId;
    private String catalogName;

    public CatelogyLevelFour()
    {
    }

    private CatelogyLevelFour(Parcel paramParcel)
    {
        this.catalogId = paramParcel.readString();
        this.catalogName = paramParcel.readString();
    }

    public int describeContents()
    {
        return 0;
    }

    public String getCatalogId()
    {
        return this.catalogId;
    }

    public String getCatalogName()
    {
        return this.catalogName;
    }

    public void setCatalogId(String paramString)
    {
        this.catalogId = paramString;
    }

    public void setCatalogName(String paramString)
    {
        this.catalogName = paramString;
    }

    public void writeToParcel(Parcel paramParcel, int paramInt)
    {
        paramParcel.writeString(this.catalogId);
        paramParcel.writeString(this.catalogName);
    }
}
