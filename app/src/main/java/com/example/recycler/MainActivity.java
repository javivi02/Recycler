package com.example.recycler;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements Adaptador.pasoDatos {

    private TextView titulo;
    private RecyclerView lista;
    private Adaptador adaptador;
    private ArrayList <Item> listado = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lista = findViewById(R.id.rvLista);

        adaptador = new Adaptador(listado, this);
        lista.setLayoutManager(new LinearLayoutManager(this));
        lista.setAdapter(adaptador);
        lista.setHasFixedSize(true); // mejora rendimiento si el contenido no cambia de tamaño
        //lista.addItemDecoration(new DividerItemDecoration(this, DividerItemDecoration.VERTICAL)); //dibujo una linea entre cada elemento

        rellenar();

    }

    private void rellenar() {

        listado.add(new Item("Raul", false));
        listado.add(new Item("Javier", false));
        listado.add(new Item("Sergio", false));
        listado.add(new Item("Pedro", false));
        listado.add(new Item("Ramon", false));
        listado.add(new Item("Ivan", false));
        listado.add(new Item("Raul", false));
        listado.add(new Item("Javier", false));
        listado.add(new Item("Sergio", false));
        listado.add(new Item("Pedro", false));
        listado.add(new Item("Ramon", false));
        listado.add(new Item("Ivan", false));

    }

    @Override
    public void itemClick(int posicion, Item item) {

        //reset();
        //System.out.println(posicion);
        item.setColor(true);
        //adaptador.notifyItemChanged(posicion);
        //System.out.println(item.isColor());

        //System.out.println(listado.size());
        //for(Item fila : listado) System.out.println(fila.isColor());


    }
}