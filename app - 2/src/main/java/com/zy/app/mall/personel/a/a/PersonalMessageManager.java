package com.zy.app.mall.personel.a.a;

import android.text.TextUtils;

import com.zy.common.utils.CommonUtil;
import com.zy.common.utils.HttpGroup;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/**
 * Created by Robin on 2016/5/9.
 */
//public class b
public class PersonalMessageManager {
    private static List<WeakReference<PersonalMessageObserver>> a;
    private static String b;
    private static volatile PersonalMessageManager instance;    //c
    private static Map<String, PersonalMessageChannel> d;
    private static JSONObject e;

    private PersonalMessageManager(String paramString)
    {
        a = new ArrayList();
        d = new HashMap();
        b = paramString;
    }

    public  static PersonalMessageManager getInstance(String paramString)
    {
        if (instance == null)
            synchronized(PersonalMessageManager.class){
                if (instance == null){
                    String str = "";
                    if (paramString != null)
                        str = paramString;
                    instance = new PersonalMessageManager(str);

                }
            }
        b = paramString;
        c(paramString);
        return instance;
    }

    public static void a()
    {
                synchronized (a)
                {
                    Iterator localIterator = a.iterator();
                    while (localIterator.hasNext()) {
                        PersonalMessageObserver locale = (PersonalMessageObserver)((WeakReference)localIterator.next()).get();
                        if (locale != null)
                            locale.onPersonalMessageReceived(d);
                        else
                            localIterator.remove();
                    }
                }
    }

    public static void a(PersonalMessageObserver parame)
    {
        if (parame == null)
            throw new NullPointerException("observer is null");
        synchronized (a)
        {
            Iterator localIterator = a.iterator();
            while (localIterator.hasNext())
                if ((PersonalMessageObserver)((WeakReference)localIterator.next()).get() == parame)
                    return;
            a.add(new WeakReference(parame));
            return;
        }
    }

    public static void a(HttpGroup paramHttpGroup)
    {
        HttpGroup.HttpSetting localHttpSetting = new HttpGroup.HttpSetting();
        localHttpSetting.setHost(HostConfig.getInstance().getHost(HostConstants.PERSONAL_HOME_HOST));
        localHttpSetting.setFunctionId("redpoint");
        localHttpSetting.setEffect(0);
        localHttpSetting.setCacheMode(2);
        localHttpSetting.setListener(new HttpGroup.OnCommonListener(){//c(true)
            @Override
            public void onReady(HttpGroup.HttpSettingParams paramHttpSettingParams) {
                if (PersonalMessageManager.e == null)
                    PersonalMessageManager.c(PersonalMessageManager.b);
                paramHttpSettingParams.putJsonParam("channels", PersonalMessageManager.e);
            }

            @Override
            public void onError(HttpGroup.HttpError paramHttpError) {

            }

            @Override
            public void onEnd(HttpGroup.HttpResponse paramHttpResponse) {
                JSONObjectProxy v0 = paramHttpResponse.getJSONObject();
                if (v0 != null)
                {
                    PersonalMessageManager.synthetic_a(v0);
                    if (true)
                        PersonalMessageManager.a();
                }
            }
        });
        paramHttpGroup.add(localHttpSetting);
    }

    private static void synthetic_a(JSONObject paramJSONObject) {
        JSONArray channels = paramJSONObject.optJSONArray("channels");
        d.clear();
        if ((channels != null) && (channels.length() > 0)) {

            for (int i = 0; i < channels.length(); i++) {
                JSONObject object = channels.optJSONObject(i);
                if (object != null) {
                    PersonalMessageChannel channel = new PersonalMessageChannel();
                    channel.channel = object.optString("channel");
                    channel.style = object.optInt("style");
                    channel.redDot = object.optInt("redDot");
                    channel.lastReadNotice = object.optLong("lastReadNotice");
                    channel.num = object.optInt("num");
                    d.put(channel.channel, channel);
                }

            }
        }
    }

    public static void a(final String paramString, long paramLong, HttpGroup paramHttpGroup)
    {
        try
        {
            if (e == null)
                e = new JSONObject();
            e.put(paramString, paramLong);
            d(e);
            if (paramHttpGroup != null){
                HttpGroup.HttpSetting httpSetting = new HttpGroup.HttpSetting();
                httpSetting.setHost(HostConfig.getInstance().getHost(HostConstants.MSG_CENTER_HOST));
                httpSetting.setFunctionId("getTimeStamp");
                httpSetting.setListener(new HttpGroup.OnCommonListener(){//d(paramString)
                    @Override
                    public void onReady(HttpGroup.HttpSettingParams paramHttpSettingParams) {

                    }

                    @Override
                    public void onError(HttpGroup.HttpError paramHttpError) {

                    }

                    @Override
                    public void onEnd(HttpGroup.HttpResponse paramHttpResponse) {
                        JSONObjectProxy jsonObjectProxy = paramHttpResponse.getJSONObject();
                        long l = 0;
                        if ((jsonObjectProxy != null) && (jsonObjectProxy.optInt("code", -1) == 0) && (l = jsonObjectProxy.optLong("timeStamp")) > 0L){   //if-lez v2, :cond_1
                            try
                            {
                                if (PersonalMessageManager.e == null)
                                    PersonalMessageManager.e = new JSONObject();
                                PersonalMessageManager.e.put(paramString, l);
                                PersonalMessageManager.d(PersonalMessageManager.e);

                            }
                            catch (JSONException e)
                            {
                                e.printStackTrace();
                            }
                        }
                        return;
                    }
                });
                paramHttpGroup.add(httpSetting);
            }
        }
        catch (JSONException e)
        {
                e.printStackTrace();

        }
        return;
    }

    public static void b(PersonalMessageObserver parame)
    {
        if (parame == null)
            throw new NullPointerException("observer is null");
        synchronized (a)
        {
            Iterator iterator = a.iterator();
            while (iterator.hasNext())
            {
                PersonalMessageObserver locale = (PersonalMessageObserver)((WeakReference)iterator.next()).get();
                if ((locale == null) || (locale == parame))
                    iterator.remove();
            }
        }
    }

    private static void c(String paramString) {
        paramString = CommonUtil.getJdSharedPreferences().getString("redPointParams_" + paramString, "");
        if (TextUtils.isEmpty(paramString)) {
            try {
                e = new JSONObject();
                e.put("message", 0);
                d(e);
            } catch (JSONException e) {
                e = null;
                e.printStackTrace();
            }
        } else {
            try {
                e = new JSONObject(paramString);
            } catch (JSONException e) {
                e = null;
                e.printStackTrace();
            }
        }
        if (e == null)
            e = new JSONObject();
        return;
    }

    private static void d(JSONObject paramJSONObject)
    {
        if (paramJSONObject == null)
            return;
        CommonUtil.getJdSharedPreferences().edit().putString("redPointParams_" + b, paramJSONObject.toString()).apply();
    }
}
