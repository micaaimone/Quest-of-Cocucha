//package JUEGO.JSON;
//
//import org.json.JSONArray;
//import org.json.JSONObject;
//import org.json.JSONTokener;
//
//import java.io.FileNotFoundException;
//import java.io.FileReader;
//import java.io.FileWriter;
//import java.io.IOException;
//
//public class JSONUtilities {
//
//
//    public static void grabar(JSONObject jsonObject, String nombreArchivo){
//        try
//        {
//            FileWriter file = new FileWriter(nombreArchivo);
//            file.write(jsonObject.toString());
//            file.flush();
//            file.close();
//        } catch (IOException e) {
//            throw new RuntimeException(e);
//        }
//    }
//
//    public static void grabar(JSONArray jsonArray, String nombreArchivo)
//    {
//        try {
//            FileWriter file = new FileWriter(nombreArchivo);
//            file.write(jsonArray.toString());
//            file.flush();
//            file.close();
//        } catch (IOException e) {
//            throw new RuntimeException(e);
//        }
//    }
//
//    public static JSONTokener leer(String nombreArchivo){
//        JSONTokener tokener = null;
//        try {
//            tokener = new JSONTokener(new FileReader(nombreArchivo));
//        } catch (FileNotFoundException e) {
//            throw new RuntimeException(e);
//        }
//
//        return tokener;
//}
//
//}
