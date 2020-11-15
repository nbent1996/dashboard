package Datos;

import Modelo.LogSistema;
import Modelo.Privilegio;
import Modelo.QueryEjecutada;
import Modelo.TipoUsuario;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;

public class OpTiposUsuarios implements IOperaciones<TipoUsuario> {

  
/*Estado*/
private static Database database;
private OpLogSistema logging;
/*Estado*/

/*Constructores*/
public OpTiposUsuarios(){
    this.database = Database.getInstancia();
    this.logging = new OpLogSistema();
}
/*Constructores*/

/*Comportamiento*/
  @Override
    public void guardar(TipoUsuario cAnterior, TipoUsuario c) throws Exception, SQLException {
        if(cAnterior == null){
            insertar(c);
        }else{
            modificar(cAnterior, c);
        }
    }

    @Override
    public void insertar(TipoUsuario c) throws Exception, SQLException {
        ArrayList<String> listaSQL = new ArrayList<>();
        listaSQL.add("INSERT INTO TiposUsuarios (nombre) values ('"+c.getNombre()+"')");
        if(!c.getListaPrivilegios().isEmpty()){
            for(Privilegio p : c.getListaPrivilegios()){
                listaSQL.add("INSERT INTO TieneTUP (nombreTipoUsuario, nombrePrivilegio) values ('"+c.getNombre()+"','"+p.getNombrePrivilegio()+"')");
            }
        }
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
    public void modificar(TipoUsuario cAnterior, TipoUsuario c) throws Exception, SQLException {
        //Solo modifica la lista de privilegios de ese tipo de usuario y no el nombre del tipo de usuario.
        ArrayList<String> listaSQL = new ArrayList<>();
        if(listasSonIguales(cAnterior.getListaPrivilegios(), c.getListaPrivilegios())){
            return;
        }
//        if(!c.getNombre().equals(cAnterior.getNombre())){
//        listaSQL.add("UPDATE TiposUsuarios SET nombre='"+c.getNombre()+"' WHERE nombre='"+cAnterior.getNombre()+"' AND nombre not in(select nombre from TiposUsuario)");
//        }
        
        listaSQL.add("DELETE FROM TieneTUP WHERE nombreTipoUsuario='"+c.getNombre()+"' ");
        for(Privilegio p: c.getListaPrivilegios()){
            listaSQL.add("INSERT INTO TieneTUP (nombreTipoUsuario, nombrePrivilegio) VALUES ('"+c.getNombre()+"','"+p.getNombrePrivilegio()+"')");
        }
           
    }

    @Override
    public void borrar(TipoUsuario c) throws Exception, SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<TipoUsuario> obtenerTodos() throws Exception, SQLException {
        return buscar(null,null);
    }

    @Override
    public ArrayList<TipoUsuario> buscar(String filtro, String extras) throws Exception, SQLException {
          ArrayList<TipoUsuario> lista = new ArrayList<>();
        String nombreTipoUsuario = "";
        String sql = "SELECT * FROM TiposUsuarios ";
        if(filtro!=null){
            sql+=filtro;
            sql+=" and eliminado='N' order by nombre ";
        }else{
            sql+=" where eliminado='N' order by nombre ";
        }
        ArrayList<String> listaSQL = new ArrayList<>();
        listaSQL.add(sql);
        try{
        ResultSet rs = database.consultar(sql);
        while(rs.next()){
            nombreTipoUsuario = rs.getString("nombre");
            lista.add(new TipoUsuario(nombreTipoUsuario));
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
    public  boolean listasSonIguales(ArrayList<Privilegio> a, ArrayList<Privilegio> b){     
    // comprobar que tienen el mismo tamaño y que no son nulos
    if ((a.size() != b.size()) || (a == null && b!= null) || (a != null && b== null)){
        return false;
    }

    if (a == null && b == null) return true;

    // ordenar las ArrayList y comprobar que son iguales          
    Collections.sort(a);
    Collections.sort(b);
    return a.equals(b);
}
/*Comportamiento*/

/*Getters y Setters*/

/*Getters y Setters*/
}
