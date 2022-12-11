package com.example.idnp_lab08;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class PostulanteinfActivity extends AppCompatActivity {

    private static final String TAG = "PostulanteinfActivity";
    private ArrayList<Postulante> postulantes;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_postulanteinf);

        Intent intent = getIntent();
        postulantes = intent.getParcelableArrayListExtra(MenuActivity.EXTRA_POSTULANTES);

        Log.d(TAG, "size: "+postulantes.size());

        Button btnBuscar = findViewById(R.id.btnBuscar);
        EditText edtDni = findViewById(R.id.editTextBuscar);
        TextView txtresultado = findViewById(R.id.txtResultado);

        btnBuscar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String dni = edtDni.getText().toString();
                for (Postulante postulante : postulantes) {
                    Log.d(TAG, "postulante: "+postulante.toString());
                    if(postulante.getDni().equals(dni)){
                        txtresultado.setText(postulante.toString());
                        Log.d(TAG, postulante.toString());
                    }
                    else{
                        txtresultado.setText("Postulante no encontrado");
                    }
                }
            }
        });
    }
}
