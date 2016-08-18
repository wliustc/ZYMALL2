package com.jingdong.common.sample.jshop;

import android.view.MotionEvent;
import android.view.View;

import com.zy.app.mall.personel.a.a.PersonalMessageChannel;
import com.zy.app.mall.personel.a.a.PersonalMessageObserver;
import com.zy.app.mall.utils.MyActivity;

import java.util.Map;

/**
 * Created by Robin on 2016/6/20.
 */
public class JshopMainShopActivity extends MyActivity
        implements View.OnTouchListener, PersonalMessageObserver {
    @Override
    public boolean onTouch(View v, MotionEvent event) {
        return false;
    }

    @Override
    public void onPersonalMessageReceived(Map<String, PersonalMessageChannel> paramMap) {

    }
}
