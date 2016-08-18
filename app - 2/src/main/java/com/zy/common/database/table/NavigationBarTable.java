package com.zy.common.database.table;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.zy.common.entity.navigationbar.NavigationBar;
import com.zy.common.utils.CommonUtil;
import com.zy.common.utils.DBHelperUtil;
import com.zy.common.utils.Log;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Created by Robin on 2016/4/19.
 */
//public class i
public class NavigationBarTable {
    private static final String TB_NAVIGATION_BAR = "navigation_bar";
    private static final String TB_CLOUMN_ID = "id";
    private static final String TB_CLOUMN_OFF_URL = "off_url";
    private static final String TB_CLOUMN_ON_URL = "on_url";
    private static final String TB_CLOUMN_OFF_PATH = "off_path";
    private static final String TB_CLOUMN_ON_PATH = "on_path";
    private static final String TB_CLOUMN_FUNCTION_ID = "function_id";
    private static final String TB_CLOUMN_NAVI_LABEL = "navi_label";
    private static final String TB_CLOUMN_NAVI_ORDER = "navi_order";
    private static final String TB_CLOUMN_NAVI_TASK = "navi_task";
    private static final String TB_CLOUMN_DEFAULT_TAG = "default_tag";
    private static final String TB_CLOUMN_DISPLAY_TAG = "display_tag";
    private static final String TB_CLOUMN_ICON_TYPE = "icon_type";
    private static final String TB_CLOUMN_START_TIME = "start_time";
    private static final String TB_CLOUMN_END_TIME = "end_time";
    private static final String TB_CLOUMN_DATA_VERSION = "data_version";
    private static final String TB_CLOUMN_M_URL = "m_url";
    private static final String TB_CLOUMN_BIT_ICON_TAG = "big_icon_tag";
    public static final String TAG = NavigationBarTable.class.getSimpleName();
    public static List<NavigationBar> a(int paramInt1, int paramInt2)
    {
        SQLiteDatabase sqLiteDatabase = null;
        List<NavigationBar> list = null;
        try{
            sqLiteDatabase = DBHelperUtil.getDatabase();
            String[] column = {TB_CLOUMN_ID, TB_CLOUMN_OFF_URL, TB_CLOUMN_ON_URL, TB_CLOUMN_OFF_PATH, TB_CLOUMN_ON_PATH, TB_CLOUMN_FUNCTION_ID, TB_CLOUMN_NAVI_LABEL, TB_CLOUMN_NAVI_ORDER, TB_CLOUMN_NAVI_TASK, TB_CLOUMN_DEFAULT_TAG, TB_CLOUMN_DISPLAY_TAG, TB_CLOUMN_ICON_TYPE, TB_CLOUMN_START_TIME, TB_CLOUMN_END_TIME, TB_CLOUMN_M_URL, TB_CLOUMN_BIT_ICON_TAG, TB_CLOUMN_DATA_VERSION};
            String v3 = "display_tag=? and data_version=? and icon_type = " + paramInt2;
            if(paramInt2 ==-1)
                v3 = "display_tag=? and data_version=?";
            Cursor cursor = sqLiteDatabase.query(TB_NAVIGATION_BAR, column, v3, new String[]{String.valueOf(paramInt1), String.valueOf(CommonUtil.getLongFromPreference("dataVersion_Navigation", 0))}, null, null, null);
            if(cursor != null){ //if-nez v3, :cond_3
                list = new ArrayList<NavigationBar>();
                for(cursor.moveToFirst(); !cursor.isAfterLast();){
                    NavigationBar navigationBar = new NavigationBar();
                    navigationBar.setId(cursor.getInt(cursor.getColumnIndex(TB_CLOUMN_ID)));
                    navigationBar.setDefaultTag(cursor.getInt(cursor.getColumnIndex(TB_CLOUMN_DEFAULT_TAG)));
                    navigationBar.setDisplayTag(cursor.getInt(cursor.getColumnIndex(TB_CLOUMN_DISPLAY_TAG)));
                    navigationBar.setFunctionId(cursor.getString(cursor.getColumnIndex(TB_CLOUMN_FUNCTION_ID)));
                    navigationBar.setOffUrl(cursor.getString(cursor.getColumnIndex(TB_CLOUMN_OFF_URL)));
                    navigationBar.setOnUrl(cursor.getString(cursor.getColumnIndex(TB_CLOUMN_ON_URL)));
                    navigationBar.setOffPath(cursor.getString(cursor.getColumnIndex(TB_CLOUMN_OFF_PATH)));
                    navigationBar.setOnPath(cursor.getString(cursor.getColumnIndex(TB_CLOUMN_ON_PATH)));
                    navigationBar.setNaviLabel(cursor.getString(cursor.getColumnIndex(TB_CLOUMN_NAVI_LABEL)));
                    navigationBar.setNaviOrder(cursor.getInt(cursor.getColumnIndex(TB_CLOUMN_NAVI_ORDER)));
                    navigationBar.setNaviTask(cursor.getInt(cursor.getColumnIndex(TB_CLOUMN_NAVI_TASK)));
                    navigationBar.setmUrl(cursor.getString(cursor.getColumnIndex(TB_CLOUMN_M_URL)));
                    navigationBar.setBigIconTag(cursor.getInt(cursor.getColumnIndex(TB_CLOUMN_BIT_ICON_TAG)));
                    navigationBar.setDataVersion(cursor.getString(cursor.getColumnIndex(TB_CLOUMN_DATA_VERSION)));
                    list.add(navigationBar);
                }

            }
            if(cursor != null && cursor.isClosed())
                cursor.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    //public static void a(SQLiteDatabase paramSQLiteDatabase)
    public static void create(SQLiteDatabase paramSQLiteDatabase)
    {
        paramSQLiteDatabase.execSQL("CREATE TABLE navigation_bar(id INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL,off_url TEXT,on_url TEXT,off_path TEXT,on_path TEXT,function_id TEXT,navi_label TEXT,navi_order INTEGER,navi_task INTEGER,default_tag INTEGER,display_tag INTEGER,icon_type INTEGER,start_time TEXT,end_time TEXT,data_version TEXT,m_url TEXT ,big_icon_tag INTEGER)");
    }


    //public static void b(SQLiteDatabase paramSQLiteDatabase)
    public static void upgrade(SQLiteDatabase paramSQLiteDatabase)
    {
        paramSQLiteDatabase.execSQL("drop table if exists navigation_bar");
    }

    private static void a(SQLiteDatabase paramSQLiteDatabase, int paramInt)
    {
        paramSQLiteDatabase.execSQL("DELETE FROM navigation_bar WHERE display_tag=" + paramInt);
    }

    public static boolean a() {
        SQLiteDatabase sqLiteDatabase = null;
        try {
            sqLiteDatabase = DBHelperUtil.getDatabase();
            sqLiteDatabase.beginTransaction();
            a(sqLiteDatabase, 1);
            sqLiteDatabase.execSQL("UPDATE navigation_bar SET display_tag=1 WHERE display_tag=0");
            sqLiteDatabase.setTransactionSuccessful();
            return true;
        } catch (Exception e) {
            if (Log.D) {
                e.printStackTrace();
            }
            return false;
        } finally {
            if (sqLiteDatabase != null)
                sqLiteDatabase.endTransaction();
        }
    }

    public static boolean a(int paramInt, String paramString1, String paramString2)
    {
        if ((paramInt >= 0) && (paramString2 != null) && ("".equals(paramString2))) {
            Object localObject = null;
            try {
                SQLiteDatabase database = DBHelperUtil.getDatabase();
                ContentValues contentValues = new ContentValues();
                contentValues.put(paramString2, paramString1);
                paramInt = database.update("navigation_bar", contentValues, "id=?", new String[]{String.valueOf(paramInt)});
                if (paramInt > 0)
                    return true;
            } catch (Exception e) {
                if (Log.D)
                    e.printStackTrace();
            }
        }
        return false;
    }

    public static boolean a(List<NavigationBar> paramList) {
        SQLiteDatabase sqLiteDatabase = null;
        try {
            sqLiteDatabase = DBHelperUtil.getDatabase();

            sqLiteDatabase.beginTransaction();

            a(sqLiteDatabase, 0);

            Iterator<NavigationBar> iterator = paramList.iterator();
            while (iterator.hasNext()) {
                NavigationBar navigationBar = (NavigationBar) iterator.next();
                ContentValues contentValues = new ContentValues();
                contentValues.put("default_tag", Integer.valueOf(navigationBar.getDefaultTag()));
                contentValues.put("display_tag", Integer.valueOf(navigationBar.getDisplayTag()));
                contentValues.put("function_id", navigationBar.getFunctionId());
                contentValues.put("off_path", navigationBar.getOffPath());
                contentValues.put("on_path", navigationBar.getOnPath());
                contentValues.put("off_url", navigationBar.getOffUrl());
                contentValues.put("on_url", navigationBar.getOnUrl());
                contentValues.put("navi_label", navigationBar.getNaviLabel());
                contentValues.put("navi_order", navigationBar.getNaviOrder());
                contentValues.put("navi_task", Integer.valueOf(navigationBar.getNaviTask()));
                contentValues.put("start_time", navigationBar.getStartTime());
                contentValues.put("end_time", navigationBar.getEndTime());
                contentValues.put("m_url", navigationBar.getmUrl());
                contentValues.put("big_icon_tag", Integer.valueOf(navigationBar.getBigIconTag()));
                contentValues.put("icon_type", Integer.valueOf(navigationBar.getIconType()));
                contentValues.put("data_version", navigationBar.getDataVersion());
                if (sqLiteDatabase.insert("navigation_bar", null, contentValues) > 0L)
                    continue;
            }
            sqLiteDatabase.setTransactionSuccessful();

        } catch (Exception e) {
            if (Log.D) {
                e.printStackTrace();
            }
            return false;
        } finally {
            if (sqLiteDatabase != null)
                sqLiteDatabase.endTransaction();
        }
        return true;
    }

    public static void b()
    {
        try
        {
            SQLiteDatabase localSQLiteDatabase = DBHelperUtil.getDatabase();
            localSQLiteDatabase.execSQL("DELETE FROM navigation_bar");
        }
        catch (Exception localException)
        {
            if (Log.D)
                localException.printStackTrace();
        }
    }


    public static boolean c()
    {
        String sql1 = "select count(*) from navigation_bar where  (off_path is null or off_path =\'\') or (on_path is null or on_path=\'\') and default_tag=0 and icon_type=0";
        String sql2 = "select count(*) from navigation_bar where  (off_path is null or off_path =\'\') and default_tag=0 and icon_type=1";
        SQLiteDatabase sqLiteDatabase = null;
        Cursor v3 = null;
        Cursor v2 = null;
        try {
            sqLiteDatabase = DBHelperUtil.getDatabase();
            sqLiteDatabase.beginTransaction();
            v3 = sqLiteDatabase.rawQuery(sql1, new String[0]);
            v2 = sqLiteDatabase.rawQuery(sql2, new String[0]);
            int v5 = 0;
            if(v3.moveToFirst()){   //if-eqz v1, :cond_e
                v5 = v3.getInt(0);
            }
            //:goto_0
            int v1 = 0;
            if(v2.moveToFirst()){   //if-eqz v1, :cond_d
                v1 = v2.getInt(0);
            }
            //:goto_1
            sqLiteDatabase.setTransactionSuccessful();
            if(v5 == 0 && v1 ==0){  //if-nez v5, :cond_4
                return true;
            }
        } catch (Exception e) {
            if (Log.D) {
                e.printStackTrace();
            }
            return false;
        } finally {
            if(v3 != null && !v3.isClosed())
                v3.close();
            if(v2 != null && !v2.isClosed())
                v2.close();
            if (sqLiteDatabase != null)
                sqLiteDatabase.endTransaction();
        }
        return false;
    }

}
