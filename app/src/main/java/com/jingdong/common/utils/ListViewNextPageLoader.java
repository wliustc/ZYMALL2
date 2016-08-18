package com.jingdong.common.utils;

import android.os.Handler;
import android.text.TextUtils;
import android.widget.AbsListView;
import android.widget.ListView;

import com.zy.common.frame.IDestroyListener;
import com.zy.common.frame.IMyActivity;
import com.zy.common.utils.HttpGroup;
import com.zy.common.utils.Log;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * Created by Robin on 2016/5/8.
 */
//cw
public abstract class ListViewNextPageLoader implements IDestroyListener, HttpGroup.OnAllListener {
    private String A;
    private HashMap<Integer, Boolean> B = new HashMap();
    private final String a = "NextPageLoader";
    private IMyActivity b;
    private Handler c;
    protected ArrayList<Object> d = new ArrayList();
    protected boolean e = true;
    protected HttpGroup f;
    protected String g;
    protected JSONObject h;
    protected boolean i = true;
    protected boolean j = false;
    protected String k = "";
    protected Long l = Long.valueOf(0L);
    protected String m = "page";
    protected String n = "pagesize";
    protected int o = 1;
    protected int p = 10;
    protected int q;
    HttpGroup.HttpRequest r;
    private ArrayList<?> s = null;
    private boolean t = false;
    private boolean u = true;
    private boolean v = false;
    private long w;
    private boolean x = false;
    private long y = -1L;
    private AbsListView.OnScrollListener z = null;

    public ListViewNextPageLoader(IMyActivity paramIMyActivity, ListView paramListView, String paramString) {
        this.b = paramIMyActivity;
        this.c = paramIMyActivity.getHandler();
        paramIMyActivity.addDestroyListener(this);
        this.f = this.b.getHttpGroupaAsynPool();
        if (paramListView != null)
            paramListView.setOnScrollListener(new AbsListView.OnScrollListener() {//cx(this)
                @Override
                public void onScrollStateChanged(AbsListView view, int scrollState) {
                    if (ListViewNextPageLoader.this.z != null)
                        ListViewNextPageLoader.this.z.onScrollStateChanged(view, scrollState);
                }

                @Override
                public void onScroll(AbsListView view, int firstVisibleItem, int visibleItemCount, int totalItemCount) {
                    if ((!ListViewNextPageLoader.this.t) && (!ListViewNextPageLoader.this.v) && (!ListViewNextPageLoader.this.x) && (ListViewNextPageLoader.this.e) && (view.getAdapter() != null) && (ListViewNextPageLoader.this.d != null) && (ListViewNextPageLoader.this.d.size() > 0) && (totalItemCount - firstVisibleItem <= visibleItemCount * 2))
                        ListViewNextPageLoader.this.f();
                    if (ListViewNextPageLoader.this.z != null)
                        ListViewNextPageLoader.this.z.onScroll(view, firstVisibleItem, visibleItemCount, totalItemCount);
                }
            });
        this.g = paramString;
    }

    public ListViewNextPageLoader(IMyActivity paramIMyActivity, ListView paramListView, String paramString, JSONObject paramJSONObject) {
        this(paramIMyActivity, paramListView, paramString);
        this.h = paramJSONObject;
    }

    private void a(ArrayList<?> paramArrayList, boolean paramBoolean) {
        b(paramArrayList);
        if (a(paramArrayList)) {
            this.s = null;
            this.d.addAll(paramArrayList);
        }
        a(this.t);
        if ((!this.t) && (!paramBoolean))
            this.o += 1;
    }

    private boolean b(ArrayList<?> paramArrayList) {
        if (((paramArrayList != null) && (paramArrayList.size() < this.p)) || ((this.q == this.o) && (!this.j)))
            this.t = true;
        else
            this.t = false;
        return this.t;
    }

    private void i() {
        if (this.r != null)
            this.r.stop();
        this.t = false;
        this.B.clear();
        this.o = 1;
        this.s = null;
        this.e = true;
        this.v = false;
        this.d.clear();
    }

    private synchronized void j() {
        if (this.v)
            return;
        if (this.f != null) {
            this.v = true;
            a();
            c();
            Map localObject1 = new HashMap();
            if (this.j)
                localObject1.put(this.m, this.l);
            else
                localObject1.put(this.m, Integer.valueOf(this.o));
            HttpGroup.HttpSetting localHttpSetting = new HttpGroup.HttpSetting();
            localHttpSetting.setFunctionId(this.g);
            localHttpSetting.setJsonParams(k());
            localHttpSetting.setListener(this);
            localHttpSetting.setMoreParams((Map) localObject1);
            localHttpSetting.setNotifyUser(this.i);
            if (!TextUtils.isEmpty(this.A))
                localHttpSetting.setHost(this.A);
            localHttpSetting.setPost(false);
            if (this.u && this.o == 1) {
                this.u = false;
                localHttpSetting.setEffect(1);
            } else
                localHttpSetting.setEffect(0);
            if ((this.w > 0L) || (this.o == 1)) {
                localHttpSetting.setLocalFileCache(true);
                localHttpSetting.setLocalFileCacheTime(this.w);
            }
            this.r = this.f.add(localHttpSetting);
        }
    }

