package com.example.appembalaje;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.appembalaje.listadapter.ListAdapterCategoria;
import com.example.appembalaje.modelos.Categoria;

import java.util.ArrayList;
import java.util.List;

public class ingresar extends AppCompatActivity {

    List<Categoria> categorias;
    ProgressDialog progressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_categorias);
        init();
    }

    public void menuCrud(View view){
        Intent menu = new Intent(this,BottomMenu.class);
        startActivity(menu);
    }

    public void init(){
        categorias = new ArrayList<>();
        categorias.add(new Categoria(1,"Por defecto"));
        ListAdapterCategoria listAdapterCategoria = new ListAdapterCategoria(categorias, this, new ListAdapterCategoria.OnItemClickListener() {
            @Override
            public void onItemClick(Categoria item) {
                moveToDesc(item);
            }
        });
        RecyclerView recyclerView = findViewById(R.id.rcView);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(listAdapterCategoria);
    }

    private void moveToDesc(Categoria item){
        Intent intent = new Intent(this, activity_detalleProducto.class);
        intent.putExtra("Categoria",item);
        startActivity(intent);
    }


}

