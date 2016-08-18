package com.zy.app.mall.navigationbar;

import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.View;

import com.zy.app.mall.R;
import com.zy.common.database.table.NavigationBarTable;
import com.zy.common.entity.navigationbar.NavigationBar;
import com.zy.common.utils.CommonUtil;
import com.zy.common.utils.HttpGroup;
import com.zy.common.utils.Log;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

/**
 * Created by Robin on 2016/4/18.
 */
//Lcom/jingdong/app/mall/navigationbar/j;
public class NavigationOptHelper {

    private static NavigationOptHelper instance;//c;
    public static boolean b = false;
    private SharedPreferences sharedPreferences = CommonUtil.getJdSharedPreferences();  //d
    private List<NavigationButton> e;
    public int lastIndex = 0;   //a = 0;
    private int h = -1;
    private String j;
    private String k;

    public static  NavigationOptHelper getInstance()
    {
        if (instance == null){
            synchronized(NavigationOptHelper.class){
                if (instance == null){
                    instance =  new NavigationOptHelper();
                }
            }
        }
        return instance;
    }

    private static int a(String paramString)
    {
        if ("index".equals(paramString))
            return 0;
        if ("find".equals(paramString))
            return 2;
        if ("category".equals(paramString))
            return 1;
        if ("cart".equals(paramString))
            return 3;
        if ("home".equals(paramString))
            return 4;
        return -1;
    }

    public static int a(String paramString, boolean paramBoolean) {
        int result = R.drawable.main_bottom_tab_home_normal;    //2130840137
        if (paramBoolean) {
            if ("首页".equals(paramString))
                result = R.drawable.main_bottom_tab_home_normal;  //2130840137
            if ("分类".equals(paramString))
                result = R.drawable.main_bottom_tab_category_normal;  //2130840133
            if ("购物车".equals(paramString))
                result = R.drawable.main_bottom_tab_cart_normal;  //2130840131
            if ("发现".equals(paramString))
                result = R.drawable.main_bottom_tab_faxian_normal;  //2130840135
            if ("我的京东".equals(paramString))
                result = R.drawable.main_bottom_tab_personal_normal;  //2130840139
        } else {
            if ("首页".equals(paramString))
                result = R.drawable.main_bottom_tab_home_focus;  //2130840136
            if ("分类".equals(paramString))
                result = R.drawable.main_bottom_tab_category_focus;  //2130840132
            if ("购物车".equals(paramString))
                result = R.drawable.main_bottom_tab_cart_focus;  //2130840130
            if ("发现".equals(paramString))
                result = R.drawable.main_bottom_tab_faxian_focus;  //2130840134
            if ("我的京东".equals(paramString))
                result =  R.drawable.main_bottom_tab_personal_focus;  //2130840138
        }
        return result;
    }


    private List<NavigationButton> a(Context paramContext)
    {
        this.sharedPreferences.edit().putBoolean("display_defultNavigation", true).commit();
        ArrayList localArrayList = new ArrayList();
        localArrayList.add(new NavigationButton(paramContext, 0, "首页", R.drawable.main_bottom_tab_home_normal, R.drawable.main_bottom_tab_home_focus));    //2130840137, 2130840136
        localArrayList.add(new NavigationButton(paramContext, 1, "分类", R.drawable.main_bottom_tab_category_normal, R.drawable.main_bottom_tab_category_focus));    //2130840133, 2130840132
        localArrayList.add(new NavigationButton(paramContext, 2, "发现", R.drawable.main_bottom_tab_faxian_normal, R.drawable.main_bottom_tab_faxian_focus));    //2130840135, 2130840134
        localArrayList.add(new NavigationButton(paramContext, 3, "购物车", R.drawable.main_bottom_tab_cart_normal, R.drawable.main_bottom_tab_cart_focus));   // 2130840131, 2130840130
        localArrayList.add(new NavigationButton(paramContext, 4, "我的京东", R.drawable.main_bottom_tab_personal_normal, R.drawable.main_bottom_tab_personal_focus));  //2130840139, 2130840138
        return localArrayList;
    }

