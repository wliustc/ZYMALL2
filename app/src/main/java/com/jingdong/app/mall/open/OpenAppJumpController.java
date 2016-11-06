package com.jingdong.app.mall.open;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;

import com.jingdong.common.utils.HttpGroup;
import com.jingdong.common.utils.JSONObjectProxy;
import com.zy.common.utils.JDMtaUtils;
import com.zy.common.utils.Log;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.Date;
import java.util.Iterator;

/**
 * Created by Robin on 2016/11/6.
 */
//d
public class OpenAppJumpController {
    private int a = 0;
    private Bundle b = new Bundle();

    public OpenAppJumpController(int paramInt, Bundle paramBundle)
    {
        this.a = paramInt;
        this.b = paramBundle;
    }




    public static OpenAppJumpController a(Intent paramIntent)
    {
        Uri uri = paramIntent.getData();
        OpenAppJumpController v0= null;
        if (Log.D)
            Log.d(_A.h, "data -->> " + uri);
        boolean bool;
        if (uri != null)
        {//if-eqz v1, :cond_3
            bool = TextUtils.isEmpty(paramIntent.getAction());
            if ("virtual".equals(((Uri)uri).getHost()))//if-eqz v0, :cond_2
                return _A.b((Uri)uri, bool);
            else
                return new OpenAppJumpController((Uri)uri, bool);
        }else if (paramIntent.getExtras() != null){//if-eqz v2, :cond_a
            Bundle v2 = paramIntent.getExtras();
            int moduleId = v2.getInt("moduleId", 0);
            if (Log.D)
                Log.d(_A.h, "createCommand moduleId -->> " + moduleId);
            Bundle localObject1 = new Bundle();
            Iterator localIterator = v2.keySet().iterator();
            //:cond_5
            //:goto_1
            while (localIterator.hasNext())
            {//if-eqz v0, :cond_8
                String str = (String)localIterator.next();
                if (!str.startsWith("param_"))//if-eqz v1, :cond_5
                    continue;
                Object localObject2 = v2.get(str);
                str = str.substring(str.indexOf("_") + 1);
                if ((localObject2 instanceof String))
                {
                    ((Bundle)localObject1).putString(str, (String)localObject2);
                }else if ((localObject2 instanceof Integer))
                {
                    ((Bundle)localObject1).putInt(str, ((Integer)localObject2).intValue());
                }else  if (localObject2 instanceof Long) {
                    ((Bundle) localObject1).putLong(str, ((Long) localObject2).longValue());
                }
            }
            //:cond_8
            ((Bundle)localObject1).putAll(v2);
            if (moduleId != 0)
                return new OpenAppJumpController(moduleId, (Bundle)localObject1);
            v0 = (OpenAppJumpController)v2.getSerializable("command");

        }
        //:cond_1
        //:goto_0
        return v0;
    }

    private static void a(Bundle paramBundle1, Bundle paramBundle2)
    {
        Iterator localIterator = paramBundle1.keySet().iterator();
        while (localIterator.hasNext())
        {
            String str = (String)localIterator.next();
            Object localObject = paramBundle1.get(str);
            if ((localObject instanceof String))
            {
                paramBundle2.putString("param_" + str, (String)localObject);
                continue;
            }
            if ((localObject instanceof Integer))
            {
                paramBundle2.putInt("param_" + str, ((Integer)localObject).intValue());
                continue;
            }
            if (!(localObject instanceof Long))
                continue;
            paramBundle2.putLong("param_" + str, ((Long)localObject).longValue());
        }
    }

    public final int a()
    {
        return this.a;
    }

    public final Bundle b()
    {
        return this.b;
    }

    public final Bundle c()
    {
        Bundle localBundle = new Bundle();
        localBundle.putInt("moduleId", this.a);
        a(this.b, localBundle);
        return localBundle;
    }

