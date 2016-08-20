package com.zy.common.entity;

import java.io.Serializable;

/**
 * Created by Robin on 2016/8/20.
 */
public class GeoPoint implements Serializable {
    private int mLatie6;
    private int mLongie6;

    public GeoPoint(int paramInt1, int paramInt2)
    {
        this.mLatie6 = paramInt1;
        this.mLongie6 = paramInt2;
    }

    public int getLatitudeE6()
    {
        return this.mLatie6;
    }

    public int getLongitudeE6()
    {
        return this.mLongie6;
    }

    public void setLatitudeE6(int paramInt)
    {
        this.mLatie6 = paramInt;
    }

    public void setLongitudeE6(int paramInt)
    {
        this.mLongie6 = paramInt;
    }
}
