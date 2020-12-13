package controlador;

import Datos.OpCategoria;
import Datos.OpDispositivo;
import Datos.OpTipoDispositivo;
import controlador.Interfaces.IVistaManejoDispositivos;
import controlador.Interfaces.IControlador;
import Modelo.Dispositivo;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;

public class ControladorManejoDispositivos implements IControlador<Dispositivo>{
    /*Estado*/
    private IVistaManejoDispositivos vista;
    private OpDispositivo opDispositivo;
    private OpTipoDispositivo opTipoDispositivo;
    private OpCategoria opCategoria;
    /*Estado*/
    
    /*Constructores*/
    public ControladorManejoDispositivos(IVistaManejoDispositivos vista) {
        this.vista = vista;
        this.opDispositivo = new OpDispositivo("bentancor");
        this.opTipoDispositivo = new OpTipoDispositivo("bentancor");
        this.opCategoria = new OpCategoria("bentancor");
    }
    /*Constructores*/
    
    /*Comportamiento*/
        public void cargarTiposDispositivos() {
            try{
                //vista.mostrarTiposDispositivos(opTipoDispositivo.buscar(" WHERE nombreCategoria='"+categoria+"' ",null));
                vista.mostrarTiposDispositivos(opTipoDispositivo.obtenerTodos());
            }catch(Exception ex){
                vista.mensajeError("dispositivo_Alta.jsp","Error en la carga de tipos de dispositivos.");
            }
        }
        public void cargarCategorias(){
            try{
                vista.mostrarCategorias(opCategoria.obtenerTodos());
            }catch(Exception ex){
                vista.mensajeError("dispositivo_Alta.jsp","Error en la carga de categorias.");
            }
        }
    /*Comportamiento*/
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    @Override
    public void cargarItems(Dispositivo c, DefaultTableModel modelo) throws Exception, SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String getFiltroProcesado(Dispositivo c, DefaultTableModel modelo) throws Exception, SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void borrarItems(ArrayList<Dispositivo> items) throws Exception, SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }


    
}
