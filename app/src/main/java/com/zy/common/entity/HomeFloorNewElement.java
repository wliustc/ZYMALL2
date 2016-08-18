package com.zy.common.entity;

import com.jd.framework.json.JDJSON;
import com.jingdong.common.utils.JSONObjectProxy;
import com.zy.common.utils.JSONArrayProxy;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

/**
 * Created by Robin on 2016/6/5.
 */
public class HomeFloorNewElement {
    public static final int ANNOUNCEMENT = 2;
    public static final int CHANNEL_ELEMENT = 1;
    public static final int HOME = 0;
    private JSONObjectProxy advert;
    private String announcementContent;
    private String clickUrl;
    private JSONObjectProxy content;
    private String functionId;
    private String id;
    private int imageType;
    private String img;
    private String isShare;
    private JumpEntity jump;
    private String jumpTo;
    private String jumpType;
    private String labelColor;
    private String labelWords;
    private String param;
    private JumpEntity rcJump;
    private String rcJumpTo;
    private String rcJumpType;
    private String rcJumpUrl;
    private String rcSourceValue;
    private String rightCorner;
    private String shareAvatar;
    private String shareContent;
    private String shareImg;
    private String shareTitle;
    private String shareUrl;
    private String showName;
    private String slogan;
    private String sourceValue;
    private String subtitle;
    private String summary;
    private String url;

    public HomeFloorNewElement(JSONObjectProxy paramJSONObjectProxy, int paramInt)
    {
        switch (paramInt)
        {
            case 0:
                this.id = paramJSONObjectProxy.optString("id", "");
                this.isShare = paramJSONObjectProxy.optString("isShare", "");
                this.rightCorner = paramJSONObjectProxy.optString("rightCorner", "");
                this.jumpType = paramJSONObjectProxy.optString("jumpType", "");
                this.jumpTo = paramJSONObjectProxy.optString("jumpTo", "");
                this.url = paramJSONObjectProxy.optString("url", "");
                this.img = paramJSONObjectProxy.optString("img", "");
                this.content = paramJSONObjectProxy.getJSONObjectOrNull("content");
                this.showName = paramJSONObjectProxy.optString("showName", "");
                this.imageType = paramJSONObjectProxy.optInt("imageType", 0);
                this.subtitle = paramJSONObjectProxy.optString("subtitle", "");
                this.labelWords = paramJSONObjectProxy.optString("labelWords", "");
                this.labelColor = paramJSONObjectProxy.optString("labelColor", "");
                this.param = paramJSONObjectProxy.optString("param", "");
                this.sourceValue = paramJSONObjectProxy.optString("sourceValue", "");
                this.rcJumpTo = paramJSONObjectProxy.optString("rcJumpTo", "");
                this.rcJumpType = paramJSONObjectProxy.optString("rcJumpType", "");
                this.rcJumpUrl = paramJSONObjectProxy.optString("rcJumpUrl", "");
                this.rcSourceValue = paramJSONObjectProxy.optString("rcSourceValue", "");
                this.shareTitle = paramJSONObjectProxy.optString("shareTitle", "");
                this.shareContent = paramJSONObjectProxy.optString("shareContent", "");
                this.shareAvatar = paramJSONObjectProxy.optString("shareAvatar", "");
                this.shareUrl = paramJSONObjectProxy.optString("shareUrl", "");
                this.advert = paramJSONObjectProxy.getJSONObjectOrNull("advert");
                this.clickUrl = paramJSONObjectProxy.optString("clickUrl", "");
                this.functionId = paramJSONObjectProxy.optString("functionId", "");
                parserJumpEntity(paramJSONObjectProxy);
                parserRcJumpEntity(paramJSONObjectProxy);
                return;
            case 1:
                    this.id = paramJSONObjectProxy.optString("id", "");
                    this.jumpType = paramJSONObjectProxy.optString("jumpType", "");
                    this.jumpTo = paramJSONObjectProxy.optString("jumpTo", "");
                    this.url = paramJSONObjectProxy.optString("jumpUrl", "");
                    this.img = paramJSONObjectProxy.optString("img", "");
                    this.sourceValue = paramJSONObjectProxy.optString("sourceValue", "");
                    this.isShare = paramJSONObjectProxy.optString("shareDefault", "");
                    if ("1".equals(this.isShare))
                        this.showName = paramJSONObjectProxy.optString("title", "");
                    else {
                        JSONObject object = paramJSONObjectProxy.optJSONObject("share");
                        if (object != null) {
                            this.showName = object.optString("title", "");
                            this.summary = object.optString("summary", "");
                            this.shareImg = object.optString("img", "");
                        }
                    }
                return;
            case 2:
                this.slogan = paramJSONObjectProxy.optString("slogan", "");
                this.announcementContent = paramJSONObjectProxy.optString("content", "");
                this.jumpType = paramJSONObjectProxy.optString("jumpType", "");
                this.jumpTo = paramJSONObjectProxy.optString("jumpTo", "");
                this.url = paramJSONObjectProxy.optString("url", "");
                this.sourceValue = paramJSONObjectProxy.optString("sourceValue", "");
                this.shareTitle = paramJSONObjectProxy.optString("shareTitle", "");
                this.shareContent = paramJSONObjectProxy.optString("shareContent", "");
                this.shareAvatar = paramJSONObjectProxy.optString("shareAvatar", "");
                this.shareUrl = paramJSONObjectProxy.optString("shareUrl", "");
                this.isShare = paramJSONObjectProxy.optString("isShare", "");
                parserJumpEntity(paramJSONObjectProxy);
        }

    }

