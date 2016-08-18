package com.zy.app.mall.home.floor.a.b;

import android.content.Context;
import android.graphics.Point;
import android.text.TextUtils;

import com.zy.app.mall.home.floor.model.entity.ISeparationFloorEntity;
import com.zy.app.mall.home.floor.view.baseUI.MallBaseFloor;
import com.zy.app.mall.home.floor.view.view.MallFloor_Announcement;
import com.zy.app.mall.home.floor.view.view.MallFloor_Banner;
import com.zy.app.mall.home.floor.view.view.MallFloor_Icon;
import com.zy.app.mall.home.floor.view.view.MallFloor_Left1Right1TopNBottom;
import com.zy.app.mall.home.floor.view.view.MallFloor_Left1RightN;
import com.zy.app.mall.home.floor.view.view.MallFloor_LinearLayout;
import com.zy.app.mall.home.floor.view.view.MallFloor_Overlay;
import com.zy.app.mall.home.floor.view.view.MallFloor_Panic;
import com.zy.app.mall.home.floor.view.view.MallFloor_Shop;
import com.zy.app.mall.home.floor.view.view.MallFloor_WithSubFloor;
import com.zy.common.utils.DPIUtil;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Robin on 2016/6/3.
 */
//b
public class MallFloorCommonUtil {
    //public static int a(String paramString, int paramInt)
    public static int str2Color(String str, int defaultColor)
    {
        if ((str != null) && (!str.isEmpty())) {
            Matcher matcher = Pattern.compile("^#([A-Fa-f0-9]{6})$|^#([A-Fa-f0-9]{2})([A-Fa-f0-9]{6})$").matcher(str);

            if (matcher.matches()) {
                String str1 = matcher.group(1);
                String str2 = matcher.group(2);
                String str3 = matcher.group(3);
                if ((str2 != null) && (str3 != null))
                    return Integer.parseInt(str2, 16) << 24 | Integer.parseInt(str3, 16);
                else if (str1 != null)
                    return 0xFF000000 | Integer.parseInt(str1, 16);
            }
        }
        return defaultColor;
    }

    //public static String a(String paramString)
    public static String null2Str(String paramString)
    {
        String str = "";
        if ((paramString != null) && (!paramString.equalsIgnoreCase("null")) && !paramString.contains("null"))
            str = paramString;
        return str;
    }

    public static MallBaseFloor<?> getMallFloorLayout(Context paramContext, int paramInt)
    {
        switch (paramInt)
        {
            default:
                return null;
            case MallFloorTypeUtil.HYBRID://hybrid
                return new MallFloor_WithSubFloor(paramContext);
            case MallFloorTypeUtil.E_05003://05003
                return new MallFloor_LinearLayout(paramContext, 2, 202);
            case MallFloorTypeUtil.E_05004://05004
                return new MallFloor_LinearLayout(paramContext, 2, 272);
            case MallFloorTypeUtil.E_05005://05005
                return new MallFloor_LinearLayout(paramContext, 3, 292);
            case MallFloorTypeUtil.E_05006://05006
                return new MallFloor_LinearLayout(paramContext, 4, 202);
            case MallFloorTypeUtil.E_05007://05007
                return new MallFloor_LinearLayout(paramContext, 4, 232);
            case MallFloorTypeUtil.E_12://12
                return new MallFloor_Overlay(paramContext);
            case MallFloorTypeUtil.E_15://15
                return new MallFloor_Panic(paramContext);
            case MallFloorTypeUtil.E_19://19
                return new MallFloor_Shop(paramContext);
            case MallFloorTypeUtil.BANNER://banner
                MallFloor_Banner banner = new MallFloor_Banner(paramContext, 350);
                banner.c(0);
                return banner;
            case MallFloorTypeUtil.E_05001://05001
                MallFloor_Banner banner1 = new MallFloor_Banner(paramContext, 165);
                banner1.c(10, 10, 10, 0);
                banner1.d(1000);
                return banner1;
            case MallFloorTypeUtil.E_05002://05002
                return new MallFloor_Banner(paramContext, 185);
            case MallFloorTypeUtil.E_05008://05008
                return new MallFloor_Left1RightN(paramContext, 2, 406);
            case MallFloorTypeUtil.E_05009://05009
                return new MallFloor_Left1Right1TopNBottom(paramContext, 2, 406);
            case MallFloorTypeUtil.APPCENTER://appcenter
                return new MallFloor_Icon(paramContext, 5, 2);
            case MallFloorTypeUtil.ANNOUNCEMENT://announcement
                return new MallFloor_Announcement(paramContext);
            case MallFloorTypeUtil.E_01003://01003
                ArrayList localArrayList = new ArrayList();
                localArrayList.add(Integer.valueOf(340));
                localArrayList.add(Integer.valueOf(170));
                localArrayList.add(Integer.valueOf(170));
                MallFloor_LinearLayout linearLayout = new MallFloor_LinearLayout(paramContext, 3, 370, 720, localArrayList);
                linearLayout.c(true);
                linearLayout.c(20, 100, 20, 20);
                return linearLayout;
            case MallFloorTypeUtil.E_01004://01004
                MallFloor_Left1RightN left1RightN = new MallFloor_Left1RightN(paramContext, 2, 370);
                left1RightN.c(true);
                left1RightN.c(20, 100, 20, 20);
                return left1RightN;
            case MallFloorTypeUtil.E_01005://01005
                MallFloor_Left1Right1TopNBottom left1Right1TopNBottom = new MallFloor_Left1Right1TopNBottom(paramContext, 2, 370);
                left1Right1TopNBottom.c(true);
                left1Right1TopNBottom.c(20, 100, 20, 20);
                return left1Right1TopNBottom;
        }

    }

