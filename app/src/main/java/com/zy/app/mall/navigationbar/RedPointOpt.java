package com.zy.app.mall.navigationbar;

import android.content.SharedPreferences;
import android.os.Handler;

import com.jingdong.app.mall.MyApplication;
import com.jingdong.app.mall.utils.CommonUtil;
import com.zy.app.mall.MainFrameActivity;
import com.zy.app.mall.utils.frame.TabBarButton;

/**
 * Created by Robin on 2016/5/19.
 */
//s
public class RedPointOpt {
    public static final String a = RedPointOpt.class.getSimpleName();
    private static RedPointOpt instance;
    private SharedPreferences c = CommonUtil.getJdSharedPreferences();
    private SharedPreferences.Editor d = this.c.edit();

    //a()
    public synchronized static RedPointOpt getInstance(){
        if (instance == null){
            synchronized (RedPointOpt.class){
                if(instance == null){
                    instance = new RedPointOpt();
                }
            }
        }
        return instance;
    }

    public final void a(int paramInt) {
        Object localObject = MyApplication.getInstance().getMainFrameActivity();
        if (localObject != null) {
            localObject = ((MainFrameActivity) localObject).getHandler();
            if (localObject != null) {
                int i = 0;
                if (paramInt == 4) {//if-ne p1, v3, :cond_3
                    this.d.putInt("shared_personal_redpointflag_navigation", 0).commit();
                } else if (this.c.getInt("shared_personal_redpointflag_navigation", 0) == 1)
                    i = 1;

                if (i != 0)
                    ((Handler) localObject).post(new Runnable(){//t(this)
                        @Override
                        public void run() {
                            if (MyApplication.getInstance().getMainFrameActivity() != null){
                                if (MainFrameActivity.f() != null)
                                MainFrameActivity.f().a(Boolean.valueOf(true));
                            }
                                return;
                        }
                    });
                else
                    ((Handler) localObject).post(new Runnable(){//u(this)
                        @Override
                        public void run() {
                            if (MyApplication.getInstance().getMainFrameActivity() != null){
                                if(MainFrameActivity.f() != null)
                                MainFrameActivity.f().a(Boolean.valueOf(false));
                            }
                                return;
                        }
                    });
            }
        }
        return;
    }

    public final void a(int paramInt, boolean paramBoolean)
    {
        int i = 1;
        Object localObject = MyApplication.getInstance().getMainFrameActivity();
        if (localObject != null)
        {//if-eqz v2, :cond_1
            localObject = ((MainFrameActivity)localObject).getHandler();
            if (localObject != null)
            {//if-eqz v2, :cond_1
                if (!paramBoolean)
                {//if-nez p2, :cond_0
                    if (paramInt == 2) {//if-ne p1, v3, :cond_2
                        this.d.putInt("shared_faxian_redpoint_flag", 0).commit();
                        //:cond_0
                        i = 0;
                    }else if (this.c.getInt("shared_faxian_redpoint_flag", 0) != 1) //if-ne v3, v0, :cond_0
                        i = 0;
                        //goto :goto_0
                }

                //:goto_0
                if (i != 0)
                    ((Handler)localObject).post(new Runnable(){//v(this)
                        @Override
                        public void run() {
                            if (MyApplication.getInstance().getMainFrameActivity() != null){
                                TabBarButton.RedPoint localc = MainFrameActivity.g();
                                if (localc != null)
                                    localc.b(Boolean.valueOf(true));
                            }
                                return;
                        }
                    });
                else
                    ((Handler)localObject).post(new Runnable(){//w(this)
                        @Override
                        public void run() {
                            if (MyApplication.getInstance().getMainFrameActivity() != null){
                                TabBarButton.RedPoint localc = MainFrameActivity.g();
                                if (localc != null);
                                localc.b(Boolean.valueOf(false));
                            }
                                return;
                        }
                    });
            }
        }
        //:cond_1
        //:goto_1
            a(paramInt);
            return;

    }
}
