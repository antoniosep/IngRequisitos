package Modelo;
import java.io.FileWriter;
import java.io.IOException;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

public class JSONWrite {
    public static void main(String[] args) {
        JSONObject obj = new JSONObject();

        try {
            FileWriter file = new FileWriter("Nombre.json");
            file.write(obj.toJSONString());
            file.flush();
            file.close();
        } catch (IOException e) {
            //manejar error
            System.out.println(e.getMessage());
        }
    }
}
