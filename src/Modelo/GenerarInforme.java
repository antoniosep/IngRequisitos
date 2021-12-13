package Modelo;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class GenerarInforme {


    public static void main(String[] args) throws IOException {

        List<Transaccion> lista=new LinkedList<>();
        lista=informeInicial();

        System.out.println(lista.toString());


    }

    public GenerarInforme(){

    }

    public static List<Transaccion> informeInicial(){
        DBaccess bd = new DBaccess();
        List<Transaccion> res = new LinkedList<Transaccion>();
        String selectQueryBody = "SELECT * FROM transaccion WHERE fechaInstruccion >= date_sub(curdate(), interval 5 year)";

        try {
            PreparedStatement preparedStatement = bd.conn.prepareStatement(selectQueryBody);
            //preparedStatement.setString(1, filtro);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                res.add(new Transaccion(rs.getString(1), rs.getDate(2), rs.getDate(3)));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return res;
    }

    public static List<Transaccion> informeSemanal(){

        DBaccess bd = new DBaccess();
        List<Transaccion> res = new LinkedList<Transaccion>();
        String selectQueryBody = "SELECT * FROM transaccion WHERE fechaInstruccion >= date_sub(curdate(), interval 1 week)";


        try {
            PreparedStatement preparedStatement = bd.conn.prepareStatement(selectQueryBody);
            //preparedStatement.setString(1, filtro);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                res.add(new Transaccion(rs.getString(1), rs.getDate(2), rs.getDate(3)));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return res;

    }

}
