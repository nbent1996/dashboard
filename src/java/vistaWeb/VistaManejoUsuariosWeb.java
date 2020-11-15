/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vistaWeb;

import controlador.ControladorManejoUsuarios;
import controlador.IVistaManejoUsuarios;
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

    public void procesarRequest(HttpServletRequest request, HttpServletResponse response) {
        
        String usuarioAltaUsr = request.getParameter("usuario");
        String nombreCompletoAltaUsr = request.getParameter("nombreCompleto");
        String nombreEmpresaAltaUsr = request.getParameter("nombreEmpresa");
        String nombrePaisAltaUsr = request.getParameter("nombrePais");
        String tipoUsuarioAltaUsr = request.getParameter("tipoUsuario");
        
        this.request = request;
        
        controlador.altaUsuario(usuarioAltaUsr, nombreCompletoAltaUsr, nombreEmpresaAltaUsr, nombrePaisAltaUsr, tipoUsuarioAltaUsr);
        
    }

    @Override
    public void mensajeAltaUsuario(String mensaje) { //mensaje de si se dió de alta o no (en el controlador)
        destino = "usuario_alta.jsp?msg=" + mensaje;
    }
    
    
    
}
