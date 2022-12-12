package com.example.idnp_lab08;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

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
    //private ArrayList<Postulante> postulantes;

    //private static final String FILE_NAME = "datos.txt";

    Helper helper = new Helper();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_postulanteinf);

        //Intent intent = getIntent();
        //postulantes = intent.getParcelableArrayListExtra(MenuActivity.EXTRA_POSTULANTES);

        //Log.d(TAG, "size: "+postulantes.size());

        Button btnBuscar = findViewById(R.id.btnBuscar);
        EditText edtDni = findViewById(R.id.editTextBuscar);
        TextView txtresultado = findViewById(R.id.txtResultado);

        btnBuscar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                /*String dni = edtDni.getText().toString();
                for (Postulante postulante : postulantes) {
                    Log.d(TAG, "postulante: "+postulante.toString());
                    if(postulante.getDni().equals(dni)){
                        txtresultado.setText(postulante.toString());
                        Log.d(TAG, postulante.toString());
                    }
                    else{
                        txtresultado.setText("Postulante no encontrado");
                    }
                }*/

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


                String content = helper.read(getApplicationContext());
                txtresultado.setText(content);



                /*StringBuilder sb = new StringBuilder();
                String datos = "";
                try {
                    FileInputStream fis = getApplicationContext().openFileInput(FILE_NAME);
                    InputStreamReader inputStreamReader =new InputStreamReader(fis, StandardCharsets.UTF_8);
                    BufferedReader br = new BufferedReader(inputStreamReader);
                    String line = br.readLine();
                    while(line != null){
                        sb.append(line);
                        line = br.readLine();
                    }
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                } finally {
                    datos = sb.toString();
                    txtresultado.setText(datos);
                }*/
            }
        });
    }
}