    public HomeFloorNewElement(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6)
    {
        this.isShare = paramString1;
        this.shareUrl = paramString2;
        this.shareTitle = paramString3;
        this.shareContent = paramString4;
        this.shareAvatar = paramString5;
        this.functionId = paramString6;
    }

    private void parserJumpEntity(JSONObjectProxy paramJSONObjectProxy)
    {
        try
        {
            this.jump = JDJSON.parseObject(paramJSONObjectProxy.getJSONObjectOrNull("jump").toString(), JumpEntity.class);
        }
        catch (java.lang.Exception e)
        {
        }
        if (this.jump != null)
            this.sourceValue = this.jump.getSrv();
        return;
    }

    private void parserRcJumpEntity(JSONObjectProxy paramJSONObjectProxy)
    {
        try
        {
            this.rcJump = JDJSON.parseObject(paramJSONObjectProxy.getJSONObjectOrNull("rcJump").toString(), JumpEntity.class);
        }
        catch (java.lang.Exception e)
        {
        }
        if (this.rcJump != null)
            this.rcSourceValue = this.rcJump.getSrv();
        return;

    }

    public static java.util.ArrayList<HomeFloorNewElement> toList(JSONArrayProxy paramJSONArrayPoxy){
        ArrayList<HomeFloorNewElement> result = null;
        if(paramJSONArrayPoxy != null){
            result = new ArrayList<HomeFloorNewElement>();
            for(int i = 0; i < paramJSONArrayPoxy.length(); i++){
                JSONObjectProxy jsonObject = null;
                try {
                    jsonObject = paramJSONArrayPoxy.getJSONObject(i);
                    if(jsonObject != null){
                        result.add(new HomeFloorNewElement(jsonObject, 0));
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }
        return result;
    }

    public static java.util.ArrayList<HomeFloorNewElement> toList(JSONArrayProxy paramJSONArrayPoxy, int paramInt){
        ArrayList<HomeFloorNewElement> result = null;
        if(paramJSONArrayPoxy != null){
            result = new ArrayList<HomeFloorNewElement>();
            for(int i = 0; i < paramJSONArrayPoxy.length(); i++){
                JSONObjectProxy jsonObject = null;
                try {
                    jsonObject = paramJSONArrayPoxy.getJSONObject(i);
                    if(jsonObject != null){
                        result.add(new HomeFloorNewElement(jsonObject, paramInt));
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }
        return result;
    }

    public JSONObjectProxy getAdvert()
    {
        return this.advert;
    }

    public String getAnnouncementContent()
    {
        return this.announcementContent;
    }

    public String getClickUrl()
    {
        return this.clickUrl;
    }

    public JSONObjectProxy getContent()
    {
        return this.content;
    }

    public String getFunctionId()
    {
        return this.functionId;
    }

    public String getId()
    {
        return this.id;
    }

    public int getImageType()
    {
        return this.imageType;
    }

    public String getImg()
    {
        return this.img;
    }

    public String getIsShare()
    {
        return this.isShare;
    }

    public JumpEntity getJump()
    {
        return this.jump;
    }

    public String getJumpTo()
    {
        return this.jumpTo;
    }

    public String getJumpType()
    {
        return this.jumpType;
    }

    public String getLabelColor()
    {
        return this.labelColor;
    }

    public String getLabelWords()
    {
        return this.labelWords;
    }

    public String getParam()
    {
        return this.param;
    }

    public JumpEntity getRcJump()
    {
        return this.rcJump;
    }

    public String getRcJumpTo()
    {
        return this.rcJumpTo;
    }

    public String getRcJumpType()
    {
        return this.rcJumpType;
    }

    public String getRcJumpUrl()
    {
        return this.rcJumpUrl;
    }

    public String getRcSourceValue()
    {
        return this.rcSourceValue;
    }

    public String getRightCorner()
    {
        return this.rightCorner;
    }

    public String getShareAvatar()
    {
        return this.shareAvatar;
    }

    public String getShareContent()
    {
        return this.shareContent;
    }

    public String getShareImg()
    {
        return this.shareImg;
    }

    public String getShareTitle()
    {
        return this.shareTitle;
    }

    public String getShareUrl()
    {
        return this.shareUrl;
    }

    public String getShowName()
    {
        return this.showName;
    }

    public String getSlogan()
    {
        return this.slogan;
    }

    public String getSourceValue()
    {
        return this.sourceValue;
    }

    public String getSubtitle()
    {
        return this.subtitle;
    }

    public String getSummary()
    {
        return this.summary;
    }

    public String getUrl()
    {
        return this.url;
    }
}
