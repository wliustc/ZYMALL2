package com.zy.app.mall.home.floor.d.a;

import com.jingdong.common.utils.JSONObjectProxy;
import com.zy.app.mall.home.floor.d.a.FloorEngine;
import com.zy.app.mall.home.floor.model.entity.ListItemFloorEntity;
import com.zy.common.entity.HomeFloorNewElement;

/**
 * Created by Robin on 2016/6/22.
 */
//g
public class ListItemFloorEngine<E extends ListItemFloorEntity> extends FloorEngine<E> {

    @Override
    public void a(HomeFloorNewElement paramHomeFloorNewElement, E paramE)
    {
        super.a(paramHomeFloorNewElement, paramE);
        paramE.setMaiDianData(paramHomeFloorNewElement.getRcSourceValue(), paramHomeFloorNewElement.getSourceValue());
        paramE.setRcJumpType(paramHomeFloorNewElement.getRcJumpType());
        if (paramHomeFloorNewElement.getAdvert() != null)
        {
            paramE.setAdvertImg(paramHomeFloorNewElement.getAdvert().optString("advertImg"));
            paramE.setAdvertJump(paramHomeFloorNewElement.getAdvert().optString("advertJump"));
        }else
            paramE.setAdvertImg("");
    }

    public void a(boolean paramBoolean, JSONObjectProxy paramJSONObjectProxy, E paramE)
    {
    }
}