    private List<NavigationButton> a(Context paramContext, boolean paramBoolean) {
        List<NavigationBar> navigationBarList = NavigationBarTable.a(1, 0);
        if ((navigationBarList == null) || (((List) navigationBarList).size() <= 0)) {
            d();
            return null;
        }
        ArrayList localArrayList = new ArrayList();
        Iterator iterator = ((List) navigationBarList).iterator();
        int m = 0;
        NavigationBar localNavigationBar;
        //:goto_1
        while (((Iterator) iterator).hasNext()) {   //if-eqz v0, :cond_a
            localNavigationBar = (NavigationBar) ((Iterator) iterator).next();
            if ((TextUtils.isEmpty(localNavigationBar.getOffPath())) || (TextUtils.isEmpty(localNavigationBar.getOnPath())))  //if-nez v0, :cond_2
                m = 1;
            try {
                if (!new File(localNavigationBar.getOffPath()).exists() || !new File(localNavigationBar.getOnPath()).exists()) {//if-eqz v1, :cond_3
                    //:cond_3
                    m = 1;
                }//:cond_4
            } catch (Exception e) {
                if (Log.D)
                    e.printStackTrace();
                m = 1;
            }
            //:goto_3
            if (m != 0) {    // if-eqz v8, :cond_6
                d();
                return null;
            }// :cond_6

            NavigationButton navigationButton = new NavigationButton(paramContext, a(localNavigationBar.getFunctionId()), localNavigationBar.getNaviLabel(), localNavigationBar.getOffPath(), localNavigationBar.getOnPath(), localNavigationBar.getBigIconTag() == 1);
            if (!TextUtils.isEmpty(localNavigationBar.getmUrl())) {//if-nez v1, :cond_7
                ((NavigationButton) navigationButton).setUrl(localNavigationBar.getmUrl());
                ((NavigationButton) navigationButton).a(true);
            }
            if ((this.lastIndex == 0) && (localNavigationBar.getDefaultTag() == 1) && (!paramBoolean))
                this.lastIndex = a(localNavigationBar.getFunctionId());
            localArrayList.add(localNavigationBar.getNaviOrder().intValue(), navigationButton);
        }

        this.sharedPreferences.edit().putLong("display_version_Navigation", this.sharedPreferences.getLong("dataVersion_Navigation", 0L)).commit();
        return localArrayList;

    }

    //public final List<NavigationButton> a(Context paramContext, boolean paramBoolean, View paramView)
    public final List<NavigationButton> getNavigationButtonList(Context context, boolean paramBoolean, View navigationBg)
    {
        boolean isNaviBg = CommonUtil.sharedPreferences.getBoolean("share_navi_bg_both_Navigation", false);
        if (h())        //(currentTimeMillis >= endTimeNavigation) || (currentTimeMillis < startTimeNavigation);
        {
            this.e = a(context);
            if (navigationBg != null)
                navigationBg.setBackgroundDrawable(context.getResources().getDrawable(R.drawable.main_navigation_bg_5));   //2130840146
        }
        else{
            this.e = a(context, paramBoolean);
            if ((this.e == null) || (this.e.size() <= 0))
            {   //if-gtz v1, :cond_4
                this.e = a(context);
                if (isNaviBg)
                {   //if-eqz v0, :cond_3
                    if (navigationBg != null) {  //if-eqz p3, :cond_0
                        navigationBg.setBackgroundDrawable(context.getResources().getDrawable(R.drawable.main_navigation_bg_5));   //2130840146
                    }
                }else
                    setBackgroundDrawable(navigationBg, context);
            }else{  //:cond_4
                if ((isNaviBg) && (setBackgroundDrawable(navigationBg, context) == 0))
                    this.e = a(context);
            }

        }
        return this.e;
    }

    private int setBackgroundDrawable(View view, Context context)
    {
        Drawable drawable = getDrawable();
        if (drawable != null) {
            view.setBackgroundDrawable(drawable);
            return 1;
        }else {
            view.setBackgroundDrawable(context.getResources().getDrawable(R.drawable.main_navigation_bg_5));
            return 0;
        }
    }

    private Drawable getDrawable() {
        int m = 0;
        List<NavigationBar> navigationBarList = NavigationBarTable.a(1, 1);
        if ((navigationBarList == null) || (((List) navigationBarList).size() <= 0)) {
            d();
            return null;
        }
        NavigationBar navigationBar = (NavigationBar) ((List) navigationBarList).get(0);
        try {
            if (TextUtils.isEmpty(((NavigationBar) navigationBar).getOffPath()) || !new File(((NavigationBar) navigationBar).getOffPath()).exists()) {
                m = 1;
            }
        } catch (Exception localException) {
            if (Log.D)
                localException.printStackTrace();
            m = 1;
        }
        //:goto_1
        if (m != 0) {
            d();
            return null;
        } else
            return (Drawable) BitmapDrawable.createFromPath(((NavigationBar) navigationBar).getOffPath());
    }

