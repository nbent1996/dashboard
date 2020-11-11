package Datos;

import Modelo.LogSistema;
import Modelo.Moneda;
import Modelo.QueryEjecutada;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class OpMonedas implements IOperaciones<Moneda> {
/*Estado*/
private static Database database;
/*Estado*/

/*Constructores*/
public OpMonedas(){
    this.database = Database.getInstancia();
}
/*Constructores*/

/*Comportamiento*/
 @Override
    public void guardar(Moneda cAnterior, Moneda c) throws Exception, SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void insertar(Moneda c) throws Exception, SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void modificar(Moneda cAnterior, Moneda c) throws Exception, SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void borrar(Moneda c) throws Exception, SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<Moneda> obtenerTodos() throws Exception, SQLException {
        return buscar(null,null);
    }

    @Override
    public ArrayList<Moneda> buscar(String filtro, String extras) throws Exception, SQLException {
        ArrayList<Moneda> lista = new ArrayList<>();
        String codigo = "";
        String nombreMoneda = "";
        String simbolo = "";
        String sql = "SELECT * FROM Monedas ";
        if(filtro!=null){
            sql+=filtro;
            sql+=" where eliminado='N' order by nombreMoneda "; 
        }else{
            sql+=" where eliminado='N' order by nombreMoneda ";
        }
        ResultSet rs = database.consultar(sql);
        while(rs.next()){
            codigo = rs.getString("codigo");
            nombreMoneda = rs.getString("nombreMoneda");
            simbolo = rs.getString("simbolo");
            lista.add(new Moneda(codigo, nombreMoneda,simbolo));
        }
        rs.close();
         ArrayList<String> listaSQL = new ArrayList<>();
         listaSQL.add(sql);
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
    public void registroConsola(ArrayList<String> listaSQL, String operacion, String textoError) {
        LogSistema log = new LogSistema(-1, operacion, textoError, new ArrayList<QueryEjecutada>());
        
        System.out.println("----------------------------------");
        for (String sentencia : listaSQL) {
            log.getListaQuerys().add(new QueryEjecutada(sentencia));
            System.out.println(sentencia);
        }
        System.out.println("----------------------------------");
        /*Evidencia en consola*/  
    }
/*Comportamiento*/

/*Getters y Setters*/

/*Getters y Setters*/

   
}
