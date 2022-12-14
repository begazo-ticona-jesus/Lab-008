package com.example.appv2;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class Adapter_InfoPostulantes extends RecyclerView.Adapter<Adapter_InfoPostulantes.ViewHolder> {
    private ArrayList<Postulante>data;

    public Adapter_InfoPostulantes(ArrayList<Postulante>listaPostulantes){
        data = listaPostulantes;
    }
    @NonNull
    @Override
    public Adapter_InfoPostulantes.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.lista_postulantes, null);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull Adapter_InfoPostulantes.ViewHolder holder, int position) {
        Postulante p = data.get(position);
        String apellidos = p.apPaterno.replaceFirst("ApellidoP:", "")+ p.apMaterno.replaceFirst("ApellidoM:", "");
        holder.nombre_tv.setText(p.nombres+apellidos);
        holder.dni_tv.setText(p.dni);
        holder.carrera_tv.setText(p.carrera);
    }

    @Override
    public int getItemCount() {return data.size();}

    public class ViewHolder extends RecyclerView.ViewHolder{
        TextView nombre_tv;
        TextView dni_tv;
        TextView carrera_tv;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            nombre_tv = itemView.findViewById(R.id.tv_nombres);
            dni_tv = itemView.findViewById(R.id.tv_dni);
            carrera_tv = itemView.findViewById(R.id.tv_carrera);
        }
    }
}
