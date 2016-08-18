package com.zy.common.entity;

import com.zy.common.utils.Log;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.Serializable;
import java.util.LinkedList;

/**
 * Created by Robin on 2016/6/22.
 */
public class Image implements Serializable {
    public static final int PRODUCTDETAIL = 0;
    public static final int PRODUCT_DETAIL_NEW = 1;
    private String big;
    private String small;

    public Image(String paramString1, String paramString2)
    {
        this.small = paramString1;
        this.big = paramString2;
    }

    public Image(JSONObject paramJSONObject, int paramInt) {
        try {
            switch (paramInt) {
                case PRODUCTDETAIL://:pswitch_0
                    setSmall(paramJSONObject.getString("newpath"));
                    setBig(paramJSONObject.getString("bigpath"));
                    break;
                case PRODUCT_DETAIL_NEW://:pswitch_1
                    setSmall(paramJSONObject.getString("small"));
                    setBig(paramJSONObject.getString("big"));
                    break;
            }
        } catch (JSONException e) {
            if (Log.V)
                Log.v(Image.class.getName(), e.getMessage());
        }
    }

    public static LinkedList<Image> toList(JSONArray jsonArray, int paramInt) {
        LinkedList<Image> result = null;
        if (jsonArray != null) {
            result = new LinkedList<Image>();
            try {
                for (int i = 0; i < jsonArray.length(); i++) {
                    result.add(new Image(jsonArray.getJSONObject(i), paramInt));
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        return result;
    }

    public String getBig()
    {
        return this.big;
    }

    public String getSmall()
    {
        return this.small;
    }

    public void setBig(String paramString)
    {
        this.big = paramString;
    }

    public void setSmall(String paramString)
    {
        this.small = paramString;
    }
}
