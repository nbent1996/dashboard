package controlador;

import controlador.Interfaces.IControlador;
import controlador.Interfaces.IVistaManejoUsuarios;
import Datos.OpEmpresa;
import Datos.OpPais;
import Datos.OpPersona;
import Datos.OpTipoUsuario;
import Modelo.Empresa;
import Modelo.Funciones;
import Modelo.Operador;
import Modelo.Pais;
import Modelo.Persona;
import Modelo.ProgramException;
import Modelo.TipoUsuario;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;
public class ControladorManejoUsuarios implements IControlador<Persona>{
    /*Estado*/
    private IVistaManejoUsuarios vista;
    private OpPersona opPersona;
    private OpEmpresa opEmpresa;
    private OpPais opPais;
    private OpTipoUsuario opTipoUsuario;
    /*Estado*/
    
    /*Constructores*/
    public ControladorManejoUsuarios(IVistaManejoUsuarios vista) {
        this.vista = vista;
        this.opPersona = new OpPersona("bentancor");
        this.opPais = new OpPais("bentancor");
        this.opTipoUsuario = new OpTipoUsuario("bentancor");
    }
    /*Constructores*/

    /*Comportamiento*/
    public void altaUsuario(String usuarioAltaUsr, String nombreCompletoAltaUsr, String nombreEmpresaAltaUsr, String nombrePaisAltaUsr, String tipoUsuarioAltaUsr){
        try {
            Empresa e = new Empresa("FALTA TRAER LA IDENTIFICACION TRIBUTARIA");
            Pais p = new Pais("FALTA TRAER EL COD PAIS DESDE EL VALUE DEL OPTION");
            Operador operador = new Operador(usuarioAltaUsr, usuarioAltaUsr,nombreCompletoAltaUsr, e,p, new TipoUsuario(tipoUsuarioAltaUsr), "Masculino" );
            operador.validar();
            opPersona.guardar(null, operador);
            vista.exitoAltaUsuario("Usuario dado de alta correctamente");
        } catch (ProgramException ex) { 
            vista.errorAltaUsuario(ex.getMessage()); 
        } catch (Exception ex) {        
            vista.errorAltaUsuario(ex.getMessage()); 
        }
    }
    public void borrarUsuariosSeleccionados(String[] listaNombresDeUsuarios) {
        //ACÁ ME LLEGA LA LISTA DE NOMBRES DE USUARIO QUE SE SELECCIONARON EN LOS CHECKBOXES
        //ELIMINAR TODOS LOS USUARIOS QUE TENGAN ESOS NOMBRES (EL NOMBRE DE USUARIO ES CLAVE PRIMARIA)
        //VER QUE DEVOLVER AL USUARIO, YA QUE SE DEBERÍA REFRESCAR LA TABLA
        
        if(listaNombresDeUsuarios != null){ //se seleccionó al menos un usuario para borrar
            
            for (String nombreUsuario : listaNombresDeUsuarios) {
                //recorro cada nombre de usuario, me traigo la persona que tiene ese usuario y lo borro
                
                try{
                    Persona personaBuscada = opPersona.buscar(" WHERE OperadoresDashboard.usuarioSistema='" + nombreUsuario + "' ", "Modelo.Operador").get(0);
                    opPersona.borrar(personaBuscada);
                    vista.mostrarMensajeExitoPersonaBorrada("Se eliminó el usuario: " + personaBuscada.getUsuarioSistema());
                    //luego de borrar se debería actualizar la lista que está viendo el usuario, ver como resolver
                }catch(Exception ex){
                    vista.mensajeErrorAlBorrarPersona("Ocurrió un error al borrar el usuario");
                }
  
            }
            
        }else{
            vista.mensajeNoSeleccionasteUsuarios("Debes seleccionar un usuario para borrar");
        }
        
    }
    
    
    
