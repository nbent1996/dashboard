package vistaWeb;

import Modelo.Operador;
import controlador.ControladorInicio;
import controlador.Interfaces.IVistaInicio;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class VistaInicioWeb implements IVistaInicio {
/*Estado*/
    private ControladorInicio controlador;
    private HttpServletRequest request;
    private HttpServletResponse response;
    private HttpSession sesion;
    private PrintWriter out;
    private String destino;   
    
    private Operador operadorLogueado;
/*Estado*/

/*Constructores*/
    public VistaInicioWeb(HttpServletRequest request, HttpServletResponse response) throws IOException{
        this.response = response;
        this.request = request;
        this.out = response.getWriter();
        this.sesion = request.getSession();
        this.operadorLogueado = (Operador) request.getSession().getAttribute("OperadorLogueado");
        this.controlador = new ControladorInicio(this, operadorLogueado);
    }
/*Constructores*/

/*Comportamiento*/
    public void procesarRequest(HttpServletRequest request, HttpServletResponse response){
        String accion= request.getParameter("accion");
        switch(accion){
            case "estadisticasInicio":
                  obtenerEstadisticas();
            break;
        }
    }
    private void obtenerEstadisticas(){
        try {
            controlador.obtenerEstadisticasA();
        } catch (Exception ex) {
            Logger.getLogger(VistaInicioWeb.class.getName()).log(Level.SEVERE, null, ex);
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
    @Override
    public Operador getOperadorLogueado() {
        return (Operador) sesion.getAttribute("operadorLogueado");
    }
    
    
    @Override
    public void mostrarEstadisticas(ArrayList<Integer> items) {
        
        if(items.size()==4){//compruebo que se hayan cargado todas las estadísticas
            
            
                request.getSession(false).setAttribute("estadisticas", items);//guardo en la session el arraylist conteniendo las estadisticas para agarrarlo en el jsp
                out.write(items.toString());
            
            
        }
        
        
        
    }
    
    
/*Comportamiento*/

/*Getters y Setters*/

/*Getters y Setters*/

}




