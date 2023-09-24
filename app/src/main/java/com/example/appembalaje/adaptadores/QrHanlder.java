package com.example.appembalaje.adaptadores;

import android.app.Activity;
import com.google.zxing.integration.android.IntentIntegrator;

public class QrHanlder {

    public String ReadCode(Activity activity,int tipoLector){
        String codigo = (tipoLector==1) ? IntentIntegrator.QR_CODE:IntentIntegrator.EAN_13;
        Boolean beep= (tipoLector==1) ? Boolean.FALSE:Boolean.TRUE;
        IntentIntegrator integrador = new IntentIntegrator(activity);
        integrador.setDesiredBarcodeFormats(codigo);
        integrador.setCameraId(0);
        integrador.setBeepEnabled(beep);
        integrador.setBarcodeImageEnabled(true);
        integrador.initiateScan();
        return null;
    }

    public String GenerateQrCode(String data){
        return null;
    }

}
