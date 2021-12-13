package Modelo;

public class Direccion {
    private int codigoPostal;
    private String calle;
    private String ciudad;
    private String pais;

    public Direccion(int codigoPostal, String calle, String ciudad, String pais) {
        this.codigoPostal = codigoPostal;
        this.calle = calle;
        this.ciudad = ciudad;
        this.pais = pais;
    }

    public int getCodigoPostal() {
        return codigoPostal;
    }

    public void setCodigoPostal(int codigoPostal) {
        this.codigoPostal = codigoPostal;
    }

    public String getCalle() {
        return calle;
    }

    public void setCalle(String calle) {
        this.calle = calle;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }
}