    public void bajaUsuario(String nombreUsuarioBaja, String nombreCompletoUsuarioBaja) {
        //ACÁ SIMPLIFICAR LOS LOS IF HACIENDO BUEN FILTRO DE SQL EN EL BUSCAR QUE INCLUYA LIKE
        ArrayList<Persona> aux = new ArrayList();
        
        if(nombreUsuarioBaja.trim().equals("") && nombreCompletoUsuarioBaja.trim().equals("")){ //los dos filtros vienen vacíos 
            vista.errorAlBorrarUsuario("No ha ingresado los datos para buscar");
        }
        else if(nombreCompletoUsuarioBaja.trim().equals("") && nombreUsuarioBaja.trim()!=null){ 
            try {
            //filtro por nombre de usuario y no por nombre completo
            //aux = opPersona.buscar(" WHERE OperadoresDashboard.usuarioSistema ='"+nombreUsuarioBaja+"' " , "Modelo.Operador");
            aux = opPersona.buscar(" WHERE OperadoresDashboard.usuarioSistema like '%"+nombreUsuarioBaja+"%' " , "Modelo.Operador");
            vista.pruebaMostrarTablaBorrarUsuario(aux);
            } catch (Exception ex) {
                vista.errorAlBorrarUsuario("Error al dar de baja el usuario");
            }
        }
        else if(nombreUsuarioBaja.trim().equals("") && nombreCompletoUsuarioBaja.trim()!=null){ 
            try {
            //filtro por nombre completo y no por nombre de usuario
            aux = opPersona.buscar(" WHERE OperadoresDashboard.nombreCompleto ='"+nombreCompletoUsuarioBaja+"' " , "Modelo.Operador");
            vista.pruebaMostrarTablaBorrarUsuario(aux);
            } catch (Exception ex) {
                vista.errorAlBorrarUsuario("Error al dar de baja el usuario");
            }
        }
        else if(nombreCompletoUsuarioBaja.trim() != null && nombreUsuarioBaja.trim() != null){ 
            try {
            //filtro por los dos campos
            aux = opPersona.buscar(" WHERE OperadoresDashboard.nombreCompleto ='"+nombreCompletoUsuarioBaja+"' +OperadoresDashboard.usuarioSistema ='"+nombreUsuarioBaja+"' " , "Modelo.Operador");
            vista.pruebaMostrarTablaBorrarUsuario(aux);
            } catch (Exception ex) {
                vista.errorAlBorrarUsuario("Error al dar de baja el usuario");
            }
        }
        
        
        
//        try {
//            //Persona persona = opPersona.buscar(" WHERE usuarioSistema='"+usuarioBajaUsr+"' " , "").get(0);
//            aux = opPersona.buscar(" WHERE OperadoresDashboard.usuarioSistema='"+nombreUsuarioBaja+"' " , "Modelo.Operador");
//            vista.pruebaMostrarTablaBorrarUsuario(aux);
//            //opPersona.borrar(persona);
//            //vista.exitoAlBorrarUsuario("Usuario dado de baja correctamente");
//            
//        } catch (Exception ex) {//error al insertar
//            vista.errorAlBorrarUsuario("Error al dar de baja el usuario");
//        }

    }
    
    public void modificarUsuario(String usuarioModUsr, String nombreCompletoModUsr, String nombreEmpresaModUsr, String nombrePaisModUsr, String passwordModUsr) {
        
        //CONTINUAR ACÁ, EVALUAR SITUACION YA QUE ALGUNOS DE LOS PARAMETROS PUEDEN SER NULOS, VER DONDE EVALUAR DICHA CONDICION
   
    }
   
    public void cargarTiposUsuario() {
        try {
            vista.mostrarTiposUsuario(opTipoUsuario.obtenerTodos());
        } catch (Exception ex) {
            vista.errorCargaTiposUsuarios("Error en la carga de tipos de usuario");
        }
    }

    public void cargarPaises() {
        try {
            vista.mostrarPaises(opPais.obtenerTodos());
        } catch (Exception ex) {
            vista.errorCargaPaises("Error en la carga de paises");
        }
    }

    

    
    
    
    
    
    
    
    
    
    @Override
    public void cargarItems(Persona c, DefaultTableModel modelo) throws Exception, SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String getFiltroProcesado(Persona c, DefaultTableModel modelo) throws Exception, SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void borrarItems(ArrayList<Persona> items) throws Exception, SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    
    

    
    
}
