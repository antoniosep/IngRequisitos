package Modelo;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Date;
import java.util.List;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

public class JSONWrite {

    public static void ejectuar(List<Clientes> args) {
        DBaccess miBd = new DBaccess();
        List<Clientes> clientes;
        if(args == null){
            clientes = miBd.buscarClientes();
        }else {
            clientes = args;
        }
        JSONArray clientList = new JSONArray();
        for(Clientes c : clientes){
        JSONObject obj = new JSONObject();
            obj.put("Id", c.getId());
            obj.put("Numero identificación", c.getNumeroidentificacion());
            obj.put("Estado", c.getEstado());
            obj.put("Fecha inicio", c.getFechaInicio().toString());
            obj.put("PSW", c.getPsw());
            obj.put("Direccion", c.getDireccion().toString());

            JSONObject clientObject = new JSONObject();
            clientObject.put("cliente", obj);

            clientList.add(clientObject);
        }
        JSONObject fin = new JSONObject();
        fin.put("clientes", clientList);


        try {
            FileWriter file = new FileWriter("InformeClientes.json");
            file.write(fin.toJSONString());
            file.flush();
            file.close();
        } catch (IOException e) {
            //manejar error
            e.getStackTrace();
        }
    }
}