    private JSONObject k() {
        if (this.h == null) {
            JSONObject localJSONObject = new JSONObject();
            this.h = localJSONObject;
            return localJSONObject;
        }
        return this.h;
    }

    //ArrayList<?> a(HttpGroup.HttpResponse paramHttpResponse);
    protected abstract ArrayList<?> toList(HttpGroup.HttpResponse paramHttpResponse);

    protected abstract void a();

    public final void a(int paramInt) {
        this.p = paramInt;
    }

    public final void a(String paramString) {
        this.n = paramString;
    }

    public final void a(ArrayList<?> paramArrayList, int paramInt) {
        i();
        if (((paramArrayList == null) || (paramArrayList.size() == 0)) && (paramInt == 0)) {
            e();
            return;
        }
        this.d.addAll(paramArrayList);
        if (b(paramArrayList))
            a(true);
        this.o += paramInt;
    }

    protected abstract void a(boolean paramBoolean);

    protected abstract boolean a(ArrayList<?> paramArrayList);

    protected abstract void b();

    public final void b(int paramInt) {
        this.q = paramInt;
    }

    public final void b(String paramString) {
        this.A = paramString;
    }

    public final void b(boolean paramBoolean) {
        this.u = false;
    }

    protected void c() {
        try {
            if (this.j)
                k().put(this.k, this.l);
            else
                k().put(this.m, this.o);
            k().put(this.n, this.p);
            return;
        } catch (JSONException localJSONException) {
            if (Log.V)
                Log.v("NextPageLoader", "JSONException -->> ", localJSONException);
        }
    }

    public final void c(String paramString) {
        if (!TextUtils.isEmpty(paramString)) {
            this.j = true;
            this.k = paramString;
        }
    }

    public final void c(boolean paramBoolean) {
        this.i = false;
    }

    public final void d() {
        e();
    }

    public final void e() {
        i();
        f();
    }

    public final synchronized void f() {
        this.e = true;
        if (this.t) {
            if (Log.D)
                Log.d("NextPageLoader", "loadedLast Page " + this.t);
        } else if (this.s == null) {
            j();
        } else
            a(this.s, true);
        return;
    }

    public final boolean g() {
        return (this.d != null) && (this.d.size() > 0);
    }

    public final Integer h() {
        return Integer.valueOf(this.o);
    }

    @Override
    public void onDestroy() {
        this.x = true;
        this.b = null;
        this.d.clear();
        this.s = null;
        this.f = null;
        this.h = null;
        if (this.r != null)
            this.r.stop();
    }

    @Override
    public void onEnd(HttpGroup.HttpResponse paramHttpResponse) {
        if (this.y <= 0L) {
            this.y = paramHttpResponse.getJSONObject().optLong("totalCount");
            if (Log.D)
                Log.d("NextPageLoader", "onEnd() -->> totalCount = " + this.y);
        }
        final ArrayList localArrayList = toList(paramHttpResponse);
        final Map params = paramHttpResponse.getMoreParams();
        this.c.post(new Runnable() {//cy(this, localArrayList, params)
            @Override
            public void run() {
                if (ListViewNextPageLoader.this.x) {
                    ListViewNextPageLoader.this.v = false;
                    return;
                }
                if (localArrayList == null) {
                    ListViewNextPageLoader.this.v = false;
                    ListViewNextPageLoader.this.e = false;
                    ListViewNextPageLoader.this.b();
                    return;
                }
                Object v0 = params.get(ListViewNextPageLoader.this.m);
                if ((v0 instanceof Integer)) {//if-eqz v1, :cond_3
                    Integer localInteger = (Integer) v0;
                    synchronized (ListViewNextPageLoader.this.B) {
                        if ((ListViewNextPageLoader.this.B.get(localInteger) != null) && (((Boolean) ListViewNextPageLoader.this.B.get(localInteger)).booleanValue())) {//if-eqz v1, :cond_2
                            ListViewNextPageLoader.this.v = false;
                            ListViewNextPageLoader.this.e = false;
                            ListViewNextPageLoader.this.b();
                            return;
                        } else {
                            ListViewNextPageLoader.this.B.put(localInteger, Boolean.valueOf(true));
                        }
                    }
                }
                ListViewNextPageLoader.this.s = localArrayList;
                if (Log.D) {
                    Log.d("Temp", "show now -->> ");
                    System.err.println("showNextPage(itemList)");
                }
                ListViewNextPageLoader.this.a(localArrayList, false);
                ListViewNextPageLoader.this.v = false;
            }
        });
    }

    @Override
    public void onError(HttpGroup.HttpError paramHttpError) {
        this.v = false;
        if (this.y == this.d.size())
            return;
        this.c.post(new Runnable() {//cz(this)
            @Override
            public void run() {
                ListViewNextPageLoader.this.b();
            }
        });
        this.e = false;
    }

    @Override
    public void onProgress(int paramInt1, int paramInt2) {

    }

    @Override
    public void onStart() {

    }
}
