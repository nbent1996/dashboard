package controlador;

import controlador.Interfaces.IVistaLogin;
import Datos.OpPersona;
import Datos.OpTipoUsuario;
import Modelo.ProgramException;

public class ControladorLogin {
    /*Estado*/
    private IVistaLogin vista;
    private OpPersona opPersona;
    private OpTipoUsuario opTipoUsuario;
    /*Estado*/
    /*Constructores*/
    public ControladorLogin(IVistaLogin vista){
        this.vista = vista;
        this.opPersona = new OpPersona("loginUser");
        this.opTipoUsuario = new OpTipoUsuario("loginUser");
    }
    /*Constructores*/
    
    /*Comportamiento*/
    public void login(String usuario, String password){
//        try{
//        
//        }catch(ProgramException ex){
//        
//        }catch(Exception ex){
//        
//        }
        
    }
    /*Comportamiento*/
    /*Getters y Setters*/
    
    /*Getters y Setters*/
}
