package com.jingdong.common.utils.cache;

import com.c.a.a.b.LruBitmapCache;
import com.jingdong.app.mall.personel.a.a.PersonalMessageManager;

import java.util.HashMap;

/**
 * Created by Robin on 2016/5/16.
 */
public class GlobalImageCache {
    public static final int STATE_FAILURE = 2;
    public static final int STATE_LOADING = 1;
    public static final int STATE_NONE = 0;
    public static final int STATE_SUCCESS = 3;
    private static LruBitmapCache lruBitmapCache;

    public static LruBitmapCache getLruBitmapCache() {
        return lruBitmapCache;
    }
}
