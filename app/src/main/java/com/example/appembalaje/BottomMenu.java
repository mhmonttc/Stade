package com.example.appembalaje;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.bottomsheet.BottomSheetDialog;

public class BottomMenu extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ingresar);
    }

    public void verMenu(View view){
        Button btnMenu = findViewById(R.id.btnMenuInf);
        btnMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MostrarMenu();
            }
        });


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

            }
        });

        crearSubCat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

        crearProd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

    }


}
