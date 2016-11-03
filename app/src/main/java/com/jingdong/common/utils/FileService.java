package com.jingdong.common.utils;

import android.os.Environment;
import android.os.StatFs;

import com.zy.common.utils.Log;

import java.io.File;
import java.util.ArrayList;

/**
 * Created by Robin on 2016/11/3.
 */
public class FileService {
    private static int a = -20;
    private static int b = -20;
    private static bl c;
    private static bn d = new bn(2, "/json");
    private static bn e = new bn(5, "/json");
    private static bn f = new bn(1, "/image");

    public static bm a(int paramInt)
    {
        switch (paramInt)
        {
            default:
            case 2:
            case 1:
            case 5:
            case 3:
            case 4:
            case 6:
        }
        do
        {
            do
            {
                do
                {
                    return null;
                    return d.a();
                    return f.a();
                    return e.a();
                }
                while (h() <= 16777216L);
                return new bm(a("/camera"), 2);
            }
            while (c() <= 8388608L);
            if (Log.D)
                Log.d("FileService", "getDirectoryByJsonSize() -->> INTERNAL");
            return new bm(a("/persist", 2, false), 1);
            if (Log.D)
                Log.d("FileService", "getDirectoryByImageSize() -->> ");
            if (!b())
                continue;
            if (Log.D)
                Log.d("FileService", "getDirectoryByImageSize() -->> EXTERNAL");
            return new bm(a("/file"), 2);
        }
        while (c() <= 8388608L);
        if (Log.D)
            Log.d("FileService", "getDirectoryByImageSize() -->> INTERNAL");
        return new bm(a("/file", 2, false), 1);
    }

    public static File a(String paramString)
    {
        if (Log.D)
            Log.d("FileService", "getExternalDirectory() -->> ");
        File localFile = Environment.getExternalStorageDirectory();
        StringBuilder localStringBuilder = new StringBuilder("/jingdong");
        if (paramString != null);
        while (true)
        {
            paramString = new File(localFile, paramString);
            if (!paramString.exists())
                paramString.mkdirs();
            return paramString;
            paramString = "";
        }
    }

    private static File a(String paramString, int paramInt, boolean paramBoolean)
    {
        if (Log.D)
            Log.d("FileService", "getInternalDirectory() -->> ");
        File localFile = BaseApplication.getInstance().getCacheDir();
        StringBuilder localStringBuilder = new StringBuilder("/jingdong");
        if (paramString != null);
        while (true)
        {
            paramString = new File(localFile, paramString);
            if (!paramString.exists())
                paramString.mkdirs();
            if (paramBoolean)
            {
                a("755", new File(localFile, "/jingdong"));
                a("755", paramString);
            }
            if (Log.D)
                Log.d("FileService", "getInternalDirectory() dir.getAbsolutePath() -->> " + paramString.getAbsolutePath());
            if (Log.D)
                Log.d("FileService", "getInternalDirectory() dir.exists() -->> " + paramString.exists());
            return paramString;
            paramString = "";
        }
    }

    public static File a(String paramString, boolean paramBoolean)
    {
        return a(paramString, 2, false);
    }

    private static FileOutputStream a(bi parambi)
            throws FileNotFoundException
    {
        String str1 = null;
        Object localObject;
        int i;
        while (true)
        {
            long l = parambi.d();
            boolean bool = parambi.b();
            Log.i("FileService", "availableSize : " + l);
            if (0L != l)
            {
                if ((1 == parambi.a()) && (c() < l))
                {
                    Log.i("FileService", "internal not enough: " + c());
                    localObject = str1;
                    if (!bool)
                        break;
                    Log.i("FileService", "internal not enough, try external");
                    parambi.a(2);
                    parambi.a(false);
                    continue;
                }
                if ((2 == parambi.a()) && (g() < l))
                {
                    Log.i("FileService", "external not enough: " + g());
                    localObject = str1;
                    if (!bool)
                        break;
                    Log.i("FileService", "external not enough, try internal");
                    parambi.a(1);
                    parambi.a(false);
                    continue;
                }
            }
            if (!CommonUtil.getPlugOn())
                break label309;
            str1 = BaseApplication.getInstance().getFilesDir().getAbsolutePath();
            String str2 = parambi.e();
            localObject = str1;
            if (!TextUtils.isEmpty(str2))
                localObject = str1 + "/" + str2;
            localObject = new File((String)localObject);
            if (!((File)localObject).exists())
                ((File)localObject).mkdirs();
            localObject = new File((File)localObject, parambi.f());
            i = parambi.g();
            if (i != 1)
                break label294;
            a("644", (File)localObject);
        }
        while (true)
        {
            localObject = new FileOutputStream((File)localObject);
            return localObject;
            label294: if (i != 2)
                continue;
            a("622", (File)localObject);
        }
        label309: return (FileOutputStream)BaseApplication.getInstance().openFileOutput(parambi.f(), parambi.g());
    }

