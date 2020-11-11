package Modelo;

import Resources.DTOs.DTOFechas;
import Resources.DTOs.Fecha;
import java.util.ArrayList;

public class LogSistema {
    /*Estado*/
    private int idLog;
    private String operacion;
    private String textoError;
    private DTOFechas fechaHora;
    private ArrayList<QueryEjecutada> listaQuerys;
    /*Estado*/
    
    /*Constructores*/
    public LogSistema(int idLog){
        this.idLog = idLog;
        this.operacion = this.textoError = "";
        this.fechaHora = new DTOFechas(new Fecha());
    }
       
    public LogSistema(int idLog, String operacion, String textoError, ArrayList<QueryEjecutada> listaQuerys){
        this.idLog = idLog;
        this.operacion=operacion;
        this.textoError = textoError;
        this.listaQuerys = listaQuerys;
    }
    public LogSistema(String operacion, String textoError){
        this.idLog = -1;
        this.operacion=operacion;
        this.textoError = textoError;
    }
    
    /*Constructores*/
    
    /*Comportamiento*/
    
    /*Comportamiento*/
    
    /*Getters y Setters*/
     public int getIdLog() {
        return idLog;
    }

    public void setIdLog(int idLog) {
        this.idLog = idLog;
    }

    public String getOperacion() {
        return operacion;
    }

    public void setOperacion(String operacion) {
        this.operacion = operacion;
    }

    public String getTextoError() {
        return textoError;
    }

    public void setTextoError(String textoError) {
        this.textoError = textoError;
    }

    public DTOFechas getFechaHora() {
        return fechaHora;
    }

    public void setFechaHora(DTOFechas fechaHora) {
        this.fechaHora = fechaHora;
    }
    public ArrayList<QueryEjecutada> getListaQuerys() {
        return listaQuerys;
    }

    public void setListaQuerys(ArrayList<QueryEjecutada> listaQuerys) {
        this.listaQuerys = listaQuerys;
    }

    /*Getters y Setters*/


   
    
}
