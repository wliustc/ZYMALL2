package com.zy.common.entity.navigationbar;

import com.alibaba.fastjson.annotation.JSONField;

/**
 * Created by Robin on 2016/4/7.
 */
public class NavigationBar {
    public static final String TAG = NavigationBar.class.getSimpleName();
    private int bigIconTag;
    private String dataVersion;
    private int defaultTag;
    private int displayTag;
    private String endTime;
    private String functionId;
    private int iconType;
    private int id;
    private String mUrl;
    private String naviLabel;

    @JSONField(name="sort")
    private Integer naviOrder;
    private int naviTask;
    private String offPath;

    @JSONField(name="lableImage")
    private String offUrl;
    private String onPath;

    @JSONField(name="optlableImage")
    private String onUrl;
    private String startTime;

    public int getBigIconTag()
    {
        return this.bigIconTag;
    }

    public String getDataVersion()
    {
        return this.dataVersion;
    }

    public int getDefaultTag()
    {
        return this.defaultTag;
    }

    public int getDisplayTag()
    {
        return this.displayTag;
    }

    public String getEndTime()
    {
        return this.endTime;
    }

    public String getFunctionId()
    {
        return this.functionId;
    }

    public int getIconType()
    {
        return this.iconType;
    }

    public int getId()
    {
        return this.id;
    }

    public String getNaviLabel()
    {
        return this.naviLabel;
    }

    public Integer getNaviOrder()
    {
        return this.naviOrder;
    }

    public int getNaviTask()
    {
        return this.naviTask;
    }

    public String getOffPath()
    {
        return this.offPath;
    }

    public String getOffUrl()
    {
        return this.offUrl;
    }

    public String getOnPath()
    {
        return this.onPath;
    }

    public String getOnUrl()
    {
        return this.onUrl;
    }

    public String getStartTime()
    {
        return this.startTime;
    }

    public String getmUrl()
    {
        return this.mUrl;
    }

    public void setBigIconTag(int paramInt)
    {
        this.bigIconTag = paramInt;
    }

    public void setDataVersion(String paramString)
    {
        this.dataVersion = paramString;
    }

    public void setDefaultTag(int paramInt)
    {
        this.defaultTag = paramInt;
    }

    public void setDisplayTag(int paramInt)
    {
        this.displayTag = paramInt;
    }

    public void setEndTime(String paramString)
    {
        this.endTime = paramString;
    }

    public void setFunctionId(String paramString)
    {
        this.functionId = paramString;
    }

    public void setIconType(int paramInt)
    {
        this.iconType = paramInt;
    }

    public void setId(int paramInt)
    {
        this.id = paramInt;
    }

    public void setNaviLabel(String paramString)
    {
        this.naviLabel = paramString;
    }

    public void setNaviOrder(Integer paramInteger)
    {
        this.naviOrder = paramInteger;
    }

    public void setNaviTask(int paramInt)
    {
        this.naviTask = paramInt;
    }

    public void setOffPath(String paramString)
    {
        this.offPath = paramString;
    }

    public void setOffUrl(String paramString)
    {
        this.offUrl = paramString;
    }

    public void setOnPath(String paramString)
    {
        this.onPath = paramString;
    }

    public void setOnUrl(String paramString)
    {
        this.onUrl = paramString;
    }

    public void setStartTime(String paramString)
    {
        this.startTime = paramString;
    }

    public void setmUrl(String paramString)
    {
        this.mUrl = paramString;
    }
}
