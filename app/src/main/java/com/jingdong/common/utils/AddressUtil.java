package com.jingdong.common.utils;

import android.content.SharedPreferences;
import android.text.TextUtils;

import com.jd.framework.json.JDJSON;
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
        if(!TextUtils.isEmpty(v0)){//if-nez v3, :cond_1
            JDJSON.parseObject(v0, AddressGlobal.class)
        }
    }



    private static String e()
    {
        String str = LoginUserBase.getLoginUserName();
        if (TextUtils.isEmpty(str))
            return "";
        return "Global_" + str;
    }
}
