/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vistaWeb;

import controlador.ControladorManejoUsuarios;
import controlador.IVistaManejoUsuarios;
import java.io.IOException;
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

    public VistaManejoUsuariosWeb() {
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
        
        
        
        
        
        
        
//        String usuarioAltaUsr = request.getParameter("usuario");
//        String nombreCompletoAltaUsr = request.getParameter("nombreCompleto");
//        String nombreEmpresaAltaUsr = request.getParameter("nombreEmpresa");
//        String nombrePaisAltaUsr = request.getParameter("nombrePais");
//        String tipoUsuarioAltaUsr = request.getParameter("tipoUsuario");
//        
//        this.request = request;
//        this.response = response;
//        
//        controlador.altaUsuario(usuarioAltaUsr, nombreCompletoAltaUsr, nombreEmpresaAltaUsr, nombrePaisAltaUsr, tipoUsuarioAltaUsr);
        
    }

    @Override
    public void mensajeAltaUsuario(String mensaje){ //mensaje de si se dió de alta o no (en el controlador)
        destino = "usuario_Alta.jsp?msg=" + mensaje; //en usuario_Alta hay una expression msg que lo aplica abajo del botón
        try {
            this.redireccionPrueba();//esto es para probar que aplique el mensaje
        } catch (IOException ex) {
            Logger.getLogger(VistaManejoUsuariosWeb.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }

    private void redireccionPrueba() throws IOException {
        response.sendRedirect(destino);
    }

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
        
        //mandarlo al controlador y probar 
        
    }
    
    
    
}
