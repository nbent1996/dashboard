package controlador.Interfaces;

import Modelo.Pais;
import Modelo.TipoDocumento;
import java.util.ArrayList;

public interface IVistaManejoClientes {
    public void mensajeError(String nombreJSP, String texto);
    public void mensajeExito(String nombreJSP, String texto);
    public void mostrarPaises(ArrayList<Pais> paises);
    public void mostrarTiposDocumento(ArrayList<TipoDocumento> tiposDocumento);
    public void mostrarUsuarioSistema(String usuario);
}
