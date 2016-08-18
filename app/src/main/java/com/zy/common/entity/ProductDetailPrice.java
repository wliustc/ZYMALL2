package com.zy.common.entity;

import android.text.TextUtils;

import com.jingdong.common.utils.JSONObjectProxy;
import com.zy.common.utils.Log;

import java.io.Serializable;
import java.text.DecimalFormat;

/**
 * Created by robin on 16-8-4.
 */
public class ProductDetailPrice implements Serializable {
    private static final String TAG = ProductDetailPrice.class.getSimpleName();
    private Boolean display;
    private String name;
    private String value;

    public ProductDetailPrice()
    {
    }

    public ProductDetailPrice(JSONObjectProxy paramJSONObjectProxy, int paramInt) {
        switch (paramInt)
        {
            case 3:     //sswitch_0
            case 1112:
            case 1113:
                setName(paramJSONObjectProxy.getStringOrNull("name"));
                setValue(paramJSONObjectProxy.getStringOrNull("value"));
                setDisplay(paramJSONObjectProxy.getBooleanOrNull("display"));
                return;
        }
    }

    public ProductDetailPrice(String paramString)
    {
        setValue(paramString);
    }

    public Boolean getDisplay()
    {
        boolean bool = false;
        if (this.display != null)
            bool = this.display.booleanValue();
        return Boolean.valueOf(bool);
    }

    public String getName()
    {
        if (TextUtils.isEmpty(this.name))
            return "";
        return this.name;
    }

    public String getValue()
    {
        try
        {
            if (this.value != null)
            {
                Double localObject = Double.valueOf(this.value);
                if (localObject != null)
                {
                    if (((Double)localObject).doubleValue() > 0.0D)
                    return new DecimalFormat("0.00").format(localObject);
                }
            }
        }
        catch (Exception localException)
        {
            if (Log.D)
                localException.printStackTrace();
        }
        return (String)"暂无报价";
    }

    public void setDisplay(Boolean display)
    {
        this.display = display;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public void setValue(String value)
    {
        this.value = value;
    }
}
