package com.example.recycler;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.QuickContactBadge;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class Adaptador extends RecyclerView.Adapter<Adaptador.HolderAdapter> {

    Context contexto;
    ArrayList<Item> datos;
    View vista;

    public Adaptador(ArrayList datos, Context contexto) {
        this.contexto = contexto;
        this.datos = datos;
    }

    @Override
    public HolderAdapter onCreateViewHolder(ViewGroup parent, int viewType) {
        vista = LayoutInflater.from(contexto).inflate(R.layout.item_adaptador, parent, false);
        return new HolderAdapter(vista);
    }

    @Override
    public void onBindViewHolder(HolderAdapter holder, int position) {

        Item actual = (Item) datos.get(position);
        holder.nombre.setText(actual.getNombre());

        /*
        Manejamos el evento desde el propio adaptador
         */

        holder.nombre.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                view.setSelected(true);
                System.out.println(actual.getNombre());
            }
        });

    }

    @Override
    public int getItemCount() {
        return datos.size();
    }

    public class HolderAdapter extends RecyclerView.ViewHolder {

        TextView nombre;

        public HolderAdapter(View itemView) {
            super(itemView);

            nombre = (TextView) vista.findViewById(R.id.txt_item);

        }
    }
}
