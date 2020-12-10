package controlador;

import Datos.OpEmpresa;
import Datos.OpPais;
import Datos.OpPersona;
import Modelo.Pais;
import Modelo.Persona;
import Modelo.Principal;
import Modelo.ProgramException;
import Modelo.Secundario;
import controlador.Interfaces.IVistaManejoClientes;
import java.util.ArrayList;

public class ControladorManejoClientes {
    /*Estado*/
    private IVistaManejoClientes vista;
    private OpPersona opPersona;
    private OpEmpresa opEmpresa;
    private OpPais opPais;
    /*Estado*/
    /*Constructores*/
    public ControladorManejoClientes(IVistaManejoClientes vista){
        this.vista = vista;
        this.opPersona = new OpPersona("bentancor");
        this.opEmpresa = new OpEmpresa("bentancor");
        this.opPais = new OpPais("bentancor");
    }
    /*Constructores*/
    
    /*Comportamiento*/
    public void alta(Persona p) {
        try {
            if (p instanceof Principal) {
                Principal principal = (Principal) p;
                principal.validar();
                opPersona.guardar(null, principal);
                vista.exitoAltaCliente("Cliente del tipo titular dado de alta correctamente.");
            } else if (p instanceof Secundario) {
                Secundario secundario = (Secundario) p;
                secundario.validar();
                opPersona.guardar(null, secundario);
                vista.exitoAltaCliente("Cliente del tipo cuenta secundaria dado de alta correctamente.");
            }
        } catch (ProgramException ex) {
            vista.errorAltaCliente(ex.getMessage());
        } catch (Exception ex) {
            vista.errorAltaCliente(ex.getMessage());
        }
    }
  public void cargarPaises() {
        try {
            vista.mostrarPaises(opPais.obtenerTodos());
        } catch (Exception ex) {
            vista.errorCargaPaises("Error en la carga de paises");
        }
    }
  public void generarUsuarioSistema(){
        try {
            String usr = opPersona.getNuevoUsuarioSistema();
            vista.mostrarUsuarioSistema(usr);
        } catch (Exception ex) {
            vista.errorAlGenerarUsuario("Error al generar usuario de sistema del cliente.");
        }
  }
  
    /*Comportamiento*/
    
    /*Getters y Setters*/
    
    /*Getters y Setters*/
}
