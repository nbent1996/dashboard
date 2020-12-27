package vistaWeb;

import Modelo.Funciones;
import Modelo.Moneda;
import Modelo.Paquete;
import Modelo.ProgramException;
import Modelo.Suscripcion;
import Resources.DTOs.DTOFechas;
import Resources.DTOs.Fecha;
import controlador.ControladorManejoSuscripciones;
import controlador.Interfaces.IVistaManejoSuscripciones;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
public class VistaManejoSuscripcionesWeb implements IVistaManejoSuscripciones{
    /*Estado*/
    private ControladorManejoSuscripciones controlador;
    private String destino;
    private HttpServletRequest request;
    private HttpServletResponse response;
    private PrintWriter out;
    /*Estado*/
    /*Constructores*/
    public VistaManejoSuscripcionesWeb(HttpServletRequest request, HttpServletResponse response) throws IOException{
        this.response = response;
        this.out = response.getWriter();
        controlador = new ControladorManejoSuscripciones(this);
    }
    /*Constructores*/
    
    /*Comportamiento*/
    public void procesarRequest(HttpServletRequest request, HttpServletResponse response) {
        String accion = request.getParameter("accion");
        switch (accion) {
            case "generarTablaPaquetes":
                this.generarTablaPaquetes();
                break;
            case "generarTablaSuscripcionesBaja":
                this.generarTablaSuscripciones(request, response);
            break;
            case "formAltaSuscripcion":
                this.altaSuscripcion(request, response);
                break;
            case "formBajaSuscripcion":

                break;

            case "formModificacionSuscripcion":

            break;
        }
    }
    private void generarTablaPaquetes(){
        this.controlador.generarTablaPaquetes();
    }
    private void generarTablaSuscripciones(HttpServletRequest request, HttpServletResponse response){
        this.request = request;
        this.response = response;
        String idSuscripcionStr = request.getParameter("idSuscripcion");
        int idSuscripcion = -1;
        if(idSuscripcionStr !=null && !idSuscripcionStr.equals("")){
            idSuscripcion = Integer.parseInt(idSuscripcionStr);
        }
        String fechaInicioAStr = request.getParameter("fechaInicioA");
        String fechaFinAStr = request.getParameter("fechaFinA");
        String fechaInicioBStr = request.getParameter("fechaInicioB");
        String fechaFinBStr = request.getParameter("fechaFinB"); 
        String activa = request.getParameter("activa");
        String tiempoContrato = request.getParameter("tiempoContrato");
        if(fechaInicioAStr==null){
            fechaInicioAStr = "";
        }
        if(fechaFinAStr==null){
            fechaFinAStr = "";
        }
        if(fechaInicioBStr==null){
            fechaInicioBStr = "";
        }
        if(fechaFinBStr==null){
            fechaFinBStr = "";
        }
        if(activa==null){
            activa = "";
        }else{
            if(!activa.equals("")){
                activa = "Y";
            }else{
                activa = "N";
            }
        }
        if(tiempoContrato==null){
            tiempoContrato = "";
        }
        String filtro = this.controlador.getFiltroProcesado(idSuscripcion, fechaInicioAStr, fechaFinAStr,fechaInicioBStr, fechaFinBStr, activa, tiempoContrato);  
        this.controlador.generarTablaSuscripciones(filtro);
    }
    private void altaSuscripcion(HttpServletRequest request, HttpServletResponse response) {

        this.request = request;
        this.response = response;
    }
    @Override
    public void generarTablaPaquetes(String idTabla , ArrayList<Paquete> items, Moneda moneda){
        try{
            String componente = Funciones.tablaPaquetes(idTabla, items, moneda);
            out.write(componente + "\n\n");
        }catch(ProgramException ex){
            mensajeError("suscripcion_Alta.jsp","Error al generar la tabla de Paquetes de dispositivos.");
        }
    }
    @Override
    public void generarTablaSuscripciones(String idTabla, ArrayList<Suscripcion> items) {
        try{
            String componente = Funciones.tablaSuscripciones(idTabla, items);
            out.write(componente + "\n\n");
        }catch(ProgramException ex){
            mensajeError("suscripcion_BajaModificacion.jsp","Error al generar la tabla de suscripciones.");
        }
    }
    @Override
    public void mensajeError(String nombreJSP, String texto) {
        destino = nombreJSP+"?msg=" + texto;
        try{
            response.sendRedirect(destino);
        }catch(IOException ex){
            System.out.println(texto);
        }        
    }

    @Override
    public void mensajeExito(String nombreJSP, String texto) {
        destino = nombreJSP+"?msg=" + texto;
        try{
            response.sendRedirect(destino);
        }catch(IOException ex){
            System.out.println(texto);
        }      
    }
    
    /*Comportamiento*/




}
