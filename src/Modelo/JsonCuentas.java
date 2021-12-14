package Modelo;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class JsonCuentas {
    public static void ejecutar(List<Cuentas> args) {
        DBaccess miBd = new DBaccess();
        JSONArray productList = new JSONArray();
        List<Cuentas> cuentas;
        if(args == null){
            cuentas = miBd.buscarCuentas();
        }else{
            cuentas = args;
        }
        for(Cuentas c: cuentas){
            JSONObject obj = new JSONObject();
            obj.put("Id", c.getId());
            obj.put("Numero cuenta", c.getNumeroCuenta());
            obj.put("Estado", c.getEstadoCuenta());
            obj.put("Fecha apertura", c.getFechaApertura().toString());
            obj.put("Fecha de cierre", c.getFechaCierre().toString());
            obj.put("Entidad Ebury", c.getEntidadEbury());

            JSONObject productObject = new JSONObject();
            productObject.put("cuenta", obj);

            productList.add(productObject);
        }
        JSONObject fin = new JSONObject();
        fin.put("cuentas",productList);


        try {
            FileWriter file = new FileWriter("InformeCuentas.json");
            file.write(fin.toJSONString());
            file.flush();
            file.close();
        } catch (IOException e) {
            //manejar error
            e.getStackTrace();
        }
    }
}
