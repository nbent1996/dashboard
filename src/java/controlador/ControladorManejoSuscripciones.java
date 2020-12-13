package controlador;

import Datos.OpMoneda;
import Datos.OpPaquete;
import Datos.OpSuscripcion;
import Datos.OpTipoDispositivo;
import Modelo.Moneda;
import controlador.Interfaces.IVistaManejoSuscripciones;

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
    public void generarTablaPaquetes(){
        try{
            vista.generarTablaPaquetes(opPaquete.obtenerTodos(), new Moneda("UYU","Pesos Uruguayos","$")); //MONEDA HARDCODEADA, OBTENERLA DESDE LA IDENTIFICACION TRIBUTARIA DE LA SESSION
        }catch(Exception ex){
            vista.mensajeError("suscripcion_Alta.jsp","Error al generar la tabla de paquetes de dispositivos.");
        }
    }
    /*Comportamiento*/
}
