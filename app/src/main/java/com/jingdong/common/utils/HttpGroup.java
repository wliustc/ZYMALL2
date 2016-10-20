package com.jingdong.common.utils;

import android.view.ViewGroup;

import com.jingdong.common.utils.JSONObjectProxy;
import com.jingdong.common.utils.ListViewNextPageLoader;
import com.jingdong.common.utils.URLParamMap;
import com.zy.common.frame.IDestroyListener;
import com.zy.common.frame.IMyActivity;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.Map;

/**
 * Created by Robin on 2016/4/14.
 */
public abstract class HttpGroup implements IDestroyListener {

    public static String getCookie() {
        return null;
    }

    public HttpRequest add(HttpSetting localHttpSetting) {
        return new HttpRequest();
    }

    public static HttpGroup getHttpGroup(HttpGroupSetting localObject) {
        return null;
    }

    public static String mergerUrlAndParams(String url, Map paramURLParamMap) {
        throw new RuntimeException("Not Found mergerUrlAndParams(String url, URLParamMap paramURLParamMap)");
    }

    public interface StopController {
        public abstract boolean isStop();

        public abstract void stop();
    }

    public interface HttpTaskListener
    {
    }

    public interface OnEndListener extends HttpGroup.HttpTaskListener
    {
        public abstract void onEnd(HttpGroup.HttpResponse paramHttpResponse);
    }

    public interface OnErrorListener extends HttpGroup.HttpTaskListener
    {
        public abstract void onError(HttpGroup.HttpError paramHttpError);
    }

    public interface OnReadyListener extends HttpGroup.HttpTaskListener
    {
        public abstract void onReady(HttpGroup.HttpSettingParams paramHttpSettingParams);
    }

    public interface OnCommonListener extends HttpGroup.OnEndListener, HttpGroup.OnErrorListener, HttpGroup.OnReadyListener
    {
    }

    public interface OnProgressListener extends HttpGroup.HttpTaskListener{
        public abstract void onProgress(int paramInt1, int paramInt2);

    }

    interface OnStartListener extends HttpGroup.HttpTaskListener{
        public abstract void onStart();
    }
    public interface OnAllListener extends HttpGroup.OnEndListener, HttpGroup.OnErrorListener, HttpGroup.OnProgressListener, HttpGroup.OnStartListener{

    }

    public  interface CustomOnAllListener extends HttpGroup.OnAllListener
    {
    }

    public interface OnCancelListener extends HttpGroup.HttpTaskListener
    {
        public void onCancel();
    }

    public interface OnPauseListener extends HttpGroup.HttpTaskListener
    {
        public void onPause();
    }

    public class HttpRequest implements HttpGroup.StopController{
        @Override
        public boolean isStop() {
            return false;
        }

        @Override
        public void stop() {

        }
    }
    public class HttpResponse {
        private Map moreParams;
        private org.json.JSONObject JSONObject;
        private JSONObjectProxy jSONObjectProxy;

        public Map getMoreParams() {
            return moreParams;
        }



        public JSONObjectProxy getJSONObject() {
            return jSONObjectProxy;
        }
        public JSONObjectProxy getJSONObjectProxy() {
            return jSONObjectProxy;
        }
    }

    public class HttpError {
    }

    public class HttpSettingParams {
        public void putJsonParam(String action, String paramString) {

        }
    }

    public static class HttpSetting {
        public static final int CACHE_MODE_ASSETS = 3;
        public static final int CACHE_MODE_AUTO = 0;
        public static final int CACHE_MODE_BOTH = 4;
        public static final int CACHE_MODE_ONLY_CACHE = 1;
        public static final int CACHE_MODE_ONLY_NET = 2;
        public static final int EFFECT_DEFAULT = 1;
        public static final int EFFECT_NO = 0;
        public static final int EFFECT_STATE_NO = 0;
        public static final int EFFECT_STATE_YES = 1;
        public static final int ERROR_DIALOG_TYPE_BACK_RETRY = 2;
        public static final int ERROR_DIALOG_TYPE_DEFAULT = 0;
        public static final int ERROR_DIALOG_TYPE_ONLY_CANCEL = 1;
        public static final int ERROR_DIALOG_TYPE_SETUP_CANCEL = 3;
        private String functionId;
        private JSONObject jsonParams;
        private ListViewNextPageLoader listener;
        private Map moreParams;
        private boolean notifyUser;
        private String host;
        private boolean post;
        private int effect;
        private boolean localFileCache;
        private long localFileCacheTime;
        private String url;
        private int bussinessId = -1;
        private int cacheMode = 0;
        private long connectTimeout;
        private long readTimeout;
        private OnErrorListener onErrorListener;
        private OnStartListener onStartListener;
        private OnCancelListener onCancelListener;
        private OnProgressListener onProgressListener;
        private OnEndListener onEndListener;
        private OnReadyListener onReadyListener;
        private OnPauseListener onPauseListener;
        private boolean useCookies;
        private int attempts;

