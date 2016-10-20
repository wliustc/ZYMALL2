package com.zy.jdma.minterface;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by Robin on 2016/10/21.
 */
public class MaInitCommonInfo implements Parcelable {
    public static final Parcelable.Creator<MaInitCommonInfo> CREATOR = new Parcelable.Creator<MaInitCommonInfo>() {//MaInitCommonInfo.1()
        @Override
        public MaInitCommonInfo createFromParcel(Parcel source) {
            return new MaInitCommonInfo(source);
        }

        @Override
        public MaInitCommonInfo[] newArray(int size) {
            return new MaInitCommonInfo[size];
        }
    };
    public String app_device = "";
    public String appv = "";
    public String build = "";
    public String channel = "";
    public String client = "";
    public String guid = "";
    public String pin = "";
    public String proj_id = "";
    public String site_id = "";
    public int zipFlag = 0;

    public MaInitCommonInfo()
    {
    }

    public MaInitCommonInfo(Parcel paramParcel)
    {
        this.appv = paramParcel.readString();
        this.build = paramParcel.readString();
        this.channel = paramParcel.readString();
        this.guid = paramParcel.readString();
        this.app_device = paramParcel.readString();
        this.proj_id = paramParcel.readString();
        this.site_id = paramParcel.readString();
        this.client = paramParcel.readString();
        this.zipFlag = paramParcel.readInt();
        this.pin = paramParcel.readString();
    }

    public int describeContents()
    {
        return 0;
    }

    public void writeToParcel(Parcel paramParcel, int paramInt)
    {
        paramParcel.writeString(this.appv);
        paramParcel.writeString(this.build);
        paramParcel.writeString(this.channel);
        paramParcel.writeString(this.guid);
        paramParcel.writeString(this.app_device);
        paramParcel.writeString(this.proj_id);
        paramParcel.writeString(this.site_id);
        paramParcel.writeString(this.client);
        paramParcel.writeInt(this.zipFlag);
        paramParcel.writeString(this.pin);
    }
}
