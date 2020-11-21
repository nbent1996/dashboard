/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

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
    
    public ControladorManejoUsuarios(IVistaManejoUsuarios vista) {
        this.vista = vista;
        this.opPersona = new OpPersona("bentancor");//usuario logueado, en el login tomarlo de la session
    }
    

    public void altaUsuario(String usuarioAltaUsr, String nombreCompletoAltaUsr, String nombreEmpresaAltaUsr, String nombrePaisAltaUsr, String tipoUsuarioAltaUsr){
        
        //AGREGUÉ CLASE DE EXCEPTION PARA PODER CAPTURAR LOS ERRORES DE ESA CLASE ACÁ Y PODER MANDAR A LA VISTA LOS ERRORES ESPECÍFICOS CUANDO OCURRE UNA EXCEPCION DE ESE TIPO
        //YA QUE LAS EXCEPCIONES DE LOS OP SON EXCEPTION (ADEMAS DE SQL EXCEPTION)
        
        
        //validar los campos en el dominio -
        //pasarle al OpPersona el objeto Persona
            //Averiguar la identificacion tributaria en base a nombreEmpresaAltaUsr
            //Averiguar el codigo del Pais en base a nombrePaisAltaUsr
            String codPais="", identificacionTributaria="";    
            Operador operador = new Operador(usuarioAltaUsr, usuarioAltaUsr,nombreCompletoAltaUsr, new Empresa(identificacionTributaria), new Pais(codPais), new TipoUsuario(tipoUsuarioAltaUsr) );
<<<<<<< HEAD
            opPersona.guardar(null, operador);
=======
        try {
            operador.validar(); //valido campos del operador (chequea en operador y en persona)
            //ok validaciones
        } catch (ProgramException ex) {
            //error en las validaciones
        }
        try {
            opPersona.guardar(null, operador); //inserto el operador en la base
            //ok inserción
        } catch (Exception ex) {
            //error al insertar
        }
        
            
>>>>>>> a8ff4c9ec48e72400d4e180c1f983e10a5f25af0



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
