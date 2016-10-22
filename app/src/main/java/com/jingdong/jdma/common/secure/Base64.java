package com.jingdong.jdma.common.secure;

import java.io.UnsupportedEncodingException;

/**
 * Created by Robin on 2016/10/22.
 */
public class Base64 {
    
    public static byte[] decode(byte[] bytes) {
        return bytes;
    }

    public static String encodeBytes(byte[] encrypt) {
        try {
            return new String(encrypt, "utf-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return null;
    }
}
