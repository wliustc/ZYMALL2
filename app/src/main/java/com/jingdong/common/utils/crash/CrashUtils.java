package com.jingdong.common.utils.crash;

import android.content.Intent;
import android.os.Build;
import android.text.TextUtils;

import com.jingdong.common.config.Configuration;
import com.jingdong.common.utils.HttpGroup;
import com.zy.common.utils.Log;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.File;
import java.util.Date;

/**
 * Created by robin on 16-10-31.
 */
//e
public class CrashUtils {
    private static File a;
    private static boolean b = true;

    static
    {
        try
        {
            a = new File(bj.a(1).b(), "crash");
            return;
        }
        catch (Exception localException)
        {
            while (!Log.E);
            localException.printStackTrace();
        }
    }

    public static JSONObject a(int paramInt, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5)
    {
        String str1 = "";
        String str2 = FormatUtils.formatDate(new Date());
        if (!TextUtils.isEmpty(paramString1.trim()))
            str1 = "FeedBack: " + paramString1;
        paramString1 = "submit: " + paramInt + " ;-- " + str1;
        paramString1 = paramString1 + " ;--" + paramString2;
        paramString1 = paramString1 + " ;--current free disk size: " + bp.a() + "M";
        paramString1 = paramString1 + " ;--cpu: " + Build.CPU_ABI + ";--bootloader:" + Build.BOOTLOADER + ";--romVersion:" + Build.DISPLAY;
        paramString1 = paramString1 + " ;--ad_se:" + com.jingdong.common.utils.g.a().length() + " ;--ad_si:" + com.jingdong.common.utils.g.b().length();
        paramString1 = paramString1 + " ;--battery:" + BatteryReceiver.a;
        paramString2 = new JSONObject();
        try
        {
            paramString2.put("currentPageInfo", paramString3);
            paramString2.put("crashStack", paramString4);
            paramString2.put("feedback", paramString1);
            paramString2.put("buildCode", String.valueOf(StatisticsReportUtil.getSoftwareVersionCode()));
            paramString2.put("clientVersion", StatisticsReportUtil.getSoftwareVersionName());
            paramString2.put("crashTime", str2);
            paramString2.put("partner", Configuration.getProperty("partner"));
            paramString1 = paramString5;
            if (TextUtils.isEmpty(paramString5))
                paramString1 = "default";
            paramString2.put("bisType", paramString1);
            paramString2.put("msgType", "1");
            if (Log.D)
                Log.d("crash", paramString2.toString());
            ab.putBooleanToPreference("crash_share_just_start", Boolean.valueOf(false));
            return paramString2;
        }
        catch (Throwable paramString1)
        {
            while (true)
            {
                if (!Log.D)
                    continue;
                paramString1.printStackTrace();
            }
        }
    }

    public static void a()
    {
        if (a == null);
        do
            return;
        while (!b);
        b = false;
        if (!a.exists())
        {
            b = true;
            return;
        }
        new g().start();
    }

    public static void a(Intent paramIntent)
    {
        new f(paramIntent).start();
    }

