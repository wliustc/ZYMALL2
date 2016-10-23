package com.jingdong.common.utils;

import android.content.Context;
import android.os.Handler;

import com.zy.common.utils.Log;

/**
 * Created by Robin on 2016/10/23.
 */
public class HttpGroupWithNPS {
    private static final long COMPLETE_WAIT_TIME = 10000L;
    private static final String TAG = HttpGroupWithNPS.class.getSimpleName();
    private static final String mType = "2";
    private Context mContext;
    private Handler mHandler;
    private HttpGroup mHttpGroup;
    private boolean mIsPause;
    private boolean mIsStop;
    private Runnable mLastRunnable;
    private boolean mNeedStop;
    private HttpGroup.OnGroupCompleteListener mOnGroupCompleteListener;
    private HttpGroup.OnGroupStartListener mOnGroupStartListener;
    private String mPageName;
    private String mPageParam;
    private String mQueryTime;

    public HttpGroupWithNPS(Context paramContext, HttpGroup paramHttpGroup, String paramString1, String paramString2, boolean paramBoolean)
    {
        this.mPageName = paramString1;
        this.mPageParam = paramString2;
        this.mNeedStop = paramBoolean;
        this.mContext = paramContext;
        this.mHandler = new Handler(paramContext.getMainLooper());
        this.mHttpGroup = paramHttpGroup;
        initHttpGroup();
        this.mIsPause = false;
        this.mIsStop = false;
    }

    private void initHttpGroup()
    {
        if (this.mHttpGroup == null)
            return;
        this.mHttpGroup.setOnGroupStartListener(new HttpGroup.OnGroupStartListener(){
            @Override
            public void onStart() {
////                if (HttpGroupWithNPS.access$000(this.this$0) != null)
////                    HttpGroupWithNPS.access$000(this.this$0).onStart();
////                if ((HttpGroupWithNPS.access$100(this.this$0) != null) && (Log.E))
////                    Log.e(HttpGroupWithNPS.access$200(), "Error: there has old querytime. pullRefreshHttpGroup -->> onStart: mPageName = " + HttpGroupWithNPS.access$300(this.this$0) + ", mPageParam = " + HttpGroupWithNPS.access$400(this.this$0) + ", old querytime = " + HttpGroupWithNPS.access$100(this.this$0) + ", new querytime = " + JDMtaUtils.getCurrentMicrosecond());
////                HttpGroupWithNPS.access$102(this.this$0, JDMtaUtils.getCurrentMicrosecond());
////               if (Log.D)
////                    Log.d(HttpGroupWithNPS.access$200(), " pullRefreshHttpGroup -->> onStart: , mPageName = " + HttpGroupWithNPS.access$300(this.this$0) + ", mPageParam = " + HttpGroupWithNPS.access$400(this.this$0) + ", mQueryTime = " + HttpGroupWithNPS.access$100(this.this$0));
            }
        });
        this.mHttpGroup.setOnGroupCompleteListener(new HttpGroup.OnGroupCompleteListener(){//HttpGroupWithNPS.2(this)
            @Override
            public void onComplete() {
////                if (HttpGroupWithNPS.access$500(this.this$0) != null)
////                    HttpGroupWithNPS.access$500(this.this$0).onComplete();
////                synchronized (this.this$0)
////                {
////                    if ((HttpGroupWithNPS.access$600(this.this$0) == true) && (HttpGroupWithNPS.access$700(this.this$0) == true))
////                        return;
////                    if (HttpGroupWithNPS.access$800(this.this$0) == true)
////                        return;
////                }
////                monitorexit;
////                String str = JDMtaUtils.getCurrentMicrosecond();
////                if (Log.D)
////                    Log.d(HttpGroupWithNPS.access$200(), " pullRefreshHttpGroup -->> onComplete: , mPageName = " + HttpGroupWithNPS.access$300(this.this$0) + ", mPageParam = " + HttpGroupWithNPS.access$400(this.this$0) + ", endTime = " + str);
////                if (HttpGroupWithNPS.access$100(this.this$0) == null)
////                {
////                    if (Log.E)
////                    {
////                        Log.e(HttpGroupWithNPS.access$200(), "Error: there has no query time. can't send log.");
////                        return;
////                    }
////                }
////                else
////                    synchronized (this.this$0)
////                    {
////                        if (HttpGroupWithNPS.access$900(this.this$0) != null)
////                        {
////                            if (HttpGroupWithNPS.access$1000(this.this$0) != null)
////                                HttpGroupWithNPS.access$900(this.this$0).removeCallbacks(HttpGroupWithNPS.access$1000(this.this$0));
////                            HttpGroupWithNPS.access$1002(this.this$0, new HttpGroupWithNPS.CompleteRunnable(this.this$0, str));
////                            HttpGroupWithNPS.access$900(this.this$0).postDelayed(HttpGroupWithNPS.access$1000(this.this$0), 10000L);
////                        }
////                        return;
////                    }
            }
        });
    }

    public synchronized void destory()
    {
        if (Log.D)
            Log.d(TAG, "destory() ");

            if (this.mHandler != null)
            {
                if (this.mLastRunnable != null)
                {
                    this.mHandler.removeCallbacks(this.mLastRunnable);
                    this.mLastRunnable = null;
                }
                this.mHandler = null;
            }
            if (this.mContext != null)
                this.mContext = null;
            return;

    }

    public HttpGroup getHttpGroup()
    {
        return this.mHttpGroup;
    }

    public synchronized void onPause()
    {
        if (this.mIsPause == true)
            return;
        if (Log.D)
            Log.d(TAG, " canceled current httpgroupNPS. mPageName = " + this.mPageName + ", mPageParam = " + this.mPageParam);

            this.mIsPause = true;
            if (this.mLastRunnable != null)
                this.mHandler.removeCallbacks(this.mLastRunnable);
            return;
    }

    public synchronized void onResume()
    {
            this.mIsPause = false;
            return;
    }

    public void setOnGroupCompleteListener(HttpGroup.OnGroupCompleteListener paramOnGroupCompleteListener)
    {
        this.mOnGroupCompleteListener = paramOnGroupCompleteListener;
    }

    public void setOnGroupStartListener(HttpGroup.OnGroupStartListener paramOnGroupStartListener)
    {
        this.mOnGroupStartListener = paramOnGroupStartListener;
    }
}
