/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vistaWeb;

import controlador.ControladorManejoDispositivos;
import controlador.Interfaces.IVistaManejoDispositivos;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Andres
 */
public class VistaManejoDispositivosWeb implements IVistaManejoDispositivos{
    
    private ControladorManejoDispositivos controlador;
    private HttpServletRequest request;
    private HttpServletResponse response;
    
    private PrintWriter out;

    public VistaManejoDispositivosWeb(HttpServletRequest request, HttpServletResponse response) throws IOException {
        this.response = response;
        this.out = response.getWriter();
        controlador = new ControladorManejoDispositivos(this);
    }
    
    

    public void procesarRequest(HttpServletRequest request, HttpServletResponse response) {
        
        //procesar las acciones
        
        
        
        
    }
    
    
    
}
