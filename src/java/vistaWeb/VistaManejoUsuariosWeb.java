package vistaWeb;

import Modelo.Funciones;
import Modelo.Pais;
import Modelo.Persona;
import Modelo.ProgramException;
import Modelo.TipoUsuario;
import controlador.ControladorManejoUsuarios;
import controlador.Interfaces.IVistaManejoUsuarios;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



public class VistaManejoUsuariosWeb implements IVistaManejoUsuarios{
    /*Estado*/
    private ControladorManejoUsuarios controlador;
    private String destino;
    private HttpServletRequest request;
    private HttpServletResponse response;
    private PrintWriter out;
    /*Estado*/
    
    /*Constructores*/
    public VistaManejoUsuariosWeb(HttpServletRequest request, HttpServletResponse response) throws IOException {
        this.response = response;
        this.out = response.getWriter();
        controlador = new ControladorManejoUsuarios(this);
    }
    /*Constructores*/
    
    /*Comportamiento*/
    public void procesarRequest(HttpServletRequest request, HttpServletResponse response) {
        String accion = request.getParameter("accion");
        switch(accion){
            case "comboTipos":
                cargarTiposUsuario();
            break;
            case "comboPaises":
                cargarPaises();
            break;
            case "formAlta":
                altaUsuario(request, response);
            break;  
            case "formModificacion":
                modificacionUsuario(request, response);
            break;
            case "borrarUsuarios":
                borrarUsuarios(request, response);
            break;
        }
    }

    private void cargarTiposUsuario() {
        controlador.cargarTiposUsuario();
    }

    private void cargarPaises() {
        controlador.cargarPaises();
    }


    private void altaUsuario(HttpServletRequest request, HttpServletResponse response) {
        
        String usuarioAltaUsr = request.getParameter("usuario");
        String nombreCompletoAltaUsr = request.getParameter("nombreCompleto");
        String nombreEmpresaAltaUsr = request.getParameter("nombreEmpresa");
        String nombrePaisAltaUsr = request.getParameter("lstPaises");
        String tipoUsuarioAltaUsr = request.getParameter("tipoUsuario");
        
        
        this.request = request;
        this.response = response;

        controlador.altaUsuario(usuarioAltaUsr, nombreCompletoAltaUsr, nombreEmpresaAltaUsr, nombrePaisAltaUsr, tipoUsuarioAltaUsr);
        
    }

//    private void bajaUsuario(HttpServletRequest request, HttpServletResponse response) {
//        
//        String nombreUsuarioBaja = request.getParameter("usuarioBaja");
//        
//        this.request = request;
//        this.response = response;
//        
//        controlador.bajaUsuario(nombreUsuarioBaja, "");
//        
//    }
    
    private void borrarUsuarios(HttpServletRequest request, HttpServletResponse response) {
        String listaNombresDeUsuarios[] = request.getParameterValues("listaUsuarios");
        this.request = request;
        this.response = response;
        
        controlador.borrarUsuariosSeleccionados(listaNombresDeUsuarios);
    }
    
    private void bajaUsuarioConTabla(HttpServletRequest request, HttpServletResponse response) {
        
        //uno de los dos viene vacio ya que se puede filtrar por cualquiera de los dos campos
        String nombreUsuarioBaja = request.getParameter("nombreUsuario");
        String nombreCompletoUsuarioBaja = request.getParameter("nombreCompleto");
        
        this.request = request;
        this.response = response;
        
        controlador.bajaUsuario(nombreUsuarioBaja, nombreCompletoUsuarioBaja);
        
    }

    private void modificacionUsuario(HttpServletRequest request, HttpServletResponse response) {
        String usuarioModUsr = request.getParameter("usuarioMod");
        String nombreCompletoModUsr = request.getParameter("nombreCompletoMod");
        String nombreEmpresaModUsr = request.getParameter("nombreEmpresaMod");
        String nombrePaisModUsr = request.getParameter("nombrePaisMod");
        String passwordModUsr = request.getParameter("passwordMod");
        
        controlador.modificarUsuario(usuarioModUsr, nombreCompletoModUsr, nombreEmpresaModUsr, nombrePaisModUsr, passwordModUsr);
        
        //(pueden ser nulos ya que no es necesario llenar todos los campos (se puede modificar un campo solo))
        
    }

   @Override
    public void mostrarTiposUsuario(ArrayList<TipoUsuario> tiposUsuarios) {
        String componente;
        try {
            componente = Funciones.lista(false, "selTiposUsuarios", tiposUsuarios, "changeItemSelected()");
            out.write(componente + "\n\n");
        } catch (ProgramException ex) {
            mensajeError("Error al mostrar los tipos de usuario.");
        }

    }

    @Override
    public void mostrarPaises(ArrayList<Pais> paises) {  
        try {
           String componente = Funciones.lista(false, "selPaises", paises, "changeItemSelected()");
           out.write(componente + "\n\n");
        } catch (ProgramException ex) {
            mensajeError("Error al mostrar los paises.");
        }
    }
    @Override
    public void mensajeError(String texto) {
        destino = "usuario_Alta.jsp?msg=" + texto;
        
        try {
            response.sendRedirect(destino);
        } catch (IOException ex) {
            System.out.println(texto);
        }
    }

    @Override
    public void mensajeExito(String texto) {
        destino = "usuario_Alta.jsp?msg=" + texto;
        
        try {
            response.sendRedirect(destino);
        } catch (IOException ex) {
            System.out.println(texto);
        }
    }
    /*--*/
    
    @Override
    public void pruebaMostrarTablaBorrarUsuario(ArrayList<Persona> aux) {
        //Funciones.tablaUsuarios(aux, "btnBajaUsuario");
        
        String componente = Funciones.tablaUsuarios(aux, "btnBajaUsuario");
        
        out.write(componente + "\n\n");
    }

    @Override
    public void mostrarMensajeExitoPersonaBorrada(String exitoAlBorrarUsuario) {
        out.write(exitoAlBorrarUsuario);
    }

    @Override
    public void mensajeErrorAlBorrarPersona(String errorAlBorrarUsuario) {
        out.write(errorAlBorrarUsuario);
    }

    @Override
    public void mensajeNoSeleccionasteUsuarios(String noHayUsuariosSeleccionados) {
        out.write(noHayUsuariosSeleccionados);
    }

/*Comportamiento*/

    

    

    

    
    
    
    
}
