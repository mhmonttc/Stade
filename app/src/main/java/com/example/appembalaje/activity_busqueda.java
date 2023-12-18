package com.example.appembalaje;

import android.os.Bundle;
import android.widget.SearchView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.appembalaje.listadapter.ListAdapterBusqueda;
import com.example.appembalaje.modelos.Producto;
import java.util.ArrayList;
import java.util.List;

public class activity_busqueda extends AppCompatActivity {

    private RecyclerView recyclerCotizacion;
    private SearchView searchCotizacion;
    private List<Producto> prodList;
    private ListAdapterBusqueda listAdapterBusqueda;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_busqueda_cotizacion);
        listAdapterBusqueda = new ListAdapterBusqueda(prodList,this,null);
        searchCotizacion = findViewById(R.id.searchViewCot);
        recyclerCotizacion = findViewById(R.id.searchRecycler);
        searchCotizacion.clearFocus();
        searchCotizacion.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String s) {
                filtrarLista(s);
                return false;
            }

            @Override
            public boolean onQueryTextChange(String s) {
                return true;
            }
        });
        recyclerCotizacion.setHasFixedSize(true);
        recyclerCotizacion.setLayoutManager(new LinearLayoutManager(this));
        recyclerCotizacion.setAdapter(listAdapterBusqueda);
    }

    private void filtrarLista(String s) {
        List<Producto> listaFiltrada = new ArrayList<>();
        for(Producto producto: prodList){
            if(producto.getNombrePX().toLowerCase().contains(s.toLowerCase())){
                listaFiltrada.add(producto);
            }
        }

        if(listaFiltrada.isEmpty()){
            Toast.makeText(this, "No hay productos que tengan ese nombre", Toast.LENGTH_SHORT).show();
        }else{
            listAdapterBusqueda.setListaFiltrada(listaFiltrada);
        }
    }


}
