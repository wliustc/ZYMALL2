package com.jingdong.app.mall.basic;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;

import com.jingdong.common.ui.JDDialogFactory;
import com.zy.common.ScrollableTabActivity;
import com.zy.common.constant.Constants;
import com.zy.common.ui.JDDialog;
import com.zy.common.utils.JDMtaUtils;
import com.zy.common.utils.Log;

/**
 * Created by Robin on 2016/11/6.
 */
//a
public class ActivityJumpController implements ScrollableTabActivity._Q {
    public static final String a = ActivityJumpController.class.getSimpleName();
    public static ActivityJumpController b;
    private Activity c;

    private static int a(Bundle paramBundle, String paramString)
    {
        paramBundle = paramBundle.get(paramString);
        int j = 0;
        int i = j;
        if (!TextUtils.isEmpty(paramBundle));
        try
        {
            i = Integer.parseInt(paramBundle);
            j = i;
            if (i <= 0)
                j = 1;
            return j;
        }
        catch (Exception e)
        {
            while (true)
            {
                i = j;
                if (Log.E)
                e.printStackTrace();
                i = j;
            }
        }
    }

    public static ActivityJumpController a()
    {
        if (b == null)
            b = new ActivityJumpController();
        return b;
    }

    private void a(int paramInt)
    {
        if (paramInt == 0)
        {
            localIntent = new Intent(this.c, PhoneChargeActivity.class);
            localIntent.putExtra("jumpType", 0);
            a(localIntent);
        }
        do
            return;
        while (paramInt != 1);
        Intent localIntent = new Intent(this.c, PhoneChargeActivity.class);
        localIntent.putExtra("jumpType", 1);
        a(localIntent);
    }

    private void a(Intent paramIntent)
    {
        this.c.startActivity(paramIntent);
    }

    private void a(Bundle paramBundle)
    {
        if (paramBundle != null)
        {
            Intent localIntent = new Intent(this.c, EvaluateDetailActivity.class);
            localIntent.putExtra("product_id", paramBundle.getString("productId"));
            localIntent.putExtra("product_comment_guid", paramBundle.getString("commentId"));
            localIntent.putExtra("sourceType", paramBundle.getString("sourceType"));
            localIntent.putExtra("sourceValue", paramBundle.getString("sourceValue"));
            a(localIntent);
        }
    }

    private void a(BaseActivity paramBaseActivity, String paramString)
    {
        ArrayList localArrayList = new ArrayList();
        try
        {
            if (Log.D)
                Log.d(a, " forwardShoppingCart ---> skuIds : " + paramString);
            paramString = new JSONArray(paramString);
            if (paramString.length() > 0)
            {
                int i = 0;
                while (i < paramString.length())
                {
                    String str = paramString.optString(i);
                    if (!TextUtils.isEmpty(str))
                        localArrayList.add(new CartSkuSummary(str, Integer.valueOf(1)));
                    i += 1;
                }
            }
        }
        catch (Exception paramString)
        {
            if (Log.D)
                paramString.printStackTrace();
            if ((paramBaseActivity != null) && (localArrayList.size() > 0))
                qi.addMultiProductToCart(paramBaseActivity, localArrayList, null, new h(this, localArrayList, paramBaseActivity), true);
        }
    }

    private void a(String paramString, Bundle paramBundle)
    {
        String str = paramBundle.getString("sourceValue");
        int i;
        if ((!TextUtils.isEmpty(str)) && (str.equals("scan")))
        {
            i = 1;
            if (i != 0)
            {
                paramBundle = paramBundle.getString("sourceType");
                if (TextUtils.isEmpty(paramBundle))
                    break label98;
                paramString = paramString + "_" + paramBundle;
            }
        }
        label98:
        while (true)
        {
            JDMtaUtils.sendCommonData(this.c, "QrcodeScan_OpenClient", paramString, "", this.c, "", "", "");
            return;
            i = 0;
            break;
        }
    }




    private void u(Bundle paramBundle)
    {
        Intent localIntent = new Intent(this.c, BabelActivity.class);
        localIntent.putExtras(paramBundle);
        a(localIntent);
    }

    private void v(Bundle paramBundle)
    {
        Object localObject = paramBundle.getString("msg");
        localObject = JDDialogFactory.getInstance().createJdDialogWithStyle2(this.c, (String)localObject, this.c.getResources().getString(2131230726), this.c.getResources().getString(2131231372));
        ((JDDialog)localObject).setOnLeftButtonClickListener(new j(this, (JDDialog)localObject));
        ((JDDialog)localObject).setOnRightButtonClickListener(new k(this, paramBundle, (JDDialog)localObject));
        ((JDDialog)localObject).show();
    }

    public final ActivityJumpController a(Activity paramActivity)
    {
        this.c = paramActivity;
        return a();
    }

