package com.zy.app.mall.home.floor.d.a;

import com.zy.app.mall.home.floor.model.entity.WithSubFloorFloorEntity;
import com.zy.common.entity.HomeFloorNewElements;
import com.zy.common.entity.HomeFloorNewModel;

/**
 * Created by Robin on 2016/7/6.
 */
//k
public class WithSubFloorFloorEngine<E extends WithSubFloorFloorEntity> extends FloorEngine<E>{
    @Override
    public final void a(HomeFloorNewModel paramHomeFloorNewModel, HomeFloorNewElements paramHomeFloorNewElements, E paramFloorEntity)
    {
        super.a(paramHomeFloorNewModel, paramHomeFloorNewElements, paramFloorEntity);
        paramFloorEntity.setElements(HomeFloorNewElements.toList(paramHomeFloorNewModel.getContent().getJSONArrayOrNull("subFloors")));
    }
}
