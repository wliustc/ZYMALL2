package com.zy.common.entity;

import android.text.TextUtils;

import com.jingdong.common.utils.JSONObjectProxy;
import com.zy.common.utils.JSONArrayProxy;
import com.zy.common.utils.Log;

import org.json.JSONException;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by robin on 16-8-17.
 */
public class Catelogy implements Serializable {
    public static final int CATELOGY = 0;
    public static final int CATELOGY_FILTER = 1;
    public static final int CATELOGY_NEW = 3;
    public static final int CATELOGY_PROMOTION = 2;
    private static final String DESTINATION_AIRLINE_M = "airline_m";
    private static final String DESTINATION_DATA_RECHARGE = "data_charge";
    private static final String DESTINATION_EBOOK_M = "ebook_m";
    private static final String DESTINATION_GAME_RECHARGE = "game_charge";
    private static final String DESTINATION_HOTBOOK = "hot_book";
    private static final String DESTINATION_JD_GAME_M = "jdgame_to";
    private static final String DESTINATION_LOTTERY_M = "lottery_m";
    private static final String DESTINATION_MOVIE = "movie";
    private static final String DESTINATION_M_WITH_ACTION = "_m";
    private static final String DESTINATION_M_WITH_TO = "_to";
    private static final String DESTINATION_NEWBOOK = "new_book";
    private static final String DESTINATION_QQ_RECHARGE = "QQ_charge";
    private static final String DESTINATION_RECHARGE_M = "chongzhi_m";
    public static final int RECORMMEND = 4;
    private static final String TAG = "Catelogy";
    private String action;
    private ArrayList<Catelogy> addHeaderChildCategories;
    private String cId;
    private ArrayList<Catelogy> childCategories;
    private int columNum;
    private String description;
    private String destination;
    private String fId;
    private String field;
    private boolean hasLevelFour;
    private Catelogy headerCatelogy;
    private List<Image> imageList = new LinkedList();
    private String imgUrl;
    private int level;
    private String level1Cid;
    private String level2Cid;
    private String level3Cid;
    private JSONArrayProxy levelFourJsonArray;
    private List<CatelogyLevelFour> levelFourList;
    private List<Catelogy.MergedCatelogy> mergeCatalogs = null;
    private String name;
    private int num;
    private int orderSort;
    private String path;
    private long promotionID;
    private String searchKey;
    private int sensitiveFlag;
    private Long shopId;
    private boolean showTab = false;
    private int virtualFlag;
    private Integer wareNumber;

    public Catelogy()
    {
    }

