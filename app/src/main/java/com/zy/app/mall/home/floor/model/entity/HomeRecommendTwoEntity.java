package com.zy.app.mall.home.floor.model.entity;

import com.zy.common.utils.JSONArrayProxy;

import org.json.JSONArray;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Robin on 2016/5/28.
 */
public class HomeRecommendTwoEntity {
    private HomeRecommendEntity recommendEntityLeft;
    private HomeRecommendEntity recommendEntityRight;

    public static List<HomeRecommendTwoEntity> toList(JSONArrayProxy paramJSONArrayPoxy)
    {
        ArrayList<HomeRecommendTwoEntity> arrayList = null;
        int i;
        HomeRecommendTwoEntity twoEntity = null;
        if (paramJSONArrayPoxy != null) {
            if (paramJSONArrayPoxy != null && paramJSONArrayPoxy.length() > 0) {
                arrayList = new ArrayList<HomeRecommendTwoEntity>();
                try {
                    twoEntity = new HomeRecommendTwoEntity();
                    for (i = 0; i < paramJSONArrayPoxy.length(); i++) {//if-ge v2, v3, :cond_4
                        HomeRecommendEntity entity = new HomeRecommendEntity(paramJSONArrayPoxy.getJSONObject(i));
                        if (entity.getType() < 0)
                            continue;
                        if (twoEntity.getRecommendEntityLeft() == null)
                            twoEntity.recommendEntityLeft = entity;
                        else if (twoEntity.getRecommendEntityRight() == null) {
                            twoEntity.recommendEntityRight = entity;
                            arrayList.add(twoEntity);
                            twoEntity = new HomeRecommendTwoEntity();//v0
                        }
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
        return arrayList;
    }

    public HomeRecommendEntity getRecommendEntityLeft()
    {
        return this.recommendEntityLeft;
    }

    public HomeRecommendEntity getRecommendEntityRight()
    {
        return this.recommendEntityRight;
    }

    public boolean isAllProduct()
    {
        return (this.recommendEntityLeft.getType() == 0) && (this.recommendEntityRight.getType() == 0);
    }

    public boolean isLeftProduct()
    {
        return (this.recommendEntityLeft.getType() == 0) && (this.recommendEntityRight.getType() != 0);
    }

    public boolean isRightProduct()
    {
        return (this.recommendEntityLeft.getType() != 0) && (this.recommendEntityRight.getType() == 0);
    }
}
