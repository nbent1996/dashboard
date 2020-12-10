package controlador.Interfaces;

import Modelo.Pais;
import Modelo.Persona;
import Modelo.TipoUsuario;
import java.util.ArrayList;
public interface IVistaManejoUsuarios {
    
    public void exitoAltaUsuario(String mensajeExitoAlta);
    public void errorAltaUsuario(String mensajeErrorAlta);
    public void exitoAlBorrarUsuario(String mensajeExitoBaja);
    public void errorAlBorrarUsuario(String mensajeErrorBaja);
    public void mostrarTiposUsuario(ArrayList<TipoUsuario> tiposUsuarios);
    public void mostrarPaises(ArrayList<Pais> paises);
    public void errorCargaTiposUsuarios(String mensajeError);
    public void errorCargaPaises(String mensajeError);
    public void pruebaMostrarTablaBorrarUsuario(ArrayList<Persona> aux);
    
    
    
}
