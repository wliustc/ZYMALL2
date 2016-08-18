package com.zy.common.channel.common.utils;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;

import com.jingdong.app.mall.basic.JDTransferActivity;
import com.jingdong.common.utils.JSONObjectProxy;
import com.zy.common.entity.JumpEntity;
import com.zy.common.entity.ShareEntity;
import com.zy.common.entity.ShareInfo;
import com.zy.common.utils.JsonParser;
import com.zy.common.utils.Log;

import org.json.JSONException;

import java.util.Iterator;

/**
 * Created by Robin on 2016/5/22.
 */
//b
public class JumpUtil {
    private static final String a = JumpUtil.class.getSimpleName();

    public static int a(String paramString, JSONObjectProxy paramJSONObjectProxy) {
        if ("activity".equals(paramString))
            return 103;
        if ("cart".equals(paramString))
            return 102;
        if ("cartB".equals(paramString))
            return 123;
        if ("getCoupon".equals(paramString))
            return 105;
        if ("m".equals(paramString))
            return 106;
        if (("productDetail".equals(paramString) | "skudetail".equals(paramString)))
            return 101;
        if ("textContainer".equals(paramString))
            return 104;
        if ("promotion".equals(paramString))
            return 107;
        if ("jd_native_jimi".equals(paramString))
            return 200;
        if ("jd_native_im".equals(paramString))
            return 201;
        if ("im".equals(paramString))
            return 208;
        if ("pop_native_im".equals(paramString))
            return 202;
        if ("jshopMain".equals(paramString))
            return 110;
        if (("couponCenter".equals(paramString) | "couponcenter".equals(paramString)))
            return 129;
        if ("share".equals(paramString))
            return 111;
        if ("DM".equals(paramString))
            return 112;
        if ("homeIcons".equals(paramString))
            return 113;
        if ("Discovery".equals(paramString))
            return 114;
        if ("productList".equals(paramString))
            return 115;
        if (("getXB".equals(paramString) | "native_littlebing".equals(paramString) | "xiaobing".equals(paramString)))
            return 116;
        if (("seckill".equals(paramString) | "miaosha".equals(paramString)))
            return 117;
        if ("orderlist".equals(paramString))
            return 118;
        if ("ordertrace".equals(paramString))
            return 119;
        if ("findActivity".equals(paramString))
            return 121;
        if (("cutPrice".equals(paramString) | "bargain".equals(paramString)))
            return 122;
        if (("airTicket".equals(paramString) | "jipiao".equals(paramString)))
            return 124;
        if ("airList".equals(paramString))
            return 206;
        if ("inTravelOrder".equals(paramString))
            return 213;
        if ("exTravelOrder".equals(paramString))
            return 214;
        if (("worthBuy".equals(paramString) | "goodchoice".equals(paramString)))
            return 125;
        if (("phoneSale".equals(paramString) | "mobile-only".equals(paramString)))
            return 126;
        if (("goodsRecommend".equals(paramString) | "recommend".equals(paramString)))
            return 127;
        if (("Movie".equals(paramString) | "dianyingpiao".equals(paramString)))
            return 203;
        if ("faxian".equals(paramString))
            return 128;
        if ("jshopBrand".equals(paramString))
            return 204;
        if ("myDNA".equals(paramString))
            return 205;
        if ("orderDetail_wear".equals(paramString))
            return 207;
        if (("wuliuchaxun".equals(paramString) | "Mwuliuchaxun".equals(paramString) | "logistics".equals(paramString)))
            return 209;
        if ("commentDetail".equals(paramString))
            return 211;
        if (("story".equals(paramString) | "native_story".equals(paramString)))
            return 212;
        if ("orderInfoView".equals(paramString))
            return 215;
        if ("ranklist".equals(paramString))
            return 219;
        if ("genericChannel".equals(paramString))
            return 217;
        if ("aggregatePage".equals(paramString))
            return 218;
        if (("RankingMain".equals(paramString) | "goodranking".equals(paramString)))
            return 221;
        if (("guangguang".equals(paramString) | "native_guangguang".equals(paramString) | "guangguangnew".equals(paramString)))
            return 222;
        if (("storetrend".equals(paramString) | "native_storetrend".equals(paramString)))
            return 223;
        if (("photobuy".equals(paramString) | "native_photobuy".equals(paramString)))
            return 224;
        if (("appcenter".equals(paramString) | "native_appcenter".equals(paramString)))
            return 225;
        if ("HomePage".equals(paramString))
            return 1;
        if (("scan".equals(paramString) | "native_scan".equals(paramString) | "saoasao".equals(paramString)))
            return 226;
        if ("faxian_author".equals(paramString))
            return 227;
        if ("faxian_article".equals(paramString))
            return 228;
        if ("orderDetail".equals(paramString))
            return 229;
        if (("recharge".equals(paramString) | "chongzhi".equals(paramString)))
            return 10;
        if ("shenghuoquan".equals(paramString))
            return 230;
        if (("mycollect".equals(paramString) | "Mguanzhu".equals(paramString)))
            return 231;
        if ("QQchongzhi".equals(paramString))
            return 232;
        if ("gamechongzhi".equals(paramString))
            return 233;
        if (("lottery".equals(paramString) | "caipiao".equals(paramString)))
            return 12;
        if ("indexGoodShop".equals(paramString))
            return 234;
        if ("newthemestreet".equals(paramString))
            return 235;
        if ("brandinner".equals(paramString))
            return 236;
        if ("myMessageShow".equals(paramString))
            return 2;
        if ("myMessageBox".equals(paramString))
            return 6;
        if ("category".equals(paramString))
            return 13;
        if ("search".equals(paramString))
            return 3;
        if ("barcodePurchase".equals(paramString))
            return 7;
        if ("jdLogin".equals(paramString))
            return 9;
        if ("myJd".equals(paramString))
            return 108;
        if ("lifetravel".equals(paramString))
            return 237;
        if ("promotionJump".equals(paramString))
            return 238;
        if ("promotionNew".equals(paramString))
            return 239;
        if ("h5Game".equals(paramString))
            return 240;
        if ("paySuccess".equals(paramString))
            return 241;
        if ("mystreet".equals(paramString))
            return 242;
        if ("geneRecom".equals(paramString))
            return 243;
        if ("newgoodshop".equals(paramString))
            return 244;
        if ("babel".equals(paramString))
            return 245;
        if ("OpenByDefaultBrowser".equals(paramString))
            return 246;
        if ("signRank".equals(paramString))
            return 247;
        paramString = paramJSONObjectProxy.optString("landpageUrl");
        if ((!TextUtils.isEmpty(paramString)) && (!TextUtils.isEmpty(paramString.trim())))
            return 210;
        return 0;
    }

