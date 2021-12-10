package Modelo;

public class Clientes {
    private int id;
    private int numeroidentificacion;
    private String estado;
    private int fechaInicio;

    public Clientes(int id, int numeroidentificacion, String estado, int fechaInicio){
        this.id = id;
        this.numeroidentificacion = numeroidentificacion;
        this.estado = estado;
        this.fechaInicio = fechaInicio;
    }
}
