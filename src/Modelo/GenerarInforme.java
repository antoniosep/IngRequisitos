package Modelo;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class GenerarInforme {


    public static void main(String[] args) throws IOException {

        List<Transaccion> lista=new LinkedList<Transaccion>();
        lista=informeInicial();

        System.out.println(lista.toString());
    }

    public GenerarInforme(){

    }

    public static List<Transaccion> informeInicial(){
        DBaccess bd = new DBaccess();
        List<Transaccion> res = new LinkedList<Transaccion>();;
        List<Transaccion> aux = bd.buscarTransacciones();
        //String selectQueryBody = "SELECT * FROM transaccion WHERE fechaInstruccion >= date_sub(curdate(), interval 5 year)";
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
        LocalDateTime now = LocalDateTime.now();
        now.minusYears(5);
        /*
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
        */
        for (Transaccion t: aux) {
            if(t.getFechaInstruccion().toLocalDate().isAfter(now.minusYears(5).toLocalDate())){
                res.add(t);
            }
        }

        return res;
    }

    public static List<Transaccion> informeSemanal(){

        DBaccess bd = new DBaccess();
        List<Transaccion> res = new LinkedList<Transaccion>();
        List<Transaccion> aux = bd.buscarTransacciones();
        //String selectQueryBody = "SELECT * FROM transaccion WHERE fechaInstruccion >= date_sub(curdate(), interval 1 week)";
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
        LocalDateTime now = LocalDateTime.now();
        now.minusWeeks(1);

        for (Transaccion t: aux) {
            if(t.getFechaInstruccion().toLocalDate().isAfter(now.minusWeeks(1).toLocalDate())){
                res.add(t);
            }
        }
        /*
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
        */
        return res;
    }

    @Override
    public String toString() {
        String res = "";
        List<Transaccion> aux = informeSemanal();
        for(Transaccion t : aux){
            res += t.getId();
            res += " ";
            res += t.getFechaInstruccion().toString();
            res += " ";
            res += t.getFechaEjecucion().toString();
            res += "\n";
        }
        System.out.println(res);
        return res;
    }
}