        public void setFunctionId(String functionId) {
            this.functionId = functionId;
        }

        public void setJsonParams(JSONObject jsonParams) {
            this.jsonParams = jsonParams;
        }

        public void setListener(HttpGroup.HttpTaskListener paramHttpTaskListener) {
            if ((paramHttpTaskListener instanceof HttpGroup.CustomOnAllListener))
                setEffect(0);
//            if ((paramHttpTaskListener instanceof ba))
//                setEffectState(1);
            if ((paramHttpTaskListener instanceof HttpGroup.OnErrorListener))
                this.onErrorListener = ((HttpGroup.OnErrorListener)paramHttpTaskListener);
            if ((paramHttpTaskListener instanceof HttpGroup.OnStartListener))
                this.onStartListener = ((HttpGroup.OnStartListener)paramHttpTaskListener);
            if ((paramHttpTaskListener instanceof HttpGroup.OnCancelListener))
                this.onCancelListener = ((HttpGroup.OnCancelListener)paramHttpTaskListener);
            if ((paramHttpTaskListener instanceof HttpGroup.OnProgressListener))
                this.onProgressListener = ((HttpGroup.OnProgressListener)paramHttpTaskListener);
            if ((paramHttpTaskListener instanceof HttpGroup.OnEndListener))
                this.onEndListener = ((HttpGroup.OnEndListener)paramHttpTaskListener);
            if ((paramHttpTaskListener instanceof HttpGroup.OnReadyListener))
                this.onReadyListener = ((HttpGroup.OnReadyListener)paramHttpTaskListener);
            if ((paramHttpTaskListener instanceof HttpGroup.OnPauseListener))
                this.onPauseListener = ((HttpGroup.OnPauseListener)paramHttpTaskListener);
        }

        public void setMoreParams(Map moreParams) {
            this.moreParams = moreParams;
        }

        public void setNotifyUser(boolean notifyUser) {
            this.notifyUser = notifyUser;
        }

        public void setHost(String host) {
            this.host = host;
        }

        public void setPost(boolean post) {
            this.post = post;
        }

        public void setEffect(int effect) {
            this.effect = effect;
        }

        public void setLocalFileCache(boolean localFileCache) {
            this.localFileCache = localFileCache;
        }

        public void setLocalFileCacheTime(long localFileCacheTime) {
            this.localFileCacheTime = localFileCacheTime;
        }

        public void setUrl(String url) {
            this.url = url;
        }

        public void putJsonParam(String isAdvance, Object integer) {

        }

        public void setConnectTimeout(long connectTimeout) {
            this.connectTimeout = connectTimeout;
        }

        public void setReadTimeout(long readTimeout) {
            this.readTimeout = readTimeout;
        }

        public void setCacheMode(int cacheMode) {
            this.cacheMode = cacheMode;
        }

        public void setBussinessId(int bussinessId) {
            this.bussinessId = bussinessId;
        }

        public void setUseCookies(boolean useCookies) {
            this.useCookies = useCookies;
        }

        public void setAttempts(int attempts) {
            this.attempts = attempts;
        }
    }

    public static class HttpGroupSetting {
        public static final int PRIORITY_FILE = 500;
        public static final int PRIORITY_IMAGE = 5000;
        public static final int PRIORITY_JSON = 1000;
        public static final int TYPE_FILE = 500;
        public static final int TYPE_IMAGE = 5000;
        public static final int TYPE_JSON = 1000;
        private IMyActivity myActivity;
        private int priority;
        private ViewGroup progressBarRootLayout;
        private int type;
        public void setType(int type) {
            this.type = type;
        }

        public void setMyActivity(IMyActivity myActivity) {
            this.myActivity = myActivity;
        }
    }
}
