package Modelo;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

public class JSONWrite {

    public static void main(String[] args) {
        DBaccess miBd = new DBaccess();
        List<Clientes> clientes = miBd.buscarClientes();
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

        JSONArray productList = new JSONArray();
        List<Cuentas> cuentas = miBd.buscarCuentas();
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
        fin.put("clientes", clientList);
        fin.put("cuentas",productList);


        try {
            FileWriter file = new FileWriter("InformeHolanda.json");
            file.write(fin.toJSONString());
            file.flush();
            file.close();
        } catch (IOException e) {
            //manejar error
            System.out.println(e.getMessage());
        }
    }
}
