package controlador.Interfaces;

import Modelo.Moneda;
import Modelo.Paquete;
import Modelo.Suscripcion;
import java.util.ArrayList;

public interface IVistaManejoSuscripciones {
    public void mensajeError(String nombreJSP, String texto);
    public void mensajeExito(String nombreJSP, String texto);
    public void generarTablaPaquetes(String idTabla, ArrayList<Paquete> items, Moneda moneda);
    public void generarTablaSuscripciones(String idTabla, ArrayList<Suscripcion> items);
}