    public static String a(File paramFile)
    {
        Object localObject = null;
        bi localbi = new bi();
        localbi.a(1);
        localbi.a(true);
        localbi.b("shareimage.jpg");
        localbi.b(1);
        try
        {
            FileOutputStream localFileOutputStream = a(localbi);
            by.a(new FileInputStream(paramFile), localFileOutputStream, null, new bk());
            paramFile = b(localbi);
            return paramFile;
        }
        catch (Exception localException)
        {
            do
                paramFile = localObject;
            while (!Log.D);
            localException.printStackTrace();
            Log.d("FileService", " saveShareImage-->> " + localException.getMessage());
        }
        return null;
    }

    public static String a(byte[] paramArrayOfByte)
    {
        Object localObject = null;
        bi localbi = new bi();
        localbi.a(1);
        localbi.a(true);
        localbi.b("shareimage.jpg");
        localbi.b(1);
        try
        {
            FileOutputStream localFileOutputStream = a(localbi);
            localFileOutputStream.write(paramArrayOfByte);
            localFileOutputStream.flush();
            localFileOutputStream.close();
            paramArrayOfByte = b(localbi);
            return paramArrayOfByte;
        }
        catch (Exception localException)
        {
            do
                paramArrayOfByte = localObject;
            while (!Log.D);
            localException.printStackTrace();
            Log.d("FileService", " saveShareImage-->> " + localException.getMessage());
        }
        return null;
    }

    public static void a()
    {
        d.a = true;
        f.a = true;
        e.a = true;
    }

    private static void a(bm parambm)
    {
        monitorenter;
        while (true)
            try
            {
                File localFile = parambm.b();
                int i = 0;
                switch (bm.a(parambm))
                {
                    case 1:
                        if (!Log.D)
                            continue;
                        Log.d("FileService", "tryCleanImageDir currentNum:" + i);
                        if ((i <= 4096) || (c != null))
                            continue;
                        parambm = new bl(localFile);
                        c = parambm;
                        parambm.start();
                        return;
                    if (b != -20)
                        continue;
                    b = c(localFile);
                    i = b;
                    break;
                    case 2:
                        if (a != -20)
                            continue;
                        a = c(localFile);
                        i = a;
                        continue;
                }
            }
            finally
            {
                monitorexit;
            }
    }

    public static void a(String paramString, File paramFile)
    {
        try
        {
            if (!paramFile.exists())
                paramFile.createNewFile();
            Runtime.getRuntime().exec("chmod " + paramString + " " + paramFile);
            return;
        }
        catch (Exception localException)
        {
            while (!Log.D);
            localException.printStackTrace();
            Log.d("FileService", " -->> chModFile mode:" + paramString + " file:" + paramFile + " error:" + localException.getMessage());
        }
    }

    public static boolean a(bm parambm, String paramString, byte[] paramArrayOfByte)
    {
        if (paramArrayOfByte == null)
            return false;
        return b(parambm, paramString, paramArrayOfByte, 0);
    }

    public static boolean a(bm parambm, String paramString, byte[] paramArrayOfByte, int paramInt)
    {
        int i;
        if ((paramArrayOfByte == null) || (paramArrayOfByte.length <= 0) || (TextUtils.isEmpty(paramString)) || (parambm == null))
        {
            i = 0;
            return i;
        }
        if (Log.D)
        {
            Log.d("FileService", "saveToSDCardWithType phoneMemoryImageCacheNum:" + b);
            Log.d("FileService", "saveToSDCardWithType sdCardImageCacheNum:" + a);
        }
        switch (paramInt)
        {
            default:
            case 1:
        }
        while (true)
        {
            boolean bool = a(parambm, paramString, paramArrayOfByte);
            if (Log.D)
                Log.d("FileService", "saveToSDCardWithType result:" + bool);
            i = bool;
            if (!bool)
                break;
            i = bool;
            if (paramInt - 1 != 0)
                break;
            b(parambm);
            return bool;
            a(parambm);
        }
    }

