package vistaWeb;
import Modelo.Funciones;
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
            case "formAltaPaquete":
                this.altaPaquete(request, response);
                break;
            case "formBajaPaquete":

                break;

            case "formModificacionPaquete":

            break;
        }
    }
    private void generarTablaTiposDispositivos(){
        this.controlador.generarTablaTiposDispositivos();
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
    public void generarTablaTiposDispositivos(ArrayList<TipoDispositivo> items) {
        try{
            String componente = Funciones.tablaTiposDispositivosConCantidad(items);
            out.write(componente + "\n\n");
        }catch(ProgramException ex){
            mensajeError("paquete_Alta.jsp","Error al generar la tabla de Paquetes de dispositivos.");
        }
    }
    /*Comportamiento*/


    
    
}
