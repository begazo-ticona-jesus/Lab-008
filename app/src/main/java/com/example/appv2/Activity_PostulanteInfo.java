package com.example.appv2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Activity_PostulanteInfo extends AppCompatActivity {

    private static final String FILE_NAME = "postulantes.txt";
    private RecyclerView rvPostulantes;
    private ArrayList<Postulante> dataPost = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_postulante_info);
        String dni,nombre,apellidop,apellidom,fecha,colegio,carrera;
        Helper helper = new Helper(getApplicationContext());
        String data = helper.readPostulante();
        data = data.replaceAll("(\n|\r)", "");
        String []datos = data.split("->");
        for (int i=1; i<datos.length;i=i+7){
            dni = datos[i];
            nombre = datos[i+1];
            apellidop = datos[i+2];
            apellidom = datos[i+3];
            fecha = datos[i+4];
            colegio = datos[i+5];
            carrera = datos [i+6];
            Log.d("DATOS:",datos.length+"\n"+dni+"\n"+nombre+"\n"+apellidop+"\n"+apellidom+"\n"+fecha+"\n"+colegio+"\n"+carrera+"\n");
            dataPost.add(new Postulante(dni,nombre,apellidop,apellidom,fecha,colegio,carrera));
        }

        rvPostulantes = findViewById(R.id.recyclerViewPostulantes);
        rvPostulantes.setLayoutManager(new LinearLayoutManager(this));
        Adapter_InfoPostulantes adapter = new Adapter_InfoPostulantes(dataPost);
        rvPostulantes.setAdapter(adapter);
    }
}
