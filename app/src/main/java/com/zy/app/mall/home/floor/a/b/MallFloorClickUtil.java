package com.zy.app.mall.home.floor.a.b;

import com.jingdong.app.mall.miaosha.MiaoShaActivity;
import com.jingdong.common.BaseActivity;
import com.zy.app.mall.home.floor.a.a.Constants;
import com.zy.common.channel.common.utils.JumpUtil;
import com.zy.common.entity.JumpEntity;
import com.zy.common.utils.JDMtaUtils;

/**
 * Created by Robin on 2016/5/22.
 */
//a
public class MallFloorClickUtil {
    public static void a(BaseActivity paramBaseActivity, Object paramObject, String paramString1, String paramString2, JumpEntity paramJumpEntity)
    {
        b(paramBaseActivity, paramObject, paramString1, "Home_Floor", paramJumpEntity);
    }

    public static void b(BaseActivity paramBaseActivity, Object paramObject, String paramString1, String paramString2, JumpEntity paramJumpEntity)
    {
        if (paramJumpEntity == null)
            return;
        JumpUtil.a(paramBaseActivity, paramJumpEntity, 1);
        String des = paramJumpEntity.getDes();
        if (("seckill".equals(des) | "miaosha".equals(des)))
        {
            JDMtaUtils.sendCommonData(paramBaseActivity, "Home_HandSeckill", paramString1, "", paramObject, "", MiaoShaActivity.class, "", Constants.b);
        }else if (("native_story".equals(des) | "story".equals(des))){
            JDMtaUtils.sendCommonData(paramBaseActivity, paramString2, paramString1, "", paramObject, "", "StoryMainActivity", "", Constants.b);
        }else{
            try
            {
                JDMtaUtils.sendCommonData(paramBaseActivity, paramString2, paramString1, "", paramObject, "", "", "", Constants.b);
            }
            catch (Exception e)
            {
                e.printStackTrace();
            }
        }

    }
}
