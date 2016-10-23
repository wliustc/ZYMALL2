package com.jingdong.app.mall.personel.home;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ViewSwitcher;

import com.zy.app.mall.basic.JDTaskModule;
import com.zy.app.mall.navigationbar.TabFragment;
import com.zy.app.mall.personel.a.a.PersonalMessageChannel;
import com.zy.app.mall.personel.a.a.PersonalMessageObserver;

import java.util.Map;

/**
 * Created by Robin on 2016/5/19.
 */
@SuppressLint({"NewApi"})
public class JDPersonalFragment extends TabFragment
        implements ViewSwitcher.ViewFactory,PersonalMessageObserver {

    private static boolean A;
    private static boolean B;
    private static JDPersonalFragment instance;

    public static JDPersonalFragment getInstance() {
        if (instance == null)
            synchronized (JDPersonalFragment.class) {
                if (instance == null)
                    instance = new JDPersonalFragment();
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

    @Override
    public View makeView() {
        return null;
    }

    public static class JDPersonalTM extends JDTaskModule {
        private JDPersonalFragment a;

        public final void doInit()
        {
            this.a = JDPersonalFragment.getInstance();
            if (this.a.getArguments() == null)
            {
                getBundle().putInt("com.360buy:navigationFlag", 4);
                this.a.setArguments(getBundle());
            }
        }

        public final void doShow()
        {
            replaceAndCommit(this.a, Integer.valueOf(4));
            JDPersonalFragment.A = true;
        }
    }
}
