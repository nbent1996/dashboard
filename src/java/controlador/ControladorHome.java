package controlador;

import controlador.Interfaces.IVistaHome;
import Datos.OpImagen;
import Datos.OpPersona;

public class ControladorHome {
/*Estado*/
private IVistaHome vista;
private OpImagen opImagen;
private OpPersona opPersona;

/*Estado*/

/*Constructores*/
public ControladorHome(IVistaHome vista){
    this.vista = vista;
    this.opImagen = new OpImagen("bentancor");
    this.opPersona = new OpPersona("bentancor");
}
/*Constructores*/

/*Comportamiento*/
    
/*Comportamiento*/

/*Getters y Setters*/

/*Getters y Setters*/
}
