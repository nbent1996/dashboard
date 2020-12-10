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
    
    private ControladorManejoUsuarios controlador;
    private String destino;
    private HttpServletRequest request;
    private HttpServletResponse response;
    private PrintWriter out;
   
    public VistaManejoUsuariosWeb(HttpServletRequest request, HttpServletResponse response) throws IOException {
        this.response = response;
        this.out = response.getWriter();
        controlador = new ControladorManejoUsuarios(this);
    }
    
    

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
//            case "formBaja":
//                //bajaUsuario(request, response);
//            break;
//            case "buscarUsuariosBaja":
//                bajaUsuarioConTabla(request, response);
//            break;
            case "formModificacion":
                modificacionUsuario(request, response);
            break;
            case "borrarUsuarios":
                borrarUsuarios(request, response);
            break;
        }

        
        //Se reusa el mismo servlet en los formularios de ABM usuarios
        if (request.getParameter("accion").equals("formAlta")){ //me llega el name parametroOculto del input hiden del form de alta usuario con value formAlta
            altaUsuario(request, response);
        }
        
//        if (request.getParameter("accion").equals("formBaja")){ //me llega el name parametroOculto del input hiden del form de baja usuario con value formBaja
//            bajaUsuario(request, response);
//        }

        if(request.getParameter("accion").equals("buscarUsuariosBaja")){
            bajaUsuarioConTabla(request, response);
        }
        
        if(request.getParameter("accion").equals("borrarUsuarios")){
            borrarUsuarios(request, response);
        }
        
        
        if (request.getParameter("accion").equals("formModificacion")){ //me llega el name parametroOculto del input hiden del form de modificacion usuario con value formModificacion
            modificacionUsuario(request, response);
        }
        
         
        
        
        

//        procesarCombos(request);
        

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
    public void exitoAltaUsuario(String mensajeExito) {
        destino = "usuario_Alta.jsp?msg=" + mensajeExito; //en usuario_Alta hay una expression msg que lo aplica abajo del botón
        try {
            response.sendRedirect(destino);
        } catch (IOException ex) {
            Logger.getLogger(VistaManejoUsuariosWeb.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void errorAltaUsuario(String mensajeError) {
        destino = "usuario_Alta.jsp?msg=" + mensajeError;
        try {
            response.sendRedirect(destino);
        } catch (IOException ex) {
            Logger.getLogger(VistaManejoUsuariosWeb.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void exitoAlBorrarUsuario(String mensajeExitoBaja) {
        destino = "usuario_Baja.jsp?msg=" + mensajeExitoBaja;
        try {
            response.sendRedirect(destino);
        } catch (IOException ex) {
            Logger.getLogger(VistaManejoUsuariosWeb.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }

    @Override
    public void errorAlBorrarUsuario(String mensajeErrorBaja) {
        destino = "usuario_Baja.jsp?msg=" + mensajeErrorBaja;
        try {
            response.sendRedirect(destino);
        } catch (IOException ex) {
            Logger.getLogger(VistaManejoUsuariosWeb.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    @Override
    public void mostrarTiposUsuario(ArrayList<TipoUsuario> tiposUsuarios) {
        String componente;
        try {
            componente = Funciones.lista(false, "selTiposUsuarios", tiposUsuarios);
            out.write(componente + "\n\n");
        } catch (ProgramException ex) {
            errorCargaTiposUsuarios("Error al mostrar los tipos de usuario.");
        }

    }

    @Override
    public void mostrarPaises(ArrayList<Pais> paises) {  
        try {
           String componente = Funciones.lista(false, "selPaises", paises);
           out.write(componente + "\n\n");
        } catch (ProgramException ex) {
            errorCargaPaises("Error al mostrar los paises.");
        }
    }

    @Override
    public void errorCargaTiposUsuarios(String mensajeError) {
        destino = "Alta.jsp?errorCombos=" + mensajeError;
        
        try {
            response.sendRedirect(destino);
        } catch (IOException ex) {
            Logger.getLogger(VistaManejoUsuariosWeb.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void errorCargaPaises(String mensajeError) {
        destino = "usuario_Alta.jsp?errorCombos=" + mensajeError;
        
        try {
            response.sendRedirect(destino);
        } catch (IOException ex) {
            Logger.getLogger(VistaManejoUsuariosWeb.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

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

    

    

    

    
    
    
    
}
