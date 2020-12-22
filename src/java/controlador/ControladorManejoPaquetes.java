package controlador;

import Datos.OpPaquete;
import Datos.OpTipoDispositivo;
import Modelo.Moneda;
import Resources.DTOs.DTORangoNumerosStr;
import controlador.Interfaces.IVistaManejoPaquetes;

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
        if(idPaquete!=-1){
            filtro+=" Paquetes.idPaquete='"+idPaquete+"' AND ";
        }
        filtro+=" Paquetes.nombrePaquete LIKE '%"+nombre+"%' ";
        if(rango.esRango()){
            filtro+=" Paquetes.costoBruto BETWEEN '"+costoA+"' AND '"+costoB+"' ";
        }
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
        try{
            vista.generarTablaPaquetes("tblPaquetesPaqueteBaja", opPaquete.buscar(filtro,null), new Moneda("UYU","Pesos Uruguayos","$")); //MONEDA HARDCODEADA, OBTENERLA DESDE LA IDENTIFICACION TRIBUTARIA DE LA SESSION
        }catch(Exception ex){
            vista.mensajeError("paquete_Baja.jsp","Error al generar la tabla de paquetes de dispositivos.");
        }
    }
    /*Comportamiento*/

    public void borrarPaquetesSeleccionados(String[] listaIdPaquetes) {
        
        if(!listaIdPaquetes[0].equals("")){ //se seleccionó al menos un paquete para borrar
            //en el frontend tira todos los id de paquetes de los check en la posición [0], por eso convierto a string y luego a array para poder recorrer
            String cadena = listaIdPaquetes[0].toString();
            String[]cadenaConvertida = cadena.split(",");
            for (String idP : cadenaConvertida) { //recorro cada nombre de usuario, me traigo la persona que tiene ese usuario y lo borro                               
                try{
//                    Persona personaBuscada = opPersona.buscar(" WHERE OperadoresDashboard.usuarioSistema='" + nombreUsuario + "' ", "Modelo.Operador").get(0);
//                    opPersona.borrar(personaBuscada);
                }catch(Exception ex){
//                    vista.mensajeErrorBajaUsuarios("Ocurrió un error al borrar el usuario");
//                    System.out.println(ex.getMessage());
                }
  
            }
            //vista.mostrarMensajeExitoPersonaBorrada("Se eliminaron los usuarios: " + cadena); //devuelvo cadena que es el string que tiene los nombres de usuarios a borrar
        }else{
            //vista.mensajeNoSeleccionasteUsuarios("Debes seleccionar al menos un usuario para borrar");
        }
        
        
        
    }
    
    
    
    
}
