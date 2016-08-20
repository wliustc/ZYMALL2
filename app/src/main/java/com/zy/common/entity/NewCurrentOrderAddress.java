package com.zy.common.entity;

import android.text.TextUtils;

import com.zy.common.utils.CommonUtil;

import java.io.Serializable;

/**
 * Created by Robin on 2016/8/20.
 */
public class NewCurrentOrderAddress implements Serializable {
    private boolean addressDefault;
    private String addressDetail;
    private String cityName;
    private String countryName;
    private boolean giftBuyHidePrice;
    private String giftRecImg;
    private String giftSenderConsigneeMobile;
    private String giftSenderConsigneeName;
    private String giftSenderImg;
    private String giftSenderMessage;
    private long id;
    private Integer idArea;
    private Integer idCity;
    private Integer idCompanyBranch;
    private Integer idProvince;
    private Integer idTown;
    private String identityCard;
    private Boolean isIdTown;
    private String mobile;
    private String name;
    private String phone;
    private String pin;
    private String provinceName;
    private String townName;
    private Integer userLevel;
    private String where;
    private String zip;

    public boolean getAddressDefault()
    {
        return this.addressDefault;
    }

    public String getAddressDetail()
    {
        if (TextUtils.isEmpty(this.addressDetail))
            return "";
        return this.addressDetail;
    }

    public String getCityName()
    {
        if (TextUtils.isEmpty(this.cityName))
            return "";
        return this.cityName;
    }

    public String getCountryName()
    {
        if (this.countryName == null)
            return "";
        return this.countryName;
    }

    public String getGiftRecImg()
    {
        if (TextUtils.isEmpty(this.giftRecImg))
            return "";
        return this.giftRecImg;
    }

    public String getGiftSenderConsigneeMobile()
    {
        if (TextUtils.isEmpty(this.giftSenderConsigneeMobile))
            return "";
        return this.giftSenderConsigneeMobile;
    }

    public String getGiftSenderConsigneeName()
    {
        if (TextUtils.isEmpty(this.giftSenderConsigneeName))
            return "";
        return this.giftSenderConsigneeName;
    }

    public String getGiftSenderImg()
    {
        if (TextUtils.isEmpty(this.giftSenderImg))
            return "";
        return this.giftSenderImg;
    }

    public String getGiftSenderMessage()
    {
        if (TextUtils.isEmpty(this.giftSenderMessage))
            return "";
        return this.giftSenderMessage;
    }

    public long getId()
    {
        return this.id;
    }

    public Integer getIdArea()
    {
        if (this.idArea == null)
            return Integer.valueOf(0);
        return this.idArea;
    }

    public Integer getIdCity()
    {
        if (this.idCity == null)
            return Integer.valueOf(0);
        return this.idCity;
    }

    public Integer getIdCompanyBranch()
    {
        if (this.idCompanyBranch == null)
            return Integer.valueOf(0);
        return this.idCompanyBranch;
    }

    public Integer getIdProvince()
    {
        if (this.idProvince == null)
            return Integer.valueOf(0);
        return this.idProvince;
    }

    public Integer getIdTown()
    {
        if (this.idTown == null)
            return Integer.valueOf(0);
        return this.idTown;
    }

    public String getIdentityCard()
    {
        return this.identityCard;
    }

    public Boolean getIsIdTown()
    {
        if (this.isIdTown == null)
            return Boolean.valueOf(false);
        return this.isIdTown;
    }

    public String getMobile()
    {
        if (this.mobile == null)
            return "";
        return CommonUtil.getPhoneNumber(this.mobile);
    }

    public String getName()
    {
        if (this.name == null)
            return "";
        return this.name;
    }

    public String getNormalMobile()
    {
        if (this.mobile == null)
            return "";
        return this.mobile;
    }

    public String getPhone()
    {
        if (this.phone == null)
            return "";
        return CommonUtil.getPhoneNumber(this.phone);
    }

    public String getPin()
    {
        if (this.pin == null)
            return "";
        return this.pin;
    }

    public String getProvinceName()
    {
        if (TextUtils.isEmpty(this.provinceName))
            return "";
        return this.provinceName;
    }

    public String getTownName()
    {
        if (TextUtils.isEmpty(this.townName))
            return "";
        return this.townName;
    }

    public Integer getUserLevel()
    {
        if (this.userLevel == null)
            return Integer.valueOf(0);
        return this.userLevel;
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

    public boolean isGiftBuyHidePrice()
    {
        return this.giftBuyHidePrice;
    }

    public void setAddressDefault(Boolean paramBoolean)
    {
        this.addressDefault = paramBoolean.booleanValue();
    }

    public void setAddressDetail(String paramString)
    {
        this.addressDetail = paramString;
    }

    public void setCityName(String paramString)
    {
        this.cityName = paramString;
    }

    public void setCountryName(String paramString)
    {
        this.countryName = paramString;
    }

    public void setGiftBuyHidePrice(boolean paramBoolean)
    {
        this.giftBuyHidePrice = paramBoolean;
    }

    public void setGiftRecImg(String paramString)
    {
        this.giftRecImg = paramString;
    }

    public void setGiftSenderConsigneeMobile(String paramString)
    {
        this.giftSenderConsigneeMobile = paramString;
    }

    public void setGiftSenderConsigneeName(String paramString)
    {
        this.giftSenderConsigneeName = paramString;
    }

    public void setGiftSenderImg(String paramString)
    {
        this.giftSenderImg = paramString;
    }

    public void setGiftSenderMessage(String paramString)
    {
        this.giftSenderMessage = paramString;
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

    public void setIdCompanyBranch(Integer paramInteger)
    {
        this.idCompanyBranch = paramInteger;
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

    public void setIsIdTown(Boolean paramBoolean)
    {
        this.isIdTown = paramBoolean;
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
        this.provinceName = paramString;
    }

    public void setTownName(String paramString)
    {
        this.townName = paramString;
    }

    public void setUserLevel(Integer paramInteger)
    {
        this.userLevel = paramInteger;
    }

    public void setWhere(String paramString)
    {
        this.where = paramString;
    }

    public void setZip(String paramString)
    {
        this.zip = paramString;
    }
}
