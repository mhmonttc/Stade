package com.example.appembalaje;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class ingresar extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_categorias);
    }

    public void menuAccesorios(View view){
        Intent mAccesorios = new Intent(this, activity_accesorios.class);
        startActivity(mAccesorios);
    }

    public void menuCrud(View view){
        Intent menu = new Intent(this,BottomMenu.class);
        startActivity(menu);
    }


}


