package Modelo;

public class Cuentas {
    private int id;
    private int numeroCuenta;
    private String estadoCuenta;
    private int fechaApertura;
    private int fechaCierre;
    private String entidadEbury;

    public Cuentas(int id, int numeroCuenta, String estadoCuenta, int fechaApertura, int fechaCierre, String entidadEbury){
        this.id=id;
        this.numeroCuenta = numeroCuenta;
        this.estadoCuenta = estadoCuenta;
        this.fechaApertura = fechaApertura;
        this.fechaCierre = fechaCierre;
        this.entidadEbury = entidadEbury;
    }
}
