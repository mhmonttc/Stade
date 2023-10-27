package com.example.appembalaje.modelos;

public class SubCategoria {

    private int id;
    private String nombre;
    private String catOrigen;

    public SubCategoria(int id, String nombre, String catOrigen) {
        this.id = id;
        this.nombre = nombre;
        this.catOrigen = catOrigen;
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

    public String getCatOrigen() {
        return catOrigen;
    }

    public void setCatOrigen(String catOrigen) {
        this.catOrigen = catOrigen;
    }
}
