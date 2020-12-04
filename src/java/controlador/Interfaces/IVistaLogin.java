<<<<<<< HEAD:src/java/controlador/Interfaces/IVistaLogin.java
package controlador.Interfaces;
=======
package controlador;

import Modelo.Operador;

>>>>>>> 487b4912505212024703fb0c6d93f730b9e0c364:src/java/controlador/IVistaLogin.java
public interface IVistaLogin {
    
    
    public void mostrarError(String textoError);

    public void permitirAcceso(Operador operadorLogin);

    public void denegarAcceso(String mensajeError);
    
}
