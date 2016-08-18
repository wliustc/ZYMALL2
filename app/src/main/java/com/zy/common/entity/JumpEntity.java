package com.zy.common.entity;

import android.text.TextUtils;

/**
 * Created by Robin on 2016/5/8.
 */
public class JumpEntity {
    private String des;
    private String params;
    private ShareEntity shareInfo;
    private String srv;

    public String getDes()
    {
        return this.des;
    }

    public String getParams()
    {
        return this.params;
    }

    public ShareEntity getShareInfo()
    {
        return this.shareInfo;
    }

    public String getSrv()
    {
        if (TextUtils.isEmpty(this.srv))
            return "";
        return this.srv;
    }

    public void setDes(String paramString)
    {
        this.des = paramString;
    }

    public void setParams(String paramString)
    {
        this.params = paramString;
    }

    public void setShareInfo(ShareEntity paramShareEntity)
    {
        this.shareInfo = paramShareEntity;
    }

    public void setSrv(String paramString)
    {
        this.srv = paramString;
    }
}
