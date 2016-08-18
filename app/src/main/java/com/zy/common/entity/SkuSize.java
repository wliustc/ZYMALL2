package com.zy.common.entity;

import com.jingdong.common.utils.JSONObjectProxy;
import com.zy.common.utils.JSONArrayProxy;
import com.zy.common.utils.Log;

import org.json.JSONException;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Created by robin on 16-8-4.
 */
public class SkuSize implements Serializable {
    public static final int CONSTRUCTOR = 0;
    private Boolean directShow;
    private Boolean promotion;
    private String sizeName;
    private Long wareId;

    public SkuSize(JSONObjectProxy paramJSONObjectProxy, int paramInt)
    {
        switch (paramInt)
        {
            case CONSTRUCTOR:
                setDirectShow(paramJSONObjectProxy.getBooleanOrNull("directShow"));
                setPromotion(paramJSONObjectProxy.getBooleanOrNull("promotion"));
                setSizeName(paramJSONObjectProxy.getStringOrNull("size"));
                setWareId(paramJSONObjectProxy.getLongOrNull("wareId"));
        }

    }

    public static ArrayList<SkuSize> toList(JSONArrayProxy paramJSONArrayPoxy, int paramInt) {
        ArrayList<SkuSize> result = null;
        if (paramJSONArrayPoxy != null) {
            try {
                for (int i = 0; i < paramJSONArrayPoxy.length(); i++) {
                    if (result == null)
                        result = new ArrayList<SkuSize>();
                    result.add(new SkuSize(paramJSONArrayPoxy.getJSONObject(i), paramInt));
                }
            } catch (JSONException e) {
                if (Log.V)
                    Log.v("SkuSize", e.getMessage());
            }
        }
        return result;
    }

    public Boolean getDirectShow()
    {
        boolean bool = false;
        if (this.directShow == null)
            bool = this.directShow.booleanValue();
            return Boolean.valueOf(bool);
    }

    public Boolean getPromotion()
    {
        boolean bool = false;
        if (this.promotion == null)
            bool = this.promotion.booleanValue();
            return Boolean.valueOf(bool);
    }

    public String getSizeName()
    {
        if (this.sizeName == null)
            return "";
        return this.sizeName;
    }

    public Long getWareId()
    {
        return this.wareId;
    }

    public void setDirectShow(Boolean paramBoolean)
    {
        this.directShow = paramBoolean;
    }

    public void setPromotion(Boolean paramBoolean)
    {
        this.promotion = paramBoolean;
    }

    public void setSizeName(String paramString)
    {
        this.sizeName = paramString;
    }

    public void setWareId(Long paramLong)
    {
        this.wareId = paramLong;
    }
}
