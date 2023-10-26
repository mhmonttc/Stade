package com.example.appembalaje;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
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
                Toast.makeText(BottomMenu.this, "Opción no disponible", Toast.LENGTH_SHORT).show();
            }
        });

        crearSubCat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(BottomMenu.this, "Opción no disponible", Toast.LENGTH_SHORT).show();
            }
        });

        crearProd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent crud = new Intent(BottomMenu.this, CRUDPX.class);
                startActivity(crud);
                bottomSheetDialog.dismiss();
            }
        });

    }


}
