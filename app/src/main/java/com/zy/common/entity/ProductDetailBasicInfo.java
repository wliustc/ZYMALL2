package com.zy.common.entity;

import android.text.TextUtils;

import com.jingdong.common.utils.JSONObjectProxy;

import java.io.Serializable;

/**
 * Created by robin on 16-8-4.
 */
public class ProductDetailBasicInfo implements Serializable {
    private boolean cartFlag;
    private String cartImag;
    private String cartTip;
    private String chatUrl;
    private boolean easyBuy;
    private String ebookId;
    private String ebookLink;
    private String ebookPrice;
    private String ebookType;
    private String fare;
    private String infoPageImag;
    private boolean is7ToReturn = true;
    private boolean isOneHour = false;
    private boolean isPop;
    private String mLink;
    private boolean miaosha;
    private long miaoshaRemainTime;
    private String name;
    private String reasonTips = null;
    private String stock;
    private String type;
    private String venderId;
    private String wareId;

    public ProductDetailBasicInfo()
    {
    }

    public ProductDetailBasicInfo(JSONObjectProxy paramJSONObjectProxy, int paramInt) {
        switch (paramInt) {
            case 3:
                setName(paramJSONObjectProxy.getStringOrNull("name"));
                if (!paramJSONObjectProxy.isNull("stock"))
                    setStock(paramJSONObjectProxy.getStringOrNull("stock"));
                setCartTip(paramJSONObjectProxy.getStringOrNull("cartTip"));
                if (!paramJSONObjectProxy.isNull("easyBuy"))
                    setEasyBuy(paramJSONObjectProxy.getBooleanOrNull("easyBuy").booleanValue());
                if (!paramJSONObjectProxy.isNull("miaosha"))
                    setMiaosha(paramJSONObjectProxy.getBooleanOrNull("miaosha").booleanValue());
                if (!paramJSONObjectProxy.isNull("cartFlag"))
                    setCartFlag(paramJSONObjectProxy.getBooleanOrNull("cartFlag").booleanValue());
                setWareId(paramJSONObjectProxy.getStringOrNull("wareId"));
                setCartImag(paramJSONObjectProxy.getStringOrNull("cartImag"));
                setInfoPageImag(paramJSONObjectProxy.getStringOrNull("infoPageImag"));
                setChatUrl(paramJSONObjectProxy.getStringOrNull("chatUrl"));
                setmLink(paramJSONObjectProxy.getStringOrNull("mLink"));
                setVenderId(paramJSONObjectProxy.getStringOrNull("venderId"));
                if (!paramJSONObjectProxy.isNull("fare"))
                    setFare(paramJSONObjectProxy.getStringOrNull("fare"));
                if (!paramJSONObjectProxy.isNull("type"))
                    setType(paramJSONObjectProxy.getStringOrNull("type"));
                if (!paramJSONObjectProxy.isNull("isOneHour"))
                    setOneHour(paramJSONObjectProxy.getBooleanOrNull("isOneHour").booleanValue());
                if (!paramJSONObjectProxy.isNull("is7ToReturn"))
                    setIs7ToReturn(paramJSONObjectProxy.getBooleanOrNull("is7ToReturn").booleanValue());
                else
                    setIs7ToReturn(true);

                if (!paramJSONObjectProxy.isNull("miaoshaRemainTime"))
                    setMiaoshaRemainTime(paramJSONObjectProxy.getLongOrNull("miaoshaRemainTime").longValue());
                if (!paramJSONObjectProxy.isNull("ebookType")) {
                    setEbookType(paramJSONObjectProxy.getStringOrNull("ebookType"));
                    if (!paramJSONObjectProxy.isNull("ebookLink"))
                        setEbookLink(paramJSONObjectProxy.getStringOrNull("ebookLink"));
                    if (!paramJSONObjectProxy.isNull("ebookPrice"))
                        setEbookPrice(paramJSONObjectProxy.getStringOrNull("ebookPrice"));
                    if (!paramJSONObjectProxy.isNull("ebookId"))
                        setEbookId(paramJSONObjectProxy.getStringOrNull("ebookId"));
                }
                if (!paramJSONObjectProxy.isNull("reasonTips"))
                    setReasonTips(paramJSONObjectProxy.getStringOrNull("reasonTips"));
                if (!paramJSONObjectProxy.isNull("isPop"))
                    setPop(paramJSONObjectProxy.getBooleanOrNull("isPop").booleanValue());
                return;
        }

    }

