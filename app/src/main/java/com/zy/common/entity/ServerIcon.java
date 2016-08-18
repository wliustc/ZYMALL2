package com.zy.common.entity;

import android.text.TextUtils;

import com.jingdong.common.utils.JSONObjectProxy;
import com.zy.common.utils.JSONArrayProxy;
import com.zy.common.utils.Log;

import java.util.ArrayList;

/**
 * Created by robin on 16-8-4.
 */
public class ServerIcon {
    private String helpLink;
    private String imageUrl;
    private String name;
    private String tip;

    public ServerIcon(JSONObjectProxy paramJSONObjectProxy)
    {
        if (paramJSONObjectProxy != null)
        {
            this.imageUrl = paramJSONObjectProxy.getStringOrNull("imageUrl");
            this.tip = paramJSONObjectProxy.getStringOrNull("tip");
            this.name = paramJSONObjectProxy.getStringOrNull("name");
            this.helpLink = paramJSONObjectProxy.getStringOrNull("helpLink");
        }
    }

    public static ArrayList<ServerIcon> toList(JSONArrayProxy paramJSONArrayPoxy)
    {
        ArrayList localArrayList = new ArrayList();
        if (paramJSONArrayPoxy != null){
            try
            {
                for (int i = 0; i < paramJSONArrayPoxy.length(); i++)
                {
                    ServerIcon localServerIcon = new ServerIcon(paramJSONArrayPoxy.getJSONObject(i));
                    if (!TextUtils.isEmpty(localServerIcon.getName()))
                        localArrayList.add(localServerIcon);
                }
            }
            catch (Exception e)
            {
                if (Log.D)
                    Log.e("ServerIcon", e.getMessage());
            }
        }
                return localArrayList;
    }

    public String getHelpLink()
    {
        if (TextUtils.isEmpty(this.helpLink))
            return "";
        return this.helpLink;
    }

    public String getImageUrl()
    {
        if (TextUtils.isEmpty(this.imageUrl))
            return "";
        return this.imageUrl;
    }

    public String getName()
    {
        if (TextUtils.isEmpty(this.name))
            return "";
        return this.name;
    }

    public String getTip()
    {
        if (TextUtils.isEmpty(this.tip))
            return "";
        return this.tip;
    }
}
