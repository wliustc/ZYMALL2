package com.jingdong.app.mall.faxian.a.b;

import com.zy.app.mall.faxian.a.b.CachedActivityEntry;

import java.util.Stack;

/**
 * Created by Robin on 2016/5/20.
 */
//g
public class FaxianCacheJumpController {
    public static boolean b = false;
    private static FaxianCacheJumpController c;
    private static Stack<CachedActivityEntry> d = new Stack();
    final String TAG = FaxianCacheJumpController.class.getSimpleName();

    private static FaxianCacheJumpController instance;

    public static FaxianCacheJumpController getInstance() {
        if (instance == null)
            synchronized (FaxianCacheJumpController.class) {
                if (instance == null)
                    instance = new FaxianCacheJumpController();
            }
        return instance;
    }
}
