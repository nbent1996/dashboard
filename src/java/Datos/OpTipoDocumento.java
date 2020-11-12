package Datos;

import Modelo.LogSistema;
import Modelo.QueryEjecutada;
import Modelo.TipoDocumento;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class OpTipoDocumento implements IOperaciones<TipoDocumento> {
    /*Estado*/
    private static Database database;
    private OpLogSistema logging; 
    /*Estado*/
    
    /*Constructores*/
    public OpTipoDocumento(){
        this.database = Database.getInstancia();
        this.logging = new OpLogSistema();
    }
    /*Constructores*/
    
    /*Comportamiento*/
    @Override
    public void guardar(TipoDocumento cAnterior, TipoDocumento c) throws Exception, SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void insertar(TipoDocumento c) throws Exception, SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void modificar(TipoDocumento cAnterior, TipoDocumento c) throws Exception, SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void borrar(TipoDocumento c) throws Exception, SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<TipoDocumento> obtenerTodos() throws Exception, SQLException {
        return buscar(null, null);
    }

    @Override
    public ArrayList<TipoDocumento> buscar(String filtro, String extras) throws Exception, SQLException {
        ArrayList<TipoDocumento> lista = new ArrayList <>();
        String codDocumento = "";
        String nombreDocumento = "";
        String sql = "SELECT * FROM TiposDocumentos";
        if(filtro!=null){
            sql+=filtro;
            sql+=" and eliminado='N' order by nombreDocumento asc ";
        }else{
            sql+=" where eliminado='N' order by nombreDocumento asc ";
        }
        ResultSet rs = database.consultar(sql);
        while(rs.next()){
            codDocumento = rs.getString("codDocumento");
            nombreDocumento = rs.getString("nombreDocumento");
            lista.add(new TipoDocumento(codDocumento, nombreDocumento));
        }
        rs.close();
        ArrayList<String> listaSQL = new ArrayList<>();
        listaSQL.add(sql);
        registroConsola(listaSQL,"Búsqueda", "NOERROR");
        return lista;
    }

    @Override
    public boolean existsAllID(ArrayList<Integer> lista) throws Exception, SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean borradoMultiplePorIds(ArrayList<Integer> listaIds) throws Exception, SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void registroConsola(ArrayList<String> listaSQL, String operacion, String textoError) throws Exception, SQLException {
        LogSistema log = new LogSistema(-1, operacion, textoError, new ArrayList<>());
        
        System.out.println("----------------------------------");
        for (String sentencia : listaSQL) {
            log.getListaQuerys().add(new QueryEjecutada(sentencia));
            System.out.println(sentencia);
        }
        logging.insertar(log);
        System.out.println("----------------------------------");
        /*Evidencia en consola*/  
    }
    /*Comportamiento*/





    
}
