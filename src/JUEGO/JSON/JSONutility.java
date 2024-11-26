package JUEGO.JSON;
/*
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONTokener;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

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

    public static JSONTokener leer(String nombreArchivo){
        JSONTokener tokener = null;
        try{
            tokener = new JSONTokener(new FileReader(nombreArchivo));
        }catch (JSONException ex) {
            throw new RuntimeException(ex);
        }catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        return tokener;
    }
}
*/