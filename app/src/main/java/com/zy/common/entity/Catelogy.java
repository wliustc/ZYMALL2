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

    public Catelogy(JSONObjectProxy paramJSONObjectProxy, int paramInt) {
        switch (paramInt) {
            case 0://:pswitch_0
                this.cId = paramJSONObjectProxy.getStringOrNull("cid");
                this.level = paramJSONObjectProxy.getIntOrNull("level").intValue();
                this.name = paramJSONObjectProxy.getStringOrNull("name");
                this.mergeCatalogs = Catelogy.MergedCatelogy.toList(paramJSONObjectProxy.getJSONArrayOrNull("mergeCatalogs"));
                this.showTab = paramJSONObjectProxy.optBoolean("showTab");
                break;
            case 1://:pswitch_1
                setcId(paramJSONObjectProxy.getStringOrNull("cid"));
                setName(paramJSONObjectProxy.getStringOrNull("name"));
                setWareNumber(paramJSONObjectProxy.getIntOrNull("wareNumber"));
                setField(paramJSONObjectProxy.getStringOrNull("filed"));
                doCatelogyArray(paramJSONObjectProxy.getJSONArrayOrNull("childs"));
                this.headerCatelogy = new Catelogy();
                this.headerCatelogy = this;
                break;
            case 2://:pswitch_2
                if (paramJSONObjectProxy != null) {
                    setcId(paramJSONObjectProxy.getStringOrNull("catelogyId"));
                    setName(paramJSONObjectProxy.getStringOrNull("promotion_name"));
                    this.description = paramJSONObjectProxy.getStringOrNull("promotion_info");
                    this.imgUrl = paramJSONObjectProxy.getStringOrNull("imageUrl");
                    try {
                        this.promotionID = paramJSONObjectProxy.getLongOrNull("promotion_id").longValue();
                    } catch (NullPointerException e) {
                        e.printStackTrace();
                    }
                }
                break;
            case 3://:pswitch_3
                if (paramJSONObjectProxy == null) {

                }
                this.name = paramJSONObjectProxy.getStringOrNull("name");
                this.imgUrl = paramJSONObjectProxy.getStringOrNull("icon");
                this.cId = paramJSONObjectProxy.getStringOrNull("cid");
                this.virtualFlag = paramJSONObjectProxy.optInt("virtualFlag");
                if (this.virtualFlag != 0) {
                    if (this.virtualFlag == 1)
                        this.searchKey = paramJSONObjectProxy.getStringOrNull("searchKey");
                    else if (this.virtualFlag == 2)
                        this.shopId = paramJSONObjectProxy.getLongOrNull("shopId");
                }

                this.action = paramJSONObjectProxy.getStringOrNull("action");
                this.destination = paramJSONObjectProxy.getStringOrNull("destination");
                this.path = paramJSONObjectProxy.getStringOrNull("path");
                if (paramJSONObjectProxy.optInt("YNlevelF", 0) == 0)
                    setHasLevelFour(false);
                else
                    setHasLevelFour(true);

                this.levelFourJsonArray = paramJSONObjectProxy.getJSONArrayOrNull("level_f");
                this.levelFourList = getLevelFourList(this.levelFourJsonArray);
                break;
            case 4://:pswitch_4
                if (paramJSONObjectProxy == null) {
                    this.path = paramJSONObjectProxy.getStringOrNull("path");
                    if (!TextUtils.isEmpty(this.path)) {
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
                    if (this.virtualFlag != 0) {//if-eqz v0, :cond_5
                        if (this.virtualFlag == 1)//if-ne v0, v3, :cond_6
                            this.searchKey = paramJSONObjectProxy.getStringOrNull("searchKey");
                        else if (this.virtualFlag == 2)
                            this.shopId = paramJSONObjectProxy.getLongOrNull("shopId");
                    }

                    this.action = paramJSONObjectProxy.getStringOrNull("action");
                    this.destination = paramJSONObjectProxy.getStringOrNull("destination");
                    this.sensitiveFlag = paramJSONObjectProxy.optInt("sensitiveFlag");
                    if (paramJSONObjectProxy.optInt("YNlevelF", 0) == 0)
                        setHasLevelFour(false);
                    else
                        setHasLevelFour(true);

                    this.levelFourJsonArray = paramJSONObjectProxy.getJSONArrayOrNull("level_f");
                    this.levelFourList = getLevelFourList(this.levelFourJsonArray);
                }
                break;
        }
        return;

    }

    private void doCatelogyArray(JSONArrayProxy paramJSONArrayPoxy)
    {
        if (Log.D){
            Log.d("Catelogy", "doCatelogyArray() -->> ");
            if (paramJSONArrayPoxy != null)
                Log.d("Catelogy", "jsonArrayOrNull.length() == " + paramJSONArrayPoxy.length());
        }
        if ((paramJSONArrayPoxy != null) && (paramJSONArrayPoxy.length() > 0)){
            if (this.childCategories == null){//if-nez v0, :cond_1
                this.childCategories = new ArrayList();

                for (int i = 0; i < paramJSONArrayPoxy.length(); i++)
                    try
                    {
                        Catelogy localCatelogy = new Catelogy(paramJSONArrayPoxy.getJSONObject(i), 1);
                        this.childCategories.add(i, localCatelogy);
                    }
                    catch (JSONException e)
                    {
                            e.printStackTrace();
                    }
            }//:cond_1
        }
        return;

    }

    public static String getCmsTotalCid(ArrayList<Catelogy> paramArrayList, int paramInt)
    {
        String localObject2= "null";
        if (paramInt > 0){
            String localObject1 = "";
            for (int i = 0; i < paramInt; i++){
                if (i < paramInt - 1)
                    localObject2 = (String)localObject1 + ((Catelogy)paramArrayList.get(i)).getcId() + "_";
                else if (i == paramInt - 1)
                    localObject2 = (String)localObject1 + ((Catelogy)paramArrayList.get(i)).getcId();
            }

        }
        return localObject2;
    }

    private List<CatelogyLevelFour> getLevelFourList(JSONArrayProxy paramJSONArrayPoxy)
    {
        if (Log.D)
        {
            Log.d("Catelogy", "getLevelFourList() -->> ");
            if (paramJSONArrayPoxy != null)
                Log.d("Catelogy", "jsonArrayOrNull.length() == " + paramJSONArrayPoxy.length());
        }
        ArrayList localArrayList = null;
        if ((paramJSONArrayPoxy != null) || (paramJSONArrayPoxy.length() > 0))
        {
            localArrayList = new ArrayList();
            for (int i = 0; i< paramJSONArrayPoxy.length(); i++)
            {
                CatelogyLevelFour localObject = new CatelogyLevelFour();
                try
                {
                    JSONObjectProxy localJSONObjectProxy = paramJSONArrayPoxy.getJSONObject(i);
                    localObject.setCatalogId(localJSONObjectProxy.optString("catalogId"));
                    localObject.setCatalogName(localJSONObjectProxy.optString("getCatalogName"));
                    localArrayList.add(localObject);
                    i += 1;
                }
                catch (JSONException localJSONException)
                {
                        localJSONException.printStackTrace();
                }
            }

        }
        return localArrayList;

    }

    // ERROR //
    public static ArrayList<Catelogy> toList(JSONArrayProxy paramJSONArrayPoxy, int paramInt)
    {
        ArrayList<Catelogy> v0 = new ArrayList<Catelogy>();;
        if(paramJSONArrayPoxy != null && paramJSONArrayPoxy.length() > 0){
            for(int v1 = 0; v1<paramJSONArrayPoxy.length(); v1++){
                try {
                    JSONObjectProxy v2 = paramJSONArrayPoxy.getJSONObject(v1);
                    if(v2 != null){
                        if(!v2.isNull("name")){//if-nez v2, :cond_0
                            v0.add(new Catelogy(v2, paramInt));
                        }
                    }

                } catch (JSONException e) {
                    if(Log.V)
                        Log.v("Ware", e.getMessage());
                    break;
                }
            }
        }
        if (Log.D) {
            Log.d("Catelogy", "list:" + v0);
        }
        return v0;
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
            ArrayList v0 = null;
            if (paramJSONArrayPoxy != null) {//if-nez p0, :cond_1
                v0 = new ArrayList<MergedCatelogy>();
                for(int v1 = 0; v1< paramJSONArrayPoxy.length(); v1++){//if-ge v1, v2, :cond_3
                    try {
                        JSONObjectProxy v2 = paramJSONArrayPoxy.getJSONObject(v1);
                        if(v2 != null){//if-eqz v2, :cond_2
                            if(!v2.isNull("name")){//if-nez v2, :cond_2
                                v0.add(new MergedCatelogy(v2));
                            }
                        }
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
            }//:cond_1
            return v0;
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
