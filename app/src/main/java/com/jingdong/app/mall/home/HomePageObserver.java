package com.jingdong.app.mall.home;

import android.content.Context;

import com.jingdong.common.utils.JSONObjectProxy;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by Robin on 2016/5/8.
 */
//.class public Lcom/jingdong/app/mall/home/x;
public class HomePageObserver {
    public static boolean a = false;
    private static HomePageObserver instance;//b
    //private HttpGroupWithNPS i;
    private Context j;
    private _Z d;

    //a
    public static HomePageObserver getInstance(Context context) {
        if(instance==null){
            synchronized (HomePageObserver.class){
                if(instance==null){
                    instance = new HomePageObserver();
                    if(context !=null && instance.j == null)
                        instance.j=context.getApplicationContext();
                }
            }
            //instance.i = new HttpGroupWithNPS(instance.j, instance.d(), JDHomeFragment.class.getSimpleName(), "", false);
        }
        return instance;
    }

    public void a() {
        JSONObjectProxy jsonObject = null;
        try {
            jsonObject = new JSONObjectProxy(new JSONObject(this.d.getJsonString()));
        } catch (JSONException e) {
            e.printStackTrace();
            return;
        }
        this.d.a(jsonObject);
    }


    public final void a(_Z paramz)
    {
        this.d = paramz;
    }

    public void b() {

    }

    public abstract interface _Z
    {
        public void a();

        //public void a(HttpGroup.HttpResponse paramHttpResponse);
        public void a(JSONObjectProxy jsonObject);

        public void b();

        public String getJsonString();
    }
}
