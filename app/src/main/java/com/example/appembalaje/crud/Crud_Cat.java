package com.example.appembalaje.crud;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.appembalaje.R;
import com.example.appembalaje.dataHelper.DataHelper_Producto;

public class Crud_Cat extends AppCompatActivity {

    EditText codCat,nomCat;
    ListView lstLista;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_agregar_producto);
        codCat = (EditText) findViewById(R.id.codPX);
        nomCat = (EditText)findViewById(R.id.nomPX);

        lstLista =(ListView) findViewById(R.id.lstLista);
    }

    public void Agregar(View view){
        DataHelper_Producto dh =new DataHelper_Producto(this,"alistapp.db",null,1);
        SQLiteDatabase bd =dh.getWritableDatabase();
        ContentValues reg=new ContentValues();
        reg.put("id",codCat.getText().toString());
        reg.put("nombre",nomCat.getText().toString());
        long resp =bd.insert("categoria",null,reg);
        bd.close();
        String response = resp==-1 ? "No se puede agregar el registro":"Registro Agregado";
        Toast.makeText(Crud_Cat.this, response, Toast.LENGTH_SHORT).show();
        Limpiar();
        ActualizarListView();
    }

    public void Editar(View view){
        DataHelper_Producto dh =new DataHelper_Producto(this,"alistapp.db",null,1);
        SQLiteDatabase bd =dh.getWritableDatabase();
        ContentValues reg=new ContentValues();
        reg.put("id",codCat.getText().toString());
        reg.put("nombre",nomCat.getText().toString());
        long resp =bd.update("categoria",reg,"id=?", new String[]{codCat.getText().toString()});
        bd.close();
        String response = resp==-1 ? "No se puede agregar el registro":"Registro Agregado";
        Toast.makeText(Crud_Cat.this, response, Toast.LENGTH_SHORT).show();
        Limpiar();
        ActualizarListView();
    }

    public void Eliminar(View view){
        DataHelper_Producto dh =new DataHelper_Producto(this,"alistapp.db",null,1);
        SQLiteDatabase bd =dh.getWritableDatabase();
        long resp = bd.delete("productos","id="+codCat,null);
        bd.close();
        String response = resp==-1 ? "Registro no encontrado":"Registro Eliminado";
        Toast.makeText(Crud_Cat.this, response, Toast.LENGTH_SHORT).show();
        Limpiar();
        ActualizarListView();
    }

    protected void Limpiar(){
        codCat.setText("");
        nomCat.setText("");
    }

    protected void ActualizarListView(){
        DataHelper_Producto dh =new DataHelper_Producto(this,"alistapp.db",null,1);
        SQLiteDatabase bd =dh.getWritableDatabase();
        Cursor c = bd.rawQuery("SELECT id,nombre from categoria",null);
        String[] arr = new String[c.getCount()];
        if(c.moveToFirst()){
            int i = 0;
            do{
                String linea = "||"+c.getInt(0)+"||"+c.getString(1)+"||"+c.getInt(2)+"||"+c.getString(3)+"||"+c.getString(4)+"||"+c.getString(5)+"||";
                arr[i]=linea;
                i++;
            }while (c.moveToNext());
            ArrayAdapter<String> adaptador = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,arr);
            lstLista.setAdapter(adaptador);
            bd.close();
        }

    }



}
