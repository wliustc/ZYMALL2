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
public class SkuColor implements Serializable {
    public static final int CONSTRUCTOR = 0;
    private String colorImg;
    private String colorName;
    private Boolean promotion;
    private Long wareId;
    private String wareName;
    private String wareTitle;

    public SkuColor(JSONObjectProxy paramJSONObjectProxy, int paramInt)
    {
        switch (paramInt)
        {
            case 0:
                setColorName(paramJSONObjectProxy.getStringOrNull("color"));
                setColorImg(paramJSONObjectProxy.getStringOrNull("colorImg"));
                setPromotion(paramJSONObjectProxy.getBooleanOrNull("promotion"));
                setWareId(paramJSONObjectProxy.getLongOrNull("wareId"));
                setWareTitle(paramJSONObjectProxy.getStringOrNull("waretitle"));
                setWareName(paramJSONObjectProxy.getStringOrNull("wname"));
        }

    }

    public static ArrayList<SkuColor> toList(JSONArrayProxy paramJSONArrayPoxy, int paramInt)
    {
        ArrayList<SkuColor> result = null;
        if (paramJSONArrayPoxy != null){
            try
            {
                for (int i = 0; i < paramJSONArrayPoxy.length(); i ++)
                {
                    if (result == null)
                        result = new ArrayList();

                        result.add(new SkuColor(paramJSONArrayPoxy.getJSONObject(i), paramInt));
                }
            }
            catch (JSONException e)
            {
                if (Log.V)
                    Log.v("SkuColor", e.getMessage());
            }
        }
        return result;
    }

    public String getColorImg()
    {
        if (this.colorImg == null)
            return "";
        return this.colorImg;
    }

    public String getColorName()
    {
        if (this.colorName == null)
            return "";
        return this.colorName;
    }

    public Boolean getPromotion()
    {
        boolean bool = false;
        if (this.promotion != null)
            bool = this.promotion.booleanValue();
        return Boolean.valueOf(bool);
    }

    public Long getWareId()
    {
        long l = 0l;
        if (this.wareId != null)
            l = this.wareId.longValue();
        return Long.valueOf(l);

    }

    public String getWareName()
    {
        if (this.wareName == null)
            return "";
        return this.wareName;
    }

    public String getWareTitle()
    {
        if (this.wareTitle == null)
            return "";
        return this.wareTitle;
    }

    public void setColorImg(String colorImg)
    {
        this.colorImg = colorImg;
    }

    public void setColorName(String colorName)
    {
        this.colorName = colorName;
    }

    public void setPromotion(Boolean promotion)
    {
        this.promotion = promotion;
    }

    public void setWareId(Long wareId)
    {
        this.wareId = wareId;
    }

    public void setWareName(String wareName)
    {
        this.wareName = wareName;
    }

    public void setWareTitle(String wareTitle)
    {
        this.wareTitle = wareTitle;
    }
}
