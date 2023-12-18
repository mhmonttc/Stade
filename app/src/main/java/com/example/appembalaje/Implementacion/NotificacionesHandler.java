package com.example.appembalaje.Implementacion;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.Context;
import android.os.Build;

import androidx.annotation.RequiresApi;
import androidx.core.app.NotificationCompat;

import com.example.appembalaje.R;

import java.util.List;

public class NotificacionesHandler {
    final String CHANNEL_ID ="Uatha1";
    private List<String> textoNotificacionesAcumulado;
    private String textoLargoNotificacion;
    public void CrearCanalNotificacion(Context context){
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.O) {
            NotificationChannel channel = new NotificationChannel("1","Uatha", NotificationManager.IMPORTANCE_HIGH);
            NotificationManager notificationManager = context.getSystemService(NotificationManager.class);
            notificationManager.createNotificationChannel(channel);
        }
    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    public void MostrarNotificacion(Context context, String titulo, String contenidoNotificacion, boolean esPermanente){
        NotificationManager notificationManager = context.getSystemService(NotificationManager.class);
        NotificationCompat.Builder builder = new NotificationCompat.Builder(context,CHANNEL_ID)
                .setSmallIcon(R.mipmap.ic_launcher)
                .setContentTitle(titulo)
                .setContentText(contenidoNotificacion)
                .setOngoing(esPermanente);
        textoNotificacionesAcumulado.forEach(elem->{
            textoLargoNotificacion = textoLargoNotificacion+"\nMensaje: "+elem;
        });
        builder.setStyle(new NotificationCompat.BigTextStyle()
                .setBigContentTitle("Pruebas")
                .bigText(textoLargoNotificacion));
        notificationManager.notify(1,builder.build());
    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    public void RefreshNotificacion(Context context, String titulo, String contenidoNotificacion, boolean esPermanente, String texto){
        textoNotificacionesAcumulado.add(texto);
        MostrarNotificacion(context,titulo,contenidoNotificacion,esPermanente);
    }
}
