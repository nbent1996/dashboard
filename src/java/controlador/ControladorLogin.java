package controlador;

import controlador.Interfaces.IVistaLogin;
import Datos.OpImagen;
import Datos.OpPersona;
import Datos.OpTipoUsuario;
import Modelo.Empresa;
import Modelo.Operador;
import Modelo.Pais;
import Modelo.TipoUsuario;

public class ControladorLogin {
    /*Estado*/
    private IVistaLogin vista;
    private OpPersona opPersona;
    private OpTipoUsuario opTipoUsuario;
    private OpImagen opImagen;
    /*Estado*/
    /*Constructores*/
    public ControladorLogin(IVistaLogin vista){
        this.vista = vista;
        this.opPersona = new OpPersona(new Operador("loginUser", "Bot", new Empresa("526283747346"),new Pais("URU"),new TipoUsuario("administrador"), "Masculino"));
        this.opTipoUsuario = new OpTipoUsuario(new Operador("loginUser", "Bot", new Empresa("526283747346"),new Pais("URU"),new TipoUsuario("administrador"), "Masculino"));
        this.opImagen = new OpImagen(new Operador("loginUser", "Bot", new Empresa("526283747346"),new Pais("URU"),new TipoUsuario("administrador"), "Masculino"));
        
    }
    /*Constructores*/
    
    /*Comportamiento*/
    
    
    
    public void login(String nombreUsuario, String password) {
        
        
        try {//matchea datos correctamente
            Operador operadorLogin = (Operador) opPersona.buscar(" WHERE OperadoresDashboard.usuarioSistema='"+nombreUsuario+"' AND OperadoresDashboard.clave=SHA('"+password+"') " , "Modelo.Operador").get(0);  
            vista.permitirAcceso(operadorLogin); //ver como manejar el acceso dependiendo del tipo de usuario (lista de privilegios)
            
        } catch (Exception ex) { //no encontró datos en BD
            vista.denegarAcceso("Usuario y/o contraseña incorrectos.");
        }
        //LLEVARME A LA BASE DE DATOS LOS DATOS PARA VER SI COINCIDEN CON LOS INGRESADOS
        //PERMITIR ACCESO Y GUARDAR EL USUARIO EN LA SESSION O DENEGAR Y MOSTRAR MENSAJE
    }
    
    
    
    
    /*Comportamiento*/
    /*Getters y Setters*/
    
    /*Getters y Setters*/

    
}
