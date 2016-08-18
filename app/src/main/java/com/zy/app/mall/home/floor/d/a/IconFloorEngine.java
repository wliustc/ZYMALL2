package com.zy.app.mall.home.floor.d.a;


import android.content.SharedPreferences;
import android.text.TextUtils;

import com.jingdong.app.mall.utils.CommonUtil;
import com.zy.app.mall.home.floor.a.a.MallFloorEvent;
import com.zy.app.mall.home.floor.model.entity.FloorEntity;
import com.zy.app.mall.home.floor.model.entity.IconFloorEntity;
import com.zy.common.entity.AppEntry;
import com.zy.common.entity.HomeFloorNewElements;
import com.zy.common.entity.HomeFloorNewModel;
import com.zy.common.utils.JSONArrayProxy;

import java.util.List;

/**
 * Created by robin on 16-7-5.
 */
//e
public class IconFloorEngine<E extends IconFloorEntity> extends FloorEngine<E> {
    @Override
    public final void a(HomeFloorNewModel paramHomeFloorNewModel, HomeFloorNewElements paramHomeFloorNewElements, E paramFloorEntity)
    {
        super.a(paramHomeFloorNewModel, paramHomeFloorNewElements, paramFloorEntity);
        String v0 = paramHomeFloorNewModel.getContent().optString("poz", "");
        if (!TextUtils.isEmpty(v0))
        {
            SharedPreferences.Editor localEditor = CommonUtil.getJdSharedPreferences().edit();
            localEditor.putString("HOMEPOZ", v0);
            localEditor.commit();
        }
        paramFloorEntity.setRedDotAll(paramHomeFloorNewModel.getContent().optInt("notification", 0));
        paramFloorEntity.setBgUrl(paramHomeFloorNewModel.getContent().optString("bgPic", ""));
        paramFloorEntity.setTextColor(paramHomeFloorNewModel.getContent().optString("fontColor", ""));
        if (paramHomeFloorNewModel == null)
        {
            a(new MallFloorEvent("2", Boolean.valueOf(false)));

        }else {
            JSONArrayProxy jsonArrayProxy = paramHomeFloorNewModel.getContent().getJSONArrayOrNull("data");
            if ((jsonArrayProxy != null)&& (jsonArrayProxy.length() > 0)) {
                List<AppEntry> list = AppEntry.toList(jsonArrayProxy);
                if ((list != null) && (list.size() >= paramFloorEntity.getMaxIconItemCount())) {
                    paramFloorEntity.setAppEntryList(list);
                    a(new MallFloorEvent("1"));
                }
            }else
                a(new MallFloorEvent("2", Boolean.valueOf(false)));
        }
        return;
    }
}
