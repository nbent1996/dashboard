/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import Datos.OpPersona;
import Modelo.Persona;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Andres
 */
public class ControladorManejoUsuarios implements IControlador<Persona>{
    
    private IVistaManejoUsuarios vista;
    private OpPersona opPersona;
    
    public ControladorManejoUsuarios(IVistaManejoUsuarios vista) {
        this.vista = vista;
        this.opPersona = new OpPersona("bentancor");//usuario logueado, en el login tomarlo de la session
    }
    

    public void altaUsuario(String usuarioAltaUsr, String nombreCompletoAltaUsr, String nombreEmpresaAltaUsr, String nombrePaisAltaUsr, String tipoUsuarioAltaUsr) {
        
        
        //validar los campos en el dominio
        //pasarle al OpPersona el objeto Persona
        //Este método lanza excepciones (la de validaciones de campos del dominio)
        //Este metodo tambien lanza excepciones de sql Exception
        //ver ArcClienteAController de la barometrica como ejemplo 
        
        
        
        vista.mensajeAltaUsuario(usuarioAltaUsr); //solo para probar que funcione el ciclo
        //desde acá ir al modelo, insertar en tabla BD
        //llamar a métodos de la vista dependiendo si se pudo insertar o no
        
        
//        if(se insertó ok){
//            vista.mensajeAltaUsuario("Usuario creado exitosamente");
//        }else{
//            vista.mensajeAltaUsuario("Error al dar de alta el usuario");
//        }
        
        
        
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
