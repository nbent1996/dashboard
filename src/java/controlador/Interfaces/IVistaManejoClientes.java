package controlador.Interfaces;

import Modelo.Pais;
import java.util.ArrayList;

public interface IVistaManejoClientes {
    public void exitoAltaCliente(String mensajeExitoAlta);
    public void errorAltaCliente(String mensajeErrorAlta);
    public void exitoAlBorrarCliente(String mensajeExitoBaja);
    public void errorAlBorrarCliente(String mensajeErrorBaja);
    public void mostrarPaises(ArrayList<Pais> paises);
    public void errorCargaPaises(String mensajeError);   
}
