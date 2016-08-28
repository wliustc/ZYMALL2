package com.jingdong.app.mall.home.floor.d.a;

import com.jingdong.common.utils.JSONObjectProxy;
import com.zy.app.mall.home.floor.a.a.MallFloorEvent;
import com.zy.app.mall.home.floor.d.a.ListItemFloorEngine;
import com.zy.app.mall.home.floor.model.entity.ShopFloorEntity;
import com.zy.common.entity.GoodShopModel;
import com.zy.common.entity.HomeFloorNewElement;
import com.zy.common.entity.JumpEntity;
import com.zy.common.utils.JSONArrayProxy;
import com.zy.common.utils.Log;

import java.util.ArrayList;

/**
 * Created by robin on 16-7-28.
 */
//j
public class ShopFloorEngine<E extends ShopFloorEntity> extends ListItemFloorEngine<ShopFloorEntity> {
    ////private UseCacheHttpGroupUtil c = new UseCacheHttpGroupUtil();

    @Override
    public void a(HomeFloorNewElement paramHomeFloorNewElement, ShopFloorEntity paramShopFloorEntity)
    {
        super.a(paramHomeFloorNewElement, paramShopFloorEntity);
        if (paramShopFloorEntity == null)
            return;
        String str2 = "";
        String str1 = "";
        JumpEntity localJumpEntity2 = paramHomeFloorNewElement.getRcJump();
        JumpEntity localJumpEntity1 = paramHomeFloorNewElement.getJump();
        if (localJumpEntity2 != null)
            str2 = localJumpEntity2.getSrv();
        if (localJumpEntity1 != null)
            str1 = localJumpEntity1.getSrv();
        paramShopFloorEntity.setMaiDianData(str2, str1);
    }


    private boolean a(JSONObjectProxy jsonObjectProxy, ShopFloorEntity paramShopFloorEntity)
    {
        boolean result = false;//v0
        //boolean v1 = false;
        //:cond_0 return false :cond_1 return v0
        if(jsonObjectProxy.length() != 0){
            try {
                JSONArrayProxy v3 = jsonObjectProxy.getJSONArrayOrNull("result");
                if (v3 != null && v3.length() > 0) {//if-eqz v3, :cond_6
                    ArrayList<GoodShopModel> v4 = GoodShopModel.toList(v3);
                    if (paramShopFloorEntity.isListEmpty(v4)) {//if-eqz v0, :cond_3
                        if (Log.D) {//if-eqz v0, :cond_6
                            Log.d("ShopFloorEngine", "on end list is null or empty");
                        }
                    } else {//:cond_3
                        try {
                            GoodShopModel entity = paramShopFloorEntity.getListLastItem(v4);
                            paramShopFloorEntity.setModelToJump(entity);
                            paramShopFloorEntity.removeListLastItem(v4);
                            String categories = GoodShopModel.getCategories(v3);
                            paramShopFloorEntity.setCatigoriesStr(categories);
                        } catch (Exception e) {//:catch_1

                        }

                        try {
                            paramShopFloorEntity.resetItemTmpList(v4);
                            a(new MallFloorEvent("1"));
                        } catch (Exception e) {//:catch_3

                        }
                        result = true;
                        //v1 = true;
                    }
                }

            }catch (Exception e){//catch_1
                if(Log.D)
                    e.printStackTrace();
            }finally {
                //:goto_4
                if(!result){// if-nez v2, :cond_1
                    try {
                        a(new MallFloorEvent("2", Boolean.valueOf(false)));
                    }catch (Exception e){//:catch_0
                        if(Log.E)
                            e.printStackTrace();
                    }
                }
            }


        }
        //:cond_1
        //:goto_0
        return result;
    }

    public final void a(boolean paramBoolean, JSONObjectProxy paramJSONObjectProxy, ShopFloorEntity paramListItemFloorEntity)
    {
        ////this.c.a(false);
        a(paramJSONObjectProxy, paramListItemFloorEntity);
    }

}
