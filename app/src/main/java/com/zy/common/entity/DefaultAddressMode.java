package com.zy.common.entity;

import android.text.TextUtils;

import com.jingdong.common.utils.JSONObjectProxy;
import com.zy.common.utils.JSONArrayProxy;

import org.json.JSONException;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Created by robin on 16-8-4.
 */
public class DefaultAddressMode implements Serializable {
    public static final int DIRECT_WARE = 0;
    private String cityId;
    private String cityName;
    private String countyId;
    private String countyName;
    private String functionId;
    private String provinceId;
    private String provinceName;
    private String skuId;
    private String townId;
    private String townName;

    public DefaultAddressMode()
    {
    }

    public DefaultAddressMode(JSONObjectProxy paramJSONObjectProxy, int paramInt)
    {
        switch (paramInt)
        {

            case 0:
            case 1112:
                setProvinceId(paramJSONObjectProxy.getStringOrNull("provinceId"));
                setProvinceName(paramJSONObjectProxy.getStringOrNull("provinceName"));
                setCityId(paramJSONObjectProxy.getStringOrNull("cityId"));
                setCityName(paramJSONObjectProxy.getStringOrNull("cityName"));
                setCountyId(paramJSONObjectProxy.getStringOrNull("countyId"));
                setCountyName(paramJSONObjectProxy.getStringOrNull("countyName"));
                setTownId(paramJSONObjectProxy.getStringOrNull("townId"));
                setTownName(paramJSONObjectProxy.getStringOrNull("townName"));
                if (!paramJSONObjectProxy.isNull("skuId"))
                    setSkuId(paramJSONObjectProxy.getStringOrNull("skuId"));
                if (!paramJSONObjectProxy.isNull("functionId"));
                setFunctionId(paramJSONObjectProxy.getStringOrNull("functionId"));
        }
            return;
    }

    public static ArrayList<DefaultAddressMode> toList(JSONArrayProxy paramJSONArrayPoxy, int paramInt)
    {
        ArrayList<DefaultAddressMode> reusult = null;
        if (paramJSONArrayPoxy != null){
            reusult = new ArrayList<DefaultAddressMode>();
            try
            {
                for (int i=0; i < paramJSONArrayPoxy.length(); i++){
                    DefaultAddressMode defaultAddressMode = new DefaultAddressMode(paramJSONArrayPoxy.getJSONObject(i), paramInt);
                    if (!TextUtils.isEmpty(defaultAddressMode.getProvinceName()))
                        reusult.add(defaultAddressMode);
                }
            }
            catch (JSONException e)
            {
                e.printStackTrace();
            }
        }
        return reusult;
    }

    public String getCityId()
    {
        if (TextUtils.isEmpty(this.cityId))
            return "0";
        return this.cityId;
    }

    public String getCityName()
    {
        if (TextUtils.isEmpty(this.cityName))
            return "";
        return this.cityName;
    }

    public String getCountyId()
    {
        if (TextUtils.isEmpty(this.countyId))
            return "0";
        return this.countyId;
    }

    public String getCountyName()
    {
        if (TextUtils.isEmpty(this.countyName))
            return "";
        return this.countyName;
    }

    public String getFunctionId()
    {
        if (TextUtils.isEmpty(this.functionId))
            return "";
        return this.functionId;
    }

    public String getProvinceId()
    {
        if (TextUtils.isEmpty(this.provinceId))
            return "0";
        return this.provinceId;
    }

    public String getProvinceName()
    {
        if (TextUtils.isEmpty(this.provinceName))
            return "";
        return this.provinceName;
    }

    public String getSkuId()
    {
        if (TextUtils.isEmpty(this.skuId))
            return "";
        return this.skuId;
    }

    public String getTownId()
    {
        if (TextUtils.isEmpty(this.townId))
            return "0";
        return this.townId;
    }

    public String getTownName()
    {
        if (TextUtils.isEmpty(this.townName))
            return "";
        return this.townName;
    }

    public void setCityId(String paramString)
    {
        this.cityId = paramString;
    }

    public void setCityName(String paramString)
    {
        this.cityName = paramString;
    }

    public void setCountyId(String paramString)
    {
        this.countyId = paramString;
    }

    public void setCountyName(String paramString)
    {
        this.countyName = paramString;
    }

    public void setFunctionId(String paramString)
    {
        this.functionId = paramString;
    }

    public void setProvinceId(String paramString)
    {
        this.provinceId = paramString;
    }

    public void setProvinceName(String paramString)
    {
        this.provinceName = paramString;
    }

    public void setSkuId(String paramString)
    {
        this.skuId = paramString;
    }

    public void setTownId(String paramString)
    {
        this.townId = paramString;
    }

    public void setTownName(String paramString)
    {
        this.townName = paramString;
    }
}
