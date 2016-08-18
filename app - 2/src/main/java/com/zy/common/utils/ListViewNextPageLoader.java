package com.zy.common.utils;

import android.os.Handler;
import android.widget.AbsListView;
import android.widget.ListView;
import com.zy.common.frame.IDestroyListener;
import com.zy.common.frame.IMyActivity;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by Robin on 2016/5/8.
 */
//cw
public abstract class ListViewNextPageLoader implements IDestroyListener, HttpGroup.OnAllListener{
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

    public ListViewNextPageLoader(IMyActivity paramIMyActivity, ListView paramListView, String paramString)
    {
        this.b = paramIMyActivity;
        this.c = paramIMyActivity.getHandler();
        paramIMyActivity.addDestroyListener(this);
        this.f = this.b.getHttpGroupaAsynPool();
        if (paramListView != null)
            paramListView.setOnScrollListener(new cx(this));
        this.g = paramString;
    }

    public ListViewNextPageLoader(IMyActivity paramIMyActivity, ListView paramListView, String paramString, JSONObject paramJSONObject)
    {
        this(paramIMyActivity, paramListView, paramString);
        this.h = paramJSONObject;
    }

    private void a(ArrayList<?> paramArrayList, boolean paramBoolean)
    {
        b(paramArrayList);
        if (a(paramArrayList))
        {
            this.s = null;
            this.d.addAll(paramArrayList);
        }
        a(this.t);
        if ((!this.t) && (!paramBoolean))
            this.o += 1;
    }

    private boolean b(ArrayList<?> paramArrayList)
    {
        if (((paramArrayList != null) && (paramArrayList.size() < this.p)) || ((this.q == this.o) && (!this.j)));
        for (this.t = true; ; this.t = false)
            return this.t;
    }

    private void i()
    {
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

    private void j()
    {
        monitorenter;
        while (true)
        {
            HttpGroup.HttpSetting localHttpSetting;
            try
            {
                if (this.v)
                    continue;
                Object localObject1 = this.f;
                if (localObject1 == null)
                    return;
                this.v = true;
                a();
                c();
                localObject1 = new HashMap();
                if (this.j)
                {
                    ((HashMap)localObject1).put(this.m, this.l);
                    localHttpSetting = new HttpGroup.HttpSetting();
                    localHttpSetting.setFunctionId(this.g);
                    localHttpSetting.setJsonParams(k());
                    localHttpSetting.setListener(this);
                    localHttpSetting.setMoreParams((Map)localObject1);
                    localHttpSetting.setNotifyUser(this.i);
                    if (TextUtils.isEmpty(this.A))
                        continue;
                    localHttpSetting.setHost(this.A);
                    localHttpSetting.setPost(false);
                    if ((!this.u) || (this.o != 1))
                        break label221;
                    this.u = false;
                    localHttpSetting.setEffect(1);
                    if ((this.w <= 0L) || (this.o != 1))
                        continue;
                    localHttpSetting.setLocalFileCache(true);
                    localHttpSetting.setLocalFileCacheTime(this.w);
                    this.r = this.f.add(localHttpSetting);
                    continue;
                }
            }
            finally
            {
                monitorexit;
            }
            localObject2.put(this.m, Integer.valueOf(this.o));
            continue;
            label221: localHttpSetting.setEffect(0);
        }
    }

    private JSONObject k()
    {
        if (this.h == null)
        {
            JSONObject localJSONObject = new JSONObject();
            this.h = localJSONObject;
            return localJSONObject;
        }
        return this.h;
    }

    //ArrayList<?> a(HttpGroup.HttpResponse paramHttpResponse);
    protected abstract ArrayList<?> toList(HttpGroup.HttpResponse paramHttpResponse);

    protected abstract void a();

    public final void a(int paramInt)
    {
        this.p = paramInt;
    }

    public final void a(String paramString)
    {
        this.n = paramString;
    }

    public final void a(ArrayList<?> paramArrayList, int paramInt)
    {
        i();
        if (((paramArrayList == null) || (paramArrayList.size() == 0)) && (paramInt == 0))
        {
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

    public final void b(int paramInt)
    {
        this.q = paramInt;
    }

    public final void b(String paramString)
    {
        this.A = paramString;
    }

    public final void b(boolean paramBoolean)
    {
        this.u = false;
    }

    protected void c()
    {
        try
        {
            if (this.j)
                k().put(this.k, this.l);
            while (true)
            {
                k().put(this.n, this.p);
                return;
                k().put(this.m, this.o);
            }
        }
        catch (JSONException localJSONException)
        {
            if (Log.V)
                Log.v("NextPageLoader", "JSONException -->> ", localJSONException);
        }
    }

    public final void c(String paramString)
    {
        if (!TextUtils.isEmpty(paramString))
        {
            this.j = true;
            this.k = paramString;
        }
    }

    public final void c(boolean paramBoolean)
    {
        this.i = false;
    }

    public final void d()
    {
        e();
    }

    public final void e()
    {
        i();
        f();
    }

    public final void f()
    {
        monitorenter;
        while (true)
        {
            try
            {
                this.e = true;
                if (!this.t)
                    continue;
                if (!Log.D)
                    continue;
                Log.v("NextPageLoader", "loadedLast Page " + this.t);
                return;
                if (this.s == null)
                {
                    j();
                    continue;
                }
            }
            finally
            {
                monitorexit;
            }
            a(this.s, true);
        }
    }

    public final boolean g()
    {
        return (this.d != null) && (this.d.size() > 0);
    }

    public final Integer h()
    {
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
        if (this.y <= 0L)
        {
            this.y = paramHttpResponse.getJSONObject().optLong("totalCount");
            if (Log.D)
                Log.d("NextPageLoader", "onEnd() -->> totalCount = " + this.y);
        }
        ArrayList localArrayList = toList(paramHttpResponse);
        paramHttpResponse = paramHttpResponse.getMoreParams();
        this.c.post(new cy(this, localArrayList, paramHttpResponse));
    }

    @Override
    public void onError(HttpGroup.HttpError paramHttpError) {
        if (this.y <= 0L)
        {
            this.y = paramHttpResponse.getJSONObject().optLong("totalCount");
            if (Log.D)
                Log.d("NextPageLoader", "onEnd() -->> totalCount = " + this.y);
        }
        ArrayList localArrayList = a(paramHttpResponse);
        paramHttpResponse = paramHttpResponse.getMoreParams();
        this.c.post(new cy(this, localArrayList, paramHttpResponse));
    }

    @Override
    public void onProgress(int paramInt1, int paramInt2) {

    }

    @Override
    public void onStart() {

    }
}
