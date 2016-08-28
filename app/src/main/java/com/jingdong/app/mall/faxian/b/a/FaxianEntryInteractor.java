package com.jingdong.app.mall.faxian.b.a;

import android.content.SharedPreferences;

import com.jingdong.app.mall.utils.CommonUtil;
import com.jingdong.common.config.Configuration;
import com.zy.app.mall.navigationbar.NavigationButton;
import com.zy.cleanmvp.presenter.BaseInteractor;
import com.zy.common.utils.Log;

import org.greenrobot.eventbus.EventBus;
import org.json.JSONArray;
import org.json.JSONException;

import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by Robin on 2016/5/19.
 */
//f
public class FaxianEntryInteractor  extends BaseInteractor {
    private static FaxianEntryInteractor instance;
    public static FaxianEntryInteractor getInstance() {
        if(instance == null){
            synchronized (FaxianEntryInteractor.class){
                if(instance == null){
                    instance = new FaxianEntryInteractor();
                }
            }
        }
        return instance;
    }

    @Override
    public final void cancleIO() {

    }

    @Override
    public final void clearState(int paramInt) {

    }

    public void a(boolean b) {
        if (Log.D)
            Log.d("FaxianInteractor", "loadRedDot in");
//        HttpGroup.HttpSetting localHttpSetting = new HttpGroup.HttpSetting();
//        localHttpSetting.setFunctionId("jdDiscoveryNotify");
//        localHttpSetting.setHost(Configuration.getPortalHost());
//        localHttpSetting.setPost(true);
//        localHttpSetting.setEffect(0);
//        localHttpSetting.setListener(new HttpGroup.OnCommonListener(){//g(this, paramBoolean)
//            @Override
//            public void onReady(HttpGroup.HttpSettingParams paramHttpSettingParams) {
//                f.a(this.b, paramHttpSettingParams);
//                ConcurrentHashMap localConcurrentHashMap = this.b.b();
//                if (Log.D)
//                    Log.d("FaxianInteractor", " loadRedDot request param -->> " + localConcurrentHashMap.toString());
//                try
//                {
//                    paramHttpSettingParams.putJsonParam("channels", new JSONArray((String)localConcurrentHashMap.get("channels")));
//                    paramHttpSettingParams.putJsonParam("applogin", localConcurrentHashMap.get("applogin"));
//                    paramHttpSettingParams.putJsonParam("uuid", localConcurrentHashMap.get("uuid"));
//                    gp.b();
//                    paramHttpSettingParams.putJsonParam("wskey", jd.wjlogin_sdk.a.d.d());
//                    if (this.a)
//                        paramHttpSettingParams.putJsonParam("discoverytime", Long.valueOf(CommonUtil.getJdSharedPreferences().getLong("FAXIAN_LAST_UPDATE_TIME", 0L)));
//                    return;
//                }
//                catch (JSONException localJSONException)
//                {
//                    while (true)
//                        localJSONException.printStackTrace();
//                }
//            }
//
//            @Override
//            public void onError(HttpGroup.HttpError paramHttpError) {
//
//            }
//
//            @Override
//            public void onEnd(HttpGroup.HttpResponse paramHttpResponse) {
//                if (Log.D)
//                    Log.d("FaxianInteractor", " jdDiscoveryNotify -->> onEnd ");
//                paramHttpResponse = paramHttpResponse.getJSONObject();
//                if (paramHttpResponse == null)
//                    return;
//                SharedPreferences localSharedPreferences = CommonUtil.getJdSharedPreferences();
//                JSONObjectProxy localJSONObjectProxy = paramHttpResponse.getJSONObjectOrNull("poz");
//                if (localJSONObjectProxy != null)
//                    localSharedPreferences.edit().putString("FAXIAN_POZ", localJSONObjectProxy.toString()).commit();
//                if (this.a)
//                {
//                    this.b.a(paramHttpResponse, null, true);
//                    return;
//                }
//                EventBus.getDefault().post(new com.jingdong.app.mall.faxian.a.a.d("FAXIAN_REFRESH_RED_DOT", paramHttpResponse));
//            }
//        });
//        HttpGroupUtils.getHttpGroupaAsynPool().add(localHttpSetting);
    }
}
