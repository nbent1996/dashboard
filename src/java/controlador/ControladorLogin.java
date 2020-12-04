package controlador;

<<<<<<< HEAD
import controlador.Interfaces.IVistaLogin;
=======
import Datos.OpImagen;
>>>>>>> 487b4912505212024703fb0c6d93f730b9e0c364
import Datos.OpPersona;
import Datos.OpTipoUsuario;
import Modelo.Operador;

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
        this.opPersona = new OpPersona("loginUser");
        this.opTipoUsuario = new OpTipoUsuario("loginUser");
        this.opImagen = new OpImagen("loginUser");
        
    }
    /*Constructores*/
    
    /*Comportamiento*/
<<<<<<< HEAD
    
    
    
    public void login(String nombreUsuario, String password) {
        
        
        try {//matchea datos correctamente
            Operador operadorLogin = (Operador) opPersona.buscar(" WHERE Operadores.usuarioSistema='"+nombreUsuario+"' AND Operadores.clave=SHA('"+password+"') " , "Modelo.Operador").get(0);  
            vista.permitirAcceso(operadorLogin); //ver como manejar el acceso dependiendo del tipo de usuario (lista de privilegios)
            
        } catch (Exception ex) { //no encontró datos en BD
            vista.denegarAcceso("Usuario y/o contraseña incorrectos.");
        }
=======
    public void login(String usuario, String password){
//        try{
//        
//        }catch(ProgramException ex){
//        
//        }catch(Exception ex){
//        
//        }
>>>>>>> e08c26aa95f7516e3d9bc38101ddc7ae22e8f22b
        
        
        
        
        
        //LLEVARME A LA BASE DE DATOS LOS DATOS PARA VER SI COINCIDEN CON LOS INGRESADOS
        //PERMITIR ACCESO Y GUARDAR EL USUARIO EN LA SESSION O DENEGAR Y MOSTRAR MENSAJE
        
        
        
        
    }
    
    
    
    
    /*Comportamiento*/
    /*Getters y Setters*/
    
    /*Getters y Setters*/

    
}
