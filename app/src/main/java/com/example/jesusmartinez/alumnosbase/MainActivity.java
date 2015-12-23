package com.example.jesusmartinez.alumnosbase;

import android.app.ListActivity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private static AlumnosDataBase dataBase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ListView listView=(ListView) findViewById(R.id.list);

        dataBase = new AlumnosDataBase(this);




        //Obtenemos los datos de la base de datos
        ArrayList<Alumnos> values = dataBase.muestraAlumnos();

        //Creamos el adapter y lo asociamos a la activity
        AlumnosAdapter adapter = new AlumnosAdapter(this,R.layout.row,values);
        listView.setAdapter(adapter);


    }
}
