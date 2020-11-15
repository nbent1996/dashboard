package Modelo;

import Resources.DTOs.DTOFechas;
import java.util.ArrayList;

public class Suscripcion implements Comparable<Suscripcion> {
/*Estado*/
private int idSuscripcion;
private DTOFechas fechaInicio;
private float tiempoContrato;
private DTOFechas fechaFin;
private boolean activa;
private ArrayList<Paquete> listaPaquetes;
/*Estado*/

/*Constructores*/
/*FULL*/
public Suscripcion(int idSuscripcion, DTOFechas fechaInicio, float tiempoContrato, DTOFechas fechaFin, boolean activa, ArrayList<Paquete> listaPaquetes) {
        this.idSuscripcion = idSuscripcion;
        this.fechaInicio = fechaInicio;
        this.tiempoContrato = tiempoContrato;
        this.fechaFin = fechaFin;
        this.activa = activa;
        this.listaPaquetes = listaPaquetes;
    }

/*ID -1 FULL*/
public Suscripcion(DTOFechas fechaInicio, float tiempoContrato, DTOFechas fechaFin, boolean activa, ArrayList<Paquete> listaPaquetes) {
        this.idSuscripcion = -1;
        this.fechaInicio = fechaInicio;
        this.tiempoContrato = tiempoContrato;
        this.fechaFin = fechaFin;
        this.activa = activa;
        this.listaPaquetes = listaPaquetes;
    }

/*FULL SIN PAQUETES*/
public Suscripcion(int idSuscripcion, DTOFechas fechaInicio, float tiempoContrato, DTOFechas fechaFin, boolean activa) {
        this.idSuscripcion = idSuscripcion;
        this.fechaInicio = fechaInicio;
        this.tiempoContrato = tiempoContrato;
        this.fechaFin = fechaFin;
        this.activa = activa;
    }
/*ID -1 SIN PAQUETES*/
public Suscripcion(DTOFechas fechaInicio, float tiempoContrato, DTOFechas fechaFin, boolean activa) {
        this.idSuscripcion = -1;
        this.fechaInicio = fechaInicio;
        this.tiempoContrato = tiempoContrato;
        this.fechaFin = fechaFin;
        this.activa = activa;
    }
/*Constructores*/
/*Comportamiento*/

    @Override
    public int compareTo(Suscripcion o) {
        int resultado = 0;
        if(this.getIdSuscripcion()<(o.getIdSuscripcion())){
            resultado = -1;
        }
        if(this.getIdSuscripcion()>(o.getIdSuscripcion())){
            resultado = 1;
        }
        return resultado;
    }

/*Comportamiento*/
/*Getters y Setters*/
    public int getIdSuscripcion() {
        return idSuscripcion;
    }

    public void setIdSuscripcion(int idSuscripcion) {
        this.idSuscripcion = idSuscripcion;
    }

    public DTOFechas getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(DTOFechas fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public float getTiempoContrato() {
        return tiempoContrato;
    }

    public void setTiempoContrato(float tiempoContrato) {
        this.tiempoContrato = tiempoContrato;
    }

    public DTOFechas getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(DTOFechas fechaFin) {
        this.fechaFin = fechaFin;
    }

    public boolean getActiva() {
        return activa;
    }

    public void setActiva(boolean activa) {
        this.activa = activa;
    }

    public ArrayList<Paquete> getListaPaquetes() {
        return listaPaquetes;
    }

    public void setListaPaquetes(ArrayList<Paquete> listaPaquetes) {
        this.listaPaquetes = listaPaquetes;
    }
/*Getters y Setters*/



    
}
