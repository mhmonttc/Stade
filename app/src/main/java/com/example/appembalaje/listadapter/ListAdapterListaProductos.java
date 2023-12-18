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
import com.example.appembalaje.modelos.Producto;

import java.util.List;

public class ListAdapterListaProductos extends RecyclerView.Adapter<ListAdapterListaProductos.ViewHolder> {

    protected List<Producto> datos;
    private LayoutInflater layoutInflater;
    private Context context;
    final ListAdapterListaProductos.OnItemClickListener listener;

    public interface OnItemClickListener{
        void onItemClick(Producto item);
    }



    public ListAdapterListaProductos(List<Producto> itemList, Context context, OnItemClickListener listen) {
        this.datos = itemList;
        this.layoutInflater = LayoutInflater.from(context);
        this.context = context;
        this.listener=listen;
    }

    @NonNull
    @Override
    public ListAdapterListaProductos.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = layoutInflater.inflate(R.layout.cardview_lista_prod,null);
        return new ListAdapterListaProductos.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ListAdapterListaProductos.ViewHolder holder, int position) {
        holder.bindData(datos.get(position));
    }

    @Override
    public int getItemCount() {
        return datos.size();
    }

    public void setItems(List<Producto> itemList){datos=itemList;}

    public class ViewHolder extends RecyclerView.ViewHolder{

        ImageView imgListaProd;
        TextView txtListaNombre,txtListaCantidad,txtListaTienda;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            txtListaNombre = itemView.findViewById(R.id.txtListaNombreProducto);
            txtListaCantidad = itemView.findViewById(R.id.txtListaCantidadProducto);
            txtListaTienda = itemView.findViewById(R.id.txtListaTiendaDisponible);
        }

        void bindData(final Producto item){
            //imgCatSub.setImageBitmap(item.getImagen());
            txtListaNombre.setText(item.getDescPX());
            txtListaCantidad.setText(String.valueOf(item.getCantPX()));
            txtListaTienda.setText(item.getTiendaPX());
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    listener.onItemClick(item);
                }
            });
        }
    }
}


