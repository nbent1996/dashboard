package vistaWeb;

import Modelo.Funciones;
import Modelo.Pais;
import Modelo.Persona;
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
    
    
    private ArrayList<TipoUsuario> tiposUsu = new ArrayList();
    private ArrayList<Pais> paises = new ArrayList();
    
    private ArrayList<Persona> personas = new ArrayList();

    
    public VistaManejoUsuariosWeb(HttpServletRequest request, HttpServletResponse response) throws IOException {
        this.response = response;
        this.out = response.getWriter();
        controlador = new ControladorManejoUsuarios(this);
    }
    
    

    public void procesarRequest(HttpServletRequest request, HttpServletResponse response) {
        
        String accion = request.getParameter("accion");
        switch(accion){
            case "comboTipos":
                this.cargarTiposUsuario();
            break;
            case "comboPaises":
                this.cargarPaises();
            break;
            case "formAlta":
                altaUsuario(request, response);
            break;  
            case "formBaja":
                //bajaUsuario(request, response);
            break;
            case "buscarUsuariosBaja":
                bajaUsuarioConTabla(request, response);
            break;
            case "formModificacion":
                modificacionUsuario(request, response);
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
        this.tiposUsu = tiposUsuarios;
        String componente = Funciones.lista(false, "lstTipos", tiposUsuarios);
        out.write("Tipo de usuario: " + componente + "\n\n");

    }

    @Override
    public void mostrarPaises(ArrayList<Pais> paises) {
        this.paises = paises;
        String componente = Funciones.lista(false, "lstPaises", paises);
        out.write("Pais: " + componente + "\n\n");
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
        
        this.personas = aux;
        String componente = Funciones.tablaUsuarios(aux, "btnBajaUsuario");
        
        out.write(componente + "\n\n");
    }

    

    

    
    
    
    
}
