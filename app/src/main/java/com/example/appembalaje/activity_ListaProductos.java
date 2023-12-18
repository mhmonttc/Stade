package com.example.appembalaje;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.appembalaje.dataHelper.ProductoCRUD;
import com.example.appembalaje.listadapter.ListAdapterCategoria;
import com.example.appembalaje.listadapter.ListAdapterListaProductos;
import com.example.appembalaje.modelos.Categoria;
import com.example.appembalaje.modelos.Producto;

import java.util.ArrayList;
import java.util.List;

public class activity_ListaProductos extends AppCompatActivity {

    private List<Producto> prodList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalle_producto);
        Categoria elemento = (Categoria) getIntent().getSerializableExtra("Categoria");
        init(elemento);
    }

    private void init(Categoria elemento){
        prodList = new ArrayList<>();
        ProductoCRUD prod = new ProductoCRUD();
        prodList = prod.LosProductosDeCiertaCategoria(elemento.getNombre(),this);
        //prodList.add(new Producto("Producto de prueba","hhh",4,"Tienda 1", "Por defecto"));
        ListAdapterListaProductos listAdapterListaProductos = new ListAdapterListaProductos(prodList, this, new ListAdapterListaProductos.OnItemClickListener() {
            @Override
            public void onItemClick(Producto item) {
                moveToDesc(item);
            }
        });
        RecyclerView recyclerView = findViewById(R.id.rcDetalleProd);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(listAdapterListaProductos);
    }

    private void moveToDesc(Producto item) {
        Intent intent = new Intent(this, activity_detalleProducto.class);
        intent.putExtra("Producto",item);
        startActivity(intent);
    }

    public void cambioModo(View view){
        Intent intent = new Intent(this, activity_delivery.class);
        startActivity(intent);
    }
}
