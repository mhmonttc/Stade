package com.example.appembalaje.Implementacion;

import static androidx.core.content.ContextCompat.startActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Build;

import androidx.annotation.RequiresApi;

import com.example.appembalaje.modelos.Producto;
import java.util.List;

public class GMapsHandler {

    public Intent generarRutaInvividual(String coordenadaLat,String coordenadaLong){
        Uri gmmIntentUri = Uri.parse("google.navigation:q=-33.4524377,-70.5694704");
        Intent mapIntent = new Intent(Intent.ACTION_VIEW, gmmIntentUri);
        mapIntent.setPackage("com.google.android.apps.maps");
        return mapIntent;
    }



    @RequiresApi(api = Build.VERSION_CODES.N)
    public void generarRutaGeneral(List<Producto> datos){
        datos.forEach(item->{

        });
    }
}
