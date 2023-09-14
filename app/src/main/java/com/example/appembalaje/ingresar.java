package com.example.appembalaje;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class ingresar extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ingresar);
    }

    public void menuAccesorios(View view){
        Intent mAccesorios = new Intent(this, activity_accesorios.class);
        startActivity(mAccesorios);
    }

    public void menuCajas(View view){
        Intent mCajas = new Intent(this, activity_cajas.class);
        startActivity(mCajas);
    }
}