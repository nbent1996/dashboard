package Datos;

import Modelo.LogSistema;
import Modelo.Pais;
import Modelo.QueryEjecutada;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class OpPais implements IOperaciones<Pais> {

 
/*Estado*/
public static Database database;
/*Estado*/

/*Constructores*/
public OpPais(){
    this.database = Database.getInstancia();
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
        ResultSet rs = database.consultar(sql);
        while(rs.next()){
            codigo = rs.getString("codigo");
            nombre = rs.getString("nombre");
            lista.add(new Pais(codigo, nombre));
        }
        rs.close();
        ArrayList<String>listaSQL = new ArrayList<>();
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
