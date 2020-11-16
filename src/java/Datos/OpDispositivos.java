package Datos;

import Modelo.Cliente;
import Modelo.Dispositivo;
import Modelo.Empresa;
import Modelo.LogSistema;
import Modelo.Principal;
import Modelo.QueryEjecutada;
import Modelo.TipoDispositivo;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class OpDispositivos implements IOperaciones<Dispositivo> {
/*Estado*/
private static Database database;
private OpLogSistema logging;
/*Estado*/

/*Constructores*/
public OpDispositivos(){
    this.database = Database.getInstancia();
    this.logging = new OpLogSistema();
}
/*Constructores*/

/*Comportamiento*/
  @Override
    public void guardar(Dispositivo cAnterior, Dispositivo c) throws Exception, SQLException {
        if(cAnterior == null){
            insertar(c);
        }else{
            modificar(cAnterior, c);
        }
    }

    @Override
    public void insertar(Dispositivo c) throws Exception, SQLException {
        ArrayList<String> listaSQL = new ArrayList<>();
        listaSQL.add("INSERT INTO Dispositivos (nroSerie, estado, idTipoDispositivo, identificacionTributaria, nroCliente) values ('"+c.getNroSerie()+"','"+c.getEstado()+"','"+c.getTipoDispositivo().getIdTipoDispositivo()+"','"+c.getEmpresaAsociada().getIdentificacionTributaria()+"','"+c.getClienteAsociado().getNroCliente()+"') ");

        try {
            /*Validar que el nroSerie no exista ya en la base de datos*/
            ResultSet validarConsistencia = database.consultar("SELECT * FROM Dispositivos WHERE nroSerie='" + c.getNroSerie() + "' ");
            if (validarConsistencia.next()) {
                validarConsistencia.close();
                registroConsola(listaSQL, "Alta", "El Número de serie ingresado ya existe en el sistema.");
                throw new Exception("El Número de serie ingresado ya existe en el sistema.");
            }
            validarConsistencia.close();
            /*Validar que el nroSerie no exista ya en la base de datos*/
            database.actualizarMultiple(listaSQL, "INSERT");
        } catch (SQLException ex) {
            registroConsola(listaSQL, "Alta", ex.getMessage());
            throw ex;
        } catch (Exception ex) {
            registroConsola(listaSQL, "Alta", ex.getMessage());
            throw ex;
        }
        registroConsola(listaSQL, "Alta", "NOERROR");
    }

    @Override
    public void modificar(Dispositivo cAnterior, Dispositivo c) throws Exception, SQLException {
        ArrayList<String> listaSQL = new ArrayList<>();
        listaSQL.add("UPDATE Dispositivos SET estado='"+c.getEstado()+"', idTipoDispositivo='"+c.getTipoDispositivo().getIdTipoDispositivo()+"', nroCliente='"+c.getClienteAsociado().getNroCliente()+"' WHERE nroSerie ='"+c.getNroSerie()+"' ");
        try{
            database.actualizarMultiple(listaSQL, "UPDATE");
        }catch(SQLException ex){
            registroConsola(listaSQL, "Modificación", ex.getMessage());
            throw ex;
        }catch(Exception ex){
            registroConsola(listaSQL, "Modificación", ex.getMessage());
            throw ex;
        }
        registroConsola(listaSQL, "Modificación", "NOERROR");
    }

    @Override
    public void borrar(Dispositivo c) throws Exception, SQLException {
       ArrayList<String> listaSQL = new ArrayList<>();
       listaSQL.add("UPDATE Dispositivos SET eliminado='Y' WHERE nroSerie='"+c.getNroSerie()+"' ");
       try{
            database.actualizarMultiple(listaSQL, "UPDATE");
        }catch(SQLException ex){
            registroConsola(listaSQL, "Baja", ex.getMessage());
            throw ex;
        }catch(Exception ex){
            registroConsola(listaSQL, "Baja", ex.getMessage());
            throw ex;
        }
        registroConsola(listaSQL, "Baja", "NOERROR");
    }

    @Override
    public ArrayList<Dispositivo> obtenerTodos() throws Exception, SQLException {
        return buscar(null, null);
    }

    @Override
    public ArrayList<Dispositivo> buscar(String filtro, String extras) throws Exception, SQLException {
        ArrayList<String> listaSQL = new ArrayList<>();
        ArrayList<Dispositivo> lista = new ArrayList<>();
        String nroSerie="", estado="";
        TipoDispositivo tipo;
        Empresa empresaAsociada;
        Cliente clienteAsociado;
        String sql = "SELECT nroSerie, estado, idTipoDispositivo, identificacionTributaria, nroCliente from Dispositivos ";
        if(filtro!=null){
            sql+=filtro;
            sql+= " AND eliminado = 'N' ";
        }else{
            sql+= " WHERE eliminado = 'N' ";
        }
        
        listaSQL.add(sql);
        try{
            ResultSet rs = database.consultar(sql);
            while(rs.next()){
                nroSerie = rs.getString("nroSerie");
                estado = rs.getString("estado");
                tipo = new TipoDispositivo(rs.getInt("idTipoDispositivo"));
                empresaAsociada = new Empresa(rs.getString("identificacionTributaria"));
                clienteAsociado = new Principal(rs.getString("identificacionTributaria"));
                lista.add(new Dispositivo(nroSerie, estado, tipo, empresaAsociada, clienteAsociado));
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
       ArrayList<String> listaSQL = new ArrayList<>();
       /*Armando listado de IDS para la Query*/
        String listaIdsStr = "";
        for(Integer i: listaIds){
            listaIdsStr += i + " , ";
        }
        listaIdsStr = listaIdsStr.substring(0, (listaIdsStr.length()-2));
       /*Armando listado de IDS para la Query*/
       listaSQL.add("UPDATE Dispositivos SET eliminado='Y' WHERE nroSerie in ("+listaIdsStr+")");
       
       try{
            database.actualizarMultiple(listaSQL, "UPDATE");
        }catch(SQLException ex){
            registroConsola(listaSQL, "Baja", ex.getMessage());
            throw ex;
        }catch(Exception ex){
            registroConsola(listaSQL, "Baja", ex.getMessage());
            throw ex;
        }
        registroConsola(listaSQL, "Baja", "NOERROR");
        return true;
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
