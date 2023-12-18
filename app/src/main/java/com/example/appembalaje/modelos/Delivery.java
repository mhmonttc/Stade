package com.example.appembalaje.modelos;

import android.graphics.Bitmap;
import android.media.Image;

import java.util.ArrayList;

public class Delivery {

    private int id;
    private Bitmap imagen;
    private int cotizacion;
    private String estado;

    public Delivery(int id, Bitmap imagen, int cotizacion, String estado) {
        this.id = id;
        this.imagen = imagen;
        this.cotizacion = cotizacion;
        this.estado = estado;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Bitmap getImagen() {
        return imagen;
    }

    public void setImagen(Bitmap imagen) {
        this.imagen = imagen;
    }

    public int getCotizacion() {
        return cotizacion;
    }

    public void setCotizacion(int cotizacion) {
        this.cotizacion = cotizacion;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
}
