package com.example.appembalaje.dataHelper;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.appembalaje.modelos.Producto;

import java.util.ArrayList;
import java.util.List;

public class ProductoCRUD {

    public long CrearProducto(int id, String nombre,String cantidad, String tienda, String categoria, Context context){
        DataHelper_Producto dh =new DataHelper_Producto(context,"alistapp.db",null,1);
        SQLiteDatabase bd =dh.getWritableDatabase();
        ContentValues reg=new ContentValues();
        reg.put("id",id);
        reg.put("nombre",nombre);
        reg.put("cantidad",cantidad);
        reg.put("tienda",tienda);
        reg.put("categoria",categoria);
        long resp =bd.insert("productos",null,reg);
        CerrarConexión(context);
        return resp;
    }

    public long BorrarProducto(int id,Context context){
        DataHelper_Producto dh =new DataHelper_Producto(context,"alistapp.db",null,1);
        SQLiteDatabase bd =dh.getWritableDatabase();
        long resp = bd.delete("productos","id="+id,null);
        CerrarConexión(context);
        return resp;
    }

    public long EditarProducto(int id, String nombre,String cantidad, String tienda, String categoria, Context context){
        DataHelper_Producto dh =new DataHelper_Producto(context,"alistapp.db",null,1);
        SQLiteDatabase bd = dh.getWritableDatabase();
        ContentValues reg= new ContentValues();
        reg.put("id",id);
        reg.put("nombre",nombre);
        reg.put("cantidad",cantidad);
        reg.put("tienda",tienda);
        reg.put("categoria",categoria);
        long resp =bd.update("productos",reg,"id=?", new String[]{String.valueOf(id)});
        CerrarConexión(context);
        return resp;
    }

    public Cursor TodosLosProductos(Context context) {
        DataHelper_Producto dh =new DataHelper_Producto(context,"alistapp.db",null,1);
        SQLiteDatabase bd =dh.getWritableDatabase();
        Cursor c = bd.rawQuery("SELECT id,nombre,cantidad,tienda,categoria from productos",null);
        return c;
    }

        public void CerrarConexión(Context context){
            DataHelper_Producto dh = new DataHelper_Producto(context, "alistapp.db", null, 1);
            SQLiteDatabase bd = dh.getWritableDatabase();
            bd.close();
        }

    public ArrayList<Producto> LosProductosDeCiertaCategoria(String nombreCategoria, Context context){
        ArrayList<Producto> prodList = new ArrayList<>();
        DataHelper_Producto dh = new DataHelper_Producto(context,"alistapp.db",null,1);
        SQLiteDatabase bd =dh.getWritableDatabase();
        Cursor c = bd.rawQuery("SELECT id,nombre,cantidad,tienda,categoria FROM productos WHERE categoria=?",new String[]{nombreCategoria});
        if (c.moveToFirst()) {
            do {
                String nombre = c.getString(0);
                String descPX = c.getString(1);
                int cantPX = c.getInt(2);
                String tiendaPX = c.getString(3);
                String categoriaPX = c.getString(4);
                Producto prod = new Producto(nombre, descPX, cantPX, tiendaPX, categoriaPX);
                prodList.add(prod);
            } while (c.moveToNext());
        }
        return prodList;
    }

}
