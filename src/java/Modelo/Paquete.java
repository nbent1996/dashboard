package Modelo;

import java.util.ArrayList;

public class Paquete {
/*Estado*/
private int idPaquete;
private float costoBruto;
private Empresa empresaAsociada;
private ArrayList<TieneTP> listaTieneTP;
/*Estado*/

/*Constructores*/
/*SOLO ID*/
public Paquete(int idPaquete){
    this.idPaquete = idPaquete;
}
/*ID -1 FULL*/
public Paquete(float costoBruto, Empresa empresaAsociada, ArrayList<TieneTP> listaTieneTP){
    this.idPaquete = -1;
    this.costoBruto = costoBruto;
    this.empresaAsociada = empresaAsociada;
    this.listaTieneTP = listaTieneTP;
}
/*CON ID SIN LISTA TIENETP*/
public Paquete(int idPaquete, float costoBruto, Empresa empresaAsociada){
    this.idPaquete = idPaquete;
    this.costoBruto = costoBruto;
    this.empresaAsociada = empresaAsociada;
}
/*ID -1 sin LISTA TIENETP*/
public Paquete(float costoBruto, Empresa empresaAsociada){
    this.idPaquete = -1;
    this.costoBruto = costoBruto;
    this.empresaAsociada = empresaAsociada;
}
/*Constructores*/

/*Comportamiento*/

/*Comportamiento*/

/*Getters y Setters*/
public int getIdPaquete() {
        return idPaquete;
    }

    public void setIdPaquete(int idPaquete) {
        this.idPaquete = idPaquete;
    }

    public float getCostoBruto() {
        return costoBruto;
    }

    public void setCostoBruto(float costoBruto) {
        this.costoBruto = costoBruto;
    }

    public Empresa getEmpresaAsociada() {
        return empresaAsociada;
    }

    public void setEmpresaAsociada(Empresa empresaAsociada) {
        this.empresaAsociada = empresaAsociada;
    }

    public ArrayList<TieneTP> getListaTieneTP() {
        return listaTieneTP;
    }

    public void setListaTieneTP(ArrayList<TieneTP> listaTieneTP) {
        this.listaTieneTP = listaTieneTP;
    }
/*Getters y Setters*/

    
}