    public static byte[] a(FileInputStream paramFileInputStream)
            throws Exception
    {
        ByteArrayOutputStream localByteArrayOutputStream = new ByteArrayOutputStream();
        byte[] arrayOfByte = new byte[1024];
        while (true)
        {
            int i = paramFileInputStream.read(arrayOfByte);
            if (i == -1)
                break;
            localByteArrayOutputStream.write(arrayOfByte, 0, i);
        }
        paramFileInputStream.close();
        localByteArrayOutputStream.close();
        return localByteArrayOutputStream.toByteArray();
    }

    private static String b(bi parambi)
    {
        return BaseApplication.getInstance().getFilesDir().getAbsolutePath() + "/" + parambi.f();
    }

    private static void b(bm parambm)
    {
        monitorenter;
        if (parambm == null);
        while (true)
        {
            monitorexit;
            return;
            File localFile;
            try
            {
                localFile = parambm.b();
                if ((localFile == null) || (!localFile.exists()))
                    continue;
                switch (bm.a(parambm))
                {
                    case 1:
                        if (b == -20)
                            b = c(localFile);
                        b += 1;
                        continue;
                    case 2:
                }
            }
            finally
            {
                monitorexit;
            }
            if (a == -20)
                a = c(localFile);
            a += 1;
            continue;
        }
    }

    public static boolean b()
    {
        return Environment.getExternalStorageState().equals("mounted");
    }

    // ERROR //
    private static boolean b(bm parambm, String paramString, byte[] paramArrayOfByte, int paramInt)
    {
        // Byte code:
        //   0: aload_0
        //   1: ifnull +14 -> 15
        //   4: aload_1
        //   5: invokestatic 209	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
        //   8: ifne +7 -> 15
        //   11: aload_2
        //   12: ifnonnull +5 -> 17
        //   15: iconst_0
        //   16: ireturn
        //   17: new 111	java/io/File
        //   20: dup
        //   21: aload_0
        //   22: invokevirtual 281	com/jingdong/common/utils/bm:b	()Ljava/io/File;
        //   25: aload_1
        //   26: invokespecial 122	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
        //   29: astore_0
        //   30: new 221	java/io/FileOutputStream
        //   33: dup
        //   34: aload_0
        //   35: invokespecial 224	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
        //   38: astore_1
        //   39: aload_1
        //   40: ifnull +10 -> 50
        //   43: aload_1
        //   44: astore_0
        //   45: aload_1
        //   46: aload_2
        //   47: invokevirtual 270	java/io/FileOutputStream:write	([B)V
        //   50: aload_1
        //   51: ifnull +7 -> 58
        //   54: aload_1
        //   55: invokevirtual 276	java/io/FileOutputStream:close	()V
        //   58: iconst_1
        //   59: ireturn
        //   60: astore_2
        //   61: aconst_null
        //   62: astore_1
        //   63: aload_1
        //   64: astore_0
        //   65: aload_2
        //   66: invokevirtual 260	java/lang/Exception:printStackTrace	()V
        //   69: aload_1
        //   70: ifnull -55 -> 15
        //   73: aload_1
        //   74: invokevirtual 276	java/io/FileOutputStream:close	()V
        //   77: iconst_0
        //   78: ireturn
        //   79: astore_0
        //   80: iconst_0
        //   81: ireturn
        //   82: astore_1
        //   83: aconst_null
        //   84: astore_0
        //   85: aload_0
        //   86: ifnull +7 -> 93
        //   89: aload_0
        //   90: invokevirtual 276	java/io/FileOutputStream:close	()V
        //   93: aload_1
        //   94: athrow
        //   95: astore_0
        //   96: goto -38 -> 58
        //   99: astore_0
        //   100: goto -7 -> 93
        //   103: astore_1
        //   104: goto -19 -> 85
        //   107: astore_2
        //   108: goto -45 -> 63
        //
        // Exception table:
        //   from	to	target	type
        //   30	39	60	java/lang/Exception
        //   73	77	79	java/io/IOException
        //   30	39	82	finally
        //   54	58	95	java/io/IOException
        //   89	93	99	java/io/IOException
        //   45	50	103	finally
        //   65	69	103	finally
        //   45	50	107	java/lang/Exception
    }

