package com.example.idnp_lab08;

import android.content.Context;
import android.util.Log;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;

public class Helper {
    private static final String FILE_NAME = "datos.txt";
    private ArrayList<Postulante> Datos = new ArrayList<>();

    public void Agregar(Postulante postulante, ArrayList<Postulante> postulantes){
        this.Datos = postulantes;
        this.Datos.add(postulante);
    }

    public ArrayList<Postulante> getPostulante(){

        return Datos;

    }

    public void writeToFile(Context context, ArrayList<Postulante> Datos){
        try (FileOutputStream fos = context.openFileOutput(FILE_NAME, Context.MODE_PRIVATE)) {
            for(Postulante p : Datos)
                fos.write(p.toString().getBytes());
            //fos.flush();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public ArrayList<Postulante> readToFile(Context context) {
        final String SEPARADOR_CAMPO = ",";
        ArrayList<Postulante> post = new ArrayList<>();

        try {
            FileInputStream fis = context.openFileInput(FILE_NAME);
            InputStreamReader inputStreamReader = new InputStreamReader(fis, StandardCharsets.UTF_8);
            BufferedReader reader = new BufferedReader(inputStreamReader);
            String line;
            while ((line = reader.readLine()) != null) {
                String[] PostArray = line.split(SEPARADOR_CAMPO);
                String a = PostArray[1];
                Log.d("Helper", a);
                post.add(new Postulante(PostArray[0],PostArray[1],PostArray[2],PostArray[3],PostArray[4],PostArray[5],PostArray[6]));
            }
            fis.close();

        } catch (IOException e) {
            e.printStackTrace();
        }

        return post;
    }





}
