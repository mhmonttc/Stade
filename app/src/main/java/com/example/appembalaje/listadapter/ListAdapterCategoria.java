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
import com.example.appembalaje.modelos.Categoria;

import java.util.List;

public class ListAdapterCategoria extends RecyclerView.Adapter<ListAdapterCategoria.ViewHolder> {

    private List<Categoria> datos;
    private LayoutInflater layoutInflater;
    private Context context;
    final ListAdapterCategoria.OnItemClickListener listener;

    public interface OnItemClickListener{
        void onItemClick(Categoria item);
    }

    public ListAdapterCategoria(List<Categoria> itemList, Context context, OnItemClickListener listen) {
        this.datos = itemList;
        this.layoutInflater = LayoutInflater.from(context);
        this.context = context;
        this.listener=listen;
    }

    @NonNull
    @Override
    public ListAdapterCategoria.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = layoutInflater.inflate(R.layout.cardview_cat_subcat,null);
        return new ListAdapterCategoria.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ListAdapterCategoria.ViewHolder holder, int position) {
        holder.bindData(datos.get(position));
    }

    @Override
    public int getItemCount() {
        return datos.size();
    }

    public void setItems(List<Categoria> itemList){datos=itemList;}

    public class ViewHolder extends RecyclerView.ViewHolder{

        ImageView imgCatSub;
        TextView txtCatSub;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            imgCatSub = itemView.findViewById(R.id.imgCatSub);
            txtCatSub = itemView.findViewById(R.id.txtCatSub);
        }

        void bindData(final Categoria item){
            //imgCatSub.setImageBitmap(item.getImagen());
            txtCatSub.setText(item.getNombre());
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    listener.onItemClick(item);
                }
            });
        }
    }
}


