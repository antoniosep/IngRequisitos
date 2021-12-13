package Modelo;

import java.util.Date;

public class Cuentas {
    private int id;
    private int numeroCuenta;
    private String estadoCuenta;
    private Date fechaApertura;
    private Date fechaCierre;
    private String entidadEbury;

    public Cuentas(int id, int numeroCuenta, String estadoCuenta, Date fechaApertura, Date fechaCierre, String entidadEbury){
        this.id=id;
        this.numeroCuenta = numeroCuenta;
        this.estadoCuenta = estadoCuenta;
        this.fechaApertura = fechaApertura;
        this.fechaCierre = fechaCierre;
        this.entidadEbury = entidadEbury;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getNumeroCuenta() {
        return numeroCuenta;
    }

    public void setNumeroCuenta(int numeroCuenta) {
        this.numeroCuenta = numeroCuenta;
    }

    public String getEstadoCuenta() {
        return estadoCuenta;
    }

    public void setEstadoCuenta(String estadoCuenta) {
        this.estadoCuenta = estadoCuenta;
    }

    public Date getFechaApertura() {
        return fechaApertura;
    }

    public void setFechaApertura(Date fechaApertura) {
        this.fechaApertura = fechaApertura;
    }

    public Date getFechaCierre() {
        return fechaCierre;
    }

    public void setFechaCierre(Date fechaCierre) {
        this.fechaCierre = fechaCierre;
    }

    public String getEntidadEbury() {
        return entidadEbury;
    }

    public void setEntidadEbury(String entidadEbury) {
        this.entidadEbury = entidadEbury;
    }

    public String toString(){
        String res ="";
        res+=id+";"+numeroCuenta+";"+estadoCuenta+";"+fechaApertura.toString()+";"+fechaCierre.toString()+";"+entidadEbury+"\n";
        return res;
    }
}
