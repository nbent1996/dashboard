package controlador.Interfaces;

import Modelo.Pais;
import Modelo.Persona;
import Modelo.TipoUsuario;
import java.util.ArrayList;
public interface IVistaManejoUsuarios {
    public void mensajeError(String texto);
    public void mensajeExito(String texto);
    public void mostrarTiposUsuario(ArrayList<TipoUsuario> tiposUsuarios);
    public void mostrarPaises(ArrayList<Pais> paises);
 
    /*--*/
    public void mensajeErrorAlBorrarPersona(String errorAlBorrarUsuario);
    public void mostrarMensajeExitoPersonaBorrada(String exitoAlBorrarUsuario);
    public void mensajeNoSeleccionasteUsuarios(String noHayUsuariosSeleccionados);
    public void pruebaMostrarTablaBorrarUsuario(ArrayList<Persona> aux);
    
}