    // ERROR //
    public static void a(JSONObject paramJSONObject)
    {
        // Byte code:
        //   0: aconst_null
        //   1: astore 5
        //   3: getstatic 34	com/jingdong/common/utils/crash/e:a	Ljava/io/File;
        //   6: ifnonnull +4 -> 10
        //   9: return
        //   10: aload_0
        //   11: ifnull -2 -> 9
        //   14: aload_0
        //   15: ldc 157
        //   17: new 72	java/lang/StringBuilder
        //   20: dup
        //   21: ldc 236
        //   23: invokespecial 77	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
        //   26: aload_0
        //   27: ldc 157
        //   29: invokevirtual 239	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
        //   32: invokevirtual 81	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   35: invokevirtual 84	java/lang/StringBuilder:toString	()Ljava/lang/String;
        //   38: invokevirtual 153	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
        //   41: pop
        //   42: getstatic 34	com/jingdong/common/utils/crash/e:a	Ljava/io/File;
        //   45: invokevirtual 217	java/io/File:exists	()Z
        //   48: ifne +92 -> 140
        //   51: getstatic 34	com/jingdong/common/utils/crash/e:a	Ljava/io/File;
        //   54: invokevirtual 242	java/io/File:createNewFile	()Z
        //   57: pop
        //   58: iconst_1
        //   59: istore 8
        //   61: iconst_0
        //   62: istore 6
        //   64: aconst_null
        //   65: astore_1
        //   66: new 244	java/io/BufferedWriter
        //   69: dup
        //   70: new 246	java/io/FileWriter
        //   73: dup
        //   74: getstatic 34	com/jingdong/common/utils/crash/e:a	Ljava/io/File;
        //   77: iload 8
        //   79: invokespecial 249	java/io/FileWriter:<init>	(Ljava/io/File;Z)V
        //   82: invokespecial 252	java/io/BufferedWriter:<init>	(Ljava/io/Writer;)V
        //   85: astore_2
        //   86: iload 8
        //   88: ifeq +306 -> 394
        //   91: iload 6
        //   93: ifne +273 -> 366
        //   96: aload_2
        //   97: aload_0
        //   98: invokevirtual 195	org/json/JSONObject:toString	()Ljava/lang/String;
        //   101: invokevirtual 255	java/io/BufferedWriter:append	(Ljava/lang/CharSequence;)Ljava/io/Writer;
        //   104: pop
        //   105: aload_2
        //   106: invokevirtual 258	java/io/BufferedWriter:flush	()V
        //   109: aload_2
        //   110: invokevirtual 261	java/io/BufferedWriter:close	()V
        //   113: return
        //   114: astore_0
        //   115: getstatic 39	com/jingdong/common/utils/Log:E	Z
        //   118: ifeq -109 -> 9
        //   121: aload_0
        //   122: invokevirtual 262	java/io/IOException:printStackTrace	()V
        //   125: return
        //   126: astore_1
        //   127: getstatic 194	com/jingdong/common/utils/Log:D	Z
        //   130: ifeq -88 -> 42
        //   133: aload_1
        //   134: invokevirtual 263	org/json/JSONException:printStackTrace	()V
        //   137: goto -95 -> 42
        //   140: new 265	java/io/LineNumberReader
        //   143: dup
        //   144: new 267	java/io/FileReader
        //   147: dup
        //   148: getstatic 34	com/jingdong/common/utils/crash/e:a	Ljava/io/File;
        //   151: invokespecial 270	java/io/FileReader:<init>	(Ljava/io/File;)V
        //   154: invokespecial 273	java/io/LineNumberReader:<init>	(Ljava/io/Reader;)V
        //   157: astore 4
        //   159: aload 4
        //   161: astore_2
        //   162: new 275	java/util/ArrayList
        //   165: dup
        //   166: invokespecial 276	java/util/ArrayList:<init>	()V
        //   169: astore_1
        //   170: aload 4
        //   172: astore_2
        //   173: aload 4
        //   175: invokevirtual 279	java/io/LineNumberReader:readLine	()Ljava/lang/String;
        //   178: astore_3
        //   179: aload_3
        //   180: ifnull +107 -> 287
        //   183: aload 4
        //   185: astore_2
        //   186: aload_3
        //   187: invokevirtual 64	java/lang/String:trim	()Ljava/lang/String;
        //   190: invokevirtual 134	java/lang/String:length	()I
        //   193: ifle -23 -> 170
        //   196: aload 4
        //   198: astore_2
        //   199: aload_1
        //   200: aload_3
        //   201: invokeinterface 285 2 0
        //   206: pop
        //   207: goto -37 -> 170
        //   210: astore_3
        //   211: aload 4
        //   213: astore_2
        //   214: getstatic 194	com/jingdong/common/utils/Log:D	Z
        //   217: ifeq +10 -> 227
        //   220: aload 4
        //   222: astore_2
        //   223: aload_3
        //   224: invokevirtual 42	java/lang/Exception:printStackTrace	()V
        //   227: aload_1
        //   228: astore_2
        //   229: aload 4
        //   231: ifnull +10 -> 241
        //   234: aload 4
        //   236: invokevirtual 286	java/io/LineNumberReader:close	()V
        //   239: aload_1
        //   240: astore_2
        //   241: aload_2
        //   242: ifnull +276 -> 518
        //   245: aload_2
        //   246: invokeinterface 289 1 0
        //   251: istore 6
        //   253: iload 6
        //   255: bipush 10
        //   257: if_icmpne +101 -> 358
        //   260: aload_2
        //   261: iconst_0
        //   262: invokeinterface 293 2 0
        //   267: pop
        //   268: aload_2
        //   269: aload_0
        //   270: invokevirtual 195	org/json/JSONObject:toString	()Ljava/lang/String;
        //   273: invokeinterface 285 2 0
        //   278: pop
        //   279: aload_2
        //   280: astore_1
        //   281: iconst_0
        //   282: istore 8
        //   284: goto -218 -> 66
        //   287: aload 4
        //   289: invokevirtual 286	java/io/LineNumberReader:close	()V
        //   292: aload_1
        //   293: astore_2
        //   294: goto -53 -> 241
        //   297: astore_1
        //   298: aload 5
        //   300: astore_0
        //   301: getstatic 39	com/jingdong/common/utils/Log:E	Z
        //   304: ifeq +7 -> 311
        //   307: aload_1
        //   308: invokevirtual 213	java/lang/Throwable:printStackTrace	()V
        //   311: aload_0
        //   312: ifnull -303 -> 9
        //   315: aload_0
        //   316: invokevirtual 261	java/io/BufferedWriter:close	()V
        //   319: return
        //   320: astore_0
        //   321: getstatic 39	com/jingdong/common/utils/Log:E	Z
        //   324: ifeq -315 -> 9
        //   327: aload_0
        //   328: invokevirtual 262	java/io/IOException:printStackTrace	()V
        //   331: return
        //   332: astore_0
        //   333: aconst_null
        //   334: astore_2
        //   335: aload_2
        //   336: ifnull +7 -> 343
        //   339: aload_2
        //   340: invokevirtual 286	java/io/LineNumberReader:close	()V
        //   343: aload_0
        //   344: athrow
        //   345: astore_0
        //   346: aconst_null
        //   347: astore_1
        //   348: aload_1
        //   349: ifnull +7 -> 356
        //   352: aload_1
        //   353: invokevirtual 261	java/io/BufferedWriter:close	()V
        //   356: aload_0
        //   357: athrow
        //   358: iconst_1
        //   359: istore 8
        //   361: aload_2
        //   362: astore_1
        //   363: goto -297 -> 66
        //   366: aload_2
        //   367: new 72	java/lang/StringBuilder
        //   370: dup
        //   371: ldc_w 295
        //   374: invokespecial 77	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
        //   377: aload_0
        //   378: invokevirtual 195	org/json/JSONObject:toString	()Ljava/lang/String;
        //   381: invokevirtual 81	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   384: invokevirtual 84	java/lang/StringBuilder:toString	()Ljava/lang/String;
        //   387: invokevirtual 255	java/io/BufferedWriter:append	(Ljava/lang/CharSequence;)Ljava/io/Writer;
        //   390: pop
        //   391: goto -286 -> 105
        //   394: aload_1
        //   395: invokeinterface 289 1 0
        //   400: istore 7
        //   402: iconst_0
        //   403: istore 6
        //   405: iload 6
        //   407: iload 7
        //   409: if_icmpge -304 -> 105
        //   412: iload 6
        //   414: ifne +22 -> 436
        //   417: aload_2
        //   418: aload_1
        //   419: iload 6
        //   421: invokeinterface 298 2 0
        //   426: checkcast 300	java/lang/CharSequence
        //   429: invokevirtual 255	java/io/BufferedWriter:append	(Ljava/lang/CharSequence;)Ljava/io/Writer;
        //   432: pop
        //   433: goto +97 -> 530
        //   436: aload_2
        //   437: new 72	java/lang/StringBuilder
        //   440: dup
        //   441: ldc_w 295
        //   444: invokespecial 77	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
        //   447: aload_1
        //   448: iload 6
        //   450: invokeinterface 298 2 0
        //   455: checkcast 60	java/lang/String
        //   458: invokevirtual 81	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   461: invokevirtual 84	java/lang/StringBuilder:toString	()Ljava/lang/String;
        //   464: invokevirtual 255	java/io/BufferedWriter:append	(Ljava/lang/CharSequence;)Ljava/io/Writer;
        //   467: pop
        //   468: goto +62 -> 530
        //   471: astore_0
        //   472: aload_2
        //   473: astore_1
        //   474: goto -126 -> 348
        //   477: astore_1
        //   478: getstatic 39	com/jingdong/common/utils/Log:E	Z
        //   481: ifeq -125 -> 356
        //   484: aload_1
        //   485: invokevirtual 262	java/io/IOException:printStackTrace	()V
        //   488: goto -132 -> 356
        //   491: astore_2
        //   492: aload_0
        //   493: astore_1
        //   494: aload_2
        //   495: astore_0
        //   496: goto -148 -> 348
        //   499: astore_0
        //   500: goto -165 -> 335
        //   503: astore_3
        //   504: aconst_null
        //   505: astore_1
        //   506: aconst_null
        //   507: astore 4
        //   509: goto -298 -> 211
        //   512: astore_3
        //   513: aconst_null
        //   514: astore_1
        //   515: goto -304 -> 211
        //   518: iconst_0
        //   519: istore 6
        //   521: goto -268 -> 253
        //   524: astore_1
        //   525: aload_2
        //   526: astore_0
        //   527: goto -226 -> 301
        //   530: iload 6
        //   532: iconst_1
        //   533: iadd
        //   534: istore 6
        //   536: goto -131 -> 405
        //
        // Exception table:
        //   from	to	target	type
        //   109	113	114	java/io/IOException
        //   14	42	126	org/json/JSONException
        //   173	179	210	java/lang/Exception
        //   186	196	210	java/lang/Exception
        //   199	207	210	java/lang/Exception
        //   42	58	297	java/lang/Throwable
        //   66	86	297	java/lang/Throwable
        //   234	239	297	java/lang/Throwable
        //   245	253	297	java/lang/Throwable
        //   260	279	297	java/lang/Throwable
        //   287	292	297	java/lang/Throwable
        //   339	343	297	java/lang/Throwable
        //   343	345	297	java/lang/Throwable
        //   315	319	320	java/io/IOException
        //   140	159	332	finally
        //   42	58	345	finally
        //   66	86	345	finally
        //   234	239	345	finally
        //   245	253	345	finally
        //   260	279	345	finally
        //   287	292	345	finally
        //   339	343	345	finally
        //   343	345	345	finally
        //   96	105	471	finally
        //   105	109	471	finally
        //   366	391	471	finally
        //   394	402	471	finally
        //   417	433	471	finally
        //   436	468	471	finally
        //   352	356	477	java/io/IOException
        //   301	311	491	finally
        //   162	170	499	finally
        //   173	179	499	finally
        //   186	196	499	finally
        //   199	207	499	finally
        //   214	220	499	finally
        //   223	227	499	finally
        //   140	159	503	java/lang/Exception
        //   162	170	512	java/lang/Exception
        //   96	105	524	java/lang/Throwable
        //   105	109	524	java/lang/Throwable
        //   366	391	524	java/lang/Throwable
        //   394	402	524	java/lang/Throwable
        //   417	433	524	java/lang/Throwable
        //   436	468	524	java/lang/Throwable
    }

    public static void a(JSONObject paramJSONObject, HttpGroup.OnAllListener paramOnAllListener)
            throws Exception
    {
        Object localObject = new JSONArray();
        ((JSONArray)localObject).put(paramJSONObject);
        paramJSONObject = new JSONObject();
        paramJSONObject.put("msg", localObject);
        localObject = new HttpGroup.HttpGroupSetting();
        ((HttpGroup.HttpGroupSetting)localObject).setPriority(1000);
        ((HttpGroup.HttpGroupSetting)localObject).setType(1000);
        localObject = HttpGroup.getHttpGroup((HttpGroup.HttpGroupSetting)localObject);
        HttpGroup.HttpSetting localHttpSetting = new HttpGroup.HttpSetting();
        localHttpSetting.setFunctionId("newcrash");
        localHttpSetting.setJsonParams(paramJSONObject);
        localHttpSetting.setHost(Configuration.getNgwHost());
        localHttpSetting.setListener(paramOnAllListener);
        ((HttpGroup)localObject).add(localHttpSetting);
    }
}
