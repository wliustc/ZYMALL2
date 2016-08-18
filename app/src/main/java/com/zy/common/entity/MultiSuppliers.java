package com.zy.common.entity;

import android.text.TextUtils;

import com.jingdong.common.utils.JSONObjectProxy;
import com.zy.common.res.StringUtil;

import java.io.Serializable;

/**
 * Created by robin on 16-8-4.
 */
public class MultiSuppliers implements Serializable {
    private static final String TAG = "MultiSuppliers";
    private String fatherId;
    private String minPrice;
    private String supplierCount;

    public MultiSuppliers(JSONObjectProxy paramJSONObjectProxy)
    {
        paramJSONObjectProxy = paramJSONObjectProxy.getJSONObjectOrNull("multiSuppliers");
        if (paramJSONObjectProxy != null)
        {
            setFatherId(paramJSONObjectProxy.getStringOrNull("father_id"));
            setMinPrice(paramJSONObjectProxy.getStringOrNull("min_price"));
            setSupplierCount(paramJSONObjectProxy.getStringOrNull("supplier_count"));
        }
    }

    public String getFatherId()
    {
        return this.fatherId;
    }

    public String getMinPrice()
    {
        return this.minPrice;
    }

    public String getSupplierCount()
    {
        return this.supplierCount;
    }

    public String getText()
    {
        Object localObject2 = null;
        Object localObject1 = localObject2;
        if (!TextUtils.isEmpty(this.minPrice))
        {
            localObject1 = localObject2;
            if (!TextUtils.isEmpty(this.supplierCount))
                localObject1 = this.supplierCount + String.format(StringUtil.productListMultiSeller, new Object[] { StringUtil.product_price_label + this.minPrice });
        }
        return (String)localObject1;
    }

    public boolean isMultiFlag()
    {
        return (!TextUtils.isEmpty(this.minPrice)) && (!TextUtils.isEmpty(this.supplierCount));
    }

    public void setFatherId(String paramString)
    {
        this.fatherId = paramString;
    }

    public void setMinPrice(String paramString)
    {
        this.minPrice = paramString;
    }

    public void setSupplierCount(String paramString)
    {
        this.supplierCount = paramString;
    }
}
