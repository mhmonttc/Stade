package com.example.appembalaje.Implementacion;

import android.content.Context;
import android.os.Build;
import android.util.Log;
import androidx.annotation.RequiresApi;

import org.eclipse.paho.client.mqttv3.IMqttDeliveryToken;
import org.eclipse.paho.client.mqttv3.MqttCallback;
import org.eclipse.paho.client.mqttv3.MqttClient;
import org.eclipse.paho.client.mqttv3.MqttConnectOptions;
import org.eclipse.paho.client.mqttv3.MqttException;
import org.eclipse.paho.client.mqttv3.MqttMessage;

public class MQTTHandler {

    private static String mqtthost ="tcp://mqttmhmc.cloud.shiftr.io:1883";
    private static String idUsuario ="AppAndroid";
    private static String topico = "Mensaje";
    private static String User="mqttmhmc";
    private static String Pass="0y9b5hvHgoZNSIOR";

    private MqttClient mqttClient;

    @RequiresApi(api = Build.VERSION_CODES.N)
    public void iniciarConnMqtt(Context context) {
        try {
            mqttClient = new MqttClient(mqtthost,idUsuario,null);
            MqttConnectOptions options = new MqttConnectOptions();
            options.setUserName(User);
            options.setPassword(Pass.toCharArray());
            mqttClient.connect(options);
            NotificacionesHandler not = new NotificacionesHandler();
            not.MostrarNotificacion(context,"Integración Uatha IoT","",true);
            mqttClient.setCallback(new MqttCallback() {
                @Override
                public void connectionLost(Throwable cause) {
                    not.RefreshNotificacion(context,"Integración Uatha IoT","",false,"Se ha perdido la conexión con servicios IoT");
                }
                @Override
                public void messageArrived(String topic, MqttMessage message) throws Exception {
                    String payload = new String(message.getPayload());
                    not.RefreshNotificacion(context,"Integración Uatha IoT","",false,payload);
                }
                @Override
                public void deliveryComplete(IMqttDeliveryToken token) {
                    Log.d("MQTT","Entrega Completa");
                }
            });
            mqttClient.subscribe(topico);
        } catch (MqttException e){
            e.printStackTrace();
        }
    }

    private void sendMessage(String message) {
        try{
            MqttMessage mqttMessage = new MqttMessage(message.getBytes());
            mqttClient.publish(topico,mqttMessage);
        }catch (MqttException e){
            e.printStackTrace();
        }
    }

    public void CerrarConnMqtt(){
        try{
            mqttClient.disconnect();
        }catch (MqttException e){
            e.printStackTrace();
        }
    }
}
