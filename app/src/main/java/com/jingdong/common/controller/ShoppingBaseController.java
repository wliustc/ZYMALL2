package com.jingdong.common.controller;

import com.zy.common.utils.CommonUtil;
import com.zy.common.utils.Log;

/**
 * Created by Robin on 2016/11/4.
 */
public class ShoppingBaseController {
    private static final String SHARED_PREFERENCES_SHOPPING_CART_COUNT = "shoppingCartCount";
    private static final String TAG = "ShoppingController";
//    private static bw iCommon;

//    public static void addMultiProductOrPack(IMyActivity paramIMyActivity, ArrayList<Product> paramArrayList, ArrayList<Pack> paramArrayList1, SourceEntity paramSourceEntity, ShoppingBaseController.ShoppingListener paramShoppingListener)
//    {
//        if ((paramIMyActivity == null) || ((paramArrayList == null) && (paramArrayList1 == null)))
//            return;
//        paramSourceEntity = new ArrayList();
//        String str;
//        if (paramArrayList != null)
//        {
//            localObject = paramArrayList.iterator();
//            while (((Iterator)localObject).hasNext())
//            {
//                paramArrayList = (Product)((Iterator)localObject).next();
//                if (paramArrayList == null)
//                    continue;
//                str = paramArrayList.getId();
//                if (paramArrayList.getNum().intValue() == 0);
//                for (paramArrayList = Integer.valueOf(1); ; paramArrayList = paramArrayList.getNum())
//                {
//                    paramSourceEntity.add(new CartSkuSummary(str, paramArrayList));
//                    break;
//                }
//            }
//        }
//        Object localObject = new ArrayList();
//        if (paramArrayList1 != null)
//        {
//            paramArrayList1 = paramArrayList1.iterator();
//            while (paramArrayList1.hasNext())
//            {
//                paramArrayList = (Pack)paramArrayList1.next();
//                if (paramArrayList == null)
//                    continue;
//                str = String.valueOf(paramArrayList.getId());
//                if (paramArrayList.getNum().intValue() == 0);
//                for (paramArrayList = Integer.valueOf(1); ; paramArrayList = paramArrayList.getNum())
//                {
//                    ((ArrayList)localObject).add(new CartPackSummary(str, paramArrayList));
//                    break;
//                }
//            }
//        }
//        addMultiProductToCart(paramIMyActivity, paramSourceEntity, (ArrayList)localObject, paramShoppingListener, true);
//    }
//
//    public static void addMultiProductToCart(IMyActivity paramIMyActivity, ArrayList<CartSkuSummary> paramArrayList, ArrayList<CartPackSummary> paramArrayList1, ShoppingBaseController.ShoppingListener paramShoppingListener, boolean paramBoolean)
//    {
//        addMultiProductToCart(paramIMyActivity, paramArrayList, paramArrayList1, paramShoppingListener, paramBoolean, true, true);
//    }
//
//    public static void addMultiProductToCart(IMyActivity paramIMyActivity, ArrayList<CartSkuSummary> paramArrayList, ArrayList<CartPackSummary> paramArrayList1, ShoppingBaseController.ShoppingListener paramShoppingListener, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
//    {
//        if (((paramArrayList == null) || (paramArrayList.size() == 0)) && ((paramArrayList1 == null) || (paramArrayList1.size() == 0)))
//            return;
//        paramArrayList = new CartRequest(new CartRequestOperate(paramArrayList, paramArrayList1, "2"));
//        paramArrayList.setNoResponse(Boolean.valueOf(paramBoolean1));
//        syncCartAddNoCache(paramIMyActivity, paramArrayList, new ShoppingBaseController.ShoppingHttpListener(paramShoppingListener), paramBoolean2, paramBoolean3);
//    }
//
//    public static void addNewYbAdd(gm paramgm, IMyActivity paramIMyActivity, ArrayList<CartResponseNewYBDetail> paramArrayList, ShoppingBaseController.ShoppingWithoutListener paramShoppingWithoutListener)
//    {
//        int i = 1;
//        if (Log.D)
//            Log.d("ShoppingController", " addOrDeleteYb -->> myActivity:" + paramIMyActivity + ", currentSelectYBList:" + paramArrayList + ", listener:" + paramShoppingWithoutListener);
//        if (paramArrayList != null);
//        Object localObject;
//        while (true)
//        {
//            try
//            {
//                if (paramArrayList.size() > 0)
//                {
//                    localObject = (CartResponseNewYBDetail)paramArrayList.get(0);
//                    if (localObject == null)
//                        break;
//                    if (((CartResponseNewYBDetail)localObject).getPlatformNum() == null)
//                        continue;
//                    i = Integer.parseInt(((CartResponseNewYBDetail)localObject).getPlatformNum());
//                    if (TextUtils.isEmpty(((CartResponseNewYBDetail)localObject).getrSuitId()))
//                        break label211;
//                    localObject = new CartPackSummary(((CartResponseNewYBDetail)localObject).getSkuId(), ((CartResponseNewYBDetail)localObject).getrSuitId(), Integer.valueOf(i), "7");
//                    paramArrayList = paramArrayList.iterator();
//                    if (!paramArrayList.hasNext())
//                        break label280;
//                    ((CartPackSummary)localObject).addSku(new CartSkuSummary(((CartResponseNewYBDetail)paramArrayList.next()).getPlatformId(), Integer.valueOf(i)));
//                    continue;
//                }
//            }
//            catch (Exception paramgm)
//            {
//                if (Log.E)
//                {
//                    Log.e("ShoppingController", " -->> " + paramgm.getMessage());
//                    paramgm.printStackTrace();
//                }
//            }
//            return;
//            label211: localObject = new CartPackSummary(((CartResponseNewYBDetail)localObject).getSkuId(), Integer.valueOf(i), "8");
//        }
//        while (true)
//        {
//            paramArrayList = new CartRequest(new CartRequestOperate(null, paramArrayList, "2"));
//            paramArrayList.setModelGroupUtil(paramgm);
//            syncCartAdd(paramIMyActivity, paramArrayList, new ShoppingBaseController.HttpWithoutUpdateListener(paramShoppingWithoutListener), true, false);
//            return;
//            paramArrayList = null;
//            continue;
//            label280: paramArrayList = (ArrayList<CartResponseNewYBDetail>)localObject;
//        }
//    }
//
//    public static void addNewYbAddNOCache(IMyActivity paramIMyActivity, ArrayList<CartResponseNewYBDetail> paramArrayList, ShoppingBaseController.ShoppingListener paramShoppingListener)
//    {
//        int i = 1;
//        if (Log.D)
//            Log.d("ShoppingController", " addOrDeleteYb -->> myActivity:" + paramIMyActivity + ", currentSelectYBList:" + paramArrayList + ", listener:" + paramShoppingListener);
//        if (paramArrayList != null);
//        Object localObject;
//        while (true)
//        {
//            try
//            {
//                if (paramArrayList.size() > 0)
//                {
//                    localObject = (CartResponseNewYBDetail)paramArrayList.get(0);
//                    if (localObject == null)
//                        break;
//                    if (((CartResponseNewYBDetail)localObject).getPlatformNum() == null)
//                        continue;
//                    i = Integer.parseInt(((CartResponseNewYBDetail)localObject).getPlatformNum());
//                    if (TextUtils.isEmpty(((CartResponseNewYBDetail)localObject).getrSuitId()))
//                        break label202;
//                    localObject = new CartPackSummary(((CartResponseNewYBDetail)localObject).getSkuId(), ((CartResponseNewYBDetail)localObject).getrSuitId(), Integer.valueOf(i), "7");
//                    paramArrayList = paramArrayList.iterator();
//                    if (!paramArrayList.hasNext())
//                        break label262;
//                    ((CartPackSummary)localObject).addSku(new CartSkuSummary(((CartResponseNewYBDetail)paramArrayList.next()).getPlatformId(), Integer.valueOf(i)));
//                    continue;
//                }
//            }
//            catch (Exception paramIMyActivity)
//            {
//                if (Log.E)
//                {
//                    Log.e("ShoppingController", " -->> " + paramIMyActivity.getMessage());
//                    paramIMyActivity.printStackTrace();
//                }
//            }
//            return;
//            label202: localObject = new CartPackSummary(((CartResponseNewYBDetail)localObject).getSkuId(), Integer.valueOf(i), "8");
//        }
//        while (true)
//        {
//            syncCartAddNoCache(paramIMyActivity, new CartRequest(new CartRequestOperate(null, paramArrayList, "2")), new ShoppingBaseController.ShoppingHttpListener(paramShoppingListener), true, false);
//            return;
//            paramArrayList = null;
//            continue;
//            label262: paramArrayList = (ArrayList<CartResponseNewYBDetail>)localObject;
//        }
//    }
//
//    public static void addOnePack(IMyActivity paramIMyActivity, Pack paramPack)
//    {
//        addOnePack(paramIMyActivity, paramPack, false, false, false);
//    }
//
//    public static void addOnePack(IMyActivity paramIMyActivity, Pack paramPack, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
//    {
//        if (Log.D)
//            Log.d("ShoppingController", " addOnePack -->> myActivity:" + paramIMyActivity + ", addPack:" + paramPack);
//        if ((paramIMyActivity == null) || (paramPack == null) || (paramPack.getId() == null))
//            return;
//        ShoppingBaseController.3 local3 = new ShoppingBaseController.3(paramIMyActivity, paramBoolean2, paramBoolean3, paramPack);
//        String str = String.valueOf(paramPack.getId());
//        StringBuilder localStringBuilder;
//        if (paramBoolean1)
//        {
//            localStringBuilder = new StringBuilder();
//            paramPack = paramPack.getProductList().iterator();
//            while (paramPack.hasNext())
//            {
//                Product localProduct = (Product)paramPack.next();
//                if (localProduct == null)
//                    continue;
//                localStringBuilder.append("_" + localProduct.getId());
//            }
//            if (TextUtils.isEmpty(localStringBuilder));
//        }
//        for (paramPack = str + localStringBuilder; ; paramPack = str)
//        {
//            paramPack = new CartRequest(new CartRequestOperate(null, new CartPackSummary(paramPack, Integer.valueOf(1)), "2"));
//            paramPack.setNoResponse(Boolean.valueOf(true));
//            syncCartAddNoCache(paramIMyActivity, paramPack, new ShoppingBaseController.ShoppingHttpListener(local3), true, true);
//            return;
//        }
//    }
//
//    public static void addOneProductWithYB(IMyActivity paramIMyActivity, ProductDetailEntity paramProductDetailEntity, ArrayList<CartResponseNewYBDetail> paramArrayList, Runnable paramRunnable)
//    {
//        if ((paramIMyActivity == null) || (paramProductDetailEntity == null))
//            return;
//        paramArrayList = new ShoppingBaseController.1(paramIMyActivity, paramIMyActivity, paramArrayList, paramProductDetailEntity, paramRunnable);
//        if (TextUtils.equals(paramProductDetailEntity.getJdPrice(), StringUtil.no_price))
//        {
//            paramArrayList.onError(StringUtil.product_canot_add_to_car);
//            return;
//        }
//        paramRunnable = paramProductDetailEntity.id;
//        if (paramProductDetailEntity.number == 0);
//        for (int i = 1; ; i = paramProductDetailEntity.number)
//        {
//            syncCartAddNoCache(paramIMyActivity, new CartRequest(new CartRequestOperate(new CartSkuSummary(paramRunnable, Integer.valueOf(i)), null, "2")), new ShoppingBaseController.ShoppingHttpListener(paramArrayList, false), true, true);
//            return;
//        }
//    }
//
//    public static void addProductForProductList(IMyActivity paramIMyActivity, String paramString, int paramInt, Runnable paramRunnable1, Runnable paramRunnable2, SourceEntity paramSourceEntity)
//    {
//        if (Log.D)
//            Log.d("ShoppingController", " addOneProductOrPack -->> myActivity:" + paramIMyActivity + "productId:" + paramString + "productNum:" + paramInt);
//        if ((paramIMyActivity == null) || (TextUtils.isEmpty(paramString)))
//            return;
//        Product localProduct;
//        if (!TextUtils.isEmpty(paramString))
//        {
//            paramString = paramString.trim();
//            localProduct = new Product();
//        }
//        while (true)
//        {
//            try
//            {
//                localProduct.setId(Long.valueOf(Long.parseLong(paramString)));
//                localProduct.setNum(Integer.valueOf(paramInt));
//                paramString = localProduct;
//                if (paramSourceEntity == null)
//                    continue;
//                localProduct.setSourceEntity(paramSourceEntity);
//                paramString = localProduct;
//                paramRunnable1 = new ShoppingBaseController.6(paramIMyActivity, paramIMyActivity, paramRunnable1, paramString, paramRunnable2);
//                if (paramString == null)
//                    continue;
//                paramRunnable2 = new CartSkuSummary(paramString.getId(), paramString.getNum());
//                paramString = new ArrayList();
//                paramString.add(paramRunnable2);
//                if (paramString == null)
//                    break;
//                paramString = new CartRequest(new CartRequestOperate(paramString, null, "2"));
//                paramString.setNoResponse(Boolean.valueOf(true));
//                syncCartAddNoCache(paramIMyActivity, paramString, new ShoppingBaseController.ShoppingHttpListener(paramRunnable1), true, true);
//                return;
//            }
//            catch (Exception paramString)
//            {
//                if (!Log.E)
//                    continue;
//                paramString.printStackTrace();
//                paramString = null;
//                continue;
//                paramString = null;
//                continue;
//            }
//            paramString = null;
//        }
//    }
//
//    public static void addProductOrPack(IMyActivity paramIMyActivity, String paramString1, int paramInt1, String paramString2, int paramInt2, SourceEntity paramSourceEntity)
//    {
//        addProductOrPack(paramIMyActivity, paramString1, paramInt1, paramString2, paramInt2, paramSourceEntity, true);
//    }
//
//    public static void addProductOrPack(IMyActivity paramIMyActivity, String paramString1, int paramInt1, String paramString2, int paramInt2, SourceEntity paramSourceEntity, boolean paramBoolean)
//    {
//        Object localObject1 = null;
//        if (Log.D)
//            Log.d("ShoppingController", " addOneProductOrPack -->> myActivity:" + paramIMyActivity + "productId:" + paramString1 + "productNum:" + paramInt1 + "packId:" + paramString2 + "packNum:" + paramInt2 + "sourceEntity:" + paramSourceEntity);
//        if ((paramIMyActivity == null) || ((TextUtils.isEmpty(paramString1)) && (TextUtils.isEmpty(paramString2))))
//            return;
//        Object localObject2;
//        if (!TextUtils.isEmpty(paramString1))
//        {
//            paramString1 = paramString1.trim();
//            localObject2 = new Product();
//        }
//        while (true)
//        {
//            try
//            {
//                ((Product)localObject2).setId(Long.valueOf(Long.parseLong(paramString1)));
//                ((Product)localObject2).setNum(Integer.valueOf(paramInt1));
//                paramString1 = (String)localObject2;
//                if (paramSourceEntity == null)
//                    continue;
//                ((Product)localObject2).setSourceEntity(paramSourceEntity);
//                paramString1 = (String)localObject2;
//                if (TextUtils.isEmpty(paramString2))
//                    break label373;
//                paramString2 = paramString2.trim();
//                localObject2 = new Pack();
//            }
//            catch (NumberFormatException paramString1)
//            {
//                try
//                {
//                    ((Pack)localObject2).setId(Long.valueOf(Long.parseLong(paramString2)));
//                    ((Pack)localObject2).setNum(Integer.valueOf(paramInt2));
//                    paramString2 = (String)localObject2;
//                    if (paramSourceEntity == null)
//                        continue;
//                    ((Pack)localObject2).setSourceEntity(paramSourceEntity);
//                    paramString2 = (String)localObject2;
//                    localObject2 = new ShoppingBaseController.4(paramIMyActivity, paramBoolean, paramString1, paramString2);
//                    if (paramString1 == null)
//                        break label368;
//                    paramSourceEntity = new CartSkuSummary(paramString1.getId(), paramString1.getNum());
//                    paramString1 = new ArrayList();
//                    paramString1.add(paramSourceEntity);
//                    paramSourceEntity = localObject1;
//                    if (paramString2 == null)
//                        continue;
//                    paramString2 = new CartPackSummary(String.valueOf(paramString2.getId()), paramString2.getNum());
//                    paramSourceEntity = new ArrayList();
//                    paramSourceEntity.add(paramString2);
//                    addMultiProductToCart(paramIMyActivity, paramString1, paramSourceEntity, (ShoppingBaseController.ShoppingListener)localObject2, true);
//                    return;
//                    paramString1 = paramString1;
//                    if (!Log.E)
//                        continue;
//                    paramString1.printStackTrace();
//                    paramString1 = null;
//                }
//                catch (NumberFormatException paramIMyActivity)
//                {
//                }
//            }
//            if (!Log.E)
//                break;
//            paramIMyActivity.printStackTrace();
//            return;
//            label368: paramString1 = null;
//            continue;
//            label373: paramString2 = null;
//            continue;
//            paramString1 = null;
//        }
//    }
//
//    public static void addProductOrPackForCutting(IMyActivity paramIMyActivity, Product paramProduct, Pack paramPack, SourceEntity paramSourceEntity, ShoppingBaseController.ShoppingListener paramShoppingListener)
//    {
//        CartPackSummary localCartPackSummary = null;
//        if ((Log.D) && (paramProduct != null) && (paramPack != null))
//            Log.d("ShoppingController", " addOneProductOrPack -->> myActivity:" + paramIMyActivity + "productId:" + paramProduct.getId() + "productNum:" + paramProduct.getNum() + "packId:" + paramPack.getId() + "packNum:" + paramPack.getNum() + "sourceEntity:" + paramSourceEntity);
//        if ((paramIMyActivity == null) || ((paramProduct == null) && (paramPack == null)))
//            return;
//        if (paramProduct != null)
//        {
//            CartSkuSummary localCartSkuSummary = new CartSkuSummary(paramProduct.getId(), paramProduct.getNum());
//            paramSourceEntity = new ArrayList();
//            paramSourceEntity.add(localCartSkuSummary);
//            JDMtaUtils.onSaveProductOrderPage(paramProduct.getId());
//        }
//        for (paramProduct = paramSourceEntity; ; paramProduct = null)
//        {
//            paramSourceEntity = localCartPackSummary;
//            if (paramPack != null)
//            {
//                localCartPackSummary = new CartPackSummary(String.valueOf(paramPack.getId()), paramPack.getNum());
//                paramSourceEntity = new ArrayList();
//                paramSourceEntity.add(localCartPackSummary);
//                JDMtaUtils.onSavePackOrderPage(paramPack.getId());
//            }
//            addMultiProductToCart(paramIMyActivity, paramProduct, paramSourceEntity, paramShoppingListener, true);
//            return;
//        }
//    }
//
//    public static void addSkuToCart(IMyActivity paramIMyActivity, String paramString, int paramInt, SourceEntity paramSourceEntity, ShoppingBaseController.AddCartListener paramAddCartListener)
//    {
//        if (Log.D)
//            Log.d("ShoppingController", " addOneProductOrPack -->> myActivity:" + paramIMyActivity + "productId:" + paramString + "productNum:" + paramInt);
//        if ((paramIMyActivity == null) || (TextUtils.isEmpty(paramString)))
//            return;
//        Product localProduct;
//        if (!TextUtils.isEmpty(paramString))
//        {
//            paramString = paramString.trim();
//            localProduct = new Product();
//        }
//        while (true)
//        {
//            try
//            {
//                localProduct.setId(Long.valueOf(Long.parseLong(paramString)));
//                localProduct.setNum(Integer.valueOf(paramInt));
//                paramString = localProduct;
//                if (paramSourceEntity == null)
//                    continue;
//                localProduct.setSourceEntity(paramSourceEntity);
//                paramString = localProduct;
//                paramSourceEntity = new ShoppingBaseController.5(paramIMyActivity, paramAddCartListener, paramString);
//                if (paramString == null)
//                    continue;
//                paramAddCartListener = new CartSkuSummary(paramString.getId(), paramString.getNum());
//                paramString = new ArrayList();
//                paramString.add(paramAddCartListener);
//                if (paramString == null)
//                    break;
//                syncCartAddNoCache(paramIMyActivity, new CartRequest(new CartRequestOperate(paramString, null, "2")), new ShoppingBaseController.ShoppingHttpListener(paramSourceEntity), true, true);
//                return;
//            }
//            catch (Exception paramString)
//            {
//                if (!Log.E)
//                    continue;
//                paramString.printStackTrace();
//                paramString = null;
//                continue;
//                paramString = null;
//                continue;
//            }
//            paramString = null;
//        }
//    }
//
//    public static void addToCart(IMyActivity paramIMyActivity, String paramString)
//    {
//        addToCartById(paramIMyActivity, paramString, new ShoppingBaseController.8(paramIMyActivity, paramString));
//    }
//
//    private static void addToCartById(IMyActivity paramIMyActivity, String paramString, HttpGroup.OnCommonListener paramOnCommonListener)
//    {
//        syncCartAddNoCache(paramIMyActivity, new CartRequest(new CartRequestOperate(new CartSkuSummary(paramString, Integer.valueOf(1)), null, "2")), paramOnCommonListener, true, true);
//    }
//
//    public static void batchAddGiftToPack(gm paramgm, IMyActivity paramIMyActivity, ArrayList<CartResponseGift> paramArrayList, CartPackSummary paramCartPackSummary, ShoppingBaseController.ShoppingWithoutListener paramShoppingWithoutListener, ViewGroup paramViewGroup)
//    {
//        if (Log.D)
//            Log.d("ShoppingController", " addOneGiftToPack -->> myActivity:" + paramIMyActivity + ", addGiftCartSkuSummary:" + paramArrayList.size() + ", beAddedToCartPackSummary:" + paramCartPackSummary + ", listener:" + paramShoppingWithoutListener);
//        if (paramCartPackSummary != null)
//        {
//            paramArrayList = paramArrayList.iterator();
//            while (paramArrayList.hasNext())
//                paramCartPackSummary.addGift((CartSkuSummary)paramArrayList.next());
//        }
//        paramArrayList = new CartRequest(new CartRequestOperate(null, paramCartPackSummary, "2"));
//        paramArrayList.setLoadingViewRoot(paramViewGroup);
//        paramArrayList.setModelGroupUtil(paramgm);
//        syncCartAdd(paramIMyActivity, paramArrayList, new ShoppingBaseController.HttpWithoutUpdateListener(paramShoppingWithoutListener));
//    }
//
//    public static void batchChangePromotion(gm paramgm, IMyActivity paramIMyActivity, ArrayList<CartSkuGiftSummary> paramArrayList, ArrayList<CartPackGiftSummary> paramArrayList1, ShoppingBaseController.ShoppingWithoutListener paramShoppingWithoutListener, ViewGroup paramViewGroup)
//    {
//        ArrayList localArrayList = new ArrayList();
//        localArrayList.add(new CartRequestOperateGift(paramArrayList, paramArrayList1, "4"));
//        paramArrayList = new CartRequest(localArrayList);
//        paramArrayList.setLoadingViewRoot(paramViewGroup);
//        paramArrayList.setModelGroupUtil(paramgm);
//        syncCartChangePromotion(paramIMyActivity, paramArrayList, new ShoppingBaseController.HttpWithoutUpdateListener(paramShoppingWithoutListener));
//    }
//
//    public static void batchDeleteGiftToPack(gm paramgm, IMyActivity paramIMyActivity, ArrayList<? super CartSkuSummary> paramArrayList, CartPackSummary paramCartPackSummary, ShoppingBaseController.ShoppingWithoutListener paramShoppingWithoutListener, ViewGroup paramViewGroup)
//    {
//        if (Log.D)
//            Log.d("ShoppingController", " addOneGiftToPack -->> myActivity:" + paramIMyActivity + ", deleteGiftCartSkuSummary:" + paramArrayList.size() + ", beDeletedToCartPackSummary:" + paramCartPackSummary + ", listener:" + paramShoppingWithoutListener);
//        if (paramCartPackSummary != null)
//        {
//            paramArrayList = paramArrayList.iterator();
//            while (paramArrayList.hasNext())
//                paramCartPackSummary.addGift((CartSkuSummary)paramArrayList.next());
//        }
//        paramArrayList = new CartRequest(new CartRequestOperate(null, paramCartPackSummary, "4"));
//        paramArrayList.setLoadingViewRoot(paramViewGroup);
//        paramArrayList.setModelGroupUtil(paramgm);
//        syncCartRemove(paramIMyActivity, paramArrayList, new ShoppingBaseController.HttpWithoutUpdateListener(paramShoppingWithoutListener));
//    }
//
//    public static void batchDeleteGiftToPackNoCache(IMyActivity paramIMyActivity, ArrayList<? super CartSkuSummary> paramArrayList, CartPackSummary paramCartPackSummary, ShoppingBaseController.ShoppingListener paramShoppingListener, ViewGroup paramViewGroup)
//    {
//        if (Log.D)
//            Log.d("ShoppingController", " addOneGiftToPack -->> myActivity:" + paramIMyActivity + ", deleteGiftCartSkuSummary:" + paramArrayList.size() + ", beDeletedToCartPackSummary:" + paramCartPackSummary + ", listener:" + paramShoppingListener);
//        if (paramCartPackSummary != null)
//        {
//            paramArrayList = paramArrayList.iterator();
//            while (paramArrayList.hasNext())
//                paramCartPackSummary.addGift((CartSkuSummary)paramArrayList.next());
//        }
//        paramArrayList = new CartRequest(new CartRequestOperate(null, paramCartPackSummary, "4"));
//        paramArrayList.setLoadingViewRoot(paramViewGroup);
//        syncCartRemoveNoCache(paramIMyActivity.getHttpGroupaAsynPool(), paramIMyActivity, paramArrayList, new ShoppingBaseController.ShoppingHttpListener(paramShoppingListener), true, true);
//    }
//
//    public static void batchDeleteMustGift(gm paramgm, IMyActivity paramIMyActivity, ArrayList<CartSkuGiftSummary> paramArrayList, ArrayList<CartPackGiftSummary> paramArrayList1, ShoppingBaseController.ShoppingWithoutListener paramShoppingWithoutListener, ViewGroup paramViewGroup)
//    {
//        ArrayList localArrayList = new ArrayList();
//        localArrayList.add(new CartRequestOperateGift(paramArrayList, paramArrayList1, "4"));
//        paramArrayList = new CartRequest(localArrayList);
//        paramArrayList.setLoadingViewRoot(paramViewGroup);
//        paramArrayList.setModelGroupUtil(paramgm);
//        syncCartGiftRemove(paramIMyActivity, paramArrayList, new ShoppingBaseController.HttpWithoutUpdateListener(paramShoppingWithoutListener));
//    }
//
//    public static void batchDeleteMustGiftNoCache(IMyActivity paramIMyActivity, ArrayList<CartSkuGiftSummary> paramArrayList, ArrayList<CartPackGiftSummary> paramArrayList1, ShoppingBaseController.ShoppingListener paramShoppingListener, ViewGroup paramViewGroup)
//    {
//        ArrayList localArrayList = new ArrayList();
//        localArrayList.add(new CartRequestOperateGift(paramArrayList, paramArrayList1, "4"));
//        paramArrayList = new CartRequest(localArrayList);
//        paramArrayList.setLoadingViewRoot(paramViewGroup);
//        syncCartGiftRemoveNoCache(paramIMyActivity, paramArrayList, new ShoppingBaseController.ShoppingHttpListener(paramShoppingListener));
//    }
//
//    public static void clearLocalCart()
//    {
//        new Thread(new ShoppingBaseController.7()).start();
//        setProductCount(0);
//        validateCartIcon();
//    }
//
//    private static String combineCartCacheKey()
//    {
//        if (Log.D)
//            Log.d("ShoppingController", " combineCartCacheKey -->> getLoginUserName:" + LoginUserBase.getLoginUserName());
//        return "cartSyncCachekey" + LoginUserBase.getLoginUserName();
//    }
//
//    public static void deleteEsaySelectOneProductGiftOrPackGifts(IMyActivity paramIMyActivity, String paramString, ArrayList<OrderCommodity> paramArrayList, ShoppingBaseController.ShoppingListener paramShoppingListener)
//    {
//        if (paramArrayList == null);
//        ArrayList localArrayList;
//        do
//        {
//            return;
//            localArrayList = new ArrayList();
//            int i = 0;
//            while (i < paramArrayList.size())
//            {
//                OrderCommodity localOrderCommodity = (OrderCommodity)paramArrayList.get(i);
//                if (localOrderCommodity != null)
//                {
//                    int j;
//                    if ((TextUtils.equals(paramString, localOrderCommodity.getId())) && (localOrderCommodity.isMainSku()))
//                        if (localOrderCommodity.getGifts() == null)
//                            j = 0;
//                    while (true)
//                    {
//                        int k = 0;
//                        while (true)
//                            if (k < j)
//                            {
//                                OrderCommodityGift localOrderCommodityGift = (OrderCommodityGift)localOrderCommodity.getGifts().get(k);
//                                if ((localOrderCommodityGift != null) && (localOrderCommodityGift.isNoStock()))
//                                    localArrayList.add(new CartSkuGiftSummary(paramString, localOrderCommodityGift.getId(), Integer.valueOf(1)));
//                                k += 1;
//                                continue;
//                                j = localOrderCommodity.getGifts().size();
//                                break;
//                                if (localOrderCommodity.isNoStock())
//                                    localArrayList.add(new CartSkuGiftSummary(paramString, localOrderCommodity.getId(), Integer.valueOf(1)));
//                            }
//                    }
//                }
//                i += 1;
//            }
//        }
//        while (localArrayList.size() <= 0);
//        batchDeleteMustGiftNoCache(paramIMyActivity, localArrayList, null, paramShoppingListener, null);
//    }
//
//    public static void deleteNewYb(gm paramgm, IMyActivity paramIMyActivity, ShoppingBaseController.ShoppingWithoutListener paramShoppingWithoutListener, String paramString1, String paramString2, int paramInt)
//    {
//        if (Log.D)
//            Log.d("ShoppingController", " addOrDeleteYb -->> myActivity:" + paramIMyActivity + ", skuid:" + paramString1 + ", rSuitid" + paramString2 + ", listener:" + paramShoppingWithoutListener);
//        if ((paramString1 != null) || (paramString2 != null))
//            try
//            {
//                if (!TextUtils.isEmpty(paramString2));
//                for (paramString1 = new CartPackSummary(paramString1, paramString2, Integer.valueOf(paramInt), "7"); ; paramString1 = new CartPackSummary(paramString1, Integer.valueOf(paramInt), "8"))
//                {
//                    paramString1 = new CartRequest(new CartRequestOperate(null, paramString1, "9"));
//                    paramString1.setModelGroupUtil(paramgm);
//                    syncCartRemove(paramIMyActivity, paramString1, new ShoppingBaseController.HttpWithoutUpdateListener(paramShoppingWithoutListener));
//                    return;
//                }
//            }
//            catch (Exception paramgm)
//            {
//                if (Log.E)
//                {
//                    Log.e("ShoppingController", " -->> " + paramgm.getMessage());
//                    paramgm.printStackTrace();
//                }
//            }
//    }
//
//    public static void deleteOneGiftFormPack(gm paramgm, IMyActivity paramIMyActivity, CartSkuSummary paramCartSkuSummary, CartPackSummary paramCartPackSummary, ShoppingBaseController.ShoppingWithoutListener paramShoppingWithoutListener, ViewGroup paramViewGroup)
//    {
//        if (Log.D)
//            Log.d("ShoppingController", " addOneGiftToPack -->> myActivity:" + paramIMyActivity + ", deleteGiftCartSkuSummary:" + paramCartSkuSummary + ", beDeletedToCartPackSummary:" + paramCartPackSummary + ", listener:" + paramShoppingWithoutListener);
//        if (paramCartPackSummary != null)
//            paramCartPackSummary.addGift(paramCartSkuSummary);
//        paramCartSkuSummary = new CartRequest(new CartRequestOperate(null, paramCartPackSummary, "4"));
//        paramCartSkuSummary.setLoadingViewRoot(paramViewGroup);
//        paramCartSkuSummary.setModelGroupUtil(paramgm);
//        syncCartRemove(paramIMyActivity, paramCartSkuSummary, new ShoppingBaseController.HttpWithoutUpdateListener(paramShoppingWithoutListener));
//    }
//
//    public static void deleteOnePack(gm paramgm, IMyActivity paramIMyActivity, CartPackSummary paramCartPackSummary, ShoppingBaseController.ShoppingWithoutListener paramShoppingWithoutListener, ViewGroup paramViewGroup)
//    {
//        if (Log.D)
//            Log.d("ShoppingController", " deleteOneProduct -->> myActivity:" + paramIMyActivity + ", deleteCartPackSummary:" + paramCartPackSummary + ", listener:" + paramShoppingWithoutListener);
//        ArrayList localArrayList = new ArrayList();
//        localArrayList.add(paramCartPackSummary);
//        deleteProductOrPackList(paramgm, paramIMyActivity, null, localArrayList, paramShoppingWithoutListener, paramViewGroup);
//    }
//
//    public static void deleteOneProduct(gm paramgm, IMyActivity paramIMyActivity, CartSkuSummary paramCartSkuSummary, ShoppingBaseController.ShoppingWithoutListener paramShoppingWithoutListener, ViewGroup paramViewGroup)
//    {
//        if (Log.D)
//            Log.d("ShoppingController", " deleteOneProduct -->> myActivity:" + paramIMyActivity + ", deleteCartSkuSummary:" + paramCartSkuSummary + ", listener:" + paramShoppingWithoutListener);
//        ArrayList localArrayList = new ArrayList();
//        localArrayList.add(paramCartSkuSummary);
//        deleteProductOrPackList(paramgm, paramIMyActivity, localArrayList, null, paramShoppingWithoutListener, paramViewGroup);
//    }
//
//    public static void deleteProductOrPackList(gm paramgm, IMyActivity paramIMyActivity, ArrayList<CartSkuSummary> paramArrayList, ArrayList<CartPackSummary> paramArrayList1, ShoppingBaseController.ShoppingWithoutListener paramShoppingWithoutListener, ViewGroup paramViewGroup)
//    {
//        if (Log.D)
//            Log.d("ShoppingController", " deleteProductOrPackList -->> myActivity:" + paramIMyActivity + ", deleteSkus:" + paramArrayList + ", deletePacks:" + paramArrayList1 + ", listener:" + paramShoppingWithoutListener);
//        ArrayList localArrayList = new ArrayList();
//        localArrayList.add(new CartRequestOperate(paramArrayList, paramArrayList1, "4"));
//        paramArrayList = new CartRequest(localArrayList);
//        paramArrayList.setLoadingViewRoot(paramViewGroup);
//        paramArrayList.setModelGroupUtil(paramgm);
//        syncCartRemove(paramIMyActivity, paramArrayList, new ShoppingBaseController.HttpWithoutUpdateListener(paramShoppingWithoutListener));
//    }
//
//    public static void deleteSelectOneProductGiftOrPackGifts(IMyActivity paramIMyActivity, CartResponseInfo paramCartResponseInfo, ArrayList<OrderCommodity> paramArrayList, ShoppingBaseController.ShoppingListener paramShoppingListener)
//    {
//        int i3 = paramCartResponseInfo.getSkus().size();
//        int i2 = paramCartResponseInfo.getSuits().size();
//        Object localObject1 = new ArrayList();
//        ArrayList localArrayList = new ArrayList();
//        int i = 0;
//        Object localObject2;
//        int j;
//        Object localObject3;
//        int k;
//        int m;
//        label145: int n;
//        label148: Object localObject4;
//        int i1;
//        Object localObject5;
//        while (i < i3)
//        {
//            localObject2 = (CartResponseSku)paramCartResponseInfo.getSkus().get(i);
//            if ((localObject2 != null) && (((CartResponseSku)localObject2).getMustGifts() != null) && (((CartResponseSku)localObject2).getMustGifts().size() != 0))
//            {
//                j = 0;
//                while (j < paramArrayList.size())
//                {
//                    localObject3 = (OrderCommodity)paramArrayList.get(j);
//                    if (TextUtils.equals(((CartResponseSku)localObject2).getSkuId(), ((OrderCommodity)localObject3).getId()))
//                    {
//                        if (((CartResponseSku)localObject2).getMustGifts() == null)
//                        {
//                            k = 0;
//                            if (((OrderCommodity)localObject3).getGifts() != null)
//                                break label269;
//                            m = 0;
//                            n = 0;
//                            if (n >= k)
//                                break label291;
//                            localObject4 = (CartResponseSku)((CartResponseSku)localObject2).getMustGifts().get(n);
//                            i1 = 0;
//                        }
//                        while (true)
//                        {
//                            if (i1 < m)
//                            {
//                                localObject5 = (OrderCommodityGift)((OrderCommodity)localObject3).getGifts().get(i1);
//                                if ((TextUtils.equals(((CartResponseSku)localObject4).getSkuId(), ((OrderCommodityGift)localObject5).getId())) && (((OrderCommodityGift)localObject5).isNoStock()))
//                                    ((ArrayList)localObject1).add(new CartSkuGiftSummary(((CartResponseSku)localObject2).getSkuId(), ((CartResponseSku)localObject4).getSkuId(), ((CartResponseSku)localObject4).getNum()));
//                            }
//                            else
//                            {
//                                n += 1;
//                                break label148;
//                                k = ((CartResponseSku)localObject2).getMustGifts().size();
//                                break;
//                                label269: m = ((OrderCommodity)localObject3).getGifts().size();
//                                break label145;
//                            }
//                            i1 += 1;
//                        }
//                    }
//                    label291: j += 1;
//                }
//                if (((ArrayList)localObject1).size() > 0)
//                {
//                    batchDeleteMustGiftNoCache(paramIMyActivity, (ArrayList)localObject1, null, paramShoppingListener, null);
//                    ((ArrayList)localObject1).clear();
//                }
//            }
//            i += 1;
//        }
//        i = 0;
//        if (i < i2)
//        {
//            localObject1 = (CartResponseSuit)paramCartResponseInfo.getSuits().get(i);
//            if (localObject1 != null)
//            {
//                localObject2 = new ArrayList();
//                localObject3 = new ArrayList();
//                if (((CartResponseSuit)localObject1).getGifts() == null)
//                {
//                    j = 0;
//                    k = 0;
//                    label392: if (k < j)
//                        m = 0;
//                }
//                else
//                {
//                    while (true)
//                    {
//                        if (m < paramArrayList.size())
//                        {
//                            localObject4 = (OrderCommodity)paramArrayList.get(m);
//                            localObject5 = (CartResponseSku)((CartResponseSuit)localObject1).getGifts().get(k);
//                            if ((!TextUtils.isEmpty(((OrderCommodity)localObject4).getPromoId())) && (TextUtils.equals(((CartResponseSku)localObject5).getSkuId(), ((OrderCommodity)localObject4).getId())))
//                                ((ArrayList)localObject3).add(localObject5);
//                        }
//                        else
//                        {
//                            k += 1;
//                            break label392;
//                            j = ((CartResponseSuit)localObject1).getGifts().size();
//                            break;
//                        }
//                        m += 1;
//                    }
//                }
//                if (((ArrayList)localObject3).size() > 0)
//                {
//                    batchDeleteGiftToPackNoCache(paramIMyActivity, (ArrayList)localObject3, new CartPackSummary(((CartResponseSuit)localObject1).getPackId(), ((CartResponseSuit)localObject1).getNum(), ((CartResponseSuit)localObject1).getsType()), paramShoppingListener, null);
//                    ((ArrayList)localObject3).clear();
//                }
//            }
//        }
//        while (true)
//        {
//            try
//            {
//                if (((CartResponseSuit)localObject1).getSkus() != null)
//                    continue;
//                j = 0;
//                break label838;
//                if (k >= j)
//                    continue;
//                localObject3 = (CartResponseSku)((CartResponseSuit)localObject1).getSkus().get(k);
//                if ((localObject3 == null) || (((CartResponseSku)localObject3).getMustGifts() == null) || (((CartResponseSku)localObject3).getMustGifts().size() == 0))
//                    continue;
//                i1 = ((CartResponseSku)localObject3).getMustGifts().size();
//                m = 0;
//                if (m >= i1)
//                    continue;
//                localObject4 = (CartResponseSku)((CartResponseSku)localObject3).getMustGifts().get(m);
//                n = 0;
//                if (n >= paramArrayList.size())
//                    break label844;
//                localObject5 = (OrderCommodity)paramArrayList.get(n);
//                if ((!TextUtils.equals(((CartResponseSku)localObject4).getSkuId(), ((OrderCommodity)localObject5).getId())) || (!((OrderCommodity)localObject5).isNoStock()))
//                    continue;
//                localArrayList.add(new CartSkuGiftSummary(((CartResponseSku)localObject3).getSkuId(), ((CartResponseSku)localObject4).getSkuId(), ((CartResponseSku)localObject4).getNum()));
//                break label844;
//                j = ((CartResponseSuit)localObject1).getSkus().size();
//                break label838;
//                n += 1;
//                continue;
//                k += 1;
//                continue;
//            }
//            catch (Exception localException)
//            {
//                if (!Log.E)
//                    continue;
//                localException.printStackTrace();
//                if (localArrayList.size() > 0)
//                {
//                    ((ArrayList)localObject2).add(new CartPackGiftSummary(((CartResponseSuit)localObject1).getSuitId(), ((CartResponseSuit)localObject1).getNum(), localArrayList, ((CartResponseSuit)localObject1).getsType()));
//                    batchDeleteMustGiftNoCache(paramIMyActivity, null, (ArrayList)localObject2, paramShoppingListener, null);
//                    localArrayList.clear();
//                    if (((ArrayList)localObject2).size() > 0)
//                        ((ArrayList)localObject2).clear();
//                }
//            }
//            i += 1;
//            break;
//            return;
//            label838: k = 0;
//            continue;
//            label844: m += 1;
//        }
//    }
//
//    public static void editProductOrPackList(gm paramgm, IMyActivity paramIMyActivity, ArrayList<CartSkuSummary> paramArrayList, ArrayList<CartPackSummary> paramArrayList1, ShoppingBaseController.ShoppingWithoutListener paramShoppingWithoutListener, boolean paramBoolean, ViewGroup paramViewGroup)
//    {
//        if (Log.D)
//            Log.d("ShoppingController", " editProductOrPackList -->> myActivity:" + paramIMyActivity + ", editSkus:" + paramArrayList + ", editPacks:" + paramArrayList1 + ", listener:" + paramShoppingWithoutListener);
//        ArrayList localArrayList = new ArrayList();
//        localArrayList.add(new CartRequestOperate(paramArrayList, paramArrayList1, "3"));
//        paramArrayList = new CartRequest(localArrayList);
//        paramArrayList.setLoadingViewRoot(paramViewGroup);
//        paramArrayList.setModelGroupUtil(paramgm);
//        syncCartChange(paramIMyActivity, paramArrayList, new ShoppingBaseController.HttpWithoutUpdateListener(paramShoppingWithoutListener), paramBoolean);
//    }
//
//    protected static JSONObject getCartRequestParam(CartRequest paramCartRequest)
//    {
//        Object localObject5 = null;
//        Object localObject3;
//        boolean bool;
//        if (paramCartRequest != null)
//        {
//            localObject1 = paramCartRequest.getCartCommon();
//            localObject3 = paramCartRequest.getCartOperates();
//            bool = paramCartRequest.getNoResponse().booleanValue();
//            paramCartRequest = (CartRequest)localObject1;
//        }
//        label112: Object localObject2;
//        for (Object localObject1 = paramCartRequest; ; localObject2 = null)
//        {
//            paramCartRequest = localObject5;
//            if (localObject1 != null);
//            try
//            {
//                paramCartRequest = ((CartRequestCommon)localObject1).toParams();
//                localObject1 = paramCartRequest;
//                if (paramCartRequest != null);
//            }
//            catch (JSONException localJSONException2)
//            {
//                try
//                {
//                    localObject1 = new JSONObject();
//                    if (localObject3 != null)
//                        try
//                        {
//                            if (((ArrayList)localObject3).size() > 0)
//                            {
//                                paramCartRequest = new JSONArray();
//                                localObject3 = ((ArrayList)localObject3).iterator();
//                                while (((Iterator)localObject3).hasNext())
//                                    paramCartRequest.put(((CartRequestOperate)((Iterator)localObject3).next()).toParams());
//                            }
//                        }
//                        catch (JSONException localJSONException3)
//                        {
//                            paramCartRequest = (CartRequest)localObject1;
//                            localObject1 = localJSONException3;
//                        }
//                    while (true)
//                    {
//                        if (Log.E)
//                        {
//                            Log.e("ShoppingController", "syncCart -->> " + ((JSONException)localObject1).getMessage());
//                            ((JSONException)localObject1).printStackTrace();
//                        }
//                        return paramCartRequest;
//                        ((JSONObject)localObject1).put("operations", paramCartRequest);
//                        ((JSONObject)localObject1).put("syntype", "1");
//                        ((JSONObject)localObject1).put("cartuuid", StatisticsReportUtil.readCartUUID());
//                        if (bool)
//                            ((JSONObject)localObject1).put("noResponse", bool);
//                        paramCartRequest = a.a();
//                        if (paramCartRequest != null)
//                        {
//                            ((JSONObject)localObject1).put("longitude", paramCartRequest.getLongitudeDB());
//                            ((JSONObject)localObject1).put("latitude", paramCartRequest.getLatitudeDB());
//                            ((JSONObject)localObject1).put("coord_type", paramCartRequest.getCoordType());
//                        }
//                        return localObject1;
//                        localJSONException1 = localJSONException1;
//                        paramCartRequest = null;
//                    }
//                }
//                catch (JSONException localJSONException2)
//                {
//                    break label112;
//                }
//            }
//            bool = false;
//            Object localObject4 = null;
//        }
//    }
//
//    public static void getCartYB(IMyActivity paramIMyActivity, CartRequest paramCartRequest, HttpGroup.HttpTaskListener paramHttpTaskListener)
//    {
//        if (Log.D)
//        {
//            Log.d("ShoppingController", "syncCart() : MyActivity -> " + paramIMyActivity);
//            Log.d("ShoppingController", "syncCart() : CartRequest -> " + paramCartRequest);
//            Log.d("ShoppingController", "syncCart() : HttpTaskListener -> " + paramHttpTaskListener);
//        }
//        paramCartRequest.setNeedCache(false);
//        paramCartRequest.setNotify(false);
//        paramCartRequest.setEffect(false);
//        syncCart(paramIMyActivity.getHttpGroupaAsynPool(), "cartYB", paramIMyActivity, paramCartRequest, paramHttpTaskListener);
//    }