    public static void a(int paramInt, ISeparationFloorEntity paramISeparationFloorEntity)
    {
        int i = DPIUtil.getWidthByDesignValue720(20);
        int j = DPIUtil.getWidthByDesignValue720(10);
        switch (paramInt)
        {
            case MallFloorTypeUtil.E_05003://05003//:pswitch_1
                paramISeparationFloorEntity.setSeparationLabelPos(_E.a);
                paramISeparationFloorEntity.setSeparationLabelMargin(new Point(i, j));
                paramISeparationFloorEntity.setSeparationLabelTextSizeDp(12.0F);
                paramISeparationFloorEntity.setSeparationImgPos(_D.RIGHT_TOP);
                paramISeparationFloorEntity.setSeparationImgMargin(new Point(j, i));
                paramISeparationFloorEntity.setSeparationImgWidthHeightBy720Design(150, 172);
                paramISeparationFloorEntity.setSeparationTitleCharCountLimit(5);
                paramISeparationFloorEntity.setSeparationSubTitleCharCountLimit(6);
                paramISeparationFloorEntity.setSeparationLabelCharCountLimit(5);
                break;
            case MallFloorTypeUtil.E_05004://05004//:pswitch_2
                paramISeparationFloorEntity.setSeparationLabelPos(_E.a);
                paramISeparationFloorEntity.setSeparationLabelMargin(new Point(i, j));
                paramISeparationFloorEntity.setSeparationLabelTextSizeDp(12.0F);
                paramISeparationFloorEntity.setSeparationImgPos(_D.RIGHT_BOTTOM);
                paramISeparationFloorEntity.setSeparationImgMargin(new Point(i, j));
                paramISeparationFloorEntity.setSeparationImgWidthHeightBy720Design(218, 155);
                paramISeparationFloorEntity.setSeparationTitleCharCountLimit(5);
                paramISeparationFloorEntity.setSeparationSubTitleCharCountLimit(9);
                paramISeparationFloorEntity.setSeparationLabelCharCountLimit(5);
                break;
            case MallFloorTypeUtil.E_05005://05005//:pswitch_3
                paramISeparationFloorEntity.setSeparationLabelPos(_E.d);
                paramISeparationFloorEntity.setSeparationLabelMargin(new Point(0, 0));
                paramISeparationFloorEntity.setSeparationLabelTextSizeDp(12.0F);
                paramISeparationFloorEntity.setSeparationLabelPadding(new Point(DPIUtil.getWidthByDesignValue720(5), 0));
                paramISeparationFloorEntity.setSeparationImgPos(_D.LEFT_BOTTOM);
                paramISeparationFloorEntity.setSeparationImgMargin(new Point(i, j));
                paramISeparationFloorEntity.setSeparationImgWidthHeightBy720Design(200, 173);
                paramISeparationFloorEntity.setSeparationTitleCharCountLimit(5);
                paramISeparationFloorEntity.setSeparationSubTitleCharCountLimit(7);
                paramISeparationFloorEntity.setSeparationLabelCharCountLimit(2);
                break;
            case MallFloorTypeUtil.E_05006://05006//:pswitch_4
                paramISeparationFloorEntity.setSeparationLabelPos(_E.d);
                paramISeparationFloorEntity.setSeparationLabelMargin(new Point(0, 0));
                paramISeparationFloorEntity.setSeparationLabelTextSizeDp(10.0F);
                paramISeparationFloorEntity.setSeparationLabelPadding(new Point(DPIUtil.getWidthByDesignValue720(5), 0));
                paramISeparationFloorEntity.setSeparationImgPos(_D.LEFT_BOTTOM);
                paramISeparationFloorEntity.setSeparationImgMargin(new Point(i, j));
                paramISeparationFloorEntity.setSeparationImgWidthHeightBy720Design(140, 90);
                paramISeparationFloorEntity.setSeparationTitleCharCountLimit(4);
                paramISeparationFloorEntity.setSeparationSubTitleCharCountLimit(6);
                paramISeparationFloorEntity.setSeparationLabelCharCountLimit(2);
                break;
            case MallFloorTypeUtil.E_05007://05007//:pswitch_5
                paramISeparationFloorEntity.setSeparationLabelPos(_E.d);
                paramISeparationFloorEntity.setSeparationLabelMargin(new Point(0, 0));
                paramISeparationFloorEntity.setSeparationLabelTextSizeDp(10.0F);
                paramISeparationFloorEntity.setSeparationLabelPadding(new Point(DPIUtil.getWidthByDesignValue720(5), 0));
                paramISeparationFloorEntity.setSeparationImgPos(_D.LEFT_BOTTOM);
                paramISeparationFloorEntity.setSeparationImgMargin(new Point(i, j));
                paramISeparationFloorEntity.setSeparationImgWidthHeightBy720Design(140, 120);
                paramISeparationFloorEntity.setSeparationTitleCharCountLimit(4);
                paramISeparationFloorEntity.setSeparationSubTitleCharCountLimit(6);
                paramISeparationFloorEntity.setSeparationLabelCharCountLimit(2);
                break;
            case MallFloorTypeUtil.E_12://12//:pswitch_0
            case MallFloorTypeUtil.E_15://15//:pswitch_0
            case MallFloorTypeUtil.E_19://19//:pswitch_0
            case MallFloorTypeUtil.BANNER://banner//:pswitch_0
            case MallFloorTypeUtil.E_05001://05001//:pswitch_0
            case MallFloorTypeUtil.E_05002://05002//:pswitch_0
                break;
            case MallFloorTypeUtil.E_05008://05008//:pswitch_6
            case MallFloorTypeUtil.E_05009://05009//:pswitch_6
                paramISeparationFloorEntity.setSeparationLabelPos(_E.a);
                paramISeparationFloorEntity.setSeparationLabelMargin(new Point(i, j));
                paramISeparationFloorEntity.setSeparationLabelTextSizeDp(12.0F);
                paramISeparationFloorEntity.setSeparationImgPos(_D.RIGHT_BOTTOM);
                paramISeparationFloorEntity.setSeparationImgMargin(new Point(j, j));
                break;
        }

    }

