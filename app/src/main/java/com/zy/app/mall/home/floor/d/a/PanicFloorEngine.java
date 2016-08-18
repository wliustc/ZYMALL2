package com.zy.app.mall.home.floor.d.a;

import android.text.TextUtils;

import com.jingdong.app.mall.utils.CommonUtil;
import com.jingdong.common.config.Configuration;
import com.jingdong.common.entity.Product;
import com.jingdong.common.utils.ExceptionReporter;
import com.jingdong.common.utils.JSONObjectProxy;
import com.zy.app.mall.home.floor.a.a.MallFloorEvent;
import com.zy.app.mall.home.floor.d.a.ListItemFloorEngine;
import com.zy.app.mall.home.floor.model.entity.ListItemFloorEntity;
import com.zy.app.mall.home.floor.model.entity.PanicFloorEntity;
import com.zy.common.utils.HttpGroup;
import com.zy.common.utils.JSONArrayProxy;
import com.zy.common.utils.Log;

import java.util.ArrayList;

/**
 * Created by Robin on 2016/6/22.
 */
//h
public class PanicFloorEngine<E extends PanicFloorEntity> extends ListItemFloorEngine<PanicFloorEntity> {
    private boolean c = false;
    private String d;

    public final void a(final boolean paramBoolean, final PanicFloorEntity paramPanicFloorEntity) {
        int i = 1;
        if (this.c)
            return;
        this.c = true;
        ExceptionReporter localExceptionReporter = new ExceptionReporter();
        //paramPanicFloorEntity = new i(this, paramBoolean, paramPanicFloorEntity);
        HttpGroup.HttpSetting localHttpSetting = new HttpGroup.HttpSetting();
        if (!TextUtils.isEmpty(this.d)) //if-nez v5, :cond_2
            localHttpSetting.setFunctionId(this.d);
        else
            localHttpSetting.setFunctionId("indexMiaoShaArea");
        localHttpSetting.setHost(Configuration.getPortalHost());
        if (!paramBoolean)
            i = 0;

        localHttpSetting.putJsonParam("isAdvance", Integer.valueOf(i));
        localHttpSetting.setEffect(0);
        CommonUtil.handleHomeConnectReadTimeByNetType(localHttpSetting);
        localHttpSetting.setNotifyUser(false);
        localHttpSetting.setListener(new HttpGroup.CustomOnAllListener(){//new i(this, paramBoolean, paramPanicFloorEntity);
            @Override
            public void onStart() {

            }

            @Override
            public void onProgress(int paramInt1, int paramInt2) {

            }

            @Override
            public void onError(HttpGroup.HttpError paramHttpError) {
                if (Log.D)
                    Log.d("PanicFloorEngine", " -->> onError getPanicBuyingList()");
                PanicFloorEngine.this.c = false;
                PanicFloorEngine.this.a(new MallFloorEvent("2", Boolean.valueOf(false)));
            }

            @Override
            public void onEnd(HttpGroup.HttpResponse paramHttpResponse) {
                if (Log.D)
                    Log.d("PanicFloorEngine", " -->> onEnd getPanicBuyingList()");
                PanicFloorEngine.this.c = false;
                if (paramBoolean)
                    paramPanicFloorEntity.setNextRoundObject(paramHttpResponse.getJSONObject());
                else
                    PanicFloorEngine.this.a(paramHttpResponse.getJSONObject(), paramPanicFloorEntity);
            }
        });
        if (this.b != null)
            this.b.add(localHttpSetting);
        localExceptionReporter.attachHttpSetting(localHttpSetting);
        return;

    }

    public final boolean a(JSONObjectProxy paramJSONObjectProxy, PanicFloorEntity paramPanicFloorEntity)
    {
        boolean v0 = false;
        if(paramPanicFloorEntity!=null) {

            JSONArrayProxy v1 = null;
            String v2 = null;
            paramPanicFloorEntity.setBuyTimeTimeMillis(System.currentTimeMillis());
            if (paramJSONObjectProxy != null && paramJSONObjectProxy.length() != 0) {
                try {
                    this.d = paramJSONObjectProxy.optString("functionId");
                    v1 = paramJSONObjectProxy.getJSONArrayOrNull("indexMiaoSha");
                    paramPanicFloorEntity.setMiaoshaAdvance(Integer.parseInt(paramJSONObjectProxy.optString("miaoshaAdvance", "0")));
                    paramPanicFloorEntity.setNextRoundKey(paramJSONObjectProxy.getStringOrNull("nextRoundKey"));
                    v2 = paramJSONObjectProxy.getStringOrNull("scheme");
                } catch (Exception e) {//:catch_0
                    if (Log.E)
                        e.printStackTrace();
                }
                try {
                    paramPanicFloorEntity.setBuyTimeTimeRemain(paramJSONObjectProxy.getLongOrNull("timeRemain"));
                } catch (Exception e) {//:catch_1

                }
                //:goto_1
                try {
                    paramPanicFloorEntity.setNameText(paramJSONObjectProxy.optString("name", ""));
                    if (!TextUtils.isEmpty(v2)) {
                        paramPanicFloorEntity.setIsTestA(v2.equals("A"));
                    }
                    ArrayList<Product> list = Product.toList(v1, 0x11);
                    if (list == null || list.size() < 4) {//if-eqz v1, :cond_3
                        this.a(new MallFloorEvent("2", Boolean.valueOf(false)));
                    } else {//:cond_4
                        try {
                            if (Log.D)
                                Log.d("PanicFloorEngine", " -->>scheme = " + v2 + " isTestA = " + paramPanicFloorEntity.isTestA() + " productList size = " + list.size());
                            paramPanicFloorEntity.resetItemTmpList(list);
                            this.a(new MallFloorEvent("1"));
                            return true;
                        } catch (Exception e) {//:catch_0
                            if (Log.E)
                                e.printStackTrace();
                        }
                    }
                } catch (Exception e) {//:catch_0
                    if (Log.E)
                        e.printStackTrace();
                }

            }
        }
        return v0;
    }

    @Override
    public void a(boolean paramBoolean, JSONObjectProxy paramJSONObjectProxy, PanicFloorEntity entity) {
        if ((entity != null) && (!a(paramJSONObjectProxy, entity)))
            a(false, entity);
    }

}