    public Catelogy(JSONObjectProxy paramJSONObjectProxy, int paramInt)
    {
        switch (paramInt)
        {
            default:
            case 0:
            case 1:
            case 2:
            case 3:
            case 4:
        }
        label408:
        do
        {
            do
            {
                do
                {
                    return;
                    this.cId = paramJSONObjectProxy.getStringOrNull("cid");
                    this.level = paramJSONObjectProxy.getIntOrNull("level").intValue();
                    this.name = paramJSONObjectProxy.getStringOrNull("name");
                    this.mergeCatalogs = Catelogy.MergedCatelogy.toList(paramJSONObjectProxy.getJSONArrayOrNull("mergeCatalogs"));
                    this.showTab = paramJSONObjectProxy.optBoolean("showTab");
                    return;
                    setcId(paramJSONObjectProxy.getStringOrNull("cid"));
                    setName(paramJSONObjectProxy.getStringOrNull("name"));
                    setWareNumber(paramJSONObjectProxy.getIntOrNull("wareNumber"));
                    setField(paramJSONObjectProxy.getStringOrNull("filed"));
                    doCatelogyArray(paramJSONObjectProxy.getJSONArrayOrNull("childs"));
                    this.headerCatelogy = new Catelogy();
                    this.headerCatelogy = this;
                    return;
                }
                while (paramJSONObjectProxy == null);
                setcId(paramJSONObjectProxy.getStringOrNull("catelogyId"));
                setName(paramJSONObjectProxy.getStringOrNull("promotion_name"));
                this.description = paramJSONObjectProxy.getStringOrNull("promotion_info");
                this.imgUrl = paramJSONObjectProxy.getStringOrNull("imageUrl");
                try
                {
                    this.promotionID = paramJSONObjectProxy.getLongOrNull("promotion_id").longValue();
                    return;
                }
                catch (NullPointerException e)
                {
                    e.printStackTrace();
                    return;
                }
            }
            while (paramJSONObjectProxy == null);
            this.name = paramJSONObjectProxy.getStringOrNull("name");
            this.imgUrl = paramJSONObjectProxy.getStringOrNull("icon");
            this.cId = paramJSONObjectProxy.getStringOrNull("cid");
            this.virtualFlag = paramJSONObjectProxy.optInt("virtualFlag");
            if (this.virtualFlag != 0)
            {
                if (this.virtualFlag == 1)
                    this.searchKey = paramJSONObjectProxy.getStringOrNull("searchKey");
            }
            else
            {
                this.action = paramJSONObjectProxy.getStringOrNull("action");
                this.destination = paramJSONObjectProxy.getStringOrNull("destination");
                this.path = paramJSONObjectProxy.getStringOrNull("path");
                if (paramJSONObjectProxy.optInt("YNlevelF", 0) != 0)
                    break label408;
                setHasLevelFour(false);
            }
            while (true)
            {
                this.levelFourJsonArray = paramJSONObjectProxy.getJSONArrayOrNull("level_f");
                this.levelFourList = getLevelFourList(this.levelFourJsonArray);
                return;
                if (this.virtualFlag != 2)
                    break;
                this.shopId = paramJSONObjectProxy.getLongOrNull("shopId");
                break;
                setHasLevelFour(true);
            }
        }
        while (paramJSONObjectProxy == null);
        this.path = paramJSONObjectProxy.getStringOrNull("path");
        if (!TextUtils.isEmpty(this.path))
        {
            String[] arrayOfString = this.path.split("_");
            this.level1Cid = arrayOfString[0];
            this.level2Cid = arrayOfString[1];
            this.level3Cid = arrayOfString[2];
        }
        this.cId = paramJSONObjectProxy.getStringOrNull("cid");
        this.name = paramJSONObjectProxy.getStringOrNull("name");
        this.imgUrl = paramJSONObjectProxy.getStringOrNull("icon");
        this.columNum = paramJSONObjectProxy.optInt("columNum");
        this.virtualFlag = paramJSONObjectProxy.optInt("virtualFlag");
        if (this.virtualFlag != 0)
        {
            if (this.virtualFlag == 1)
                this.searchKey = paramJSONObjectProxy.getStringOrNull("searchKey");
        }
        else
        {
            this.action = paramJSONObjectProxy.getStringOrNull("action");
            this.destination = paramJSONObjectProxy.getStringOrNull("destination");
            this.sensitiveFlag = paramJSONObjectProxy.optInt("sensitiveFlag");
            if (paramJSONObjectProxy.optInt("YNlevelF", 0) != 0)
                break label639;
            setHasLevelFour(false);
        }
        while (true)
        {
            this.levelFourJsonArray = paramJSONObjectProxy.getJSONArrayOrNull("level_f");
            this.levelFourList = getLevelFourList(this.levelFourJsonArray);
            return;
            if (this.virtualFlag != 2)
                break;
            this.shopId = paramJSONObjectProxy.getLongOrNull("shopId");
            break;
            label639: setHasLevelFour(true);
        }
    }

    private void doCatelogyArray(JSONArrayProxy paramJSONArrayPoxy)
    {
        if (Log.D)
        {
            Log.d("Catelogy", "doCatelogyArray() -->> ");
            if (paramJSONArrayPoxy != null)
                Log.d("Catelogy", "jsonArrayOrNull.length() == " + paramJSONArrayPoxy.length());
        }
        if ((paramJSONArrayPoxy == null) || (paramJSONArrayPoxy.length() <= 0))
            break label54;
        label54:
        do
            return;
        while (this.childCategories != null);
        this.childCategories = new ArrayList();
        int j = paramJSONArrayPoxy.length();
        int i = 0;
        while (i < j)
            try
            {
                Catelogy localCatelogy = new Catelogy(paramJSONArrayPoxy.getJSONObject(i), 1);
                this.childCategories.add(i, localCatelogy);
                i += 1;
            }
            catch (JSONException localJSONException)
            {
                while (true)
                    localJSONException.printStackTrace();
            }
    }

    public static String getCmsTotalCid(ArrayList<Catelogy> paramArrayList, int paramInt)
    {
        Object localObject2;
        if (paramInt <= 0)
            localObject2 = "null";
        Object localObject1;
        int i;
        do
        {
            return localObject2;
            localObject1 = "";
            i = 0;
            localObject2 = localObject1;
        }
        while (i >= paramInt);
        if (i < paramInt - 1)
            localObject2 = (String)localObject1 + ((Catelogy)paramArrayList.get(i)).getcId() + "_";
        while (true)
        {
            i += 1;
            localObject1 = localObject2;
            break;
            localObject2 = localObject1;
            if (i != paramInt - 1)
                continue;
            localObject2 = (String)localObject1 + ((Catelogy)paramArrayList.get(i)).getcId();
        }
    }