    public static class _A{
        public static String a;
        public static String b;
        public static String c;
        public static String d;
        public static String e;
        public static Date f;
        public static String g;
        private static final String h = _A.class.getSimpleName();
        private static Handler i = new Handler();

        private static OpenAppJumpController a(JSONObjectProxy paramJSONObjectProxy, int paramInt)
        {
            if ((paramJSONObjectProxy == null) || (paramInt == 0))
                return null;
            Iterator localIterator = paramJSONObjectProxy.keys();
            if (localIterator == null)
                return null;
            Bundle localBundle = new Bundle();
            while (localIterator.hasNext())
            {
                Object localObject1 = localIterator.next();
                if ((localObject1 == null) || (!(localObject1 instanceof String)))
                    continue;
                String str = (String)localObject1;
                Object localObject2;
                try
                {
                    localObject1 = paramJSONObjectProxy.get(str);
                    if (localObject1 == null)
                        continue;
                    if ((localObject1 instanceof String))
                        localBundle.putString(str, (String)localObject1);
                }
                catch (JSONException localObject2)
                {
                    while (true)
                    {
                        if (Log.E)
                            localJSONException.printStackTrace();
                        localObject2 = null;
                    }
                    if ((localObject2 instanceof Integer))
                    {
                        localBundle.putInt(str, ((Integer)localObject2).intValue());
                        continue;
                    }
                    if ((localObject2 instanceof Long))
                    {
                        localBundle.putLong(str, ((Long)localObject2).longValue());
                        continue;
                    }
                    if ((localObject2 instanceof JSONArray))
                    {
                        localBundle.putString(str, ((JSONArray)localObject2).toString());
                        continue;
                    }
                    if ((localObject2 instanceof JSONObject))
                        localBundle.putString(str, ((JSONObject)localObject2).toString());
                }
                if (!Log.D)
                    continue;
                Log.d(h, " prepareCommandFromJson ---> object : " + localObject2);
            }
            if (Log.D)
                Log.d(h, " prepareCommandFromJson ---> bundle : " + localBundle + " , toString : F " + localBundle.toString());
            return new d(paramInt, localBundle);
        }

        public static void a()
        {
            a(null);
        }

