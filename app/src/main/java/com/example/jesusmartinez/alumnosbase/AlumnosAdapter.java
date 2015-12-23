package com.example.jesusmartinez.alumnosbase;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.zip.Inflater;

/**
 * Created by jesusmartinez on 23/12/15.
 */
public class AlumnosAdapter extends ArrayAdapter<Alumnos> {

    Context mContext;
    int mResource;
    ArrayList<Alumnos> mData=null;
    ViewHolder holder;

    public AlumnosAdapter(Context context, int resource, ArrayList<Alumnos> objects) {
        super(context, resource, objects);
        this.mContext=context;
        this.mResource=resource;
        this.mData=objects;
    }

    @Override
    public Alumnos getItem(int position) {
        return super.getItem(position);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {


        if (convertView==null ) {
            LayoutInflater inflater = LayoutInflater.from(mContext);
            convertView = inflater.inflate(mResource, parent, false);

            holder=new ViewHolder();
            holder.nombre=(TextView)convertView.findViewById(R.id.nombre);
            holder.grupo=(TextView)convertView.findViewById(R.id.grupo);

            convertView.setTag(holder);
        }

        else

        {
            holder=(ViewHolder) convertView.getTag();
        }


        holder.nombre.setText(mData.get(0).getNombre());
        holder.grupo.setText(mData.get(0).getGrupo());


        return convertView;
    }



    static class ViewHolder {
        TextView nombre;
        TextView grupo;
    }
}