    private List<CatelogyLevelFour> getLevelFourList(JSONArrayPoxy paramJSONArrayPoxy)
    {
        if (Log.D)
        {
            Log.d("Catelogy", "getLevelFourList() -->> ");
            if (paramJSONArrayPoxy != null)
                Log.d("Catelogy", "jsonArrayOrNull.length() == " + paramJSONArrayPoxy.length());
        }
        Object localObject;
        if ((paramJSONArrayPoxy == null) || (paramJSONArrayPoxy.length() <= 0))
        {
            localObject = null;
            return localObject;
        }
        int j = paramJSONArrayPoxy.length();
        ArrayList localArrayList = new ArrayList();
        int i = 0;
        while (true)
        {
            localObject = localArrayList;
            if (i >= j)
                break;
            localObject = new CatelogyLevelFour();
            try
            {
                JSONObjectProxy localJSONObjectProxy = paramJSONArrayPoxy.getJSONObject(i);
                ((CatelogyLevelFour)localObject).setCatalogId(localJSONObjectProxy.optString("catalogId"));
                ((CatelogyLevelFour)localObject).setCatalogName(localJSONObjectProxy.optString("getCatalogName"));
                localArrayList.add(localObject);
                i += 1;
            }
            catch (JSONException localJSONException)
            {
                while (true)
                    localJSONException.printStackTrace();
            }
        }
    }

    // ERROR //
    public static ArrayList<Catelogy> toList(JSONArrayProxy paramJSONArrayPoxy, int paramInt)
    {
        // Byte code:
        //   0: new 322	java/util/ArrayList
        //   3: dup
        //   4: invokespecial 323	java/util/ArrayList:<init>	()V
        //   7: astore_3
        //   8: iconst_0
        //   9: istore 4
        //   11: aload_3
        //   12: astore_2
        //   13: iload 4
        //   15: aload_0
        //   16: invokevirtual 310	com/jingdong/common/utils/JSONArrayPoxy:length	()I
        //   19: if_icmpge +77 -> 96
        //   22: aload_0
        //   23: iload 4
        //   25: invokevirtual 327	com/jingdong/common/utils/JSONArrayPoxy:getJSONObject	(I)Lcom/jingdong/common/utils/JSONObjectProxy;
        //   28: ifnull +36 -> 64
        //   31: aload_0
        //   32: iload 4
        //   34: invokevirtual 327	com/jingdong/common/utils/JSONArrayPoxy:getJSONObject	(I)Lcom/jingdong/common/utils/JSONObjectProxy;
        //   37: ldc 144
        //   39: invokevirtual 381	com/jingdong/common/utils/JSONObjectProxy:isNull	(Ljava/lang/String;)Z
        //   42: ifne +22 -> 64
        //   45: aload_3
        //   46: new 2	com/jingdong/common/entity/Catelogy
        //   49: dup
        //   50: aload_0
        //   51: iload 4
        //   53: invokevirtual 327	com/jingdong/common/utils/JSONArrayPoxy:getJSONObject	(I)Lcom/jingdong/common/utils/JSONObjectProxy;
        //   56: iload_1
        //   57: invokespecial 329	com/jingdong/common/entity/Catelogy:<init>	(Lcom/jingdong/common/utils/JSONObjectProxy;I)V
        //   60: invokevirtual 382	java/util/ArrayList:add	(Ljava/lang/Object;)Z
        //   63: pop
        //   64: iload 4
        //   66: iconst_1
        //   67: iadd
        //   68: istore 4
        //   70: goto -59 -> 11
        //   73: astore_3
        //   74: aconst_null
        //   75: astore_0
        //   76: aload_0
        //   77: astore_2
        //   78: getstatic 385	com/jingdong/common/utils/Log:V	Z
        //   81: ifeq +15 -> 96
        //   84: ldc_w 387
        //   87: aload_3
        //   88: invokevirtual 390	org/json/JSONException:getMessage	()Ljava/lang/String;
        //   91: invokestatic 393	com/jingdong/common/utils/Log:v	(Ljava/lang/String;Ljava/lang/String;)V
        //   94: aload_0
        //   95: astore_2
        //   96: getstatic 293	com/jingdong/common/utils/Log:D	Z
        //   99: ifeq +25 -> 124
        //   102: ldc 60
        //   104: new 301	java/lang/StringBuilder
        //   107: dup
        //   108: ldc_w 395
        //   111: invokespecial 305	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
        //   114: aload_2
        //   115: invokevirtual 398	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
        //   118: invokevirtual 318	java/lang/StringBuilder:toString	()Ljava/lang/String;
        //   121: invokestatic 299	com/jingdong/common/utils/Log:d	(Ljava/lang/String;Ljava/lang/String;)V
        //   124: aload_2
        //   125: areturn
        //   126: astore_2
        //   127: aload_3
        //   128: astore_0
        //   129: aload_2
        //   130: astore_3
        //   131: goto -55 -> 76
        //
        // Exception table:
        //   from	to	target	type
        //   0	8	73	org/json/JSONException
        //   13	64	126	org/json/JSONException
    }

