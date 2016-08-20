package com.zy.common.entity;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.Serializable;

/**
 * Created by Robin on 2016/8/20.
 */
public class AddressGlobal implements Parcelable, Serializable {
    public static final Parcelable.Creator<AddressGlobal> CREATOR = new Parcelable.Creator<AddressGlobal>(){//AddressGlobal.1()
        @Override
        public AddressGlobal createFromParcel(Parcel source) {
            return  new AddressGlobal(source);
        }

        @Override
        public AddressGlobal[] newArray(int size) {
            return new AddressGlobal[size];
        }
    };
    private String CoordType;
    private String addressDetail;
    private String areaName;
    private String cityName;
    private long id;
    private int idArea;
    private int idCity;
    private int idProvince;
    private int idTown;
    private Boolean isUserAddress;
    private String latitude;
    private String longitude;
    private String mobile;
    private String name;
    private String provinceName;
    private long timeStamp;
    private String townName;
    private String where;

    public AddressGlobal()
    {
    }

    protected AddressGlobal(Parcel paramParcel)
    {
        this.id = paramParcel.readLong();
        this.idProvince = paramParcel.readInt();
        this.idCity = paramParcel.readInt();
        this.idTown = paramParcel.readInt();
        this.idArea = paramParcel.readInt();
        this.where = paramParcel.readString();
        this.provinceName = paramParcel.readString();
        this.cityName = paramParcel.readString();
        this.townName = paramParcel.readString();
        this.areaName = paramParcel.readString();
        this.isUserAddress = ((Boolean)paramParcel.readValue(Boolean.class.getClassLoader()));
        this.name = paramParcel.readString();
        this.mobile = paramParcel.readString();
        this.addressDetail = paramParcel.readString();
        this.longitude = paramParcel.readString();
        this.latitude = paramParcel.readString();
        this.CoordType = paramParcel.readString();
        this.timeStamp = paramParcel.readLong();
    }

    public static AddressGlobal cloneAddressGlobal(AddressGlobal paramAddressGlobal1, AddressGlobal paramAddressGlobal2)
    {
        if ((paramAddressGlobal1 != null) && (paramAddressGlobal2 != null))
        {
            paramAddressGlobal2.setIdProvince(paramAddressGlobal1.getIdProvince());
            paramAddressGlobal2.setIdCity(paramAddressGlobal1.getIdCity());
            paramAddressGlobal2.setIdTown(paramAddressGlobal1.getIdTown());
            paramAddressGlobal2.setIdArea(paramAddressGlobal1.getIdArea());
            paramAddressGlobal2.setProvinceName(paramAddressGlobal1.getProvinceName());
            paramAddressGlobal2.setCityName(paramAddressGlobal1.getCityName());
            paramAddressGlobal2.setTownName(paramAddressGlobal1.getTownName());
            paramAddressGlobal2.setAreaName(paramAddressGlobal1.getAreaName());
        }
        return paramAddressGlobal2;
    }

    private String verificationText(String paramString)
    {
        String str = paramString;
        if (TextUtils.isEmpty(paramString))
            str = "";
        return str;
    }

    public int describeContents()
    {
        return 0;
    }

    public String getAddressDetail()
    {
        return verificationText(this.addressDetail);
    }

    public String getAreaName()
    {
        return verificationText(this.areaName);
    }

    public String getCityName()
    {
        return verificationText(this.cityName);
    }

    public String getCoordType()
    {
        return verificationText(this.CoordType);
    }

    public long getId()
    {
        return this.id;
    }

    public int getIdArea()
    {
        return this.idArea;
    }

    public int getIdCity()
    {
        return this.idCity;
    }

    public int getIdProvince()
    {
        return this.idProvince;
    }

    public int getIdTown()
    {
        return this.idTown;
    }

    public Boolean getIsUserAddress()
    {
        if ((this.isUserAddress != null) && (this.isUserAddress.booleanValue()));
        for (boolean bool = true; ; bool = false)
            return Boolean.valueOf(bool);
    }

    public String getLatitude()
    {
        return verificationText(this.latitude);
    }

    public String getLongitude()
    {
        return verificationText(this.longitude);
    }

    public String getMobile()
    {
        return verificationText(this.mobile);
    }

    public String getName()
    {
        return verificationText(this.name);
    }

    public String getProvinceName()
    {
        return verificationText(this.provinceName);
    }

    public long getTimeStamp()
    {
        return this.timeStamp;
    }

    public String getTownName()
    {
        return verificationText(this.townName);
    }

    public String getWhere()
    {
        return verificationText(this.where);
    }

    public void parseNewCurrendOrderAddress(NewCurrentOrderAddress paramNewCurrentOrderAddress)
    {
        if (paramNewCurrentOrderAddress == null)
            return;
        setId(paramNewCurrentOrderAddress.getId());
        setIdProvince(paramNewCurrentOrderAddress.getIdProvince().intValue());
        setIdCity(paramNewCurrentOrderAddress.getIdCity().intValue());
        setIdTown(paramNewCurrentOrderAddress.getIdTown().intValue());
        setIdArea(paramNewCurrentOrderAddress.getIdArea().intValue());
        setProvinceName(paramNewCurrentOrderAddress.getProvinceName());
        setCityName(paramNewCurrentOrderAddress.getCityName());
        setTownName(paramNewCurrentOrderAddress.getTownName());
        setWhere(paramNewCurrentOrderAddress.getWhere());
        setName(paramNewCurrentOrderAddress.getName());
    }

