package com.example.idnp_lab08;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class PostulanteregistroActivity extends AppCompatActivity {
    //public final static String EXTRA_MESSAGE = "EXTRA_MESSAGE";
    //public final static String EXTRA_NEW_POSTULANTE = "EXTRA_NEW_POSTULANTE";

    Helper helper = new Helper();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_postulanteregistro);

        EditText edtPaterno = findViewById(R.id.edtPaterno);
        EditText edtMaterno = findViewById(R.id.edtMaterno);
        EditText edtNombres = findViewById(R.id.edtNombres);
        EditText edtDni = findViewById(R.id.edtDNI);
        EditText edtFecha = findViewById(R.id.edtFecha);
        EditText edtColegio = findViewById(R.id.edtColegio);
        EditText edtCarrera = findViewById(R.id.edtCarrera);
        Button btnRegistrar = findViewById(R.id.btnRegistrar);



        btnRegistrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Postulante p = new Postulante();
                p.setDni(edtDni.getText().toString());
                p.setNombres(edtNombres.getText().toString());
                p.setApePaterno(edtPaterno.getText().toString());
                p.setApeMaterno(edtMaterno.getText().toString());
                p.setFecha(edtFecha.getText().toString());
                p.setColegio(edtColegio.getText().toString());
                p.setCarrera(edtCarrera.getText().toString());

                /*Intent intent = new Intent();
                intent.putExtra(EXTRA_NEW_POSTULANTE, p);
                intent.putExtra(EXTRA_MESSAGE, "correcto");
                setResult(Activity.RESULT_OK, intent);
                finish();*/

                //---------Desde aqui----------------
                /*File path = getApplicationContext().getFilesDir();
                try {
                    FileOutputStream writer = new FileOutputStream( new File(path, "datos.txt"));
                    writer.write(p.toString().getBytes());
                    writer.close();
                    Toast.makeText(getApplicationContext(), "Escrito en el archivo: datos.txt", Toast.LENGTH_SHORT).show();
                } catch (Exception e) {
                    e.printStackTrace();
                }*/

                helper.write(getApplicationContext(), p);


                Intent intent = new Intent(getApplicationContext(), MenuActivity.class);
                startActivity(intent);

            }
        });
    }
}