package vistaWeb;

import Modelo.Funciones;
import Modelo.Pais;
import Modelo.Persona;
import Modelo.ProgramException;
import Modelo.TipoDocumento;
import controlador.ControladorManejoClientes;
import controlador.Interfaces.IVistaManejoClientes;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class VistaManejoClientesWeb implements IVistaManejoClientes{
    
    /*Estado*/
    private ControladorManejoClientes controlador;
    private String destino;
    private HttpServletRequest request;
    private HttpServletResponse response;
    private PrintWriter out;
    /*Estado*/

    /*Constructores*/
     public VistaManejoClientesWeb(HttpServletRequest request, HttpServletResponse response) throws IOException {
        this.response = response;
        this.out = response.getWriter();
        controlador = new ControladorManejoClientes(this);
    }
    /*Constructores*/
    
    /*Comportamiento*/
    public void procesarRequest(HttpServletRequest request, HttpServletResponse response){
        String accion = request.getParameter("accion");
        switch(accion){
            case "comboPaises":
                cargarPaises();
            break;
            case "comboTiposDocumento":
                cargarTiposDocumento();
            break;
//            case "generarUsuario":
//                this.generarUsuarioSistema();
//            break;
            case "formAltaCliente":
                altaCliente(request, response);
            break;
            case "mostrarTablaClientesInicio":
                cargarTablaClientesBajaInicio();
            break;
            
            case "formModificacionCliente":
            
            break;
        }
    }
    private void cargarPaises(){
        this.controlador.cargarPaises();
    }
    private void cargarTiposDocumento(){
        this.controlador.cargarTiposDocumento();
    }
    private void generarUsuarioSistema(){
        this.controlador.generarUsuarioSistema();
    }
    
    private void cargarTablaClientesBajaInicio() {
        controlador.cargarTablaClientesBajaInicio();
    }
    
    private void altaCliente(HttpServletRequest request, HttpServletResponse response){
        this.request = request;
        this.response = response;
        String tipoCliente = request.getParameter("selTipoCliente");
        String nroDocumento = request.getParameter("txtbxNroDocumentoClienteAlta");
        String nombreCompleto = request.getParameter("txtbxNombreCompletoClienteAlta");
        String codPais = request.getParameter("lstPaises");
        String email = request.getParameter("txtbxEmailClienteAlta");
        String telefono = request.getParameter("txtbxTelefonoClienteAlta");
        String tipoDocumento = request.getParameter("lstTiposDocumento");
        if(tipoCliente.equals("Principal")){
            String chkServActivo = request.getParameter("chkServicioActivo");
            boolean chkActivo = false;
            if(!chkServActivo.equals("")){
                chkActivo = true;
            }
            controlador.altaPrincipal(nroDocumento, nombreCompleto, codPais, email, telefono ,chkActivo, tipoDocumento);
        }else if (tipoCliente.equals("Secundario")){
            String nroDocumentoPrincipal = request.getParameter("txtbxNroDocPrincipalClienteAlta");
            controlador.altaSecundario(nombreCompleto, codPais, email, telefono, nroDocumento, nroDocumentoPrincipal);
        }
    } 
    @Override
    public void mostrarPaises(ArrayList<Pais> paises) {
        try {
            String componente = Funciones.lista(false, "lstPaises", paises, "changeItemSelected()");
            out.write(componente + "\n\n");
        } catch (ProgramException ex) {
            mensajeError("cliente_Alta.jsp","Error al mostrar los paises.");
        }
    }
    @Override
    public void mostrarTiposDocumento(ArrayList<TipoDocumento> tiposDocumento) {
        try{
            String componente = Funciones.lista(false, "lstTiposDocumento", tiposDocumento, "changeItemSelected()");
            out.write(componente + "\n\n");
        }catch(ProgramException ex){
            mensajeError("cliente_Alta.jsp","Error al mostrar los tipos de documento.");
        }
    }
    @Override
    public void mostrarUsuarioSistema(String usuario) {
        try{
        out.write("<input type='text' id='txtbxUsuarioSistemaClienteAlta' class='nb-input' disabled='true' value='"+usuario+"' name='txtbxUsuarioSistemaClienteAlta' />"+"\n\n");
        //METODO EN DESUSO
        }catch(Exception ex){
            mensajeError("cliente_Alta.jsp","Error al mostrar el usuario de sistema autogenerado.");
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
    
    /*Getters y Setters*/
    
    /*Getters y Setters*/

    //muestro tabla de todos los clientes (principales y secundarios) para seleccionar y dar de baja
    @Override
    public void mostrarTablaClientesBajaInicio(ArrayList<Persona> principalesYSecundarios) {
        String componente = Funciones.tablaClientes(principalesYSecundarios, "chkBajaCliente");
        
        out.write(componente + "\n\n");
    }










    
}
