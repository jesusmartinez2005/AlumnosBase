package com.example.jesusmartinez.alumnosbase;

import android.app.ListActivity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private static AlumnosDataBase dataBase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final ListView listView=(ListView) findViewById(R.id.list);
        Button button=(Button) findViewById(R.id.ok);
        dataBase = new AlumnosDataBase(this);

        //probando si esto va a la branch nueva o a la vieja



        //Obtenemos los datos de la base de datos
        ArrayList<Alumnos> values = dataBase.muestraAlumnos();

        //Creamos el adapter y lo asociamos a la activity
        final AlumnosAdapter adapter = new AlumnosAdapter(this,R.layout.row,values);
        listView.setAdapter(adapter);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //dataBase=new AlumnosDataBase(getApplicationContext());

                EditText nombre = (EditText) findViewById(R.id.nombre);
                EditText grupo = (EditText) findViewById(R.id.grupo);
                dataBase.introAlumnos(dataBase.getWritableDatabase(), nombre.getText().toString(), grupo.getText().toString());
                dataBase.close();


                //Obtenemos los datos de la base de datos
                ArrayList<Alumnos> values = dataBase.muestraAlumnos();

                //Creamos el adapter y lo asociamos a la activity
                final AlumnosAdapter adapter = new AlumnosAdapter(getApplicationContext(), R.layout.row, values);
                listView.setAdapter(adapter);

            }
        });

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                ArrayList<Alumnos> values = dataBase.muestraAlumnos();
                AlumnosAdapter adapter = new AlumnosAdapter(getApplicationContext(),R.layout.row,values);
                Alumnos alumnopulsado = adapter.getItem(position);
                Toast.makeText(getApplicationContext(), "has pulsado "+alumnopulsado.getNombre()+" "+ position, Toast.LENGTH_SHORT).show();

                dataBase.getWritableDatabase();
                dataBase.deleteAlumnos(alumnopulsado.getNombre());
                dataBase.close();

                values = dataBase.muestraAlumnos();
                adapter = new AlumnosAdapter(getApplicationContext(),R.layout.row,values);
                listView.setAdapter(adapter);
                //   adapter.remove(adapter.getItem(position));
            }
        });



    }
}
