package vistaWeb;

import Modelo.Pais;
import controlador.ControladorManejoClientes;
import controlador.Interfaces.IVistaManejoClientes;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
public class VistaManejoClientesWeb implements IVistaManejoClientes{
    /*Estado*/
    private ControladorManejoClientes controlador;
    private String destino;
    private HttpServletRequest request;
    private HttpServletResponse response;
    private PrintWriter out;
    /*Estado*/

    /*Constructores*/
     public VistaManejoClientesWeb(HttpServletRequest request, HttpServletResponse response) throws IOException {
        this.response = response;
        this.out = response.getWriter();
        controlador = new ControladorManejoClientes(this);
    }
    /*Constructores*/
    
    /*Comportamiento*/
    public void procesarRequest(HttpServletRequest request, HttpServletResponse response){
        String accion = request.getParameter("accion");
        switch(accion){
            case "comboPaises":
                this.cargarPaises();
            break;
            case "formAltaCliente":
                
            break;
            case "formBajaCliente":
            
            break;
            
            case "formModificacionCliente":
            
            break;
        }
    }
    private void cargarPaises(){
        this.controlador.cargarPaises();
    }
    private void altaCliente(HttpServletRequest request, HttpServletResponse response){
        
    } 
    @Override
    public void exitoAltaCliente(String mensajeExitoAlta) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void errorAltaCliente(String mensajeErrorAlta) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void exitoAlBorrarCliente(String mensajeExitoBaja) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void errorAlBorrarCliente(String mensajeErrorBaja) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void mostrarPaises(ArrayList<Pais> paises) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void errorCargaPaises(String mensajeError) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    /*Comportamiento*/
    
    /*Getters y Setters*/
    
    /*Getters y Setters*/


    
}
