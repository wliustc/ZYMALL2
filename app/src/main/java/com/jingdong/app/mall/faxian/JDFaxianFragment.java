package com.jingdong.app.mall.faxian;

import android.os.Bundle;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;

import com.jingdong.app.mall.faxian.a.b.FaxianCacheJumpController;
import com.jingdong.app.mall.faxian.b.b.FaxianNavigator;
import com.jingdong.app.mall.faxian.b.c.FaxianPresenter;
import com.jingdong.app.mall.faxian.b.d.IFaxianUI;
import com.jingdong.common.entity.ChannelTabInfo;
import com.zy.app.mall.basic.JDTaskModule;
import com.zy.app.mall.navigationbar.INavigationPage;
import com.zy.app.mall.navigationbar.TabFragment;
import com.zy.app.mall.personel.a.a.PersonalMessageChannel;
import com.zy.app.mall.personel.a.a.PersonalMessageObserver;

import java.util.List;
import java.util.Map;

/**
 * Created by Robin on 2016/5/19.
 */
public class JDFaxianFragment extends TabFragment<FaxianPresenter, FaxianNavigator>
        implements IFaxianUI, INavigationPage, PersonalMessageObserver {
    private static JDFaxianFragment instance;

    public static JDFaxianFragment getInstance() {
        if (instance == null)
            synchronized (JDFaxianFragment.class) {
                if (instance == null)
                    instance = new JDFaxianFragment();
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
    public void a(List<ChannelTabInfo> paramList, boolean paramBoolean) {

    }

    @Override
    public void b() {

    }

    @Override
    public void onPersonalMessageReceived(Map<String, PersonalMessageChannel> paramMap) {

    }

    public static class JDFaxianTM extends JDTaskModule
    {
        private JDFaxianFragment faxian;

        public JDFaxianTM()
        {
            FaxianCacheJumpController.b = false;
        }

        public void doInit()
        {
            this.faxian = JDFaxianFragment.getInstance();
            if (this.faxian.getArguments() == null)
            {
                getBundle().putInt("com.360buy:navigationFlag", 2);
                this.faxian.setArguments(getBundle());
            }
        }

        public void doShow()
        {
            replaceAndCommit(this.faxian, Integer.valueOf(2));
        }
    }
}