    public void parseUserAddress(UserAddress paramUserAddress)
    {
        if (paramUserAddress == null)
            return;
        setId(paramUserAddress.getId());
        setIdProvince(paramUserAddress.getIdProvince().intValue());
        setIdCity(paramUserAddress.getIdCity().intValue());
        setIdTown(paramUserAddress.getIdTown().intValue());
        setIdArea(paramUserAddress.getIdArea().intValue());
        setProvinceName(paramUserAddress.getProvinceName());
        setCityName(paramUserAddress.getCityName());
        setTownName(paramUserAddress.getTownName());
        setAreaName(paramUserAddress.getCountryName());
        setWhere(paramUserAddress.getWhere());
        setName(paramUserAddress.getName());
    }

    public void setAddressDetail(String paramString)
    {
        this.addressDetail = paramString;
    }

    public void setAreaName(String paramString)
    {
        this.areaName = paramString;
    }

    public void setCityName(String paramString)
    {
        this.cityName = paramString;
    }

    public void setCoordType(String paramString)
    {
        this.CoordType = paramString;
    }

    public void setId(long paramLong)
    {
        this.id = paramLong;
    }

    public void setIdArea(int paramInt)
    {
        this.idArea = paramInt;
    }

    public void setIdCity(int paramInt)
    {
        this.idCity = paramInt;
    }

    public void setIdProvince(int paramInt)
    {
        this.idProvince = paramInt;
    }

    public void setIdTown(int paramInt)
    {
        this.idTown = paramInt;
    }

    public void setIsUserAddress(Boolean paramBoolean)
    {
        this.isUserAddress = paramBoolean;
    }

    public void setLatitude(String paramString)
    {
        this.latitude = paramString;
    }

    public void setLongitude(String paramString)
    {
        this.longitude = paramString;
    }

    public void setMobile(String paramString)
    {
        this.mobile = paramString;
    }

    public void setName(String paramString)
    {
        this.name = paramString;
    }

    public void setProvinceName(String paramString)
    {
        this.provinceName = paramString;
    }

    public void setTimeStamp(long paramLong)
    {
        this.timeStamp = paramLong;
    }

    public void setTownName(String paramString)
    {
        this.townName = paramString;
    }

    public void setWhere(String paramString)
    {
        this.where = paramString;
    }

    public JSONObject toOrderStr()
    {
        JSONObject localJSONObject = new JSONObject();
        try
        {
            localJSONObject.put("Id", getId());
            localJSONObject.put("IdProvince", getIdProvince());
            localJSONObject.put("IdCity", getIdCity());
            localJSONObject.put("IdTown", getIdTown());
            localJSONObject.put("IdArea", getIdArea());
            localJSONObject.put("Name", getName());
            localJSONObject.put("Mobile", getMobile());
            localJSONObject.put("Where", getWhere());
            localJSONObject.put("addressDetail", getAddressDetail());
            localJSONObject.put("longitude", getLongitude());
            localJSONObject.put("latitude", getLatitude());
            localJSONObject.put("CoordType", getCoordType());
            return localJSONObject;
        }
        catch (JSONException localJSONException)
        {
            localJSONException.printStackTrace();
        }
        return localJSONObject;
    }

    public String toString()
    {
        try
        {
            JSONObject localJSONObject = toOrderStr();
            localJSONObject.put("provinceName", getProvinceName());
            localJSONObject.put("cityName", getCityName());
            localJSONObject.put("townName", getTownName());
            localJSONObject.put("areaName", getAreaName());
            localJSONObject.put("isUserAddress", getIsUserAddress());
            localJSONObject.put("timeStamp", System.currentTimeMillis());
            return localJSONObject.toString();
        }
        catch (JSONException localJSONException)
        {
            localJSONException.printStackTrace();
        }
        return "";
    }

    public void writeToParcel(Parcel paramParcel, int paramInt)
    {
        paramParcel.writeLong(this.id);
        paramParcel.writeInt(this.idProvince);
        paramParcel.writeInt(this.idCity);
        paramParcel.writeInt(this.idTown);
        paramParcel.writeInt(this.idArea);
        paramParcel.writeString(this.where);
        paramParcel.writeString(this.provinceName);
        paramParcel.writeString(this.cityName);
        paramParcel.writeString(this.townName);
        paramParcel.writeString(this.areaName);
        paramParcel.writeValue(this.isUserAddress);
        paramParcel.writeString(this.name);
        paramParcel.writeString(this.mobile);
        paramParcel.writeString(this.addressDetail);
        paramParcel.writeString(this.longitude);
        paramParcel.writeString(this.latitude);
        paramParcel.writeString(this.CoordType);
        paramParcel.writeLong(this.timeStamp);
    }
}
