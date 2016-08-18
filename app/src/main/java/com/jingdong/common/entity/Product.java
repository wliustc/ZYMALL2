package com.jingdong.common.entity;

import android.text.TextUtils;

import com.alibaba.fastjson.parser.Feature;
import com.jd.framework.json.JDJSON;
import com.jd.framework.json.TypeToken;
import com.jingdong.common.utils.JSONObjectProxy;
import com.zy.common.entity.DefaultAddressMode;
import com.zy.common.entity.DiliverManInfo;
import com.zy.common.entity.Image;
import com.zy.common.entity.MultiSuppliers;
import com.zy.common.entity.ProductDetailBasicInfo;
import com.zy.common.entity.ProductDetailPrice;
import com.zy.common.entity.ProductDetailSkuColor;
import com.zy.common.entity.ProductDetailSkuSize;
import com.zy.common.entity.ProductFeeInfo;
import com.zy.common.entity.ServerIcon;
import com.zy.common.entity.SkuColor;
import com.zy.common.entity.SkuSize;
import com.zy.common.entity.SourceEntity;
import com.zy.common.entity.VirtualOrderInfo;
import com.zy.common.entity.WareRankInfo;
import com.zy.common.entity.YushouOrder;
import com.zy.common.utils.CommonUtil;
import com.zy.common.utils.JSONArrayProxy;
import com.zy.common.utils.Log;

import org.json.JSONArray;
import org.json.JSONException;

import java.io.Serializable;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Robin on 2016/6/22.
 */
public class Product implements Serializable {
    private static final String TAG = "Product";

    public static final int BEGINGTOORDER = 2;
    public static final int BEGINTOBUY = 4;
    public static final int CART_LIST = 9;
    public static final int CHANNEL_LIST = 31;
    public static final int CMS_ACTIVITY = 22;
    public static final int COLLECT_LIST = 7;
    public static final int CRAZY = 0;
    public static final int DELIVER = 19;
    public static final int EASY_LIST = 12;
    public static final int ENDBUY = 5;
    public static final int FAVO_RECOMMEND = 32;
    public static final int FLAG_SIZE_CLOTHES = 1;
    public static final int FLAG_SIZE_NO = 0;
    public static final int FLAG_SIZE_SHOES = 2;
    public static final int HOME_RECOMMEND = 30;
    public static final int HOT_SALES = 21;
    public static final int LIMIT_TIMEBUY = 14;
    public static final int MATCH_WARE_INFO_LIST = 16;
    public static final int MIAO_SHA_BRAND_INNER = 33;
    public static final int MIAO_SHA_LIST = 17;
    public static final int MIAO_SHA_PAGE_INNER = 34;
    public static final int MULTI_SELLER = 29;
    public static final int MY_DNA_PRODUCT_LIST = 10011;
    public static final int M_PROMOTION = 20;

    public static final int PACKS = 24;
    public static final int PACKS_LIST = 13;
    public static final int PACKS_MAIN = 25;
    public static final int PHOTO_SHOPPING_WARE_INFO_LIST = 26;
    public static final int PRODUCT_DETAIL = 3;
    public static final int PRODUCT_DETAIL_CRUX = 28;
    public static final int PROMOTION = 10;
    public static final int PROMOTION_INFO = 18;
    public static final int PURCHASEWARE = 35;
    public static final int RECOMAND_PRODECT = 4;
    public static final int SEARCH_CATEGORY = 1;
    public static final int SHOPPING = 23;
    public static final int SKU_COLOR_SIZE = 15;
    public static final int USER_INFO = 5;
    public static final int WAITINGTOBUY = 3;
    public static final int WAITINGTOORDER = 1;
    public static final int WARE_ID_BY_BAR_CODE_LIST = 11;

    public static final int ORDER_DETAIL = 106;
    public static final int ORDER_LIST = 6;

    public static final int ORDER_STATUS_ID_OTHER = 0;
    public static final int ORDER_STATUS_ID_ERROR = -1;
    public static final int ORDER_STATUS_ID_DENGDAIFUKUAN = 1;
    public static final int ORDER_STATUS_ID_DENGDAISHOUHUO = 3;
    public static final int ORDER_STATUS_ID_FUKUANCHENGGONG = 2;
    public static final int ORDER_STATUS_ID_SHOUHUOCHENGGONG = 4;
    public static final int ORDER_STATUS_ID_YIWANCHENG = 5;
    public static final int ORDER_STATUS_ID_YIQUXIAO = 6;

    private static final String CONST_NO_PRICE = "暂无报价";
    private static final String FREE = "免费";

    private static boolean isValid = true;
    private String adEventId;
    private String adWord;
    private String addFavoriteMsg;
    private String areaTips;
    private String author;
    private Boolean availableInStore;
    private Long averageScore;
    private long buyAgain;
    private Long buyBegin;
    private int buyCount;
    private Long buyEnd;
    private String cId;
    private String cName;
    private boolean canBeDelete = false;
    private Boolean canConsultFlag;
    private boolean canEasyBuy = false;
    private Boolean canFreeRead = Boolean.valueOf(false);
    private Boolean canGoToShop;
    private String cityId;
    private Integer cityIdMode1;
    ////private HashMap<Long, CityMode1> cityMode1Map;
    ////private ArrayList<AddressBaseMode> cityModeList;
    private String cityName;
    ////private ArrayList<CommentCount> commentCountList;
    private String commentGuid;
    private String consultationCount;
    private String countyId;
    ////private ArrayList<AddressBaseMode> countyModeList;
    private String countyName;
    ////private ArrayList<Coupon> couponList;
    private String customAttr = "";
    private DefaultAddressMode defaultAddressMode;
    private ArrayList<DefaultAddressMode> defaultAddressModeList;
    private String deliver;
    private String deliveryCommentFlag;
    private String deliveryFlag;
    private String desc;
    private String deviceidTail;
    private String diffMobilePrice = "";
    private String diffPice;
    public String diffPriceMobile;
    private String discount;
    private String discountNew;
    private String ebookUrl = "";
    private Long endTime;
    private ArrayList<Product.ExcutableButton> excutableButtonsList;
    private String expid;
    private String exprid;
    private long fatherId;
    private String fid;
    private String flags;
    private Integer flowOrder;
    private String freeReadUrl;
    private ArrayList<Product> giftList;
    private String good;
    private Boolean hasChat;
    private String hasComment;
    private String hasDiscuss;
    private boolean hasPacks = false;
    private int hasPriceDiff;
    private Boolean hasShop;
    private String historyPrice;
    private Long id;
    private List<Image> imageList = new LinkedList();
    private String imgPrice;
    private String index;
    private String interlImgUrl;
    private int internationalOrder;
    private int internationalType = 0;
    public int isAddCar;
    private Boolean isBook;
    private Boolean isBookDisc;
    private Boolean isCarBlocked = Boolean.valueOf(false);
    private boolean isCheckNext = false;
    private Boolean isEbook = Boolean.valueOf(false);
    private Boolean isEche;
    private boolean isFavorited;
    private Integer isFlashSale;
    private Boolean isFood = Boolean.valueOf(false);
    public boolean isHaveProductLogTag = false;
    private boolean isHot = false;
    private Boolean isInternational;
    public int isMobileVip;
    private boolean isNew = false;
    private Boolean isOrder;
    private Boolean isPhoneVipPrice;
    private Boolean isPromotion;
    private Boolean isPromotionDou;
    private Boolean isPromotionJiang;
    private Boolean isPromotionQuan;
    private Boolean isPromotionShan;
    private Boolean isPromotionTuan;
    private Boolean isPromotionZeng;
    private boolean isSaleExpand;
    private Boolean isShowDelButton = Boolean.valueOf(true);
    private Boolean isShowNetContent = Boolean.valueOf(false);
    public int isSoldOut;
    private boolean isVirtualOrder;
    private String jdPrice;
    private String logid;
    private String lookSimilar;
    private String mPaymentType;
    private ArrayList<Product> mProductList;
    private ArrayList<ServerIcon> mServerIcons;
    private String mShaShopId;
    private String marketPrice;
    private String marketPriceDescription;
    public Product.MaterialRedirectProtocol materialRedirectProtocol;
    private String message;
    private String messageTime;
    private Boolean miaoSha;
    private String miaoShaPrice;
    private String moreFunId;
    private String mpageAddress;
    private String msgTypeName;
    private MultiSuppliers multiSuppliers;
    List<String> mySearchProductTagInfos;
    private int nItemCount;
    private String name;
    private String notifyPrice;
    private Integer num;
    private Boolean online;
    private String operateWord;
    private Long orderBegin;
    private String orderCheckCode;
    private String orderCommentCount;
    private Long orderEnd;
    public List<Product.OrderOptButton> orderOptButtons;
    public int orderStatusId = -1;
    private String orderStatusShow;
    private int orderType = 0;
    private Boolean postByjd = Boolean.valueOf(false);
    private String priceDiff;
    private String priceDiffText;
    private Boolean priceReport = Boolean.valueOf(false);
    private String priority;
    private ProductDetailBasicInfo productDetailBasicInfo;
    ////private ProductDetailCruxBasicInfo productDetailCruxBasicInfo;
    private DefaultAddressMode productDetailDefaultAddress;
    private ProductDetailPrice productDetailJprice;
    private ProductDetailPrice productDetailMprice;
    private ProductDetailPrice productDetailPcprice;
    private ArrayList<ProductDetailSkuColor> productDetailSkuColor;
    private ArrayList<ProductDetailSkuSize> productDetailSkuSize;
    private ProductFeeInfo productFeeInfo;
    private Integer productStatusType;
    private int promFlag = 0;
    private String promName;
    private String promotionIconUrl;
    private String promotionInfo;
    private String promotionTitle;
    private String provinceID;
    private Integer provinceIdMode1;
    ////private ArrayList<Province> provinceList;
    ////private ArrayList<ProvinceMode1> provinceMode1List;
    private HashMap<Integer, Integer> provinceMode1Map;
    ////private ArrayList<AddressBaseMode> provinceModeList;
    private String provinceName;
    private Integer provinceStockCode;
    private String provinceStockContent;
    private Boolean provinceStockFlag;
    private Integer provinceStockMode = Integer.valueOf(0);
    private String psPrice;
    private int purchaseReminder;
    private String purchaseReminderIcon;
    private String rate;
    private Integer remainNum;
    private String rid;
    private List<String> sImgUrlList = new LinkedList();
    private String sItemPrice;
    private String sMsgBody;
    private String sMsgFlag;
    private String sMsgId;
    private String sMsgTime;
    private String sMsgType;
    private String sMsgUpdateTime;
    private String sOrderId;
    private String sOrderStatus;
    private String sPriceShow;
    private String sSkuID;
    private String sSkuName;
    private String sSubmitTime;
    private String sTotalPrice;
    private String sUerScore;
    private String sUserBalance;
    private String sUserClass;
    private String sUserName;
    private List<Product.Sale> salesList;
    public boolean self = false;
    private String sendPay;
    private long shopId;
    private String shopName;
    private String shopUrl;
    private Long showId;
    private String showLabel;
    private Integer showLabelId;
    private Boolean showMarketPrice = null;
    private ArrayList<SkuColor> skuColorList;
    private String skuId;
    private ArrayList<SkuSize> skuSizeList;
    private String skuType;
    private int skuTypeId;
    private Integer soldRate;
    private SourceEntity sourceEntity;
    private int sourceID;
    private String sourceValue;
    private Integer specialKill;
    private String spuId;
    private DiliverManInfo staffInfo;
    private Long startTime;
    private String startTimeShow;
    private String stockFunction;
    private int stockQuantity;
    private Integer stockState;
    private Integer stockStateId;
    private String stockStateStr;
    private Boolean subOrderFlag;
    private int supportSizeType = 0;
    private String tag;
    private String tagText;
    private int tagType;
    private String targetUrl;
    private String toMURL = "";
    private Integer totalCount;
    private String townId;
    ////private ArrayList<AddressBaseMode> townModeList;
    private String townName;
    private String userPriceContent;
    private String userPriceLabel;
    private long venderId;
    private String venderName;
    private Integer venderType;
    ////private VirtualOrderInfo virtualOrderInfo;
    private String voucherStatus;
    private Product.WarePromotionInfo warePromotionInfo;
    public WareRankInfo wareRank;
    private String wareType;
    private YushouOrder yushouOrder;
    private Integer yuyueNum;

    public Product()
    {
    }

    public Product(JSONObjectProxy paramJSONObjectProxy, int paramInt)
    {
        this(paramJSONObjectProxy, null, paramInt);
    }

    public Product(JSONObjectProxy paramJSONObjectProxy, int paramInt, Object[] paramArrayOfObject)
    {
        this(paramJSONObjectProxy, null, paramInt, paramArrayOfObject);
    }

    public Product(JSONObjectProxy paramJSONObjectProxy, JSONArray paramJSONArray, int paramInt)
    {
        this(paramJSONObjectProxy, paramJSONArray, paramInt, null);
    }

    private Product(JSONObjectProxy paramJSONObjectProxy, JSONArray paramJSONArray, int paramInt, Object[] paramArrayOfObject)
    {
        update(paramJSONObjectProxy, paramJSONArray, paramInt, paramArrayOfObject);
    }

    private void SetDiffPrice(String paramString)
    {
        this.diffPice = paramString;
    }

    private ArrayList<Product.ExcutableButton> getExcutableButtonsList(JSONArrayProxy paramJSONArrayPoxy)
    {
        ArrayList localArrayList = new ArrayList();
        if ((paramJSONArrayPoxy != null) && (paramJSONArrayPoxy.length() > 0))
        {
            for (int i=0; i < paramJSONArrayPoxy.length(); i++)
            {
                localArrayList.add(new Product.ExcutableButton(this, paramJSONArrayPoxy.getJSONObjectOrNull(i)));
            }
        }
        return localArrayList;
    }

    private void setRemainNum(Integer paramInteger)
    {
        this.remainNum = paramInteger;
    }

    public static ArrayList<Product> toList(JSONArrayProxy jsonArrayProxy, int paramInt)
    {
        return toList(jsonArrayProxy, paramInt, null);
    }

