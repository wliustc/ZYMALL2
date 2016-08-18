package com.zy.common.entity;

import com.jingdong.common.utils.JSONObjectProxy;

import java.io.Serializable;

/**
 * Created by robin on 16-8-4.
 */
public class YushouOrder implements Serializable {
    public static final int LADDER_TYPE_DEFAULT = 0;
    public static final int LADDER_TYPE_GENERATED = 1;
    public static final int LADDER_TYPE_NOT_GENERATE = 2;
    public static final int PAY_TYPE_DEFAULT = 0;
    public static final int PAY_TYPE_ENTIRE = 1;
    public static final int PAY_TYPE_NOT_ENTIRE = 2;
    public static final int YUSHOU_DEFAULT = -2;
    public static final int YUSHOU_EXCEP_STATUS = -1;
    public static final int YUSHOU_FULLPAY_SUCESS = 7;
    public static final int YUSHOU_PAYBARGAIN_AND_PAYBALANCE = 5;
    public static final int YUSHOU_PAYBARGAIN_LESS_BALANCESTARTPAYTIME = 2;
    public static final int YUSHOU_PAYBARGAIN_MORE_BALANCESTARTPAYTIME_LESS_BALANCEENDPAYTIME = 3;
    public static final int YUSHOU_PAYBARGAIN_MORE_BALANCESTARTPAYTIME_MORE_BALANCEENDPAYTIME = 4;
    public static final int YUSHOU_UNPAYBARGAIN_LESS30MINS = 0;
    public static final int YUSHOU_UNPAYBARGAIN_MORE30MINS = 1;
    private int ladderType = 0;
    private String sendPay = "";
    private String yushouBalance;
    private String yushouBalanceShow;
    private String yushouBargin;
    private String yushouEndPayTime;
    private String yushouPayTime;
    private int yushouPayType;
    private int yushouState;

    public static YushouOrder fromJson(JSONObjectProxy paramJSONObjectProxy)
    {
        YushouOrder localYushouOrder = new YushouOrder();
        localYushouOrder.sendPay = paramJSONObjectProxy.getStringOrNull("sendPay");
        localYushouOrder.setYushouState(paramJSONObjectProxy.optInt("yushouState", -2));
        localYushouOrder.setYushouBargin(paramJSONObjectProxy.getStringOrNull("yushouBargin"));
        localYushouOrder.setYushouBalance(paramJSONObjectProxy.getStringOrNull("yushouBalance"));
        localYushouOrder.setYushouPayTime(paramJSONObjectProxy.getStringOrNull("yushouPayTime"));
        localYushouOrder.setYushouEndPayTime(paramJSONObjectProxy.getStringOrNull("yushouEndPayTime"));
        localYushouOrder.setYushouPayType(paramJSONObjectProxy.optInt("yushouPayType", 0));
        localYushouOrder.setLadderType(paramJSONObjectProxy.optInt("yushouLadderType", 0));
        localYushouOrder.setYushouBalanceShow(paramJSONObjectProxy.optString("yushouBalanceShow", ""));
        return localYushouOrder;
    }

    public boolean canPay()
    {
        return (this.yushouState == 0) || (this.yushouState == 3);
    }

    public int getLadderType()
    {
        return this.ladderType;
    }

    public String getYushouBalance()
    {
        return this.yushouBalance;
    }

    public String getYushouBalanceShow()
    {
        return this.yushouBalanceShow;
    }

    public String getYushouBargin()
    {
        return this.yushouBargin;
    }

    public String getYushouEndPayTime()
    {
        return this.yushouEndPayTime;
    }

    public String getYushouPayTime()
    {
        return this.yushouPayTime;
    }

    public int getYushouPayType()
    {
        return this.yushouPayType;
    }

    public int getYushouState()
    {
        return this.yushouState;
    }

    public boolean isBalacneTimoutCancel()
    {
        return this.yushouState == 4;
    }

    public boolean isBarginTimeoutCancel()
    {
        return this.yushouState == 1;
    }

    public boolean isCancel()
    {
        return (isBarginTimeoutCancel()) || (isBalacneTimoutCancel());
    }

    public boolean isEntirePay()
    {
        return this.yushouPayType == 1;
    }

    public boolean isYushou()
    {
        boolean i = false;
        try
        {
            return this.sendPay.substring(43, 44).equals("1");
        }
        catch (Exception localException)
        {
        }
        return false;
    }

    public void setLadderType(int paramInt)
    {
        this.ladderType = paramInt;
    }

    public void setYushouBalance(String paramString)
    {
        this.yushouBalance = paramString;
    }

    public void setYushouBalanceShow(String paramString)
    {
        this.yushouBalanceShow = paramString;
    }

    public void setYushouBargin(String paramString)
    {
        this.yushouBargin = paramString;
    }

    public void setYushouEndPayTime(String paramString)
    {
        this.yushouEndPayTime = paramString;
    }

    public void setYushouPayTime(String paramString)
    {
        this.yushouPayTime = paramString;
    }

    public void setYushouPayType(int paramInt)
    {
        this.yushouPayType = paramInt;
    }

    public void setYushouState(int paramInt)
    {
        this.yushouState = paramInt;
    }
}
