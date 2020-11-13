package Datos;

import Modelo.Idioma;
import Modelo.LogSistema;
import Modelo.QueryEjecutada;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class OpIdioma implements IOperaciones<Idioma>{
/*Estado*/
private static Database database;
private OpLogSistema logging;
/*Estado*/

/*Constructores*/
public OpIdioma(){
    this.database = Database.getInstancia();
    this.logging = new OpLogSistema();
}
/*Constructores*/

/*Comportamiento*/
 @Override
    public void guardar(Idioma cAnterior, Idioma c) throws Exception, SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void insertar(Idioma c) throws Exception, SQLException {
        ArrayList<String> listaSQL = new ArrayList<>();
        listaSQL.add("INSERT INTO Idiomas (nombreIdioma) values ('"+c.getNombre()+"')");
        try{
            database.actualizarMultiple(listaSQL, "INSERT");
        }catch(SQLException ex){
            registroConsola(listaSQL, "Alta", ex.getMessage());
            throw ex;
        }catch(Exception ex){
            registroConsola(listaSQL, "Alta", ex.getMessage());
            throw ex;
        }
        registroConsola(listaSQL, "Alta", "NOERROR");
    }

    @Override
    public void modificar(Idioma cAnterior, Idioma c) throws Exception, SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void borrar(Idioma c) throws Exception, SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<Idioma> obtenerTodos() throws Exception, SQLException {
        return buscar(null, null);
    }

    @Override
    public ArrayList<Idioma> buscar(String filtro, String extras) throws Exception, SQLException {
        ArrayList<Idioma> lista = new ArrayList<>();
        String nombreIdioma = "";
        String sql = "SELECT * FROM Idiomas ";
        if(filtro!=null){
            sql+=filtro;
            sql+=" and eliminado='N' order by nombreIdioma ";
        }else{
            sql+=" where eliminado='N' order by nombreIdioma ";
        }
        ArrayList<String> listaSQL = new ArrayList<>();
        listaSQL.add(sql);
        try{
        ResultSet rs = database.consultar(sql);
        while(rs.next()){
            nombreIdioma = rs.getString("nombreIdioma");
            lista.add(new Idioma(nombreIdioma));
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