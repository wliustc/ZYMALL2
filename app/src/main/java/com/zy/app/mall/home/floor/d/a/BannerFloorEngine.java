package com.zy.app.mall.home.floor.d.a;

import com.zy.app.mall.home.floor.d.a.FloorEngine;
import com.zy.app.mall.home.floor.model.entity.BannerFloorEntity;
import com.zy.app.mall.home.floor.model.entity.FloorEntity;
import com.zy.common.entity.Commercial;
import com.zy.common.entity.HomeFloorNewElement;
import com.zy.common.entity.HomeFloorNewElements;
import com.zy.common.entity.HomeFloorNewModel;

import java.util.ArrayList;

/**
 * Created by Robin on 2016/6/16.
 */
//b
public class BannerFloorEngine<E extends BannerFloorEntity> extends FloorEngine<E> {
    @Override
    public final void a(HomeFloorNewModel paramHomeFloorNewModel, HomeFloorNewElements paramHomeFloorNewElements, E paramFloorEntity)
    {

        if (paramFloorEntity != null) {//if-eqz p3, :cond_3
            BannerFloorEntity entity = paramFloorEntity;
            entity.setFloorId(paramHomeFloorNewModel.getFloorId());
            ArrayList localArrayList = new ArrayList();
            int i;
            if (paramHomeFloorNewElements != null) {//if-eqz p2, :cond_1
                entity.resetItemList(paramHomeFloorNewElements.getData());
                entity.setEventId("Home_TLFloor_Expo");
                int j = entity.getItemListSize();
                for (i = 0; i < j; i++) {//if-ge v1, v3, :cond_2
                    HomeFloorNewElement element = entity.getItemByPosition(i);
                    if (element != null)
                        localArrayList.add(element.getSourceValue());
                }
            }else {//:cond_1
                entity.setEventId("Home_FocusPic_Expo");
                ArrayList<Commercial> list = Commercial.toList(paramHomeFloorNewModel.getBanner(), 0);
                if (list != null) {
                    for (i = 0; i < list.size(); i++) {
                        localArrayList.add(list.get(i).getSourceValue());
                    }
                }
            }
            //:cond_2
            paramFloorEntity.setSourceValues(localArrayList);
            super.a(paramHomeFloorNewModel, paramHomeFloorNewElements, paramFloorEntity);
        }// :cond_3
    }
}
