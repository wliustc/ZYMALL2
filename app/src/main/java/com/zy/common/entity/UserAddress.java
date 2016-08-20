package com.zy.common.entity;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;

import com.alibaba.fastjson.annotation.JSONField;
import com.jd.framework.json.JDJSON;
import com.jingdong.common.utils.JSONObjectProxy;
import com.zy.common.utils.BaiduMapUtils;
import com.zy.common.utils.JSONArrayProxy;

import org.json.JSONObject;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Created by Robin on 2016/8/20.
 */
public class UserAddress implements Parcelable, Serializable {
    public static final int ADDRESS_TYPE_LOCATION = 1;
    public static final int ADDRESS_TYPE_USER = -1;
    public static final int COORD_TYPE_BAIDU = 4;
    public static final int COORD_TYPE_GOOGLE = 3;
    public static final int COORD_TYPE_PHONE = 1;
    public static final int COORD_TYPE_QQ = 2;
    public static final Parcelable.Creator<UserAddress> CREATOR = new Parcelable.Creator<UserAddress>(){
        @Override
        public UserAddress createFromParcel(Parcel source) {
            UserAddress userAddress = new UserAddress();
            userAddress.pin = source.readString();
            userAddress.id = source.readLong();
            userAddress.idCity = Integer.valueOf(source.readInt());
            userAddress.idTown = Integer.valueOf(source.readInt());
            userAddress.idArea = Integer.valueOf(source.readInt());
            userAddress.idProvince = Integer.valueOf(source.readInt());
            userAddress.name = source.readString();
            userAddress.where = source.readString();
            userAddress.typeId = Integer.valueOf(source.readInt());
            userAddress.email = source.readString();
            userAddress.mobile = source.readString();
            userAddress.zip = source.readString();
            userAddress.geoPoint = (GeoPoint)source.readSerializable();
            userAddress.addressDetail = source.readString();
            userAddress.coordType = source.readInt();
            boolean[] arrayOfBoolean = new boolean[3];
            source.readBooleanArray(arrayOfBoolean);
            userAddress.isDefaultAddr = Boolean.valueOf(arrayOfBoolean[0]);
            userAddress.isNoIdTown = Boolean.valueOf(arrayOfBoolean[1]);
            userAddress.isAreaWrong = arrayOfBoolean[2];
            userAddress.ProvinceName = source.readString();
            userAddress.CityName = source.readString();
            userAddress.CountryName = source.readString();
            userAddress.TownName = source.readString();
            userAddress.longitudeDB = source.readDouble();
            userAddress.latitudeDB = source.readDouble();
            return userAddress;
        }

        @Override
        public UserAddress[] newArray(int size) {
            return new UserAddress[size];
        }
    };
    public static final int TYPE_ID_EASY_GO = 0;
    private String CityName;
    private String CountryName;
    private String ProvinceName;
    private String TownName;
    private Integer UserLevel;
    private String addressDetail;
    private int addressType;
    private int coordType = 2;
    private String email;
    private GeoPoint geoPoint;
    private long id;
    private Integer idArea;
    private Integer idCity;
    private Integer idProvince;
    private Integer idTown;
    private String identityCard;
    private boolean isAreaWrong;

    @JSONField(name="addressDefault")
    private Boolean isDefaultAddr;

    @JSONField(name="isIdTown")
    private Boolean isNoIdTown;

    @JSONField(name="Latitude")
    private double latitudeDB = -1.0D;

    @JSONField(name="Longitude")
    private double longitudeDB = -1.0D;

    @JSONField(name="Message")
    private String message;
    private String mobile;
    private String name;
    private String phone;
    private String pin;
    private Integer typeId;
    private String where;
    private String zip;

    public UserAddress()
    {
    }

