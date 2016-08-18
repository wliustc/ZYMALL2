package com.zy.app.mall.home.floor.model.entity;

import com.jd.framework.json.JDJSON;
import com.jingdong.common.utils.JSONObjectProxy;
import com.zy.common.entity.JumpEntity;

/**
 * Created by Robin on 2016/5/28.
 */
public class HomeRecommendEntity {
    private HomeDNAEntity dna;
    private JumpEntity jump;
    private HomeProductEntity product;
    private HomeShopEntity shop;
    private int type = -1;
    private String url;

    public HomeRecommendEntity(JSONObjectProxy paramJSONObjectProxy)
    {
        if ("ware".equals(paramJSONObjectProxy.opt("type")))
        {
            this.product = new HomeProductEntity(paramJSONObjectProxy);
            this.type = 0;
        }else if ("shop".equals(paramJSONObjectProxy.opt("type")))
        {
            this.shop = new HomeShopEntity(paramJSONObjectProxy);
            this.type = 1;
        }else if ("channel".equals(paramJSONObjectProxy.opt("type"))) {
            if (paramJSONObjectProxy.getJSONObjectOrNull("jump") != null)
                this.jump = JDJSON.parseObject(paramJSONObjectProxy.getJSONObjectOrNull("jump").toString(), JumpEntity.class);
            this.url = paramJSONObjectProxy.optString("imageurl");
            this.type = 2;
        }else if ("dna".equals(paramJSONObjectProxy.opt("type"))) {
            this.dna = new HomeDNAEntity(paramJSONObjectProxy);
            this.type = 3;
        }
        return;
    }

    public HomeDNAEntity getDna()
    {
        return this.dna;
    }

    public JumpEntity getJump()
    {
        return this.jump;
    }

    public HomeProductEntity getProduct()
    {
        return this.product;
    }

    public HomeShopEntity getShop()
    {
        return this.shop;
    }

    public int getType()
    {
        return this.type;
    }

    public String getUrl()
    {
        return this.url;
    }

}
