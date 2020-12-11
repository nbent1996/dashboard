package controlador.Interfaces;

import Modelo.Pais;
import java.util.ArrayList;

public interface IVistaManejoClientes {
    public void mensajeError(String texto);
    public void mensajeExito(String texto);
    public void mostrarPaises(ArrayList<Pais> paises);
    public void mostrarUsuarioSistema(String usuario);
}
