package com.example.appembalaje.listadapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.appembalaje.R;
import com.example.appembalaje.modelos.Producto;

import java.util.List;

public class ListAdapterPX extends RecyclerView.Adapter<ListAdapterPX.ViewHolder> {

    private List<Producto> datos;
    private LayoutInflater layoutInflater;
    private Context context;
    ImageView imagenPX;
    TextView txtPX,txtDesc,txtStock;


    public ListAdapterPX(List<Producto> itemList, LayoutInflater layoutInflater, Context context) {
        this.datos = itemList;
        this.layoutInflater = layoutInflater;
        this.context = context;
    }

    @NonNull
    @Override
    public ListAdapterPX.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = layoutInflater.inflate(R.layout.cardview_px,null);
        return new ListAdapterPX.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ListAdapterPX.ViewHolder holder, int position) {
        holder.bindData(datos.get(position));
    }

    @Override
    public int getItemCount() {
        return datos.size();
    }

    public void setItems(List<Producto> itemList){datos=itemList;}

    public class ViewHolder extends RecyclerView.ViewHolder{

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            imagenPX = itemView.findViewById(R.id.imgPXCard);
            txtPX = itemView.findViewById(R.id.txtPXCard);
            txtDesc = itemView.findViewById(R.id.txtPXDescripcion);
            txtStock= itemView.findViewById(R.id.txtStock);
        }

        void bindData(final Producto item){
            imagenPX.setImageBitmap(item.getImagePX());
            txtPX.setText(item.getNombrePX());
            txtDesc.setText(item.getDescPX());
            txtStock.setText(item.getCantPX());
        }
    }
}


