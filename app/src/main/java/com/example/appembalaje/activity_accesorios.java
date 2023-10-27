package com.example.appembalaje;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.AsyncTask;
import android.os.Bundle;

public class activity_accesorios extends AppCompatActivity {

    CardView crdView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.cardview_px);

        crdView= (CardView) findViewById(R.id.crdView);
    }
}

/*public class accesoriosAsync extends AsyncTask<Void,Void,String>{

    private Context context;

    @Override
    protected String doInBackground(Void... voids) {
        DataHelper dh =new DataHelper(context,"alistapp.db",null,1);
        SQLiteDatabase bd =dh.getReadableDatabase();
        Cursor c = bd.rawQuery("SELECT id,nombre,cantidad,tienda,categoria,subcategoria from productos",null);
        String[] arr = new String[c.getCount()];
        if(c.moveToFirst()){
            int i = 0;
            do{
                String linea = "||"+c.getInt(0)+"||"+c.getString(1)+"||"+c.getInt(2)+"||"+c.getString(3)+"||"+c.getString(4)+"||"+c.getString(5)+"||";
                arr[i]=linea;
                i++;
            }while (c.moveToNext());

            bd.close();
        }
        return null;
    }
}
*/