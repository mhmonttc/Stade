package com.example.appembalaje.listadapter;

import android.content.Context;

import com.example.appembalaje.modelos.Producto;

import java.util.List;

public class ListAdapterBusqueda extends ListAdapterListaProductos {
    public ListAdapterBusqueda(List<Producto> itemList, Context context, OnItemClickListener listen) {
        super(itemList, context, listen);
    }

    public void setListaFiltrada(List<Producto> listaFiltrada){
        this.datos = listaFiltrada;
        notifyDataSetChanged();
    }
}
