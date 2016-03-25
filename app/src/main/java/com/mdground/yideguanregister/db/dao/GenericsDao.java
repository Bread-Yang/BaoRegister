package com.mdground.yideguanregister.db.dao;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.preference.PreferenceManager;

import com.mdground.yideguanregister.db.dao.inter.IBaseDao;
import com.mdground.yideguanregister.util.PreferenceUtils;
import com.socks.library.KLog;

import net.tsz.afinal.FinalDb;
import net.tsz.afinal.FinalDb.DaoConfig;

import java.util.ArrayList;
import java.util.List;

public class GenericsDao<T> implements IBaseDao<T> {

    private final String YIDEGUAN_DATABASE_NAME = "yideguan.db";

    private static FinalDb db;

    public GenericsDao(final Context context) {
        if (db == null) {
            final DaoConfig daoConfig = new DaoConfig();
            daoConfig.setContext(context);
            daoConfig.setDbName(YIDEGUAN_DATABASE_NAME);
            daoConfig.setDebug(false);
            daoConfig.setDbVersion(1);
            daoConfig.setDbUpdateListener(new FinalDb.DbUpdateListener() {
                @Override
                public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
                    KLog.e("数据库更新了, 清除之前 的Preference和Database");

                    // 清空preference
                    PreferenceUtils.clearPreference(context, PreferenceManager.getDefaultSharedPreferences(context));

                    // 删除所有表
                    List<String> tables = new ArrayList<String>();
                    Cursor cursor = sqLiteDatabase.rawQuery("SELECT * FROM sqlite_master WHERE type='table';", null);
                    cursor.moveToFirst();
                    while (!cursor.isAfterLast()) {
                        String tableName = cursor.getString(1);
                        if (!tableName.equals("android_metadata") &&
                                !tableName.equals("sqlite_sequence"))
                            tables.add(tableName);
                        cursor.moveToNext();
                    }
                    cursor.close();

                    for (String tableName : tables) {
                        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + tableName);
                    }

//                    context.deleteDatabase(YIDEGUAN_DATABASE_NAME);

//                    context.openOrCreateDatabase(YIDEGUAN_DATABASE_NAME, Context.MODE_PRIVATE, null);
//                    db.dropDb();
//                    db = FinalDb.create(daoConfig);
                }
            });

            db = FinalDb.create(daoConfig);
        }
    }

    @Override
    public void deleteAll(Class<? extends T> clazz) {
        db.deleteAll(clazz);
    }

    @Override
    public void save(T t) {
        db.save(t);
    }

    @Override
    public T getById(int id, Class<? extends T> clazz) {
        return db.findById(id, clazz);
    }

    public FinalDb getDb() {
        return db;
    }
}
