package com.jingdong.app.mall.shopping;

import android.os.Bundle;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AbsListView;

import com.zy.app.mall.basic.JDTaskModule;
import com.zy.app.mall.navigationbar.TabFragment;
import com.zy.app.mall.personel.a.a.PersonalMessageChannel;
import com.zy.app.mall.personel.a.a.PersonalMessageObserver;
import com.zy.app.mall.utils.ui.LastSectionExpandListView;

import java.util.Map;

/**
 * Created by Robin on 2016/5/19.
 */
public class JDShoppingCartFragment  extends TabFragment implements PersonalMessageObserver, LastSectionExpandListView {

    private static JDShoppingCartFragment instance;

    public static JDShoppingCartFragment getInstance() {
        if (instance == null)
            synchronized (JDShoppingCartFragment.class) {
                if (instance == null)
                    instance = new JDShoppingCartFragment();
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
    public void a(AbsListView paramAbsListView, int paramInt) {

    }

    @Override
    public void b(int paramInt1, int paramInt2) {

    }

    @Override
    public void onPersonalMessageReceived(Map<String, PersonalMessageChannel> paramMap) {

    }

    public static class JDShoppingCartTM extends JDTaskModule
    {
        private JDShoppingCartFragment shopping;

        public void doInit()
        {
            this.shopping = JDShoppingCartFragment.getInstance();
            if (this.shopping.getArguments() == null)
            {
                getBundle().putInt("com.360buy:navigationFlag", 3);
                this.shopping.setArguments(getBundle());
            }
        }

        public void doShow()
        {
            replaceAndCommit(this.shopping, Integer.valueOf(3));
        }
    }
}
