package com.example.appembalaje.dataHelper;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DataHelper_SubC extends SQLiteOpenHelper {

    public DataHelper_SubC (@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL("CREATE TABLE subc (id INTEGER PRIMARY KEY, nombre TEXT,catOrigen TEXT)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS subc");
        sqLiteDatabase.execSQL("CREATE TABLE subc (id INTEGER PRIMARY KEY, nombre TEXT,catOrigen TEXT)");
    }
}
