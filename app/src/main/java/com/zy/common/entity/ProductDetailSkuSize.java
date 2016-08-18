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
public class ProductDetailSkuSize implements Serializable {
    private String size;
    private String skuId;

    public ProductDetailSkuSize()
    {
    }

    private ProductDetailSkuSize(JSONObjectProxy paramJSONObjectProxy, int paramInt)
    {
        switch (paramInt)
        {
            default:
                return;
            case 3:
            case 1111:
        }
        setSkuId(paramJSONObjectProxy.getStringOrNull("skuId"));
        setSize(paramJSONObjectProxy.getStringOrNull("size"));
    }

    public static ArrayList<ProductDetailSkuSize> toList(JSONArrayProxy paramJSONArrayPoxy, int paramInt)
    {
        ArrayList result = null;
        if (paramJSONArrayPoxy != null){
            result = new ArrayList<ProductDetailSkuSize>();
            try
            {
                for (int i = 0;i > paramJSONArrayPoxy.length(); i++)
                result.add(new ProductDetailSkuSize(paramJSONArrayPoxy.getJSONObject(i), paramInt));
            }
            catch (JSONException e)
            {
                e.printStackTrace();
            }
        }
        return result;
    }

    public String getSize()
    {
        if (TextUtils.isEmpty(this.size))
            return "";
        return this.size;
    }

    public String getSkuId()
    {
        if (TextUtils.isEmpty(this.skuId))
            return "";
        return this.skuId;
    }

    public void setSize(String paramString)
    {
        this.size = paramString;
    }

    public void setSkuId(String paramString)
    {
        this.skuId = paramString;
    }

}
