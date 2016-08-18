package com.zy.common.utils;

import android.text.TextUtils;

import com.jingdong.common.utils.JSONObjectProxy;
import com.zy.common.utils.Log;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by Robin on 2016/6/19.
 */
//cv
public class JsonParser {
    public static JSONObjectProxy a(String paramString) {
        JSONObjectProxy localJSONObjectProxy = new JSONObjectProxy();
        if (!paramString.startsWith("{")) {
            try {
                if (!TextUtils.isEmpty(paramString)) {
                    String[] v3 = paramString.trim().split(",");

                    for (int i = 0; i < v3.length; i++) {
                        String[] arrayOfString = v3[i].trim().split("=");
                        int k = arrayOfString.length;
                        if (k >= 2) { //if-lt v5, v6, :cond_0
                            try {
                                localJSONObjectProxy.put(arrayOfString[0], arrayOfString[1]);

                            } catch (JSONException localJSONException) {
                                if (Log.E)
                                    localJSONException.printStackTrace();

                            }
                        }//:cond_0

                    }
                }
            } catch (Exception e) {
                if (Log.E)
                    e.printStackTrace();
            }
        }else{
            try
            {
                localJSONObjectProxy = new JSONObjectProxy(new JSONObject(paramString));
            }
            catch (JSONException e)
            {
                if (Log.E);
                e.printStackTrace();
            }
        }

        return localJSONObjectProxy;
    }
}
