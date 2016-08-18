package com.zy.app.mall.home.floor.d.a;

import com.jingdong.common.utils.JSONObjectProxy;
import com.zy.app.mall.home.floor.model.entity.AnnouncementFloorEntity;
import com.zy.common.entity.HomeFloorNewElement;
import com.zy.common.entity.HomeFloorNewElements;
import com.zy.common.entity.HomeFloorNewModel;

/**
 * Created by Robin on 2016/7/6.
 */
//a
public class AnnouncementFloorEngine<E extends AnnouncementFloorEntity> extends FloorEngine<E> {
    @Override
    public final void a(HomeFloorNewModel paramHomeFloorNewModel, HomeFloorNewElements paramHomeFloorNewElements, E paramFloorEntity) {
        if ((paramFloorEntity != null) && (paramHomeFloorNewModel != null)) {
            AnnouncementFloorEntity entity = paramFloorEntity;
            JSONObjectProxy json = paramHomeFloorNewModel.getContent();
            if (paramFloorEntity != null) {
                if (json.optInt("rotate", 4) > 0)
                    entity.setRotateTime(json.optInt("rotate", 4));
                entity.setLeftImageUrl(json.optString("img", ""));
                entity.setElementList(HomeFloorNewElement.toList(json.getJSONArrayOrNull("announcement"), 2));
                int margin = paramHomeFloorNewModel.getBottomMargin();
                if (margin > 0) ;
                entity.setBottomDividerHeight(margin);
            }
        }
    }
}
