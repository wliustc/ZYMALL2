package com.zy.common.entity;

import android.text.TextUtils;

import com.jingdong.common.utils.JSONObjectProxy;
import com.zy.common.utils.JSONArrayProxy;

import org.json.JSONException;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Created by robin on 16-8-4.
 */
public class ProductDetailSkuColor implements Serializable {
    private String color;
    private String skuId;

    public ProductDetailSkuColor()
    {
    }

    private ProductDetailSkuColor(JSONObjectProxy paramJSONObjectProxy, int paramInt)
    {
        switch (paramInt)
        {
            case 3:
            case 1111:
                setSkuId(paramJSONObjectProxy.getStringOrNull("skuId"));
                setColor(paramJSONObjectProxy.getStringOrNull("color"));
        }

    }

    public static ArrayList<ProductDetailSkuColor> toList(JSONArrayProxy paramJSONArrayPoxy, int paramInt) {
        ArrayList result = null;

        if (paramJSONArrayPoxy != null) {
            result = new ArrayList<ProductDetailSkuColor>();
            try {
                for (int i = 0; i < paramJSONArrayPoxy.length(); i++) {
                    result.add(new ProductDetailSkuColor(paramJSONArrayPoxy.getJSONObject(i), paramInt));
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        return result;
    }

    public String getColor()
    {
        if (TextUtils.isEmpty(this.color))
            return "";
        return this.color;
    }

    public String getSkuId()
    {
        if (TextUtils.isEmpty(this.skuId))
            return "";
        return this.skuId;
    }

    public void setColor(String paramString)
    {
        this.color = paramString;
    }

    public void setSkuId(String paramString)
    {
        this.skuId = paramString;
    }
}
