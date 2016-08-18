package com.jingdong.app.mall.navigationbar;

import android.os.Bundle;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;

import com.jingdong.app.mall.faxian.a.b.FaxianCacheJumpController;
import com.zy.app.mall.basic.JDTaskModule;
import com.zy.app.mall.navigationbar.JDTabFragment;
import com.zy.app.mall.personel.a.a.PersonalMessageChannel;
import com.zy.app.mall.personel.a.a.PersonalMessageObserver;

import java.util.Map;

/**
 * Created by Robin on 2016/5/20.
 */
public class JDMFragment extends JDTabFragment implements PersonalMessageObserver {
    private static JDMFragment instance;

    public static JDMFragment getInstance() {
        if (instance == null)
            synchronized (JDMFragment.class) {
                if (instance == null)
                    instance = new JDMFragment();
            }
        return instance;
    }

    @Override
    public void a(int paramInt1, int paramInt2) {

    }

    @Override
    public View onCreateViews(LayoutInflater layoutInflater, Bundle bundle) {
        return null;
    }

    @Override
    public boolean onKeyDown(int paramInt, KeyEvent keyEvent) {
        return false;
    }

    @Override
    public void onPersonalMessageReceived(Map<String, PersonalMessageChannel> paramMap) {

    }

    public static class JDMM extends JDTaskModule
    {
        private JDMFragment mFragment;

        public JDMM()
        {
            FaxianCacheJumpController.b = true;
        }

        public void doInit()
        {
            this.mFragment = JDMFragment.getInstance();
            getBundle().putInt("com.360buy:navigationFlag", 2);
            this.mFragment.setArguments(getBundle());
        }

        public void doShow()
        {
            replaceAndCommit(this.mFragment, Integer.valueOf(6));
        }
    }
}
