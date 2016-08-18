package com.zy.common.entity;

import android.graphics.drawable.Drawable;
import android.text.TextUtils;

import com.jd.framework.json.JDJSON;
import com.jingdong.common.utils.JSONObjectProxy;
import com.zy.common.utils.JSONArrayProxy;
import com.zy.common.utils.Log;

import org.json.JSONException;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Created by Robin on 2016/6/19.
 */
public class Commercial implements Serializable {
    public static final int FOCUSACTIVITY = 0;
    public static final int SELECTACTIVITY = 111;
    public static final int ZHIDEMAIACTIVITY = 112;
    private static final long serialVersionUID = 1L;
    private String action;
    private String clickUrl;
    private Drawable drawable;
    private String feature;
    private String horizontalImg;
    private String id;
    private JumpEntity jump;
    private String param;
    private String shareAvatar;
    private String shareContent;
    private String shareTitle;
    private String shareUrl;
    private String sourceValue;
    private String title;
    private int type;
    private String verticalImg;
    private String viewType;
    private int wareDisplayType;
    private String wareIds;
    private Integer ynShare;

    public Commercial()
    {
    }

    public Commercial(JSONObjectProxy paramJSONObjectProxy, int paramInt)
    {
        update(paramJSONObjectProxy, paramInt);
    }

    public static boolean isAdd(Commercial paramCommercial)
    {
        return !TextUtils.isEmpty(paramCommercial.getId());
    }

    private void parserJumpEntity(JSONObjectProxy paramJSONObjectProxy)
    {
        try
        {
            this.jump = ((JumpEntity) JDJSON.parseObject(paramJSONObjectProxy.getJSONObjectOrNull("jump").toString(), JumpEntity.class));
        }
        catch (java.lang.Exception e)
        {
        }
    }

    public static ArrayList<Commercial> toList(JSONArrayProxy paramJSONArrayPoxy, int paramInt) {
        ArrayList result = null;
        if (paramJSONArrayPoxy != null) {
            result = new ArrayList();
            try {
                for (int i = 0; i < paramJSONArrayPoxy.length(); i++) {
                    Commercial localObject = new Commercial(paramJSONArrayPoxy.getJSONObject(i), paramInt);
                    if (isAdd((Commercial) localObject)) {
                        result.add(localObject);
                    } else if (paramInt == 0)
                        result.add(localObject);
                }
            } catch (JSONException e) {
                if (Log.V)
                    Log.v("Ware", e.getMessage());
            }
        }
        return result;
    }

    private void updateSelect(JSONObjectProxy paramJSONObjectProxy)
    {
        this.id = "Select_Recommend_CarouselFigure";
        this.horizontalImg = paramJSONObjectProxy.optString("img", "");
        this.action = paramJSONObjectProxy.optString("url", "");
        this.type = 3;
        paramJSONObjectProxy = paramJSONObjectProxy.getJSONObjectOrNull("share");
        if (paramJSONObjectProxy != null)
        {
            this.ynShare = Integer.valueOf(1);
            this.title = paramJSONObjectProxy.optString("title", "");
            this.verticalImg = paramJSONObjectProxy.optString("img", "");
            this.sourceValue = paramJSONObjectProxy.optString("summary", "");
        }
    }

    private void updateZhidemai(JSONObjectProxy paramJSONObjectProxy)
    {
        this.id = paramJSONObjectProxy.optString("id");
        this.horizontalImg = paramJSONObjectProxy.optString("img", "");
        this.action = paramJSONObjectProxy.optString("jumpUrl", "");
        this.type = 3;
        paramJSONObjectProxy = paramJSONObjectProxy.getJSONObjectOrNull("share");
        if (paramJSONObjectProxy != null)
        {
            this.ynShare = Integer.valueOf(1);
            this.title = paramJSONObjectProxy.optString("title", "");
            this.verticalImg = paramJSONObjectProxy.optString("img", "");
            this.sourceValue = paramJSONObjectProxy.optString("summary", "");
        }
    }

    public String getAction()
    {
        return this.action;
    }

    public String getClickUrl()
    {
        return this.clickUrl;
    }

