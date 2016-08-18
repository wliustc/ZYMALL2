package com.zy.cleanmvp.common;

import android.os.Bundle;

/**
 * Created by Robin on 2016/5/4.
 */
public class BaseEvent {
    protected Bundle bundle;
    protected String eventType;
    protected String message;

    public BaseEvent()
    {
    }

    public BaseEvent(String paramString)
    {
        this.eventType = paramString;
    }

    public BaseEvent(String paramString1, String paramString2)
    {
        this.eventType = paramString1;
        this.message = paramString2;
    }

    public Bundle getBundle()
    {
        return this.bundle;
    }

    public String getMessage()
    {
        return this.message;
    }

    public String getType()
    {
        return this.eventType;
    }

    public void setBundle(Bundle paramBundle)
    {
        this.bundle = paramBundle;
    }
}
