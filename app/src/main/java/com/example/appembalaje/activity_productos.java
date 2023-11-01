package com.example.appembalaje;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.appembalaje.dataHelper.DataHelper_Producto;
import com.example.appembalaje.dataHelper.ProductoCRUD;
import com.example.appembalaje.modelos.Producto;

import java.util.ArrayList;

public class activity_productos extends AppCompatActivity {

    EditText codPX, nomPX, cantPX;
    Spinner spTienda, spCat, spSub;
    String[] tiendas = new String[]{"Tienda 1"};

    String[] categorias = new String[]{"Por defecto"};
    ListView lstLista;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_agregar_producto);
        codPX = (EditText) findViewById(R.id.codPX);
        nomPX = (EditText) findViewById(R.id.nomPX);
        cantPX = (EditText) findViewById(R.id.cantPX);

        spTienda = (Spinner) findViewById(R.id.spTienda);
        spCat = (Spinner) findViewById(R.id.spCategoria);
        lstLista = (ListView) findViewById(R.id.lstLista);

        CargarListas();
    }

    public void Agregar(View view) {
        ProductoCRUD agregar = new ProductoCRUD();
        long resp = agregar.CrearProducto(Integer.parseInt(codPX.getText().toString()), nomPX.getText().toString(), cantPX.getText().toString(), spTienda.getSelectedItem().toString(), spCat.getSelectedItem().toString(), this);
        String response = resp == -1 ? "No se puede agregar el registro" : "Registro Agregado";
        Toast.makeText(activity_productos.this, response, Toast.LENGTH_SHORT).show();
        Limpiar();
        CargarListas();
    }

    public void Editar(View view) {
        ProductoCRUD editar = new ProductoCRUD();
        long resp = editar.EditarProducto(Integer.parseInt(codPX.getText().toString()), nomPX.getText().toString(), cantPX.getText().toString(), spTienda.getSelectedItem().toString(), spCat.getSelectedItem().toString(), this);
        String response = resp == -1 ? "No se puede agregar el registro" : "Registro Agregado";
        Toast.makeText(activity_productos.this, response, Toast.LENGTH_SHORT).show();
        Limpiar();
        CargarListas();
    }

    public void Eliminar(View view) {
        ProductoCRUD eliminar = new ProductoCRUD();
        long resp = eliminar.BorrarProducto(Integer.parseInt(codPX.getText().toString()), this);
        String response = resp == -1 ? "Registro no encontrado" : "Registro Eliminado";
        Toast.makeText(activity_productos.this, response, Toast.LENGTH_SHORT).show();
        Limpiar();
        CargarListas();
    }

    protected void CargarListas() {
        ActualizarListView();

        ArrayAdapter<String> spAdp = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, tiendas);
        spAdp.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spTienda.setAdapter(spAdp);

        ArrayAdapter<String> spAdp2 = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, categorias);
        spAdp.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spCat.setAdapter(spAdp2);
    }

    protected void Limpiar() {
        codPX.setText("");
        nomPX.setText("");
        cantPX.setText("");
        spTienda.setSelected(false);
        spCat.setSelected(false);
        spCat.setSelected(false);
    }

    protected void ActualizarListView() {
        ProductoCRUD leer = new ProductoCRUD();
        Cursor c = leer.TodosLosProductos(this);
        String[] arr = new String[c.getCount()];
        if (c.moveToFirst()) {
            int i = 0;
            do {
                String linea = "||" + c.getInt(0) + "||" + c.getString(1) + "||" + c.getInt(2) + "||" + c.getString(3) + "||" + c.getString(4) + "||";
                arr[i] = linea;
                i++;
            } while (c.moveToNext());
            ArrayAdapter<String> adaptador = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, arr);
            lstLista.setAdapter(adaptador);
            leer.CerrarConexión(this);
        }
    }
}


