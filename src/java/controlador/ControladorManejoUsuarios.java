/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import Datos.OpEmpresa;
import Datos.OpPais;
import Datos.OpPersona;
import Datos.OpTipoUsuario;
import Modelo.Empresa;
import Modelo.Operador;
import Modelo.Pais;
import Modelo.Persona;
import Modelo.ProgramException;
import Modelo.TipoUsuario;
import com.mysql.cj.xdevapi.JsonString;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.json.JsonObject;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Andres
 */
public class ControladorManejoUsuarios implements IControlador<Persona>{
    
    private IVistaManejoUsuarios vista;
    private OpPersona opPersona;
    private OpEmpresa opEmpresa;
    private OpPais opPais;
    private OpTipoUsuario opTipoUsuario;
    
    public ControladorManejoUsuarios(IVistaManejoUsuarios vista) {
        this.vista = vista;
        this.opPersona = new OpPersona("bentancor");//usuario logueado, en el login tomarlo de la session
        this.opPais = new OpPais("bentancor");//usuario logueado, en el login tomarlo de la session
        this.opTipoUsuario = new OpTipoUsuario("bentancor");//usuario logueado, en el login tomarlo de la session
        //cargarTiposUsuario();
        //cargarPaises();
        //prueba();
        //vista.cargarTipos(pasarleListaTipos); cargarTipos() y resolverlo mas abajo
        //vista.cargarPaises(pasarListaPaises);
    }
    

    public void altaUsuario(String usuarioAltaUsr, String nombreCompletoAltaUsr, String nombreEmpresaAltaUsr, String nombrePaisAltaUsr, String tipoUsuarioAltaUsr){

        
        try {
            
            //opPersona.buscar(filtroBuscarPersona(operador), tipoUsuarioAltaUsr); //chequea que no haya un idéntico operador en la BD
            Empresa empresa = opEmpresa.buscar(" WHERE nombre='"+nombreEmpresaAltaUsr+"' " , "").get(0);
            Pais pais = opPais.buscar(" WHERE nombre='"+nombrePaisAltaUsr+"' " , "").get(0);
            
            Operador operador = new Operador(usuarioAltaUsr, usuarioAltaUsr,nombreCompletoAltaUsr, empresa, pais, new TipoUsuario(tipoUsuarioAltaUsr) );
            operador.validar(); //valido campos del operador (chequea en operador y en persona)
            opPersona.guardar(null, operador); //inserto el operador en la base
            vista.exitoAltaUsuario("Usuario dado de alta correctamente");
            
        } catch (ProgramException ex) { //error en las validaciones
            
            vista.errorAltaUsuario(ex.getMessage());
            
        } catch (Exception ex) { //error al insertar    
            
            vista.errorAltaUsuario(ex.getMessage());
            
        }

    }
    
    
    public void bajaUsuario(String usuarioBajaUsr) {
        
        try {
            Persona persona = opPersona.buscar(" WHERE usuarioSistema='"+usuarioBajaUsr+"' " , "").get(0);
            opPersona.borrar(persona);
            vista.exitoAlBorrarUsuario("Usuario dado de baja correctamente");
            
        } catch (Exception ex) {//error al insertar
            vista.errorAlBorrarUsuario("Error al dar de baja el usuario");
        }

    }
    
    public void modificarUsuario(String usuarioModUsr, String nombreCompletoModUsr, String nombreEmpresaModUsr, String nombrePaisModUsr, String passwordModUsr) {
        
        //CONTINUAR ACÁ, EVALUAR SITUACION YA QUE ALGUNOS DE LOS PARAMETROS PUEDEN SER NULOS, VER DONDE EVALUAR DICHA CONDICION
   
    }

//    private String filtroBuscarPersona(Operador operador) {
//        
//          Hacer filtro con los campos del operador para chequear que no exista otro igual    
//        
//    }

    
    
    
    public void cargarTiposUsuario() {
        //de acá traerme la lista de tipos de la base de datos
        //pasarle a la vista la lista de tipos para que la muestre
        //en la vista igualar parametro con atributo de lista y mostrar
        ArrayList <TipoUsuario> tiposUsuarios = new ArrayList();
        
        try {
            tiposUsuarios = opTipoUsuario.obtenerTodos();
            vista.mostrarTiposUsuario(tiposUsuarios);
        } catch (Exception ex) {
            //error en la vista
            vista.errorCargaTiposUsuarios("Error en la carga de tipos de usuario");
            //Logger.getLogger(ControladorManejoUsuarios.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void cargarPaises() {
        ArrayList <Pais> paises = new ArrayList();
        
        try {
            paises = opPais.obtenerTodos();
            vista.mostrarPaises(paises);
        } catch (Exception ex) {
            //error en la vista
            vista.errorCargaPaises("Error en la carga de paises");
            //Logger.getLogger(ControladorManejoUsuarios.class.getName()).log(Level.SEVERE, null, ex);
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
