package controlador.Interfaces;

import Modelo.Operador;
import java.util.ArrayList;

public interface IVistaInicio {
    public void mensajeError(String nombreJSP, String texto);
    public void mensajeExito(String nombreJSP, String texto);
    public Operador getOperadorLogueado();
    public void mostrarEstadisticas(ArrayList<Integer> items);
}
