package com.example.idnp_lab08;

import android.content.Context;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
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

    public String readToFile(Context context) {
        StringBuilder stringBuilder = new StringBuilder();
        try {
            FileInputStream fis = context.openFileInput(FILE_NAME);
            InputStreamReader inputStreamReader = new InputStreamReader(fis, StandardCharsets.UTF_8);
            BufferedReader reader = new BufferedReader(inputStreamReader);
            String line = reader.readLine();
            while (line != null) {
                stringBuilder.append(line).append('\n');
                line = reader.readLine();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            return stringBuilder.toString();
        }
    }


}
