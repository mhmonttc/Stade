package com.example.appembalaje;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
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

    List<Producto> prodList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalle_producto);
        Categoria elemento = (Categoria) getIntent().getSerializableExtra("Categoria");
        Toast.makeText(this, elemento.getNombre(), Toast.LENGTH_SHORT).show();
        init();
    }

    private void init(){
        prodList = new ArrayList<>();
        Categoria elemento = (Categoria) getIntent().getSerializableExtra("Categoria");
        ProductoCRUD prod = new ProductoCRUD();
        Cursor c = prod.LosProductosDeCiertaCategoria(elemento.getNombre().toString(),this);
        for(c.moveToFirst(); !c.isAfterLast(); c.moveToNext()) {
            prodList.add(new Producto(c.getString(0),c.getString(1),c.getInt(2),c.getString(3),c.getString(4)));
        }
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

    private void moveToDesc(Producto item){
        Intent intent = new Intent(this, activity_detalleProducto.class);
        intent.putExtra("Producto",item);
        startActivity(intent);
    }
}
