package vistaWeb;

import Modelo.Funciones;
import Modelo.Pais;
import Modelo.Persona;
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
            case "generarUsuario":
                this.generarUsuarioSistema();
            break;
            case "formAltaCliente":
                this.altaCliente(request, response);
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
    private void generarUsuarioSistema(){
        String usuario = this.controlador.generarUsuarioSistema();
        request.setAttribute(usuario, "usuarioSistema" );
    }
    private void altaCliente(HttpServletRequest request, HttpServletResponse response){
        Persona p;
        String usuarioSistema = request.getParameter("usuarioSistema");
        String nroDocumento = request.getParameter("txtbxNroDocumentoClienteAlta");
        String nombreCompleto = request.getParameter("txtbxNombreCompletoClienteAlta");
        
        this.request = request;
        this.response = response;
        //controlador.alta(p);
    } 
    @Override
    public void exitoAltaCliente(String mensajeExitoAlta) {
        destino = "cliente_Alta.jsp?msg=" + mensajeExitoAlta;
        try{
            response.sendRedirect(destino);
        }catch(IOException ex){
            System.out.println("Error en la redirección");
        }
    }

    @Override
    public void errorAltaCliente(String mensajeErrorAlta) {
        destino = "cliente_Alta.jsp?msg=" + mensajeErrorAlta;
        try{
            response.sendRedirect(destino);
        }catch(IOException ex){
            System.out.println("Error en la redirección");
        }    
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
        String componente = Funciones.lista(false, "lstPaises", paises);
        out.write(componente + "\n\n");
    }
    @Override
    public void mostrarUsuarioSistema(String usuario) {
        out.write(usuario + "\n\n");
    }
    @Override
    public void errorCargaPaises(String mensajeError) {
        destino = "cliente_Alta.jsp?msg=" + mensajeError;
        try{
            response.sendRedirect(destino);
        }catch(IOException ex){
            System.out.println("Error en la redirección");
        }
    }
    @Override
    public void errorAlGenerarUsuario(String texto) {
        destino = "cliente_Alta.jsp?msg=" + texto;
        try{
            response.sendRedirect(destino);
        }catch(IOException ex){
            System.out.println("Error en la redirección");
        }    
    }
    /*Comportamiento*/
    
    /*Getters y Setters*/
    
    /*Getters y Setters*/






    
}
