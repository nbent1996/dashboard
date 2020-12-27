package controlador;

import Datos.OpPaquete;
import Datos.OpTipoDispositivo;
import Modelo.Moneda;
import Modelo.Paquete;
import Resources.DTOs.DTORangoNumerosStr;
import controlador.Interfaces.IVistaManejoPaquetes;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ControladorManejoPaquetes {
    /*Estado*/
    private IVistaManejoPaquetes vista;
    private OpPaquete opPaquete;
    private OpTipoDispositivo opTipoDispositivo;
    /*Estado*/
    
    /*Constructores*/
    public ControladorManejoPaquetes(IVistaManejoPaquetes vista){
        this.vista = vista;
        this.opPaquete = new OpPaquete("bentancor");
        this.opTipoDispositivo = new OpTipoDispositivo("bentancor");
    }
    /*Constructores*/
    
    /*Comportamiento*/
    public String getFiltroProcesado(int idPaquete, String nombre, String costoA, String costoB){
        String filtro = " WHERE ";
        DTORangoNumerosStr rango = new DTORangoNumerosStr(costoA, costoB);
        if(idPaquete!=-1){//si se ingresó un idPaquete en el filtro
            filtro+=" Paquetes.idPaquete='"+idPaquete+"' AND ";
        }
        filtro+=" Paquetes.nombrePaquete LIKE '%"+nombre+"%' AND ";
<<<<<<< HEAD
        if(rango.esRango()){
=======
        if(rango.esRango()){//si se ingresaron costoA y costoB
>>>>>>> 0bf2b5bb3c840412050a305d332be0176762239e
            filtro+=" Paquetes.costoBruto BETWEEN '"+costoA+"' AND '"+costoB+"' ";
        }else{//entra acá si alguno de los costos no se ingresó o si los dos vienen vacios (si los dos vienen vacios, no entra a ninguno de los ifs)
            if(!costoA.equals("")){//si se ingresó un costoA
                filtro+=" Paquetes.costoBruto > '"+costoA+"'";
            }
            if(!costoB.equals("")){//si se ingresó un costoB
                filtro+=" Paquetes.costoBruto < '"+costoB+"'";
            }
        }
        
        if(filtro.endsWith("AND ")){
            filtro = filtro.substring(0, filtro.length()-5);
        }
<<<<<<< HEAD
        if (filtro.endsWith("AND ")) {
            filtro = filtro.substring(0, filtro.length() - 5);
        }
=======
        
>>>>>>> 0bf2b5bb3c840412050a305d332be0176762239e
        if(filtro.equals(" WHERE ")){
            filtro=null;
        }
        return filtro;
    }
    
    public void generarTablaTiposDispositivos(){
        try{
            vista.generarTablaTiposDispositivos("tblTiposDispositivosPaqueteAlta", opTipoDispositivo.obtenerTodos());
        }catch(Exception ex){
            vista.mensajeError("paquete_Alta.jsp", "Error al generar la tabla de tipos de dispositivos.\n");
        }
    }
    public void generarTablaPaquetes(String filtro){
        ArrayList<Paquete> paquetesFiltrados = new ArrayList();
        try{
            paquetesFiltrados = opPaquete.buscar(filtro, null);
            vista.generarTablaPaquetes("tblPaquetesPaqueteBaja", paquetesFiltrados, new Moneda("UYU","Pesos Uruguayos","$")); //MONEDA HARDCODEADA, OBTENERLA DESDE LA IDENTIFICACION TRIBUTARIA DE LA SESSION
        }catch(Exception ex){
            vista.mensajeError("paquete_BajaModificacion.jsp","Error al generar la tabla de paquetes de dispositivos.");
        }
    }
    /*Comportamiento*/

    public void borrarPaquetesSeleccionados(String[] listaIdPaquetes) {
        
        String nombresPaqBorrados = "";
        
        if(!listaIdPaquetes[0].equals("")){ //se seleccionó al menos un paquete para borrar
            //en el frontend tira todos los id de paquetes de los check en la posición [0], por eso convierto a string y luego a array para poder recorrer
            String cadena = listaIdPaquetes[0].toString();
            String[]cadenaConvertida = cadena.split(",");
            for (String idP : cadenaConvertida) {                               
                try{
                    Paquete paqueteABorrar = opPaquete.buscar(" WHERE Paquetes.idPaquete='" + idP + "' ", null).get(0);
                    opPaquete.borrar(paqueteABorrar);
                    nombresPaqBorrados+=paqueteABorrar.getNombre() + "  -";
                }catch(Exception ex){
                    vista.mensajeErrorBajaPaquetes("Ocurrió un error al borrar el paquete");
                }
  
            }
            vista.mostrarMensajeExitoPaqueteBorrado("Se eliminaron los paquetes: " + nombresPaqBorrados);
        }else{
            vista.mensajeNoSeleccionastePaquetes("Debes seleccionar al menos un paquete para borrar");
        }
        
        
        
    }

    public void cargarTablaPaquetesBajaInicio() {
        
        ArrayList<Paquete> paquetes = new ArrayList();
        
        try {
            paquetes = opPaquete.obtenerTodos();
            vista.generarTablaPaquetes("tblPaquetesPaqueteBaja", paquetes, new Moneda("UYU","Pesos Uruguayos","$")); //MONEDA HARDCODEADA, OBTENERLA DESDE LA IDENTIFICACION TRIBUTARIA DE LA SESSION
        } catch (Exception ex) {
            vista.mensajeError("paquetes_Baja.jsp", "Error en la carga de paquetes");
        }
        
        
    }
    
    
    
    
}
