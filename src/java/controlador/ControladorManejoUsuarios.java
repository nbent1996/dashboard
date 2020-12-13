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
            vista.mensajeExito("usuario_Alta.jsp","Usuario dado de alta correctamente");
        } catch (ProgramException ex) { 
            vista.mensajeError("usuario_Alta.jsp",ex.getMessage()); 
        } catch (Exception ex) {        
            vista.mensajeError("usuario_Alta.jsp",ex.getMessage()); 
        }
    }
    public void borrarUsuariosSeleccionados(String[] listaNombresDeUsuarios) {
        //ACÁ ME LLEGA LA LISTA DE NOMBRES DE USUARIO QUE SE SELECCIONARON EN LOS CHECKBOXES
        //ELIMINAR TODOS LOS USUARIOS QUE TENGAN ESOS NOMBRES (EL NOMBRE DE USUARIO ES PK)
        //VER QUE DEVOLVER AL USUARIO, YA QUE SE DEBERÍA REFRESCAR LA TABLA
        
        String nombresEliminados = "";
        
        if(!listaNombresDeUsuarios[0].equals("")){ //se seleccionó al menos un usuario para borrar
            //en el frontend tira todos los nombres de usuarios de los check en la posición [0], convierto a string y luego a array correctamente para poder recorrer
            String cadena = listaNombresDeUsuarios[0].toString();
            String[]cadenaConvertida = cadena.split(",");
            for (String nombreUsuario : cadenaConvertida) {
                //recorro cada nombre de usuario, me traigo la persona que tiene ese usuario y lo borro
                
                try{
                    Persona personaBuscada = opPersona.buscar(" WHERE OperadoresDashboard.usuarioSistema='" + nombreUsuario + "' ", "Modelo.Operador").get(0);
                    opPersona.borrar(personaBuscada);
                    nombresEliminados+=personaBuscada.getUsuarioSistema() + "; ";                                      
                    //luego de borrar se debería actualizar la lista que está viendo el usuario, ver como resolver
                }catch(Exception ex){
                    vista.mensajeErrorBajaUsuarios("Ocurrió un error al borrar el usuario");
                    System.out.println(ex.getMessage());
                }
  
            }
            
            vista.mostrarMensajeExitoPersonaBorrada("Se eliminaron los usuarios: " + nombresEliminados); //ver de refrescar la lista
            
        }else{
            vista.mensajeNoSeleccionasteUsuarios("Debes seleccionar al menos un usuario para borrar");
        }
        
    }
    
    
    
    public void mostrarUsuariosBajaEnTabla(String nombreUsuarioBaja, String nombreCompletoUsuarioBaja) {
        //ACÁ SIMPLIFICAR LOS LOS IF HACIENDO BUEN FILTRO DE SQL EN EL BUSCAR QUE INCLUYA LIKE
        ArrayList<Persona> listaUsuarios = new ArrayList();
        
        if(nombreUsuarioBaja.trim().equals("") && nombreCompletoUsuarioBaja.trim().equals("")){ //los dos filtros vienen vacíos 
            vista.mensajeError("usuario_Alta.jsp","No ha ingresado los datos para buscar");
        }
        else if(nombreCompletoUsuarioBaja.trim().equals("") && nombreUsuarioBaja.trim()!=null){ 
            try {
            //filtro por nombre de usuario y no por nombre completo
            //aux = opPersona.buscar(" WHERE OperadoresDashboard.usuarioSistema ='"+nombreUsuarioBaja+"' " , "Modelo.Operador");
            listaUsuarios = opPersona.buscar(" WHERE OperadoresDashboard.usuarioSistema like '%"+nombreUsuarioBaja+"%' " , "Modelo.Operador");
            vista.mostrarTablaConUsuariosABorrar(listaUsuarios);
            } catch (Exception ex) {
                vista.mensajeError("usuario_Alta.jsp","Error al dar de baja el usuario");
            }
        }
        else if(nombreUsuarioBaja.trim().equals("") && nombreCompletoUsuarioBaja.trim()!=null){ 
            try {
            //filtro por nombre completo y no por nombre de usuario
            listaUsuarios = opPersona.buscar(" WHERE OperadoresDashboard.nombreCompleto ='"+nombreCompletoUsuarioBaja+"' " , "Modelo.Operador");
            vista.mostrarTablaConUsuariosABorrar(listaUsuarios);
            } catch (Exception ex) {
                vista.mensajeError("usuario_Alta.jsp","Error al dar de baja el usuario");
            }
        }
        else if(nombreCompletoUsuarioBaja.trim() != null && nombreUsuarioBaja.trim() != null){ 
            vista.mensajeError("usuario_Baja.jsp", "No ha ingresado los datos para buscar"); //fijarse porque crea otra vista
        }else{
            try {

                listaUsuarios = opPersona.buscar(" WHERE OperadoresDashboard.usuarioSistema like '%" + nombreUsuarioBaja + "%' and Personas.nombreCompleto like '%"+nombreCompletoUsuarioBaja+"%' ", "Modelo.Operador");
                vista.mostrarTablaConUsuariosABorrar(listaUsuarios);
                    return;
//                if(!nombreUsuarioBaja.trim().isEmpty()){
//                    listaUsuarios = opPersona.buscar(" WHERE OperadoresDashboard.usuarioSistema like '%" + nombreUsuarioBaja + "%' ", "Modelo.Operador");
//                    vista.mostrarTablaConUsuariosABorrar(listaUsuarios);
//                    return;
//                }
//                if(!nombreCompletoUsuarioBaja.trim().isEmpty()){
//                    listaUsuarios = opPersona.buscar(" WHERE OperadoresDashboard.nombreCompleto like '%" + nombreCompletoUsuarioBaja + "%' ", "Modelo.Operador");
//                    vista.mostrarTablaConUsuariosABorrar(listaUsuarios);
//                    return;
//                }
                
                
                
//                    if(listaUsuarios.isEmpty()){//no encontró por nombre de usuario, busca por nombre completo
//                        listaUsuarios = opPersona.buscar(" WHERE OperadoresDashboard.nombreCompleto like '%" + nombreCompletoUsuarioBaja + "%' ", "Modelo.Operador");
//                    }
                //vista.mostrarTablaConUsuariosABorrar(listaUsuarios);
            } catch (Exception ex) {
                vista.mensajeError("usuario_Baja.jsp","Error al dar de baja el usuario");
                System.out.println(ex.getMessage());
            }
        }
        
        
        
        
        
        
        
        
        
        
//        else if(nombreCompletoUsuarioBaja.trim().equals("") && nombreUsuarioBaja.trim()!=null){ 
//            try {
//            //filtro por nombre de usuario y no por nombre completo
//            //aux = opPersona.buscar(" WHERE OperadoresDashboard.usuarioSistema ='"+nombreUsuarioBaja+"' " , "Modelo.Operador");
//            listaUsuarios = opPersona.buscar(" WHERE OperadoresDashboard.usuarioSistema like '%"+nombreUsuarioBaja+"%' " , "Modelo.Operador");
//            vista.mostrarTablaConUsuariosABorrar(listaUsuarios);
//            } catch (Exception ex) {
//                vista.mensajeErrorAlBuscarUsuarios("Error al dar de baja el usuario");
//            }
//        }
//        else if(nombreUsuarioBaja.trim().equals("") && nombreCompletoUsuarioBaja.trim()!=null){ 
//            try {
//            //filtro por nombre completo y no por nombre de usuario
//            listaUsuarios = opPersona.buscar(" WHERE OperadoresDashboard.nombreCompleto ='"+nombreCompletoUsuarioBaja+"' " , "Modelo.Operador");
//            vista.mostrarTablaConUsuariosABorrar(listaUsuarios);
//            } catch (Exception ex) {
//                vista.mensajeErrorAlBuscarUsuarios("Error al dar de baja el usuario");
//            }
//        }
//        else if(nombreCompletoUsuarioBaja.trim() != null && nombreUsuarioBaja.trim() != null){ 
//            try {
//            //filtro por los dos campos
//            listaUsuarios = opPersona.buscar(" WHERE OperadoresDashboard.nombreCompleto ='"+nombreCompletoUsuarioBaja+"' +OperadoresDashboard.usuarioSistema ='"+nombreUsuarioBaja+"' " , "Modelo.Operador");
//            vista.mostrarTablaConUsuariosABorrar(listaUsuarios);
//            } catch (Exception ex) {
//                vista.mensajeErrorAlBuscarUsuarios("Error al dar de baja el usuario");
//            }
//        }
        


    }
    
    public void modificarUsuario(String usuarioModUsr, String nombreCompletoModUsr, String nombreEmpresaModUsr, String nombrePaisModUsr, String passwordModUsr) {
        
        //CONTINUAR ACÁ, EVALUAR SITUACION YA QUE ALGUNOS DE LOS PARAMETROS PUEDEN SER NULOS, VER DONDE EVALUAR DICHA CONDICION
   
    }
   
    public void cargarTiposUsuario() {
        try {
            vista.mostrarTiposUsuario(opTipoUsuario.obtenerTodos());
        } catch (Exception ex) {
            vista.mensajeError("usuario_Alta.jsp","Error en la carga de tipos de usuario");
        }
    }

    public void cargarPaises() {
        try {
            vista.mostrarPaises(opPais.obtenerTodos());
        } catch (Exception ex) {
            vista.mensajeError("usuario_Alta.jsp","Error en la carga de paises");
        }
    }

    public void cargarTablaUsuariosBajaInicio() {
        try {
            vista.mostrarTablaUsuariosBaja(opPersona.obtenerTodos());
        } catch (Exception ex) {
            vista.mensajeError("usuario_Alta.jsp","Error en la carga de usuarios"); //reuso el método de error del clic del botón buscar
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
