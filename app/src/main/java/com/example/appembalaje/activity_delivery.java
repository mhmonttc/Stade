package com.example.appembalaje;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.appembalaje.dataHelper.ProductoCRUD;
import com.example.appembalaje.listadapter.ListAdapterDelivery;
import com.example.appembalaje.listadapter.ListAdapterListaProductos;
import com.example.appembalaje.modelos.Categoria;
import com.example.appembalaje.modelos.Delivery;
import com.example.appembalaje.modelos.Producto;

import java.util.ArrayList;
import java.util.List;

public class activity_delivery extends AppCompatActivity {
    private List<Delivery> deliveryList;
    private List<Delivery> rutaHoy;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_delivery);
        init();
    }


    private void init(){
        deliveryList = new ArrayList<>();
        //deliveryList = prod.LosProductosDeCiertaCategoria(elemento.getNombre(),this);
        deliveryList.add(new Delivery(1,null,456456,"Pendiente Despacho"));
        ListAdapterDelivery listAdapterListaProductos = new ListAdapterDelivery(deliveryList, this, new ListAdapterDelivery.OnItemClickListener() {
            @Override
            public void onItemClick(Delivery item) {
                moveToDesc(item);
            }
        });
        RecyclerView recyclerView = findViewById(R.id.rcDetalleDelivery);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(listAdapterListaProductos);
    }

    private void moveToDesc(Delivery item) {
        if(rutaHoy.contains(item)){
            Toast.makeText(this, "El pedido ya se encuentra en la ruta", Toast.LENGTH_SHORT).show();
        }else{
            rutaHoy.add(item);
            Toast.makeText(this, "Agregado a la ruta de hoy", Toast.LENGTH_SHORT).show();
        }
    }
}