    public static void a(int paramInt1, ISeparationFloorEntity paramISeparationFloorEntity, int paramInt2)
    {
        switch (paramInt1){
            default:
                return;
            case MallFloorTypeUtil.E_05008://05008//:pswitch_0
                if (paramInt2 == 0)
                {
                    paramISeparationFloorEntity.setSeparationImgWidthHeightBy720Design(330, 280);
                    paramISeparationFloorEntity.setSeparationTitleCharCountLimit(5);
                    paramISeparationFloorEntity.setSeparationSubTitleCharCountLimit(9);
                    paramISeparationFloorEntity.setSeparationLabelCharCountLimit(7);
                }else {
                    paramISeparationFloorEntity.setSeparationImgWidthHeightBy720Design(150, 172);
                    paramISeparationFloorEntity.setSeparationTitleCharCountLimit(5);
                    paramISeparationFloorEntity.setSeparationSubTitleCharCountLimit(6);
                    paramISeparationFloorEntity.setSeparationLabelCharCountLimit(5);
                }
                break;
            case MallFloorTypeUtil.E_05009://05009//:pswitch_1
                if (paramInt2 == 0)
                {
                    paramISeparationFloorEntity.setSeparationImgWidthHeightBy720Design(330, 280);
                    paramISeparationFloorEntity.setSeparationTitleCharCountLimit(5);
                    paramISeparationFloorEntity.setSeparationSubTitleCharCountLimit(9);
                    paramISeparationFloorEntity.setSeparationLabelCharCountLimit(7);
                }else if (paramInt2 == 1){
                    paramISeparationFloorEntity.setSeparationImgWidthHeightBy720Design(150, 172);
                    paramISeparationFloorEntity.setSeparationTitleCharCountLimit(5);
                    paramISeparationFloorEntity.setSeparationSubTitleCharCountLimit(6);
                    paramISeparationFloorEntity.setSeparationLabelCharCountLimit(5);
                }else {
                    paramISeparationFloorEntity.setSeparationLabelPos(_E.d);
                    paramISeparationFloorEntity.setSeparationLabelMargin(new Point(0, 0));
                    paramISeparationFloorEntity.setSeparationLabelTextSizeDp(10.0F);
                    paramISeparationFloorEntity.setSeparationLabelPadding(new Point(DPIUtil.getWidthByDesignValue720(5), 0));
                    paramISeparationFloorEntity.setSeparationImgWidthHeightBy720Design(140, 90);
                    paramISeparationFloorEntity.setSeparationTitleCharCountLimit(4);
                    paramISeparationFloorEntity.setSeparationSubTitleCharCountLimit(6);
                    paramISeparationFloorEntity.setSeparationLabelCharCountLimit(2);
                }
                break;
        }

    }

