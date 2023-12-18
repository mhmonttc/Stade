package com.example.appembalaje;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.appembalaje.modelos.Categoria;

public class activity_detalleProducto extends AppCompatActivity {

    CardView crdView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalle_producto);
        Categoria elemento = (Categoria) getIntent().getSerializableExtra("Categoria");
        Toast.makeText(this, elemento.getNombre(), Toast.LENGTH_SHORT).show();

    }


}
