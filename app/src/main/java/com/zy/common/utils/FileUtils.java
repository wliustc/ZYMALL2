package com.zy.common.utils;

import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.os.Environment;
import android.os.StatFs;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.nio.channels.FileChannel;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * Created by robin on 16-8-19.
 */
//bp
public class FileUtils {
    private static final String HH = "0123456789abcdef";

    public static double a(File paramFile) {
        double d1 = 0.0D;
        if (paramFile != null && paramFile.exists()) {//if-eqz v2, :cond_0
            if (paramFile.isDirectory()) {//if-eqz v2, :cond_2
                File[] listFiles = paramFile.listFiles();
                if (listFiles != null) {//if-nez v3, :cond_1
                    for (int i = 0; i < listFiles.length; i++) {
                        d1 += a(listFiles[i]);
                    }
                }
            } else {//:cond_2
                d1 = paramFile.length() / 1024.0D / 1024.0D;
            }
        }//:cond_0
        return d1;
    }

    public static long a() {
        StatFs localStatFs = new StatFs(Environment.getDataDirectory().getPath());
        try {
            long l = localStatFs.getBlockSize();
            localStatFs.getBlockCount();
            l = localStatFs.getAvailableBlocks() * (l * 2L / 1024L) / 2L / 1024L;
            return l;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return -1L;
    }

    public static String a(Context paramContext, Uri paramUri) {
        if (paramUri != null) {
            String scheme = paramUri.getScheme();
            if (scheme == null)
                return paramUri.getPath();
            if ("file".equals(scheme))
                return paramUri.getPath();
            if ("content".equals(scheme)) {
                Cursor cursor = null;
                try {
                    cursor = paramContext.getContentResolver().query(paramUri, new String[]{"_data"}, null, null, null);
                    if (cursor != null) {
                        if (cursor.moveToFirst()) {
                            int i = cursor.getColumnIndex("_data");
                            if (i >= 0)
                                return cursor.getString(i);
                        }
                    }
                } finally {
                    if (cursor != null && !cursor.isClosed())
                        cursor.close();
                }

            }
        }
        return null;


    }

    public static String a(String paramString) {
        try {
            MessageDigest messageDigest = MessageDigest.getInstance("MD5");
            File file = new File(paramString);
            if ((file.exists()) && (file.isFile())) {
                messageDigest.update(new FileInputStream(file).getChannel().map(FileChannel.MapMode.READ_ONLY, 0L, file.length()));
                byte[] data = messageDigest.digest();
                StringBuilder builder = new StringBuilder(data.length * 2);
                ;

                for (int i = 0; i < data.length; i++) {
                    int k = data[i];
                    builder.append(HH.charAt(k >> 4 & 0xF));
                    builder.append(HH.charAt(k & 0xF));
                }
                return builder.toString();
            }
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (java.io.IOException e) {
        }
        return (String) null;
    }

    public static boolean b(String paramString) {
        if (Log.D)
            Log.d("FileUtils", "apkpath -->> " + paramString);
        return new File(paramString).exists();
    }
}
