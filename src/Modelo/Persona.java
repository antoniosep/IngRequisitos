package Modelo;

import java.util.Date;

public class Persona {
    private static String nombre;
    private static String segundoNombre;
    private static String apellido;
    private static String segundoApellido;
    private static Date fechaNacimiento;
    private static String dni;

    public Persona(String nombre, String segundoNombre, String apellido, String segundoApellido, Date fechaNacimiento, String dni) {
        this.nombre = nombre;
        this.segundoNombre = segundoNombre;
        this.apellido = apellido;
        this.segundoApellido = segundoApellido;
        this.fechaNacimiento = fechaNacimiento;
        this.dni = dni;
    }

    public Persona(String dni){
        DBaccess acceso = new DBaccess();
        Persona persona = acceso.buscarPersonas("dni", dni).get(0);
    }

    public static String getNombre() {
        return nombre;
    }

    public static void setNombre(String nombre) {
        Persona.nombre = nombre;
    }

    public static String getSegundoNombre() {
        return segundoNombre;
    }

    public static void setSegundoNombre(String segundoNombre) {
        Persona.segundoNombre = segundoNombre;
    }

    public static String getApellido() {
        return apellido;
    }

    public static void setApellido(String apellido) {
        Persona.apellido = apellido;
    }

    public static String getSegundoApellido() {
        return segundoApellido;
    }

    public static void setSegundoApellido(String segundoApellido) {
        Persona.segundoApellido = segundoApellido;
    }

    public static Date getFechanaciMiento() {
        return fechaNacimiento;
    }

    public static void setFechanaciMiento(Date fechanaciMiento) {
        Persona.fechaNacimiento = fechanaciMiento;
    }

    public static String getDni() {
        return dni;
    }

    public static void setDNI(String dni) {
        Persona.dni = dni;
    }
}
