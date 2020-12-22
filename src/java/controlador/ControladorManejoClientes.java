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

    //muestro tabla solamente con los clientes segun filtros ingresados
    public void mostrarClientesFiltradosTabla(int nroClienteBaja, String emailClienteBaja, String nombreCompletoClienteBaja) {        

        ArrayList<Persona> listaClientes = new ArrayList();
        
        try {
            
            if(nroClienteBaja == -1){//quiere decir que no se ingresó un nro cliente en el filtro
                listaClientes = opPersona.buscar(" WHERE Personas.nombreCompleto LIKE '%"+nombreCompletoClienteBaja+"%' AND Clientes.email LIKE '%"+emailClienteBaja+"%' " , "Modelo.Principal");
                listaClientes.addAll(opPersona.buscar(" WHERE Personas.nombreCompleto LIKE '%"+nombreCompletoClienteBaja+"%' AND Clientes.email LIKE '%"+emailClienteBaja+"%' " , "Modelo.Secundario"));
                vista.mostrarTablaClientesBajaInicio(listaClientes);//ver de reusar siempre el mismo metodo cuando se quiere mostrar tabla
            }else{
                listaClientes = opPersona.buscar(" WHERE Clientes.nroCliente like '%"+nroClienteBaja+"%' AND Personas.nombreCompleto LIKE '%"+nombreCompletoClienteBaja+"%' AND Clientes.email LIKE '%"+emailClienteBaja+"%' " , "Modelo.Principal");
                listaClientes.addAll(opPersona.buscar(" WHERE Clientes.nroCliente like '%"+nroClienteBaja+"%' AND Personas.nombreCompleto LIKE '%"+nombreCompletoClienteBaja+"%' AND Clientes.email LIKE '%"+emailClienteBaja+"%' " , "Modelo.Secundario"));
                vista.mostrarTablaClientesBajaInicio(listaClientes);//ver de reusar siempre el mismo metodo cuando se quiere mostrar tabla
                //ver acá que si el array de clientes es vacio devolver mensaje de que no se encontraron en vez de mostrar tabla vacia
            }
            
        } catch (Exception ex) {
            vista.mensajeError("cliente_Baja", "Error al dar de baja el cliente");
        }
        
        
    }

    //SE CAE SI BORRO UN PRINCIPAL Y UN SECUNDARIO A LA VEZ
    //Borro los clientes seleccionados de los checkboxes
    public void borrarClientesSeleccionados(String[] listaNombresDeUsuariosDeClientes) {

        String borrados = "";
        
        if(!listaNombresDeUsuariosDeClientes[0].equals("")){ //se seleccionó al menos un cliente para borrar
            //en el frontend tira todos los nombres de usuarios de los check en la posición [0], por eso convierto a string y luego a array para poder recorrer
            String cadena = listaNombresDeUsuariosDeClientes[0].toString();
            String[]cadenaConvertida = cadena.split(",");

            
            for (String nombreUsuarioCli : cadenaConvertida) { 
                //recorro cada nombre de usuario, me traigo la persona que tiene ese usuario y lo borro
                
                try {
                    borrados+=nombreUsuarioCli + " - ";
                    opPersona.borrar(new Secundario(nombreUsuarioCli));
                    
                } catch (Exception ex) {
                    //vista.mensajeErrorBajaClientes("Ocurrió un error al borrar el cliente");
                    System.out.println("No es principal");
                }
                
                
  
            }
            vista.mostrarMensajeExitoClienteBorrado("Se eliminaron los clientes: " + borrados); //devuelvo cadena que es el string que tiene los nombres de usuarios a borrar
        }else{
            vista.mensajeNoSeleccionasteClientes("Debes seleccionar al menos un cliente para borrar");
        }
        
        
        
    }
    
    
    
    
    
}
