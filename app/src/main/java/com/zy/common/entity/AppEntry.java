package com.zy.common.entity;

import com.jd.framework.json.JDJSON;
import com.jingdong.common.utils.JSONObjectProxy;
import com.zy.common.utils.JSONArrayProxy;

import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by robin on 16-7-5.
 */
public class AppEntry {
    public static final Integer ACTION_TYPE_FUNCTIONID = Integer.valueOf(3);
    public static final Integer ACTION_TYPE_MPAGE = Integer.valueOf(1);
    public static final Integer ACTION_TYPE_NATIVE = Integer.valueOf(2);
    public static final String APP_CODE_CAIPIAO = "caipiao";
    public static final String APP_CODE_CHONGZHI = "chongzhi";
    public static final String APP_CODE_COUPON_CENTER = "couponcenter";
    public static final String APP_CODE_DIANYINGPIAO = "dianyingpiao";
    public static final String APP_CODE_GENERICCHANNEL = "genericChannel";
    public static final String APP_CODE_JIPIAO = "jipiao";
    public static final String APP_CODE_LIULIANGCHONGZHI = "liuliangchongzhi";
    public static final String APP_CODE_QQCHONGZHI = "qqchongzhi";
    public static final String APP_CODE_SAO_A_SAO = "saoasao";
    public static final String APP_CODE_SHENGHUOQUAN = "shenghuoquan";
    public static final String APP_CODE_YOUXICHONGZHI = "youxichongzhi";
    private Integer actionType;
    private String appCode;
    private Integer cornerIcon;
    private String functionId;
    private String icon;
    private String id;
    private JumpEntity jump;
    private String name;
    private String nativeJumpType;
    private String needLogin = "0";
    private Integer order;
    private String param;
    private Integer redDot;
    private String redirectURL;
    private String share_desc;
    private Integer share_enable;
    private String share_icon;
    private String share_name;
    private String share_url;
    private String slogan;
    private String sourceValue;


    public AppEntry()
    {
    }

    public AppEntry(JSONObjectProxy paramJSONObjectProxy)
    {
        this.id = paramJSONObjectProxy.optString("id");
        this.appCode = paramJSONObjectProxy.optString("appCode");
        this.name = paramJSONObjectProxy.optString("name");
        this.icon = paramJSONObjectProxy.optString("icon");
        this.slogan = paramJSONObjectProxy.optString("slogan");
        this.cornerIcon = Integer.valueOf(paramJSONObjectProxy.optInt("cornerIcon"));
        this.order = Integer.valueOf(paramJSONObjectProxy.optInt("order"));
        this.actionType = Integer.valueOf(paramJSONObjectProxy.optInt("actionType"));
        this.redirectURL = paramJSONObjectProxy.optString("redirectURL");
        this.nativeJumpType = paramJSONObjectProxy.optString("nativeJumpType");
        this.functionId = paramJSONObjectProxy.optString("functionId");
        this.needLogin = paramJSONObjectProxy.optString("needLogin");
        JSONObject localJSONObject = paramJSONObjectProxy.optJSONObject("share");
        if (localJSONObject != null)
        {
            this.share_enable = Integer.valueOf(localJSONObject.optInt("enable"));
            this.share_name = localJSONObject.optString("name");
            this.share_url = localJSONObject.optString("url");
            this.share_icon = localJSONObject.optString("icon");
            this.share_desc = localJSONObject.optString("desc");
        }
        this.sourceValue = paramJSONObjectProxy.optString("sourceValue");
        this.redDot = Integer.valueOf(paramJSONObjectProxy.optInt("notificationEnable", 0));
        this.param = paramJSONObjectProxy.optString("param", "");
        try
        {
            this.jump = ((JumpEntity) JDJSON.parseObject(paramJSONObjectProxy.getJSONObjectOrNull("jump").toString(), JumpEntity.class));
            return;
        }
        catch (java.lang.Exception e)
        {
        }
    }

    public static List<AppEntry> toList(JSONArrayProxy paramJSONArrayPoxy)
    {
        ArrayList localArrayList = new ArrayList();
        if ((paramJSONArrayPoxy != null) && (paramJSONArrayPoxy.length() != 0)){
            for (int i = 0; i < paramJSONArrayPoxy.length(); i++)
            {
                JSONObjectProxy localJSONObjectProxy = paramJSONArrayPoxy.getJSONObjectOrNull(i);
                if (localJSONObjectProxy != null)
                    localArrayList.add(new AppEntry(localJSONObjectProxy));
            }
        }
        return localArrayList;
    }

    public Integer getActionType()
    {
        return this.actionType;
    }

    public String getAppCode()
    {
        return this.appCode;
    }

    public Integer getCornerIcon()
    {
        return this.cornerIcon;
    }

    public String getFunctionId()
    {
        return this.functionId;
    }

    public String getIcon()
    {
        return this.icon;
    }

    public String getId()
    {
        return this.id;
    }

    public JumpEntity getJump()
    {
        return this.jump;
    }

    public String getName()
    {
        return this.name;
    }

    public String getNativeJumpType()
    {
        return this.nativeJumpType;
    }

    public String getNeedLogin()
    {
        return this.needLogin;
    }

    public Integer getOrder()
    {
        return this.order;
    }

    public String getParam()
    {
        return this.param;
    }

    public Integer getRedDot()
    {
        return this.redDot;
    }

    public String getRedirectURL()
    {
        return this.redirectURL;
    }

    public String getShare_desc()
    {
        return this.share_desc;
    }

    public Integer getShare_enable()
    {
        return this.share_enable;
    }

    public String getShare_icon()
    {
        return this.share_icon;
    }

    public String getShare_name()
    {
        return this.share_name;
    }

    public String getShare_url()
    {
        return this.share_url;
    }

    public String getSlogan()
    {
        return this.slogan;
    }

    public String getSourceValue()
    {
        return this.sourceValue;
    }

    public void setIcon(String paramString)
    {
        this.icon = paramString;
    }

    public void setId(String paramString)
    {
        this.id = paramString;
    }

    public void setJump(JumpEntity paramJumpEntity)
    {
        this.jump = paramJumpEntity;
    }

    public void setName(String paramString)
    {
        this.name = paramString;
    }
}
