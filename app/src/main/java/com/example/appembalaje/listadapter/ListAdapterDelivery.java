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
import com.example.appembalaje.modelos.Delivery;

import java.util.List;

public class ListAdapterDelivery extends RecyclerView.Adapter<ListAdapterDelivery.ViewHolder> {

    private List<Delivery> datos;
    private LayoutInflater layoutInflater;
    private Context context;
    final ListAdapterDelivery.OnItemClickListener listener;

    public interface OnItemClickListener{
        void onItemClick(Delivery item);
    }

    public ListAdapterDelivery(List<Delivery> itemList, Context context, OnItemClickListener listen) {
        this.datos = itemList;
        this.layoutInflater = LayoutInflater.from(context);
        this.context = context;
        this.listener=listen;
    }

    @NonNull
    @Override
    public ListAdapterDelivery.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = layoutInflater.inflate(R.layout.card_lista_cot,null);
        return new ListAdapterDelivery.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ListAdapterDelivery.ViewHolder holder, int position) {
        holder.bindData(datos.get(position));
    }

    @Override
    public int getItemCount() {
        return datos.size();
    }

    public void setItems(List<Delivery> itemList){datos=itemList;}

    public class ViewHolder extends RecyclerView.ViewHolder{

        ImageView imgDeliveryList;
        TextView txtIdDelivery,txtEstatusDelivery;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            imgDeliveryList = itemView.findViewById(R.id.imgDeliveryList);
            txtIdDelivery = itemView.findViewById(R.id.txtIdDelivery);
            txtEstatusDelivery = itemView.findViewById(R.id.txtEstatusDelivery);
        }

        void bindData(final Delivery item){
            //imgDeliveryList.setImageBitmap(item.getImagen());
            txtEstatusDelivery.setText(item.getEstado().toString());
            txtIdDelivery.setText(String.valueOf(item.getId()));
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    listener.onItemClick(item);
                }
            });
        }
    }
}


