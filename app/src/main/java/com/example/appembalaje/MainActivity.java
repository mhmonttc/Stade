package com.example.appembalaje;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.net.Uri;
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

    public void mapsPruebas(View view){
        Uri gmmIntentUri = Uri.parse("google.navigation:q=-33.4524377,-70.5694704");
        Intent mapIntent = new Intent(Intent.ACTION_VIEW, gmmIntentUri);
        mapIntent.setPackage("com.google.android.apps.maps");
        startActivity(mapIntent);
    }

    public class ProcesoAsyncrono extends AsyncTask<Void,Void,String> {
        ProgressDialog progressDialog;

        @Override
        protected String doInBackground(Void... voids) {
            try {
                Thread.sleep(1500);
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