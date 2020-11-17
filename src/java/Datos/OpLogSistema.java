package Datos;

import Modelo.LogSistema;
import Modelo.QueryEjecutada;
import java.sql.SQLException;
import java.util.ArrayList;

public class OpLogSistema implements IOperaciones<LogSistema>{


/*Estado*/
    Database database;
/*Estado*/

/*Constructores*/
public OpLogSistema(){
    database = Database.getInstancia();
}
/*Constructores*/

/*Comportamiento*/
    @Override
    public LogSistema guardar(LogSistema cAnterior, LogSistema c) throws Exception, SQLException {
        if(cAnterior == null){
            return insertar(c);
        }else{
            return modificar(cAnterior, c);
        }
    }

    @Override
    public LogSistema insertar(LogSistema c) throws Exception, SQLException {/*Usuario Sistema hardcodeado resolver eso*/
        ArrayList<String> listaSQL  = new ArrayList();
        String sql = "INSERT INTO LogsSistema (usuarioSistema, operacion, textoError) values ('bentancor','"+c.getOperacion()+"','"+c.getTextoError()+"')";
        listaSQL.add(sql);
        for (QueryEjecutada q: c.getListaQuerys()){
            listaSQL.add("INSERT INTO QuerysEjecutadas (idLog, textoQuery) values (?, '"+q.getTextoQuery()+"')");
        }
        database.actualizarMultiple(listaSQL, "INSERT");
        return new LogSistema(-1);
    }

    @Override
    public LogSistema modificar(LogSistema cAnterior, LogSistema c) throws Exception, SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public LogSistema borrar(LogSistema c) throws Exception, SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<LogSistema> obtenerTodos() throws Exception, SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<LogSistema> buscar(String filtro, String extras) throws Exception, SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public LogSistema borradoMultiplePorIds(ArrayList<Integer> listaIds) throws Exception, SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public LogSistema registroConsola(String usuarioSistema, ArrayList<String> listaSQL, String operacion, String textoError) {
        throw new UnsupportedOperationException("Not supported yet."); //Objeto no Auditado
    }
/*Comportamiento*/

/*Getters y Setters*/

/*Getters y Setters*/
}
