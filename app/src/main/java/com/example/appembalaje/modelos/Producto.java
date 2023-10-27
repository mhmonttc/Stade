package com.example.appembalaje.modelos;

import android.graphics.Bitmap;

public class Producto {

    private Bitmap imagePX;
    private String nombrePX;
    private String descPX;
    private int cantPX;
    private String tiendaPX;
    private String categoriaPX;
    private String Subcategoria;

    public Producto(Bitmap imagePX, String nombrePX, String descPX, int cantPX, String tiendaPX, String categoriaPX, String subcategoria) {
        this.imagePX = imagePX;
        this.nombrePX = nombrePX;
        this.descPX = descPX;
        this.cantPX = cantPX;
        this.tiendaPX = tiendaPX;
        this.categoriaPX = categoriaPX;
        Subcategoria = subcategoria;
    }

    public Bitmap getImagePX() {
        return imagePX;
    }

    public void setImagePX(Bitmap imagePX) {
        this.imagePX = imagePX;
    }

    public String getNombrePX() {
        return nombrePX;
    }

    public void setNombrePX(String nombrePX) {
        this.nombrePX = nombrePX;
    }

    public String getDescPX() {
        return descPX;
    }

    public void setDescPX(String descPX) {
        this.descPX = descPX;
    }

    public int getCantPX() {
        return cantPX;
    }

    public void setCantPX(int cantPX) {
        this.cantPX = cantPX;
    }

    public String getTiendaPX() {
        return tiendaPX;
    }

    public void setTiendaPX(String tiendaPX) {
        this.tiendaPX = tiendaPX;
    }

    public String getCategoriaPX() {
        return categoriaPX;
    }

    public void setCategoriaPX(String categoriaPX) {
        this.categoriaPX = categoriaPX;
    }

    public String getSubcategoria() {
        return Subcategoria;
    }

    public void setSubcategoria(String subcategoria) {
        Subcategoria = subcategoria;
    }



}
