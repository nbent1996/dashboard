package controlador.Interfaces;

import Modelo.Moneda;
import Modelo.Paquete;
import java.util.ArrayList;

public interface IVistaManejoSuscripciones {
    public void mensajeError(String texto);
    public void mensajeExito(String texto);
    public void generarTablaPaquetes(ArrayList<Paquete> items, Moneda moneda);
}
