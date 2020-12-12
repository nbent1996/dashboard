package controlador.Interfaces;

import Modelo.Pais;
import Modelo.Persona;
import Modelo.TipoUsuario;
import java.util.ArrayList;
public interface IVistaManejoUsuarios {
    
    
    public void mensajeErrorAltaUsuarios(String texto);
    public void mensajeExitoAltaUsuarios(String texto);
    public void mostrarTiposUsuario(ArrayList<TipoUsuario> tiposUsuarios);
    public void mostrarPaises(ArrayList<Pais> paises);
 
    /*--*/
    
    public void mostrarMensajeExitoPersonaBorrada(String exitoAlBorrarUsuario);
    public void mensajeNoSeleccionasteUsuarios(String noHayUsuariosSeleccionados);
    public void mostrarTablaConUsuariosABorrar(ArrayList<Persona> listaUsuarios);

    public void mensajeErrorBajaUsuarios(String mensajeError);

    public void mensajeErrorAlBuscarUsuarios(String mensajeError);

    public void mostrarTablaUsuariosBaja(ArrayList<Persona> usuarios);
    
}
