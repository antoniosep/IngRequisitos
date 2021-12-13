package Modelo;

import java.sql.*;
import java.util.LinkedList;
import java.util.List;

public class DBaccess {

    static final String BD_SERVER = "jdbc:mysql://eburyrequisitos.cobadwnzalab.eu-central-1.rds.amazonaws.com";
    static final String BD_NAME = "grupo07DB";
    static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    static final String USER = "grupo07";
    static final String PASS = "FjLWM6DNk6TJDzfV";

    public static Connection conn;
    private static DBaccess acceso = null;

    public DBaccess() {
        try {
            // create connection for database called DBB_SCHEMA in a server installed in
            // DB_URL, with a user USER with password PASS
            //Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection(BD_SERVER + "/" + BD_NAME, USER, PASS);
        } catch (SQLException e) {
            System.err.format("SQL State: %s\n%s", e.getSQLState(), e.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static DBaccess getInstance() {
        if (acceso == null) {
            acceso = new DBaccess();
        }
        return acceso;
    }

    public static boolean HealthCheck() {
        boolean res;
        try {
            conn = DriverManager.getConnection(BD_SERVER + "/" + BD_NAME, USER, PASS);
            res=true;
        } catch (SQLException e) {
            System.err.format("SQL State: %s\n%s", e.getSQLState(), e.getMessage());
            res=false;
        } catch (Exception e) {
            e.printStackTrace();
            res=false;
        }

        return res;
    }

    public Clientes inicioSesion(String usr, String psw) {

        Clientes cliente = buscarClientes("id",usr).get(0);
        return (cliente!=null)&&(cliente.getPsw().equals(psw)) ? cliente : null;

    }

    public List<Direccion> buscarDireccion(String nombreColumna, int filtro){
        /* Aqui tenemos señoras y señores un codigo bien de chido para que
         * podamos hacer SELECT a la bbdd pero seleccionando una columna y una
         * restriccion, si queremos aplicar más de una condicion ajo y agua amigos
         * */
        List<Direccion> res = new LinkedList<Direccion>();
        String selectQueryBody = "SELECT * FROM direccion WHERE "+ nombreColumna +"=?";
        try {
            PreparedStatement preparedStatement = conn.prepareStatement(selectQueryBody);
            preparedStatement.setInt(1, filtro);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                Direccion dir = new Direccion(rs.getInt(4), rs.getString(1), rs.getInt(2), rs.getString(3), rs.getString(5));
                res.add(dir);
                System.out.println(dir.toString());
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return res;
    }

    public List<Direccion> buscarDireccion(){
        /* Aqui tenemos señoras y señores un codigo bien de chido para que
         * podamos hacer SELECT a la bbdd pero seleccionando una columna y una
         * restriccion, si queremos aplicar más de una condicion ajo y agua amigos
         * */
        List<Direccion> res = new LinkedList<Direccion>();
        String selectQueryBody = "SELECT * FROM direccion WHERE " + 0 + "=?";
        try {
            PreparedStatement preparedStatement = conn.prepareStatement(selectQueryBody);
            preparedStatement.setString(1, "0");
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                res.add(new Direccion(rs.getInt(1), rs.getString(2), rs.getInt(3), rs.getString(4), rs.getString(5)));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return res;
    }

    public List<Clientes> buscarClientes(String nombreColumna, String filtro){
        /* Aqui tenemos señoras y señores un codigo bien de chido para que
        * podamos hacer SELECT a la bbdd pero seleccionando una columna y una
        * restriccion, si queremos aplicar más de una condicion ajo y agua amigos
        * */
        List<Clientes> res = new LinkedList<Clientes>();
        String selectQueryBody = "SELECT * FROM cliente WHERE "+ nombreColumna +"=?";
        try {
            PreparedStatement preparedStatement = conn.prepareStatement(selectQueryBody);
            preparedStatement.setString(1, filtro);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                res.add(new Clientes(rs.getString(1), rs.getString(2), rs.getString(3), rs.getDate(4), rs.getString(5), new Direccion (rs.getInt(6))));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return res;
    }

    public List<Clientes> buscarClientes(){
        /* Aqui tenemos señoras y señores un codigo bien de chido para que
         * podamos hacer SELECT a la bbdd pero seleccionando una columna y una
         * restriccion, si queremos aplicar más de una condicion ajo y agua amigos
         * */
        List<Clientes> res = new LinkedList<Clientes>();
        String selectQueryBody = "SELECT * FROM cliente WHERE "+ 0 +"=?";
        try {
            PreparedStatement preparedStatement = conn.prepareStatement(selectQueryBody);
            preparedStatement.setString(1, "0");
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                res.add(new Clientes(rs.getString(1), rs.getString(2), rs.getString(3), rs.getDate(4), rs.getString(5), new Direccion (rs.getInt(6))));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return res;
    }

    public List<Persona> buscarPersonas(){
        /* Aqui tenemos señoras y señores un codigo bien de chido para que
         * podamos hacer SELECT a la bbdd pero seleccionando una columna y una
         * restriccion, si queremos aplicar más de una condicion ajo y agua amigos
         * */
        List<Persona> res = new LinkedList<Persona>();
        String selectQueryBody = "SELECT * FROM persona WHERE "+ "0" +"=?";
        try {
            PreparedStatement preparedStatement = conn.prepareStatement(selectQueryBody);
            preparedStatement.setString(1,"0");
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                res.add(new Persona(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getDate(5), rs.getString(6)));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return res;
    }

    public List<Transaccion> buscarTransacciones(){
        /* Aqui tenemos señoras y señores un codigo bien de chido para que
         * podamos hacer SELECT a la bbdd pero seleccionando una columna y una
         * restriccion, si queremos aplicar más de una condicion ajo y agua amigos
         * */
        List<Transaccion> res = new LinkedList<Transaccion>();
        String selectQueryBody = "SELECT * FROM transaccion ";
        try {
            PreparedStatement preparedStatement = conn.prepareStatement(selectQueryBody);
            //preparedStatement.setString(1,"0");
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                    res.add(new Transaccion(rs.getString(1), rs.getDate(2), rs.getDate(3)));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return res;
    }

    public List<Transaccion> buscarTransacciones(String nombreColumna, String filtro){
        /* Aqui tenemos señoras y señores un codigo bien de chido para que
         * podamos hacer SELECT a la bbdd pero seleccionando una columna y una
         * restriccion, si queremos aplicar más de una condicion ajo y agua amigos
         * */
        List<Transaccion> res = new LinkedList<Transaccion>();
        String selectQueryBody = "SELECT * FROM transaccion WHERE "+ nombreColumna +"=?";
        try {
            PreparedStatement preparedStatement = conn.prepareStatement(selectQueryBody);
            //preparedStatement.setString(1,filtro);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                res.add(new Transaccion(rs.getString(1), rs.getDate(2), rs.getDate(3)));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return res;
    }

    public List<Persona> buscarPersonas(String nombreColumna, String filtro){
        /* Aqui tenemos señoras y señores un codigo bien de chido para que
         * podamos hacer SELECT a la bbdd pero seleccionando una columna y una
         * restriccion, si queremos aplicar más de una condicion ajo y agua amigos
         * */
        List<Persona> res = new LinkedList<Persona>();
        String selectQueryBody = "SELECT * FROM persona";
        try {
            PreparedStatement preparedStatement = conn.prepareStatement(selectQueryBody);
            //preparedStatement.setString(1, filtro);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                res.add(new Persona(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getDate(5), rs.getString(6)));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return res;
    }

    public List<Empresa> buscarEmpresas(String nombreColumna, String filtro){
        /* Aqui tenemos señoras y señores un codigo bien de chido para que
         * podamos hacer SELECT a la bbdd pero seleccionando una columna y una
         * restriccion, si queremos aplicar más de una condicion ajo y agua amigos
         * */
        List<Empresa> res = new LinkedList<Empresa>();
        String selectQueryBody = "SELECT * FROM empresa WHERE "+ nombreColumna +"=?";
        try {
            PreparedStatement preparedStatement = conn.prepareStatement(selectQueryBody);
            preparedStatement.setString(1, filtro);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                res.add(new Empresa(rs.getString(1), rs.getString(2), rs.getDate(3)));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return res;
    }

    public List<Cuentas> buscarCuentas(){
        /* Aqui tenemos señoras y señores un codigo bien de chido para que
         * podamos hacer SELECT a la bbdd pero seleccionando una columna y una
         * restriccion, si queremos aplicar más de una condicion ajo y agua amigos
         * */
        List<Cuentas> res = new LinkedList<Cuentas>();
        String selectQueryBody = "SELECT * FROM cuentaEbury";
        try {
            PreparedStatement preparedStatement = conn.prepareStatement(selectQueryBody);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                res.add(new Cuentas(rs.getInt(1), rs.getInt(2), rs.getString(3), rs.getDate(4), rs.getDate(5),rs.getString(6)));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return res;
    }
    public List<Cuentas> buscarCuentas(String nombreColumna, String filtro){
        /* Aqui tenemos señoras y señores un codigo bien de chido para que
         * podamos hacer SELECT a la bbdd pero seleccionando una columna y una
         * restriccion, si queremos aplicar más de una condicion ajo y agua amigos
         * */
        List<Cuentas> res = new LinkedList<Cuentas>();
        String selectQueryBody = "SELECT * FROM cuenta WHERE "+ nombreColumna +"=?";
        try {
            PreparedStatement preparedStatement = conn.prepareStatement(selectQueryBody);
            preparedStatement.setString(1, filtro);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                res.add(new Cuentas(rs.getInt(1), rs.getInt(2), rs.getString(3), rs.getDate(4), rs.getDate(5),rs.getString(6)));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return res;
    }
    public List<Direccion> buscarDireccion(String nombreColumna, String filtro){
        /* Aqui tenemos señoras y señores un codigo bien de chido para que
         * podamos hacer SELECT a la bbdd pero seleccionando una columna y una
         * restriccion, si queremos aplicar más de una condicion ajo y agua amigos
         * */
        List<Direccion> res = new LinkedList<Direccion>();
        String selectQueryBody = "SELECT * FROM direccion";
        try {
            PreparedStatement preparedStatement = conn.prepareStatement(selectQueryBody);
            //preparedStatement.setString(1, filtro);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                res.add(new Direccion(rs.getInt(1), rs.getString(2), rs.getInt(3),rs.getString(4), rs.getString(5)));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return res;
    }

}