    public String getCartImag() {
        return this.cartImag;
    }

    public String getCartTip() {
        if (TextUtils.isEmpty(this.cartTip))
            return "";
        return this.cartTip;
    }

    public String getChatUrl() {
        if (TextUtils.isEmpty(this.chatUrl))
            return "";
        return this.chatUrl;
    }

    public String getEbookId() {
        return this.ebookId;
    }

    public String getEbookLink() {
        return this.ebookLink;
    }

    public String getEbookPrice() {
        return this.ebookPrice;
    }

    public String getEbookType() {
        return this.ebookType;
    }

    public String getFare() {
        return this.fare;
    }

    public String getInfoPageImag() {
        return this.infoPageImag;
    }

    public long getMiaoshaRemainTime() {
        return this.miaoshaRemainTime;
    }

    public String getName() {
        if (TextUtils.isEmpty(this.name))
            return "";
        return this.name;
    }

    public String getReasonTips() {
        return this.reasonTips;
    }

    public String getStock() {
        if (TextUtils.isEmpty(this.stock))
            return "";
        return this.stock;
    }

    public String getType() {
        return this.type;
    }

    public String getVenderId() {
        if (TextUtils.isEmpty(this.venderId))
            return "";
        return this.venderId;
    }

    public String getWareId() {
        if (TextUtils.isEmpty(this.wareId))
            return "";
        return this.wareId;
    }

    public String getmLink() {
        if (TextUtils.isEmpty(this.mLink))
            return "";
        return this.mLink;
    }

    public boolean is7ToReturn() {
        return this.is7ToReturn;
    }

    public boolean isCartFlag() {
        return this.cartFlag;
    }

    public boolean isEasyBuy() {
        return this.easyBuy;
    }

    public boolean isMiaosha() {
        return this.miaosha;
    }

    public boolean isOneHour() {
        return this.isOneHour;
    }

    public boolean isPop() {
        return this.isPop;
    }

    public void setCartFlag(boolean paramBoolean) {
        this.cartFlag = paramBoolean;
    }

    public void setCartImag(String paramString) {
        this.cartImag = paramString;
    }

    public void setCartTip(String paramString) {
        this.cartTip = paramString;
    }

    public void setChatUrl(String paramString) {
        this.chatUrl = paramString;
    }

    public void setEasyBuy(boolean paramBoolean) {
        this.easyBuy = paramBoolean;
    }

    public void setEbookId(String paramString) {
        this.ebookId = paramString;
    }

    public void setEbookLink(String paramString) {
        this.ebookLink = paramString;
    }

    public void setEbookPrice(String paramString) {
        this.ebookPrice = paramString;
    }

    public void setEbookType(String paramString) {
        this.ebookType = paramString;
    }

    public void setFare(String paramString) {
        this.fare = paramString;
    }

    public void setInfoPageImag(String paramString) {
        this.infoPageImag = paramString;
    }

    public void setIs7ToReturn(boolean paramBoolean) {
        this.is7ToReturn = paramBoolean;
    }

    public void setMiaosha(boolean paramBoolean) {
        this.miaosha = paramBoolean;
    }

    public void setMiaoshaRemainTime(long paramLong) {
        this.miaoshaRemainTime = paramLong;
    }

    public void setName(String paramString) {
        this.name = paramString;
    }

    public void setOneHour(boolean paramBoolean) {
        this.isOneHour = paramBoolean;
    }

    public void setPop(boolean paramBoolean) {
        this.isPop = paramBoolean;
    }

    public void setReasonTips(String paramString) {
        this.reasonTips = paramString;
    }

    public void setStock(String paramString) {
        this.stock = paramString;
    }

    public void setType(String paramString) {
        this.type = paramString;
    }

    public void setVenderId(String paramString) {
        this.venderId = paramString;
    }

    public void setWareId(String paramString) {
        this.wareId = paramString;
    }

    public void setmLink(String paramString) {
        this.mLink = paramString;
    }
}
