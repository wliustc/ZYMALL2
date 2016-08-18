package com.zy.common.entity;

import com.jingdong.common.utils.JSONObjectProxy;
import com.zy.common.utils.JSONArrayProxy;

import org.json.JSONException;

import java.util.ArrayList;

/**
 * Created by Robin on 2016/6/5.
 */
public class HomeFloorNewElements {
    private ArrayList<HomeFloorNewElement> data;
    private String tpl;

    public HomeFloorNewElements(JSONObjectProxy paramJSONObjectProxy)
    {
        this.tpl = paramJSONObjectProxy.optString("tpl", "");
        if (paramJSONObjectProxy.getJSONArrayOrNull("data") != null)
            this.data = HomeFloorNewElement.toList(paramJSONObjectProxy.getJSONArrayOrNull("data"));
    }

    public static ArrayList<HomeFloorNewElements> toList(JSONArrayProxy jsonArrayPoxy) {
        ArrayList<HomeFloorNewElements> result = null;
        if(jsonArrayPoxy != null && jsonArrayPoxy.length() != 0 ){
            result = new ArrayList<HomeFloorNewElements>();
            try {
                for(int i=0; i<jsonArrayPoxy.length(); i++){
                        result.add(new HomeFloorNewElements(jsonArrayPoxy.getJSONObject(i)));
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        return result;
    }

    public ArrayList<HomeFloorNewElement> getData()
    {
        return this.data;
    }

    public String getTpl()
    {
        return this.tpl;
    }
}
