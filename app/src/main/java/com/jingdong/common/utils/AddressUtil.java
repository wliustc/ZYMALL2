package com.jingdong.common.utils;

import android.content.SharedPreferences;
import android.text.TextUtils;

import com.jd.framework.json.JDJSON;
import com.jingdong.app.mall.utils.LoginUser;
import com.jingdong.common.login.LoginUserBase;
import com.zy.common.entity.AddressGlobal;
import com.zy.common.entity.UserAddress;
import com.zy.common.utils.CommonUtil;

import java.util.ArrayList;

/**
 * Created by Robin on 2016/8/20.
 */
//f
public class AddressUtil {
    private static SharedPreferences a = CommonUtil.getJdSharedPreferences();

    public static int a(ArrayList<UserAddress> paramArrayList)
    {
        if ((paramArrayList == null) || (paramArrayList.size() == 0))
            return 0;
        return paramArrayList.size();
    }

    public static AddressGlobal a()
    {
        String v0 = a.getString(AddressUtil.e(), "");
        String v1 = a.getString( "AddressGlobal", "");
        AddressGlobal addressGlobal1 = null, addressGlobal2=null;
        if(!TextUtils.isEmpty(v0)){//if-nez v3, :cond_1
            addressGlobal1 = (AddressGlobal)JDJSON.parseObject(v0, AddressGlobal.class);//v3
        }
        if(!TextUtils.isEmpty(v1)){//if-nez v0, :cond_2
            addressGlobal2 = (AddressGlobal)JDJSON.parseObject(v1, AddressGlobal.class);//v0
        }
        if(LoginUserBase.hasLogin()){//if-eqz v1, :cond_6
            if(addressGlobal1 != null && addressGlobal2 != null) {
                if (addressGlobal1.getTimeStamp() > addressGlobal2.getTimeStamp())
                    return addressGlobal1;
                else
                    return addressGlobal2;
            }else if(addressGlobal1 != null)
                return addressGlobal1;
            else if(addressGlobal2 != null){
                return addressGlobal2;
            }
        }else{
            if(addressGlobal2 != null)
                return addressGlobal2;
        }
        return null;
    }



    private static String e()
    {
        String str = LoginUserBase.getLoginUserName();
        if (TextUtils.isEmpty(str))
            return "";
        return "Global_" + str;
    }
}
