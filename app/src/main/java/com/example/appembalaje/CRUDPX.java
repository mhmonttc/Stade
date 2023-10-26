package com.example.appembalaje;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

public class CRUDPX extends AppCompatActivity {

    EditText codPX,nomPX,cantPX;
    Spinner spTienda,spCat,spSub;
    String[] tiendas =new String[]{"Bodega Tienda"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_agregar_producto);
        codPX = (EditText) findViewById(R.id.codPX);
        nomPX = (EditText)findViewById(R.id.nomPX);
        cantPX = (EditText)findViewById(R.id.cantPX);

        spTienda = (Spinner) findViewById(R.id.spTienda);
        spCat =(Spinner) findViewById(R.id.spCategoria);
        spSub =(Spinner) findViewById(R.id.spSub);
    }

    public void Agregar(View view){
        DataHelper dh =new DataHelper(this,"alistapp.db",null,1);
        SQLiteDatabase bd =dh.getWritableDatabase();
        ContentValues reg=new ContentValues();
        reg.put("id",codPX.getText().toString());
        reg.put("nombre",nomPX.getText().toString());
        reg.put("cantidad",cantPX.getText().toString());
        reg.put("tienda",spTienda.getSelectedItem().toString());
        reg.put("categoria",spCat.getSelectedItem().toString());
        reg.put("subcategoria",spSub.getSelectedItem().toString());
        long resp =bd.insert("productos",null,reg);
        bd.close();
        String response = resp==-1 ? "No se puede agregar el registro":"Registro Agregado";
        Toast.makeText(CRUDPX.this, response, Toast.LENGTH_SHORT).show();
        Limpiar();
        CargarListas();
    }

    public void Editar(View view){
        DataHelper dh =new DataHelper(this,"alistapp.db",null,1);
        SQLiteDatabase bd =dh.getWritableDatabase();
        ContentValues reg=new ContentValues();
        reg.put("id",codPX.getText().toString());
        reg.put("nombre",nomPX.getText().toString());
        reg.put("cantidad",cantPX.getText().toString());
        reg.put("tienda",spTienda.getSelectedItem().toString());
        reg.put("categoria",spCat.getSelectedItem().toString());
        reg.put("subcategoria",spSub.getSelectedItem().toString());
        long resp =bd.update("productos",reg,"id=?", new String[]{codPX.getText().toString()});
        bd.close();
        String response = resp==-1 ? "No se puede agregar el registro":"Registro Agregado";
        Toast.makeText(CRUDPX.this, response, Toast.LENGTH_SHORT).show();
        Limpiar();
        CargarListas();
    }

    public void Eliminar(View view){
        DataHelper dh =new DataHelper(this,"alistapp.db",null,1);
        SQLiteDatabase bd =dh.getWritableDatabase();
        long resp = bd.delete("productos","id="+codPX,null);
        bd.close();
        String response = resp==-1 ? "Registro no encontrado":"Registro Eliminado";
        Toast.makeText(CRUDPX.this, response, Toast.LENGTH_SHORT).show();
        Limpiar();
        CargarListas();
    }

    protected void CargarListas(){
        ArrayAdapter<String> spAdp = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item,tiendas);
        spAdp.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spTienda.setAdapter(spAdp);
    }

    protected void Limpiar(){
        codPX.setText("");
        nomPX.setText("");
        cantPX.setText("");
        spTienda.setSelected(false);
        spCat.setSelected(false);
        spCat.setSelected(false);
    }



}
