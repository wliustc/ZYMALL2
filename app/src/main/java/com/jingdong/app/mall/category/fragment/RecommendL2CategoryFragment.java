package com.jingdong.app.mall.category.fragment;

import android.app.Fragment;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.ListView;

import com.jingdong.common.config.Configuration;
import com.jingdong.common.utils.ExceptionReporter;
import com.jingdong.common.utils.HttpGroup;
import com.zy.app.mall.category.JDNewCategoryFragment;
import com.zy.app.mall.category.b.RightColumnBase;
import com.zy.app.mall.category.fragment.L2CategoryFragment;
import com.zy.common.entity.Catelogy;
import com.zy.common.utils.JDMtaUtils;
import com.zy.common.utils.JSONArrayProxy;

import org.json.JSONException;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Robin on 2016/8/20.
 */
public class RecommendL2CategoryFragment extends L2CategoryFragment {


    private static String s;
    private static String t;
    private String r = "bp.category";
    private List<RightColumnBase> u = new ArrayList();
    private boolean v = false;
    private _AF w = null;

    private static int a(JSONArrayProxy paramJSONArrayPoxy)
    {
        int j = 0;
        if ((paramJSONArrayPoxy != null) && (paramJSONArrayPoxy.length() > 0))
        {
            int i = 0;
            while (true)
            {
                k = i;
                if (j >= paramJSONArrayPoxy.length())
                    break label107;
                try
                {
                    Catelogy localCatelogy = new Catelogy(paramJSONArrayPoxy.getJSONObject(j), 4);
                    k = i;
                    if (localCatelogy.getSensitiveFlag() == 0)
                    {
                        k = i;
                        if (!TextUtils.isEmpty(localCatelogy.getImgUrl()))
                        {
                            int m = localCatelogy.getColumNum();
                            k = i;
                            if (m != 1)
                                k = i + 1;
                        }
                    }
                    j += 1;
                    i = k;
                }
                catch (JSONException localJSONException)
                {
                    while (true)
                    {
                        localJSONException.printStackTrace();
                        k = i;
                    }
                }
            }
        }
        int k = 0;
        label107: return k;
    }

    public static Fragment a(String paramString1, String paramString2)
    {
        RecommendL2CategoryFragment localRecommendL2CategoryFragment = new RecommendL2CategoryFragment();
        Bundle localBundle = new Bundle();
        s = paramString1;
        t = paramString2;
        localBundle.putCharSequence("uid", paramString1);
        localBundle.putCharSequence("guid", paramString2);
        a(localBundle, -1);
        localRecommendL2CategoryFragment.setArguments(localBundle);
        return localRecommendL2CategoryFragment;
    }

