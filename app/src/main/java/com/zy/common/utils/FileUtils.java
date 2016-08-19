package com.zy.common.utils;

import java.io.File;

/**
 * Created by robin on 16-8-19.
 */
//bp
public class FileUtils {
    public static double a(File paramFile)
    {
        double d1 = 0.0D;
        double d2 = d1;
        if (paramFile != null)
        {
            d2 = d1;
            if (paramFile.exists())
            {
                if (!paramFile.isDirectory())
                    break label74;
                paramFile = paramFile.listFiles();
                if (paramFile != null)
                    break label37;
                d2 = d1;
            }
        }
        return d2;
        label37: int j = paramFile.length;
        int i = 0;
        while (true)
        {
            d2 = d1;
            if (i >= j)
                break;
            d2 = a(paramFile[i]);
            i += 1;
            d1 = d2 + d1;
        }
        label74: return paramFile.length() / 1024.0D / 1024.0D;
    }

    public static long a()
    {
        StatFs localStatFs = new StatFs(Environment.getDataDirectory().getPath());
        try
        {
            long l = localStatFs.getBlockSize();
            localStatFs.getBlockCount();
            l = localStatFs.getAvailableBlocks() * (l * 2L / 1024L) / 2L / 1024L;
            return l;
        }
        catch (Exception localException)
        {
            localException.printStackTrace();
        }
        return -1L;
    }

    public static String a(Context paramContext, Uri paramUri)
    {
        Object localObject = null;
        if (paramUri == null);
        do
        {
            String str;
            do
            {
                return null;
                str = paramUri.getScheme();
                if (str == null)
                    return paramUri.getPath();
                if ("file".equals(str))
                    return paramUri.getPath();
            }
            while (!"content".equals(str));
            paramUri = paramContext.getContentResolver().query(paramUri, new String[] { "_data" }, null, null, null);
        }
        while (paramUri == null);
        paramContext = localObject;
        if (paramUri.moveToFirst())
        {
            int i = paramUri.getColumnIndex("_data");
            paramContext = localObject;
            if (i >= 0)
                paramContext = paramUri.getString(i);
        }
        paramUri.close();
        return paramContext;
    }

    public static String a(String paramString)
    {
        try
        {
            Object localObject = MessageDigest.getInstance("MD5");
            paramString = new File(paramString);
            if ((paramString.exists()) && (paramString.isFile()))
            {
                ((MessageDigest)localObject).update(new FileInputStream(paramString).getChannel().map(FileChannel.MapMode.READ_ONLY, 0L, paramString.length()));
                paramString = ((MessageDigest)localObject).digest();
                localObject = new StringBuilder(paramString.length * 2);
                int j = paramString.length;
                int i = 0;
                while (i < j)
                {
                    int k = paramString[i];
                    ((StringBuilder)localObject).append("0123456789abcdef".charAt(k >> 4 & 0xF));
                    ((StringBuilder)localObject).append("0123456789abcdef".charAt(k & 0xF));
                    i += 1;
                }
                paramString = ((StringBuilder)localObject).toString();
                return paramString;
            }
        }
        catch (NoSuchAlgorithmException paramString)
        {
            paramString.printStackTrace();
            return null;
        }
        catch (FileNotFoundException paramString)
        {
            while (true)
                paramString.printStackTrace();
        }
        catch (java.io.IOException paramString)
        {
            label141: break label141;
        }
        return (String)null;
    }

    public static boolean b(String paramString)
    {
        if (Log.D)
            Log.d("FileUtils", "apkpath -->> " + paramString);
        return new File(paramString).exists();
    }
}
