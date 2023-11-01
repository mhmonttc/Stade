package com.example.appembalaje;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ProcesoAsyncrono asyncrono = new ProcesoAsyncrono();
        asyncrono.execute();
    }

    public void ingresar(View view){
        Intent login = new Intent(this, ingresar.class);
        startActivity(login);
    }

    public class ProcesoAsyncrono extends AsyncTask<Void,Void,String> {
        ProgressDialog progressDialog;

        @Override
        protected String doInBackground(Void... voids) {
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            return "Carga Completa";
        }

        @Override
        protected void onPostExecute(String s) {
            progressDialog.dismiss();
        }

        @Override
        protected void onPreExecute() {
            progressDialog = ProgressDialog.show(MainActivity.this,
                    "Cargando..",
                    "Espera unos momentos mientras verificamos algunas cosas...");
        }
    }
}