    public static Point b(String paramString)
    {
        if (!TextUtils.isEmpty(paramString)) {
            Matcher matcher = Pattern.compile(".+mobilecms/s(\\d{2,3})x(\\d{2,3})_jfs/.+").matcher(paramString);
            if (matcher.matches() && matcher.groupCount() == 2) {
                try {
                    int i = Integer.parseInt(matcher.group(1));
                    int j = Integer.parseInt(matcher.group(2));
                    return new Point(DPIUtil.getWidthByDesignValue720(i), DPIUtil.getWidthByDesignValue720(j));
                } catch (java.lang.Exception e) {
                }
            }
        }
        return new Point(0, 0);
    }

//    private static class _C{
//        public static final int a[] = new int[30];
//        static {
//            a[MallFloorTypeUtil.r-1] = 1;
//            a[MallFloorTypeUtil.a-1] = 2;
//            a[MallFloorTypeUtil.b-1] = 3;
//            a[MallFloorTypeUtil.c-1] = 4;
//            a[MallFloorTypeUtil.d-1] = 5;
//            a[MallFloorTypeUtil.e-1] = 6;
//            a[MallFloorTypeUtil.f-1] = 7;
//            a[MallFloorTypeUtil.h-1] = 8;
//            a[MallFloorTypeUtil.i-1] = 9;
//            a[MallFloorTypeUtil.j-1] = 10;
//            a[MallFloorTypeUtil.k-1] = 11;
//            a[MallFloorTypeUtil.l-1] = 12;
//            a[MallFloorTypeUtil.s-1] = 13;
//            a[MallFloorTypeUtil.t-1] = 14;
//            a[MallFloorTypeUtil.m-1] = 15;
//            a[MallFloorTypeUtil.n-1] = 16;
//            a[MallFloorTypeUtil.u-1] = 17;
//            a[MallFloorTypeUtil.v-1] = 18;
//            a[MallFloorTypeUtil.w-1] = 19;
//        }
//    }

    public enum _D{
        LEFT_TOP, RIGHT_TOP, LEFT_BOTTOM, RIGHT_BOTTOM, CENTER
    }

    public static class _E{
        public static int a=1;
        public static int b=2;
        public static int c=3;
        public static int d=4;
        public static int e=5;
    }

    public static final class _G
    {
        public boolean a = false;
        public boolean b = false;
        public boolean c = false;
        public String d = "";
        public String e = "";
        public int backgroundColor = 0xFFFF0000;//-65536;
        public String text = "";//g
    }

    public static final class _F
    {
        public int backgroundColor = 0xFFFFFFFF;  //a
        public int b = -13684945;
        public float c = DPIUtil.getWidthByDesignValue720(30);
        public Point d = new Point(DPIUtil.getWidthByDesignValue720(20), DPIUtil.getWidthByDesignValue720(16));
        public int e = 0;
        public int f = -8684677;    //f
        public float g = DPIUtil.getWidthByDesignValue720(26);
        public Point h = new Point(DPIUtil.getWidthByDesignValue720(20), DPIUtil.getWidthByDesignValue720(4));
        public int i = 0;
        public int textColor = 0xFFFFFFFF;  //j
        public float textSize1 = 15.0F; //k
        public int l = _E.a;
        public Point m = new Point(0, 0);
        public int n = 0;
        public Point o = new Point(DPIUtil.getWidthByDesignValue720(6), 0);
        public _D p = _D.LEFT_BOTTOM;
        public int q = 0;
        public int r = 0;
        public Point s = new Point(0, 0);
        protected ArrayList<_G> t = new ArrayList();

        public final _G a(int paramInt)
        {
            if (this.t.size() <= paramInt)
            {
                _G localg = new _G();
                this.t.add(localg);
                return localg;
            }
            return (_G)this.t.get(paramInt);
        }
    }
}
