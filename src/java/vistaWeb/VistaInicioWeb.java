package vistaWeb;

import Modelo.Empresa;
import Modelo.Operador;
import Modelo.Pais;
import Modelo.TipoUsuario;
import controlador.ControladorInicio;
import controlador.Interfaces.IVistaInicio;
import java.io.IOException;
import java.io.PrintWriter;
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
/*Estado*/

/*Constructores*/
    public VistaInicioWeb(HttpServletRequest request, HttpServletResponse response) throws IOException{
        this.response = response;
        this.request = request;
        /*Session harcodeada con usuario Bentancor*/
        sesion = request.getSession(true);
        sesion.setAttribute("OperadorLogueado", new Operador("Bentancor", "Nicolás Bentancor", new Empresa("526283747346"), new Pais("URU", "Uruguay"), new TipoUsuario("administrador"),"Masculino"));
        /*Session harcodeada con usuario Bentancor*/
        
        this.out = response.getWriter();
        this.controlador = new ControladorInicio(this);
        


    }
/*Constructores*/

/*Comportamiento*/
    public void procesarRequest(HttpServletRequest request, HttpServletResponse response){
        String accion= request.getParameter("accion");
        switch(accion){
            case "inicio":
                
            break;
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
/*Comportamiento*/

/*Getters y Setters*/

/*Getters y Setters*/




}
