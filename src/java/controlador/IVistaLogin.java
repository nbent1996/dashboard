package controlador;

import Modelo.Operador;

public interface IVistaLogin {
    
    
    public void mostrarError(String textoError);

    public void permitirAcceso(Operador operadorLogin);

    public void denegarAcceso(String mensajeError);
    
}
