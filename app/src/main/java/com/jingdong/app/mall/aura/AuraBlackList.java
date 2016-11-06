package com.jingdong.app.mall.aura;

import com.jingdong.common.BaseApplication;
import com.jingdong.common.config.Configuration;
import com.jingdong.common.utils.HttpGroup;
import com.zy.common.frame.IMyActivity;
import com.zy.common.utils.Log;

import java.util.Set;

/**
 * Created by Robin on 2016/11/6.
 */
//a
public class AuraBlackList {
    private static com.jingdong.app.mall.aura.internal.a a = new com.jingdong.app.mall.aura.internal.a();

    static Set<String> a()
    {
        return com.zy.common.utils.CommonUtil.getJdSharedPreferences().getStringSet("add", null);
    }

    public static void a(IMyActivity paramIMyActivity, boolean paramBoolean)
    {
        if (paramIMyActivity != null){
            if (a.a()) {
                HttpGroup.HttpSetting localHttpSetting = new HttpGroup.HttpSetting();
                localHttpSetting.setFunctionId("kvConfig");
                localHttpSetting.setHost(Configuration.getNgwHost());
                localHttpSetting.setEffect(0);
                localHttpSetting.setNotifyUser(false);
                localHttpSetting.putJsonParam("type", "auraBlackList");
                localHttpSetting.putJsonParam("buildId", com.jingdong.app.mall.utils.CommonUtil.getSoftwareVersionCode(BaseApplication.getInstance().getBaseContext()));
                localHttpSetting.setListener(new HttpGroup.OnAllListener(){//b()
                    @Override
                    public void onStart() {

                    }

                    @Override
                    public void onProgress(int paramInt1, int paramInt2) {

                    }

                    @Override
                    public void onError(HttpGroup.HttpError paramHttpError) {
                        Log.v("AuraBlackListOfNetwork", "onError = " + paramHttpError.toString());
                    }

                    @Override
                    public void onEnd(HttpGroup.HttpResponse paramHttpResponse) {
                        paramHttpResponse = paramHttpResponse.getJSONObject();
                        if (paramHttpResponse == null);
                        while (true)
                        {
                            return;
                            Log.v("AuraBlackListOfNetwork", paramHttpResponse.toString());
                            if (!paramHttpResponse.optString("code").equals("0"))
                                continue;
                            paramHttpResponse = paramHttpResponse.getJSONObjectOrNull("configs");
                            if (paramHttpResponse == null)
                                continue;
                            Iterator localIterator = paramHttpResponse.keys();
                            while (localIterator.hasNext())
                            {
                                String str = (String)localIterator.next();
                                if ((str == null) || ((!"add".equals(str)) && (!"minus".equals(str))))
                                    continue;
                                try
                                {
                                    HashSet localHashSet = new HashSet();
                                    JSONArray localJSONArray = paramHttpResponse.optJSONArray(str);
                                    int i = 0;
                                    while (i < localJSONArray.length())
                                    {
                                        localHashSet.add(localJSONArray.getString(i));
                                        i += 1;
                                    }
                                    a.a(str, localHashSet);
                                }
                                catch (Exception localException)
                                {
                                }
                            }
                        }
                    }
                });
                paramIMyActivity.getHttpGroupaAsynPool().add(localHttpSetting);
            }
        }else
            Log.v("AuraBlackListOfNetwork", "activity is null");
        do
            return;

    }

    static Set<String> b()
    {
        return com.zy.common.utils.CommonUtil.getJdSharedPreferences().getStringSet("minus", null);
    }
}
