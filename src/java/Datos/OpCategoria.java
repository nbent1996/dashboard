package Datos;

import Modelo.Categoria;
import Modelo.LogSistema;
import Modelo.QueryEjecutada;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class OpCategoria implements IOperaciones<Categoria>{
/*Estado*/
public static Database database;
/*Estado*/

/*Constructores*/
public OpCategoria(){
    this.database = Database.getInstancia();
}
/*Constructores*/

/*Comportamiento*/
 @Override
    public void guardar(Categoria cAnterior, Categoria c) throws Exception, SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void insertar(Categoria c) throws Exception, SQLException {
        ArrayList<String> listaSQL = new ArrayList<>();
        listaSQL.add("INSERT INTO Categorias (nombreCategoria) values ('"+c.getNombreCategoria()+"')");
        database.actualizarMultiple(listaSQL, "INSERT");
        registroConsola(listaSQL, "Alta", "NOERROR");
    }

    @Override
    public void modificar(Categoria cAnterior, Categoria c) throws Exception, SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void borrar(Categoria c) throws Exception, SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<Categoria> obtenerTodos() throws Exception, SQLException {
        return buscar(null, null);
    }

    @Override
    public ArrayList<Categoria> buscar(String filtro, String extras) throws Exception, SQLException {
        ArrayList<Categoria> lista = new ArrayList<>();
        String nombreCategoria = "";
        String sql = "SELECT * FROM Categorias ";
        if(filtro!=null){
            sql+=filtro;
            sql+=" and eliminado='N' order by nombreCategoria ";
        }else{
            sql+=" where eliminado='N' order by nombreCategoria ";
        }
        ResultSet rs = database.consultar(sql);
        while(rs.next()){
            nombreCategoria = rs.getString("nombreCategoria");
            lista.add(new Categoria(nombreCategoria));
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