        public static void a(Context paramContext, Intent paramIntent)
        {
            JDMtaUtils.onClick(paramContext, h, paramContext.getClass().getName());
            boolean bool = paramIntent.getBooleanExtra("isHasAction", false);
            Object localObject1 = paramIntent.getExtras();
            Object localObject2;
            if ((bool) && (localObject1 != null))
            {
                localObject2 = ((Bundle)localObject1).getString("a");
                if (!TextUtils.isEmpty((CharSequence)localObject2))
                    if (paramIntent == null)
                        break label568;
            }
            label517: label568: for (paramIntent = (MessageSummary)paramIntent.getSerializableExtra("summary"); ; paramIntent = null)
            {
                if (paramIntent != null);
                for (paramIntent = paramIntent.getType() + "_" + paramIntent.getId() + "_" + paramIntent.getContent() + "_none_none"; ; paramIntent = "")
                {
                    JDMtaUtils.onClick(paramContext, "PushMessage_OpenMessage", h, paramIntent);
                    paramIntent = new URLParamMap();
                    paramIntent.put("to", (String)localObject2);
                    paramIntent.put("fromNotice", "0");
                    paramIntent.put("msgId", ((Bundle)localObject1).getString("msgId"));
                    CommonUtil.getInstance().forwardWebActivityForAction(paramContext, "to", paramIntent);
                    d locald;
                    do
                    {
                        do
                        {
                            return;
                            locald = d.a(paramIntent);
                        }
                        while (locald == null);
                        Bundle localBundle = locald.c();
                        localObject2 = "";
                        paramIntent = "";
                        localObject1 = "";
                        if (localBundle != null)
                        {
                            localObject2 = localBundle.getString("param_des");
                            paramIntent = localBundle.getString("param_landPageId");
                            localObject1 = localBundle.getString("param_type");
                        }
                        int j;
                        if ((!TextUtils.isEmpty((CharSequence)localObject2)) && (((String)localObject2).equals("productDetail")) && (!TextUtils.isEmpty(paramIntent)) && (paramIntent.equals("qihoo.search")))
                        {
                            if (Log.D)
                                Log.d(h, " openInappForwardProduct -->> productDetail ");
                            localObject2 = new Intent(paramContext, ProductDetailActivity.class);
                            localBundle.putString("id", localBundle.getString("param_skuId"));
                            ((Intent)localObject2).putExtras(localBundle);
                            ((Intent)localObject2).addFlags(268435456);
                            localObject1 = paramIntent;
                            if (TextUtils.isEmpty(paramIntent))
                                localObject1 = "unknown";
                            ((Intent)localObject2).putExtra("source", new SourceEntity((String)localObject1, null));
                            paramContext.startActivity((Intent)localObject2);
                            j = 1;
                        }
                        while (true)
                        {
                            if (j == 0)
                                break label517;
                            if (!Log.D)
                                break;
                            Log.d(h, " d-->> come  in  : ");
                            return;
                            if ((!TextUtils.isEmpty((CharSequence)localObject1)) && (((String)localObject1).equals("2")))
                            {
                                a(null);
                                localObject1 = localBundle.getString("param_unionId");
                                paramIntent = new SourceEntity("cps", (String)localObject1);
                                if (Log.D)
                                    Log.i(h, "InterfaceBroadcastReceiver onReceive() -->> unionId : " + (String)localObject1);
                                localBundle.putLong("id", localBundle.getLong("param_id"));
                                localObject1 = new Intent(paramContext, ProductDetailActivity.class);
                                ((Intent)localObject1).putExtras(localBundle);
                                ((Intent)localObject1).addFlags(268435456);
                                ((Intent)localObject1).putExtra("source", paramIntent);
                                paramContext.startActivity((Intent)localObject1);
                                j = 1;
                                continue;
                            }
                            j = 0;
                        }
                    }
                    while (locald.a() == 0);
                    if (Log.D)
                        Log.d(h, "toTargetActivity -->> ");
                    a(null);
                    i.post(new b(locald, paramContext));
                    return;
                }
            }
        }

        public static void a(Runnable paramRunnable)
        {
            c localc;
            HttpGroup.HttpSetting localHttpSetting;
            if ((d != null) || (e != null))
            {
                if (Log.D)
                    Log.d("Temp", "cps myActivity -->> getMainFrameActivity : " + MyApplication.getInstance().getMainFrameActivity());
                localc = new c(paramRunnable);
                localHttpSetting = new HttpGroup.HttpSetting();
                localHttpSetting.setFunctionId("cps");
                localHttpSetting.setHost(Configuration.getNgwHost());
                if (b != null)
                    break label169;
                paramRunnable = "";
                localHttpSetting.putJsonParam("type", paramRunnable);
                if (c != null)
                    break label176;
                paramRunnable = "";
                label103: localHttpSetting.putJsonParam("keyword", paramRunnable);
                localHttpSetting.putJsonParam("unionId", d);
                if (e != null)
                    break label183;
                paramRunnable = "";
                label130: localHttpSetting.putJsonParam("subunionId", paramRunnable);
                if (a != null)
                    break label190;
            }
            label169: label176: label183: label190: for (paramRunnable = ""; ; paramRunnable = a)
            {
                localHttpSetting.putJsonParam("HandleOpenURL_FunctionID", paramRunnable);
                localHttpSetting.setListener(localc);
                HttpGroupUtils.getHttpGroupaAsynPool().add(localHttpSetting);
                return;
                paramRunnable = b;
                break;
                paramRunnable = c;
                break label103;
                paramRunnable = e;
                break label130;
            }
        }

        // ERROR //
        private static OpenAppJumpController b(android.net.Uri paramUri, boolean paramBoolean)
        {
            return null;
        }
    }
}
