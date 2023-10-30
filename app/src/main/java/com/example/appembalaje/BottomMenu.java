package com.example.appembalaje;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.bottomsheet.BottomSheetDialog;

public class BottomMenu extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        MostrarMenu();
    }

    protected void MostrarMenu(){
        final BottomSheetDialog bottomSheetDialog = new BottomSheetDialog(this);
        bottomSheetDialog.setContentView(R.layout.menu_inferior);

        LinearLayout crearCat = bottomSheetDialog.findViewById(R.id.creaCat);
        LinearLayout crearSubCat = bottomSheetDialog.findViewById(R.id.creaSubCat);
        LinearLayout crearProd = bottomSheetDialog.findViewById(R.id.creaProd);

        bottomSheetDialog.show();

        crearCat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(BottomMenu.this, "Opción aún no implementada", Toast.LENGTH_SHORT).show();
                /*Intent crudCat = new Intent(BottomMenu.this, activity_Categorias.class);
                startActivity(crudCat);
                bottomSheetDialog.dismiss();*/
            }
        });

        crearSubCat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(BottomMenu.this, "Opción aún no implementada", Toast.LENGTH_SHORT).show();
            }
        });

        crearProd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent crudPX = new Intent(BottomMenu.this, activity_productos.class);
                startActivity(crudPX);
                bottomSheetDialog.dismiss();
            }
        });

    }


}
