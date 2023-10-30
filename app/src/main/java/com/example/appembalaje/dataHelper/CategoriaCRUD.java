package com.example.appembalaje.dataHelper;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

public class CategoriaCRUD {

    public long CrearCategoria(int id, String nombre, Context context){
        DataHelper_Producto dh =new DataHelper_Producto(context,"alistapp.db",null,2);
        SQLiteDatabase bd = dh.getWritableDatabase();
        ContentValues reg = new ContentValues();
        reg.put("id",id);
        reg.put("nombre",nombre);
        long resp =bd.insert("categoria",null,reg);
        CerrarConexión(context);
        return resp;
    }

    public long BorrarCategoria(int id,Context context){
        DataHelper_Producto dh =new DataHelper_Producto(context,"alistapp.db",null,2);
        SQLiteDatabase bd =dh.getWritableDatabase();
        long resp = bd.delete("productos","id="+id,null);
        CerrarConexión(context);
        return resp;
    }

    public long EditarCategoria(int id, String nombre, Context context){
        DataHelper_Producto dh =new DataHelper_Producto(context,"alistapp.db",null,2);
        SQLiteDatabase bd =dh.getWritableDatabase();
        ContentValues reg=new ContentValues();
        reg.put("id",id);
        reg.put("nombre",nombre);
        long resp =bd.update("categoria",reg,"id=?", new String[]{String.valueOf(id)});
        CerrarConexión(context);
        return resp;
    }

    public Cursor TodasLasCategorias(Context context){
        DataHelper_Producto dh = new DataHelper_Producto(context,"alistapp.db",null,1);
        SQLiteDatabase bd =dh.getWritableDatabase();
        Cursor c = bd.rawQuery("SELECT id,nombre from categoria",null);
        return c;
    }

    public void CerrarConexión(Context context){
        DataHelper_Producto dh =new DataHelper_Producto(context,"alistapp.db",null,1);
        SQLiteDatabase bd =dh.getWritableDatabase();
        bd.close();
    }



}