    public static ArrayList<Product> toList(JSONArrayProxy paramJSONArrayPoxy, int paramInt, Object[] paramArrayOfObject)
    {
        ArrayList<Product> result = null;//v0
        if(paramJSONArrayPoxy != null){
            result = new ArrayList<Product>();
            try {
                for (int i = 0; i < paramJSONArrayPoxy.length(); i++) {
                    Product product = new Product(paramJSONArrayPoxy.getJSONObject(i), paramInt);//v2
                    if (Product.isValid) {//if-eqz v3, :cond_2
                        result.add(product);
                    }
                }
            }catch (JSONException e){//:catch_1
                e.printStackTrace();
            }
        }
        return result;
    }

    public void addJshopIcon(JSONObjectProxy paramJSONObjectProxy)
    {
        setPromFlag(paramJSONObjectProxy.optInt("promFlag"));
        setPromName(paramJSONObjectProxy.optString("promName"));
        setIsNew(paramJSONObjectProxy.optBoolean("isNew"));
        setIsHot(paramJSONObjectProxy.optBoolean("isHot"));
    }

    public void addNewProductListScore(JSONObjectProxy objectProxy)
    {
        setAverageScore(objectProxy.getLongOrNull("averageScore"));
        setTotalCount(objectProxy.getIntOrNull("totalCount"));
        try
        {
            JSONArrayProxy arrayProxy = objectProxy.getJSONArrayOrNull("promotionFlag");
            if (arrayProxy != null)
            {
                for (int i = 0; i < arrayProxy.length(); i++){
                    String str = (String)arrayProxy.get(i);
                    if ("5".equals(str))
                        setIsPromotionZeng(Boolean.valueOf(true));
                    else if ("1".equals(str))
                        setIsPromotionJiang(Boolean.valueOf(true));
                    else if ("3".equals(str))
                        setIsPromotionQuan(Boolean.valueOf(true));
                    else if ("4".equals(str))
                        setIsPromotionDou(Boolean.valueOf(true));
                    else if ("100".equals(str))
                        setIsFlashSale(Integer.valueOf(1));
                }
            }
        }
        catch (Exception e)
        {
        }
    }

    public void addProductListScore(JSONObjectProxy paramJSONObjectProxy) {
        setAverageScore(paramJSONObjectProxy.getLongOrNull("averageScore"));
        setTotalCount(paramJSONObjectProxy.getIntOrNull("totalCount"));

        try {
            paramJSONObjectProxy = paramJSONObjectProxy.getJSONObjectOrNull("promotionFlag");
            if (paramJSONObjectProxy.getStringOrNull("5") != null)//if-eqz v1, :cond_0
                setIsPromotionZeng(Boolean.valueOf(true));
            else
                setIsPromotionZeng(Boolean.valueOf(false));
            if (paramJSONObjectProxy.getStringOrNull("1") != null)//if-eqz v1, :cond_1
                setIsPromotionJiang(Boolean.valueOf(true));
            else
                setIsPromotionJiang(Boolean.valueOf(false));
            if (paramJSONObjectProxy.getStringOrNull("3") != null)//if-eqz v1, :cond_2
                setIsPromotionQuan(Boolean.valueOf(true));
            else
                setIsPromotionQuan(Boolean.valueOf(false));
            if (paramJSONObjectProxy.getStringOrNull("4") != null)//if-eqz v1, :cond_3
                setIsPromotionDou(Boolean.valueOf(true));
            else
                setIsPromotionDou(Boolean.valueOf(false));

            if (paramJSONObjectProxy.getStringOrNull("100") != null)//if-eqz v0, :cond_4
                setIsFlashSale(Integer.valueOf(1));
            else
                setIsFlashSale(Integer.valueOf(0));
        } catch (Exception e) {
            setIsPromotionZeng(Boolean.valueOf(false));
            setIsPromotionJiang(Boolean.valueOf(false));
            return;
        }
        return;
    }

    public void appendImgUrl(String paramString, int paramInt)
    {
        if (paramInt < 0)
            this.sImgUrlList.add(paramString.toString());
        else
            this.sImgUrlList.add(paramInt, paramString.toString());
    }

    public Object clone()
            throws CloneNotSupportedException
    {
        return super.clone();
    }

    public int geItemCount()
    {
        if (this.nItemCount <= 0)
            return Integer.valueOf("1").intValue();
        return this.nItemCount;
    }

    public String getAdEventId()
    {
        return this.adEventId;
    }

    public String getAdWord()
    {
        if (this.adWord == null)
            return "";
        return this.adWord;
    }

    public String getAddFavoriteMsg()
    {
        return this.addFavoriteMsg;
    }

    public String getAreaTips()
    {
        if (this.areaTips == null)
            return "";
        return this.areaTips;
    }

    public String getAuthor()
    {
        return this.author;
    }

    public Boolean getAvailableInStore()
    {
        return this.availableInStore;
    }

    public Long getAverageScore()
    {
        return this.averageScore;
    }

    public long getBuyAgain()
    {
        return this.buyAgain;
    }

    public Long getBuyBegintime()
    {
        return this.buyBegin;
    }

    public int getBuyCount()
    {
        return this.buyCount;
    }

    public Long getBuyEndtime()
    {
        if (this.buyEnd == null)
            return Long.valueOf(0L);
        return this.buyEnd;
    }

    public String getCId()
    {
        if (TextUtils.isEmpty(this.cId))
            return "";
        return this.cId;
    }

    public String getCName()
    {
        if (TextUtils.isEmpty(this.cName))
            return "";
        return this.cName;
    }

    public Boolean getCanConsultFlag()
    {
        if (this.canConsultFlag == null)
            return Boolean.valueOf(false);
        return this.canConsultFlag;
    }

    public Boolean getCanFreeRead()
    {
        if (this.canFreeRead == null)
            return Boolean.valueOf(false);
        return this.canFreeRead;
    }

    public boolean getCheckNext()
    {
        return this.isCheckNext;
    }

    public String getCityId()
    {
        return this.cityId;
    }

    public Integer getCityIdMode1()
    {
        return this.cityIdMode1;
    }

////    public CityMode1 getCityMode1BySkuId(Long paramLong)
////    {
////        if (this.cityMode1Map != null)
////            return (CityMode1)this.cityMode1Map.get(paramLong);
////        return null;
////    }
////
////    public ArrayList<AddressBaseMode> getCityModeList()
////    {
////        return this.cityModeList;
////    }

    public String getCityName()
    {
        return this.cityName;
    }

////    public ArrayList<CommentCount> getCommentCountList()
////    {
////        return this.commentCountList;
////    }

    public String getCommentGuid()
    {
        return this.commentGuid;
    }

    public String getConsultationCount()
    {
        return this.consultationCount;
    }

    public String getCountyID()
    {
        return this.countyId;
    }

////    public ArrayList<AddressBaseMode> getCountyModeList()
////    {
////        return this.countyModeList;
////    }

    public String getCountyName()
    {
        return this.countyName;
    }

////    public ArrayList<Coupon> getCouponList()
////    {
////        return this.couponList;
////    }

    public String getCustomAttr()
    {
        return this.customAttr;
    }

    public DefaultAddressMode getDefaultAddressMode()
    {
        return this.defaultAddressMode;
    }

    public ArrayList<DefaultAddressMode> getDefaultAddressModeList()
    {
        return this.defaultAddressModeList;
    }

    public String getDeliver()
    {
        return this.deliver;
    }

    public String getDeliveryCommentFlag()
    {
        return this.deliveryCommentFlag;
    }

    public String getDeliveryFlag()
    {
        return this.deliveryFlag;
    }

    public String getDesc()
    {
        return this.desc;
    }

    public String getDiffMobilePrice()
    {
        if (this.diffMobilePrice != null)
            return this.diffMobilePrice.trim();
        return this.diffMobilePrice;
    }

    public String getDiffPrice()
    {
        return this.diffPice;
    }

    public String getDiscount()
    {
        if (!TextUtils.isEmpty(this.discount))
            return this.discount;
        return "0";
    }

    public String getDiscountNew()
    {
        return this.discountNew;
    }

    public String getEbookUrl()
    {
        return this.ebookUrl;
    }

    public Long getEndTime()
    {
        return this.endTime;
    }

    public ArrayList<Product.ExcutableButton> getExcutableButtonsList()
    {
        return this.excutableButtonsList;
    }

    public String getExpid()
    {
        if (TextUtils.isEmpty(this.expid))
            return "";
        return this.expid;
    }

    public long getFatherId()
    {
        return this.fatherId;
    }

    public String getFid()
    {
        return this.fid;
    }

    public String getFlags()
    {
        return this.flags;
    }

    public Integer getFlowOrder()
    {
        return this.flowOrder;
    }

    public String getFreeReadUrl()
    {
        return this.freeReadUrl;
    }

    public ArrayList<Product> getGiftList()
    {
        return this.giftList;
    }

    public String getGood()
    {
        return this.good;
    }

    public Boolean getHasChat()
    {
        boolean bool = false;
        if (this.hasChat != null)
            bool = this.hasChat.booleanValue();
        return Boolean.valueOf(bool);
    }

    public String getHasComment()
    {
        if (this.hasComment == null)
            return "";
        return this.hasComment;
    }

    public String getHasDiscuss()
    {
        if (this.hasDiscuss == null)
            return "";
        return this.hasDiscuss;
    }

    public int getHasPriceDiff()
    {
        return this.hasPriceDiff;
    }

    public Boolean getHasShop()
    {
        boolean bool = false;
        if (this.hasShop != null)
            bool = this.hasShop.booleanValue();
        return Boolean.valueOf(bool);
    }

    public String getHistoryPrice()
    {
        return this.historyPrice;
    }

