package com.jingdong.common.utils;

import com.zy.common.utils.JSONArrayProxy;
import com.zy.common.utils.Log;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.Serializable;
import java.util.Iterator;

/**
 * Created by Robin on 2016/6/16.
 */
public class JSONObjectProxy extends JSONObject
        implements Serializable {
    private JSONObject jsonObject;

    public JSONObjectProxy()
    {
        this.jsonObject = new JSONObject();
    }

    public JSONObjectProxy(JSONObject paramJSONObject)
    {
        this.jsonObject = paramJSONObject;
    }

    public JSONObject accumulate(String paramString, Object paramObject)
            throws JSONException
    {
        return this.jsonObject.accumulate(paramString, paramObject);
    }

    public boolean equals(JSONObject paramJSONObject)
    {
        if (this.jsonObject == paramJSONObject)
            return true;
        if ((this.jsonObject != null) && (paramJSONObject != null))
            return this.jsonObject.toString().equals(paramJSONObject.toString());
        return false;
    }

    public Object get(String paramString)
            throws JSONException
    {
        return this.jsonObject.get(paramString);
    }

    public boolean getBoolean(String paramString)
            throws JSONException
    {
        return this.jsonObject.getBoolean(paramString);
    }

    @Deprecated
    public Boolean getBooleanOrNull(String paramString)
    {
        if (!this.jsonObject.isNull(paramString)) {
            try
            {
                boolean bool = this.jsonObject.getBoolean(paramString);
                return Boolean.valueOf(bool);
            }
            catch (JSONException e)
            {
                if (Log.V)
                Log.v(JSONObjectProxy.class.getName(), e.getMessage());
            }
        }

        return null;
    }

    public double getDouble(String paramString)
            throws JSONException
    {
        return this.jsonObject.getDouble(paramString);
    }

    @Deprecated
    public Double getDoubleOrNull(String paramString)
    {
        if (!this.jsonObject.isNull(paramString)) {
            try
            {
                double d = this.jsonObject.getDouble(paramString);
                return Double.valueOf(d);
            }
            catch (JSONException e)
            {
                if (Log.V)
                Log.v(JSONObjectProxy.class.getName(), e.getMessage());
            }
        }
        return null;
    }

    public double getDoubleValue(String paramString)
    {
        if (!this.jsonObject.isNull(paramString)) {
            try
            {
                double d = Double.valueOf(this.jsonObject.getDouble(paramString)).doubleValue();
                return d;
            }
            catch (JSONException e)
            {
                if (Log.V)
                Log.v(JSONObjectProxy.class.getName(), e.getMessage());
            }
        }
        return -1.0D;
    }

    public int getInt(String paramString)
            throws JSONException
    {
        return this.jsonObject.getInt(paramString);
    }

    @Deprecated
    public Integer getIntOrNull(String paramString)
    {
        if (!this.jsonObject.isNull(paramString))
        {
            try
            {
                int i = this.jsonObject.getInt(paramString);
                return Integer.valueOf(i);
            }
            catch (JSONException e)
            {
                if (Log.V)
                Log.v(JSONObjectProxy.class.getName(), e.getMessage());
            }
        }

        return null;
    }

    public int getIntegerValue(String paramString)
    {
        if (!this.jsonObject.isNull(paramString))
        {
            try
            {
                int i = this.jsonObject.getInt(paramString);
                return i;
            }
            catch (JSONException e)
            {
                if (Log.V)
                Log.v(JSONObjectProxy.class.getName(), e.getMessage());
            }
        }
        return -1;
    }

    public JSONArrayProxy getJSONArray(String paramString)
            throws JSONException
    {
        return new JSONArrayProxy(this.jsonObject.getJSONArray(paramString));
    }

    public JSONArrayProxy getJSONArrayOrNull(String paramString)
    {
        if (!this.jsonObject.isNull(paramString)) {
            try {
                return new JSONArrayProxy(this.jsonObject.getJSONArray(paramString));
            } catch (JSONException e) {
            }
        }
        return null;
    }

    public JSONObjectProxy getJSONObject(String paramString)
            throws JSONException
    {
        return new JSONObjectProxy(this.jsonObject.getJSONObject(paramString));
    }

    public JSONObjectProxy getJSONObjectOrNull(String paramString)
    {
        if (!this.jsonObject.isNull(paramString)) {
            try {
                return new JSONObjectProxy(this.jsonObject.getJSONObject(paramString));
            } catch (JSONException e) {
            }
        }
        return null;
    }

    public long getLong(String paramString)
            throws JSONException
    {
        return this.jsonObject.getLong(paramString);
    }

    @Deprecated
    public Long getLongOrNull(String paramString)
    {
        if (!this.jsonObject.isNull(paramString))
        {
            try
            {
                long l = this.jsonObject.getLong(paramString);
                return Long.valueOf(l);
            }
            catch (JSONException e)
            {
                if (Log.V)
                Log.v(JSONObjectProxy.class.getName(), e.getMessage());
            }
        }

        return null;
    }

    public String getString(String paramString)
            throws JSONException
    {
        return this.jsonObject.getString(paramString);
    }

    @Deprecated
    public String getStringOrNull(String paramString)
    {
        if (!this.jsonObject.isNull(paramString))
        {
            try
            {
                paramString = this.jsonObject.getString(paramString);
                return paramString;
            }
            catch (JSONException e)
            {
                if (Log.V);
                Log.v(JSONObjectProxy.class.getName(), e.getMessage());
            }
        }

        return null;
    }

    public boolean has(String paramString)
    {
        return this.jsonObject.has(paramString);
    }

    public int hashCode()
    {
        return this.jsonObject.hashCode();
    }

    public boolean isNull(String paramString)
    {
        return this.jsonObject.isNull(paramString);
    }

    public Iterator keys()
    {
        return this.jsonObject.keys();
    }

    public int length()
    {
        return this.jsonObject.length();
    }

    public JSONArray names()
    {
        return this.jsonObject.names();
    }

    public Object opt(String paramString)
    {
        return this.jsonObject.opt(paramString);
    }

    public boolean optBoolean(String paramString)
    {
        return this.jsonObject.optBoolean(paramString);
    }

    public boolean optBoolean(String paramString, boolean paramBoolean)
    {
        return this.jsonObject.optBoolean(paramString, paramBoolean);
    }

    public double optDouble(String paramString)
    {
        return this.jsonObject.optDouble(paramString);
    }

    public double optDouble(String paramString, double paramDouble)
    {
        return this.jsonObject.optDouble(paramString, paramDouble);
    }

    public int optInt(String paramString)
    {
        return this.jsonObject.optInt(paramString);
    }

    public int optInt(String paramString, int paramInt)
    {
        return this.jsonObject.optInt(paramString, paramInt);
    }

    public JSONArray optJSONArray(String paramString)
    {
        return this.jsonObject.optJSONArray(paramString);
    }

    public JSONObject optJSONObject(String paramString)
    {
        return this.jsonObject.optJSONObject(paramString);
    }

    public long optLong(String paramString)
    {
        return this.jsonObject.optLong(paramString);
    }

    public long optLong(String paramString, long paramLong)
    {
        return this.jsonObject.optLong(paramString, paramLong);
    }

    public String optString(String paramString)
    {
        return this.jsonObject.optString(paramString);
    }

    public String optString(String paramString1, String paramString2)
    {
        return this.jsonObject.optString(paramString1, paramString2);
    }

    public JSONObject put(String paramString, double paramDouble)
            throws JSONException
    {
        return this.jsonObject.put(paramString, paramDouble);
    }

    public JSONObject put(String paramString, int paramInt)
            throws JSONException
    {
        return this.jsonObject.put(paramString, paramInt);
    }

    public JSONObject put(String paramString, long paramLong)
            throws JSONException
    {
        return this.jsonObject.put(paramString, paramLong);
    }

    public JSONObject put(String paramString, Object paramObject)
            throws JSONException
    {
        return this.jsonObject.put(paramString, paramObject);
    }

    public JSONObject put(String paramString, boolean paramBoolean)
            throws JSONException
    {
        return this.jsonObject.put(paramString, paramBoolean);
    }

    public JSONObject putOpt(String paramString, Object paramObject)
            throws JSONException
    {
        return this.jsonObject.putOpt(paramString, paramObject);
    }

    public Object remove(String paramString)
    {
        return this.jsonObject.remove(paramString);
    }

    public JSONArray toJSONArray(JSONArray paramJSONArray)
            throws JSONException
    {
        return this.jsonObject.toJSONArray(paramJSONArray);
    }

    public String toString()
    {
        return this.jsonObject.toString();
    }

    public String toString(int paramInt)
            throws JSONException
    {
        return this.jsonObject.toString(paramInt);
    }
}
