package controlador.Interfaces;

import Modelo.TipoDispositivo;
import java.util.ArrayList;

public interface IVistaManejoDispositivos {
    public void exitoAltaDispositivo(String mensajeExitoAlta);
    public void errorAltaDispositivo(String mensajeErrorAlta);
    public void exitoAlBorrarDispositivo(String mensajeExitoBaja);
    public void errorAlBorrarDispositivo(String mensajeErrorBaja);
    public void mostrarTiposDispositivos(ArrayList<TipoDispositivo> items);
    public void errorCargaTiposDispositivos(String mensajeError); 
}
