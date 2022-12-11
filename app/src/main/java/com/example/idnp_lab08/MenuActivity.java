package com.example.idnp_lab08;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class MenuActivity extends AppCompatActivity {
    private static final String TAG = "MenuActivity";
    public final static String EXTRA_POSTULANTES = "EXTRA_POSTULANTES";
    private ArrayList<Postulante> postulantes;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        postulantes = new ArrayList<>();
        initData();

        Button btnInfPostulante = findViewById(R.id.btnPostulante);
        Button btnNuevo = findViewById(R.id.btnNuevo);

        btnNuevo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), PostulanteregistroActivity.class);
                startForResult.launch(intent);
            }
        });
        btnInfPostulante.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), PostulanteinfActivity.class);
                intent.putParcelableArrayListExtra(EXTRA_POSTULANTES, postulantes);
                startActivity(intent);
            }
        });
    }

    private void initData(){
        Postulante postulante =new Postulante();
        postulante.setDni("200");
        postulante.setApeMaterno("Torres");
        postulante.setApePaterno("Alferes");
        postulante.setFecha("20/20/2000");
        postulante.setNombres("Paul");
        postulante.setColegio("Miguel grau");
        postulante.setCarrera("Mecanica");

        postulantes.add(postulante);
    }

    ActivityResultLauncher<Intent> startForResult = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(),
            new ActivityResultCallback<ActivityResult>() {
                @Override
                public void onActivityResult(ActivityResult result) {
                    if (result.getResultCode() == Activity.RESULT_OK){
                        Intent intent = result.getData();
                        String message = intent.getStringExtra(PostulanteregistroActivity.EXTRA_MESSAGE);
                        Postulante postulante = intent.getParcelableExtra(PostulanteregistroActivity.EXTRA_NEW_POSTULANTE);
                        Log.d(TAG, message);
                        Log.d(TAG, postulante.toString());
                        postulantes.add(postulante);
                    }
                }
            });
}