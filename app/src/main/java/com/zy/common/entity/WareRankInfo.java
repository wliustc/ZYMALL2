package com.zy.common.entity;

import com.jingdong.common.utils.JSONObjectProxy;

import java.io.Serializable;

/**
 * Created by robin on 16-8-4.
 */
public class WareRankInfo implements Serializable {
    public String cid3Name;
    public String currentRank;

    public WareRankInfo(JSONObjectProxy paramJSONObjectProxy)
    {
        setCurrentRank(paramJSONObjectProxy.getStringOrNull("currentRank"));
        setCid3Name(paramJSONObjectProxy.getStringOrNull("cid3Name"));
    }

    public String getCid3Name()
    {
        return this.cid3Name;
    }

    public String getCurrentRank()
    {
        return this.currentRank;
    }

    public void setCid3Name(String paramString)
    {
        this.cid3Name = paramString;
    }

    public void setCurrentRank(String paramString)
    {
        this.currentRank = paramString;
    }
}
