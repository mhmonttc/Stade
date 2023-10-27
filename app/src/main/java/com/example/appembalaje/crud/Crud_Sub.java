package com.example.appembalaje.crud;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.appembalaje.R;
import com.example.appembalaje.dataHelper.DataHelper_Producto;

public class Crud_Sub extends AppCompatActivity {

    EditText codSub,nomSub,asign;
    ListView lstLista;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_agregar_producto);

        codSub = (EditText) findViewById(R.id.codPX);
        nomSub = (EditText)findViewById(R.id.nomPX);
        asign = (EditText)findViewById(R.id.cantPX);

        lstLista =(ListView) findViewById(R.id.lstLista);
    }

    public void Agregar(View view){
        DataHelper_Producto dh =new DataHelper_Producto(this,"alistapp.db",null,1);
        SQLiteDatabase bd =dh.getWritableDatabase();
        ContentValues reg=new ContentValues();
        reg.put("id",codSub.getText().toString());
        reg.put("nombre",nomSub.getText().toString());
        reg.put("catOrigen",asign.getText().toString());
        long resp =bd.insert("subcategoria",null,reg);
        bd.close();
        String response = resp==-1 ? "No se puede agregar el registro":"Registro Agregado";
        Toast.makeText(Crud_Sub.this, response, Toast.LENGTH_SHORT).show();
        Limpiar();
        CargarListas();
    }

    public void Editar(View view){
        DataHelper_Producto dh =new DataHelper_Producto(this,"alistapp.db",null,1);
        SQLiteDatabase bd =dh.getWritableDatabase();
        ContentValues reg=new ContentValues();
        reg.put("id",codSub.getText().toString());
        reg.put("nombre",nomSub.getText().toString());
        reg.put("catOrigen",asign.getText().toString());
        long resp =bd.update("subc",reg,"id=?", new String[]{codSub.getText().toString()});
        bd.close();
        String response = resp==-1 ? "No se puede agregar el registro":"Registro Agregado";
        Toast.makeText(Crud_Sub.this, response, Toast.LENGTH_SHORT).show();
        Limpiar();
        CargarListas();
    }

    public void Eliminar(View view){
        DataHelper_Producto dh =new DataHelper_Producto(this,"alistapp.db",null,1);
        SQLiteDatabase bd =dh.getWritableDatabase();
        long resp = bd.delete("subc","id="+codSub,null);
        bd.close();
        String response = resp==-1 ? "Registro no encontrado":"Registro Eliminado";
        Toast.makeText(Crud_Sub.this, response, Toast.LENGTH_SHORT).show();
        Limpiar();
        CargarListas();
    }

    protected void CargarListas(){
        ActualizarListView();
    }

    protected void Limpiar(){
        codSub.setText("");
        nomSub.setText("");
        asign.setText("");
    }

    protected void ActualizarListView(){
        DataHelper_Producto dh =new DataHelper_Producto(this,"alistapp.db",null,1);
        SQLiteDatabase bd =dh.getWritableDatabase();
        Cursor c = bd.rawQuery("SELECT id,nombre,catOrigen from subc",null);
        String[] arr = new String[c.getCount()];
        if(c.moveToFirst()){
            int i = 0;
            do{
                String linea = "||"+c.getInt(0)+"||"+c.getString(1)+"||"+c.getInt(2)+"||";
                arr[i]=linea;
                i++;
            }while (c.moveToNext());
            ArrayAdapter<String> adaptador = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,arr);
            lstLista.setAdapter(adaptador);
            bd.close();
        }

    }



}
