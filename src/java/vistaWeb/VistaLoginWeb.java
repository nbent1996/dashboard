package vistaWeb;

import controlador.ControladorLogin;
import controlador.Interfaces.IVistaLogin;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
public class VistaLoginWeb implements IVistaLogin{
    /*Estado*/
    private ControladorLogin controlador;
    private HttpServletRequest request;
    private HttpServletResponse response;
    private PrintWriter out;
    /*Estado*/
    /*Constructores*/
    public VistaLoginWeb(HttpServletRequest request, HttpServletResponse response) throws IOException{
        this.response = response;
        this.request = request;
        this.out = response.getWriter();
        this.controlador = new ControladorLogin(this);
    }
    /*Constructores*/
    /*Comportamiento*/
    public void procesarRequest(HttpServletRequest request, HttpServletResponse response){
        if(request.getParameter("accion").equals("login")){
            controlador.login(request.getParameter("txtbxUsuario"), request.getParameter("txtbxPassword"));
            
        }
    }
    /*Comportamiento*/
    /*Getters y Setters*/
    
    /*Getters y Setters*/

    @Override
    public void mostrarError(String textoError) {
        this.out.write(textoError);
    }
    
}
