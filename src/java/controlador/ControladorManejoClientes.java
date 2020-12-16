package controlador;

import Datos.OpEmpresa;
import Datos.OpPais;
import Datos.OpPersona;
import Datos.OpTipoDocumento;
import Modelo.Empresa;
import Modelo.Pais;
import Modelo.Persona;
import Modelo.Principal;
import Modelo.ProgramException;
import Modelo.Secundario;
import Modelo.TipoDocumento;
import controlador.Interfaces.IVistaManejoClientes;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ControladorManejoClientes {
    /*Estado*/
    private IVistaManejoClientes vista;
    private OpPersona opPersona;
    private OpEmpresa opEmpresa;
    private OpPais opPais;
    private OpTipoDocumento opTipoDocumento;
    /*Estado*/
    /*Constructores*/
    public ControladorManejoClientes(IVistaManejoClientes vista){
        this.vista = vista;
        this.opPersona = new OpPersona("bentancor");
        this.opEmpresa = new OpEmpresa("bentancor");
        this.opPais = new OpPais("bentancor");
        this.opTipoDocumento = new OpTipoDocumento("bentancor");
    }
    /*Constructores*/
    
    /*Comportamiento*/
    public void altaPrincipal(String nroDocumento, String nombreCompleto, String codPais, String email, String telefono, boolean servicioActivo, String tipoDocumento){
        try{
        Empresa e = new Empresa("526283747346"); //EMPRESA HARDCODEADA
        Principal p = new Principal("", nombreCompleto, e, new Pais(codPais), -1,  email, nroDocumento, servicioActivo, new TipoDocumento(tipoDocumento), telefono);
        p.validar();
        opPersona.guardar(null, p);
        vista.mensajeExito("cliente_Alta.jsp","Cliente del tipo titular dado de alta correctamente.");
        } catch (ProgramException ex) {
            vista.mensajeError("cliente_Alta.jsp",ex.getMessage());
        } catch (Exception ex) {
            vista.mensajeError("cliente_Alta.jsp", ex.getMessage());
        }
    }
    public void altaSecundario(String nombreCompleto, String codPais, String email, String telefono, String nroDocumento, String nroDocumentoPrincipal ){
        try{
        Empresa e = new Empresa("526283747346"); //EMPRESA HARDCODEADA
        Secundario s = new Secundario("", nombreCompleto, e, new Pais(codPais), -1, email, new Principal(nroDocumentoPrincipal), telefono);
        s.validar();
        opPersona.guardar(null, s);
        vista.mensajeExito("cliente_Alta.jsp", "Cliente del tipo cuenta secundaria dado de alta correctamente.");
        } catch (ProgramException ex) {
            vista.mensajeError("cliente_Alta.jsp",ex.getMessage());
        } catch (Exception ex) {
            vista.mensajeError("cliente_Alta.jsp", ex.getMessage());
        }
    }
  public void cargarPaises() {
        try {
            vista.mostrarPaises(opPais.obtenerTodos());
        } catch (Exception ex) {
            vista.mensajeError("cliente_Alta.jsp", "Error en la carga de paises");
        }
    }
  public void cargarTiposDocumento(){
        try {
            vista.mostrarTiposDocumento(opTipoDocumento.obtenerTodos());
        } catch (Exception ex) {
            vista.mensajeError("cliente_Alta.jsp", "Error en la carga de tipos de documento.");
        }
  }
  public void generarUsuarioSistema(){
        try {
            String usr = opPersona.getNuevoUsuarioSistema();
            vista.mostrarUsuarioSistema(usr);
        } catch (Exception ex) {
            vista.mensajeError("cliente_Alta.jsp", "Error al generar usuario de sistema del cliente.");
        }
  }
  
    /*Comportamiento*/
    
    /*Getters y Setters*/
    
    /*Getters y Setters*/

    public void cargarTablaClientesBajaInicio() {
        //traerme todos los principales y los secundarios y devolverlos en un array de personas
        ArrayList<Persona> principalesYSecundarios = new ArrayList();
        
        try {
            principalesYSecundarios.addAll(opPersona.buscar(null, "Modelo.Principal"));
            principalesYSecundarios.addAll(opPersona.buscar(null, "Modelo.Secundario"));
            vista.mostrarTablaClientesBajaInicio(principalesYSecundarios);
        } catch (Exception ex) {
            vista.mensajeError("cliente_Baja", "Error en la carga de clientes");
        }
        
    }
}
