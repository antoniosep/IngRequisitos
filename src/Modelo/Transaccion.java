package Modelo;



import java.sql.Date;

public class Transaccion {

    private String id;
    private Date fechaInstruccion;
    private Date fechaEjecucion;


    public Transaccion(String i,Date fI,Date fE){
        this.id=i;
        this.fechaInstruccion=fI;
        this.fechaEjecucion=fE;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Date getFechaInstruccion() {
        return fechaInstruccion;
    }

    public void setFechaInstruccion(Date fechaInstruccion) {
        this.fechaInstruccion = fechaInstruccion;
    }

    public Date getFechaEjecucion() {
        return fechaEjecucion;
    }

    public void setFechaEjecucion(Date fechaEjecucion) {
        this.fechaEjecucion = fechaEjecucion;
    }
}
