package vistaWeb;

import Modelo.Funciones;
import Modelo.Pais;
import Modelo.Persona;
import Modelo.ProgramException;
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
        this.controlador.generarUsuarioSistema();
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
    public void mostrarPaises(ArrayList<Pais> paises) {
        try {
            String componente = Funciones.lista(false, "lstPaises", paises, "changeItemSelected()");
            out.write(componente + "\n\n");
        } catch (ProgramException ex) {
            mensajeError("cliente_Alta.jsp","Error al mostrar los paises.");
        }
    }
    @Override
    public void mostrarUsuarioSistema(String usuario) {
        try{
        out.write("<span name='usuarioSistema' class='spanUsuario'>"+usuario+"</span>" + "\n\n");
        }catch(Exception ex){
            mensajeError("cliente_Alta.jsp","Error al mostrar el usuario de sistema autogenerado.");
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
    
    /*Getters y Setters*/
    
    /*Getters y Setters*/








    
}
