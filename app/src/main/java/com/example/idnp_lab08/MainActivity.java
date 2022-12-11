package com.example.idnp_lab08;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private static String TAG="MainActivity";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        EditText editTextUsuario = findViewById(R.id.editTextUsuario);
        EditText editTextContraseña = findViewById(R.id.editTextContraseña);
        Button btnIngresar = findViewById(R.id.btnActivityMenu);
        TextView txtMensaje = findViewById(R.id.txtMensaje);
        btnIngresar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String usuario = editTextUsuario.getText().toString();
                String contraseña = editTextContraseña.getText().toString();
                //para ver si la contraseña se esta ingresando correctamente
                Log.d(TAG, "usuario: "+usuario+" , contraseña"+contraseña);
                if(usuario.equals("test") && contraseña.equals("1234")){
                    Intent intent = new Intent(getApplicationContext(), MenuActivity.class);
                    startActivity(intent);
                } else{
                    txtMensaje.setText("usuario o contraseña incorrecto");
                }
            }
        });
    }
}