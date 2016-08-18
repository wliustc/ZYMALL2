package com.zy.common.entity;

/**
 * Created by Robin on 2016/5/17.
 */
public class HomeLayerParamEntity {
    private int count;
    private String url;

    public int getCount()
    {
        return this.count;
    }

    public String getUrl()
    {
        return this.url;
    }

    public void setCount(int paramInt)
    {
        this.count = paramInt;
    }

    public void setUrl(String paramString)
    {
        this.url = paramString;
    }
}
