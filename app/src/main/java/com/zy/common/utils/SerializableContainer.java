package com.zy.common.utils;

import com.jingdong.common.utils.URLParamMap;

import java.io.Serializable;

/**
 * Created by Robin on 2016/10/21.
 */
public class SerializableContainer implements Serializable {
    private URLParamMap map;

    public URLParamMap getMap()
    {
        return this.map;
    }

    public void setMap(URLParamMap paramURLParamMap)
    {
        this.map = paramURLParamMap;
    }
}
