package controlador.Interfaces;

import Modelo.Moneda;
import Modelo.Paquete;
import java.util.ArrayList;

public interface IVistaManejoSuscripciones {
    public void mensajeError(String nombreJSP, String texto);
    public void mensajeExito(String nombreJSP, String texto);
    public void generarTablaPaquetes(ArrayList<Paquete> items, Moneda moneda);
}
