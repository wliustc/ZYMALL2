package com.zy.app.mall.home;

import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;

import com.jingdong.app.mall.home.LayerFrameLayout;
import com.jingdong.common.BaseActivity;
import com.zy.common.entity.HomeLayerParamEntity;
import com.zy.common.utils.CommonUtil;
import com.zy.common.utils.Log;

/**
 * Created by Robin on 2016/5/17.
 */
//au
public class JdLayerUtil {
    public static final String TAG = JdLayerUtil.class.getSimpleName();
    private static LayerFrameLayout b;
    private static boolean c = false;

    public static void a()
    {
        LayerFrameLayout.isHomeTabNow = true;
        if (b != null)
            b.onResume();
    }

    public static void a(final BaseActivity paramBaseActivity, final HomeLayerParamEntity paramHomeLayerParamEntity)
    {
        Log.d(TAG, "LAYER:" + b);
        if ((paramHomeLayerParamEntity != null) && (paramHomeLayerParamEntity.getCount() > 0) && (!TextUtils.isEmpty(paramHomeLayerParamEntity.getUrl()))){
            if (!c){
                c = true;
                paramBaseActivity.post(new Runnable(){//av(paramHomeLayerParamEntity, paramBaseActivity)
                    @Override
                    public void run() {
                        Log.d(TAG, "openLayer-->" + paramHomeLayerParamEntity.getUrl() + "  count:" + paramHomeLayerParamEntity.getCount());
                        int i = CommonUtil.getIntFromPreference(paramHomeLayerParamEntity.getUrl(), -1);
                        Log.d(TAG, paramHomeLayerParamEntity.getUrl() + "    remain time:" + i);
                        if (i == -1)
                            CommonUtil.putIntToPreference(paramHomeLayerParamEntity.getUrl(), paramHomeLayerParamEntity.getCount());
                        final View localObject = ((ViewGroup)paramBaseActivity.findViewById(16908290)).getChildAt(0);//16908290
                        if ((localObject instanceof ViewGroup))
                        {
                            JdLayerUtil.b = new LayerFrameLayout(paramBaseActivity);
                            ViewGroup.LayoutParams localLayoutParams = new ViewGroup.LayoutParams(-1, -1);
                            ((ViewGroup)localObject).addView(JdLayerUtil.b, localLayoutParams);
                            JdLayerUtil.b.setStateChangeListener(new LayerFrameLayout.LayerStateChangeListener(){//aw(this, (ViewGroup)localObject)
                                @Override
                                public void onRemove() {
                                    Log.d(TAG, "onRemove");
                                    ((ViewGroup)localObject).removeView(JdLayerUtil.b);
                                    JdLayerUtil.b = null;
                                }

                                @Override
                                public void onShow() {
                                    Log.d(TAG, "onShow");
                                }
                            });
                        }
                        JdLayerUtil.b.showLayer(paramHomeLayerParamEntity);
                        JdLayerUtil.c = false;
                    }
                }, 2000);
            }
        }
            return;
    }

    public static void b()
    {
        LayerFrameLayout.isHomeTabNow = false;
        if (b != null)
            b.onPause();
    }
}
