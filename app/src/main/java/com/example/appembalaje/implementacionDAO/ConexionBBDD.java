package com.example.appembalaje.implementacionDAO;

import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class ConexionBBDD extends SQLiteOpenHelper{

    public SQLiteDatabase db;

    public ConexionBBDD(@Nullable CategoriaDAO context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(""); //poner query creacion de BBDD

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }

    public void Cerrar(){
        db.close();
    }
}
