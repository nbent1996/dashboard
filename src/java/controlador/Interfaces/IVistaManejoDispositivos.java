package controlador.Interfaces;

import Modelo.Categoria;
import Modelo.TipoDispositivo;
import java.util.ArrayList;

public interface IVistaManejoDispositivos {
    public void mensajeError(String texto);
    public void mensajeExito(String texto);
    public void mostrarTiposDispositivos(ArrayList<TipoDispositivo> items);
    public void mostrarCategorias(ArrayList<Categoria> items);

}