    // ERROR //
    private List<RightColumnBase> a(JSONArrayProxy paramJSONArrayPoxy, int paramInt)
    {
        // Byte code:
        //   0: new 25	java/util/ArrayList
        //   3: dup
        //   4: invokespecial 26	java/util/ArrayList:<init>	()V
        //   7: astore 9
        //   9: aload_1
        //   10: ifnull +947 -> 957
        //   13: aload_1
        //   14: invokevirtual 43	com/jingdong/common/utils/JSONArrayPoxy:length	()I
        //   17: ifle +940 -> 957
        //   20: iconst_0
        //   21: istore 25
        //   23: iload 25
        //   25: aload_1
        //   26: invokevirtual 43	com/jingdong/common/utils/JSONArrayPoxy:length	()I
        //   29: if_icmpge +928 -> 957
        //   32: aload_1
        //   33: iload 25
        //   35: invokevirtual 104	com/jingdong/common/utils/JSONArrayPoxy:getJSONObjectOrNull	(I)Lcom/jingdong/common/utils/JSONObjectProxy;
        //   38: astore_3
        //   39: aload_3
        //   40: ifnull +908 -> 948
        //   43: aload_3
        //   44: ldc 106
        //   46: invokevirtual 112	com/jingdong/common/utils/JSONObjectProxy:getJSONArrayOrNull	(Ljava/lang/String;)Lcom/jingdong/common/utils/JSONArrayPoxy;
        //   49: astore 10
        //   51: aload_3
        //   52: ldc 114
        //   54: invokevirtual 118	com/jingdong/common/utils/JSONObjectProxy:optString	(Ljava/lang/String;)Ljava/lang/String;
        //   57: astore 4
        //   59: aload_3
        //   60: ldc 120
        //   62: invokevirtual 118	com/jingdong/common/utils/JSONObjectProxy:optString	(Ljava/lang/String;)Ljava/lang/String;
        //   65: astore 11
        //   67: aload_3
        //   68: ldc 122
        //   70: invokevirtual 126	com/jingdong/common/utils/JSONObjectProxy:optBoolean	(Ljava/lang/String;)Z
        //   73: istore 29
        //   75: aload_3
        //   76: ldc 128
        //   78: invokevirtual 126	com/jingdong/common/utils/JSONObjectProxy:optBoolean	(Ljava/lang/String;)Z
        //   81: istore 30
        //   83: new 130	com/jingdong/app/mall/category/b/d
        //   86: dup
        //   87: aload 4
        //   89: aload 11
        //   91: iload 29
        //   93: invokespecial 133	com/jingdong/app/mall/category/b/d:<init>	(Ljava/lang/String;Ljava/lang/String;Z)V
        //   96: astore 4
        //   98: aload 4
        //   100: iload 30
        //   102: invokevirtual 136	com/jingdong/app/mall/category/b/d:a	(Z)V
        //   105: aload_3
        //   106: ldc 138
        //   108: invokevirtual 112	com/jingdong/common/utils/JSONObjectProxy:getJSONArrayOrNull	(Ljava/lang/String;)Lcom/jingdong/common/utils/JSONArrayPoxy;
        //   111: astore_3
        //   112: aload_3
        //   113: ifnull +39 -> 152
        //   116: aload_3
        //   117: invokevirtual 141	com/jingdong/common/utils/JSONArrayPoxy:toString	()Ljava/lang/String;
        //   120: invokestatic 65	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
        //   123: ifne +29 -> 152
        //   126: aload_3
        //   127: invokevirtual 141	com/jingdong/common/utils/JSONArrayPoxy:toString	()Ljava/lang/String;
        //   130: invokevirtual 144	java/lang/String:length	()I
        //   133: istore 16
        //   135: aload 4
        //   137: aload_3
        //   138: invokevirtual 141	com/jingdong/common/utils/JSONArrayPoxy:toString	()Ljava/lang/String;
        //   141: iconst_1
        //   142: iload 16
        //   144: iconst_1
        //   145: isub
        //   146: invokevirtual 148	java/lang/String:substring	(II)Ljava/lang/String;
        //   149: invokevirtual 151	com/jingdong/app/mall/category/b/d:a	(Ljava/lang/String;)V
        //   152: aload 9
        //   154: aload 4
        //   156: invokeinterface 157 2 0
        //   161: pop
        //   162: aload 10
        //   164: ifnull +784 -> 948
        //   167: aload 10
        //   169: invokevirtual 43	com/jingdong/common/utils/JSONArrayPoxy:length	()I
        //   172: ifle +776 -> 948
        //   175: new 25	java/util/ArrayList
        //   178: dup
        //   179: invokespecial 26	java/util/ArrayList:<init>	()V
        //   182: astore 12
        //   184: new 25	java/util/ArrayList
        //   187: dup
        //   188: invokespecial 26	java/util/ArrayList:<init>	()V
        //   191: astore 13
        //   193: new 25	java/util/ArrayList
        //   196: dup
        //   197: invokespecial 26	java/util/ArrayList:<init>	()V
        //   200: astore 14
        //   202: aload 10
        //   204: invokestatic 159	com/jingdong/app/mall/category/fragment/RecommendL2CategoryFragment:a	(Lcom/jingdong/common/utils/JSONArrayPoxy;)I
        //   207: istore 27
        //   209: aload 10
        //   211: invokestatic 162	com/jingdong/app/mall/category/fragment/RecommendL2CategoryFragment:b	(Lcom/jingdong/common/utils/JSONArrayPoxy;)I
        //   214: istore 28
        //   216: iconst_0
        //   217: istore 18
        //   219: iconst_0
        //   220: istore 17
        //   222: iconst_0
        //   223: istore 16
        //   225: aconst_null
        //   226: astore 4
        //   228: aconst_null
        //   229: astore_3
        //   230: iconst_0
        //   231: istore 26
        //   233: iload 26
        //   235: aload 10
        //   237: invokevirtual 43	com/jingdong/common/utils/JSONArrayPoxy:length	()I
        //   240: if_icmpge +678 -> 918
        //   243: iload 18
        //   245: istore 19
        //   247: iload 17
        //   249: istore 21
        //   251: iload 16
        //   253: istore 22
        //   255: aload 4
        //   257: astore 5
        //   259: aload_3
        //   260: astore 6
        //   262: new 45	com/jingdong/common/entity/Catelogy
        //   265: dup
        //   266: aload 10
        //   268: iload 26
        //   270: invokevirtual 49	com/jingdong/common/utils/JSONArrayPoxy:getJSONObject	(I)Lcom/jingdong/common/utils/JSONObjectProxy;
        //   273: iload_2
        //   274: invokespecial 52	com/jingdong/common/entity/Catelogy:<init>	(Lcom/jingdong/common/utils/JSONObjectProxy;I)V
        //   277: astore 15
        //   279: iload 18
        //   281: istore 19
        //   283: iload 17
        //   285: istore 21
        //   287: iload 16
        //   289: istore 22
        //   291: aload 4
        //   293: astore 5
        //   295: aload_3
        //   296: astore 6
        //   298: aload 15
        //   300: aload 11
        //   302: invokevirtual 165	com/jingdong/common/entity/Catelogy:setLevel2Cid	(Ljava/lang/String;)V
        //   305: iload 18
        //   307: istore 19
        //   309: iload 17
        //   311: istore 21
        //   313: iload 16
        //   315: istore 22
        //   317: aload 4
        //   319: astore 5
        //   321: aload_3
        //   322: astore 6
        //   324: iload 18
        //   326: istore 20
        //   328: iload 17
        //   330: istore 23
        //   332: iload 16
        //   334: istore 24
        //   336: aload 4
        //   338: astore 7
        //   340: aload_3
        //   341: astore 8
        //   343: aload 15
        //   345: invokevirtual 55	com/jingdong/common/entity/Catelogy:getSensitiveFlag	()I
        //   348: ifne +622 -> 970
        //   351: iload 18
        //   353: istore 19
        //   355: iload 17
        //   357: istore 21
        //   359: iload 16
        //   361: istore 22
        //   363: aload 4
        //   365: astore 5
        //   367: aload_3
        //   368: astore 6
        //   370: aload 15
        //   372: invokevirtual 68	com/jingdong/common/entity/Catelogy:getColumNum	()I
        //   375: iconst_1
        //   376: if_icmpne +192 -> 568
        //   379: iload 18
        //   381: istore 19
        //   383: iload 17
        //   385: istore 21
        //   387: iload 16
        //   389: istore 22
        //   391: aload 4
        //   393: astore 5
        //   395: aload_3
        //   396: astore 6
        //   398: new 167	com/jingdong/app/mall/category/b/c
        //   401: dup
        //   402: invokespecial 168	com/jingdong/app/mall/category/b/c:<init>	()V
        //   405: astore 7
        //   407: iload 18
        //   409: istore 19
        //   411: iload 17
        //   413: istore 21
        //   415: iload 16
        //   417: istore 22
        //   419: aload 4
        //   421: astore 5
        //   423: aload_3
        //   424: astore 6
        //   426: aload 7
        //   428: iconst_2
        //   429: putfield 173	com/jingdong/app/mall/category/b/b:a	I
        //   432: iload 18
        //   434: istore 19
        //   436: iload 17
        //   438: istore 21
        //   440: iload 16
        //   442: istore 22
        //   444: aload 4
        //   446: astore 5
        //   448: aload_3
        //   449: astore 6
        //   451: aload 7
        //   453: iconst_1
        //   454: invokevirtual 176	com/jingdong/app/mall/category/b/c:b	(I)V
        //   457: iload 18
        //   459: istore 19
        //   461: iload 17
        //   463: istore 21
        //   465: iload 16
        //   467: istore 22
        //   469: aload 4
        //   471: astore 5
        //   473: aload_3
        //   474: astore 6
        //   476: aload 7
        //   478: aload 15
        //   480: invokevirtual 179	com/jingdong/app/mall/category/b/c:a	(Lcom/jingdong/common/entity/Catelogy;)V
        //   483: iload 18
        //   485: istore 19
        //   487: iload 17
        //   489: istore 21
        //   491: iload 16
        //   493: istore 22
        //   495: aload 4
        //   497: astore 5
        //   499: aload_3
        //   500: astore 6
        //   502: aload 14
        //   504: aload 7
        //   506: invokeinterface 157 2 0
        //   511: pop
        //   512: iload 18
        //   514: iconst_1
        //   515: iadd
        //   516: istore 20
        //   518: iload 20
        //   520: istore 19
        //   522: iload 17
        //   524: istore 21
        //   526: iload 16
        //   528: istore 22
        //   530: aload 4
        //   532: astore 5
        //   534: aload_3
        //   535: astore 6
        //   537: aload 15
        //   539: iload 27
        //   541: iload 28
        //   543: iadd
        //   544: iload 20
        //   546: iadd
        //   547: invokevirtual 182	com/jingdong/common/entity/Catelogy:setNum	(I)V
        //   550: iload 17
        //   552: istore 23
        //   554: iload 16
        //   556: istore 24
        //   558: aload 4
        //   560: astore 7
        //   562: aload_3
        //   563: astore 8
        //   565: goto +405 -> 970
        //   568: iload 18
        //   570: istore 19
        //   572: iload 17
        //   574: istore 21
        //   576: iload 16
        //   578: istore 22
        //   580: aload 4
        //   582: astore 5
        //   584: aload_3
        //   585: astore 6
        //   587: aload 15
        //   589: invokevirtual 59	com/jingdong/common/entity/Catelogy:getImgUrl	()Ljava/lang/String;
        //   592: invokestatic 65	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
        //   595: ifne +183 -> 778
        //   598: iload 16
        //   600: iconst_3
        //   601: irem
        //   602: ifne +148 -> 750
        //   605: iload 18
        //   607: istore 19
        //   609: iload 17
        //   611: istore 21
        //   613: iload 16
        //   615: istore 22
        //   617: aload 4
        //   619: astore 5
        //   621: aload_3
        //   622: astore 6
        //   624: new 167	com/jingdong/app/mall/category/b/c
        //   627: dup
        //   628: invokespecial 168	com/jingdong/app/mall/category/b/c:<init>	()V
        //   631: astore_3
        //   632: aload_3
        //   633: iconst_1
        //   634: putfield 173	com/jingdong/app/mall/category/b/b:a	I
        //   637: aload_3
        //   638: aload 15
        //   640: invokevirtual 179	com/jingdong/app/mall/category/b/c:a	(Lcom/jingdong/common/entity/Catelogy;)V
        //   643: aload 12
        //   645: aload_3
        //   646: invokeinterface 157 2 0
        //   651: pop
        //   652: iload 16
        //   654: iconst_1
        //   655: iadd
        //   656: istore 24
        //   658: iload 18
        //   660: istore 19
        //   662: iload 17
        //   664: istore 21
        //   666: iload 24
        //   668: istore 22
        //   670: aload 4
        //   672: astore 5
        //   674: aload_3
        //   675: astore 6
        //   677: aload 15
        //   679: iload 24
        //   681: invokevirtual 182	com/jingdong/common/entity/Catelogy:setNum	(I)V
        //   684: iload 18
        //   686: istore 20
        //   688: iload 17
        //   690: istore 23
        //   692: aload 4
        //   694: astore 7
        //   696: aload_3
        //   697: astore 8
        //   699: goto +271 -> 970
        //   702: astore 7
        //   704: aload 6
        //   706: astore_3
        //   707: aload 5
        //   709: astore 4
        //   711: iload 22
        //   713: istore 16
        //   715: iload 21
        //   717: istore 17
        //   719: iload 19
        //   721: istore 18
        //   723: aload 7
        //   725: invokevirtual 71	org/json/JSONException:printStackTrace	()V
        //   728: iload 18
        //   730: istore 20
        //   732: iload 17
        //   734: istore 23
        //   736: iload 16
        //   738: istore 24
        //   740: aload 4
        //   742: astore 7
        //   744: aload_3
        //   745: astore 8
        //   747: goto +223 -> 970
        //   750: iload 18
        //   752: istore 19
        //   754: iload 17
        //   756: istore 21
        //   758: iload 16
        //   760: istore 22
        //   762: aload 4
        //   764: astore 5
        //   766: aload_3
        //   767: astore 6
        //   769: aload_3
        //   770: aload 15
        //   772: invokevirtual 179	com/jingdong/app/mall/category/b/c:a	(Lcom/jingdong/common/entity/Catelogy;)V
        //   775: goto -123 -> 652
        //   778: iload 17
        //   780: iconst_3
        //   781: irem
        //   782: ifne +107 -> 889
        //   785: iload 18
        //   787: istore 19
        //   789: iload 17
        //   791: istore 21
        //   793: iload 16
        //   795: istore 22
        //   797: aload 4
        //   799: astore 5
        //   801: aload_3
        //   802: astore 6
        //   804: new 167	com/jingdong/app/mall/category/b/c
        //   807: dup
        //   808: invokespecial 168	com/jingdong/app/mall/category/b/c:<init>	()V
        //   811: astore 4
        //   813: aload 4
        //   815: iconst_2
        //   816: putfield 173	com/jingdong/app/mall/category/b/b:a	I
        //   819: aload 4
        //   821: aload 15
        //   823: invokevirtual 179	com/jingdong/app/mall/category/b/c:a	(Lcom/jingdong/common/entity/Catelogy;)V
        //   826: aload 13
        //   828: aload 4
        //   830: invokeinterface 157 2 0
        //   835: pop
        //   836: iload 17
        //   838: iconst_1
        //   839: iadd
        //   840: istore 23
        //   842: iload 18
        //   844: istore 19
        //   846: iload 23
        //   848: istore 21
        //   850: iload 16
        //   852: istore 22
        //   854: aload 4
        //   856: astore 5
        //   858: aload_3
        //   859: astore 6
        //   861: aload 15
        //   863: iload 27
        //   865: iload 23
        //   867: iadd
        //   868: invokevirtual 182	com/jingdong/common/entity/Catelogy:setNum	(I)V
        //   871: iload 18
        //   873: istore 20
        //   875: iload 16
        //   877: istore 24
        //   879: aload 4
        //   881: astore 7
        //   883: aload_3
        //   884: astore 8
        //   886: goto +84 -> 970
        //   889: iload 18
        //   891: istore 19
        //   893: iload 17
        //   895: istore 21
        //   897: iload 16
        //   899: istore 22
        //   901: aload 4
        //   903: astore 5
        //   905: aload_3
        //   906: astore 6
        //   908: aload 4
        //   910: aload 15
        //   912: invokevirtual 179	com/jingdong/app/mall/category/b/c:a	(Lcom/jingdong/common/entity/Catelogy;)V
        //   915: goto -79 -> 836
        //   918: aload 9
        //   920: aload 12
        //   922: invokeinterface 186 2 0
        //   927: pop
        //   928: aload 9
        //   930: aload 13
        //   932: invokeinterface 186 2 0
        //   937: pop
        //   938: aload 9
        //   940: aload 14
        //   942: invokeinterface 186 2 0
        //   947: pop
        //   948: iload 25
        //   950: iconst_1
        //   951: iadd
        //   952: istore 25
        //   954: goto -931 -> 23
        //   957: aload 9
        //   959: areturn
        //   960: astore 7
        //   962: goto -239 -> 723
        //   965: astore 7
        //   967: goto -244 -> 723
        //   970: iload 26
        //   972: iconst_1
        //   973: iadd
        //   974: istore 26
        //   976: iload 20
        //   978: istore 18
        //   980: iload 23
        //   982: istore 17
        //   984: iload 24
        //   986: istore 16
        //   988: aload 7
        //   990: astore 4
        //   992: aload 8
        //   994: astore_3
        //   995: goto -762 -> 233
        //
        // Exception table:
        //   from	to	target	type
        //   262	279	702	org/json/JSONException
        //   298	305	702	org/json/JSONException
        //   343	351	702	org/json/JSONException
        //   370	379	702	org/json/JSONException
        //   398	407	702	org/json/JSONException
        //   426	432	702	org/json/JSONException
        //   451	457	702	org/json/JSONException
        //   476	483	702	org/json/JSONException
        //   502	512	702	org/json/JSONException
        //   537	550	702	org/json/JSONException
        //   587	598	702	org/json/JSONException
        //   624	632	702	org/json/JSONException
        //   677	684	702	org/json/JSONException
        //   769	775	702	org/json/JSONException
        //   804	813	702	org/json/JSONException
        //   861	871	702	org/json/JSONException
        //   908	915	702	org/json/JSONException
        //   632	652	960	org/json/JSONException
        //   813	836	965	org/json/JSONException
    }

