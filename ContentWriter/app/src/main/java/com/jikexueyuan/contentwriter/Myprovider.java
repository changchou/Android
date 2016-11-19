package com.jikexueyuan.contentwriter;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;
import android.support.annotation.Nullable;

/**
 * Created by Administrator on 2015/11/10 0010.
 */
public class Myprovider extends ContentProvider {

    public static final Uri URI = Uri.parse("content://com.jikexueyuan.cp");
    SQLiteDatabase database;

    @Override
    public boolean onCreate() {
        database = getContext().openOrCreateDatabase("mycp.db3", Context.MODE_PRIVATE, null);
        database.execSQL("create table tab(_id INTEGER PRIMARY KEY AUTOINCREMENT,name TEXT NOT NULL)");
        return true;
    }

    @Nullable
    @Override
    public Cursor query(Uri uri, String[] projection, String selection, String[] selectionArgs, String sortOrder) {
        Cursor cursor = database.query("tab",null,null,null,null,null,null);
        return cursor;
    }

    @Nullable
    @Override
    public String getType(Uri uri) {
        return null;
    }

    @Nullable
    @Override
    public Uri insert(Uri uri, ContentValues values) {
        database.insert("tab","_id",values);
//        database.close();
        return null;
    }

    @Override
    public int delete(Uri uri, String selection, String[] selectionArgs) {
        return 0;
    }

    @Override
    public int update(Uri uri, ContentValues values, String selection, String[] selectionArgs) {
        return 0;
    }
}