    public static int getProductCount()
    {
        return CommonUtil.getJdSharedPreferences().getInt("shoppingCartCount", 0);
    }

//    public static void selectAll(gm paramgm, IMyActivity paramIMyActivity, ShoppingBaseController.ShoppingWithoutListener paramShoppingWithoutListener, ViewGroup paramViewGroup)
//    {
//        if (Log.D)
//            Log.d("ShoppingController", " selectAll -->> myActivity:" + paramIMyActivity + ", listener:" + paramShoppingWithoutListener);
//        CartRequest localCartRequest = new CartRequest(new CartRequestOperate("7"));
//        localCartRequest.setLoadingViewRoot(paramViewGroup);
//        localCartRequest.setModelGroupUtil(paramgm);
//        syncCartCheckAll(paramIMyActivity, localCartRequest, new ShoppingBaseController.HttpWithoutUpdateListener(paramShoppingWithoutListener));
//    }
//
//    public static void selectOneProductOrPack(gm paramgm, IMyActivity paramIMyActivity, CartSkuSummary paramCartSkuSummary, CartPackSummary paramCartPackSummary, ShoppingBaseController.ShoppingWithoutListener paramShoppingWithoutListener, ViewGroup paramViewGroup)
//    {
//        if (Log.D)
//            Log.d("ShoppingController", " selectOneProductOrPack -->> myActivity:" + paramIMyActivity + ", selectSku:" + paramCartSkuSummary + ", selectePack:" + paramCartPackSummary + ", listener:" + paramShoppingWithoutListener);
//        if ((paramCartSkuSummary == null) && (paramCartPackSummary == null))
//            return;
//        ArrayList localArrayList = new ArrayList();
//        localArrayList.add(new CartRequestOperate(paramCartSkuSummary, paramCartPackSummary, "5"));
//        paramCartSkuSummary = new CartRequest(localArrayList);
//        paramCartSkuSummary.setLoadingViewRoot(paramViewGroup);
//        paramCartSkuSummary.setTouch(true);
//        paramCartSkuSummary.setModelGroupUtil(paramgm);
//        syncCartCheckSingle(paramIMyActivity, paramCartSkuSummary, new ShoppingBaseController.HttpWithoutUpdateListener(paramShoppingWithoutListener));
//    }
//
//    public static void selectOneShop(gm paramgm, IMyActivity paramIMyActivity, CartResponseShop paramCartResponseShop, ShoppingBaseController.ShoppingWithoutListener paramShoppingWithoutListener, ViewGroup paramViewGroup)
//    {
//        if (Log.D)
//        {
//            Log.d("ShoppingController", " selectOneShop -->> myActivity : " + paramIMyActivity);
//            Log.d("ShoppingController", " selectOneShop -->> selectShop : " + paramCartResponseShop);
//        }
//        if ((paramCartResponseShop == null) || (paramCartResponseShop.getCartSummary() == null) || (paramCartResponseShop.getCartSummary().size() == 0));
//        ArrayList localArrayList1;
//        ArrayList localArrayList2;
//        do
//        {
//            return;
//            localArrayList1 = new ArrayList();
//            localArrayList2 = new ArrayList();
//            paramCartResponseShop = paramCartResponseShop.getCartSummary().iterator();
//            while (paramCartResponseShop.hasNext())
//            {
//                Object localObject = paramCartResponseShop.next();
//                if ((localObject instanceof CartResponseSku))
//                {
//                    localObject = (CartResponseSku)localObject;
//                    if (((CartResponseSku)localObject).isChecked())
//                        continue;
//                    localArrayList1.add(new CartSkuSummary(((CartResponseSku)localObject).getSkuId(), ((CartResponseSku)localObject).getNum()));
//                    continue;
//                }
//                if (!(localObject instanceof CartResponseSuit))
//                    continue;
//                localObject = (CartResponseSuit)localObject;
//                CartPackSummary localCartPackSummary = new CartPackSummary(((CartResponseSuit)localObject).getPackId(), ((CartResponseSuit)localObject).getNum(), ((CartResponseSuit)localObject).getsType());
//                localCartPackSummary.setSkus(((CartResponseSuit)localObject).getSkus());
//                localArrayList2.add(localCartPackSummary);
//            }
//            if (!Log.D)
//                continue;
//            Log.d("ShoppingController", " selectOneShop -->> selectSkus.size() : " + localArrayList1.size());
//            Log.d("ShoppingController", " selectOneShop -->> selectPacks.size() : " + localArrayList2.size());
//        }
//        while ((localArrayList1.size() == 0) && (localArrayList2.size() == 0));
//        paramCartResponseShop = new ArrayList();
//        paramCartResponseShop.add(new CartRequestOperate(localArrayList1, localArrayList2, "5"));
//        paramCartResponseShop = new CartRequest(paramCartResponseShop);
//        paramCartResponseShop.setLoadingViewRoot(paramViewGroup);
//        paramCartResponseShop.setModelGroupUtil(paramgm);
//        syncCartCheckSingle(paramIMyActivity, paramCartResponseShop, new ShoppingBaseController.HttpWithoutUpdateListener(paramShoppingWithoutListener));
//    }
//
//    public static void setCommon(bw parambw)
//    {
//        iCommon = parambw;
//    }
//
//    public static void setProductCount(int paramInt)
//    {
//        CommonUtil.getJdSharedPreferences().edit().putInt("shoppingCartCount", paramInt).commit();
//    }
//
//    private static void showToast(IMyActivity paramIMyActivity, int paramInt)
//    {
//        paramIMyActivity.post(new ShoppingBaseController.2(paramInt, paramIMyActivity));
//    }
//
//    public static void syncCart(IMyActivity paramIMyActivity, CartRequest paramCartRequest, HttpGroup.HttpTaskListener paramHttpTaskListener, boolean paramBoolean1, boolean paramBoolean2)
//    {
//        syncCart(paramIMyActivity.getHttpGroupaAsynPool(), paramIMyActivity, paramCartRequest, paramHttpTaskListener, true, false);
//    }
//
//    public static void syncCart(HttpGroup paramHttpGroup, IMyActivity paramIMyActivity, CartRequest paramCartRequest, HttpGroup.HttpTaskListener paramHttpTaskListener, boolean paramBoolean1, boolean paramBoolean2)
//    {
//        paramCartRequest.setNotify(paramBoolean1);
//        paramCartRequest.setEffect(paramBoolean2);
//        syncCart(paramHttpGroup, "cart", paramIMyActivity, paramCartRequest, paramHttpTaskListener);
//    }
//
//    public static void syncCart(HttpGroup paramHttpGroup, String paramString, IMyActivity paramIMyActivity, CartRequest paramCartRequest, HttpGroup.HttpTaskListener paramHttpTaskListener)
//    {
//        if (Log.D)
//        {
//            Log.d("ShoppingController", "syncCart() : MyActivity -> " + paramIMyActivity);
//            Log.d("ShoppingController", "syncCart() : CartRequest -> " + paramCartRequest);
//            Log.d("ShoppingController", "syncCart() : HttpTaskListener -> " + paramHttpTaskListener);
//        }
//        if (paramIMyActivity == null)
//            return;
//        HttpGroup localHttpGroup = paramHttpGroup;
//        if (paramHttpGroup == null)
//            localHttpGroup = paramIMyActivity.getHttpGroupaAsynPool();
//        paramHttpGroup = getCartRequestParam(paramCartRequest);
//        paramIMyActivity = new HttpGroup.HttpSetting();
//        paramIMyActivity.setFunctionId(paramString);
//        paramIMyActivity.setJsonParams(paramHttpGroup);
//        paramIMyActivity.setHost(Configuration.getCartHost());
//        paramIMyActivity.setNotifyUser(paramCartRequest.isNotify());
//        paramIMyActivity.setCacheMode(2);
//        paramIMyActivity.setOnTouchEvent(paramCartRequest.isTouch());
//        if (paramCartRequest.getLoadingViewRoot() != null)
//            paramIMyActivity.setProgressBarRootLayout(paramCartRequest.getLoadingViewRoot());
//        paramIMyActivity.setLocalFileCache(false);
//        if ((paramCartRequest.isNeedCache()) && (!paramCartRequest.getNoResponse().booleanValue()))
//        {
//            paramIMyActivity.setLocalFileCacheTime(300000L);
//            paramIMyActivity.setMd5(Md5Encrypt.md5(combineCartCacheKey()));
//        }
//        if (paramHttpTaskListener != null)
//            paramIMyActivity.setListener(paramHttpTaskListener);
//        if (!LoginUserBase.hasLogin())
//            paramIMyActivity.setUseCookies(false);
//        if (paramCartRequest.isEffect())
//            paramIMyActivity.setEffect(1);
//        while (true)
//        {
//            localHttpGroup.add(paramIMyActivity);
//            return;
//            paramIMyActivity.setEffect(0);
//        }
//    }
//
//    public static void syncCartAdd(IMyActivity paramIMyActivity, CartRequest paramCartRequest, go paramgo)
//    {
//        syncCartAdd(paramIMyActivity, paramCartRequest, paramgo, true, true);
//    }
//
//    public static void syncCartAdd(IMyActivity paramIMyActivity, CartRequest paramCartRequest, go paramgo, boolean paramBoolean1, boolean paramBoolean2)
//    {
//        paramCartRequest.setNotify(paramBoolean1);
//        paramCartRequest.setEffect(paramBoolean2);
//        syncCartWithCacheNew(paramCartRequest.getModelGroupUtil(), "cartAdd", paramIMyActivity.getHttpGroupaAsynPool(), paramCartRequest, paramgo);
//    }
//
//    public static void syncCartAddNoCache(IMyActivity paramIMyActivity, CartRequest paramCartRequest, HttpGroup.HttpTaskListener paramHttpTaskListener, boolean paramBoolean1, boolean paramBoolean2)
//    {
//        paramCartRequest.setNotify(paramBoolean1);
//        paramCartRequest.setEffect(paramBoolean2);
//        syncCart(paramIMyActivity.getHttpGroupaAsynPool(), "cartAdd", paramIMyActivity, paramCartRequest, paramHttpTaskListener);
//    }
//
//    public static void syncCartChange(IMyActivity paramIMyActivity, CartRequest paramCartRequest, go paramgo, boolean paramBoolean)
//    {
//        syncCartChange(paramIMyActivity, paramCartRequest, paramgo, true, paramBoolean);
//    }
//
//    public static void syncCartChange(IMyActivity paramIMyActivity, CartRequest paramCartRequest, go paramgo, boolean paramBoolean1, boolean paramBoolean2)
//    {
//        paramCartRequest.setNotify(paramBoolean1);
//        paramCartRequest.setEffect(paramBoolean2);
//        syncCartWithCacheNew(paramCartRequest.getModelGroupUtil(), "cartChange", paramIMyActivity.getHttpGroupaAsynPool(), paramCartRequest, paramgo);
//    }
//
//    public static void syncCartChangePromotion(IMyActivity paramIMyActivity, CartRequest paramCartRequest, go paramgo)
//    {
//        paramCartRequest.setNotify(true);
//        paramCartRequest.setEffect(true);
//        syncCartWithCacheNew(paramCartRequest.getModelGroupUtil(), "changePromotion", paramIMyActivity.getHttpGroupaAsynPool(), paramCartRequest, paramgo);
//    }
//
//    public static void syncCartCheckAll(IMyActivity paramIMyActivity, CartRequest paramCartRequest, go paramgo)
//    {
//        syncCartCheckAll(paramIMyActivity.getHttpGroupaAsynPool(), paramIMyActivity, paramCartRequest, paramgo, true, true);
//    }
//
//    public static void syncCartCheckAll(HttpGroup paramHttpGroup, IMyActivity paramIMyActivity, CartRequest paramCartRequest, go paramgo, boolean paramBoolean1, boolean paramBoolean2)
//    {
//        paramCartRequest.setNotify(paramBoolean1);
//        paramCartRequest.setEffect(paramBoolean2);
//        syncCartWithCacheNew(paramCartRequest.getModelGroupUtil(), "cartCheckAll", paramHttpGroup, paramCartRequest, paramgo);
//    }
//
//    public static void syncCartCheckSingle(IMyActivity paramIMyActivity, CartRequest paramCartRequest, go paramgo)
//    {
//        syncCartCheckSingle(paramIMyActivity.getHttpGroupaAsynPool(), paramIMyActivity, paramCartRequest, paramgo, true, true);
//    }
//
//    public static void syncCartCheckSingle(HttpGroup paramHttpGroup, IMyActivity paramIMyActivity, CartRequest paramCartRequest, go paramgo, boolean paramBoolean1, boolean paramBoolean2)
//    {
//        paramCartRequest.setNotify(paramBoolean1);
//        paramCartRequest.setEffect(paramBoolean2);
//        syncCartWithCacheNew(paramCartRequest.getModelGroupUtil(), "cartCheckSingle", paramHttpGroup, paramCartRequest, paramgo);
//    }
//
//    public static void syncCartGiftRemove(IMyActivity paramIMyActivity, CartRequest paramCartRequest, go paramgo)
//    {
//        paramCartRequest.setNotify(true);
//        paramCartRequest.setEffect(true);
//        syncCartWithCacheNew(paramCartRequest.getModelGroupUtil(), "cartRemoveGift", paramIMyActivity.getHttpGroupaAsynPool(), paramCartRequest, paramgo);
//    }
//
//    public static void syncCartGiftRemoveNoCache(IMyActivity paramIMyActivity, CartRequest paramCartRequest, HttpGroup.HttpTaskListener paramHttpTaskListener)
//    {
//        paramCartRequest.setNotify(true);
//        paramCartRequest.setEffect(true);
//        syncCart(paramIMyActivity.getHttpGroupaAsynPool(), "cartRemoveGift", paramIMyActivity, paramCartRequest, paramHttpTaskListener);
//    }
//
//    public static void syncCartNoResponse(IMyActivity paramIMyActivity)
//    {
//        CartRequest localCartRequest = new CartRequest();
//        localCartRequest.setNoResponse(Boolean.valueOf(true));
//        syncCart(paramIMyActivity, localCartRequest, new ShoppingBaseController.ShoppingHttpListener(null), true, false);
//    }
//
//    public static void syncCartRemove(IMyActivity paramIMyActivity, CartRequest paramCartRequest, go paramgo)
//    {
//        syncCartRemove(paramIMyActivity.getHttpGroupaAsynPool(), paramIMyActivity, paramCartRequest, paramgo, true, false);
//    }
//
//    public static void syncCartRemove(HttpGroup paramHttpGroup, IMyActivity paramIMyActivity, CartRequest paramCartRequest, go paramgo, boolean paramBoolean1, boolean paramBoolean2)
//    {
//        paramCartRequest.setNotify(paramBoolean1);
//        paramCartRequest.setEffect(paramBoolean2);
//        syncCartWithCacheNew(paramCartRequest.getModelGroupUtil(), "cartRemove", paramHttpGroup, paramCartRequest, paramgo);
//    }
//
//    public static void syncCartRemoveNoCache(HttpGroup paramHttpGroup, IMyActivity paramIMyActivity, CartRequest paramCartRequest, HttpGroup.HttpTaskListener paramHttpTaskListener, boolean paramBoolean1, boolean paramBoolean2)
//    {
//        paramCartRequest.setNotify(paramBoolean1);
//        paramCartRequest.setEffect(paramBoolean2);
//        syncCart(paramHttpGroup, "cartRemove", paramIMyActivity, paramCartRequest, paramHttpTaskListener);
//    }
//
//    public static void syncCartUnCheckAll(IMyActivity paramIMyActivity, CartRequest paramCartRequest, go paramgo)
//    {
//        syncCartUnCheckAll(paramIMyActivity.getHttpGroupaAsynPool(), paramIMyActivity, paramCartRequest, paramgo, true, true);
//    }
//
//    public static void syncCartUnCheckAll(HttpGroup paramHttpGroup, IMyActivity paramIMyActivity, CartRequest paramCartRequest, go paramgo, boolean paramBoolean1, boolean paramBoolean2)
//    {
//        paramCartRequest.setNotify(paramBoolean1);
//        paramCartRequest.setEffect(paramBoolean2);
//        syncCartWithCacheNew(paramCartRequest.getModelGroupUtil(), "cartUnCheckAll", paramHttpGroup, paramCartRequest, paramgo);
//    }
//
//    public static void syncCartUnCheckSingle(IMyActivity paramIMyActivity, CartRequest paramCartRequest, HttpGroup.HttpTaskListener paramHttpTaskListener)
//    {
//        syncCartUnCheckSingleNoCache(paramIMyActivity.getHttpGroupaAsynPool(), paramIMyActivity, paramCartRequest, paramHttpTaskListener, true, true);
//    }
//
//    public static void syncCartUnCheckSingle(HttpGroup paramHttpGroup, CartRequest paramCartRequest, go paramgo, boolean paramBoolean1, boolean paramBoolean2)
//    {
//        paramCartRequest.setNotify(paramBoolean1);
//        paramCartRequest.setEffect(paramBoolean2);
//        syncCartWithCacheNew(paramCartRequest.getModelGroupUtil(), "cartUnCheckSingle", paramHttpGroup, paramCartRequest, paramgo);
//    }
//
//    public static void syncCartUnCheckSingleNoCache(HttpGroup paramHttpGroup, IMyActivity paramIMyActivity, CartRequest paramCartRequest, HttpGroup.HttpTaskListener paramHttpTaskListener, boolean paramBoolean1, boolean paramBoolean2)
//    {
//        paramCartRequest.setNotify(paramBoolean1);
//        paramCartRequest.setEffect(paramBoolean2);
//        syncCart(paramHttpGroup, "cartUnCheckSingle", paramIMyActivity, paramCartRequest, paramHttpTaskListener);
//    }
//
//    public static void syncCartWithCache(gm paramgm, HttpGroup paramHttpGroup, IMyActivity paramIMyActivity, CartRequest paramCartRequest, go paramgo)
//    {
//        syncCartWithCacheNew(paramgm, "cart", paramHttpGroup, paramCartRequest, paramgo);
//    }
//
//    public static void syncCartWithCacheNew(gm paramgm, String paramString, HttpGroup paramHttpGroup, CartRequest paramCartRequest, go paramgo)
//    {
//        paramgm.a(200);
//        paramgm.f(true);
//        paramgm.c(true);
//        paramgm.a(Configuration.getCartHost());
//        paramgm.a(300000L);
//        paramgm.b(Md5Encrypt.md5(combineCartCacheKey()));
//        paramgm.e(paramCartRequest.isEffect());
//        paramgm.a(paramCartRequest.getLoadingViewRoot());
//        paramCartRequest = getCartRequestParam(paramCartRequest);
//        long l = CommonUtil.getLongFromPreference("isShowNotificationBar", 0L);
//        if (1L == l);
//        try
//        {
//            paramCartRequest.put("specialId", l);
//            paramgm.a(paramHttpGroup, paramString, paramCartRequest.toString(), paramgo);
//            return;
//        }
//        catch (JSONException localJSONException)
//        {
//            while (true)
//                localJSONException.printStackTrace();
//        }
//    }
//
//    public static void syncCartWithNoCache(HttpGroup paramHttpGroup, IMyActivity paramIMyActivity, CartRequest paramCartRequest, HttpGroup.OnCommonListener paramOnCommonListener, String paramString1, String paramString2, ViewGroup paramViewGroup)
//    {
//        if (paramIMyActivity == null)
//            return;
//        HttpGroup localHttpGroup = paramHttpGroup;
//        if (paramHttpGroup == null)
//            localHttpGroup = paramIMyActivity.getHttpGroupaAsynPool();
//        paramHttpGroup = paramCartRequest;
//        if (paramCartRequest == null)
//            paramHttpGroup = new CartRequest();
//        paramHttpGroup.setNoResponse(Boolean.valueOf(false));
//        paramHttpGroup.setNotify(false);
//        paramHttpGroup.setEffect(false);
//        if (paramViewGroup != null)
//            paramHttpGroup.setLoadingViewRoot(paramViewGroup);
//        paramIMyActivity = getCartRequestParam(paramHttpGroup);
//        if (!TextUtils.isEmpty(paramString1));
//        try
//        {
//            paramIMyActivity.put("refer", paramString1);
//            if (TextUtils.isEmpty(paramString2));
//        }
//        catch (JSONException paramCartRequest)
//        {
//            try
//            {
//                paramIMyActivity.put("response", paramString2);
//                paramCartRequest = new HttpGroup.HttpSetting();
//                paramCartRequest.setFunctionId("cart");
//                paramCartRequest.setJsonParams(paramIMyActivity);
//                paramCartRequest.setHost(Configuration.getCartHost());
//                paramCartRequest.setNotifyUser(paramHttpGroup.isNotify());
//                paramCartRequest.setOnTouchEvent(paramHttpGroup.isTouch());
//                if (paramHttpGroup.getLoadingViewRoot() != null)
//                    paramCartRequest.setProgressBarRootLayout(paramHttpGroup.getLoadingViewRoot());
//                paramCartRequest.setLocalFileCache(false);
//                if (paramOnCommonListener != null)
//                    paramCartRequest.setListener(paramOnCommonListener);
//                if (paramHttpGroup.isEffect())
//                {
//                    paramCartRequest.setEffect(1);
//                    if (Log.D)
//                    {
//                        Log.d("ShoppingController", "syncCartWithNoCache() : params -> " + paramIMyActivity);
//                        Log.d("ShoppingController", "syncCartWithNoCache() : getUrl -> " + paramCartRequest.getUrl());
//                        Log.d("ShoppingController", "syncCartWithNoCache() : getHost -> " + paramCartRequest.getHost());
//                    }
//                    localHttpGroup.add(paramCartRequest);
//                    return;
//                    paramCartRequest = paramCartRequest;
//                    paramCartRequest.printStackTrace();
//                }
//            }
//            catch (JSONException paramCartRequest)
//            {
//                while (true)
//                {
//                    paramCartRequest.printStackTrace();
//                    continue;
//                    paramCartRequest.setEffect(0);
//                }
//            }
//        }
//    }
//
//    public static void syncCartWithNoResponse(IMyActivity paramIMyActivity, ShoppingBaseController.ShoppingListener paramShoppingListener)
//    {
//        CartRequest localCartRequest = new CartRequest();
//        localCartRequest.setNoResponse(Boolean.valueOf(true));
//        syncCart(paramIMyActivity, localCartRequest, new ShoppingBaseController.ShoppingHttpListener(paramShoppingListener), true, false);
//    }
//
//    public static void unSelectAll(gm paramgm, IMyActivity paramIMyActivity, ShoppingBaseController.ShoppingWithoutListener paramShoppingWithoutListener, ViewGroup paramViewGroup)
//    {
//        if (Log.D)
//            Log.d("ShoppingController", " unSelectAll -->> myActivity:" + paramIMyActivity + ", listener:" + paramShoppingWithoutListener);
//        CartRequest localCartRequest = new CartRequest(new CartRequestOperate("8"));
//        localCartRequest.setLoadingViewRoot(paramViewGroup);
//        localCartRequest.setModelGroupUtil(paramgm);
//        syncCartUnCheckAll(paramIMyActivity, localCartRequest, new ShoppingBaseController.HttpWithoutUpdateListener(paramShoppingWithoutListener));
//    }
//
//    public static void unSelectListProductOrPack(IMyActivity paramIMyActivity, ArrayList<CartSkuSummary> paramArrayList, ArrayList<CartPackSummary> paramArrayList1, ShoppingBaseController.ShoppingListener paramShoppingListener)
//    {
//        int k = 0;
//        if (Log.D)
//            Log.d("ShoppingController", " unSelectListProductOrPack -->> myActivity:" + paramIMyActivity + ", unSelectSkuList:" + paramArrayList + ", unSelectePackList:" + paramArrayList1 + ", listener:" + paramShoppingListener);
//        if ((paramArrayList == null) && (paramArrayList1 == null));
//        ArrayList localArrayList;
//        do
//        {
//            return;
//            localArrayList = new ArrayList();
//            if (paramArrayList == null);
//            int j;
//            for (int i = 0; ; i = paramArrayList.size())
//            {
//                j = 0;
//                while (j < i)
//                {
//                    localArrayList.add(new CartRequestOperate((CartSkuSummary)paramArrayList.get(j), null, "6"));
//                    j += 1;
//                }
//            }
//            if (paramArrayList1 == null)
//            {
//                i = 0;
//                j = k;
//            }
//            while (j < i)
//            {
//                localArrayList.add(new CartRequestOperate(null, (CartPackSummary)paramArrayList1.get(j), "6"));
//                j += 1;
//                continue;
//                i = paramArrayList1.size();
//                j = k;
//            }
//            if (!Log.D)
//                continue;
//            Log.d("ShoppingController", " unSelectListProductOrPack ---> requestOperateList.size() : " + localArrayList.size());
//        }
//        while (localArrayList.size() == 0);
//        syncCartUnCheckSingle(paramIMyActivity, new CartRequest(localArrayList), new ShoppingBaseController.ShoppingHttpListener(paramShoppingListener));
//    }
//
//    public static void unSelectOneProductOrPack(IMyActivity paramIMyActivity, CartResponseInfo paramCartResponseInfo, ArrayList<OrderCommodity> paramArrayList, ShoppingBaseController.ShoppingListener paramShoppingListener)
//    {
//        ArrayList localArrayList1 = new ArrayList();
//        ArrayList localArrayList2 = new ArrayList();
//        int n = paramCartResponseInfo.getGifts().size();
//        int i1 = paramCartResponseInfo.getSkus().size();
//        int i2 = paramCartResponseInfo.getSuits().size();
//        int i = 0;
//        while (i < paramArrayList.size())
//        {
//            OrderCommodity localOrderCommodity = (OrderCommodity)paramArrayList.get(i);
//            int m = 0;
//            int k = 0;
//            int j = m;
//            Object localObject;
//            if (k < n)
//            {
//                localObject = (CartResponseGift)paramCartResponseInfo.getGifts().get(k);
//                if ((TextUtils.isEmpty(localOrderCommodity.getPromoId())) && (TextUtils.equals(((CartResponseGift)localObject).getSkuId(), localOrderCommodity.getId())))
//                {
//                    localArrayList1.add(localObject);
//                    j = 1;
//                }
//            }
//            else
//            {
//                k = 0;
//                label140: if ((k >= i1) || (j != 0))
//                    break label239;
//                localObject = (CartResponseSku)paramCartResponseInfo.getSkus().get(k);
//                if (localObject != null)
//                    break label189;
//            }
//            label189:
//            do
//            {
//                k += 1;
//                break label140;
//                k += 1;
//                break;
//            }
//            while ((!TextUtils.isEmpty(localOrderCommodity.getPromoId())) || (!TextUtils.equals(((CartResponseSku)localObject).getSkuId(), localOrderCommodity.getId())));
//            localArrayList1.add(new CartSkuSummary(((CartResponseSku)localObject).getSkuId(), ((CartResponseSku)localObject).getNum()));
//            label239: j = 0;
//            while (j < i2)
//            {
//                localObject = (CartResponseSuit)paramCartResponseInfo.getSuits().get(j);
//                if (localObject == null)
//                {
//                    j += 1;
//                    continue;
//                }
//                if (((CartResponseSuit)localObject).getSkus() == null);
//                for (k = 0; ; k = ((CartResponseSuit)localObject).getSkus().size())
//                {
//                    m = 0;
//                    while (m < k)
//                    {
//                        CartResponseSku localCartResponseSku = (CartResponseSku)((CartResponseSuit)localObject).getSkus().get(m);
//                        if ((localCartResponseSku.isChecked()) && (!TextUtils.isEmpty(localOrderCommodity.getPromoId())) && (TextUtils.equals(localCartResponseSku.getSkuId(), localOrderCommodity.getId())))
//                        {
//                            CartPackSummary localCartPackSummary = new CartPackSummary(((CartResponseSuit)localObject).getPackId(), ((CartResponseSuit)localObject).getNum(), ((CartResponseSuit)localObject).getsType());
//                            localCartPackSummary.addSku(localCartResponseSku);
//                            localArrayList2.add(localCartPackSummary);
//                        }
//                        m += 1;
//                    }
//                    break;
//                }
//            }
//            i += 1;
//        }
//        unSelectListProductOrPack(paramIMyActivity, localArrayList1, localArrayList2, paramShoppingListener);
//    }
//
//    public static void unSelectOneProductOrPack(gm paramgm, IMyActivity paramIMyActivity, CartSkuSummary paramCartSkuSummary, CartPackSummary paramCartPackSummary, ShoppingBaseController.ShoppingWithoutListener paramShoppingWithoutListener, ViewGroup paramViewGroup)
//    {
//        if (Log.D)
//            Log.d("ShoppingController", " unSelectOneProductOrPack -->> myActivity:" + paramIMyActivity + ", unSelectSku:" + paramCartSkuSummary + ", unSelectePack:" + paramCartPackSummary + ", listener:" + paramShoppingWithoutListener);
//        if ((paramCartSkuSummary == null) && (paramCartPackSummary == null))
//            return;
//        ArrayList localArrayList = new ArrayList();
//        localArrayList.add(new CartRequestOperate(paramCartSkuSummary, paramCartPackSummary, "6"));
//        paramCartSkuSummary = new CartRequest(localArrayList);
//        paramCartSkuSummary.setLoadingViewRoot(paramViewGroup);
//        paramCartSkuSummary.setModelGroupUtil(paramgm);
//        syncCartUnCheckSingle(paramIMyActivity.getHttpGroupaAsynPool(), paramCartSkuSummary, new ShoppingBaseController.HttpWithoutUpdateListener(paramShoppingWithoutListener), true, true);
//    }
//
//    public static void unSelectOneShop(gm paramgm, IMyActivity paramIMyActivity, CartResponseShop paramCartResponseShop, ShoppingBaseController.ShoppingWithoutListener paramShoppingWithoutListener, ViewGroup paramViewGroup)
//    {
//        if (Log.D)
//            Log.d("ShoppingController", " unSelectOneShop -->> myActivity:" + paramIMyActivity);
//        if ((paramCartResponseShop == null) || (paramCartResponseShop.getCartSummary() == null) || (paramCartResponseShop.getCartSummary().size() == 0));
//        ArrayList localArrayList1;
//        ArrayList localArrayList2;
//        do
//        {
//            return;
//            localArrayList1 = new ArrayList();
//            localArrayList2 = new ArrayList();
//            paramCartResponseShop = paramCartResponseShop.getCartSummary().iterator();
//            while (paramCartResponseShop.hasNext())
//            {
//                Object localObject = paramCartResponseShop.next();
//                if ((localObject instanceof CartResponseSku))
//                {
//                    localObject = (CartResponseSku)localObject;
//                    if (!((CartResponseSku)localObject).isChecked())
//                        continue;
//                    localArrayList1.add(new CartSkuSummary(((CartResponseSku)localObject).getSkuId(), ((CartResponseSku)localObject).getNum()));
//                    continue;
//                }
//                if (!(localObject instanceof CartResponseSuit))
//                    continue;
//                localObject = (CartResponseSuit)localObject;
//                if (!((CartResponseSuit)localObject).isChecked())
//                    continue;
//                CartPackSummary localCartPackSummary = new CartPackSummary(((CartResponseSuit)localObject).getPackId(), ((CartResponseSuit)localObject).getNum(), ((CartResponseSuit)localObject).getsType());
//                localCartPackSummary.setSkus(((CartResponseSuit)localObject).getSkus());
//                localArrayList2.add(localCartPackSummary);
//            }
//            if (!Log.D)
//                continue;
//            Log.d("ShoppingController", " unSelectOneShop ---> selectSkus.size() : " + localArrayList1.size());
//            Log.d("ShoppingController", " unSelectOneShop ---> selectPacks.size() : " + localArrayList2.size());
//        }
//        while ((localArrayList1.size() == 0) && (localArrayList2.size() == 0));
//        paramCartResponseShop = new ArrayList();
//        paramCartResponseShop.add(new CartRequestOperate(localArrayList1, localArrayList2, "6"));
//        paramCartResponseShop = new CartRequest(paramCartResponseShop);
//        paramCartResponseShop.setLoadingViewRoot(paramViewGroup);
//        paramCartResponseShop.setModelGroupUtil(paramgm);
//        syncCartUnCheckSingle(paramIMyActivity.getHttpGroupaAsynPool(), paramCartResponseShop, new ShoppingBaseController.HttpWithoutUpdateListener(paramShoppingWithoutListener), true, true);
//    }
//
//    private static void validateCartIcon()
//    {
//        try
//        {
//            c localc = BaseApplication.getInstance().getMainFrameActivity();
//            if (localc != null)
//                localc.e();
//            return;
//        }
//        catch (Exception localException)
//        {
//            while (!Log.D);
//            localException.printStackTrace();
//        }
//    }
}
