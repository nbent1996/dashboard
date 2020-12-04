/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador.Interfaces;

import Modelo.Pais;
import Modelo.TipoUsuario;
import java.util.ArrayList;

/**
 *
 * @author Andres
 */
public interface IVistaManejoUsuarios {
    

    public void exitoAltaUsuario(String mensajeExitoAlta);

    public void errorAltaUsuario(String mensajeErrorAlta);

    public void exitoAlBorrarUsuario(String mensajeExitoBaja);

    public void errorAlBorrarUsuario(String mensajeErrorBaja);

    public void mostrarTiposUsuario(ArrayList<TipoUsuario> tiposUsuarios);

    public void mostrarPaises(ArrayList<Pais> paises);

    public void errorCargaTiposUsuarios(String mensajeError);

    public void errorCargaPaises(String mensajeError);
    
    
    
}
