package vistaWeb;

import Modelo.Funciones;
import Modelo.ProgramException;
import Modelo.TipoDispositivo;
import controlador.ControladorManejoDispositivos;
import controlador.Interfaces.IVistaManejoDispositivos;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
public class VistaManejoDispositivosWeb implements IVistaManejoDispositivos{
    /*Estado*/
    private ControladorManejoDispositivos controlador;
    private HttpServletRequest request;
    private HttpServletResponse response;
    private String destino;
    private PrintWriter out;
    /*Estado*/
    
    /*Constructores*/
    public VistaManejoDispositivosWeb(HttpServletRequest request, HttpServletResponse response) throws IOException {
        this.response = response;
        this.out = response.getWriter();
        controlador = new ControladorManejoDispositivos(this);
    }
    /*Constructores*/
    

    public void procesarRequest(HttpServletRequest request, HttpServletResponse response) { 
        String accion = request.getParameter("accion");
        switch(accion){
            case "comboTiposDispositivo":
                this.cargarTiposDispositivos();
            break;
            case "formAltaDispositivo":
                
            break;
            case "formBajaDispositivo":
            
            break;
            
            case "formModificacionDispositivo":
            
            break;
            case "buscarCliente":
                
            break;
            
        }
    }
    private void cargarTiposDispositivos(){
        this.controlador.cargarTiposDispositivos();
    }

    @Override
    public void exitoAltaDispositivo(String mensajeExitoAlta) {
        destino = "dispositivo_Alta.jsp?msg=" + mensajeExitoAlta;
        try {
            response.sendRedirect(destino);
        } catch (IOException ex) {
            System.out.println("Error en la redirección");
        }       }

    @Override
    public void errorAltaDispositivo(String mensajeErrorAlta) {
        destino = "dispositivo_Alta.jsp?msg=" + mensajeErrorAlta;
        try {
            response.sendRedirect(destino);
        } catch (IOException ex) {
            System.out.println("Error en la redirección");
        }       }

    @Override
    public void exitoAlBorrarDispositivo(String mensajeExitoBaja) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void errorAlBorrarDispositivo(String mensajeErrorBaja) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void mostrarTiposDispositivos(ArrayList<TipoDispositivo> items) {
        try{
        String componente = Funciones.lista(false, "selTiposDispositivo", items);
        out.write(componente+ "\n\n");
        }catch(ProgramException ex){
            errorCargaTiposDispositivos("Error en la carga de tipos de dispositivos.");
        }
    }

    @Override
    public void errorCargaTiposDispositivos(String mensajeError) {
        destino = "dispositivo_Alta.jsp?msg=" + mensajeError;
        try {
            response.sendRedirect(destino);
        } catch (IOException ex) {
            System.out.println("Error en la redirección");
        }   
    }
    
    
    
}
