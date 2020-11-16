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

        lista.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

    }

    private void rellenar() {

        listado.add(new Item("Raul"));
        listado.add(new Item("Javier"));
        listado.add(new Item("Sergio"));
        listado.add(new Item("Pedro"));
        listado.add(new Item("Ramon"));
        listado.add(new Item("Ivan"));
    }

    @Override
    public void itemClick(int item) {

        System.out.println(item);

    }
}