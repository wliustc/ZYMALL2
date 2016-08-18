package com.zy.app.mall.home.floor.model.entity;

import android.text.TextUtils;

import com.jd.framework.json.JDJSON;
import com.jingdong.common.utils.JSONObjectProxy;
import com.zy.common.entity.JumpEntity;
import com.zy.common.utils.JSONArrayProxy;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Robin on 2016/6/19.
 */
public class HomeDNAEntity {
    private String description;
    private String dnaId;
    private String dnaName;
    private JumpEntity jump;
    public List<HomeProductEntity> wareList;

    public HomeDNAEntity(JSONObjectProxy paramJSONObjectProxy) {
        this.dnaId = paramJSONObjectProxy.optString("dnaId");
        this.dnaName = paramJSONObjectProxy.optString("dnaName");
        if (paramJSONObjectProxy.getJSONObjectOrNull("jump") != null)
            this.jump = ((JumpEntity) JDJSON.parseObject(paramJSONObjectProxy.getJSONObjectOrNull("jump").toString(), JumpEntity.class));
        this.description = paramJSONObjectProxy.optString("description");
        if ((!TextUtils.isEmpty(this.description)) && (this.description.length() > 10))
            this.description = this.description.substring(0, 10);
        JSONArrayProxy wareList = paramJSONObjectProxy.getJSONArrayOrNull("wareList");
        if (wareList != null)
        {
            int length = wareList.length();
            if (length > 0)
            {
                this.wareList = new ArrayList();

                for (int i = 0; i < length; i ++)
                {
                    JSONObjectProxy localObject = wareList.getJSONObjectOrNull(i);
                    if (localObject != null)
                    {
                        HomeProductEntity entity = new HomeProductEntity(localObject.optString("wareId"), localObject.optString("imgPath"));
                        this.wareList.add(entity);
                    }
                }
            }
        }
    }

    public String getDescription()
    {
        if (TextUtils.isEmpty(this.description))
            return "";
        return this.description;
    }

    public String getDnaId()
    {
        return this.dnaId;
    }

    public String getDnaName()
    {
        if (TextUtils.isEmpty(this.dnaName))
            return "";
        return this.dnaName;
    }

    public JumpEntity getJump()
    {
        return this.jump;
    }

    public List<HomeProductEntity> getWareList()
    {
        return this.wareList;
    }
}
