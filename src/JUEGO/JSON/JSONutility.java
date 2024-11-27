package JUEGO.JSON;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONTokener;

import java.io.*;

public class JSONutility {
    public static void grabar(JSONArray jsonArray, String nombreArchivo){
    try{
        FileWriter file=new FileWriter(nombreArchivo);
        file.write(jsonArray.toString());
        file.flush();
        file.close();
    } catch (IOException e) {
        throw new RuntimeException(e);
    }
}


        public static JSONTokener leer(String nombreArchivo) {
            File archivo = new File(nombreArchivo);

            // Crear el archivo si no existe
            if (!archivo.exists()) {
                System.out.println("El archivo no existe. Creando uno nuevo: " + nombreArchivo);
                try (FileWriter writer = new FileWriter(nombreArchivo)) {
                    writer.write("{}"); // Escribir un JSON vacío por defecto
                } catch (IOException e) {
                    throw new RuntimeException("Error al crear el archivo JSON: " + e.getMessage(), e);
                }
            }

            // Leer el archivo y retornar el JSONTokener
            try {
                return new JSONTokener(new FileReader(nombreArchivo));
            } catch (FileNotFoundException e) {
                throw new RuntimeException("El archivo no pudo ser encontrado después de crearlo: " + e.getMessage(), e);
            } catch (Exception ex) {
                throw new RuntimeException("Error al leer el archivo JSON: " + ex.getMessage(), ex);
            }
        }
    }


