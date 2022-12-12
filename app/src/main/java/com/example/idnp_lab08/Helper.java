package com.example.idnp_lab08;

import android.content.Context;
import android.widget.Toast;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

public class Helper {
    private static final String FILE_NAME = "datos.txt";

    public void write(Context context, Postulante p){
        File path = context.getFilesDir();
        try {
            FileOutputStream writer = new FileOutputStream( new File(path, "datos.txt"));
            writer.write(p.toString().getBytes());
            writer.close();
            Toast.makeText(context, "Escrito en el archivo: datos.txt", Toast.LENGTH_SHORT).show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public String read(Context context){
        File path = context.getFilesDir();
        File readFrom = new File(path, "datos.txt");
        byte[] content = new byte[(int) readFrom.length()];

        try {
            FileInputStream stream = new FileInputStream(readFrom);
            stream.read(content);
            String cont = new String(content);
            return new String(content);
        } catch (Exception e){
            e.printStackTrace();
            return e.toString();
        }
    }
}
