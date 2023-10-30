package com.example.appembalaje;

import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.appembalaje.dataHelper.CategoriaCRUD;

public class activity_Categorias extends AppCompatActivity {

    EditText codCat,nomCat;
    ListView lstLista;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_agregar_categoria);
        codCat = (EditText) findViewById(R.id.codPX);
        nomCat = (EditText)findViewById(R.id.nomPX);

        lstLista =(ListView) findViewById(R.id.lstLista);
    }

    public void AgregarCategoria(View view){
        CategoriaCRUD agregar = new CategoriaCRUD();
        long resp = agregar.CrearCategoria(Integer.parseInt(codCat.getText().toString()),nomCat.getText().toString(),this);
        String response = resp==-1 ? "No se puede agregar el registro":"Registro Agregado";
        Toast.makeText(activity_Categorias.this, response, Toast.LENGTH_SHORT).show();
        LimpiarCategoria();
        ActualizarListViewCategoria();
    }

    public void EditarCategoria(View view){
        CategoriaCRUD editar = new CategoriaCRUD();
        long resp= editar.EditarCategoria(Integer.parseInt(codCat.getText().toString()),nomCat.getText().toString(),this);
        String response = resp==-1 ? "No se puede agregar el registro":"Registro Agregado";
        Toast.makeText(activity_Categorias.this, response, Toast.LENGTH_SHORT).show();
        LimpiarCategoria();
        ActualizarListViewCategoria();
    }

    public void EliminarCategoria(View view){
        CategoriaCRUD eliminar = new CategoriaCRUD();
        long resp=eliminar.BorrarCategoria(Integer.parseInt(codCat.getText().toString()),this);
        String response = resp==-1 ? "Registro no encontrado":"Registro Eliminado";
        Toast.makeText(activity_Categorias.this, response, Toast.LENGTH_SHORT).show();
        LimpiarCategoria();
        ActualizarListViewCategoria();
    }

    protected void LimpiarCategoria(){
        codCat.setText("");
        nomCat.setText("");
    }

    protected void ActualizarListViewCategoria(){
        CategoriaCRUD leer = new CategoriaCRUD();
        Cursor c = leer.TodasLasCategorias(this);
        String[] arr = new String[c.getCount()];
        if(c.moveToFirst()){
            int i = 0;
            do{
                String linea = "||"+c.getInt(0)+"||"+c.getString(1)+"||";
                arr[i]=linea;
                i++;
            }while (c.moveToNext());
            ArrayAdapter<String> adaptador = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,arr);
            lstLista.setAdapter(adaptador);
            leer.CerrarConexión(this);
        }

    }



}
