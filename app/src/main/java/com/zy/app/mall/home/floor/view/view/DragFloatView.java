package com.zy.app.mall.home.floor.view.view;

import android.view.MotionEvent;
import android.view.View;

import com.jingdong.app.mall.WebActivity;
import com.jingdong.app.mall.home.floor.b.FloorImageLoadCtrl;
import com.jingdong.common.BaseActivity;
import com.zy.app.mall.R;
import com.zy.app.mall.home.JDHomeFragment;
import com.zy.app.mall.home.floor.a.a.Constants;
import com.zy.app.mall.home.floor.a.b.MallFloorClickUtil;
import com.zy.common.entity.HomeFloorNewModel;
import com.zy.common.entity.JumpEntity;
import com.zy.common.utils.JDMtaUtils;

/**
 * Created by Robin on 2016/5/22.
 */
//a
public class DragFloatView {
    private static DragFloatView instance;
    private JDHomeFragment b;
    private HomeFloorNewModel c;
    private DragImageView d;
    private String e;
    private int f;
    private int g;
    private int h;
    private int i;
    //public final static int tag = R.id.image_last_url;//R.id.image_last_url

    public static DragFloatView getInstance()
    {
        if (instance == null) {
            synchronized (DragFloatView.class) {
                if (instance == null)
                    instance = new DragFloatView();
            }
        }
        return instance;

    }

    public final void a(JDHomeFragment paramJDHomeFragment, HomeFloorNewModel paramHomeFloorNewModel, DragImageView paramDragImageView)
    {
        this.b = paramJDHomeFragment;
        this.c = paramHomeFloorNewModel;
        this.d = paramDragImageView;
        this.e = this.c.getImg();
        if ("".equals(this.e))
        {
            this.d.setVisibility(View.GONE);
            return;
        }
        this.d.setOnTouchListener(new View.OnTouchListener(){//b(this)
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                switch (event.getAction())
                {
                    case MotionEvent.ACTION_DOWN: //pswitch_0
                        DragFloatView.this.f = (int)event.getX();
                        DragFloatView.this.g = (int)event.getY();
                        break;
                    case MotionEvent.ACTION_UP: //pswitch_1
                        DragFloatView.this.h = (int)event.getX();
                        DragFloatView.this.i = (int)event.getY();
                        if ((DragFloatView.this.h >= DragFloatView.this.f - 10) && (DragFloatView.this.h <= DragFloatView.this.f + 10) && (DragFloatView.this.i >= DragFloatView.this.g - 10) && (DragFloatView.this.i <= DragFloatView.this.g + 10)){
                            JumpEntity jump = DragFloatView.this.c.getJump();
                            if (jump != null){
                                String srv = jump.getSrv();
                                BaseActivity localBaseActivity = DragFloatView.this.b.thisActivity;
                                JDHomeFragment localJDHomeFragment = DragFloatView.this.b;
                                DragFloatView.this.c.getParam();
                                MallFloorClickUtil.b(localBaseActivity, localJDHomeFragment, srv, "Home_FloatingFloor", jump);
                                if (jump.getDes().equals("m"))
                                    JDMtaUtils.sendCommonData(DragFloatView.this.b.thisActivity, "Home_FloatingFloor", srv, "", DragFloatView.this.b, "", WebActivity.class, "", Constants.b);

                            }

                        }
                        break;
                }


                return false;
                }
        });
        this.b.thisActivity.post(new Runnable(){//c(this)
            @Override
            public void run() {
                FloorImageLoadCtrl.a(DragFloatView.this.d, DragFloatView.this.e, false, true);
                DragFloatView.this.d.setVisibility(View.VISIBLE);
            }
        });
    }
}
