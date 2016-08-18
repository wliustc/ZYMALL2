package com.zy.common.utils;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.jingdong.common.BaseApplication;
import com.zy.common.database.table.NavigationBarTable;

/**
 * Created by Robin on 2016/4/19.
 */
//public final class aw
public class DBHelperUtil {
   private static int versionCode = 25273;
    private static SQLiteOpenHelper d;
    private SQLiteDatabase a = null;
    private Context c;
    private static final String DB_NAME = "zy.db";

    public DBHelperUtil(Context paramContext)
    {
        this.c = paramContext;
    }

    //public static synchronized SQLiteDatabase a()
    public static synchronized SQLiteDatabase getDatabase()
            throws Exception
    {

            if (d == null)
                versionCode = BaseApplication.getInstance().getPackageManager().getPackageInfo(BaseApplication.getInstance().getPackageName(), 0).versionCode;
                d = new SQLiteOpenHelper(BaseApplication.getInstance(), DB_NAME, null, versionCode){
                    @Override
                    public void onCreate(SQLiteDatabase db) {
                        NavigationBarTable.create(db);
                    }

                    @Override
                    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
                        if (oldVersion < newVersion){
                            NavigationBarTable.upgrade(db);
                            onCreate(db);
                        }
                    }
                };
        SQLiteDatabase localSQLiteDatabase1 = null;
            try
            {
                localSQLiteDatabase1 = d.getWritableDatabase();
                if (Log.D)
                {
                    Log.d("Temp", "writableDatabase 1 -->> " + localSQLiteDatabase1);
                }
                return localSQLiteDatabase1;
            }
            catch (Exception e)
            {
                    e.printStackTrace();
                    BaseApplication.getInstance().deleteDatabase(DB_NAME);
                localSQLiteDatabase1 = d.getWritableDatabase();
                    if (Log.D)
                        Log.d("Temp", "writableDatabase 2 -->> " + localSQLiteDatabase1);


            }
        return  localSQLiteDatabase1;
    }

}