    public Long getId()
    {
        return this.id;
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

    public String getImageUrl()
    {
        if (this.imageList.size() > 0)
            return (this.imageList.get(0)).getSmall();
        return null;
    }

    public String getImgPrice()
    {
        return this.imgPrice;
    }

    public String getIndex()
    {
        if (TextUtils.isEmpty(this.index))
            return "";
        return this.index;
    }

    public String getInterlImgUrl()
    {
        return this.interlImgUrl;
    }

    public int getInternationalOrder()
    {
        return this.internationalOrder;
    }

    public int getInternationalType()
    {
        return this.internationalType;
    }

    public Boolean getIsBook()
    {
        return this.isBook;
    }

    public Boolean getIsBookDisc()
    {
        return this.isBookDisc;
    }

    public Boolean getIsCarBlocked()
    {
        boolean bool = false;
        if (this.isCarBlocked != null)
            bool = this.isCarBlocked.booleanValue();
        return Boolean.valueOf(bool);
    }

    public Boolean getIsEbook()
    {
        boolean bool = false;
        if (this.isEbook != null)
            bool = this.isEbook.booleanValue();
        return Boolean.valueOf(bool);
    }

    public Boolean getIsEche()
    {
        boolean bool = false;
        if (this.isEche != null)
            bool = this.isEche.booleanValue();
        return Boolean.valueOf(bool);
    }

    public Integer getIsFlashSale()
    {
        int i = 0;
        if (this.isFlashSale != null)
            i = this.isFlashSale.intValue();
            return Integer.valueOf(i);
    }

    public Boolean getIsFood()
    {
        boolean bool = false;
        if (this.isFood != null)
            bool = this.isFood.booleanValue();
        return Boolean.valueOf(bool);
    }

    public boolean getIsHaveProductLogTag()
    {
        return this.isHaveProductLogTag;
    }

    public Boolean getIsInternational()
    {
        boolean bool = false;
        if (this.isInternational != null)
            bool = this.isInternational.booleanValue();
        return Boolean.valueOf(bool);
    }

    public Boolean getIsOrderProduct()
    {
        if (this.isOrder == null)
            return Boolean.valueOf(false);
        return this.isOrder;
    }

    public Boolean getIsPhoneVipPrice()
    {
        boolean bool = false;
        if (this.isPhoneVipPrice != null)
            bool = this.isPhoneVipPrice.booleanValue();
        return Boolean.valueOf(bool);
    }

    public Boolean getIsPromotionDou()
    {
        boolean bool = false;
        if (this.isPromotionDou != null)
            bool = this.isPromotionDou.booleanValue();
        return Boolean.valueOf(bool);
    }

    public Boolean getIsPromotionJiang()
    {
        boolean bool = false;
        if (this.isPromotionJiang != null)
            bool = this.isPromotionJiang.booleanValue();
        return Boolean.valueOf(bool);
    }

    public Boolean getIsPromotionQuan()
    {
        boolean bool = false;
        if (this.isPromotionQuan != null)
            bool = this.isPromotionQuan.booleanValue();
        return Boolean.valueOf(bool);
    }

    public Boolean getIsPromotionShan()
    {
        boolean bool = false;
        if (this.isPromotionShan != null)
            bool = this.isPromotionShan.booleanValue();
        return Boolean.valueOf(bool);
    }

    public Boolean getIsPromotionTuan()
    {
        boolean bool = false;
        if (this.isPromotionTuan != null)
            bool = this.isPromotionTuan.booleanValue();
        return Boolean.valueOf(bool);
    }

    public Boolean getIsPromotionZeng()
    {
        boolean bool = false;
        if (this.isPromotionZeng != null)
            bool = this.isPromotionZeng.booleanValue();
        return Boolean.valueOf(bool);
    }

    public Boolean getIsShowDelButton()
    {
        return this.isShowDelButton;
    }

    public Boolean getIsShowNetContent()
    {
        boolean bool = false;
        if (this.isShowNetContent != null)
            bool = this.isShowNetContent.booleanValue();
        return Boolean.valueOf(bool);
    }

    public synchronized boolean getIsValid()
    {
        return isValid;

    }

    public String getJdDixcount()
    {
        try
        {
            if (this.discount != null)
            {
                Double discount = Double.valueOf(this.discount);
                if (discount != null && discount.doubleValue() >= 0.0D)
                        return new DecimalFormat("0.00").format(discount);

            }
        }
        catch (Exception localException)
        {
        }
        return (String)"暂无折扣";
    }

    public String getJdPrice()
    {
        String str = CONST_NO_PRICE;
        if (getIsEbook().booleanValue())
            str = FREE;
        try
        {
            if (this.jdPrice != null)
            {
                Double jdPrice = Double.valueOf(this.jdPrice);
                if (jdPrice != null && jdPrice.doubleValue() > 0.0D)
                        return new DecimalFormat("0.00").format(jdPrice);

            }
        }
        catch (Exception localException)
        {
        }
        return str;
    }

    public String getJdPriceRMB()
    {
        String str2 = getJdPrice();
        String str1 = str2;
        if (!TextUtils.equals(str2, CONST_NO_PRICE))
            str1 = "¥" + str2;
        return str1;
    }

    public String getJdPriceWithOutFormat()
    {
        if ((TextUtils.isEmpty(this.jdPrice)) || ("-1".equals(this.jdPrice)))
            return CONST_NO_PRICE;
        return this.jdPrice;
    }

    public String getJdPriceWithOutZero()
    {
        String str = CONST_NO_PRICE;
        if (getIsEbook().booleanValue())
            str = FREE;
        try
        {
            if (this.jdPrice != null)
            {
                Double jdPrice = Double.valueOf(this.jdPrice);
                if (jdPrice != null && jdPrice.doubleValue() > 0.0D)
                        return new DecimalFormat("#.#").format(jdPrice);
            }
        }
        catch (Exception localException)
        {
        }
        return (String)str;
    }

    public String getJdPriceWithZero()
    {
        String str = "";
        if (getIsEbook().booleanValue())
            str = FREE;
        try
        {
            if (this.jdPrice != null)
            {
                Double jdPrice = Double.valueOf(this.jdPrice);
                if (jdPrice != null && jdPrice.doubleValue() > 0.0D)
                    return new DecimalFormat("0.00").format(jdPrice);
            }
        }
        catch (Exception localException)
        {
        }
        return str;
    }

    public String getLogid()
    {
        return this.logid;
    }

    public String getLongImageUrl()
    {
        if (this.imageList.size() > 0)
        {
            if (TextUtils.isEmpty(((Image)this.imageList.get(0)).getBig()))
                return ((Image)this.imageList.get(0)).getSmall();
            return ((Image)this.imageList.get(0)).getBig();
        }
        return null;
    }

    public String getMarketPrice() {
        boolean v1 = true;//v1
        boolean flag = false;//v0
        if (!CommonUtil.getMarketPriceFlag())
            flag = true;

        if (Log.D)
            Log.d("abc", "flag -->> " + flag);
        if (getShowMarketPrice() != null) {//if-eqz v3, :cond_6
            if (getShowMarketPrice().booleanValue())//if-nez v0, :cond_4
                v1 = false;//:cond_4 move v1, v2
            //:goto_1
            if (Log.D)
                Log.d("Product", "xxxxx getShowMarketPrice-->> " + getShowMarketPrice());
        } else//:cond_6
            v1 = flag;//move v1, v0
        //goto_2

        if (Log.D)
            Log.d("Product", "xxxxx getMarketPrice-->> " + v1);
        if (v1)
            return null;
        else
            return getMarketPriceValues();

    }

    public String getMarketPriceDescription()
    {
        if ((this.marketPriceDescription == null) || ("".equals(this.marketPriceDescription)))
        {
            if (isBook().booleanValue())
                return "定价";
            return "市场价";
        }
        return this.marketPriceDescription;
    }

    public String getMarketPriceValues()
    {
        try
        {
            if (this.marketPrice != null)
            {
                Double marketPrice = Double.valueOf(this.marketPrice);
                if (marketPrice != null && marketPrice.doubleValue() > 0.0D)
                    return new DecimalFormat("0.00").format(marketPrice);
            }
        }
        catch (Exception e)
        {
        }
        return (String)CONST_NO_PRICE;
    }

    public String getMessage()
    {
        return this.message;
    }

    public Boolean getMiaoSha()
    {
        boolean bool = false;
        if (this.miaoSha != null)
            bool = this.miaoSha.booleanValue();
        return Boolean.valueOf(bool);
    }

    public String getMiaoShaPrice()
    {
        if ((TextUtils.isEmpty(this.miaoShaPrice)) || ("-1".equals(this.miaoShaPrice)))
            return CONST_NO_PRICE;
        return this.miaoShaPrice;
    }

    public String getMoreFunId()
    {
        if (TextUtils.isEmpty(this.moreFunId))
            return "";
        return this.moreFunId;
    }

    public String getMpageAddress()
    {
        return this.mpageAddress;
    }

    public String getMsgBody()
    {
        if (this.sMsgBody.length() <= 0)
            return String.valueOf(" ");
        return this.sMsgBody;
    }

    public String getMsgFlag()
    {
        if (this.sMsgFlag.length() <= 0)
            return String.valueOf(" ");
        return this.sMsgFlag;
    }

    public String getMsgTime()
    {
        if (this.sMsgTime.length() <= 0)
            return String.valueOf(" ");
        return this.sMsgTime;
    }

    public String getMsgType()
    {
        if (this.sMsgType.length() <= 0)
            return String.valueOf(" ");
        return this.sMsgType;
    }

    public String getMsgTypeName()
    {
        return this.msgTypeName;
    }

    public MultiSuppliers getMultiSuppliers()
    {
        return this.multiSuppliers;
    }

    public List<String> getMySearchProductTagInfos()
    {
        return this.mySearchProductTagInfos;
    }

    public String getName()
    {
        if (this.name != null)
            return this.name;
        return "暂无名称";
    }

    public String getNotifyPrice()
    {
        return this.notifyPrice;
    }

    public Integer getNum()
    {
        if ((this.num == null) || (this.num.intValue() <= 0))
            return Integer.valueOf(0);
        return this.num;
    }

    public Boolean getOnline()
    {
        boolean bool = false;
        if (this.online != null)
            bool = this.online.booleanValue();
        return Boolean.valueOf(bool);
    }

    public String getOperateWord()
    {
        return this.operateWord;
    }

    public Long getOrderBegintime()
    {
        if (this.orderBegin == null)
            return Long.valueOf(0L);
        return this.orderBegin;
    }

    public String getOrderCheckCode()
    {
        return this.orderCheckCode;
    }

    public String getOrderCommentCount()
    {
        return this.orderCommentCount;
    }

    public Long getOrderEndtime()
    {
        if (this.orderEnd == null)
            return Long.valueOf(0L);
        return this.orderEnd;
    }

    public String getOrderId()
    {
        if ((this.sOrderId == null) || (this.sOrderId.length() <= 0))
            return String.valueOf(" ");
        return this.sOrderId;
    }

    public String getOrderPrice()
    {
        if ((this.sTotalPrice == null) || (this.sTotalPrice.length() <= 0))
            return String.valueOf("");
        return this.sTotalPrice.trim();
    }

    public String getOrderShopName()
    {
        return this.shopName;
    }

    public String getOrderStatus()
    {
        if (this.sOrderStatus.length() <= 0)
            return String.valueOf(" ");
        return this.sOrderStatus;
    }

    public String getOrderStatusShow()
    {
        return this.orderStatusShow;
    }

    public String getOrderSubtime()
    {
        if (this.sSubmitTime.length() <= 0)
            return String.valueOf(" ");
        return this.sSubmitTime;
    }

    public int getOrderType()
    {
        return this.orderType;
    }

    public Boolean getPostByJd()
    {
        boolean bool = false;
        if (this.postByjd != null)
            bool = this.postByjd.booleanValue();
        return Boolean.valueOf(bool);
    }

    public String getPriceDiff()
    {
        return this.priceDiff;
    }

    public String getPriceDiffText()
    {
        return this.priceDiffText;
    }

    public String getPriceForAfterDiscount()
    {
        try
        {
            double d = Double.valueOf(this.jdPrice).doubleValue() - Double.valueOf(this.discount).doubleValue();
            if (d > 0.0D)
                return "¥" + new DecimalFormat("0.00").format(d);
        }
        catch (Exception localException)
        {
        }
        return CONST_NO_PRICE;
    }

    public Boolean getPriceReport()
    {
        boolean bool = false;
        if (this.priceReport != null)
            bool = this.priceReport.booleanValue();
        return Boolean.valueOf(bool);
    }

    public String getPriority()
    {
        return this.priority;
    }

    public ProductDetailBasicInfo getProductDetailBasicInfo()
    {
        if (this.productDetailBasicInfo == null)
            this.productDetailBasicInfo = new ProductDetailBasicInfo();
        return this.productDetailBasicInfo;
    }

////    public ProductDetailCruxBasicInfo getProductDetailCruxBasicInfo()
////    {
////        if (this.productDetailCruxBasicInfo == null)
////            this.productDetailCruxBasicInfo = new ProductDetailCruxBasicInfo();
////        return this.productDetailCruxBasicInfo;
////    }

    public DefaultAddressMode getProductDetailDefaultAddress()
    {
        if (this.productDetailDefaultAddress == null)
            this.productDetailDefaultAddress = new DefaultAddressMode();
        return this.productDetailDefaultAddress;
    }

    public ProductDetailPrice getProductDetailJprice()
    {
        if (this.productDetailJprice == null)
            this.productDetailJprice = new ProductDetailPrice();
        return this.productDetailJprice;
    }

    public ProductDetailPrice getProductDetailMprice()
    {
        if (this.productDetailMprice == null)
            this.productDetailMprice = new ProductDetailPrice();
        return this.productDetailMprice;
    }

    public ProductDetailPrice getProductDetailPcprice()
    {
        if (this.productDetailPcprice == null)
            this.productDetailPcprice = new ProductDetailPrice();
        return this.productDetailPcprice;
    }

    public ArrayList<ProductDetailSkuColor> getProductDetailSkuColor()
    {
        if ((this.productDetailSkuColor == null) || (this.productDetailSkuColor.size() == 0))
            this.productDetailSkuColor = new ArrayList();
        return this.productDetailSkuColor;
    }

    public ArrayList<ProductDetailSkuSize> getProductDetailSkuSize()
    {
        if ((this.productDetailSkuSize == null) || (this.productDetailSkuSize.size() == 0))
            this.productDetailSkuSize = new ArrayList();
        return this.productDetailSkuSize;
    }

    public ProductFeeInfo getProductFeeInfo()
    {
        return this.productFeeInfo;
    }

    public ArrayList<Product> getProductList()
    {
        return this.mProductList;
    }

    public Integer getProductStatusType()
    {
        if (this.productStatusType == null)
            return Integer.valueOf(5);
        return this.productStatusType;
    }

    public int getPromFlag()
    {
        return this.promFlag;
    }

    public String getPromName()
    {
        return this.promName;
    }

    public String getPromotionIconUrl()
    {
        return this.promotionIconUrl;
    }

    public String getPromotionInfo()
    {
        return this.promotionInfo;
    }

    public String getPromotionTitle()
    {
        return this.promotionTitle;
    }

    public String getProvinceID()
    {
        return this.provinceID;
    }

    public Integer getProvinceIdMode1()
    {
        return this.provinceIdMode1;
    }

////    public ArrayList<Province> getProvinceList()
////    {
////        return this.provinceList;
////    }

    public Integer getProvinceMode1IndexById(int paramInt)
    {
        return this.provinceMode1Map.get(Integer.valueOf(paramInt));
    }

////    public ArrayList<ProvinceMode1> getProvinceMode1List()
////    {
////        return this.provinceMode1List;
////    }
////
////    public ArrayList<AddressBaseMode> getProvinceModeList()
////    {
////        return this.provinceModeList;
////    }

    public String getProvinceName()
    {
        return this.provinceName;
    }

    public String getProvinceStockContent()
    {
        if ((TextUtils.isEmpty(this.provinceStockContent)) || ("null".equals(this.provinceStockContent)) || ("NULL".equals(this.provinceStockContent)))
            return "";
        return this.provinceStockContent;
    }

    public Boolean getProvinceStockFlag()
    {
        return this.provinceStockFlag;
    }

    public Integer getProvinceStockMode()
    {
        return this.provinceStockMode;
    }

    public String getPsPrice()
    {
        String str = CONST_NO_PRICE;
        if (getIsEbook().booleanValue())
            str = FREE;
        try
        {
            if (this.psPrice != null)
            {
                Double psPrice = Double.valueOf(this.psPrice);
                if (psPrice != null && psPrice.doubleValue() > 0.0D)
                    str = new DecimalFormat("0.00").format(psPrice);
            }
        }
        catch (Exception e)
        {
        }
        return str;
    }

    public int getPurchaseReminder()
    {
        return this.purchaseReminder;
    }

    public String getPurchaseReminderIcon()
    {
        return this.purchaseReminderIcon;
    }

    public String getRate()
    {
        return this.rate;
    }

    public Integer getRemainNum()
    {
        return this.remainNum;
    }

    public String getRid()
    {
        if (TextUtils.isEmpty(this.rid))
            return "";
        return this.rid;
    }

    public List<Product.Sale> getSalesList()
    {
        return this.salesList;
    }

    public String getSendPay()
    {
        return this.sendPay;
    }

    public ArrayList<ServerIcon> getServerIconList()
    {
        return this.mServerIcons;
    }

    public long getShopId()
    {
        return this.shopId;
    }

    public String getShopName()
    {
        return this.shopName;
    }

    public String getShopUrl()
    {
        return this.shopUrl;
    }

    public Long getShowId()
    {
        if (this.showId == null)
            return getId();
        return this.showId;
    }

    public String getShowLabel()
    {
        if (TextUtils.isEmpty(this.showLabel))
            return "";
        return this.showLabel;
    }

    public Integer getShowLabelId()
    {
        return this.showLabelId;
    }

    public Boolean getShowMarketPrice()
    {
        return this.showMarketPrice;
    }

    public ArrayList<SkuColor> getSkuColorList()
    {
        return this.skuColorList;
    }

    public String getSkuId()
    {
        if (TextUtils.isEmpty(this.skuId))
            return "";
        return this.skuId;
    }

    public ArrayList<SkuSize> getSkuSizeList()
    {
        return this.skuSizeList;
    }

    public String getSkuType()
    {
        return this.skuType;
    }

    public int getSkuTypeId()
    {
        return this.skuTypeId;
    }

    public Integer getSoldRate()
    {
        return this.soldRate;
    }

    public SourceEntity getSourceEntity()
    {
        return this.sourceEntity;
    }

    public int getSourceID()
    {
        return this.sourceID;
    }

    public String getSourceValue()
    {
        if (TextUtils.isEmpty(this.sourceValue))
            return "";
        return this.sourceValue;
    }

    public Integer getSpecialKill()
    {
        return this.specialKill;
    }

    public String getSpuId()
    {
        if (TextUtils.isEmpty(this.spuId))
            return "";
        return this.spuId;
    }

    public DiliverManInfo getStaffInfo()
    {
        return this.staffInfo;
    }

    public Long getStartTime()
    {
        if (this.startTime == null)
            return Long.valueOf(0L);
        return this.startTime;
    }

    public String getStartTimeShow()
    {
        return this.startTimeShow;
    }

    public String getStockFunction()
    {
        return this.stockFunction;
    }

    public int getStockQuantity()
    {
        return this.stockQuantity;
    }

    public Integer getStockState()
    {
        return this.stockState;
    }

    public Integer getStockStateId()
    {
        return this.stockStateId;
    }

    public String getStockStateStr()
    {
        return this.stockStateStr;
    }

    public Boolean getSubOrderFlag()
    {
        return this.subOrderFlag;
    }

    public int getSupportSizeType()
    {
        return this.supportSizeType;
    }

    public String getTag()
    {
        return this.tag;
    }

    public String getTagText()
    {
        return this.tagText;
    }

    public int getTagType()
    {
        return this.tagType;
    }

    public String getTargetUrl()
    {
        return this.targetUrl;
    }

    public String getToMURL()
    {
        return this.toMURL;
    }

    public Integer getTotalCount()
    {
        return this.totalCount;
    }

    public String getTownID()
    {
        return this.townId;
    }

////    public ArrayList<AddressBaseMode> getTownModeList()
////    {
////        return this.townModeList;
////    }

    public String getTownName()
    {
        return this.townName;
    }

    public String getTraceMessageTime()
    {
        return this.messageTime;
    }

    public String getUserBalance()
    {
        if (this.sUserBalance == null)
            return "";
        return this.sUserBalance;
    }

    public String getUserClass()
    {
        if (this.sUserClass == null)
            return "";
        return this.sUserClass;
    }

    public String getUserPriceContent()
    {
        return this.userPriceContent;
    }

    public String getUserPriceLabel()
    {
        return this.userPriceLabel;
    }

    public String getUserScore()
    {
        if (this.sUerScore.length() > 0)
            return this.sUerScore;
        return "0";
    }

    public String getUsername()
    {
        if (this.sUserName.length() <= 0)
            return String.valueOf("Customer");
        return this.sUserName;
    }

    public long getVenderId()
    {
        return this.venderId;
    }

    public String getVenderName()
    {
        if (Log.D)
            Log.d("abc", "venderName = " + this.venderName);
        if ((TextUtils.isEmpty(this.venderName)) || (TextUtils.equals(this.venderName, "null")))
            return "京东自营";
        return this.venderName;
    }

    public int getVenderType()
    {
        return this.venderType.intValue();
    }

////    public VirtualOrderInfo getVirtualOrderInfo()
////    {
////        return this.virtualOrderInfo;
////    }

    public String getVoucherStatus()
    {
        return this.voucherStatus;
    }

    public Product.WarePromotionInfo getWarePromotionInfo()
    {
        return this.warePromotionInfo;
    }

    public WareRankInfo getWareRank()
    {
        return this.wareRank;
    }

    public String getWareType()
    {
        return this.wareType;
    }

    public YushouOrder getYushouOrder()
    {
        return this.yushouOrder;
    }

    public Integer getYuyueNum()
    {
        if (this.yuyueNum == null)
            return Integer.valueOf(0);
        return this.yuyueNum;
    }

    public String getmPaymentType()
    {
        return this.mPaymentType;
    }

    public String getmShaShopId()
    {
        return this.mShaShopId;
    }

    public String getsMsgId()
    {
        return this.sMsgId;
    }

    public String getsMsgUpdateTime()
    {
        return this.sMsgUpdateTime;
    }

    public Boolean isBook()
    {
        boolean bool = false;
        if (this.isBook != null)
            bool = this.isBook.booleanValue();
        return Boolean.valueOf(bool);
    }

    public boolean isCanBeDelete()
    {
        return this.canBeDelete;
    }

    public boolean isCanEasyBuy()
    {
        return this.canEasyBuy;
    }

    public Boolean isCanGoToShop()
    {
        boolean bool = false;
        if (this.canGoToShop != null)
            bool = this.canGoToShop.booleanValue();
        return Boolean.valueOf(bool);
    }

    public boolean isFavorited()
    {
        return this.isFavorited;
    }

    public Boolean isFiledExist(JSONObjectProxy paramJSONObjectProxy, String paramString)
    {
        boolean bool = false;
        if (paramJSONObjectProxy.toString().contains(paramString))
            bool = true;
        return Boolean.valueOf(bool);
    }

    public boolean isHasPacks()
    {
        return this.hasPacks;
    }

    public boolean isHot()
    {
        return this.isHot;
    }

    public boolean isLookSimilar()
    {
        return (!TextUtils.isEmpty(this.lookSimilar)) && ("1".equals(this.lookSimilar));
    }

    public boolean isNew()
    {
        return this.isNew;
    }

    public Boolean isPromotion()
    {
        boolean bool = false;
        if (this.isPromotion != null)
            bool = this.isPromotion.booleanValue();
        return Boolean.valueOf(bool);
    }

    public boolean isSaleExpand()
    {
        return this.isSaleExpand;
    }

    public boolean isSelf()
    {
        return this.self;
    }

    public void isVirtualOrder(boolean paramBoolean)
    {
        this.isVirtualOrder = paramBoolean;
    }

    public boolean isVirtualOrder()
    {
        return this.isVirtualOrder;
    }

    public String popImgUrl(int paramInt)
    {
        if ((paramInt >= 0) && (this.sImgUrlList.size() > 0) && (paramInt < this.sImgUrlList.size()))
            return this.sImgUrlList.get(paramInt).toString();
        return null;
    }

////    protected void putInCityMode1Map(Long paramLong, CityMode1 paramCityMode1)
////    {
////        if (this.cityMode1Map == null)
////            this.cityMode1Map = new HashMap();
////        if (!this.cityMode1Map.containsKey(paramLong))
////            this.cityMode1Map.put(paramLong, paramCityMode1);
////    }

    public void setAdEventId(String paramString)
    {
        this.adEventId = paramString;
    }

    public void setAdWord(String paramString)
    {
        this.adWord = paramString;
    }

    public void setAddFavoriteMsg(String paramString)
    {
        this.addFavoriteMsg = paramString;
    }

    public void setAreaTips(String paramString)
    {
        this.areaTips = paramString;
    }

    public void setAuthor(String paramString)
    {
        this.author = paramString;
    }

    public void setAvailableInStore(Boolean paramBoolean)
    {
        this.availableInStore = paramBoolean;
    }

    public void setAverageScore(Long paramLong)
    {
        this.averageScore = paramLong;
    }

    public void setBook(Boolean paramBoolean)
    {
        this.isBook = paramBoolean;
    }

    public void setBuyAgain(long paramLong)
    {
        this.buyAgain = paramLong;
    }

    public void setBuyBegintime(long paramLong)
    {
        this.buyBegin = Long.valueOf(paramLong);
    }

    public void setBuyCount(int paramInt)
    {
        this.buyCount = paramInt;
    }

    public void setBuyEndtime(long paramLong)
    {
        this.buyEnd = Long.valueOf(paramLong);
    }

    public void setCId(String paramString)
    {
        this.cId = paramString;
    }

    public void setCName(String paramString)
    {
        this.cName = paramString;
    }

    public void setCanBeDelete(boolean paramBoolean)
    {
        this.canBeDelete = paramBoolean;
    }

    public void setCanConsultFlag(Boolean paramBoolean)
    {
        this.canConsultFlag = paramBoolean;
    }

    public void setCanEasyBuy(boolean paramBoolean)
    {
        this.canEasyBuy = paramBoolean;
    }

    public void setCanFreeRead(Boolean paramBoolean)
    {
        this.canFreeRead = paramBoolean;
    }

    public void setCanGoToShop(Boolean paramBoolean)
    {
        this.canGoToShop = paramBoolean;
    }

    public void setCheckNext(boolean paramBoolean)
    {
        this.isCheckNext = paramBoolean;
        if (Log.D)
            Log.d("Product", "isCheckNext -->> " + paramBoolean);
    }

    public void setCityId(String paramString)
    {
        this.cityId = paramString;
    }

    public void setCityIdMode1(Integer paramInteger)
    {
        this.cityIdMode1 = paramInteger;
    }

////    public void setCityModeList(ArrayList<AddressBaseMode> paramArrayList)
////    {
////        this.cityModeList = paramArrayList;
////    }

    public void setCityName(String paramString)
    {
        this.cityName = paramString;
    }

////    public void setCommentCountList(ArrayList<CommentCount> paramArrayList)
////    {
////        this.commentCountList = paramArrayList;
////    }

    public void setCommentGuid(String paramString)
    {
        this.commentGuid = paramString;
    }

    public void setConsultationCount(String paramString)
    {
        this.consultationCount = paramString;
    }

    public void setCountyID(String paramString)
    {
        this.countyId = paramString;
    }

////    public void setCountyModeList(ArrayList<AddressBaseMode> paramArrayList)
////    {
////        this.countyModeList = paramArrayList;
////    }

    public void setCountyName(String paramString)
    {
        this.countyName = paramString;
    }

////    public void setCouponList(ArrayList<Coupon> paramArrayList)
////    {
////        this.couponList = paramArrayList;
////    }

    public void setCustomAttr(String paramString)
    {
        this.customAttr = paramString;
    }

    public void setDefaultAddressMode(DefaultAddressMode paramDefaultAddressMode)
    {
        this.defaultAddressMode = paramDefaultAddressMode;
    }

    public void setDefaultAddressModeList(ArrayList<DefaultAddressMode> paramArrayList)
    {
        this.defaultAddressModeList = paramArrayList;
    }

    public void setDeliver(String paramString)
    {
        this.deliver = paramString;
    }

    public void setDeliveryCommentFlag(String paramString)
    {
        this.deliveryCommentFlag = paramString;
    }

    public void setDeliveryFlag(String paramString)
    {
        this.deliveryFlag = paramString;
    }

    public void setDesc(String paramString)
    {
        this.desc = paramString;
    }

    public void setDiffMobilePrice(String paramString)
    {
        this.diffMobilePrice = paramString;
    }

    public void setDiscount(String paramString)
    {
        this.discount = paramString;
    }

    public void setDiscountNew(String paramString)
    {
        this.discountNew = paramString;
    }

    public void setEbookUrl(String paramString)
    {
        this.ebookUrl = paramString;
    }

    public void setEndTime(Long paramLong)
    {
        this.endTime = Long.valueOf(paramLong.longValue() * 1000L);
    }

    public void setExcutableButtonsList(ArrayList<Product.ExcutableButton> paramArrayList)
    {
        this.excutableButtonsList = paramArrayList;
    }

    public void setExpid(String paramString)
    {
        this.expid = paramString;
    }

    public void setFatherId(long paramLong)
    {
        this.fatherId = paramLong;
    }

    public void setFavorited(boolean paramBoolean)
    {
        this.isFavorited = paramBoolean;
    }

    public void setFid(String paramString)
    {
        this.fid = paramString;
    }

    public void setFlags(String paramString)
    {
        this.flags = paramString;
    }

    public void setFlowOrder(Integer paramInteger)
    {
        this.flowOrder = paramInteger;
    }

    public void setFreeReadUrl(String paramString)
    {
        this.freeReadUrl = paramString;
    }

    public void setGiftList(ArrayList<Product> paramArrayList)
    {
        this.giftList = paramArrayList;
    }

    public void setGood(String paramString)
    {
        this.good = paramString;
    }

    public void setHasChat(Boolean paramBoolean)
    {
        this.hasChat = paramBoolean;
    }

    public void setHasComment(String paramString)
    {
        this.hasComment = paramString;
    }

    public void setHasDiscuss(String paramString)
    {
        this.hasDiscuss = paramString;
    }

    public void setHasPacks(boolean paramBoolean)
    {
        this.hasPacks = paramBoolean;
    }

    public void setHasPriceDiff(int paramInt)
    {
        this.hasPriceDiff = paramInt;
    }

    public void setHasShop(Boolean paramBoolean)
    {
        this.hasShop = paramBoolean;
    }

    public void setHistoryPrice(String paramString)
    {
        this.historyPrice = paramString;
    }

    public void setId(Long paramLong)
    {
        this.id = paramLong;
    }

    public void setImage(String paramString1, String paramString2)
    {
        this.imageList.add(new Image(paramString1, paramString2));
    }

    public void setImgPrice(String paramString)
    {
        this.imgPrice = paramString;
    }

    public void setIndex(String paramString)
    {
        this.index = paramString;
    }

    public void setInterlImgUrl(String paramString)
    {
        this.interlImgUrl = paramString;
    }

    public void setInternationalOrder(int paramInt)
    {
        this.internationalOrder = paramInt;
    }

    public void setInternationalType(int paramInt)
    {
        this.internationalType = paramInt;
    }

    public void setIsBook(Boolean paramBoolean)
    {
        this.isBook = paramBoolean;
    }

    public void setIsBookDisc(Boolean paramBoolean)
    {
        this.isBookDisc = paramBoolean;
    }

    public void setIsCarBlocked(Boolean paramBoolean)
    {
        this.isCarBlocked = paramBoolean;
    }

    public void setIsEbook(Boolean paramBoolean)
    {
        this.isEbook = paramBoolean;
    }

    public void setIsEche(Boolean paramBoolean)
    {
        this.isEche = paramBoolean;
    }

    public void setIsFlashSale(Integer paramInteger)
    {
        this.isFlashSale = paramInteger;
    }

    public void setIsFood(Boolean paramBoolean)
    {
        this.isFood = paramBoolean;
    }

    public void setIsHaveProductLogTag(boolean paramBoolean)
    {
        this.isHaveProductLogTag = paramBoolean;
    }

    public void setIsHot(boolean paramBoolean)
    {
        this.isHot = paramBoolean;
    }

    public void setIsInternational(Boolean paramBoolean)
    {
        this.isInternational = paramBoolean;
    }

    public void setIsNew(boolean paramBoolean)
    {
        this.isNew = paramBoolean;
    }

    public void setIsPhoneVipPrice(Boolean paramBoolean)
    {
        this.isPhoneVipPrice = paramBoolean;
    }

    public void setIsPromotionDou(Boolean paramBoolean)
    {
        this.isPromotionDou = paramBoolean;
    }

    public void setIsPromotionJiang(Boolean paramBoolean)
    {
        this.isPromotionJiang = paramBoolean;
    }

    public void setIsPromotionQuan(Boolean paramBoolean)
    {
        this.isPromotionQuan = paramBoolean;
    }

    public void setIsPromotionShan(Boolean paramBoolean)
    {
        this.isPromotionShan = paramBoolean;
    }

    public void setIsPromotionTuan(Boolean paramBoolean)
    {
        this.isPromotionTuan = paramBoolean;
    }

    public void setIsPromotionZeng(Boolean paramBoolean)
    {
        this.isPromotionZeng = paramBoolean;
    }

    public void setIsShowDelButton(Boolean paramBoolean)
    {
        this.isShowDelButton = paramBoolean;
    }

    public void setIsShowNetcontent(Boolean paramBoolean)
    {
        this.isShowNetContent = paramBoolean;
    }

    public synchronized void setIsValid(boolean paramBoolean)
    {
            isValid = paramBoolean;
            return;
    }

    public void setItemCount(int paramInt)
    {
        this.nItemCount = paramInt;
    }

    public void setJdDixcount(String paramString)
    {
        this.discount = paramString;
    }

    public void setJdPrice(String paramString)
    {
        this.jdPrice = paramString;
    }

    public void setLogid(String paramString)
    {
        this.logid = paramString;
    }

    public void setLookSimilar(String paramString)
    {
        this.lookSimilar = paramString;
    }

    public void setMarketPrice(String paramString)
    {
        this.marketPrice = paramString;
    }

    public void setMarketPriceDescription(String paramString)
    {
        this.marketPriceDescription = paramString;
    }

    public void setMessage(String paramString)
    {
        this.message = paramString;
    }

    public void setMessageBody(String paramString)
    {
        this.sMsgBody = paramString;
    }

    public void setMessageFlag(String paramString)
    {
        this.sMsgFlag = paramString;
    }

    public void setMessageTime(String paramString)
    {
        this.sMsgTime = paramString;
    }

    public void setMessageType(String paramString)
    {
        this.sMsgType = paramString;
    }

    public void setMiaoSha(Boolean paramBoolean)
    {
        this.miaoSha = paramBoolean;
    }

    public void setMiaoShaPrice(String paramString)
    {
        this.miaoShaPrice = paramString;
    }

    public void setMoreFunId(String paramString)
    {
        this.moreFunId = paramString;
    }

    public void setMpageAddress(String paramString)
    {
        this.mpageAddress = paramString;
    }

    public void setMsgTypeName(String paramString)
    {
        this.msgTypeName = paramString;
    }

    public void setMultiSuppliers(MultiSuppliers paramMultiSuppliers)
    {
        this.multiSuppliers = paramMultiSuppliers;
    }

    public void setMySearchProductTagInfos(List<String> paramList)
    {
        this.mySearchProductTagInfos = paramList;
    }

    public void setName(String name) {
        if (name == null) {
            this.name = name;
            return;
        }
        StringBuffer v2 = new StringBuffer();

        try {
            Matcher localMatcher = Pattern.compile("([^a-zA-Z0-9（）\\(\\) ])([a-zA-Z（\\(])|([^ ])([（\\(])|([（\\(])([^ ])|([A-Z0-9])(\\-)|(\\-)([A-Z0-9])|([0-9]*[A-Z]+[0-9]*)([^a-zA-Z0-9（）\\(\\) ])").matcher(name);
            //:goto_1
            while (localMatcher.find()) {//if-eqz v0, :cond_6
                StringBuffer v3 = new StringBuffer();

                //:goto_2
                for (int i = 1; i <= localMatcher.groupCount(); i++) {//if-gt v0, v4, :cond_1
                    if (localMatcher.group(i) != null) {//if-eqz v4, :cond_5
                        v3.append(localMatcher.group(i)).append(" ").append(localMatcher.group(i + 1));
                        break;
                    }
                }//:cond_1

                if (Log.D)
                    Log.d("Temp", "name -->> " + name);
                if (Log.D)
                    Log.d("Temp", "stringBuffer.toString() -->> " + v2.toString());
                if (Log.D)
                    Log.d("Temp", "sb.toString() -->> " + v3.toString());
                localMatcher.appendReplacement(v2, v3.toString());
                //goto/16 :goto_1
            }
            localMatcher.appendTail(v2);
            v2.append(" ");
            this.name = v2.toString();


        } catch (Exception localException) {
            this.name = name;
            return;
        }
    }

    public void setNotifyPrice(String paramString)
    {
        this.notifyPrice = paramString;
    }

    public void setNum(Integer paramInteger)
    {
        this.num = paramInteger;
    }

    public void setOnline(Boolean paramBoolean)
    {
        this.online = paramBoolean;
    }

    public void setOperateWord(String paramString)
    {
        this.operateWord = paramString;
    }

    public void setOrderCheckCode(String paramString)
    {
        this.orderCheckCode = paramString;
    }

    public void setOrderCommentCount(String paramString)
    {
        this.orderCommentCount = paramString;
    }

    public void setOrderEndtime(long paramLong)
    {
        this.orderEnd = Long.valueOf(paramLong);
    }

    public void setOrderId(String paramString)
    {
        this.sOrderId = paramString;
    }

    public void setOrderInfo(JSONObjectProxy paramJSONObjectProxy)
    {
        if (paramJSONObjectProxy == null)
        {
            this.isOrder = Boolean.valueOf(false);
            return;
        }
        this.isOrder = paramJSONObjectProxy.getBooleanOrNull("isYuYue");
        this.orderBegin = paramJSONObjectProxy.getLongOrNull("yuYueStartTime");
        this.orderEnd = paramJSONObjectProxy.getLongOrNull("yuYueEndTime");
        this.buyBegin = paramJSONObjectProxy.getLongOrNull("buyStartTime");
        this.buyEnd = paramJSONObjectProxy.getLongOrNull("buyEndTime");
        this.productStatusType = paramJSONObjectProxy.getIntOrNull("yuyueType");
        this.yuyueNum = paramJSONObjectProxy.getIntOrNull("yuyueNum");
    }

    public void setOrderPrice(String paramString)
    {
        this.sTotalPrice = paramString;
    }

    public void setOrderStatus(String paramString)
    {
        this.sOrderStatus = paramString;
    }

    public void setOrderStatusShow(String paramString)
    {
        this.orderStatusShow = paramString;
    }

    public void setOrderSubtime(String paramString)
    {
        this.sSubmitTime = paramString;
    }

    public void setOrderType(int paramInt)
    {
        this.orderType = paramInt;
    }

    public void setPostByJd(Boolean paramBoolean)
    {
        this.postByjd = paramBoolean;
    }

    public void setPriceDiff(String paramString)
    {
        this.priceDiff = paramString;
    }

    public void setPriceDiffText(String paramString)
    {
        this.priceDiffText = paramString;
    }

    public void setPriceReport(Boolean paramBoolean)
    {
        this.priceReport = paramBoolean;
    }

    public void setPriority(String paramString)
    {
        this.priority = paramString;
    }

    public void setProductDetailBasicInfo(ProductDetailBasicInfo paramProductDetailBasicInfo)
    {
        this.productDetailBasicInfo = paramProductDetailBasicInfo;
    }

////    public void setProductDetailCruxBasicInfo(ProductDetailCruxBasicInfo paramProductDetailCruxBasicInfo)
////    {
////        this.productDetailCruxBasicInfo = paramProductDetailCruxBasicInfo;
////    }

    public void setProductDetailDefaultAddress(DefaultAddressMode paramDefaultAddressMode)
    {
        this.productDetailDefaultAddress = paramDefaultAddressMode;
    }

    public void setProductDetailJprice(ProductDetailPrice paramProductDetailPrice)
    {
        this.productDetailJprice = paramProductDetailPrice;
    }

    public void setProductDetailMprice(ProductDetailPrice paramProductDetailPrice)
    {
        this.productDetailMprice = paramProductDetailPrice;
    }

    public void setProductDetailPcprice(ProductDetailPrice paramProductDetailPrice)
    {
        this.productDetailPcprice = paramProductDetailPrice;
    }

    public void setProductDetailSkuColor(ArrayList<ProductDetailSkuColor> paramArrayList)
    {
        this.productDetailSkuColor = paramArrayList;
    }

    public void setProductDetailSkuSize(ArrayList<ProductDetailSkuSize> paramArrayList)
    {
        this.productDetailSkuSize = paramArrayList;
    }

    public void setProductFeeInfo(ProductFeeInfo paramProductFeeInfo)
    {
        this.productFeeInfo = paramProductFeeInfo;
    }

    public void setProductList(ArrayList<Product> paramArrayList)
    {
        this.mProductList = paramArrayList;
    }

    public void setPromFlag(int paramInt)
    {
        this.promFlag = paramInt;
    }

    public void setPromName(String paramString)
    {
        this.promName = paramString;
    }

    public void setPromotion(Boolean paramBoolean)
    {
        this.isPromotion = paramBoolean;
    }

    public void setPromotionIconUrl(String paramString)
    {
        this.promotionIconUrl = paramString;
    }

    public void setPromotionInfo(String paramString)
    {
        this.promotionInfo = paramString;
    }

    public void setPromotionTitle(String paramString)
    {
        this.promotionTitle = paramString;
    }

    public void setProvinceID(String paramString)
    {
        this.provinceID = paramString;
    }

    public void setProvinceIdMode1(Integer paramInteger)
    {
        this.provinceIdMode1 = paramInteger;
    }

////    public void setProvinceList(ArrayList<Province> paramArrayList)
////    {
////        this.provinceList = paramArrayList;
////    }
////
////    public void setProvinceMode1List(ArrayList<ProvinceMode1> paramArrayList)
////    {
////        this.provinceMode1List = paramArrayList;
////        this.provinceMode1Map = new HashMap();
////        int i = 0;
////        while (i < paramArrayList.size())
////        {
////            ProvinceMode1 localProvinceMode1 = (ProvinceMode1)paramArrayList.get(i);
////            this.provinceMode1Map.put(Integer.valueOf(localProvinceMode1.getId()), Integer.valueOf(i));
////            i += 1;
////        }
////    }
////
////    public void setProvinceModeList(ArrayList<AddressBaseMode> paramArrayList)
////    {
////        this.provinceModeList = paramArrayList;
////    }

    public void setProvinceName(String paramString)
    {
        this.provinceName = paramString;
    }

    public void setProvinceStockContent(String paramString)
    {
        this.provinceStockContent = paramString;
    }

    public void setProvinceStockFlag(Boolean paramBoolean)
    {
        this.provinceStockFlag = paramBoolean;
    }

    public void setProvinceStockMode(Integer paramInteger)
    {
        this.provinceStockMode = paramInteger;
    }

    public void setPsPrice(String paramString)
    {
        this.psPrice = paramString;
    }

    public void setPurchaseReminder(int paramInt)
    {
        this.purchaseReminder = paramInt;
    }

    public void setPurchaseReminderIcon(String paramString)
    {
        this.purchaseReminderIcon = paramString;
    }

    public void setRate(String paramString)
    {
        this.rate = paramString;
    }

    public void setRid(String paramString)
    {
        this.rid = paramString;
    }

    public void setSaleExpand(boolean paramBoolean)
    {
        this.isSaleExpand = paramBoolean;
    }

    public void setSelf(boolean paramBoolean)
    {
        this.self = paramBoolean;
    }

    public void setSendPay(String paramString)
    {
        this.sendPay = paramString;
    }

    public void setServerIconList(ArrayList<ServerIcon> paramArrayList)
    {
        this.mServerIcons = paramArrayList;
    }

    public void setShopId(long paramLong)
    {
        this.shopId = paramLong;
    }

    public void setShopName(String paramString)
    {
        this.shopName = paramString;
    }

    public void setShopUrl(String paramString)
    {
        this.shopUrl = paramString;
    }

    public void setShowId(Long paramLong)
    {
        this.showId = paramLong;
    }

    public void setShowLabel(String paramString)
    {
        this.showLabel = paramString;
    }

    public void setShowLabelId(Integer paramInteger)
    {
        this.showLabelId = paramInteger;
    }

    public void setShowMarketPrice(Boolean paramBoolean)
    {
        this.showMarketPrice = paramBoolean;
    }

    public void setSkuColorList(ArrayList<SkuColor> paramArrayList)
    {
        this.skuColorList = paramArrayList;
    }

    public void setSkuId(String paramString)
    {
        this.skuId = paramString;
    }

    public void setSkuSizeList(ArrayList<SkuSize> paramArrayList)
    {
        this.skuSizeList = paramArrayList;
    }

    public void setSkuType(String paramString)
    {
        this.skuType = paramString;
    }

    public void setSkuTypeId(int paramInt)
    {
        this.skuTypeId = paramInt;
    }

    public void setSoldRate(Integer paramInteger)
    {
        this.soldRate = paramInteger;
    }

    public void setSourceEntity(SourceEntity paramSourceEntity)
    {
        this.sourceEntity = paramSourceEntity;
    }

    public void setSourceID(int paramInt)
    {
        this.sourceID = paramInt;
    }

    public void setSourceValue(String paramString)
    {
        this.sourceValue = paramString;
    }

    public void setSpecialKill(Integer paramInteger)
    {
        this.specialKill = paramInteger;
    }

    public void setSpuId(String paramString)
    {
        this.spuId = paramString;
    }

    public void setStaffInfo(DiliverManInfo paramDiliverManInfo)
    {
        this.staffInfo = paramDiliverManInfo;
    }

    public void setStartTime(Long paramLong)
    {
        if (paramLong != null)
            this.startTime = Long.valueOf(paramLong.longValue() * 1000L);
    }

    public void setStartTimeShow(String paramString)
    {
        this.startTimeShow = paramString;
    }

    public void setStockFunction(String paramString)
    {
        this.stockFunction = paramString;
    }

    public void setStockQuantity(int paramInt)
    {
        this.stockQuantity = paramInt;
    }

    public void setStockState(Integer paramInteger)
    {
        this.stockState = paramInteger;
    }

    public void setStockStateId(Integer paramInteger)
    {
        this.stockStateId = paramInteger;
    }

    public void setStockStateStr(String paramString)
    {
        this.stockStateStr = paramString;
    }

    public void setSubOrderFlag(Boolean paramBoolean)
    {
        this.subOrderFlag = paramBoolean;
    }

    public void setSupportSizeType(int paramInt)
    {
        this.supportSizeType = paramInt;
    }

    public void setTagText(String paramString)
    {
        this.tagText = paramString;
    }

    public void setTagType(int paramInt)
    {
        this.tagType = paramInt;
    }

    public void setTargetUrl(String paramString)
    {
        this.targetUrl = paramString;
    }

    public void setToMURL(String paramString)
    {
        this.toMURL = paramString;
    }

    public void setTotalCount(Integer paramInteger)
    {
        this.totalCount = paramInteger;
    }

    public void setTownID(String paramString)
    {
        this.townId = paramString;
    }

////    public void setTownModeList(ArrayList<AddressBaseMode> paramArrayList)
////    {
////        this.townModeList = paramArrayList;
////    }

    public void setTownName(String paramString)
    {
        this.townName = paramString;
    }

    public void setTraceMessageTime(String paramString)
    {
        this.messageTime = paramString;
    }

    public void setUserBalance(String paramString)
    {
        this.sUserBalance = paramString;
    }

    public void setUserClass(String paramString)
    {
        this.sUserClass = paramString;
    }

    public void setUserPriceContent(String paramString)
    {
        this.userPriceContent = paramString;
    }

    public void setUserPriceLabel(String paramString)
    {
        this.userPriceLabel = paramString;
    }

    public void setUserScore(String paramString)
    {
        this.sUerScore = paramString;
    }

    public void setUsername(String paramString)
    {
        this.sUserName = paramString;
    }

    public void setVenderId(long paramLong)
    {
        this.venderId = paramLong;
    }

    public void setVenderName(String paramString)
    {
        this.venderName = paramString;
    }

    public void setVenderType(Integer paramInteger)
    {
        this.venderType = paramInteger;
    }

////    public void setVirtualOrderInfo(VirtualOrderInfo paramVirtualOrderInfo)
////    {
////        this.virtualOrderInfo = paramVirtualOrderInfo;
////    }

    public void setVoucherStatus(String paramString)
    {
        this.voucherStatus = paramString;
    }

    public void setWarePromotionInfo(Product.WarePromotionInfo paramWarePromotionInfo)
    {
        this.warePromotionInfo = paramWarePromotionInfo;
    }

    public void setWareRank(WareRankInfo paramWareRankInfo)
    {
        this.wareRank = paramWareRankInfo;
    }

    public void setWareType(String paramString)
    {
        this.wareType = paramString;
    }

    public void setmPaymentType(String paramString)
    {
        this.mPaymentType = paramString;
    }

    public void setmShaShopId(String paramString)
    {
        this.mShaShopId = paramString;
    }

    public void setsMsgId(String paramString)
    {
        this.sMsgId = paramString;
    }

    public void setsMsgUpdateTime(String paramString)
    {
        this.sMsgUpdateTime = paramString;
    }

    public void update(JSONObjectProxy paramJSONObjectProxy, JSONArray paramJSONArray, int paramInt)
    {
        update(paramJSONObjectProxy, paramJSONArray, paramInt, null);
    }

    public void update(JSONObjectProxy paramJSONObjectProxy, JSONArray paramJSONArray, int paramInt, Object[] paramArrayOfObject)
    {

        JSONObjectProxy localJSONObjectProxy = null;
        setGood(paramJSONObjectProxy.getStringOrNull("good"));
        setIsCarBlocked(paramJSONObjectProxy.getBooleanOrNull("needShield"));
        setIsEbook(paramJSONObjectProxy.getBooleanOrNull("eBookFlag"));
        setEbookUrl(paramJSONObjectProxy.getStringOrNull("eBookUrl"));
        switch (paramInt)
        {
            default:
            case 0: //0x0   sswitch_0
                setId(paramJSONObjectProxy.getLongOrNull("wareId"));
                setName(paramJSONObjectProxy.getStringOrNull("wname"));
                setImage(paramJSONObjectProxy.getStringOrNull("imageurl"), null);
                setJdPrice(paramJSONObjectProxy.getStringOrNull("jdPrice"));
                setImgPrice(paramJSONObjectProxy.getStringOrNull("wmaprice"));
                setMarketPrice(paramJSONObjectProxy.getStringOrNull("marketPrice"));
                if (isFiledExist(paramJSONObjectProxy, "adword").booleanValue())
                    setAdWord(paramJSONObjectProxy.getStringOrNull("adword"));
                addProductListScore(paramJSONObjectProxy);
                setGood(paramJSONObjectProxy.getStringOrNull("good"));
                return;
            case 1: //0x1   sswitch_1
                if (Log.D)
                    Log.d("Product", "SEARCH_CATEGORY jsonObject = " + paramJSONObjectProxy);
                setId(paramJSONObjectProxy.getLongOrNull("wareId"));
                setImage(paramJSONObjectProxy.getStringOrNull("imageurl"), paramJSONObjectProxy.getStringOrNull("longImgUrl"));
                setStockQuantity(paramJSONObjectProxy.optInt("stockQuantity", 0));
                setName(paramJSONObjectProxy.getStringOrNull("wname"));
                setAdWord(paramJSONObjectProxy.getStringOrNull("adword"));
                setMarketPrice(paramJSONObjectProxy.getStringOrNull("martPrice"));
                setAuthor(paramJSONObjectProxy.optString("author"));
                setBook(Boolean.valueOf(paramJSONObjectProxy.optBoolean("isbook")));
                if ((paramArrayOfObject != null) && (paramArrayOfObject.length > 0))
                {//if-eqz p4, :cond_3
                    setIsBookDisc((Boolean)paramArrayOfObject[0]);
                    setIsFood((Boolean)paramArrayOfObject[1]);
                    setIsShowNetcontent((Boolean)paramArrayOfObject[2]);
                    setLogid((String)paramArrayOfObject[3]);
                    setAdEventId((String)paramArrayOfObject[4]);
                }//:cond_3
                setJdPrice(paramJSONObjectProxy.getStringOrNull("jdPrice"));
                addJshopIcon(paramJSONObjectProxy);
                addNewProductListScore(paramJSONObjectProxy);
                setMultiSuppliers(new MultiSuppliers(paramJSONObjectProxy));
                setShopName(paramJSONObjectProxy.getStringOrNull("shopName"));
                setAvailableInStore(paramJSONObjectProxy.getBooleanOrNull("availableInStore"));
                setPriority(paramJSONObjectProxy.getStringOrNull("priority"));
                setStockStateStr(paramJSONObjectProxy.getStringOrNull("stockState"));
                JSONObjectProxy jsonObjectProxy = paramJSONObjectProxy.getJSONObjectOrNull("wareRank");
                if (jsonObjectProxy != null)
                {
                    this.wareRank = new WareRankInfo(jsonObjectProxy);
                    setWareRank(this.wareRank);
                }
                setIsHaveProductLogTag(paramJSONObjectProxy.optBoolean("loc", false));
                setSelf(paramJSONObjectProxy.optBoolean("self", false));
                setIsInternational(paramJSONObjectProxy.getBooleanOrNull("international"));
                setIsPromotionShan(paramJSONObjectProxy.getBooleanOrNull("flashBuy"));
                setIsPromotionTuan(Boolean.valueOf(paramJSONObjectProxy.optBoolean("groupBuyFlag", false)));
                setPromotionIconUrl(paramJSONObjectProxy.getStringOrNull("promotionIconUrl"));
                setInterlImgUrl(paramJSONObjectProxy.getStringOrNull("interlImgUrl"));
                setIsEche(paramJSONObjectProxy.getBooleanOrNull("eche"));
                setToMURL(paramJSONObjectProxy.getStringOrNull("toMURL"));
                setTargetUrl(paramJSONObjectProxy.getStringOrNull("targetUrl"));
                setFlowOrder(paramJSONObjectProxy.getIntOrNull("flow_order"));
                setCustomAttr(paramJSONObjectProxy.getStringOrNull("customAttr"));
                setDiffMobilePrice(paramJSONObjectProxy.optString("diffMobilePrice"));
                setFlags(paramJSONObjectProxy.optString("flags"));
                JSONArrayProxy jsonArrayProxy = paramJSONObjectProxy.getJSONArrayOrNull("mySearchWareTags");
                if (jsonArrayProxy != null){//if-eqz v0, :cond_0
                    try
                    {
                        if (!TextUtils.isEmpty(jsonArrayProxy.toString()))//if-nez v1, :cond_0
                            setMySearchProductTagInfos(JDJSON.parseArray(jsonArrayProxy.toString(), String.class));
                    }
                    catch (Exception e)
                    {
                        e.printStackTrace();
                    }
                }//:cond_0
                return;
            case 13://0xd   sswitch_2
                setId(paramJSONObjectProxy.getLongOrNull("SkuId"));
                if (paramArrayOfObject[0] != null)
                    setImage((String)paramArrayOfObject[0] + paramJSONObjectProxy.getStringOrNull("SkuPicUrl"), null);
                else
                    setImage(paramJSONObjectProxy.getStringOrNull("SkuPicUrl"), null);

                setName(paramJSONObjectProxy.getStringOrNull("SkuName"));
                return;
            case 7: //0x7   sswitch_3
                setId(paramJSONObjectProxy.getLongOrNull("wareId"));
                setImage(paramJSONObjectProxy.getStringOrNull("imageurl"), null);
                setName(paramJSONObjectProxy.getStringOrNull("wname"));
                setAdWord(paramJSONObjectProxy.getStringOrNull("adword"));
                setMarketPrice(paramJSONObjectProxy.getStringOrNull("martPrice"));
                setJdPrice(paramJSONObjectProxy.getStringOrNull("jdPrice"));
                setOrderId(paramJSONObjectProxy.getStringOrNull("orderId"));
                setBook(paramJSONObjectProxy.getBooleanOrNull("book"));
                this.fid = paramJSONObjectProxy.getStringOrNull("fid");
                addProductListScore(paramJSONObjectProxy);
                setHasComment(paramJSONObjectProxy.getStringOrNull("comment"));
                setHasDiscuss(paramJSONObjectProxy.getStringOrNull("discuss"));
                setStockStateId(paramJSONObjectProxy.getIntOrNull("stockStateId"));
                setRemainNum(paramJSONObjectProxy.getIntOrNull("remainNum"));
                SetDiffPrice(paramJSONObjectProxy.getStringOrNull("diffPrice"));
                setNotifyPrice(paramJSONObjectProxy.getStringOrNull("notifyPrice"));
                setPsPrice(paramJSONObjectProxy.optString("psPrice"));
                setWareType(paramJSONObjectProxy.optString("wareType"));
                JSONArrayProxy jsonArray = paramJSONObjectProxy.getJSONArrayOrNull("salesList");
                if ((jsonArray != null) && (jsonArray.length() > 0))
                {
                    this.salesList = new ArrayList<Product.Sale>();
                    for (int i = 0; i < jsonArray.length(); i++)
                    {
                        localJSONObjectProxy = jsonArray.getJSONObjectOrNull(i);
                        if (localJSONObjectProxy != null)
                        {
                            String str = localJSONObjectProxy.getStringOrNull("type");
                            if (!TextUtils.isEmpty(str))
                            {
                                Product.Sale sale = new Product.Sale();
                                sale.type = str;
                                sale.lable = localJSONObjectProxy.getStringOrNull("text");
                                sale.value = localJSONObjectProxy.getStringOrNull("value");
                                sale.promotionId = localJSONObjectProxy.getStringOrNull("promotionId");
                                sale.productId = this.id;
                                localJSONObjectProxy = localJSONObjectProxy.getJSONObjectOrNull("giftInfo");
                                if (localJSONObjectProxy != null)
                                    sale.giftId = localJSONObjectProxy.getStringOrNull("id");
                                this.salesList.add(sale);
                            }
                        }

                    }
                }
                setVoucherStatus(paramJSONObjectProxy.optString("voucherStatus", ""));
                setCommentGuid(paramJSONObjectProxy.optString("commentGuid", ""));
                this.isSoldOut = paramJSONObjectProxy.optInt("isSoldOut", -1);
                this.isMobileVip = paramJSONObjectProxy.optInt("isMobileVip", -1);
                this.diffPriceMobile = paramJSONObjectProxy.optString("diffPriceMobile");
                this.isAddCar = paramJSONObjectProxy.optInt("isAddCar", -1);
                this.sourceValue = paramJSONObjectProxy.optString("sourceValue");
                return;
            case 3: //0x3   sswitch_4
                try
                {

                    JSONArrayProxy arrayProxy = paramJSONObjectProxy.getJSONArrayOrNull("image");
                    this.imageList.clear();
                    //:goto_3
                    for (int i = 0; i < arrayProxy.length(); i++){//if-ge v1, v3, :cond_9
                        JSONObjectProxy objectProxy = arrayProxy.getJSONObject(i);
                        this.imageList.add(new Image(objectProxy, 1));
                    }
                }
                catch (JSONException e) {
                    if (Log.V)
                        Log.v(Product.class.getName(), e.getMessage());
                }
                if (!paramJSONObjectProxy.isNull("jprice"))
                    setProductDetailJprice(new ProductDetailPrice(paramJSONObjectProxy.getJSONObjectOrNull("jprice"), paramInt));
                if (!paramJSONObjectProxy.isNull("mprice"))
                    setProductDetailMprice(new ProductDetailPrice(paramJSONObjectProxy.getJSONObjectOrNull("mprice"), paramInt));
                setProductDetailBasicInfo(new ProductDetailBasicInfo(paramJSONObjectProxy.getJSONObjectOrNull("basicInfo"), paramInt));
                setProductDetailSkuColor(ProductDetailSkuColor.toList(paramJSONObjectProxy.getJSONArrayOrNull("skuColor"), paramInt));
                setProductDetailSkuSize(ProductDetailSkuSize.toList(paramJSONObjectProxy.getJSONArrayOrNull("skuSize"), paramInt));
                ProductFeeInfo feeInfo= null;
                if (!paramJSONObjectProxy.isNull("feeInfo")) //if-eqz v0, :cond_d
                    feeInfo = new ProductFeeInfo(paramJSONObjectProxy.getJSONObjectOrNull("feeInfo"));
                //:goto_4
                setProductFeeInfo(feeInfo);
                setProductDetailDefaultAddress(new DefaultAddressMode(paramJSONObjectProxy.getJSONObjectOrNull("defaultAddr"), paramInt));
                if (!paramJSONObjectProxy.isNull("specialPrice"))
                    setIsPhoneVipPrice(paramJSONObjectProxy.getBooleanOrNull("specialPrice"));
                setServerIconList(ServerIcon.toList(paramJSONObjectProxy.getJSONArrayOrNull("iconList")));
                if (!paramJSONObjectProxy.isNull("yuyueInfo"))
                    setOrderInfo(paramJSONObjectProxy.getJSONObjectOrNull("yuyueInfo"));
                return;
            case 28://0x1c  sswitch_5
                //setProductDetailCruxBasicInfo(new ProductDetailCruxBasicInfo(paramJSONObjectProxy, paramInt));
                return;
            case 4: //0x4   sswitch_6
                setId(paramJSONObjectProxy.getLongOrNull("wareId"));
                setName(paramJSONObjectProxy.getStringOrNull("wname"));
                if (isFiledExist(paramJSONObjectProxy, "adword").booleanValue())
                    setAdWord(paramJSONObjectProxy.getStringOrNull("adword"));
                setMarketPrice(paramJSONObjectProxy.getStringOrNull("martPrice"));
                setJdPrice(paramJSONObjectProxy.getStringOrNull("jdPrice"));
                setImage(paramJSONObjectProxy.getStringOrNull("imageurl"), null);
                setTargetUrl(paramJSONObjectProxy.optString("clickUrl"));
                setSourceValue(paramJSONObjectProxy.optString("sourceValue"));
                return;
            case 32://0x20  sswitch_7
                setId(paramJSONObjectProxy.getLongOrNull("wareId"));
                setName(paramJSONObjectProxy.getStringOrNull("wname"));
                setJdPrice(paramJSONObjectProxy.getStringOrNull("jdPrice"));
                setImage(paramJSONObjectProxy.getStringOrNull("imageurl"), null);
                setSourceValue(paramJSONObjectProxy.optString("sourceValue"));
                return;
            case 5: //0x5   sswitch_8
                setUsername(paramJSONObjectProxy.getStringOrNull("unickName"));
                setImage(paramJSONObjectProxy.getStringOrNull("imgUrl"), null);
                setUserClass(paramJSONObjectProxy.getStringOrNull("uclass"));
                return;
            case 6: //0x6   sswitch_9
            case 106://0x6a sswitch_9
                setOrderId(paramJSONObjectProxy.optString("orderId"));
                setOrderCheckCode(paramJSONObjectProxy.optString("checkCode"));
                setOrderStatus(paramJSONObjectProxy.optString("orderStatus"));
                setOrderPrice(paramJSONObjectProxy.optString("price"));
                setOrderSubtime(paramJSONObjectProxy.optString("dataSubmit"));
                if (paramInt - 106 == 0)
                    setNum(Integer.valueOf(paramJSONObjectProxy.optInt("num")));
                else
                    setNum(Integer.valueOf(paramJSONObjectProxy.optInt("buyCount")));
                setId(Long.valueOf(paramJSONObjectProxy.optLong("wareId")));
                setName(paramJSONObjectProxy.optString("wname"));
                setImage(paramJSONObjectProxy.optString("imageurl"), null);
                setmPaymentType(paramJSONObjectProxy.optString("paymentType"));
                setSubOrderFlag(Boolean.valueOf(paramJSONObjectProxy.optBoolean("subOrder")));
                setShowLabel(paramJSONObjectProxy.optString("showLabel"));
                setShowLabelId(Integer.valueOf(paramJSONObjectProxy.optInt("showLabelId")));
                setVenderId(Long.valueOf(paramJSONObjectProxy.optLong("venderId", -1L)).longValue());
                setJdPrice(paramJSONObjectProxy.optString("jdPrice"));
                setOrderStatusShow(paramJSONObjectProxy.optString("orderStatusShow"));
                setCanGoToShop(Boolean.valueOf(paramJSONObjectProxy.optBoolean("canGoToShop")));
                setShopName(paramJSONObjectProxy.optString("shopName"));
                setMessage(paramJSONObjectProxy.optString("message"));
                setTraceMessageTime(paramJSONObjectProxy.optString("messageTime"));
                long l = paramJSONObjectProxy.optLong("buyAgain", -1L);
                setInternationalOrder(paramJSONObjectProxy.optInt("internationalOrder", -1));
                setBuyAgain(l);
                JSONObjectProxy orderMsg = paramJSONObjectProxy.getJSONObjectOrNull("orderMsg");
                if (orderMsg != null)
                {
                    JSONArrayProxy wareInfoList = orderMsg.getJSONArrayOrNull("wareInfoList");
                    if ((wareInfoList != null) && (wareInfoList.length() > 0))
                        setProductList(toList(wareInfoList, 6));
                }
                JSONObjectProxy staffInfo = paramJSONObjectProxy.getJSONObjectOrNull("staffInfo");
                if (staffInfo != null)
                {
                    this.staffInfo = new DiliverManInfo(staffInfo);
                    setStaffInfo(this.staffInfo);
                }
                setHasComment(paramJSONObjectProxy.optString("comment"));
                setHasDiscuss(paramJSONObjectProxy.optString("discuss"));
                this.yushouOrder = YushouOrder.fromJson(paramJSONObjectProxy);
                setIsShowDelButton(Boolean.valueOf(paramJSONObjectProxy.optBoolean("showDelButton", false)));
                setOrderType(paramJSONObjectProxy.optInt("orderType", 0));
                setSendPay(paramJSONObjectProxy.optString("sendPay"));
                setInternationalType(paramJSONObjectProxy.optInt("internationalType", 0));
                isVirtualOrder(paramJSONObjectProxy.optBoolean("isVirtualOrder", false));
////                if (this.isVirtualOrder)
////                    setVirtualOrderInfo(VirtualOrderInfo.parse(paramJSONObjectProxy.optString("virtualOrderInfo", "")));
////                this.materialRedirectProtocol = ((Product.MaterialRedirectProtocol)JDJSON.parseObject(String.valueOf(paramJSONObjectProxy.optJSONObject("materialRedirectProtocol")), new TypeToken<Product.MaterialRedirectProtocol>().getType(), new Feature[0]));
////                this.orderOptButtons = ((List)JDJSON.parseObject(String.valueOf(paramJSONObjectProxy.optJSONArray("buttons")), new TypeToken<List<OrderOptButton>>().getType(), new Feature[0]));
                this.orderStatusId = paramJSONObjectProxy.optInt("orderStatusId", -1);
                return;
            case 9: //0x9   sswitch_a
                setId(paramJSONObjectProxy.getLongOrNull("Id"));
                setName(paramJSONObjectProxy.getStringOrNull("Name"));
                setJdPrice(paramJSONObjectProxy.getStringOrNull("Price"));
                setJdDixcount(paramJSONObjectProxy.getStringOrNull("Discount"));
                setImgPrice(paramJSONObjectProxy.getStringOrNull("PriceImg"));
                setItemCount(paramJSONObjectProxy.getIntOrNull("Num").intValue());
                setNum(paramJSONObjectProxy.getIntOrNull("Num"));
                if ((paramArrayOfObject != null) && (paramArrayOfObject[0] != null))
                    setImage((String)paramArrayOfObject[0] + paramJSONObjectProxy.getStringOrNull("ImgUrl"), null);
                else
                    setImage(paramJSONObjectProxy.getStringOrNull("ImgUrl"), null);
                return;
            case 10 ://0xa  sswitch_b
                setId(paramJSONObjectProxy.getLongOrNull("wareId"));
                setAdWord(paramJSONObjectProxy.getStringOrNull("adword"));
                setBook(paramJSONObjectProxy.getBooleanOrNull("book"));
                setName(paramJSONObjectProxy.getStringOrNull("wname"));
                setNum(paramJSONObjectProxy.getIntOrNull("num"));
                return;
            case 11://0xb   sswitch_c
                setAdWord(paramJSONObjectProxy.getStringOrNull("adword"));
                setBook(paramJSONObjectProxy.getBooleanOrNull("book"));
                setImage(paramJSONObjectProxy.getStringOrNull("imageurl"), null);
                setMarketPrice(paramJSONObjectProxy.getStringOrNull("martPrice"));
                setId(paramJSONObjectProxy.getLongOrNull("wareId"));
                setName(paramJSONObjectProxy.getStringOrNull("wname"));
                return;
            case 12://0xc   sswitch_d
                setName(paramJSONObjectProxy.getStringOrNull("Name"));
                return;
            case 14://0xe   sswitch_e
                setId(paramJSONObjectProxy.getLongOrNull("wareId"));
                setName(paramJSONObjectProxy.getStringOrNull("wname"));
                setImage(paramJSONObjectProxy.getStringOrNull("imageurl"), null);
                setJdPrice(paramJSONObjectProxy.getStringOrNull("jdPrice"));
                setImgPrice(paramJSONObjectProxy.getStringOrNull("wmaprice"));
                setMarketPrice(paramJSONObjectProxy.getStringOrNull("marketPrice"));
                setEndTime(paramJSONObjectProxy.getLongOrNull("endTime"));

                if (isFiledExist(paramJSONObjectProxy, "adword").booleanValue());
                setAdWord(paramJSONObjectProxy.getStringOrNull("adword"));
                return;
            case 15://0xf   sswitch_f
                setSkuColorList(SkuColor.toList(paramJSONObjectProxy.getJSONArrayOrNull("skuColor"), 0));
                setSkuSizeList(SkuSize.toList(paramJSONObjectProxy.getJSONArrayOrNull("skuSize"), 0));
                return;
            case 16://0x10  sswitch_10
                setAdWord(paramJSONObjectProxy.getStringOrNull("adword"));
                setBook(paramJSONObjectProxy.getBooleanOrNull("book"));
                setImage(paramJSONObjectProxy.getStringOrNull("imageurl"), null);
                setId(paramJSONObjectProxy.getLongOrNull("wareId"));
                setName(paramJSONObjectProxy.getStringOrNull("wname"));
                setMarketPrice(paramJSONObjectProxy.getStringOrNull("martPrice"));
                setJdPrice(paramJSONObjectProxy.getStringOrNull("jdPrice"));
                return;
            case 26://0x1a  sswitch_11
                setId(paramJSONObjectProxy.getLongOrNull("wareId"));
                setName(paramJSONObjectProxy.getStringOrNull("wname"));
                setImage(paramJSONObjectProxy.getStringOrNull("imageurl"), null);
                setJdPrice(paramJSONObjectProxy.getStringOrNull("jdPrice"));
                setImgPrice(paramJSONObjectProxy.getStringOrNull("wmaprice"));
                setMarketPrice(paramJSONObjectProxy.getStringOrNull("marketPrice"));
                if (isFiledExist(paramJSONObjectProxy, "adword").booleanValue())
                    setAdWord(paramJSONObjectProxy.getStringOrNull("adword"));
                addProductListScore(paramJSONObjectProxy);
                setGood(paramJSONObjectProxy.getStringOrNull("good"));
                return;
            case 17://0x11  sswitch_12
                setAdWord(paramJSONObjectProxy.getStringOrNull("adword"));
                setBook(paramJSONObjectProxy.getBooleanOrNull("book"));
                setImage(paramJSONObjectProxy.getStringOrNull("imageurl"), null);
                setId(paramJSONObjectProxy.getLongOrNull("wareId"));
                setName(paramJSONObjectProxy.getStringOrNull("wname"));
                setMiaoShaPrice(paramJSONObjectProxy.getStringOrNull("miaoShaPrice"));
                setJdPrice(paramJSONObjectProxy.getStringOrNull("jdPrice"));
                setStartTime(Long.valueOf(paramJSONObjectProxy.optLong("startRemainTime", 0L)));
                setEndTime(Long.valueOf(paramJSONObjectProxy.optLong("endRemainTime", 0L)));
                setRate(paramJSONObjectProxy.getStringOrNull("rate"));
                setsMsgId(paramJSONObjectProxy.optString("activeId"));
                setMiaoSha(paramJSONObjectProxy.getBooleanOrNull("miaoSha"));
                setJdDixcount(paramJSONObjectProxy.getStringOrNull("discount"));
                setDiscountNew(paramJSONObjectProxy.getStringOrNull("discountNew"));
                setMessage(paramJSONObjectProxy.getStringOrNull("message"));
                setCId(paramJSONObjectProxy.getStringOrNull("cid"));
                setCName(paramJSONObjectProxy.getStringOrNull("cName"));
                setSpuId(paramJSONObjectProxy.getStringOrNull("spuId"));
                setMoreFunId(paramJSONObjectProxy.getStringOrNull("moreFunId"));
                setExpid(paramJSONObjectProxy.getStringOrNull("expid"));
                setIndex(paramJSONObjectProxy.getStringOrNull("index"));
                setRid(paramJSONObjectProxy.getStringOrNull("rid"));
                setSourceValue(paramJSONObjectProxy.getStringOrNull("sourceValue"));
                setmShaShopId(paramJSONObjectProxy.getStringOrNull("shopId"));
                setMpageAddress(paramJSONObjectProxy.getStringOrNull("mpageAddress"));
                setOperateWord(paramJSONObjectProxy.getStringOrNull("operateWord"));
                setSpecialKill(paramJSONObjectProxy.getIntOrNull("specialKill"));
                setSoldRate(paramJSONObjectProxy.getIntOrNull("soldRate"));
                setNum(Integer.valueOf(paramJSONObjectProxy.optInt("seckillNum")));
                setTagType(paramJSONObjectProxy.optInt("tagType"));
                setTagText(paramJSONObjectProxy.optString("tagText"));
                this.yuyueNum = paramJSONObjectProxy.getIntOrNull("clockNum");
                setProvinceStockContent(paramJSONObjectProxy.optString("tips"));
                setAreaTips(paramJSONObjectProxy.getStringOrNull("areaTips"));
                setStartTimeShow(paramJSONObjectProxy.optString("startTimeShow", ""));
                return;
            case 33://0x21  sswitch_13
                setId(Long.valueOf(paramJSONObjectProxy.optLong("wareId", 0L)));
                setName(paramJSONObjectProxy.optString("wname", ""));
                setImage(paramJSONObjectProxy.optString("imageurl", ""), null);
                setJdPrice(paramJSONObjectProxy.optString("jdPrice"));
                setMiaoShaPrice(paramJSONObjectProxy.optString("miaoShaPrice", ""));
                setNum(Integer.valueOf(paramJSONObjectProxy.optInt("seckillNum", 0)));
                setSourceValue(paramJSONObjectProxy.optString("sourceValue", ""));
                setTagType(paramJSONObjectProxy.optInt("tagType"));
                setTagText(paramJSONObjectProxy.optString("tagText"));
                setSoldRate(paramJSONObjectProxy.getIntOrNull("soldRate"));
                this.yuyueNum = paramJSONObjectProxy.getIntOrNull("clockNum");
                setMiaoSha(Boolean.valueOf(paramJSONObjectProxy.optBoolean("miaoSha")));
                setSpuId(paramJSONObjectProxy.getStringOrNull("spuId"));
                setProvinceStockContent(paramJSONObjectProxy.optString("tips"));
                setAreaTips(paramJSONObjectProxy.getStringOrNull("areaTips"));
                setStartTimeShow(paramJSONObjectProxy.optString("startTimeShow", ""));
                return;
            case 34://0x22  sswitch_14
                setId(Long.valueOf(paramJSONObjectProxy.optLong("skuId", 0L)));
                setName(paramJSONObjectProxy.optString("skuName", ""));
                setImage(paramJSONObjectProxy.optString("skuImg", ""), null);
                setJdPrice(paramJSONObjectProxy.optString("jdPrice"));
                setSourceValue(paramJSONObjectProxy.optString("sourceValue", ""));
                setTagType(paramJSONObjectProxy.optInt("tagType"));
                setTagText(paramJSONObjectProxy.optString("tagText"));
                setMiaoSha(Boolean.valueOf(paramJSONObjectProxy.optBoolean("miaoSha")));
                return;
            case 18://0x12  sswitch_15
                setPromotionTitle(paramJSONObjectProxy.getStringOrNull("promotionInfoTitle"));
                setPromotionInfo(paramJSONObjectProxy.getStringOrNull("promotionInfo"));
                return;
            case 19://0x13  sswitch_16
                deliver = paramJSONObjectProxy.getStringOrNull("deliver");
                String v2 = null;
                if (!TextUtils.isEmpty(deliver) && !TextUtils.equals(deliver, "null")){//if-eqz v1, :cond_19
                    v2 = deliver;

                }
                setDeliver(v2);
                setPostByJd(paramJSONObjectProxy.getBooleanOrNull("isPostByJd"));
                return;
            case 20://0x14  sswitch_17
                try
                {
                    setId(Long.valueOf(Long.parseLong(paramJSONObjectProxy.getString("wareId"))));
                    if ((this.id == null) || (TextUtils.isEmpty(this.id.toString())))
                        setIsValid(false);
                    else
                        setIsValid(true);
                    setName(paramJSONObjectProxy.getStringOrNull("wname"));
                    setImage(paramJSONObjectProxy.getStringOrNull("imageurl"), null);
                    setJdPrice(paramJSONObjectProxy.getStringOrNull("jdPrice"));

                }
                catch (NumberFormatException e)
                {
                    e.printStackTrace();
                }
                catch (JSONException e)
                {
                    e.printStackTrace();
                }
                return;
            case 21://0x15  sswitch_18
                setId(paramJSONObjectProxy.getLongOrNull("wareId"));
                setName(paramJSONObjectProxy.getStringOrNull("wname"));
                setImage(paramJSONObjectProxy.getStringOrNull("imageurl"), null);
                setMarketPrice(paramJSONObjectProxy.getStringOrNull("martPrice"));
                setStartTime(paramJSONObjectProxy.getLongOrNull("startRemainTime"));
                setEndTime(paramJSONObjectProxy.getLongOrNull("endRemainTime"));
                setBook(paramJSONObjectProxy.getBooleanOrNull("book"));
                setJdPrice(paramJSONObjectProxy.getStringOrNull("jdPrice"));
                if (isFiledExist(paramJSONObjectProxy, "adword").booleanValue())
                    setAdWord(paramJSONObjectProxy.getStringOrNull("adword"));
                return;
            case 23://0x17  sswitch_19
                setAdWord(paramJSONObjectProxy.getStringOrNull("adword"));
                setBook(paramJSONObjectProxy.getBooleanOrNull("book"));
                setImage(paramJSONObjectProxy.getStringOrNull("imageurl"), null);
                setId(paramJSONObjectProxy.getLongOrNull("wareId"));
                setName(paramJSONObjectProxy.getStringOrNull("wname"));
                setJdPrice(paramJSONObjectProxy.getStringOrNull("jdPrice"));
                setStartTime(paramJSONObjectProxy.getLongOrNull("startRemainTime"));
                setEndTime(paramJSONObjectProxy.getLongOrNull("endRemainTime"));
                setMarketPrice(paramJSONObjectProxy.getStringOrNull("martPrice"));
                setCanFreeRead(paramJSONObjectProxy.getBooleanOrNull("canFreeRead"));
                return;
            case 24://0x18  sswitch_1a
                setId(paramJSONObjectProxy.getLongOrNull("SkuId"));
                setName(paramJSONObjectProxy.getStringOrNull("SkuName"));
                setImage(paramJSONObjectProxy.getStringOrNull("SkuPicUrl"), null);
                return;
            case 25://x019  sswitch_1b
                setName(paramJSONObjectProxy.getStringOrNull("MainSkuName"));
                setId(paramJSONObjectProxy.getLongOrNull("MainSkuId"));
                setImage(paramJSONObjectProxy.getStringOrNull("MainSkuPicUrl"), null);
                return;
            case 29://0x1d  sswitch_1c
                setName(paramJSONObjectProxy.getStringOrNull("wname"));
                setId(paramJSONObjectProxy.getLongOrNull("skuId"));
                setJdPrice(paramJSONObjectProxy.getStringOrNull("jdPrice"));
                setShopId(paramJSONObjectProxy.getLongOrNull("shopId").longValue());
                setShopUrl(paramJSONObjectProxy.getStringOrNull("shopUrl"));
                setImage(paramJSONObjectProxy.getStringOrNull("imageUrl"), null);
                setFatherId(paramJSONObjectProxy.getLongOrNull("fatherId").longValue());
                setVenderId(paramJSONObjectProxy.getLongOrNull("venderId").longValue());
                setVenderType(paramJSONObjectProxy.getIntOrNull("venderType"));
                setStockState(paramJSONObjectProxy.getIntOrNull("stockState"));
                setVenderName(paramJSONObjectProxy.getStringOrNull("venderName"));
                return;
            case 30://0x1e  sswitch_1d
                setId(paramJSONObjectProxy.getLongOrNull("wareId"));
                setName(paramJSONObjectProxy.getStringOrNull("wname"));
                setJdPrice(paramJSONObjectProxy.getStringOrNull("jdPrice"));
                setImage(paramJSONObjectProxy.getStringOrNull("imageurl"), null);
                setSourceValue(paramJSONObjectProxy.getStringOrNull("sourceValue"));
                setLookSimilar(paramJSONObjectProxy.getStringOrNull("lookSimilar"));
                setTargetUrl(paramJSONObjectProxy.optString("clickUrl"));
                return;
            case 10011://0x271b sswitch_1e
                setId(paramJSONObjectProxy.getLongOrNull("sku"));
                setName(paramJSONObjectProxy.getStringOrNull("wname"));
                setJdPrice(paramJSONObjectProxy.getStringOrNull("jdPrice"));
                setImage(paramJSONObjectProxy.getStringOrNull("imgUrl"), null);
                setSourceValue(paramJSONObjectProxy.getStringOrNull("sourceValue"));
                setGood(paramJSONObjectProxy.getStringOrNull("good"));
                addNewProductListScore(paramJSONObjectProxy);
                return;
            case 31://0x1f  sswitch_1f
                setmPaymentType(paramJSONObjectProxy.optString("pType", ""));
                this.tag = paramJSONObjectProxy.optString("pText");
                setItemCount(paramJSONObjectProxy.optInt("offset"));
                setId(paramJSONObjectProxy.getLongOrNull("sku"));
                setName(paramJSONObjectProxy.getStringOrNull("name"));
                setJdPrice(paramJSONObjectProxy.getStringOrNull("p"));
                setImage(paramJSONObjectProxy.getStringOrNull("img"), null);
                setAdWord(paramJSONObjectProxy.optString("slogan"));
                setMessageType(paramJSONObjectProxy.optString("tagType"));
                setMessage(paramJSONObjectProxy.optString("newTagText", ""));
                setSourceValue(paramJSONObjectProxy.optString("sourceValue", ""));
                setSoldRate(Integer.valueOf(paramJSONObjectProxy.optInt("onSell")));
                return;
            case 35://0x23  sswitch_20
                setId(Long.valueOf(paramJSONObjectProxy.optLong("sku")));
                setBuyCount(paramJSONObjectProxy.optInt("buyCount"));
                setDesc(paramJSONObjectProxy.optString("desc"));
                setHistoryPrice(paramJSONObjectProxy.optString("historyPrice"));
                setImage(paramJSONObjectProxy.optString("imgUrl"), null);
                setJdPrice(paramJSONObjectProxy.optString("jdPrice"));
                setHasPriceDiff(paramJSONObjectProxy.optInt("hasPriceDiff"));
                setPriceDiff(paramJSONObjectProxy.optString("priceDiff"));
                setPriceDiffText(paramJSONObjectProxy.optString("priceDiffText"));
                if (paramJSONObjectProxy.getJSONObjectOrNull("warePromotionInfo") != null)
                    setWarePromotionInfo(new Product.WarePromotionInfo(this, paramJSONObjectProxy.getJSONObjectOrNull("warePromotionInfo")));
                setPurchaseReminder(paramJSONObjectProxy.optInt("purchaseReminder"));
                setSourceValue(paramJSONObjectProxy.optString("sourceValue"));
                setPurchaseReminderIcon(paramJSONObjectProxy.optString("purchaseReminderIcon"));
                setSourceID(paramJSONObjectProxy.optInt("sourceID"));
                setSkuType(paramJSONObjectProxy.optString("skuType"));
                setSkuTypeId(paramJSONObjectProxy.optInt("skuTypeId"));
                setExcutableButtonsList(getExcutableButtonsList(paramJSONObjectProxy.getJSONArrayOrNull("buttons")));
                return;
        }
    }

    public class Sale
    {
        public String giftId;
        public String lable;
        public Long productId;
        public String promotionId;
        public String type;
        public String value;
    }

    public class PromotionInfo
    {
        private String msg;
        private String text;
        private int type;

        public PromotionInfo(Product paramProduct, JSONObjectProxy paramJSONObjectProxy)
        {
            if (paramJSONObjectProxy == null)
            {
                setMsg("");
                setText("");
                setType(0);
                return;
            }
            setText(paramJSONObjectProxy.optString("text"));
            setType(paramJSONObjectProxy.optInt("type"));
            setMsg(paramJSONObjectProxy.optString("msg"));
        }

        public String getMsg()
        {
            return this.msg;
        }

        public String getText()
        {
            return this.text;
        }

        public int getType()
        {
            return this.type;
        }

        public void setMsg(String paramString)
        {
            this.msg = paramString;
        }

        public void setText(String paramString)
        {
            this.text = paramString;
        }

        public void setType(int paramInt)
        {
            this.type = paramInt;
        }
    }

    public class WarePromotionInfo
    {
        private ArrayList<Product.PromotionInfo> promotionInfoList;
        private Long sku;

        public WarePromotionInfo(Product paramProduct, JSONObjectProxy paramJSONObjectProxy)
        {
            setSku(Long.valueOf(paramJSONObjectProxy.optLong("sku")));
            this.promotionInfoList = new ArrayList();
            JSONArrayProxy jsonArrayProxy = paramJSONObjectProxy.getJSONArrayOrNull("promotionInfos");
            if ((jsonArrayProxy != null) && (jsonArrayProxy.length() > 0))
            {
                for (int i = 0;i < jsonArrayProxy.length(); i++)
                {
                    Product.PromotionInfo localPromotionInfo = new Product.PromotionInfo(paramProduct, jsonArrayProxy.getJSONObjectOrNull(i));
                    this.promotionInfoList.add(localPromotionInfo);
                }
            }
        }

        public ArrayList<Product.PromotionInfo> getPromotionInfoList()
        {
            return this.promotionInfoList;
        }

        public Long getSku()
        {
            return this.sku;
        }

        public void setSku(Long paramLong)
        {
            this.sku = paramLong;
        }
    }

    public class OrderOptButton
            implements Serializable
    {
        public String showLabel;
        public int showLabelId;
    }

    public class MaterialRedirectProtocol
            implements Serializable
    {
        public String type;
        public String url;
    }

    public class ExcutableButton
    {
        private String icon;
        private int id;
        private String text;

        public ExcutableButton(Product paramProduct, JSONObjectProxy paramJSONObjectProxy)
        {
            if (paramJSONObjectProxy != null)
            {
                setText(paramJSONObjectProxy.optString("text"));
                setId(paramJSONObjectProxy.optInt("id"));
                setIcon(paramJSONObjectProxy.optString("icon"));
            }
        }

        public String getIcon()
        {
            return this.icon;
        }

        public int getId()
        {
            return this.id;
        }

        public String getText()
        {
            return this.text;
        }

        public void setIcon(String paramString)
        {
            this.icon = paramString;
        }

        public void setId(int paramInt)
        {
            this.id = paramInt;
        }

        public void setText(String paramString)
        {
            this.text = paramString;
        }
    }


}
