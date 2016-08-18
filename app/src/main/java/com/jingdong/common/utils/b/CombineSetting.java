package com.jingdong.common.utils.b;

import com.zy.app.mall.home.JDHomeFragment;

/**
 * Created by Robin on 2016/5/8.
 */
//e
public class CombineSetting {
    private static CombineSetting b;

    public static CombineSetting getInstance() {
        if (b == null)
            synchronized (CombineSetting.class){
                if (b == null)
                    b = new CombineSetting();
            }
        return b;
    }

    public void a(String indexManager_content) {

    }
}