    private static int c(File paramFile)
    {
        if ((paramFile != null) && (paramFile.exists()))
        {
            paramFile = paramFile.list();
            if (paramFile != null)
                return paramFile.length;
        }
        return -20;
    }

    public static long c()
    {
        StatFs localStatFs = new StatFs(Environment.getDataDirectory().getPath());
        long l = localStatFs.getBlockSize();
        return localStatFs.getAvailableBlocks() * l;
    }

    private static void c(bm parambm)
    {
        if (parambm == null);
        while (true)
        {
            return;
            parambm = parambm.b();
            if ((parambm == null) || (!parambm.exists()))
                continue;
            String[] arrayOfString = parambm.list();
            if (arrayOfString == null)
                continue;
            int j = arrayOfString.length;
            int i = 0;
            while (i < j)
            {
                File localFile = new File(parambm, arrayOfString[i]);
                if (localFile.exists())
                    localFile.delete();
                i += 1;
            }
        }
    }

    public static void d()
    {
        ArrayList localArrayList = a.a();
        boolean bool1 = b();
        int i = 0;
        while (i < localArrayList.size())
        {
            CacheFile localCacheFile = (CacheFile)localArrayList.get(i);
            if (localCacheFile != null)
            {
                bm localbm = localCacheFile.getDirectory();
                if ((localbm != null) && ((localbm.c() == 1) || ((localbm.c() == 2) && (bool1 == true))))
                {
                    boolean bool2 = localCacheFile.getFile().delete();
                    if (Log.D)
                        Log.d("FileService", "cacheFile.getName() -->> " + localCacheFile.getName());
                    if (bool2)
                        a.a(localCacheFile);
                }
            }
            i += 1;
        }
        e(-20);
        d(-20);
    }

    private static void d(int paramInt)
    {
        monitorenter;
        try
        {
            a = paramInt;
            monitorexit;
            return;
        }
        finally
        {
            localObject = finally;
            monitorexit;
        }
        throw localObject;
    }

    public static void e()
    {
        bm localbm = f.a();
        if ((localbm != null) && (localbm.c() == 1) && (c() < 52428800L))
        {
            c(localbm);
            e(-20);
        }
    }

    private static void e(int paramInt)
    {
        monitorenter;
        try
        {
            b = paramInt;
            monitorexit;
            return;
        }
        finally
        {
            localObject = finally;
            monitorexit;
        }
        throw localObject;
    }

    public static void f()
    {
        if (b())
        {
            c(new bm(a("/image"), 2));
            d(-20);
        }
        c(new bm(a("/image", 2, false), 1));
        e(-20);
    }

    private static long g()
    {
        long l2 = -1L;
        long l1 = l2;
        Object localObject;
        if (b())
            localObject = Environment.getExternalStorageDirectory();
        try
        {
            localObject = new StatFs(((File)localObject).getPath());
            l1 = ((StatFs)localObject).getBlockSize();
            int i = ((StatFs)localObject).getAvailableBlocks();
            l1 = i * l1;
            return l1;
        }
        catch (Exception localException)
        {
            do
                l1 = l2;
            while (!Log.D);
            Log.d("FileService", "getAvailableExternalMemorySize() -->> " + localException);
            localException.printStackTrace();
        }
        return -1L;
    }

    private static long h()
    {
        if (b())
            try
            {
                StatFs localStatFs = new StatFs(Environment.getExternalStorageDirectory().getPath());
                long l = localStatFs.getBlockSize();
                l = localStatFs.getBlockCount() * l;
                if (Log.D)
                    Log.d("FileService", "getTotalExternalMemorySize() -->> " + l);
                return l;
            }
            catch (Exception localException)
            {
                if (Log.D)
                {
                    Log.d("FileService", "getTotalExternalMemorySize() -->> " + localException);
                    localException.printStackTrace();
                }
                return -1L;
            }
        return -1L;
    }
}
