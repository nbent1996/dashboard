package Datos;

import Modelo.LogSistema;
import Modelo.Pais;
import Modelo.QueryEjecutada;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class OpPais implements IOperaciones<Pais> {

 
/*Estado*/
private static Database database;
private OpLogSistema logging;
/*Estado*/

/*Constructores*/
public OpPais(){
    this.database = Database.getInstancia();
    this.logging = new OpLogSistema();
}
/*Constructores*/

/*Comportamiento*/
    @Override
    public void guardar(Pais cAnterior, Pais c) throws Exception, SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void insertar(Pais c) throws Exception, SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void modificar(Pais cAnterior, Pais c) throws Exception, SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void borrar(Pais c) throws Exception, SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<Pais> obtenerTodos() throws Exception, SQLException {
        return buscar(null, null);
    }

    @Override
    public ArrayList<Pais> buscar(String filtro, String extras) throws Exception, SQLException {
        ArrayList<Pais> lista = new ArrayList<>();
        String codigo = "";
        String nombre = "";
        String sql = "SELECT * FROM Paises ";
        if(filtro !=null){
            sql+=filtro;
            sql+=" and eliminado='N' order by nombre asc";
        }else{
            sql+=" where eliminado='N' order by nombre asc";
        }
        ArrayList<String>listaSQL = new ArrayList<>();
        listaSQL.add(sql);
        try{
        ResultSet rs = database.consultar(sql);
        while(rs.next()){
            codigo = rs.getString("codigo");
            nombre = rs.getString("nombre");
            lista.add(new Pais(codigo, nombre));
        }
        rs.close();
        }catch(SQLException ex){
            registroConsola(listaSQL, "Búsqueda", ex.getMessage());
            throw ex;
        }catch(Exception ex){
            registroConsola(listaSQL, "Búsqueda", ex.getMessage());
            throw ex;
        }
        registroConsola(listaSQL, "Búsqueda", "NOERROR");
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

/*Getters y Setters*/

/*Getters y Setters*/


  
}
