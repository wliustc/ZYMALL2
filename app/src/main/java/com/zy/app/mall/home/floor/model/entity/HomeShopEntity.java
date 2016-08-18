package com.zy.app.mall.home.floor.model.entity;

import com.jingdong.common.utils.JSONObjectProxy;
import com.zy.common.utils.JSONArrayProxy;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Robin on 2016/6/19.
 */
public class HomeShopEntity {
    private String clk;
    public int followCount;
    public boolean hasActivity;
    public boolean hasCoupon;
    public boolean hasNewWare;
    public boolean hasPromotion;
    public String logoUrl;
    public String shopId;
    public String shopName;
    public String sourceValue;
    private String targetUrl;
    public int venderType;
    public List<HomeProductEntity> wareList;

    public HomeShopEntity(JSONObjectProxy paramJSONObjectProxy)
    {
        this.shopId = paramJSONObjectProxy.optString("shopId");
        this.shopName = paramJSONObjectProxy.optString("shopName");
        this.logoUrl = paramJSONObjectProxy.optString("logoUrl");
        this.venderType = paramJSONObjectProxy.optInt("venderType");
        this.followCount = paramJSONObjectProxy.optInt("followCount");
        this.hasNewWare = paramJSONObjectProxy.optBoolean("hasNewWare");
        this.hasCoupon = paramJSONObjectProxy.optBoolean("hasCoupon");
        this.hasPromotion = paramJSONObjectProxy.optBoolean("hasPromotion");
        this.hasActivity = paramJSONObjectProxy.optBoolean("hasActivity");
        this.sourceValue = paramJSONObjectProxy.optString("sourceValue");
        this.targetUrl = paramJSONObjectProxy.optString("clickUrl");
        this.clk = paramJSONObjectProxy.optString("clk");
        JSONArrayProxy wareList = paramJSONObjectProxy.getJSONArrayOrNull("wareList");
        if (wareList != null)
        {
            int length = wareList.length();
            if (length > 0)
            {
                this.wareList = new ArrayList();
                for ( int i = 0; i < length; i++)
                {
                    JSONObjectProxy localObject = wareList.getJSONObjectOrNull(i);
                    if (localObject != null) {
                        HomeProductEntity entity = new HomeProductEntity(((JSONObjectProxy) localObject).optString("wareId"), ((JSONObjectProxy) localObject).optString("imgPath"));
                        this.wareList.add(entity);
                    }
                }
            }
        }
    }

    public String getClk()
    {
        return this.clk;
    }

    public int getFollowCount()
    {
        return this.followCount;
    }

    public String getLogoUrl()
    {
        return this.logoUrl;
    }

    public String getShopId()
    {
        return this.shopId;
    }

    public String getShopName()
    {
        return this.shopName;
    }

    public String getSourceValue()
    {
        return this.sourceValue;
    }

    public String getTargetUrl()
    {
        return this.targetUrl;
    }

    public int getVenderType()
    {
        return this.venderType;
    }

    public List<HomeProductEntity> getWareList()
    {
        return this.wareList;
    }

    public boolean isHasActivity()
    {
        return this.hasActivity;
    }

    public boolean isHasCoupon()
    {
        return this.hasCoupon;
    }

    public boolean isHasNewWare()
    {
        return this.hasNewWare;
    }

    public boolean isHasPromotion()
    {
        return this.hasPromotion;
    }
}
