package controlador.Interfaces;

import Modelo.Moneda;
import Modelo.Paquete;
import Modelo.TipoDispositivo;
import java.util.ArrayList;

public interface IVistaManejoPaquetes {
    public void mensajeError(String nombreJSP, String texto);
    public void mensajeExito(String nombreJSP, String texto);
    public void generarTablaTiposDispositivos(String idTabla, ArrayList<TipoDispositivo> items);
    public void generarTablaPaquetes(String idTabla, ArrayList<Paquete> items, Moneda moneda);
}
