package com.example.idnp_lab08;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import androidx.appcompat.app.AppCompatActivity;

public class PostulanteregistroActivity extends AppCompatActivity {
    public final static String EXTRA_MESSAGE = "EXTRA_MESSAGE";
    public final static String EXTRA_NEW_POSTULANTE = "EXTRA_NEW_POSTULANTE";

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

                Intent intent = new Intent();
                intent.putExtra(EXTRA_NEW_POSTULANTE, p);
                intent.putExtra(EXTRA_MESSAGE, "correcto");
                setResult(Activity.RESULT_OK, intent);
                finish();
            }
        });
    }
}