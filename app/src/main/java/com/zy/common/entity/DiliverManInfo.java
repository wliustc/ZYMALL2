package com.zy.common.entity;

import com.jingdong.common.utils.JSONObjectProxy;

import java.io.Serializable;

/**
 * Created by robin on 16-8-4.
 */
public class DiliverManInfo implements Serializable {
    private String picBigUrl;
    private String picUrl;
    private String staffName;
    private String staffNo;

    public DiliverManInfo(JSONObjectProxy paramJSONObjectProxy)
    {
        if (paramJSONObjectProxy != null)
        {
            setStaffNo(paramJSONObjectProxy.optString("staffNo"));
            setPicUrl(paramJSONObjectProxy.optString("staffPhoto"));
            setPicBigUrl(paramJSONObjectProxy.optString("staffPhotoBig"));
            setStaffName(paramJSONObjectProxy.optString("staffName"));
        }
    }

    public String getPicBigUrl()
    {
        return this.picBigUrl;
    }

    public String getPicUrl()
    {
        return this.picUrl;
    }

    public String getStaffName()
    {
        return this.staffName;
    }

    public String getStaffNo()
    {
        return this.staffNo;
    }

    public void setPicBigUrl(String paramString)
    {
        this.picBigUrl = paramString;
    }

    public void setPicUrl(String paramString)
    {
        this.picUrl = paramString;
    }

    public void setStaffName(String paramString)
    {
        this.staffName = paramString;
    }

    public void setStaffNo(String paramString)
    {
        this.staffNo = paramString;
    }
}
