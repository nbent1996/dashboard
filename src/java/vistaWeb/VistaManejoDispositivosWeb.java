package vistaWeb;

import Modelo.Categoria;
import Modelo.Funciones;
import Modelo.ProgramException;
import Modelo.TipoDispositivo;
import controlador.ControladorManejoDispositivos;
import controlador.Interfaces.IVistaManejoDispositivos;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
public class VistaManejoDispositivosWeb implements IVistaManejoDispositivos{
    /*Estado*/
    private ControladorManejoDispositivos controlador;
    private HttpServletRequest request;
    private HttpServletResponse response;
    private String destino;
    private PrintWriter out;
    /*Estado*/
    
    /*Constructores*/
    public VistaManejoDispositivosWeb(HttpServletRequest request, HttpServletResponse response) throws IOException {
        this.response = response;
        this.out = response.getWriter();
        controlador = new ControladorManejoDispositivos(this);
    }
    /*Constructores*/
    
    /*Comportamiento*/
    public void procesarRequest(HttpServletRequest request, HttpServletResponse response) { 
        String accion = request.getParameter("accion");
        switch(accion){
//            case "comboCategorias":
//                this.cargarCategorias();
//            break;
            case "comboTiposDispositivo":
                this.cargarTiposDispositivos();
            break;
            case "formAltaDispositivo":
                
            break;
            case "formBajaDispositivo":
            
            break;
            
            case "formModificacionDispositivo":
            
            break;
            case "buscarCliente":
                
            break;
            
        }
    }
    private void cargarTiposDispositivos(){
        //String cat = request.getParameter("categoria");
        this.controlador.cargarTiposDispositivos();
    }
//    private void cargarCategorias(){
//        this.controlador.cargarCategorias();
//    }

    @Override
    public void mostrarTiposDispositivos(ArrayList<TipoDispositivo> items) {
        try{
        String componente = Funciones.lista(false, "selTiposDispositivo", items, "changeItemSelected()");
        out.write(componente+ "\n\n");
        }catch(ProgramException ex){
            mensajeError("dispositivo_Alta.jsp","Error en la carga de tipos de dispositivos.");
        }
    }
    @Override
    public void mostrarCategorias(ArrayList<Categoria> items) {
        try{
            String componente = Funciones.lista(false, "selCategoria", items, "changeItemSelected()");
            out.write(componente+"\n\n");
        }catch(ProgramException ex){
            mensajeError("dispositivo_Alta.jsp","Error en la carga de categorias.");
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
    /*Comportamiento*/


    
    
}
