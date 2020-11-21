/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import Datos.OpEmpresa;
import Datos.OpPais;
import Datos.OpPersona;
import Modelo.Empresa;
import Modelo.Operador;
import Modelo.Pais;
import Modelo.Persona;
import Modelo.ProgramException;
import Modelo.TipoUsuario;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
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
    
    public ControladorManejoUsuarios(IVistaManejoUsuarios vista) {
        this.vista = vista;
        this.opPersona = new OpPersona("bentancor");//usuario logueado, en el login tomarlo de la session
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
            
            vista.errorAltaUsuario("se cayó en catch ProgramException");
            
        } catch (Exception ex) { //error al insertar    
            
            vista.errorAltaUsuario("se cayó en catch Exception");
            
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

//    private String filtroBuscarPersona(Operador operador) {
//        
//          Hacer filtro con los campos del operador para chequear que no exista otro igual    
//        
//    }

    

    
    
}