    public UserAddress(JSONObjectProxy paramJSONObjectProxy)
    {
        try
        {
            setPin(paramJSONObjectProxy.getStringOrNull("pin"));
            setId(paramJSONObjectProxy.getIntOrNull("Id").intValue());
            setIdCity(paramJSONObjectProxy.getIntOrNull("IdCity"));
            setIdTown(paramJSONObjectProxy.getIntOrNull("IdTown"));
            setIdArea(paramJSONObjectProxy.getIntOrNull("IdArea"));
            setIdProvince(paramJSONObjectProxy.getIntOrNull("IdProvince"));
            setName(paramJSONObjectProxy.getStringOrNull("Name"));
            setWhere(paramJSONObjectProxy.getStringOrNull("Where"));
            setTypeId(paramJSONObjectProxy.getIntOrNull("TypeId"));
            setEmail(paramJSONObjectProxy.getStringOrNull("Email"));
            setMobile(paramJSONObjectProxy.getStringOrNull("Mobile"));
            setZip(paramJSONObjectProxy.getStringOrNull("Zip"));
            setAddressDetail(paramJSONObjectProxy.getStringOrNull("addressDetail"));
            setIsNoIdTown(paramJSONObjectProxy.getBooleanOrNull("isIdTown"));
            setMessage(paramJSONObjectProxy.getStringOrNull("Message"));
            setLatitudeDB(paramJSONObjectProxy.getDoubleValue("Latitude"));
            setLongitudeDB(paramJSONObjectProxy.getDoubleValue("Longitude"));
            setCoordType(paramJSONObjectProxy.getIntOrNull("CoordType").intValue());
            if (getCoordType() == 4)
            {
                double[] arrayOfDouble = BaiduMapUtils.a(getLatitudeDB(), getLongitudeDB());
                setLatitudeDB(arrayOfDouble[0]);
                setLongitudeDB(arrayOfDouble[1]);
                setCoordType(2);
            }
            setProvinceName(paramJSONObjectProxy.getStringOrNull("ProvinceName"));
            setCityName(paramJSONObjectProxy.getStringOrNull("CityName"));
            setCountryName(paramJSONObjectProxy.getStringOrNull("CountryName"));
            setTownName(paramJSONObjectProxy.getStringOrNull("TownName"));
            setIsDefaultAddr(Boolean.valueOf(paramJSONObjectProxy.optBoolean("addressDefault")));
            setIdentityCard(paramJSONObjectProxy.optString("identityCard"));
            return;
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    public static UserAddress parser(JSONObject paramJSONObject)
    {
        UserAddress address = (UserAddress) JDJSON.parseObject(paramJSONObject.toString(), UserAddress.class);
        if ((address != null) && (address.getCoordType() == 4))
        {
            double[] arrayOfDouble = BaiduMapUtils.a(address.getLatitudeDB(), address.getLongitudeDB());
            address.setLatitudeDB(arrayOfDouble[0]);
            address.setLongitudeDB(arrayOfDouble[1]);
            address.setCoordType(2);
        }
        return address;
    }

    public static ArrayList<UserAddress> toList(JSONArrayProxy paramJSONArrayPoxy)
    {
        ArrayList localArrayList = new ArrayList();
        if (paramJSONArrayPoxy == null)
            return localArrayList;
        int i = 0;
        while (i < paramJSONArrayPoxy.length())
        {
            JSONObjectProxy localJSONObjectProxy = paramJSONArrayPoxy.getJSONObjectOrNull(i);
            if (localJSONObjectProxy != null)
                localArrayList.add(new UserAddress(localJSONObjectProxy));
            i += 1;
        }
        return localArrayList;
    }

    public Boolean IsDefaultAddr()
    {
        if (this.isDefaultAddr == null)
            return Boolean.valueOf(false);
        return this.isDefaultAddr;
    }

    public int describeContents()
    {
        return 0;
    }

    public boolean equals(Object paramObject)
    {
        if (this != paramObject) {
            if (paramObject == null)
                return false;
            if (getClass() != paramObject.getClass())
                return false;
            UserAddress other = (UserAddress) paramObject;
            if (!getMobile().equals(other.getMobile()))
                return false;
            if (!getName().equals(other.getName()))
                return false;
            if (!getWhere().equals(other.getWhere()))
                return false;
        }
        return true;
    }

    public String getAddressDetail()
    {
        if (this.addressDetail == null)
            return "";
        return this.addressDetail;
    }

    public int getAddressType()
    {
        return this.addressType;
    }

    public String getCityName()
    {
        if (TextUtils.isEmpty(this.CityName))
            return "";
        return this.CityName;
    }

    public int getCoordType()
    {
        return this.coordType;
    }

    public String getCountryName()
    {
        if (TextUtils.isEmpty(this.CountryName))
            return "";
        return this.CountryName;
    }

    public String getEmail()
    {
        if (this.email == null)
            return "";
        return this.email;
    }

    public GeoPoint getGeoPoint()
    {
        return this.geoPoint;
    }

    public long getId()
    {
        return this.id;
    }

    public Integer getIdArea()
    {
        if (this.idArea == null)
            return Integer.valueOf(-1);
        return this.idArea;
    }

    public Integer getIdCity()
    {
        if (this.idCity == null)
            return Integer.valueOf(-1);
        return this.idCity;
    }

    public Integer getIdProvince()
    {
        if (this.idProvince == null)
            return Integer.valueOf(-1);
        return this.idProvince;
    }

    public Integer getIdTown()
    {
        if (this.idTown == null)
            return Integer.valueOf(-1);
        return this.idTown;
    }

    public String getIdentityCard()
    {
        return this.identityCard;
    }

    public Boolean getIsNoIdTown()
    {
        if (this.isNoIdTown == null)
            return Boolean.valueOf(false);
        return this.isNoIdTown;
    }

    public double getLatitudeDB()
    {
        return this.latitudeDB;
    }

    public double getLongitudeDB()
    {
        return this.longitudeDB;
    }

    public String getMessage()
    {
        if (this.message == null)
            return "";
        return this.message;
    }

    public String getMobile()
    {
        if (this.mobile == null)
            return "";
        return this.mobile;
    }

    public String getName()
    {
        if (this.name == null)
            return "";
        return this.name;
    }

    public String getPhone()
    {
        if (TextUtils.isEmpty(this.phone))
            return "";
        return this.phone;
    }

    public String getPin()
    {
        if (this.pin == null)
            return "";
        return this.pin;
    }

    public String getProvinceName()
    {
        if (TextUtils.isEmpty(this.ProvinceName))
            return "";
        return this.ProvinceName;
    }

    public String getTownName()
    {
        if (TextUtils.isEmpty(this.TownName))
            return "";
        return this.TownName;
    }

    public Integer getTypeId()
    {
        if (this.typeId == null)
            return Integer.valueOf(1);
        return this.typeId;
    }

    public Integer getUserLevel()
    {
        if (this.UserLevel == null)
            return Integer.valueOf(0);
        return this.UserLevel;
    }

    public String getWhere()
    {
        if (this.where == null)
            return "";
        return this.where;
    }

    public String getZip()
    {
        if (this.zip == null)
            return "";
        return this.zip;
    }

    public int hashCode()
    {
        int i = 0, j = 0, k = 0;
        if (this.mobile != null)
            i = this.mobile.hashCode();
        if (this.name != null)
            j = this.name.hashCode();
        if (this.where != null)
             k = this.where.hashCode();

        return (j + (i + 31) * 31) * 31 + k;
    }

    public boolean isAddressMatching()
    {
        return (getLongitudeDB() > 0.0D) && (getLongitudeDB() < 1000.0D) && (getLatitudeDB() > 0.0D) && (getLatitudeDB() < 1000.0D) && (getCoordType() > 0);
    }

    public boolean isAreaWrong()
    {
        return this.isAreaWrong;
    }

    public void setAddressDetail(String paramString)
    {
        this.addressDetail = paramString;
    }

    public void setAddressType(int paramInt)
    {
        this.addressType = paramInt;
    }

    public void setCityName(String paramString)
    {
        this.CityName = paramString;
    }

    public void setCoordType(int paramInt)
    {
        this.coordType = paramInt;
    }

    public void setCountryName(String paramString)
    {
        this.CountryName = paramString;
    }

    public void setEmail(String paramString)
    {
        this.email = paramString;
    }

    public void setGeoPoint(GeoPoint paramGeoPoint)
    {
        this.geoPoint = paramGeoPoint;
    }

    public void setId(long paramLong)
    {
        this.id = paramLong;
    }

    public void setIdArea(Integer paramInteger)
    {
        this.idArea = paramInteger;
    }

    public void setIdCity(Integer paramInteger)
    {
        this.idCity = paramInteger;
    }

    public void setIdProvince(Integer paramInteger)
    {
        this.idProvince = paramInteger;
    }

    public void setIdTown(Integer paramInteger)
    {
        this.idTown = paramInteger;
    }

    public void setIdentityCard(String paramString)
    {
        this.identityCard = paramString;
    }

    public void setIsAreaWrong(boolean paramBoolean)
    {
        this.isAreaWrong = paramBoolean;
    }

    public void setIsDefaultAddr(Boolean paramBoolean)
    {
        this.isDefaultAddr = paramBoolean;
    }

    public void setIsNoIdTown(Boolean paramBoolean)
    {
        this.isNoIdTown = paramBoolean;
    }

    public void setLatitudeDB(double paramDouble)
    {
        this.latitudeDB = paramDouble;
    }

    public void setLongitudeDB(double paramDouble)
    {
        this.longitudeDB = paramDouble;
    }

    public void setMessage(String paramString)
    {
        this.message = paramString;
    }

    public void setMobile(String paramString)
    {
        this.mobile = paramString;
    }

    public void setName(String paramString)
    {
        this.name = paramString;
    }

    public void setPhone(String paramString)
    {
        this.phone = paramString;
    }

    public void setPin(String paramString)
    {
        this.pin = paramString;
    }

    public void setProvinceName(String paramString)
    {
        this.ProvinceName = paramString;
    }

    public void setTownName(String paramString)
    {
        this.TownName = paramString;
    }

    public void setTypeId(Integer paramInteger)
    {
        this.typeId = paramInteger;
    }

    public void setUserLevel(Integer paramInteger)
    {
        this.UserLevel = paramInteger;
    }

    public void setWhere(String paramString)
    {
        this.where = paramString;
    }

    public void setZip(String paramString)
    {
        this.zip = paramString;
    }

    public String toString()
    {
        return "UserAddress [pin=" + this.pin + ", id=" + this.id + ", idCity=" + this.idCity + ", idTown=" + this.idTown + ", idArea=" + this.idArea + ", idProvince=" + this.idProvince + ", name=" + this.name + ", where=" + this.where + ", typeId=" + this.typeId + ", email=" + this.email + ", mobile=" + this.mobile + ", zip=" + this.zip + ", addressDetail=" + this.addressDetail + ", isNoIdTown=" + this.isNoIdTown + ", message=" + this.message + "]";
    }

    public void writeToParcel(Parcel paramParcel, int paramInt)
    {
        paramParcel.writeString(this.pin);
        paramParcel.writeLong(getId());
        paramParcel.writeInt(getIdCity().intValue());
        paramParcel.writeInt(getIdTown().intValue());
        paramParcel.writeInt(getIdArea().intValue());
        paramParcel.writeInt(getIdProvince().intValue());
        paramParcel.writeString(this.name);
        paramParcel.writeString(this.where);
        paramParcel.writeInt(getTypeId().intValue());
        paramParcel.writeString(this.email);
        paramParcel.writeString(this.mobile);
        paramParcel.writeString(this.zip);
        paramParcel.writeSerializable(getGeoPoint());
        paramParcel.writeString(this.addressDetail);
        paramParcel.writeInt(getCoordType());
        paramParcel.writeBooleanArray(new boolean[] { IsDefaultAddr().booleanValue(), getIsNoIdTown().booleanValue(), isAreaWrong() });
        paramParcel.writeString(this.ProvinceName);
        paramParcel.writeString(this.CityName);
        paramParcel.writeString(this.CountryName);
        paramParcel.writeString(this.TownName);
        paramParcel.writeDouble(this.longitudeDB);
        paramParcel.writeDouble(this.latitudeDB);
    }
}
