package com.example.jesusmartinez.alumnosbase;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteCursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;

/**
 * Created by jesusmartinez on 23/12/15.
 */
public class AlumnosDataBase extends SQLiteOpenHelper {

    private static final String DATA_BASE_NAME = "base";
    private static final int DATABASE_VERSION = 3;
    private static final String TABLE_NAME = "alumnos";


    public AlumnosDataBase(Context context) {
        super(context, DATA_BASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE " + TABLE_NAME + "( " +
                "_ID" + " INTEGER PRIMARY KEY AUTOINCREMENT," +
                "nombre" + " TEXT NOT NULL," +
                "grupo" + " TEXT NOT NULL" + ");");
        initialData(db);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        if (oldVersion < newVersion) {
            db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME + ";");
            onCreate(db);
        }
    }

    public void introAlumnos (SQLiteDatabase db,String nombre,String grupo) {
        ContentValues contentValues= new ContentValues();
        contentValues.put("nombre",nombre);
        contentValues.put("grupo",grupo);
        db.insert(TABLE_NAME,null,contentValues);

    }


    public ArrayList<Alumnos> muestraAlumnos () {
        ArrayList<Alumnos> alumnoses =new ArrayList<Alumnos>();
        SQLiteDatabase db = getReadableDatabase();
        Cursor cursor= db.query(TABLE_NAME,null,null,null,null,null,null);
        if (cursor.moveToFirst()) {
            int nombreColumn =cursor.getColumnIndex("nombre");
            int grupoColumn=cursor.getColumnIndex("grupo");

            do {
                String nombre=cursor.getString(nombreColumn);
                String grupo=cursor.getString(grupoColumn);
                Alumnos alumno=new Alumnos(nombre,grupo);
                alumnoses.add(alumno);



            } while (cursor.moveToNext());
        }

        return alumnoses;

    }

    private void initialData(SQLiteDatabase db){
        introAlumnos(db,"Juan","primero A");

    }


}