    public Drawable getDrawable()
    {
        return this.drawable;
    }

    public String getFeature()
    {
        return this.feature;
    }

    public String getHorizontalImg()
    {
        return this.horizontalImg;
    }

    public String getId()
    {
        return this.id;
    }

    public JumpEntity getJump()
    {
        return this.jump;
    }

    public String getParam()
    {
        return this.param;
    }

    public String getShareAvatar()
    {
        return this.shareAvatar;
    }

    public String getShareContent()
    {
        return this.shareContent;
    }

    public String getShareTitle()
    {
        return this.shareTitle;
    }

    public String getShareUrl()
    {
        return this.shareUrl;
    }

    public String getSourceValue()
    {
        if (this.sourceValue == null)
            return "";
        return this.sourceValue;
    }

    public String getTitle()
    {
        return this.title;
    }

    public int getType()
    {
        return this.type;
    }

    public String getVerticalImg()
    {
        return this.verticalImg;
    }

    public String getViewType()
    {
        return this.viewType;
    }

    public int getWareDisplayType()
    {
        return this.wareDisplayType;
    }

    public String getWareIds()
    {
        return this.wareIds;
    }

    public Integer getYnShare()
    {
        if (this.ynShare == null);
        for (int i = 0; ; i = this.ynShare.intValue())
            return Integer.valueOf(i);
    }

    public void setAction(String paramString)
    {
        this.action = paramString;
    }

    public void setDrawable(Drawable paramDrawable)
    {
        this.drawable = paramDrawable;
    }

    public void setFeature(String paramString)
    {
        this.feature = paramString;
    }

    public void setHorizontalImg(String paramString)
    {
        this.horizontalImg = paramString;
    }

    public void setId(String paramString)
    {
        this.id = paramString;
    }

    public void setTitle(String paramString)
    {
        this.title = paramString;
    }

    public void setType(int paramInt)
    {
        this.type = paramInt;
    }

    public void setVerticalImg(String paramString)
    {
        this.verticalImg = paramString;
    }

    public void setWareDisplayType(int paramInt)
    {
        this.wareDisplayType = paramInt;
    }

    public void setWareIds(String paramString)
    {
        this.wareIds = paramString;
    }

    public void setYnShare(Integer paramInteger)
    {
        this.ynShare = paramInteger;
    }

    public void update(JSONObjectProxy paramJSONObjectProxy, int paramInt)
    {
        if (paramInt == 111)
        {
            updateSelect(paramJSONObjectProxy);
            return;
        }
        if (paramInt == 112)
        {
            updateZhidemai(paramJSONObjectProxy);
            return;
        }
        this.id = paramJSONObjectProxy.getStringOrNull("activityId");
        this.title = paramJSONObjectProxy.getStringOrNull("title");
        this.horizontalImg = paramJSONObjectProxy.getStringOrNull("horizontalImag");
        this.verticalImg = paramJSONObjectProxy.getStringOrNull("verticalImage");
        this.sourceValue = paramJSONObjectProxy.getStringOrNull("sourceValue");
        setYnShare(paramJSONObjectProxy.getIntOrNull("ynShare"));
        this.type = paramJSONObjectProxy.optInt("type");
        this.action = paramJSONObjectProxy.getStringOrNull("action");
        this.shareAvatar = paramJSONObjectProxy.optString("shareAvatar", "");
        this.shareContent = paramJSONObjectProxy.optString("shareContent", "");
        this.shareTitle = paramJSONObjectProxy.optString("shareTitle", "");
        this.shareUrl = paramJSONObjectProxy.optString("shareUrl", "");
        this.viewType = paramJSONObjectProxy.optString("viewType", "");
        this.param = paramJSONObjectProxy.optString("param", "");
        this.clickUrl = paramJSONObjectProxy.optString("clickUrl", "");
        if (this.type == 0)//if-nez v0, :cond_2
        try
        {
            this.wareDisplayType = paramJSONObjectProxy.getInt("wareDisplayType");
        }
        catch (JSONException localJSONException)
        {
        }
        parserJumpEntity(paramJSONObjectProxy);
    }
}
