package com.zy.app.mall.personel.a.a;

import java.util.Map;

/**
 * Created by Robin on 2016/5/5.
 */
//public abstract interface e
public interface PersonalMessageObserver {
    public abstract void onPersonalMessageReceived(Map<String, PersonalMessageChannel> paramMap);
}
