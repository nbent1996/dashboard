package vistaWeb;
import Modelo.Funciones;
import Modelo.Moneda;
import Modelo.Paquete;
import Modelo.ProgramException;
import Modelo.TipoDispositivo;
import controlador.ControladorManejoPaquetes;
import controlador.Interfaces.IVistaManejoPaquetes;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
public class VistaManejoPaquetesWeb implements IVistaManejoPaquetes{
    /*Estado*/
    private ControladorManejoPaquetes controlador;
    private String destino;
    private HttpServletRequest request;
    private HttpServletResponse response;
    private PrintWriter out;    
    /*Estado*/
    
    /*Constructores*/
    public VistaManejoPaquetesWeb(HttpServletRequest request, HttpServletResponse response) throws IOException{
        this.response = response;
        this.out = response.getWriter();
        controlador = new ControladorManejoPaquetes(this);
    }
    /*Constructores*/
    
    /*Comportamiento*/
    public void procesarRequest(HttpServletRequest request, HttpServletResponse response) {
        String accion = request.getParameter("accion");
        switch(accion){
            case "generarTablaTiposDispositivos":
                this.generarTablaTiposDispositivos();
            break;
            case "generarTablaPaquetesBaja":
                this.generarTablaPaquetes(request, response);
            break;
            case "formAltaPaquete":
                this.altaPaquete(request, response);
            break;
            case "modificarPaquete":

            break;
            case "borrarPaquetes":
                 borrarPaquetes(request, response);
            break;
            case "buscarPaquetes":
                 generarTablaPaquetes(request, response);
            break;
        }
    }
    private void generarTablaTiposDispositivos(){
        this.controlador.generarTablaTiposDispositivos();
    }
    private void generarTablaPaquetes(HttpServletRequest request, HttpServletResponse response){
        this.request = request;
        this.response = response;
        String idPaqueteStr = request.getParameter("idPaquete");
        int idPaquete = -1;
        if(idPaqueteStr != null && !idPaqueteStr.equals("")){
           idPaquete = Integer.parseInt(idPaqueteStr);
        }
        String nombre = request.getParameter("nombrePaquete");
        String costoA = request.getParameter("costoA");
        String costoB = request.getParameter("costoB");
        if(nombre==null){
            nombre = "";
        }
        if(costoA==null){
            costoA="";
        }
        if(costoB==null){
            costoB="";
        }
        String filtro = this.controlador.getFiltroProcesado(idPaquete, nombre, costoA, costoB);
        this.controlador.generarTablaPaquetes(filtro);
    }
    private void altaPaquete(HttpServletRequest request, HttpServletResponse response){
        this.request = request;
        this.response = response;
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

    @Override
    public void generarTablaTiposDispositivos(String idTabla, ArrayList<TipoDispositivo> items) {
        try{
            String componente = Funciones.tablaTiposDispositivosConCantidad(idTabla, items);
            out.write(componente + "\n\n");
        }catch(ProgramException ex){
            mensajeError("paquete_Alta.jsp","Error al generar la tabla de Paquetes de dispositivos.");
        }
    }
    @Override
    public void generarTablaPaquetes(String idTabla, ArrayList<Paquete> items, Moneda moneda){
        try{
            String componente = Funciones.tablaPaquetes(idTabla, items, moneda);
            out.write(componente + "\n\n");
        }catch(ProgramException ex){
            mensajeError("paquete_BajaModificacion.jsp","Error al generar la tabla de Paquetes de dispositivos.");
        }
    }
    /*Comportamiento*/

    private void borrarPaquetes(HttpServletRequest request, HttpServletResponse response) {
        String listaIdPaquetes[] = request.getParameterValues("listaIdPaquetes"); // lista de nombres de usuarios (PK) (sacados del value de los checkboxes)
        this.request = request;
        this.response = response;
        
        controlador.borrarPaquetesSeleccionados(listaIdPaquetes);
    }


    
    
}
