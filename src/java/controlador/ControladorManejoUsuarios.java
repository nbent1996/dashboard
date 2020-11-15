/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

/**
 *
 * @author Andres
 */
public class ControladorManejoUsuarios {
    
    private IVistaManejoUsuarios vista;

    public ControladorManejoUsuarios(IVistaManejoUsuarios vista) {
        this.vista = vista;
    }
    

    public void altaUsuario(String usuarioAltaUsr, String nombreCompletoAltaUsr, String nombreEmpresaAltaUsr, String nombrePaisAltaUsr, String tipoUsuarioAltaUsr) {
        
        //desde acá ir al modelo, insertar en tabla BD
        //llamar a métodos de la vista dependiendo si se pudo insertar o no
        
        
//        if(se insertó ok){
//            vista.mensajeAltaUsuario("Usuario creado exitosamente");
//        }else{
//            vista.mensajeAltaUsuario("Error al dar de alta el usuario");
//        }
        
        
        
    }
    
}
