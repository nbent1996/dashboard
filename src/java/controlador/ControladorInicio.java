package controlador;

import Datos.OpEstadisticas;
import Datos.OpImagen;
import Datos.OpPersona;
import Modelo.Operador;
import controlador.Interfaces.IVistaInicio;
import java.sql.SQLException;
import java.util.ArrayList;

public class ControladorInicio {
/*Estado*/
private IVistaInicio vista;
private OpImagen opImagen;
private OpPersona opPersona;
private OpEstadisticas opEstadisticas;

/*Estado*/

/*Constructores*/
public ControladorInicio(IVistaInicio vista, Operador operadorLogueado){
    this.vista = vista;
    this.opImagen = new OpImagen(operadorLogueado);
    this.opPersona = new OpPersona(operadorLogueado);
    //this.opEstadisticas = new OpEstadisticas(operadorLogueado);
}
/*Constructores*/

/*Comportamiento*/
    public void obtenerEstadisticasA() throws Exception, SQLException{ /*Estadisticas para los 4 recuadros celestes*/
        ArrayList<Integer> lista = opEstadisticas.getEstadisticasInicioA();
        /*Se generó el OpEstadisticas para hacer estas query, el metodo de la linea anterior retorna un arraylist con los 4 numeros siendo los siguientes cada uno de ellos:
            0 -  Clientes registrados
            1 -  Cuentas secundarias
            2 -  Dispositivos registrados
            3 -  Suscripciones activas
        De acá en adelante hay que ver como meterlo en el frontend.
        */
        
        if(lista!=null){
            vista.mostrarEstadisticas(lista);
        }
        
    }
    public void obtenerEstadisticasB() throws Exception, SQLException{
        
    }
    public void obtenerEstadisticasC() throws Exception, SQLException{
        
    }
    public void obtenerEstadisticasD() throws Exception, SQLException{
        
    }
    
/*Comportamiento*/

/*Getters y Setters*/

/*Getters y Setters*/
}
