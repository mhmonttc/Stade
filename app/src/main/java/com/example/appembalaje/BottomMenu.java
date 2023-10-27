package com.example.appembalaje;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

import androidx.appcompat.app.AppCompatActivity;

import com.example.appembalaje.crud.Crud_Cat;
import com.example.appembalaje.crud.Crud_PX;
import com.example.appembalaje.crud.Crud_Sub;
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
                Intent crudCat = new Intent(BottomMenu.this, Crud_Cat.class);
                startActivity(crudCat);
                bottomSheetDialog.dismiss();
            }
        });

        crearSubCat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent crudSub = new Intent(BottomMenu.this, Crud_Sub.class);
                startActivity(crudSub);
                bottomSheetDialog.dismiss();
            }
        });

        crearProd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent crudPX = new Intent(BottomMenu.this, Crud_PX.class);
                startActivity(crudPX);
                bottomSheetDialog.dismiss();
            }
        });

    }


}