    public String getAction()
    {
        if (this.action == null)
            return "";
        return this.action;
    }

    public ArrayList<Catelogy> getAddHeaderChildCategories()
    {
        if ((this.childCategories != null) && (this.childCategories.size() >= 0))
        {
            this.addHeaderChildCategories = this.childCategories;
            if ((this.headerCatelogy != null) && (!this.addHeaderChildCategories.contains(this.headerCatelogy)))
                this.addHeaderChildCategories.add(0, this.headerCatelogy);
        }
        return this.addHeaderChildCategories;
    }

    public ArrayList<Catelogy> getChildCategories()
    {
        return this.childCategories;
    }

    public int getColumNum()
    {
        return this.columNum;
    }

    public String getDescription()
    {
        if (TextUtils.isEmpty(this.description))
            return "";
        return this.description;
    }

    public String getDestination()
    {
        if (this.destination == null)
            return "";
        return this.destination;
    }

    public String getField()
    {
        return this.field;
    }

    public Image getImage()
    {
        if (this.imageList.size() > 0)
            return (Image)this.imageList.get(0);
        return null;
    }

    public List<Image> getImageList()
    {
        return this.imageList;
    }

    public String getImgUrl()
    {
        return this.imgUrl;
    }

    public int getLevel()
    {
        return this.level;
    }

    public String getLevel1Cid()
    {
        return this.level1Cid;
    }

    public String getLevel2Cid()
    {
        return this.level2Cid;
    }

    public String getLevel3Cid()
    {
        return this.level3Cid;
    }

    public List<CatelogyLevelFour> getLevelFourList()
    {
        return this.levelFourList;
    }

    public List<Catelogy.MergedCatelogy> getMergeCatalogs()
    {
        return this.mergeCatalogs;
    }

    public String getName()
    {
        if (TextUtils.isEmpty(this.name))
            return "";
        return this.name;
    }

    public int getNum()
    {
        return this.num;
    }

    public int getOrderSort()
    {
        return this.orderSort;
    }

    public String getPath()
    {
        return this.path;
    }

    public long getPromotionID()
    {
        return this.promotionID;
    }

    public String getSearchKey()
    {
        if (TextUtils.isEmpty(this.searchKey))
            return "";
        return this.searchKey;
    }

    public int getSensitiveFlag()
    {
        return this.sensitiveFlag;
    }

    public Long getShopId()
    {
        if ((this.shopId == null) || (this.shopId.longValue() <= 0L))
            return Long.valueOf(0L);
        return this.shopId;
    }

    public boolean getShowTab()
    {
        return this.showTab;
    }

    public int getVirtualFlag()
    {
        return this.virtualFlag;
    }

    public Integer getWareNumber()
    {
        return this.wareNumber;
    }

    public String getcId()
    {
        return this.cId;
    }

    public String getfId()
    {
        return this.fId;
    }

    public boolean isGoToHotBook()
    {
        return "hot_book".equals(getDestination());
    }

    public boolean isGoToMWithAction()
    {
        if (TextUtils.isEmpty(this.destination))
            return false;
        return this.destination.endsWith("_m");
    }

    public boolean isGoToMWithTo()
    {
        if (TextUtils.isEmpty(this.destination))
            return false;
        return this.destination.endsWith("_to");
    }

    public boolean isGoToMoviePage()
    {
        if (TextUtils.isEmpty(this.destination))
            return false;
        return this.destination.contains("movie");
    }

    public boolean isGoToNewBook()
    {
        return "new_book".equals(getDestination());
    }

    public boolean isHasLevelFour()
    {
        return this.hasLevelFour;
    }

    public boolean isWantedToAirLine()
    {
        return "airline_m".equals(getDestination());
    }