    private static Bundle a(JSONObjectProxy paramJSONObjectProxy) {
        Iterator localIterator = paramJSONObjectProxy.keys();
        Bundle localBundle = null;
        if (localIterator != null) {
            localBundle = new Bundle();
            //:goto_1
            while (localIterator.hasNext()) {//if-eqz v0, :cond_5
                Object str = localIterator.next();
                if ((str != null) || ((str instanceof String))) {//if-eqz v1, :cond_1
                    Object localObject1 = null;
                    try {
                        localObject1 = paramJSONObjectProxy.get((String) str);
                    } catch (JSONException e) {
                        if (Log.E)
                            e.printStackTrace();
                    }
                    //:goto_2
                    if (localObject1 != null) {//if-eqz v1, :cond_1
                        if ((localObject1 instanceof String))//if-eqz v5, :cond_3
                            localBundle.putString((String) str, (String) localObject1);
                        else if ((localObject1 instanceof Integer))// if-eqz v5, :cond_4
                            localBundle.putInt((String) str, ((Integer) localObject1).intValue());
                        else if ((localObject1 instanceof Long))
                            localBundle.putLong((String) str, ((Long) localObject1).longValue());
                    }
                }
            }
        }
        return localBundle;
    }

    public static void a(Context paramContext, JumpEntity paramJumpEntity, int paramInt) {
        if (paramJumpEntity != null) {
            String str;
            ShareEntity localShareEntity;

            str = paramJumpEntity.getDes();
            Object localObject1 = paramJumpEntity.getParams();
            localShareEntity = paramJumpEntity.getShareInfo();

            if (!TextUtils.isEmpty(str)) {//if-nez v1, :cond_0
                if (localObject1 == null)//if-nez v0, :cond_2
                    localObject1 = "";
                JSONObjectProxy localJSONObjectProxy = JsonParser.a((String) localObject1);
                Bundle bundle = a(localJSONObjectProxy);
                int j = a(str, localJSONObjectProxy);
                if (j == 215)
                    bundle.putString("json", localJSONObjectProxy.toString());
                if (j == 101)
                    bundle.putString("sourceValue", paramJumpEntity.getSrv());
                if (j == 239)
                    bundle.putString("sourceValue", paramJumpEntity.getSrv());
                if (j == 238)
                    bundle.putString("sourceValue", paramJumpEntity.getSrv());
                int i = 1;
                if ((localShareEntity == null) || (localShareEntity.getUrl() == null))//if-eqz v1, :cond_9
                    i = 0;

                if (i != 0) {
                    ShareInfo shareInfo = new ShareInfo();
                    shareInfo.setUrl(localShareEntity.getUrl());
                    shareInfo.setIconUrl(localShareEntity.getAvatar());
                    shareInfo.setTitle(localShareEntity.getTitle());
                    shareInfo.setSummary(localShareEntity.getContent());
                    bundle.putParcelable("shareInfo", shareInfo);
                    bundle.putString("isShare", "1");
                    bundle.putBoolean("isNeedShare", true);
                }
                bundle.putInt("jumpFrom", paramInt);
                Log.d(a, "JumpUtil.execJump():" + str + "--->" + (String) localObject1);
                if (j != 0) {//if-eqz v6, :cond_0
                    Intent intent = new Intent(paramContext, JDTransferActivity.class);
                    intent.putExtra("moduleId", j);
                    localObject1 = bundle.getString("moduleId");
                    if (!TextUtils.isEmpty((CharSequence) localObject1)) {
                        bundle.remove("moduleId");
                        bundle.putString("moduleIdTmp", (String) localObject1);
                    }
                    intent.putExtras(bundle);
                    intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);//268435456
                    paramContext.startActivity(intent);
                }
            }
            return;
        }
    }
}
