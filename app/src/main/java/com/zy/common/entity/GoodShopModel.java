package com.zy.common.entity;

import com.jingdong.common.utils.JSONObjectProxy;
import com.zy.common.utils.JSONArrayProxy;

import java.util.ArrayList;

/**
 * Created by robin on 16-7-28.
 */
public class GoodShopModel {
    public static final String TAG = "GoodShopModel";
    private int shopCategoriesCount;
    private int shopCategoriesId;
    private String shopCategoriesTitle;
    private int shopId;
    private String shopImage;
    private String shopName;
    private String sourceValue;
    private ArrayList<GoodShopModel.WareModel> wareList = new ArrayList();

    public GoodShopModel(JSONObjectProxy paramJSONObjectProxy)
    {
        setShopId(paramJSONObjectProxy.optInt("shopId"));
        setShopName(paramJSONObjectProxy.optString("shopName"));
        setSourceValue(paramJSONObjectProxy.optString("sourceValue"));
        setShopImage(paramJSONObjectProxy.optString("shopImage"));
        Object localObject = paramJSONObjectProxy.getJSONObjectOrNull("shopCategories");
        if (localObject != null){
            setShopCategoriesId(((JSONObjectProxy)localObject).optInt("cid"));
            setShopCategoriesTitle(((JSONObjectProxy)localObject).optString("name"));
            setShopCategoriesCount(((JSONObjectProxy)localObject).optInt("shopCount"));
        }
        JSONArrayProxy arrayProxy = paramJSONObjectProxy.getJSONArrayOrNull("wareList");
        if (arrayProxy != null)
        {
            int length = arrayProxy.length();
            if (length > 0){
                for (int i = 0; i < length; i++)
                {
                    JSONObjectProxy proxy = arrayProxy.getJSONObjectOrNull(i);
                    if (proxy != null){
                        GoodShopModel.WareModel wareModel = new GoodShopModel.WareModel(proxy.optLong("wareId"), proxy.optString("imgPath"));
                        this.wareList.add(wareModel);
                    }

                }
            }
        }
    }

    public static String getCategories(JSONArrayProxy paramJSONArrayPoxy)
    {
        if ((paramJSONArrayPoxy == null) || (paramJSONArrayPoxy.length() == 0))
            return null;
        JSONArrayProxy localJSONArrayPoxy = new JSONArrayProxy();
        int j = paramJSONArrayPoxy.length();

        for (int i = 0; i < j; i++)
        {
            JSONObjectProxy localJSONObjectProxy = paramJSONArrayPoxy.getJSONObjectOrNull(i);
            if (localJSONObjectProxy != null)
                localJSONArrayPoxy.put(localJSONObjectProxy.optJSONObject("shopCategories"));

        }
        return localJSONArrayPoxy.toString();
    }

    public static ArrayList<GoodShopModel> toList(JSONArrayProxy paramJSONArrayPoxy)
    {
        ArrayList localArrayList = null;
        if ((paramJSONArrayPoxy != null) && (paramJSONArrayPoxy.length() != 0)){
            localArrayList = new ArrayList();
            int length = paramJSONArrayPoxy.length();

            for (int i = 0; i < length; i++){//if-ge v1, v2, :cond_1
                Object localObject = paramJSONArrayPoxy.getJSONObjectOrNull(i);
                if (localObject != null){
                    GoodShopModel localGoodShopModel = new GoodShopModel((JSONObjectProxy)localObject);
                    if (i >= 11)
                        break;
                    localArrayList.add(localGoodShopModel);
                }
            }
        }
        return localArrayList;
    }

    public int getShopCategoriesCount()
    {
        return this.shopCategoriesCount;
    }

    public int getShopCategoriesId()
    {
        return this.shopCategoriesId;
    }

    public String getShopCategoriesTitle()
    {
        return this.shopCategoriesTitle;
    }

    public int getShopId()
    {
        return this.shopId;
    }

    public String getShopImage()
    {
        return this.shopImage;
    }

    public String getShopName()
    {
        return this.shopName;
    }

    public String getSourceValue()
    {
        return this.sourceValue;
    }

    public ArrayList<GoodShopModel.WareModel> getWareList()
    {
        return this.wareList;
    }

    public void setShopCategoriesCount(int paramInt)
    {
        this.shopCategoriesCount = paramInt;
    }

    public void setShopCategoriesId(int paramInt)
    {
        this.shopCategoriesId = paramInt;
    }

    public void setShopCategoriesTitle(String paramString)
    {
        this.shopCategoriesTitle = paramString;
    }

    public void setShopId(int paramInt)
    {
        this.shopId = paramInt;
    }

    public void setShopImage(String paramString)
    {
        this.shopImage = paramString;
    }

    public void setShopName(String paramString)
    {
        this.shopName = paramString;
    }

    public void setSourceValue(String paramString)
    {
        this.sourceValue = paramString;
    }

    public void setWareList(ArrayList<GoodShopModel.WareModel> paramArrayList)
    {
        this.wareList = paramArrayList;
    }

    public class WareModel
    {
        public String imgPath;
        public long wareId;

        public WareModel(long paramLong, String paramString)
        {
            this.wareId = paramLong;
            this.imgPath = paramString;
        }
    }

}