    public boolean isWantedToDataRecharge()
    {
        return "data_charge".equals(getDestination());
    }

    public boolean isWantedToEbookM()
    {
        return "ebook_m".equals(getDestination());
    }

    public boolean isWantedToGameRecharge()
    {
        return "game_charge".equals(getDestination());
    }

    public boolean isWantedToGoToShop()
    {
        return getShopId().longValue() > 0L;
    }

    public boolean isWantedToJDGame()
    {
        return "jdgame_to".equals(getDestination());
    }

    public boolean isWantedToLottery()
    {
        return "lottery_m".equals(getDestination());
    }

    public boolean isWantedToQqRecharge()
    {
        return "QQ_charge".equals(getDestination());
    }

    public boolean isWantedToRecharge()
    {
        return "chongzhi_m".equals(getDestination());
    }

    public boolean isWantedToSearchProduct()
    {
        return !TextUtils.isEmpty(getSearchKey());
    }

    public void setAction(String paramString)
    {
        this.action = paramString;
    }

    public void setChildCategories(ArrayList<Catelogy> paramArrayList)
    {
        this.childCategories = paramArrayList;
    }

    public void setColumNum(int paramInt)
    {
        this.columNum = paramInt;
    }

    public void setDescription(String paramString)
    {
        this.description = paramString;
    }

    public void setDestination(String paramString)
    {
        this.destination = paramString;
    }

    public void setField(String paramString)
    {
        this.field = paramString;
    }

    public void setHasLevelFour(boolean paramBoolean)
    {
        this.hasLevelFour = paramBoolean;
    }

    public void setImage(String paramString1, String paramString2)
    {
        this.imageList.add(new Image(paramString1, paramString2));
    }

    public void setImageList(List<Image> paramList)
    {
        this.imageList = paramList;
    }

    public void setImgUrl(String paramString)
    {
        this.imgUrl = paramString;
    }

    public void setLevel(int paramInt)
    {
        this.level = paramInt;
    }

    public void setLevel1Cid(String paramString)
    {
        this.level1Cid = paramString;
    }

    public void setLevel2Cid(String paramString)
    {
        this.level2Cid = paramString;
    }

    public void setLevel3Cid(String paramString)
    {
        this.level3Cid = paramString;
    }

    public void setLevelFourList(List<CatelogyLevelFour> paramList)
    {
        this.levelFourList = paramList;
    }

    public void setName(String paramString)
    {
        this.name = paramString;
    }

    public void setNum(int paramInt)
    {
        this.num = paramInt;
    }

    public void setOrderSort(int paramInt)
    {
        this.orderSort = paramInt;
    }

    public void setPath(String paramString)
    {
        this.path = paramString;
    }

    public void setPromotionID(long paramLong)
    {
        this.promotionID = paramLong;
    }

    public void setSensitiveFlag(int paramInt)
    {
        this.sensitiveFlag = paramInt;
    }

    public void setWareNumber(Integer paramInteger)
    {
        this.wareNumber = paramInteger;
    }

    public void setcId(String paramString)
    {
        this.cId = paramString;
    }

    public void setfId(String paramString)
    {
        this.fId = paramString;
    }

    public final String toString()
    {
        return "cId = " + this.cId + ", name = " + this.name + ", level = " + this.level + ", showTab = " + this.showTab + "\r\n";
    }

    public static class MergedCatelogy implements Serializable
    {
        private String Id;
        private String name;
        private int order;

        public MergedCatelogy()
        {
        }

        public MergedCatelogy(JSONObjectProxy paramJSONObjectProxy)
        {
            this.Id = paramJSONObjectProxy.getStringOrNull("id");
            this.name = paramJSONObjectProxy.getStringOrNull("name");
            this.order = paramJSONObjectProxy.getIntOrNull("order").intValue();
        }

        public static java.util.ArrayList<MergedCatelogy> toList(JSONArrayProxy paramJSONArrayPoxy)
        {

        }

        public String getId()
        {
            return this.Id;
        }

        public String getName()
        {
            if (TextUtils.isEmpty(this.name))
                return "";
            return this.name;
        }

        public int getOrder()
        {
            return this.order;
        }

        public void setId(String paramString)
        {
            this.Id = paramString;
        }

        public void setName(String paramString)
        {
            this.name = paramString;
        }

        public void setOrder(int paramInt)
        {
            this.order = paramInt;
        }

        public final String toString()
        {
            return "Id = " + this.Id + ", name = " + this.name + ", order = " + this.order + "\r\n";
        }
    }
}
