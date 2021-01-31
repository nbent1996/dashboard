package controlador;

import Datos.OpImagen;
import Datos.OpPersona;
import controlador.Interfaces.IVistaInicio;

public class ControladorInicio {
/*Estado*/
private IVistaInicio vista;
private OpImagen opImagen;
private OpPersona opPersona;

/*Estado*/

/*Constructores*/
public ControladorInicio(IVistaInicio vista){
    this.vista = vista;
    this.opImagen = new OpImagen(vista.getOperadorLogueado());
    this.opPersona = new OpPersona(vista.getOperadorLogueado());
}
/*Constructores*/

/*Comportamiento*/
    public void obtenerEstadisticas(){
        
    }
/*Comportamiento*/

/*Getters y Setters*/

/*Getters y Setters*/
}
