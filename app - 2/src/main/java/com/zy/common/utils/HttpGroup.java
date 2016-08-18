package com.zy.common.utils;

import com.zy.common.frame.IDestroyListener;

/**
 * Created by Robin on 2016/4/14.
 */
public abstract class HttpGroup implements IDestroyListener {

    public  interface HttpTaskListener
    {
    }

    public  interface OnEndListener extends HttpGroup.HttpTaskListener
    {
        public abstract void onEnd(HttpGroup.HttpResponse paramHttpResponse);
    }

    public  interface OnErrorListener extends HttpGroup.HttpTaskListener
    {
        public abstract void onError(HttpGroup.HttpError paramHttpError);
    }

    public  interface OnReadyListener extends HttpGroup.HttpTaskListener
    {
        public abstract void onReady(HttpGroup.HttpSettingParams paramHttpSettingParams);
    }

    public  interface OnCommonListener extends HttpGroup.OnEndListener, HttpGroup.OnErrorListener, HttpGroup.OnReadyListener
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
}
