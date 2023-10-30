package com.example.appembalaje.modelos;

import android.graphics.Bitmap;

import java.io.Serializable;

public class Categoria implements Serializable {

    private int id;
    private String nombre;

    private Bitmap imagen;

    public Categoria(int id, String nombre) {
        this.id = id;
        this.nombre = nombre;
        //this.imagen=img;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /*public Bitmap getImagen() {
        return imagen;
    }

    public void setImagen(Bitmap imagen) {
        this.imagen = imagen;
    }*/

}
