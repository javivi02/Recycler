package com.example.recycler;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements Adaptador.pasoDatos {

    private TextView titulo;
    private Button reset;
    private RecyclerView lista, lista2;
    private Adaptador adaptador, adaptador2;
    private ArrayList <Item> listado = new ArrayList<>();
    private ArrayList <Item> listado2 = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lista = findViewById(R.id.rvLista);
        lista2 = findViewById(R.id.rvLista2);

        reset = findViewById(R.id.button);

        adaptador = new Adaptador(listado, this);
        adaptador2 = new Adaptador(listado2, this);

        lista.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        lista.setAdapter(adaptador);
        lista.setHasFixedSize(true); // mejora rendimiento si el contenido no cambia de tamaño
        //lista.addItemDecoration(new DividerItemDecoration(this, DividerItemDecoration.VERTICAL)); //dibujo una linea entre cada elemento

        lista2.setLayoutManager(new GridLayoutManager(this, 3));
        lista2.setAdapter(adaptador2);
        lista2.setHasFixedSize(true);

        rellenarListado();
        rellenarListado2();

        reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                reset();
                adaptador.notifyDataSetChanged();
                adaptador2.notifyDataSetChanged();

                Log.i("INFO", "pulsa BOTON");

            }
        });

    }

    private void rellenarListado() {

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

    private void rellenarListado2() {

        listado2.add(new Item("Raul", false));
        listado2.add(new Item("Javier", false));
        listado2.add(new Item("Sergio", false));
        listado2.add(new Item("Pedro", false));
        listado2.add(new Item("Ramon", false));
        listado2.add(new Item("Ivan", false));
        listado2.add(new Item("Raul", false));
        listado2.add(new Item("Javier", false));
        listado2.add(new Item("Sergio", false));
        listado2.add(new Item("Pedro", false));
        listado2.add(new Item("Ramon", false));
        listado2.add(new Item("Ivan", false));

    }

    /*
     * Implementacion de la interfez de callback. Recibiremos los parametros que le hallamos
     * definido y pasado en el adaptador
     */

    @Override
    public void itemClick(int posicion, Item item) {

        System.out.println(posicion);
        adaptador.notifyDataSetChanged();
        adaptador2.notifyDataSetChanged();

        if(item.isColor())item.setColor(false);
        else item.setColor(true);

    }

    public void reset(){

        for(Item item : listado) item.setColor(false);
        for(Item item : listado2) item.setColor(false);
    }
}