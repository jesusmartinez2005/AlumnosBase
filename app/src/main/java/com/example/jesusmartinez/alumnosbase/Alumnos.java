package com.example.jesusmartinez.alumnosbase;

/**
 * Created by jesusmartinez on 23/12/15.
 */
public class Alumnos {

    public String nombre;
    public String grupo;

    public Alumnos(String nombre, String grupo) {
        this.nombre = nombre;
        this.grupo = grupo;
    }

    public String getNombre() {
        return nombre;
    }

    public String getGrupo() {
        return grupo;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setGrupo(String grupo) {
        this.grupo = grupo;
    }
}
