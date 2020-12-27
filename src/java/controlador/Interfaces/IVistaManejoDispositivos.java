package controlador.Interfaces;

import Modelo.Categoria;
import Modelo.Dispositivo;
import Modelo.TipoDispositivo;
import java.util.ArrayList;

public interface IVistaManejoDispositivos {
    public void mensajeError(String nombreJSP, String texto);
    public void mensajeExito(String nombreJSP, String texto);
    public void mostrarTiposDispositivos(ArrayList<TipoDispositivo> items);
    public void mostrarCategorias(ArrayList<Categoria> items);
    public void generarTablaDispositivos(String idTabla, ArrayList<Dispositivo> items);

    public void mensajeErrorBajaDispositivos(String errorBorradoDisp);

    public void mostrarMensajeExitoDispositivoBorrado(String exitoAlBorrarDisp);

    public void mensajeNoSeleccionasteDispositivos(String noSelecDisp);
}
