package controlador;

import Datos.OpPaquete;
import Datos.OpTipoDispositivo;
import Modelo.Moneda;
import controlador.Interfaces.IVistaManejoPaquetes;

public class ControladorManejoPaquetes {
    /*Estado*/
    private IVistaManejoPaquetes vista;
    private OpPaquete opPaquete;
    private OpTipoDispositivo opTipoDispositivo;
    /*Estado*/
    
    /*Constructores*/
    public ControladorManejoPaquetes(IVistaManejoPaquetes vista){
        this.vista = vista;
        this.opPaquete = new OpPaquete("bentancor");
        this.opTipoDispositivo = new OpTipoDispositivo("bentancor");
    }
    /*Constructores*/
    
    /*Comportamiento*/
    public void generarTablaTiposDispositivos(){
        try{
            vista.generarTablaTiposDispositivos("tblTiposDispositivosPaqueteAlta", opTipoDispositivo.obtenerTodos());
        }catch(Exception ex){
            vista.mensajeError("paquete_Alta.jsp", "Error al generar la tabla de tipos de dispositivos.\n");
        }
    }
    public void generarTablaPaquetes(){
        try{
            vista.generarTablaPaquetes("tblPaquetesPaqueteBaja", opPaquete.obtenerTodos(), new Moneda("UYU","Pesos Uruguayos","$")); //MONEDA HARDCODEADA, OBTENERLA DESDE LA IDENTIFICACION TRIBUTARIA DE LA SESSION
        }catch(Exception ex){
            vista.mensajeError("paquete_Baja.jsp","Error al generar la tabla de paquetes de dispositivos.");
        }
    }
    /*Comportamiento*/
}
