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

    public int getFechaApertura() {
        return fechaApertura;
    }

    public void setFechaApertura(int fechaApertura) {
        this.fechaApertura = fechaApertura;
    }

    public int getFechaCierre() {
        return fechaCierre;
    }

    public void setFechaCierre(int fechaCierre) {
        this.fechaCierre = fechaCierre;
    }

    public String getEntidadEbury() {
        return entidadEbury;
    }

    public void setEntidadEbury(String entidadEbury) {
        this.entidadEbury = entidadEbury;
    }
}