    private static int b(JSONArrayProxy paramJSONArrayPoxy)
    {
        int j = 0;
        if ((paramJSONArrayPoxy != null) && (paramJSONArrayPoxy.length() > 0))
        {
            int i = 0;
            while (true)
            {
                k = i;
                if (j >= paramJSONArrayPoxy.length())
                    break label107;
                try
                {
                    Catelogy localCatelogy = new Catelogy(paramJSONArrayPoxy.getJSONObject(j), 4);
                    k = i;
                    if (localCatelogy.getSensitiveFlag() == 0)
                    {
                        k = i;
                        if (TextUtils.isEmpty(localCatelogy.getImgUrl()))
                        {
                            int m = localCatelogy.getColumNum();
                            k = i;
                            if (m != 1)
                                k = i + 1;
                        }
                    }
                    j += 1;
                    i = k;
                }
                catch (JSONException localJSONException)
                {
                    while (true)
                    {
                        localJSONException.printStackTrace();
                        k = i;
                    }
                }
            }
        }
        int k = 0;
        label107: return k;
    }

    protected final View a(LayoutInflater paramLayoutInflater)
    {
        paramLayoutInflater = paramLayoutInflater.inflate(2130903251, null);
        this.p = ((ListView)paramLayoutInflater.findViewById(2131165251));
        this.p.setSelector(17170445);
        return paramLayoutInflater;
    }

