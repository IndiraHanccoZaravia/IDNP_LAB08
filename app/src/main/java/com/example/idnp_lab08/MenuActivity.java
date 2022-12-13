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

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
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

    ActivityResultLauncher<Intent> startForResult = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(),
            new ActivityResultCallback<ActivityResult>() {
                @Override
                public void onActivityResult(ActivityResult result) {
                    Helper helper= new Helper();
                    if (result.getResultCode() == Activity.RESULT_OK){
                        Intent intent = result.getData();
                        String message = intent.getStringExtra(PostulanteregistroActivity.EXTRA_MESSAGE);
                        Postulante postulante = intent.getParcelableExtra(PostulanteregistroActivity.EXTRA_NEW_POSTULANTE);
                        Log.d(TAG, message);
                        Log.d(TAG, postulante.toString());
                        //postulantes.add(postulante);

                        helper.Agregar(postulante, postulantes);
                        postulantes = helper.getPostulante();
                        helper.writeToFile(getApplicationContext(), postulantes);
                        System.out.println(postulantes);
                    }
                }
            });
}