package com.example.appembalaje.Implementacion;

import android.content.Context;
import android.os.Build;
import android.util.Log;
import android.widget.Toast;

import androidx.annotation.RequiresApi;

import com.example.appembalaje.modelos.Producto;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;
import java.util.Map;

public class DataAccess_CloudFireStore {

    private boolean resultado;
    private FirebaseFirestore db;

    public void leerTodosLosRegistros(){}
    public void leerRegistroEspecifico(){}
    @RequiresApi(api = Build.VERSION_CODES.N)
    public boolean crearRegistro(Producto producto, Context context){
        Map<String,Object> productoMap = new HashMap<>();
        productoMap.put("codigo",producto.getId());
        productoMap.put("nombre",producto.getNombrePX());
        productoMap.put("descripcion",producto.getDescPX());
        productoMap.put("direccion",producto.getCantPX());
        productoMap.put("tipoMascota",producto.getCategoriaPX());
        productoMap.put("tipoMascota",producto.getCategoriaPX());

        db.collection("productos")
                .document()
                .set(productoMap)
                .addOnSuccessListener(e ->{
                    Log.e("Sucess",e.toString());
                    resultado=true;
                })
                .addOnFailureListener(e->{
                    Log.e("Error",e.getMessage());
                    resultado=false;
                });
        return resultado;
    }
    public void modificarRegistro(){}
    public boolean borrarRegistro(String id){
        db.collection("productos")
                .document(id)
                .delete()
                .addOnSuccessListener(e ->{
                    Log.e("Sucess",e.toString());
                    resultado=true;
                })
                .addOnFailureListener(e->{
                    Log.e("Error",e.getMessage());
                    resultado=false;
                });
        return resultado;
    }

}