    public final void a(Bundle paramBundle, int paramInt)
    {
        Object localObject1 = null;
        Object localObject3 = null;
        Object localObject4 = null;
        Object localObject6 = null;
        if (Log.D)
            Log.d(a, "forward() -->> moduleId = " + paramInt);
        Object localObject2 = paramBundle;
        if (paramBundle == null)
            localObject2 = new Bundle();
        paramBundle = MyApplication.getInstance().getCurrentMyActivity();
        if (paramBundle == null);
        while (true)
        {
            return;
            Object localObject5;
            switch (paramInt)
            {
                default:
                    return;
                case 1:
                    if (Log.D)
                        Log.d(a, "MainFrameActivity toTargetActivity() -->> MODULE_ID_HOME");
                    b();
                    return;
                case 51:
                    if (Log.D)
                        Log.d(a, "MainFrameActivity toTargetActivity() -->> MODULE_ID_MESSAGE_ACTION");
                    localObject1 = ((Bundle)localObject2).getString("a");
                    if ((paramBundle == null) || (TextUtils.isEmpty((CharSequence)localObject1)))
                        continue;
                    localObject2 = new URLParamMap();
                    ((URLParamMap)localObject2).put("to", (String)localObject1);
                    CommonUtil.getInstance().forwardWebActivity(paramBundle, "to", (URLParamMap)localObject2);
                    return;
                case 2:
                    boolean bool = Log.D;
                    a(new Intent(this.c, MyMessageShow.class));
                    return;
                case 6:
                    if (Log.D)
                        Log.d(a, "MainFrameActivity toTargetActivity() -->> MODULE_ID_MESSAGE_LIST");
                    a(new Intent(this.c, MyMessageBox.class));
                    return;
                case 13:
                    if (Log.D)
                        Log.d(a, "MainFrameActivity toTargetActivity() -->> MODULE_ID_CATEGORY");
                    paramBundle = new Bundle();
                    paramBundle.putInt("to", 1);
                    c(paramBundle);
                    return;
                case 3:
                    if (Log.D)
                        Log.d(a, "MainFrameActivity toTargetActivity() -->> MODULE_ID_SEARCH");
                    JDMtaUtils.sendCommonData(this.c, "Home_Search", "", "", this.c, "", this.c.getClass(), "");
                    a(new Intent(this.c, SearchActivity.class));
                    return;
                case 4:
                    if (Log.D)
                        Log.d(a, "MainFrameActivity toTargetActivity() -->> MODULE_ID_PRODUCT");
                    paramBundle = ((Bundle)localObject2).getString("unionId");
                    if (((Bundle)localObject2).getInt("jumpFrom") != 0)
                        paramBundle = new SourceEntity("phoneOnly", ((Bundle)localObject2).getString("sourceValue"));
                    while (true)
                    {
                        bp.a(this.c, (Bundle)localObject2, paramBundle);
                        return;
                        if (TextUtils.isEmpty(paramBundle))
                        {
                            paramBundle = new SourceEntity("widget", null);
                            continue;
                        }
                        paramBundle = new SourceEntity("cps", paramBundle);
                    }
                case 5:
                    if (Log.D)
                        Log.d(a, "MainFrameActivity toTargetActivity() -->> MODULE_ID_TOKEN");
                    paramBundle = ((Bundle)localObject2).getString("tokenKey");
                    localObject1 = ((Bundle)localObject2).getString("payId");
                    localObject3 = ((Bundle)localObject2).getString("isBind");
                    localObject4 = ((Bundle)localObject2).getString("toMSM");
                    String str1 = ((Bundle)localObject2).getString("action");
                    localObject6 = ((Bundle)localObject2).getString("num");
                    if (!TextUtils.isEmpty(paramBundle))
                        if (!TextUtils.isEmpty((CharSequence)localObject3))
                            CommonUtil.getInstance().toClient(((Bundle)localObject2).getString("tokenKey"), (String)localObject3, null);
                    while (this.c != null)
                    {
                        this.c.finish();
                        return;
                        if (!TextUtils.isEmpty((CharSequence)localObject4))
                        {
                            CommonUtil.getInstance().toClient(((Bundle)localObject2).getString("tokenKey"), (String)localObject4, null);
                            continue;
                        }
                        CommonUtil.getInstance().toClient(((Bundle)localObject2).getString("tokenKey"), "", null);
                        continue;
                        if (!TextUtils.isEmpty(str1))
                        {
                            if (str1.equals("login"))
                                CommonUtil.getInstance().toClient(null, str1, null);
                            while (Log.D)
                            {
                                System.out.println("jumpControll 监听点击去登陆按钮或者打电话+++++action:" + str1);
                                break;
                                if (!str1.equals("call"))
                                    continue;
                                CommonUtil.getInstance().toClient(null, str1, (String)localObject6);
                            }
                        }
                        if (TextUtils.isEmpty((CharSequence)localObject1))
                            continue;
                        CommonUtil.getInstance().unionAndWeiXinPay((Bundle)localObject2);
                    }
                case 7:
                    if (Log.D)
                        Log.d(a, "MainFrameActivity toTargetActivity() -->> MODULE_ID_BARCODE_PURCHASE");
                    if (Log.D)
                        Log.d(a, "showBarcodeActivity() -->> ");
                    if ((MyApplication.getInstance().getCurrentMyActivity() instanceof BarcodeActivity))
                        continue;
                    paramBundle = new Intent(this.c, CaptureActivity.class);
                    if (localObject2 != null)
                        paramBundle.putExtras((Bundle)localObject2);
                    a(paramBundle);
                    return;
                case 8:
                    if (Log.D)
                        Log.d(a, "showLimitBuyListActivity() -->> ");
                    paramBundle = MyApplication.getInstance().getCurrentMyActivity();
                    if ((paramBundle instanceof MiaoShaActivity))
                    {
                        paramBundle = (MiaoShaActivity)paramBundle;
                        if (!paramBundle.isFinishing())
                            paramBundle.finish();
                    }
                    paramBundle = new Intent(this.c, MiaoShaActivity.class);
                    if (localObject2 != null)
                        paramBundle.putExtras((Bundle)localObject2);
                    a(paramBundle);
                    return;
                case 9:
                    paramBundle = new Intent(this.c, LoginActivity.class);
                    paramBundle.putExtra("com.360buy:singleInstanceFlag", true);
                    paramBundle.putExtra("com.360buy:navigationDisplayFlag", -1);
                    if (localObject2 != null)
                    {
                        localObject1 = ((Bundle)localObject2).getString("from");
                        if (Log.D)
                        {
                            Log.d(a, "forwardLoginActivity from:" + (String)localObject1);
                            Log.d(a, "forwardLoginActivity bundle:" + localObject2);
                        }
                        if ((!TextUtils.isEmpty((CharSequence)localObject1)) && ("jdgame".equals(localObject1)))
                            paramBundle.putExtra("com.360buy:loginResendFlag", 2);
                        paramBundle.putExtras((Bundle)localObject2);
                    }
                    a(paramBundle);
                    return;
                case 10:
                    if (Log.D)
                        Log.d(a, "forwordRechargeActivity");
                    bp.a(MyApplication.getInstance().getCurrentMyActivity());
                    return;
                case 11:
                    CommonUtil.getInstance().forwardWebActivityWithWidget(paramBundle, "tuan");
                    return;
                case 12:
                    CommonUtil.getInstance().forwardWebActivityWithWidget(paramBundle, "lottery");
                    return;
                case 101:
                    paramBundle = ((Bundle)localObject2).getString("skuId");
                    if (Log.D)
                    {
                        Log.d(a, "forwardProductDetail skuId : " + paramBundle);
                        Log.d(a, "forwardProductDetail landPageId : " + ((Bundle)localObject2).getString("landPageId"));
                    }
                    if (TextUtils.isEmpty(paramBundle))
                        continue;
                    try
                    {
                        paramBundle = Long.valueOf(paramBundle);
                        bp.a(this.c, paramBundle, null, SourceEntity.getOpenAppSourceEntity((Bundle)localObject2));
                        return;
                    }
                    catch (Exception paramBundle)
                    {
                    }
                    if (!Log.E)
                        continue;
                    Log.d(a, "forwardProductDetail ", paramBundle);
                    return;
                case 102:
                    paramBundle = "";
                    localObject4 = "";
                case 109:
                case 123:
                case 103:
                    try
                    {
                        localObject3 = ((Bundle)localObject2).getString("skuId");
                        paramBundle = (Bundle)localObject3;
                        localObject1 = ((Bundle)localObject2).getString("packsId");
                        if ((!TextUtils.isEmpty((CharSequence)localObject3)) || (!TextUtils.isEmpty((CharSequence)localObject1)))
                        {
                            paramInt = a((Bundle)localObject2, "skuNum");
                            i = a((Bundle)localObject2, "packsNum");
                            paramBundle = MyApplication.getInstance().getCurrentMyActivity();
                            if (Log.D)
                            {
                                Log.d(a, "forwardShoppingCart skuId : " + (String)localObject3);
                                Log.d(a, "forwardShoppingCart packsId : " + (String)localObject1);
                                Log.d(a, "forwardShoppingCart skuNum : " + paramInt);
                                Log.d(a, "forwardShoppingCart packsNum : " + i);
                                Log.d(a, "forwardShoppingCart activity : " + paramBundle);
                                Log.d(a, "forwardShoppingCart landPageId : " + ((Bundle)localObject2).getString("landPageId"));
                            }
                            if (paramBundle != null)
                                qi.addProductOrPack(paramBundle, (String)localObject3, paramInt, (String)localObject1, i, SourceEntity.getOpenAppSourceEntity((Bundle)localObject2));
                        }
                        if (this.c == null)
                            continue;
                        paramBundle = new Intent(this.c, ShoppingCartNewActivity.class);
                        this.c.startActivity(paramBundle);
                        return;
                    }
                    catch (Exception localObject5)
                    {
                        int i;
                        while (true)
                        {
                            localObject3 = paramBundle;
                            localObject1 = localObject4;
                            if (!Log.D)
                                continue;
                            Log.d(a, "forwardShoppingCart skuId : " + paramBundle);
                            Log.d(a, "forwardShoppingCart packsId : " + "");
                            localException1.printStackTrace();
                            localObject3 = paramBundle;
                            localObject1 = localObject4;
                        }
                        paramBundle = "";
                        localObject4 = "";
                        if (Log.D)
                            Log.d(a, "forwardShoppingCartB bundle : " + localObject2 + " , toString : " + ((Bundle)localObject2).toString());
                        localObject1 = localObject4;
                        try
                        {
                            localObject3 = ((Bundle)localObject2).getString("skuId");
                            paramBundle = (Bundle)localObject3;
                            localObject1 = localObject4;
                            localObject5 = ((Bundle)localObject2).getString("packsId");
                            paramBundle = (Bundle)localObject3;
                            localObject1 = localObject5;
                            localObject4 = ((Bundle)localObject2).getString("skuList");
                            if (Log.D)
                            {
                                Log.d(a, "forwardShoppingCartB skuId : " + (String)localObject3);
                                Log.d(a, "forwardShoppingCartB packsId : " + (String)localObject5);
                                Log.d(a, "forwardShoppingCartB skuIdList : " + (String)localObject4);
                            }
                            paramBundle = MyApplication.getInstance().getCurrentMyActivity();
                            if ((!TextUtils.isEmpty((CharSequence)localObject3)) || (!TextUtils.isEmpty((CharSequence)localObject5)))
                            {
                                paramInt = a((Bundle)localObject2, "skuNum");
                                i = a((Bundle)localObject2, "packsNum");
                                if (paramBundle != null)
                                    qi.addProductOrPack(paramBundle, (String)localObject3, paramInt, (String)localObject5, i, SourceEntity.getOpenAppSourceEntity((Bundle)localObject2), false);
                                paramBundle = (BaseActivity)this.c;
                                if (paramBundle == null)
                                    continue;
                                paramBundle.startActivityInFrame(new Intent(paramBundle, ShoppingCartNewActivity.class));
                                return;
                            }
                        }
                        catch (Exception localException2)
                        {
                            while (true)
                            {
                                localObject3 = paramBundle;
                                localObject5 = localObject1;
                                localObject4 = localObject6;
                                if (!Log.D)
                                    continue;
                                Log.d(a, "forwardShoppingCartB skuId : " + paramBundle);
                                Log.d(a, "forwardShoppingCartB packsId : " + (String)localObject1);
                                localException2.printStackTrace();
                                localObject3 = paramBundle;
                                localObject5 = localObject1;
                                localObject4 = localObject6;
                                continue;
                                if (TextUtils.isEmpty((CharSequence)localObject4))
                                    continue;
                                a(paramBundle, (String)localObject4);
                            }
                        }
                        localObject4 = ((Bundle)localObject2).getString("activityId");
                    }
                    if (TextUtils.isEmpty((CharSequence)localObject4))
                        continue;
                    localObject6 = ((Bundle)localObject2).getString("type");
                    localObject3 = new Bundle();
                    ((Bundle)localObject3).putString("activityId", (String)localObject4);
                    ((Bundle)localObject3).putString("comeFrom", "m_destination");
                    localObject5 = ((Bundle)localObject2).getString("title");
                    ((Bundle)localObject3).putString("name", (String)localObject5);
                    ((Bundle)localObject3).putString("title", (String)localObject5);
                    ((Bundle)localObject3).putString("landPageId", ((Bundle)localObject2).getString("landPageId"));
                    if ("1".equals(localObject6))
                    {
                        paramBundle = new Intent(this.c, PromotionProductListActivity.class);
                        ((Bundle)localObject3).putString("content", ((Bundle)localObject2).getString("content"));
                    }
                    while (paramBundle != null)
                    {
                        paramBundle.putExtras((Bundle)localObject3);
                        paramBundle.putExtra("com.360buy:navigationDisplayFlag", -1);
                        a(paramBundle);
                        return;
                        paramBundle = (Bundle)localObject1;
                        if (!"2".equals(localObject6))
                            continue;
                        paramBundle = new Intent(this.c, ProductListActivity.class);
                        localObject1 = new Commercial();
                        ((Commercial)localObject1).setId((String)localObject4);
                        ((Commercial)localObject1).setTitle((String)localObject5);
                        paramBundle.putExtra("commercial", (Serializable)localObject1);
                    }
                case 107:
                    paramBundle = ((Bundle)localObject2).getString("promotionId");
                    if (TextUtils.isEmpty(paramBundle))
                        continue;
                    localObject1 = new Intent(this.c, PromotionMessageActivity.class);
                    localObject3 = new Bundle();
                    ((Bundle)localObject3).putString("promotion_id", paramBundle);
                    ((Bundle)localObject3).putString("name", ((Bundle)localObject2).getString("title"));
                    ((Bundle)localObject3).putString("comeFrom", "m_destination");
                    ((Bundle)localObject3).putString("landPageId", ((Bundle)localObject2).getString("landPageId"));
                    ((Intent)localObject1).putExtras((Bundle)localObject3);
                    ((Intent)localObject1).putExtra("com.360buy:navigationDisplayFlag", -1);
                    a((Intent)localObject1);
                    return;
                case 104:
                    paramBundle = new Intent(this.c, CommercialRuleActivity.class);
                    localObject1 = new Bundle();
                    ((Bundle)localObject1).putString("title", ((Bundle)localObject2).getString("title"));
                    ((Bundle)localObject1).putString("detail", ((Bundle)localObject2).getString("content"));
                    paramBundle.putExtras((Bundle)localObject1);
                    a(paramBundle);
                    return;
                case 105:
                    paramBundle = ((Bundle)localObject2).getString("action");
                    localObject2 = ((Bundle)localObject2).getString("url");
                    if ((TextUtils.isEmpty(paramBundle)) || (TextUtils.isEmpty((CharSequence)localObject2)))
                        continue;
                    localObject1 = new URLParamMap();
                    ((URLParamMap)localObject1).put("to", (String)localObject2);
                    localObject2 = new Intent(this.c, WebActivity.class);
                    localObject3 = new SerializableContainer();
                    ((SerializableContainer)localObject3).setMap((URLParamMap)localObject1);
                    ((Intent)localObject2).putExtra("urlParamMap", (Serializable)localObject3);
                    ((Intent)localObject2).putExtra("urlAction", paramBundle);
                    a((Intent)localObject2);
                    return;
                case 106:
                    if (!(this.c instanceof BaseActivity))
                        continue;
                    paramBundle = new g(this, (Bundle)localObject2);
                    localObject1 = ((Bundle)localObject2).getString("needLogin");
                    if ((TextUtils.isEmpty((CharSequence)localObject1) | "0".equals(localObject1)))
                    {
                        ((BaseActivity)this.c).post(paramBundle);
                        return;
                    }
                    if (!"1".equals(localObject1))
                        continue;
                    LoginUser.getInstance().executeLoginRunnable((BaseActivity)this.c, paramBundle);
                    return;
                case 108:
                    if (Log.D)
                        Log.d(a, "forwardMyJd -->> ");
                    ((Bundle)localObject2).putInt("to", 4);
                    c((Bundle)localObject2);
                    return;
                case 200:
                    an.a().a(MyApplication.getInstance().getCurrentMyActivity(), aw.b());
                    return;
                case 208:
                    if (LoginUserBase.hasLogin())
                    {
                        an.a((Bundle)localObject2);
                        return;
                    }
                    paramBundle = new Intent(MyApplication.getInstance().getCurrentMyActivity(), LoginActivity.class);
                    paramBundle.putExtra("im_from_web", (Bundle)localObject2);
                    paramBundle.putExtra("com.360buy:loginResendFlag", 14);
                    MyApplication.getInstance().getCurrentMyActivity().startActivityInFrame(paramBundle);
                    return;
                case 201:
                    paramBundle = (Bundle)localObject3;
                    if (localObject2 != null)
                        paramBundle = (Bundle)localObject3;
                case 202:
                case 110:
                case 129:
                case 111:
                case 112:
                case 113:
                case 114:
                case 115:
                case 116:
                case 121:
                case 117:
                case 118:
                case 119:
                case 122:
                case 124:
                case 206:
                case 213:
                case 214:
                case 125:
                case 126:
                case 127:
                case 203:
                case 128:
                case 204:
                case 205:
                case 207:
                case 209:
                case 210:
                case 211:
                case 212:
                case 215:
                case 216:
                case 218:
                case 217:
                case 219:
                case 221:
                case 222:
                case 223:
                case 224:
                case 225:
                case 226:
                case 227:
                case 228:
                case 229:
                case 230:
                case 231:
                case 232:
                case 233:
                case 234:
                case 235:
                case 236:
                case 237:
                case 239:
                case 238:
                case 240:
                case 241:
                case 242:
                case 243:
                case 244:
                case 245:
                case 246:
                case 247:
                    try
                    {
                        if (((Bundle)localObject2).containsKey("orgId"))
                            paramBundle = ((Bundle)localObject2).getInt("orgId");
                        if (!TextUtils.isEmpty(paramBundle))
                        {
                            localObject1 = MyApplication.getInstance().getCurrentMyActivity();
                            paramBundle = au.b(paramBundle);
                            an.a().a((Context)localObject1, paramBundle);
                            return;
                        }
                        paramBundle = MyApplication.getInstance().getCurrentMyActivity();
                        localObject1 = au.c();
                        an.a().a(paramBundle, (au)localObject1);
                        return;
                        if (!LoginUser.hasLogin())
                        {
                            ax.a(MyApplication.getInstance().getCurrentMyActivity(), (Bundle)localObject2);
                            return;
                        }
                        ax.b(MyApplication.getInstance().getCurrentMyActivity(), (Bundle)localObject2);
                        return;
                        if (Log.D)
                            Log.d(a, " -->> forwardJshop ");
                        paramBundle = new JSONObject();
                        try
                        {
                            localObject1 = ((Bundle)localObject2).getString("venderId");
                            localObject3 = ((Bundle)localObject2).getString("shopname");
                            if (!TextUtils.isEmpty((CharSequence)localObject1))
                                paramBundle.put("venderId", ((Bundle)localObject2).getString("venderId"));
                            if (!TextUtils.isEmpty((CharSequence)localObject3))
                                paramBundle.put("shopname", ((Bundle)localObject2).getString("shopName"));
                            paramBundle.put("shopId", ((Bundle)localObject2).getString("shopId"));
                            if (Log.D)
                            {
                                Log.d(a, "forwardJshop venderId : " + ((Bundle)localObject2).getString("venderId"));
                                Log.d(a, "forwardJshop shopname : " + ((Bundle)localObject2).getString("shopname"));
                                Log.d(a, "forwardJshop shopId : " + ((Bundle)localObject2).getString("shopId"));
                            }
                            ((Bundle)localObject2).putString("brand.json", paramBundle.toString());
                            paramBundle = SourceEntity.getOpenAppSourceEntity((Bundle)localObject2);
                            bp.b(this.c, (Bundle)localObject2, paramBundle);
                            return;
                        }
                        catch (JSONException paramBundle)
                        {
                        }
                        if (!Log.D)
                            continue;
                        paramBundle.printStackTrace();
                        return;
                        if ((this.c == null) || (localObject2 == null))
                            continue;
                        paramBundle = new Intent(this.c, CouponMainActivity.class);
                        paramBundle.putExtras((Bundle)localObject2);
                        this.c.startActivity(paramBundle);
                        return;
                        localObject3 = ((Bundle)localObject2).getString("title", "");
                        localObject4 = ((Bundle)localObject2).getString("content", "");
                        localObject5 = ((Bundle)localObject2).getString("shareUrl", "");
                        localObject6 = ((Bundle)localObject2).getString("iconUrl", "");
                        String str2 = ((Bundle)localObject2).getString("from", "");
                        localObject1 = ((Bundle)localObject2).getString("channel", "");
                        paramBundle = ((Bundle)localObject2).getString("shareActionType", "");
                        if (Log.D)
                        {
                            Log.d(a, "current activity: " + this.c.getClass().getName());
                            Log.d(a, " forwardShare -->> title : " + (String)localObject3 + ", content : " + (String)localObject4 + ", shareUrl : " + (String)localObject5 + ", iconUrl : " + (String)localObject6 + ", from : " + str2);
                        }
                        localObject2 = new ShareInfo((String)localObject3, (String)localObject4, (String)localObject4, (String)localObject5, this.c.getString(2131233884, new Object[] { localObject5 }), str2, (String)localObject6, null);
                        if (!TextUtils.isEmpty((CharSequence)localObject1))
                            ((ShareInfo)localObject2).setChannels((String)localObject1);
                        if (TextUtils.isEmpty(paramBundle))
                        {
                            if (((ShareInfo)localObject2).getChannels().contains(","));
                            for (paramBundle = "P"; paramBundle.equals("O"); paramBundle = "O")
                            {
                                ShareUtil.sendShare((BaseActivity)this.c, (ShareInfo)localObject2, null);
                                return;
                            }
                            ShareUtil.showShareDialog((BaseActivity)this.c, (ShareInfo)localObject2);
                            return;
                            paramBundle = ((Bundle)localObject2).getString("dmurl");
                            localObject1 = ((Bundle)localObject2).getString("shareUrl");
                            localObject3 = ((Bundle)localObject2).getString("shareContent");
                            localObject4 = ((Bundle)localObject2).getString("shareTitle");
                            localObject5 = ((Bundle)localObject2).getString("shareAvatar");
                            localObject2 = SourceEntity.getOpenAppSourceEntity((Bundle)localObject2);
                            if (Log.D)
                                Log.d("TEST", " -->> dmUrl : " + paramBundle);
                            if (localObject2 != null)
                            {
                                paramBundle = paramBundle + "?resourceType=" + ((SourceEntity)localObject2).getSourceType() + "&resourceValue=" + ((SourceEntity)localObject2).getSourceValue();
                                if (TextUtils.isEmpty(paramBundle))
                                    continue;
                                if (!TextUtils.isEmpty((CharSequence)localObject1))
                                {
                                    localObject1 = new ShareInfo((String)localObject1, (String)localObject4, (String)localObject3, (String)localObject5, "");
                                    CommonUtil.goToMWithUrlShareInfo(MyApplication.getInstance().getCurrentMyActivity(), paramBundle, (ShareInfo)localObject1);
                                    return;
                                }
                                CommonUtil.goToMWithUrl(MyApplication.getInstance().getCurrentMyActivity(), paramBundle);
                                return;
                                paramBundle = ((Bundle)localObject2).getString("type");
                                localObject1 = ((Bundle)localObject2).getString("ctype");
                                localObject3 = ((Bundle)localObject2).getString("functionId");
                                localObject4 = ((Bundle)localObject2).getString("classParam");
                                SourceEntity.getOpenAppSourceEntity((Bundle)localObject2);
                                if (Log.D)
                                    Log.d("TEST", " -->> functionId : " + (String)localObject3);
                                if (TextUtils.isEmpty(paramBundle))
                                    continue;
                                if ("5".equals(paramBundle))
                                {
                                    if ("1".equals(localObject1))
                                    {
                                        bp.a(MyApplication.getInstance().getCurrentMyActivity(), (String)localObject4);
                                        return;
                                    }
                                    if (("2".equals(localObject1)) || (TextUtils.isEmpty((CharSequence)localObject3)))
                                        continue;
                                    CommonUtil.getInstance().forwardWebActivity(c(), (String)localObject3);
                                    return;
                                }
                                if ("7".equals(paramBundle))
                                {
                                    paramBundle = new e(this);
                                    LoginUser.getInstance().executeLoginRunnable(MyApplication.getInstance().getCurrentMyActivity(), paramBundle);
                                    return;
                                }
                                "9".equals(paramBundle);
                                return;
                                ((Bundle)localObject2).putInt("to", 2);
                                c((Bundle)localObject2);
                                return;
                                if (c().getClass() == ProductListActivity.class)
                                    continue;
                                paramBundle = new Intent(this.c, ProductListActivity.class);
                                localObject1 = ((Bundle)localObject2).getString("from");
                                localObject3 = ((Bundle)localObject2).getString("");
                                localObject4 = ((Bundle)localObject2).getString("");
                                if ((!TextUtils.isEmpty((CharSequence)localObject3)) && (!TextUtils.isEmpty((CharSequence)localObject4)))
                                    paramBundle.putExtra("source", new SourceEntity((String)localObject3, (String)localObject4));
                                if (Log.D)
                                {
                                    Log.d(a, "toProductListActivity() -->> from = " + (String)localObject1);
                                    Log.d(a, "toProductListActivity() -->> sourceType = " + (String)localObject3);
                                    Log.d(a, "toProductListActivity() -->> sourceValue = " + (String)localObject4);
                                }
                                if (TextUtils.equals((CharSequence)localObject1, "search"))
                                {
                                    localObject1 = ((Bundle)localObject2).getString("keyWord");
                                    localObject3 = new Bundle();
                                    if (!TextUtils.isEmpty((CharSequence)localObject1))
                                        ((Bundle)localObject3).putString("keyWord", (String)localObject1);
                                    ((Bundle)localObject3).putBoolean("firstToList", true);
                                    if (((Bundle)localObject2).getInt("is_allworld_shopping", 0) == 0)
                                    {
                                        paramBundle.putExtra("is_allworld_shopping", false);
                                        label4630: if ("1".equals(((Bundle)localObject2).getString("is_allworld_shopping")))
                                            paramBundle.putExtra("is_allworld_shopping", true);
                                        paramBundle.putExtras((Bundle)localObject3);
                                        paramBundle.putExtra("sortKey", -2);
                                    }
                                }
                                while (true)
                                {
                                    a(paramBundle);
                                    return;
                                    paramBundle.putExtra("is_allworld_shopping", true);
                                    break label4630;
                                    if (TextUtils.equals((CharSequence)localObject1, "category"))
                                    {
                                        paramBundle.putExtra("sortKey", 5);
                                        localObject1 = ((Bundle)localObject2).getString("cid");
                                        localObject3 = ((Bundle)localObject2).getString("levelFirst");
                                        localObject4 = ((Bundle)localObject2).getString("levelSecond");
                                        localObject5 = ((Bundle)localObject2).getString("title");
                                        paramInt = ((Bundle)localObject2).getInt("is_allworld_shopping", 0);
                                        localObject6 = new Bundle();
                                        if (!TextUtils.isEmpty((CharSequence)localObject5))
                                            ((Bundle)localObject6).putString("name", (String)localObject5);
                                        if (!TextUtils.isEmpty((CharSequence)localObject1))
                                            ((Bundle)localObject6).putString("cid", (String)localObject1);
                                        if (!TextUtils.isEmpty((CharSequence)localObject3))
                                            ((Bundle)localObject6).putString("levelFirst", (String)localObject3);
                                        if (!TextUtils.isEmpty((CharSequence)localObject4))
                                            ((Bundle)localObject6).putString("levelSecond", (String)localObject4);
                                        if (paramInt == 0)
                                            paramBundle.putExtra("is_allworld_shopping", false);
                                        while (true)
                                        {
                                            if ("1".equals(((Bundle)localObject2).getString("is_allworld_shopping")))
                                                paramBundle.putExtra("is_allworld_shopping", true);
                                            ((Bundle)localObject6).putBoolean("firstToList", true);
                                            paramBundle.putExtras((Bundle)localObject6);
                                            break;
                                            paramBundle.putExtra("is_allworld_shopping", true);
                                        }
                                    }
                                    if (!TextUtils.equals((CharSequence)localObject1, "promotion"))
                                        break;
                                    localObject1 = ((Bundle)localObject2).getString("activityId");
                                    localObject3 = ((Bundle)localObject2).getString("skuId");
                                    localObject2 = ((Bundle)localObject2).getString("tip");
                                    localObject4 = new Bundle();
                                    if (!TextUtils.isEmpty((CharSequence)localObject1))
                                        ((Bundle)localObject4).putString("activityId", (String)localObject1);
                                    if (!TextUtils.isEmpty((CharSequence)localObject3))
                                        ((Bundle)localObject4).putString("skuId", (String)localObject3);
                                    if (!TextUtils.isEmpty((CharSequence)localObject2))
                                        ((Bundle)localObject4).putString("tip", (String)localObject2);
                                    ((Bundle)localObject4).putBoolean("firstToList", true);
                                    paramBundle.putExtras((Bundle)localObject4);
                                    paramBundle.putExtra("sortKey", -2);
                                }
                                com.jingdong.common.bing.b.a((BaseActivity)this.c, true);
                                return;
                                paramBundle = new Intent(this.c, Activities.class);
                                paramBundle.putExtra("com.360buy:navigationDisplayFlag", -1);
                                a(paramBundle);
                                return;
                                a("zhangshangmiaosha", (Bundle)localObject2);
                                paramBundle = new Intent(MyApplication.getInstance().getCurrentMyActivity(), MiaoShaActivity.class);
                                paramBundle.putExtra("source", new SourceEntity("indexMiaoShaArea", ""));
                                paramBundle.putExtra("com.360buy:navigationDisplayFlag", -1);
                                paramBundle.putExtra("com.360buy:clearHistoryFlag", true);
                                paramBundle.putExtras((Bundle)localObject2);
                                MyApplication.getInstance().getCurrentMyActivity().startActivityInFrame(paramBundle);
                                return;
                                if (LoginUserBase.hasLogin())
                                {
                                    paramBundle = new Intent(MyApplication.getInstance().getCurrentMyActivity(), MyGoodsOrderListActivity.class);
                                    paramBundle.putExtra("com.360buy:navigationDisplayFlag", -1);
                                    MyApplication.getInstance().getCurrentMyActivity().startActivityInFrame(paramBundle);
                                    return;
                                }
                                paramBundle = new Intent(MyApplication.getInstance().getCurrentMyActivity(), LoginActivity.class);
                                paramBundle.putExtra("com.360buy:loginResendFlag", 10);
                                MyApplication.getInstance().getCurrentMyActivity().startActivityInFrame(paramBundle);
                                return;
                                if (localObject2 == null)
                                    continue;
                                paramBundle = ((Bundle)localObject2).getString("orderid");
                                if (TextUtils.isEmpty(paramBundle))
                                    continue;
                                localObject1 = CommonUtil.gotoLastone(MyApplication.getInstance().getCurrentMyActivity());
                                ((Intent)localObject1).putExtra("orderId", paramBundle);
                                MyApplication.getInstance().getCurrentMyActivity().startActivityInFrameWithNoNavigation((Intent)localObject1);
                                return;
                                a("kanakan", (Bundle)localObject2);
                                paramBundle = new Intent(this.c, KanAKanActivity.class);
                                paramBundle.putExtras((Bundle)localObject2);
                                paramBundle.putExtra("com.360buy:navigationDisplayFlag", -1);
                                a(paramBundle);
                                return;
                                if (this.c == null)
                                    continue;
                                bp.a(this.c, (Bundle)localObject2);
                                return;
                                if (this.c == null)
                                    continue;
                                localObject1 = this.c;
                                if ((localObject1 == null) || ((localObject1 instanceof FlightListActivity)) || ((localObject1 instanceof IntFlightListActivity)))
                                    continue;
                                localObject3 = ((Bundle)localObject2).getString("international");
                                if ("false".equals(localObject3))
                                    paramBundle = new Intent(((Activity)localObject1).getApplicationContext(), FlightListActivity.class);
                                while (paramBundle != null)
                                {
                                    paramBundle.putExtra("com.360buy:clearTopFlag", true);
                                    if (localObject2 != null)
                                        paramBundle.putExtras((Bundle)localObject2);
                                    ((Activity)localObject1).startActivity(paramBundle);
                                    return;
                                    paramBundle = (Bundle)localObject4;
                                    if (!"true".equals(localObject3))
                                        continue;
                                    paramBundle = new Intent(((Activity)localObject1).getApplicationContext(), IntFlightListActivity.class);
                                }
                                Log.d("ActivityJumpController", "forward MODULE_ID_AIRINORDER");
                                if (this.c == null)
                                    continue;
                                bp.a(this.c, (Bundle)localObject2, "1");
                                return;
                                Log.d("ActivityJumpController", "forward MODULE_ID_AIREXORDER");
                                if (this.c == null)
                                    continue;
                                bp.a(this.c, (Bundle)localObject2, "2");
                                return;
                                a("zhidemai", (Bundle)localObject2);
                                paramBundle = new Intent(this.c, GoodActivity.class);
                                paramBundle.putExtra("com.360buy:navigationDisplayFlag", -1);
                                a(paramBundle);
                                return;
                                a("shoujizhuanxiang", (Bundle)localObject2);
                                paramBundle = new Intent(this.c, JDMobileChannel.class);
                                paramBundle.putExtra("com.360buy:navigationDisplayFlag", -1);
                                paramBundle.putExtras((Bundle)localObject2);
                                a(paramBundle);
                                return;
                                a("jingpintuijian", (Bundle)localObject2);
                                paramBundle = new Intent(this.c, JDMobileChannel.class);
                                paramBundle.putExtras((Bundle)localObject2);
                                paramBundle.putExtra("functionId", "niceGoods");
                                paramBundle.putExtra("bid", "niceGoods");
                                paramBundle.putExtra("com.360buy:navigationDisplayFlag", -1);
                                a(paramBundle);
                                return;
                                if (this.c == null)
                                    continue;
                                paramBundle = this.c;
                                if ((paramBundle == null) || ((paramBundle instanceof MovieActivity)))
                                    continue;
                                localObject1 = new Intent(paramBundle.getApplicationContext(), MovieActivity.class);
                                ((Intent)localObject1).putExtra("com.360buy:clearTopFlag", true);
                                if (localObject2 != null)
                                    ((Intent)localObject1).putExtras((Bundle)localObject2);
                                paramBundle.startActivity((Intent)localObject1);
                                return;
                                paramBundle = new Intent(this.c, Faxian4EventActivity.class);
                                paramBundle.putExtra("com.360buy:navigationDisplayFlag", -1);
                                a(paramBundle);
                                return;
                                if (localObject2 == null)
                                    continue;
                                paramBundle = ((Bundle)localObject2).getString("cid");
                                localObject1 = new Intent(this.c, JshopDynaFragmentActivity.class);
                                ((Intent)localObject1).putExtra("from", "其它");
                                ((Intent)localObject1).putExtra("cid", paramBundle);
                                ((Intent)localObject1).putExtra("currentTab", 3);
                                a((Intent)localObject1);
                                return;
                                if (LoginUserBase.hasLogin())
                                {
                                    com.jingdong.common.deeplinkhelper.b.a(c());
                                    return;
                                }
                                paramBundle = new Intent(MyApplication.getInstance().getCurrentMyActivity(), LoginActivity.class);
                                paramBundle.putExtra("com.360buy:loginResendFlag", 12);
                                MyApplication.getInstance().getCurrentMyActivity().startActivityInFrame(paramBundle);
                                return;
                                if (LoginUserBase.hasLogin())
                                {
                                    paramBundle = new Intent();
                                    paramBundle.setClass(this.c, OrderDetailActivity.class);
                                    paramBundle.putExtra("orderId", ((Bundle)localObject2).getString("orderId"));
                                    paramBundle.putExtra("title", this.c.getString(2131232896));
                                    paramBundle.putExtra("com.360buy:navigationDisplayFlag", -1);
                                    MyApplication.getInstance().getCurrentMyActivity().startActivityInFrame(paramBundle);
                                    return;
                                }
                                paramBundle = new Intent(MyApplication.getInstance().getCurrentMyActivity(), LoginActivity.class);
                                paramBundle.putExtra("com.360buy:loginResendFlag", 13);
                                paramBundle.putExtra("orderId", ((Bundle)localObject2).getString("orderId"));
                                paramBundle.putExtra("title", this.c.getString(2131232896));
                                MyApplication.getInstance().getCurrentMyActivity().startActivityInFrame(paramBundle);
                                return;
                                d();
                                return;
                                d((Bundle)localObject2);
                                return;
                                a((Bundle)localObject2);
                                return;
                                b((Bundle)localObject2);
                                return;
                                e((Bundle)localObject2);
                                return;
                                f((Bundle)localObject2);
                                return;
                                h((Bundle)localObject2);
                                return;
                                g((Bundle)localObject2);
                                return;
                                paramBundle = ((Bundle)localObject2).getString("categoryIds");
                                com.jingdong.common.ranking.c.a(this.c, "", "", paramBundle, "", "Separatepage", "rank3001");
                                return;
                                paramInt = ((Bundle)localObject2).getInt("jumpFrom");
                                if (paramInt == 1)
                                {
                                    com.jingdong.common.ranking.c.a(this.c, "AppHome");
                                    return;
                                }
                                if (paramInt == 2)
                                {
                                    com.jingdong.common.ranking.c.a(this.c, "Applications");
                                    return;
                                }
                                if (paramInt == 5)
                                {
                                    com.jingdong.common.ranking.c.a(this.c, "MyJD");
                                    return;
                                }
                                paramBundle = ((Bundle)localObject2).getString("from");
                                com.jingdong.common.ranking.c.a(this.c, paramBundle);
                                return;
                                e();
                                return;
                                f();
                                return;
                                g();
                                return;
                                h();
                                return;
                                i();
                                return;
                                i((Bundle)localObject2);
                                return;
                                j((Bundle)localObject2);
                                return;
                                k((Bundle)localObject2);
                                return;
                                a(new Intent(this.c, NearbyListActivity.class));
                                return;
                                l((Bundle)localObject2);
                                return;
                                a(0);
                                return;
                                a(1);
                                return;
                                m((Bundle)localObject2);
                                return;
                                n((Bundle)localObject2);
                                return;
                                o((Bundle)localObject2);
                                return;
                                j();
                                return;
                                p((Bundle)localObject2);
                                return;
                                q((Bundle)localObject2);
                                return;
                                r((Bundle)localObject2);
                                return;
                                k();
                                return;
                                l();
                                return;
                                s((Bundle)localObject2);
                                return;
                                t((Bundle)localObject2);
                                return;
                                u((Bundle)localObject2);
                                return;
                                v((Bundle)localObject2);
                                return;
                                paramBundle = ((Bundle)localObject2).getString("pageType");
                                if ("mysign".equals(paramBundle))
                                {
                                    LoginUser.getInstance().executeLoginRunnable(MyApplication.getInstance().getCurrentMyActivity(), new b(this, paramBundle));
                                    return;
                                }
                                ReactActivityUtils.startReactNativeSRListActivity(this.c, paramBundle);
                                return;
                            }
                        }
                    }
                    catch (Exception paramBundle)
                    {
                        while (true)
                        {
                            paramBundle = (Bundle)localObject3;
                            continue;
                            continue;
                        }
                    }
            }
        }
    }

    public final void b()
    {
        Bundle localBundle = new Bundle();
        localBundle.putInt("to", 0);
        c(localBundle);
    }

    public final void b(Activity paramActivity)
    {
        if ((paramActivity != null) && (paramActivity == this.c))
        {
            if (Log.D)
                Log.d(a, "unRegistration() set null " + paramActivity.getClass().getSimpleName());
            this.c = null;
        }
    }
}
