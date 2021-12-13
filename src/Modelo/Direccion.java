package Modelo;

public class Direccion {
    private static int cpostal;
    private static String calle;
    private static int numero;
    private static String ciudad;
    private static String pais;

    public Direccion(int cpostal){
        DBaccess acceso = new DBaccess();
        Direccion direccion = acceso.buscarDireccion("codigoPostal",cpostal).get(0);
        this.cpostal = direccion.getCpostal();
        this.calle = direccion.getCalle();
        this.numero = direccion.getNumero();
        this.ciudad = direccion.getCiudad();
        this.pais = direccion.getPais();
    }
    public Direccion(int cpostal, String calle, int numero, String ciudad, String pais) {
        this.cpostal = cpostal;
        this.calle = calle;
        this.numero = numero;
        this.ciudad = ciudad;
        this.pais = pais;
    }

    public static String getPais() {
        return pais;
    }

    public static void setPais(String pais) {
        Direccion.pais = pais;
    }

    public static int getCpostal() {
        return cpostal;
    }

    public static void setCpostal(int cpostal) {
        Direccion.cpostal = cpostal;
    }

    public static String getCalle() {
        return calle;
    }

    public static void setCalle(String calle) {
        Direccion.calle = calle;
    }

    public static int getNumero() {
        return numero;
    }

    public static void setNumero(int numero) {
        Direccion.numero = numero;
    }

    public static String getCiudad() {
        return ciudad;
    }

    public static void setCiudad(String ciudad) {
        Direccion.ciudad = ciudad;
    }
}
