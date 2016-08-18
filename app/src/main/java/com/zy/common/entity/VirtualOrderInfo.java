package com.zy.common.entity;

import android.text.TextUtils;

import com.alibaba.fastjson.parser.Feature;
import com.jd.framework.json.JDJSON;
import com.jd.framework.json.TypeToken;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

/**
 * Created by robin on 16-8-4.
 */
public class VirtualOrderInfo implements Serializable {
    public static final String REDIRECT_M = "M";
    public static final String REDIRECT_NATIVE = "Native";
    public static final int VIRTUAL_ORDER_TYPE_DATA_CHARGE = 87;
    public static final int VIRTUAL_ORDER_TYPE_FLIGHT = 35;
    public static final int VIRTUAL_ORDER_TYPE_GROUP = 28;
    public static final int VIRTUAL_ORDER_TYPE_HOTEL = 39;
    public static final int VIRTUAL_ORDER_TYPE_LOC = 75;
    public static final int VIRTUAL_ORDER_TYPE_LOTTERY = 36;
    public static final int VIRTUAL_ORDER_TYPE_MOVIE = 43;
    public static final int VIRTUAL_ORDER_TYPE_PHONE_CHARGE = 37;
    public static final int VIRTUAL_ORDER_TYPE_QQ_GAME_CHARGE = 34;
    public static final int VIRTUAL_ORDER_TYPE_YICHE = 90;
    public List<VirtualOrderButton> nextOperate;
    public long orderId;
    public VirtualOrderInfo.RedirectProtocol redirectProtocol;
    public boolean showDelButton;
    public String sumMoney;
    public VirtualOrderInfo.VirtualOrderStatus virtualOrderStatus;
    public VirtualOrderInfo.VirtualOrderType virtualOrderType;
    public List<VirtualOrderInfo.VirtualWare> wareInfos;

    public static VirtualOrderInfo parse(String paramString)
    {
        if (!TextUtils.isEmpty(paramString))
            return (VirtualOrderInfo) JDJSON.parseObject(paramString, new VirtualOrderInfo._1().getType(), new Feature[0]);
        return null;
    }

    public class VirtualOrderButton
    {
        public int buttonOperateId;
        public String buttonOperateName;
        public Map<String, String> param;
        public String text;
    }

    public class RedirectProtocol
    {
        public String param;
        public String type;
        public String url;
    }

    public class VirtualOrderStatus
    {
        public int orderStatusId;
        public String orderStatusName;
    }

    public class VirtualOrderType
    {
        public int orderTypeId;
        public String orderTypeName;
    }

    public class VirtualWare
    {
        public String imgUrl;
        public List<VirtualOrderInfo.VirtualOrderMessage> messages;
        public long wareId;
    }

    public class VirtualOrderMessage
    {
        public String msg;
        public String name;
    }

    public static class _1 extends TypeToken<VirtualOrderInfo> {

    }
}
