package com.example.appembalaje;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.appembalaje.adaptadores.QrHanlder;
import com.google.zxing.integration.android.IntentIntegrator;
import com.google.zxing.integration.android.IntentResult;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void ingresar(View view){
        Intent login = new Intent(this, ingresar.class);
        startActivity(login);
    }

    public void PruebasScanner(View view){
        QrHanlder scan = new QrHanlder();
        scan.ReadCode(MainActivity.this,1);
    }

    protected void onActivityResult(int RequestCode,int resultCode, Intent data) {
        IntentResult result = IntentIntegrator.parseActivityResult(RequestCode,resultCode,data);
        if(result !=null){
            if(result.getContents()==null){
                Toast.makeText(this, "Lector Cerrado antes de tiempo", Toast.LENGTH_SHORT).show();
            }else {
                Toast.makeText(this, result.getContents(), Toast.LENGTH_SHORT).show();
            }
        }else{
            super.onActivityResult(RequestCode, resultCode, data);
        }

    }
}