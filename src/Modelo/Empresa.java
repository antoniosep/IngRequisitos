package Modelo;

import java.util.Date;

public class Empresa {
    private static String nombre;
    private static String nif;
    private static Date fechaCierre;

    public Empresa(String nombre, String nif, Date fechaCierre) {
        this.nombre=nombre;
        this.nif=nif;
        this.fechaCierre=fechaCierre;
    }

    public Empresa(String nif){
        DBaccess acceso = new DBaccess();
        Empresa empresa = acceso.buscarEmpresas("nif",nif).get(0);
    }

    public static void setNombre(String nombre) {
        Empresa.nombre = nombre;
    }

    public static void setNif(String nif) {
        Empresa.nif = nif;
    }

    public static void setFechaCierre(Date fechaCierre) {
        Empresa.fechaCierre = fechaCierre;
    }

    public static String getNombre() {
        return nombre;
    }

    public static String getNif() {
        return nif;
    }

    public static Date getFechaCierre() {
        return fechaCierre;
    }
}
