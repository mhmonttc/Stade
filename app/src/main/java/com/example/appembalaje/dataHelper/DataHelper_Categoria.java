package com.example.appembalaje.dataHelper;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DataHelper_Categoria extends SQLiteOpenHelper  {

        public DataHelper_Categoria (@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
            super(context, name, factory, version);
        }

        @Override
        public void onCreate(SQLiteDatabase sqLiteDatabase) {
            sqLiteDatabase.execSQL("CREATE TABLE categoria (id INTEGER PRIMARY KEY, nombre TEXT)");

        }

        @Override
        public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
            sqLiteDatabase.execSQL("DROP TABLE IF EXISTS categoria");
            sqLiteDatabase.execSQL("CREATE TABLE categoria (id INTEGER PRIMARY KEY, nombre TEXT)");
        }
    }

