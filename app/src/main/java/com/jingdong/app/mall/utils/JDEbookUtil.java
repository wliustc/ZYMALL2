package com.jingdong.app.mall.utils;

import android.content.Intent;
import android.content.pm.PackageInfo;

import com.jingdong.app.mall.WebActivity;
import com.jingdong.common.BaseActivity;
import com.jingdong.common.utils.URLParamMap;
import com.zy.common.utils.DPIUtil;

/**
 * Created by robin on 16-8-26.
 */
//at
public class JDEbookUtil {
    public static void a(BaseActivity paramBaseActivity, String paramString)
    {
        URLParamMap localURLParamMap = new URLParamMap();
        Object localObject = CommonUtil.getPackageInfo(paramBaseActivity, "com.jingdong.app.reader");
        if (localObject != null);
        for (localObject = ((PackageInfo)localObject).versionName; ; localObject = "")
        {
            localURLParamMap.put("clientVersion", (String)localObject);
            localURLParamMap.put("screenSize", DPIUtil.getWidth() + "*" + DPIUtil.getHeight());
            if (paramBaseActivity != null)
                break;
            return;
        }
        localObject = new Intent(paramBaseActivity, WebActivity.class);
        SerializableContainer localSerializableContainer = new SerializableContainer();
        localSerializableContainer.setMap(localURLParamMap);
        ((Intent)localObject).putExtra("urlParamMap", localSerializableContainer);
        ((Intent)localObject).putExtra("urlAction", paramString);
        ((Intent)localObject).putExtra("from", "from_ebook");
        paramBaseActivity.startActivityInFrame((Intent)localObject);
    }
}
