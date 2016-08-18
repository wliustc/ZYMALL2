package com.zy.common.entity;

import com.jd.framework.json.JDJSON;
import com.jingdong.common.utils.JSONObjectProxy;
import com.zy.common.utils.JSONArrayProxy;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Robin on 2016/5/8.
 */
public class HomeFloorNewModel {
    public static final int APPCENTER = 1;
    public static final int BANNER = 0;
    public static final int HYBRID = 2;
    public static final int RECOMMEND = 3;
    private JSONArrayProxy banner;
    //private JSONArray banner;
    private int bottomMargin;
    private JSONObjectProxy content;
    //private JSONObject content;
    private String floorId;
    private String functionId;
    private String head;
    private long hideTime;
    private String img;
    private String isShare;
    private JumpEntity jump;
    private String jumpTo;
    private String jumpType;
    private String logoImage;
    private String param;
    private String rightCorner;
    private String shareAvatar;
    private String shareContent;
    private String shareTitle;
    private String shareUrl;
    private String showName;
    private String sort;
    private String sourceValue;
    private String textColor;
    private String type;
    private String url;


    public JSONArrayProxy getBanner(){
        return this.banner;
    }

    public int getBottomMargin()
    {
        return this.bottomMargin;
    }

    public JSONObjectProxy getContent(){
        return this.content;
    }

    public String getFloorId()
    {
        return this.floorId;
    }

    public String getFunctionId()
    {
        return this.functionId;
    }

    public String getHead()
    {
        return this.head;
    }

    public long getHideTime()
    {
        return this.hideTime;
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

    public String getLogoImage()
    {
        return this.logoImage;
    }

    public String getParam()
    {
        return this.param;
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

    public String getSort()
    {
        return this.sort;
    }

    public String getSourceValue()
    {
        return this.sourceValue;
    }

    public String getTextColor()
    {
        return this.textColor;
    }

    public String getType()
    {
        return this.type;
    }

    public String getUrl()
    {
        return this.url;
    }

    public HomeFloorNewModel(JSONObjectProxy paramJSONObjectProxy) {
        this.type = paramJSONObjectProxy.optString("type", "");
        this.head = paramJSONObjectProxy.optString("head", "");
        this.showName = paramJSONObjectProxy.optString("showName", "");
        this.textColor = paramJSONObjectProxy.optString("textColor", "");
        this.logoImage = paramJSONObjectProxy.optString("logoImage", "");
        this.sort = paramJSONObjectProxy.optString("sort");
        this.rightCorner = paramJSONObjectProxy.optString("rightCorner", "");
        this.jumpType = paramJSONObjectProxy.optString("jumpType", "");
        this.jumpTo = paramJSONObjectProxy.optString("jumpTo", "");
        this.url = paramJSONObjectProxy.optString("url", "");
        this.bottomMargin = paramJSONObjectProxy.optInt("bottomMargin", 0);
        this.functionId = paramJSONObjectProxy.optString("functionId", "");
        this.param = paramJSONObjectProxy.optString("param", "");
        this.img = paramJSONObjectProxy.optString("img", "");
        this.hideTime = paramJSONObjectProxy.optLong("hideTime", 0L);
        this.sourceValue = paramJSONObjectProxy.optString("sourceValue", "");
        this.floorId = paramJSONObjectProxy.optString("floorId", "");
        if ("banner".equals(this.type))
            try {
                this.banner = paramJSONObjectProxy.getJSONArray("content");
            } catch (JSONException e) {
                e.printStackTrace();
            }
        else
            try {
                this.content = paramJSONObjectProxy.getJSONObject("content");
            } catch (JSONException e) {
                e.printStackTrace();
            }

        this.isShare = paramJSONObjectProxy.optString("isShare", "");
        this.shareAvatar = paramJSONObjectProxy.optString("shareAvatar", "");
        this.shareContent = paramJSONObjectProxy.optString("shareContent", "");
        this.shareTitle = paramJSONObjectProxy.optString("shareTitle", "");
        this.shareUrl = paramJSONObjectProxy.optString("shareUrl", "");
        try {
            this.jump = ((JumpEntity) JDJSON.parseObject(paramJSONObjectProxy.getJSONObject("jump").toString(), JumpEntity.class));
        } catch (java.lang.Exception e) {
        }
        if (this.jump != null)
            this.sourceValue = this.jump.getSrv();
        return;
    }

    public static List<HomeFloorNewModel> toList(JSONArrayProxy floorList) {
        List<HomeFloorNewModel> list = new ArrayList<HomeFloorNewModel>();
        for(int i = 0; i < floorList.length(); i++){
            JSONObjectProxy jsonObject = null;
            try {
                jsonObject = floorList.getJSONObject(i);
                HomeFloorNewModel homeFloorNewModel = new HomeFloorNewModel(jsonObject);
                list.add(homeFloorNewModel);
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        return list;
    }
}
