package controlador.Interfaces;

import Modelo.Operador;

public interface IVistaInicio {
    public void mensajeError(String nombreJSP, String texto);
    public void mensajeExito(String nombreJSP, String texto);
    public Operador getOperadorLogueado();
}
