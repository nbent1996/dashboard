/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vistaWeb;

import Modelo.ComponentesHtml;
import Modelo.Pais;
import Modelo.TipoUsuario;
import controlador.ControladorManejoUsuarios;
import controlador.IVistaManejoUsuarios;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Andres
 */
public class VistaManejoUsuariosWeb implements IVistaManejoUsuarios{
    
    private ControladorManejoUsuarios controlador;
    private String destino;
    private HttpServletRequest request;
    private HttpServletResponse response;
    
    private PrintWriter out;
    
    
    private ArrayList<TipoUsuario> tiposUsu = new ArrayList();
    private ArrayList<Pais> paises = new ArrayList();

    
    public VistaManejoUsuariosWeb(HttpServletRequest request, HttpServletResponse response) throws IOException {
        this.response = response;
        this.out = response.getWriter();
        controlador = new ControladorManejoUsuarios(this);
    }
    
    

    public void procesarRequest(HttpServletRequest request, HttpServletResponse response) {
        
        //ANDUVO ESTE CAMBIO, LO IMPLEMENTÉ PARA REUSAR EL MISMO SERVLET
        if (request.getParameter("parametroOculto").equals("formAlta")){ //me llega el name parametroOculto del input hiden del form de alta usuario con value formAlta
            altaUsuario(request, response);
        }
        
        if (request.getParameter("parametroOculto").equals("formBaja")){ //me llega el name parametroOculto del input hiden del form de baja usuario con value formBaja
            bajaUsuario(request, response);
        }
        
        if (request.getParameter("parametroOculto").equals("formModificacion")){ //me llega el name parametroOculto del input hiden del form de modificacion usuario con value formModificacion
            modificacionUsuario(request, response);
        }

//        procesarCombos(request);
        
    }
    
//  private void procesarCombos(HttpServletRequest request) {
//        String accion = request.getParameter("accion");
//        switch (accion) {
//            case "comboTipos":
//                cargarTiposUsuario();
//                break;
//            case "comboPaises":
//                cargarPaises();
//                break;
//                
//        }
//    }
    
//    private void cargarTiposUsuario() {
//        controlador.cargarTiposUsuario();
//    }
//
//    private void cargarPaises() {
//        controlador.cargarPaises();
//    }


    private void altaUsuario(HttpServletRequest request, HttpServletResponse response) {
        
        String usuarioAltaUsr = request.getParameter("usuario");
        String nombreCompletoAltaUsr = request.getParameter("nombreCompleto");
        String nombreEmpresaAltaUsr = request.getParameter("nombreEmpresa");
        String nombrePaisAltaUsr = request.getParameter("nombrePais");
        String tipoUsuarioAltaUsr = request.getParameter("tipoUsuario");

        this.request = request;
        this.response = response;

        controlador.altaUsuario(usuarioAltaUsr, nombreCompletoAltaUsr, nombreEmpresaAltaUsr, nombrePaisAltaUsr, tipoUsuarioAltaUsr);
        
    }

    private void bajaUsuario(HttpServletRequest request, HttpServletResponse response) {
        
        String usuarioBajaUsr = request.getParameter("usuarioBaja");
        
        this.request = request;
        this.response = response;
        
        controlador.bajaUsuario(usuarioBajaUsr);
        
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
        String componente = ComponentesHtml.lista(false, "lstTipos", tiposUsuarios);
        out.write("data: " + componente + "\n\n");

    }

    @Override
    public void mostrarPaises(ArrayList<Pais> paises) {
        this.paises = paises;
        String componente = ComponentesHtml.lista(false, "lstPaises", paises);
        out.write("data: " + componente + "\n\n");
    }

    

    
    
    
    
}