    public final void a(_AF paramaf)
    {
        this.w = paramaf;
    }

    public final void a(Catelogy paramCatelogy, String paramString)
    {
        if (paramCatelogy.getLevel2Cid().equals("99994444"))
            JDMtaUtils.sendCommonData(this.thisActivity, "CateCustomize_Scategory_Favor", paramCatelogy.getLevel3Cid() + "_" + paramCatelogy.getNum(), "", JDNewCategoryFragment.class, "", paramString, "");
        do
        {
            return;
            if (!paramCatelogy.getLevel2Cid().equals("44449999"))
                continue;
            JDMtaUtils.sendCommonData(this.thisActivity, "CateCustomize_Scategory_Hot", paramCatelogy.getLevel3Cid(), "", JDNewCategoryFragment.class, "", paramString, "");
            return;
        }
        while (!paramCatelogy.getLevel2Cid().equals("99999999"));
        JDMtaUtils.sendCommonData(this.thisActivity, "CateCustomize_Scategory_Special", paramCatelogy.getAction(), "", JDNewCategoryFragment.class, "", paramString, "");
    }

    public final void a(boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4)
    {
        a(paramBoolean1, paramBoolean2, paramBoolean3, paramBoolean4, this.i);
    }

    public final void a(boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4, boolean paramBoolean5)
    {
        post(new Runnable(){//v(this)
            @Override
            public void run() {
                if (this.a.isAdded())
                    this.a.l.setVisibility(0);
            }
        });
        HttpGroup.HttpSetting localHttpSetting = new HttpGroup.HttpSetting();
        localHttpSetting.setListener(new w(this, new ExceptionReporter(localHttpSetting), paramBoolean1, paramBoolean2, paramBoolean3, paramBoolean4, paramBoolean5));
        localHttpSetting.setFunctionId("commonCatalogs");
        localHttpSetting.setHost(Configuration.getPortalHost());
        String str = "0";
        if (paramBoolean1)
            str = "1";
        localHttpSetting.putJsonParam("clear", str);
        localHttpSetting.putJsonParam("method", this.r);
        localHttpSetting.putJsonParam("uid", s);
        localHttpSetting.putJsonParam("guid", t);
        localHttpSetting.putJsonParam("token", Md5Encrypt.md5(s + t + "81395f50b94bb4891a4ce4ffb6ccf64b"));
        if (!paramBoolean1)
        {
            if (!paramBoolean5)
                break label234;
            localHttpSetting.setLocalFileCache(true);
            localHttpSetting.setLocalFileCacheTime(3600000L);
            if (!paramBoolean4)
                break label225;
            localHttpSetting.setCacheMode(4);
        }
        while (true)
        {
            localHttpSetting.setBussinessId(300);
            this.thisActivity.getHttpGroupaAsynPool().add(localHttpSetting);
            a("-1", 1);
            return;
            label225: localHttpSetting.setCacheMode(0);
            continue;
            label234: a(true);
        }
    }

    public final void b(String paramString1, String paramString2)
    {
        s = paramString1;
        t = paramString2;
    }

    public void onCreate(Bundle paramBundle)
    {
        super.onCreate(paramBundle);
        getArguments();
        this.c = -1;
    }

    public interface _AF
    {
        public abstract void a(boolean paramBoolean1, boolean paramBoolean2, List<String> paramList, boolean paramBoolean3);
    }
}
