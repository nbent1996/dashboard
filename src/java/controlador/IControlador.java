package controlador;

import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;

public interface IControlador<T> {
    public void cargarItems(T c, DefaultTableModel modelo) throws Exception, SQLException;
    public String getFiltroProcesado(T c, DefaultTableModel modelo) throws Exception, SQLException;
    public void borrarItems(ArrayList<T> items) throws Exception, SQLException;
    
    
}
