package Modelo;

import java.util.Date;

public class Clientes {
    private String id;
    private String numeroidentificacion;
    private String estado;
    private Date fechaInicio;
    private String psw;
    private Direccion direccion;

    public Clientes(String id, String numeroidentificacion, String estado, Date fechaInicio, String psw,Direccion direccion){
        this.id = id;
        this.numeroidentificacion = numeroidentificacion;
        this.estado = estado;
        this.fechaInicio = fechaInicio;
        this.psw = psw;
        this.direccion = direccion;
    }

    public Direccion getDireccion() {
        return direccion;
    }

    public void setDireccion(Direccion direccion) {
        this.direccion = direccion;
    }

    public Clientes(String id){
        DBaccess acceso = new DBaccess();
        Clientes cliente = acceso.buscarClientes("nif",id).get(0);
        this.id = cliente.getId();
        this.numeroidentificacion = cliente.getNumeroidentificacion();
        this.estado = cliente.getEstado();
        this.fechaInicio = cliente.getFechaInicio();
        this.psw = cliente.getPsw();
        this.direccion = cliente.getDireccion();
    }

    public String getId() {
        return id;
    }

    public String getNumeroidentificacion() {
        return numeroidentificacion;
    }

    public String getEstado() {
        return estado;
    }

    public Date getFechaInicio() {
        return fechaInicio;
    }

    public String getPsw() {
        return psw;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setNumeroidentificacion(String numeroidentificacion) {
        this.numeroidentificacion = numeroidentificacion;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public void setFechaInicio(Date fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public void setPsw(String psw) {
        this.psw = psw;
    }
}
