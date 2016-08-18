package com.zy.common.entity;

import android.text.TextUtils;

/**
 * Created by Robin on 2016/5/8.
 */
public class ShareEntity {
    private String avatar;
    private String content;
    private String srv;
    private String title;
    private String url;

    public String getAvatar()
    {
        return this.avatar;
    }

    public String getContent()
    {
        return this.content;
    }

    public String getSrv()
    {
        if (TextUtils.isEmpty(this.srv))
            return "";
        return this.srv;
    }

    public String getTitle()
    {
        return this.title;
    }

    public String getUrl()
    {
        return this.url;
    }

    public void setAvatar(String paramString)
    {
        this.avatar = paramString;
    }

    public void setContent(String paramString)
    {
        this.content = paramString;
    }

    public void setSrv(String paramString)
    {
        this.srv = paramString;
    }

    public void setTitle(String paramString)
    {
        this.title = paramString;
    }

    public void setUrl(String paramString)
    {
        this.url = paramString;
    }
}
