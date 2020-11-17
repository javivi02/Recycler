package com.example.recycler;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.QuickContactBadge;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class Adaptador extends RecyclerView.Adapter<Adaptador.HolderAdapter> {

    private Context contexto;
    private ArrayList<Item> datos;
    private View vista;
    private pasoDatos pasoDatos; //declaro la interfaz

    public Adaptador(ArrayList datos, Context contexto) {
        this.contexto = contexto;
        this.datos = datos;
        pasoDatos = (pasoDatos) contexto;
    }

    @Override
    public HolderAdapter onCreateViewHolder(ViewGroup parent, int viewType) {
        vista = LayoutInflater.from(contexto).inflate(R.layout.item_adaptador, parent, false);
        return new HolderAdapter(vista);
    }

    @Override
    public void onBindViewHolder(HolderAdapter holder, int position) {

        Item item = datos.get(position);
        holder.nombre.setText(item.getNombre());

//        holder.nombre.setOnClickListener(new View.OnClickListener() { //Manejamos del evento desde el propio adaptador
//            @Override
//            public void onClick(View view) {
//
//                view.setSelected(true);
//
//                System.out.println(item.getNombre() + " - posicion:" + position);
//                Log.v("test",item.getNombre() + " - posicion:" + position);
//            }
//        });

        //reset();



        holder.nombre.setOnClickListener(new View.OnClickListener() { //Manejo del evento a traves de interfaz de Callback
            @Override
            public void onClick(View view) {

                pasoDatos.itemClick(position, item);
            }
        });


        if(datos.get(position).isColor()) holder.nombre.setBackground(contexto.getResources().getDrawable( R.drawable.item_seleccionado));
        else holder.nombre.setBackground(contexto.getResources().getDrawable( R.drawable.item_normal));

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

    /*
    Declaramos una interfaz de callback, para poder pasar lo que pulsemos del listado a la clase main y en esta utilizarlos
     */

    interface pasoDatos{

        void itemClick(int posicion, Item item);
    }


}
