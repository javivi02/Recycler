package com.example.recycler;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements Adaptador.pasoDatos {

    private TextView titulo;
    private Button reset;
    private RecyclerView lista;
    private Adaptador adaptador;
    private ArrayList <Item> listado = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lista = findViewById(R.id.rvLista);
        reset = findViewById(R.id.button);

        adaptador = new Adaptador(listado, this);
        lista.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        lista.setAdapter(adaptador);
        lista.setHasFixedSize(true); // mejora rendimiento si el contenido no cambia de tamaño
        //lista.addItemDecoration(new DividerItemDecoration(this, DividerItemDecoration.VERTICAL)); //dibujo una linea entre cada elemento

        rellenar();

        reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                reset();
                adaptador.notifyDataSetChanged();

                Log.i("INFO", "pulsa BOTON");

            }
        });

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

        adaptador.notifyDataSetChanged();

        if(item.isColor())item.setColor(false);
        else item.setColor(true);

    }

    public void reset(){

        for(Item item : listado) item.setColor(false);
    }
}