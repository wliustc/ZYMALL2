package com.zy.common.utils;

import android.os.Process;
import android.text.TextUtils;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by Robin on 2016/11/23.
 */
//ev
public class ProcessUtil {

    public static String a(int paramInt)
    {
        String v0 = null;
        InputStreamReader v3 = null;
        BufferedReader v1 = null;
        try{
            v3 = new InputStreamReader(new FileInputStream(new StringBuilder("/proc/").append("/cmdline").toString()));
            v1 = new BufferedReader(v3);
            char[] v4 = new char[64];
            int v2=0;
            v1.read(v4);
            //:goto_0
            for (int i = 0; i<64 && v4[i] != 0; i++){//if-ge v0, v6, :cond_0
                v2++;
            }
            v0 = new String(v4, 0, v2);
        } catch (FileNotFoundException e) {//:catch_1   :catch_c    :catch_d
            e.printStackTrace();
            v0 = "";
        } catch (IOException e){//:catch_3  :catch_a    :catch_b
            e.printStackTrace();
            v0 = "";
        }finally {//:catchall_0 :catchall_1 :catchall_2
            try {
                if(v3 != null)
                    v3.close();
            } catch (IOException e) {//:catch_0
                e.printStackTrace();
            }
            try {
                if(v1 != null)
                    v1.close();
            } catch (IOException e) {//:catch_7
                e.printStackTrace();
            }
        }
        return v0;
    }
    public static boolean a() {
        String str = a(Process.myPid()).trim();
        if (!TextUtils.isEmpty(str) && TextUtils.equals(str, "com.zy.app.mall")){
            return true;
        }else {
            return false;
        }
    }
}