    /**
     * 下载OnUrl和OffUrl
     * @return
     */
    public final synchronized int d() {
/*        List<NavigationBar> localList = NavigationBarTable.a(0, -1);
        if ((localList == null) || (localList.size() <= 0)) {
            this.sharedPreferences.edit().putLong("dataVersion_Navigation", 0L).commit();
            this.sharedPreferences.edit().putLong("display_version_Navigation", 0L).commit();
            return 0;
        }else {
            Iterator localIterator;

            if (this.g != null) {    //if-eqz v0, :cond_8
                localIterator = this.g.iterator();
                //:cond_2
                //:goto_1
                while (localIterator.hasNext()) {//if-eqz v0, :cond_3
                    HttpGroup.HttpRequest httpRequest = (HttpGroup.HttpRequest) localIterator.next();
                    if (!((HttpGroup.HttpRequest) httpRequest).isStop())
                        ((HttpGroup.HttpRequest) httpRequest).stop();
                }//:cond_3
                this.g.clear();
            }//:cond_8
            this.g = new ArrayList();
            localIterator = localList.iterator();
            // :cond_4
            //:goto_3
            while (localIterator.hasNext()) {   // if-eqz v0, :cond_9
                NavigationBar navigationBar = (NavigationBar) localIterator.next();
                try {
                    if ((!TextUtils.isEmpty(((NavigationBar) navigationBar).getOnUrl())) && ((TextUtils.isEmpty(((NavigationBar) navigationBar).getOnPath())) || (!new File(((NavigationBar) navigationBar).getOnPath()).exists())))
                        this.g.add(a(((NavigationBar) navigationBar).getId(), ((NavigationBar) navigationBar).getOnUrl(), "on_path", ((NavigationBar) navigationBar).getDataVersion() + "_" + a(((NavigationBar) navigationBar).getFunctionId(), 1)));
                    if ((!TextUtils.isEmpty(((NavigationBar) navigationBar).getOffUrl())) && ((TextUtils.isEmpty(((NavigationBar) navigationBar).getOffPath())) || (!new File(((NavigationBar) navigationBar).getOffPath()).exists())))
                        this.g.add(a(((NavigationBar) navigationBar).getId(), ((NavigationBar) navigationBar).getOffUrl(), "off_path", ((NavigationBar) navigationBar).getDataVersion() + "_" + a(((NavigationBar) navigationBar).getFunctionId(), 0)));
                } catch (Exception localException) {
                    localException.printStackTrace();
                }
            }//:cond_9
            return localList.size();
        }*/
        return 0;
    }

    public final void a(int paramInt)
    {
        this.h = paramInt;
    }

    public final int b()
    {
        return this.h;
    }

    private boolean h()
    {
        try
        {
            long startTimeNavigation = Long.parseLong(this.sharedPreferences.getString("start_time_Navigation", "0"));
            long endTimeNavigation = Long.parseLong(this.sharedPreferences.getString("end_time_Navigation", "0"));
            long currentTimeMillis = System.currentTimeMillis();
            if (Log.D)
            {
                SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                Log.d("Navigation", dateFormat.format(new Date(startTimeNavigation)));
                Log.d("Navigation", dateFormat.format(new Date(endTimeNavigation)));
            }
            return (currentTimeMillis >= endTimeNavigation) || (currentTimeMillis < startTimeNavigation);
        }
        catch (Throwable e)
        {
        }
        return true;
    }

