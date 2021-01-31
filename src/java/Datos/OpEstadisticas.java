package Datos;

import Modelo.LogSistema;
import Modelo.Operador;
import Modelo.QueryEjecutada;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class OpEstadisticas {
/*Estado*/
private static Database database;
private OpLogSistema logging;
private Operador usuarioSistema;
/*Estado*/

/*Constructores*/
public OpEstadisticas(Operador usuarioSistema){
    this.database = Database.getInstancia();
    this.usuarioSistema = usuarioSistema;
    this.logging = new OpLogSistema(this.usuarioSistema);
}
/*Constructores*/

/*Comportamiento*/
    public ArrayList<Integer> getEstadisticasInicioA() throws Exception, SQLException {
        ArrayList<Integer> lista = new ArrayList<>();
        ArrayList<String> listaSQL = new ArrayList<>();
        try {
            listaSQL.add("select count(*) from Personas, Clientes WHERE Personas.usuarioSistema = Clientes.usuarioSistema AND Personas.identificacionTributaria='"+usuarioSistema.getEmpresaAsociada().getIdentificacionTributaria()+"'");
            listaSQL.add("");
            listaSQL.add("");
            listaSQL.add("");
           
            for(String query : listaSQL){
            ResultSet rs = database.consultar(query);
            rs.next();
            lista.add(rs.getInt(""));
            }
            
        } catch (SQLException ex) {
            registroConsola(this.usuarioSistema.getUsuarioSistema(), listaSQL, "Búsqueda", ex.getMessage());
            throw ex;
        } catch (Exception ex) {
            registroConsola(this.usuarioSistema.getUsuarioSistema(), listaSQL, "Búsqueda", ex.getMessage());
            throw ex;
        }
        
        return lista;

    }
    public LogSistema registroConsola(String usuarioSistema, ArrayList<String> listaSQL, String operacion, String textoError) throws Exception, SQLException {
        LogSistema log = new LogSistema(usuarioSistema, operacion, textoError, new ArrayList<>());
        System.out.println("----------------------------------");
        System.out.println("Usuario: " + usuarioSistema + "\nOperación: " + operacion + "\nTexto Error: " + textoError);
        System.out.println("Listado de Sentencias SQL:");
        for (String sentencia : listaSQL) {
            log.getListaQuerys().add(new QueryEjecutada(sentencia));
            System.out.println(sentencia);
        }
        logging.insertar(log);
        System.out.println("----------------------------------");
        /*Evidencia en consola*/
        return log;
    }
/*Comportamiento*/

/*Getters y Setters*/

/*Getters y Setters*/
}
