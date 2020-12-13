package controlador.Interfaces;

import Modelo.TipoDispositivo;
import java.util.ArrayList;

public interface IVistaManejoPaquetes {
    public void mensajeError(String nombreJSP, String texto);
    public void mensajeExito(String nombreJSP, String texto);
    public void generarTablaTiposDispositivos(ArrayList<TipoDispositivo> items);
}
