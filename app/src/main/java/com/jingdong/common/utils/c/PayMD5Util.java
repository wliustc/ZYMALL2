package com.jingdong.common.utils.c;

/**
 * Created by robin on 16-6-27.
 */
public class PayMD5Util {
    private static final String[] a = { "0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "a", "b", "c", "d", "e", "f" };
    public static String a(String paramString1, String paramString2)
    {
        throw new RuntimeException("Not Find a(String paramString1, String paramString2)");
    }

    private static String a(byte[] paramArrayOfByte)
    {
        StringBuffer localStringBuffer = new StringBuffer();
        int i = 0;
        while (i < paramArrayOfByte.length)
        {
            int k = paramArrayOfByte[i];
            int j = k;
            if (k < 0)
                j = k + 256;
            k = j / 16;
            localStringBuffer.append(a[k] + a[(j % 16)]);
            i += 1;
        }
        return localStringBuffer.toString();
    }
}
