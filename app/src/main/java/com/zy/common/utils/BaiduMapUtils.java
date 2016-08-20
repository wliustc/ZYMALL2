package com.zy.common.utils;

/**
 * Created by Robin on 2016/8/20.
 */
//o
public class BaiduMapUtils {
    public static double[] a(double paramDouble1, double paramDouble2)
    {
        paramDouble2 -= 0.0065D;
        double d = paramDouble1 - 0.006D;
        paramDouble1 = Math.sqrt(paramDouble2 * paramDouble2 + d * d) - 2.E-005D * Math.sin(52.359877559829883D * d);
        paramDouble2 = Math.atan2(d, paramDouble2) - Math.cos(paramDouble2 * 52.359877559829883D) * 3.E-006D;
        return new double[] { Math.sin(paramDouble2) * paramDouble1, Math.cos(paramDouble2) * paramDouble1 };
    }
}
