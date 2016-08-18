package com.zy.common.entity;

/**
 * Created by Robin on 2016/5/8.
 */
public class HomeFloorNewModel {
    public static final int APPCENTER = 1;
    public static final int BANNER = 0;
    public static final int HYBRID = 2;
    public static final int RECOMMEND = 3;
    //private JSONArrayPoxy banner;
    private int bottomMargin;
    //private JSONObjectProxy content;
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


    public int getBottomMargin()
    {
        return this.bottomMargin;
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
}
