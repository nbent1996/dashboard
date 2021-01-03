package controlador;

import Datos.OpMoneda;
import Datos.OpPaquete;
import Datos.OpSuscripcion;
import Datos.OpTipoDispositivo;
import Modelo.Moneda;
import Modelo.Suscripcion;
import Resources.DTOs.DTOFechas;
import Resources.DTOs.Fecha;
import controlador.Interfaces.IVistaManejoSuscripciones;
import java.util.ArrayList;

public class ControladorManejoSuscripciones {
    /*Estado*/
    private IVistaManejoSuscripciones vista;
    private OpSuscripcion opSuscripcion;
    private OpPaquete opPaquete;
    private OpTipoDispositivo opTipoDispositivo;
    private OpMoneda opMoneda;
    /*Estado*/
    
    /*Constructores*/
    public ControladorManejoSuscripciones(IVistaManejoSuscripciones vista){
        this.vista = vista;
        this.opPaquete = new OpPaquete("bentancor");
        this.opTipoDispositivo = new OpTipoDispositivo("bentancor");
        this.opSuscripcion = new OpSuscripcion("bentancor");
        this.opMoneda = new OpMoneda("bentancor");
    }
    /*Constructores*/
    
    /*Comportamiento*/
    public String getFiltroProcesado(int idSuscripcion, String fechaInicioAStr, String fechaFinAStr, String fechaInicioBStr, String fechaFinBStr, String activaStr, String tiempoContratoStr){
        String retorno = " WHERE ";
        DTOFechas fechasInicio, fechasFin;
        if(!fechaInicioAStr.equals("") && !fechaInicioBStr.equals("")){
            fechasInicio = new DTOFechas(new Fecha(fechaInicioAStr), new Fecha(fechaInicioBStr));
            retorno += " Suscripciones.fechaInicio BETWEEN '"+fechasInicio.getFechaAStr(1)+"' AND '"+fechasInicio.getFechaBStr(1)+"' AND ";
        }
        if(!fechaFinAStr.equals("") && !fechaFinBStr.equals("")){
            fechasFin = new DTOFechas(new Fecha(fechaFinAStr), new Fecha(fechaFinBStr));
            retorno+=" Suscripciones.fechaFin BETWEEN '"+fechasFin.getFechaAStr(1)+"' AND '"+fechasFin.getFechaBStr(1)+"' AND ";
        }
        if(idSuscripcion!=-1){
            retorno+= " Suscripciones.idSuscripcion='"+idSuscripcion+"' AND ";
        }
        if(!tiempoContratoStr.equals("")){
            retorno+= " Suscripciones.tiempoContrato = '"+tiempoContratoStr+"' AND ";
        }
        if(!activaStr.equals("")){
            retorno+= " Suscripciones.activa = '"+activaStr+"' "; 
        }
        
        if(retorno.endsWith("AND ")){
            retorno = retorno.substring(0, retorno.length()-5);
        }
        if(retorno.equals(" WHERE ")){
            retorno = null;
        }
        
        return retorno;
    }
    
    public void generarTablaSuscripciones(String filtro){
        try{            
            if(filtro!=null){//Se seleccionó al menos un filtro
                ArrayList<Suscripcion> suscripcionesFiltradas = new ArrayList();
                suscripcionesFiltradas = opSuscripcion.buscar(filtro, null);
                vista.generarTablaSuscripciones("tblSuscripcionesSuscripcionBaja", suscripcionesFiltradas);
            }else{//filtro es nulo si no hay filtros seleccionados
                vista.generarTablaSuscripciones("tblSuscripcionesSuscripcionBaja", opSuscripcion.obtenerTodos());
            }
        }catch(Exception ex){
            vista.mensajeError("suscripcion_BajaModificacion.jsp","Error al generar la tabla de suscripciones.");
        }
    }
    
    public void generarTablaPaquetes(){
        try{
            vista.generarTablaPaquetes("tblPaquetesSuscripcionAlta", opPaquete.obtenerTodos(), new Moneda("UYU","Pesos Uruguayos","$")); //MONEDA HARDCODEADA, OBTENERLA DESDE LA IDENTIFICACION TRIBUTARIA DE LA SESSION
        }catch(Exception ex){
            vista.mensajeError("suscripcion_Alta.jsp","Error al generar la tabla de paquetes de dispositivos.");
        }
    }
    /*Comportamiento*/
}