    public synchronized void e() {
        if (Log.D) {
            Log.d("Navigation", "request navigation ");
        }
        /*if (!this.f) {//if-eqz v0, :cond_1
            this.f = true;
            final long v0 = CommonUtil.getJdSharedPreferences().getLong("dataVersion_Navigation", 0l);
            HttpGroup.HttpSetting v2 = HttpGroup.HttpSetting();
            v2.setFunctionId("navigation");
            v2.setCacheMode(2);
            v2.setAttempts(2);
            v2.putJsonParam("dataVersion", v0);
            v2.setHost(Configuration.getPersonalHomeHost());
            v2.setListener(new HttpGroup.OnCommonListener() {
                @Override
                public final void onEnd(HttpGroup.HttpResponse paramHttpResponse) {
                    JSONObjectProxy v4 = paramHttpResponse.getJSONObject();
                    if (Log.D) {
                        Log.d("Navigation", "--------navi---http------" + v4.toString());
                    }
                    if (v4 != null) { //if-eqz v4, :cond_8
                        String v2 = v4.optString("code");
                        if (!"0".equals(v2)) {    //if-nez v2, :cond_1
                            long v6 = v4.optLong("dataVersion");
                            NavigationOptHelper.this.i = v6;
                            if (v6 == v0) {//if-nez v2, :cond_2
                                //:cond_2
                                NavigationOptHelper.this.j = String.valueOf(v4.getLong("startDate"));
                                NavigationOptHelper.this.k = String.valueOf(v4.getLong("endDate"));
                                v10 = v4.optString("defaultFunction");
                                List v5 = JDJSON.parseArray(v4.getJSONArrayOrNull("bgImage").toString(), NavigationBar.class);
                                NavigationBar nv2 = null;
                                if (v5 != null && v5.size() > 0) {//if-eqz v5, :cond_a
                                    nv2 = (NavigationBar) v5.get(0);
                                    nv2.setIconType(1);
                                    nv2.setDataVersion(String.valueOf(v6));
                                }
                                //:goto_1
                                JSONArrayPoxy v11 = v4.getJSONArrayOrNull("navigationconfig");
                                if (v11 != null && v11.length() > 0) {//if-lez v2, :cond_8
                                    ArrayList v12 = new ArrayList();
                                    boolean b2 = false;
                                    //goto_2
                                    for (int i = 0; i < v11.length(); i++) {//if-ge v4, v3, :cond_5
                                        NavigationBar v13 = new NavigationBar();
                                        JSONObjectProxy v3 = v11.getJSONObjectOrNull(i);
                                        //:goto_3
                                        try {
                                            String functionId = v3.optString("functionId");
                                            int sort = 0;
                                            try {
                                                Integer.valueOf(v3.optString("sort"));
                                            } catch (Throwable e) {
                                            }
                                            v13.setNaviOrder(sort - 1);
                                            v13.setNaviLabel(v3.optString("lableName"));
                                            v13.setFunctionId(functionId);
                                            v13.setOnUrl(v3.optString("optlableImage"));
                                            v13.setOffUrl(v3.optString("lableImage"));
                                            v13.setmUrl(v3.optString("murl"));
                                            v13.setDisplayTag(0);
                                            v13.setStartTime(NavigationOptHelper.this.j);
                                            v13.setEndTime(NavigationOptHelper.this.k);
                                            v13.setBigIconTag(v3.optInt("displayType"));
                                            v13.setIconType(0);
                                            v13.setDataVersion(String.valueOf(v6));
                                            if (v10.equals(functionId)) { //if-eqz v3, :cond_3
                                                b2 = true;
                                                v13.setDefaultTag(1);
                                            } else {//:cond_3
                                                v13.setDefaultTag(0);
                                            }
                                            // :goto_4
                                            v12.add(v13);
                                        } catch (Exception e) {
                                            if (Log.D) {
                                                e.printStackTrace();
                                            }
                                            NavigationOptHelper.this.f = false;
                                            return;
                                        }
                                    }//cond_5
                                    if (b2) { //if-nez v2, :cond_6
                                        b2 = false;
                                        NavigationBar vv2 = (NavigationBar) v12.get(0);
                                        vv2.setDefaultTag(1);
                                    }//:cond_6
                                    if (nv2 != null) {  //if-eqz v5, :cond_7
                                        v12.add(nv2);
                                    }//:cond_7
                                    if (NavigationBarTable.a(v12)) {  //if-eqz v2, :cond_8
                                        SharedPreferences.Editor edit = NavigationOptHelper.this.sharedPreferences.edit();
                                        if (v12.size() >= 6) {    //if-lt v3, v4, :cond_9
                                            edit.putBoolean("share_navi_bg_both_Navigation", 6);
                                        } else {
                                            edit.putBoolean("share_navi_bg_both_Navigation", 0);
                                        }
                                        //:goto_5
                                        edit.putLong("dataVersion_Navigation", v6);
                                        edit.putLong("start_time_Navigation", NavigationOptHelper.this.j);
                                        edit.putLong("end_time_Navigation", NavigationOptHelper.this.k);
                                        edit.commit();
                                        NavigationOptHelper.this.d();
                                    }
                                }//:cond_8
                            }
                        }
                    }
                    NavigationOptHelper.this.f = false;
                }

                @Override
                public final void onError(HttpGroup.HttpError paramHttpError){
                    NavigationOptHelper.this.f = false;
                    if (Log.D)
                        Log.d("Navigation", "-----error---navi---http------" + paramHttpError.toString());
                }

                @Override
                public final void onReady(HttpGroup.HttpSettingParams paramHttpSettingParams){

                }
            });
            HttpGroupUtils.getHttpGroupaAsynPool(v2);
        }*/
        return;
    }
}
