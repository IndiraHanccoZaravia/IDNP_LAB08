package com.example.idnp_lab08;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;

public class PostulanteinfActivity extends AppCompatActivity {

    private static final String TAG = "PostulanteinfActivity";
    private ArrayList<Postulante> postulantes;
    RecyclerView listaPostulantes;

    Helper helper = new Helper();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_postulanteinf);

        listaPostulantes = findViewById(R.id.listaPostulantes);
        listaPostulantes.setLayoutManager(new LinearLayoutManager(this));



        Intent intent = getIntent();
        postulantes = intent.getParcelableArrayListExtra(MenuActivity.EXTRA_POSTULANTES);


        Log.d(TAG, "size: "+postulantes.size());

        ListaPostulantesAdapter adapter = new ListaPostulantesAdapter(helper.readToFile(getApplicationContext()));
        listaPostulantes.setAdapter(adapter);





                //String content = helper.readToFile(getApplicationContext());
                //txtresultado.setText(content);


                /*File path = getApplicationContext().getFilesDir();
                File readFrom = new File(path, "datos.txt");
                byte[] content = new byte[(int) readFrom.length()];
                try {
                    FileInputStream stream = new FileInputStream(readFrom);
                    stream.read(content);
                    String cont = new String(content);
                    txtresultado.setText(cont);
                } catch (Exception e){
                    e.printStackTrace();
                }*/


    }
}
