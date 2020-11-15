package Datos;

import Modelo.Categoria;
import Modelo.LogSistema;
import Modelo.QueryEjecutada;
import Modelo.TipoDispositivo;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class OpTiposDispositivos implements IOperaciones<TipoDispositivo> {
/*Estado*/
private static Database database;
private OpLogSistema logging;
/*Estado*/

/*Constructores*/
public OpTiposDispositivos(){
    this.database = Database.getInstancia();
    this.logging = new OpLogSistema();
}
/*Constructores*/

/*Comportamiento*/
 @Override
    public void guardar(TipoDispositivo cAnterior, TipoDispositivo c) throws Exception, SQLException {
        if(cAnterior == null){
            insertar(c);
        }else{
            modificar(cAnterior, c);
        }
    }

    @Override
    public void insertar(TipoDispositivo c) throws Exception, SQLException {
        ArrayList<String> listaSQL = new ArrayList<>();
        listaSQL.add("INSERT INTO TiposDispositivos (modelo, nombre, tipoComunicacion, nombreCategoria) values "
                + " ('"+c.getModelo()+"','"+c.getNombre()+"','"+c.getTipoComunicacion()+"','"+c.getCategoria().getNombreCategoria()+"') ");
        
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
    public void modificar(TipoDispositivo cAnterior, TipoDispositivo c) throws Exception, SQLException {
        ArrayList<String> listaSQL = new ArrayList<>();
        ResultSet validarConsistencia = null;
        listaSQL.add("UPDATE TiposDispositivos SET modelo='"+c.getModelo()+"', nombre='"+c.getNombre()+"', tipoComunicacion='"+c.getTipoComunicacion()+"' WHERE idTipoDispositivo='"+cAnterior.getIdTipoDispositivo()+"' ");
        /*Validar que el modelo nuevo no existe ya en la db.*/
        validarConsistencia = database.consultar("SELECT * FROM TiposDispositivos WHERE modelo='"+c.getModelo()+"' ");
        if(validarConsistencia.next()){
            validarConsistencia.close();
            registroConsola(listaSQL, "Modificación", "El modelo que usted desea asignar ya está en uso en el sistema.");
            throw new Exception("El modelo que usted desea asignar ya está en uso en el sistema.");
        }
        validarConsistencia.close();
        /*Validar que el modelo nuevo no existe ya en la db.*/
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
    public void borrar(TipoDispositivo c) throws Exception, SQLException {
        ArrayList<String> listaSQL = new ArrayList<>();
        ResultSet validarConsistencia= null;
        listaSQL.add("UPDATE TiposDispositivos SET eliminado='Y' WHERE idTipoDispositivo='"+c.getIdTipoDispositivo()+"'");
        /*Validar que este tipo de dispositivo no exista en ningun paquete de suscripción*/
        validarConsistencia = database.consultar("SELECT * FROM TieneTP WHERE idTipoDispositivo ='"+c.getIdTipoDispositivo()+"' AND eliminado='N' ");
        if(validarConsistencia.next()){
            validarConsistencia.close();
            registroConsola(listaSQL, "Baja", "El Tipo de Dispositivo que usted desea borrar existe en algún Paquete.");
            throw new Exception("El Tipo de Dispositivo que usted desea borrar existe en algún Paquete.");
        }
        validarConsistencia.close();
        /*Validar que este tipo de dispositivo no exista en ningun paquete de suscripción*/
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
    public ArrayList<TipoDispositivo> obtenerTodos() throws Exception, SQLException {
        return buscar(null,null);
    }

    @Override
    public ArrayList<TipoDispositivo> buscar(String filtro, String extras) throws Exception, SQLException {
        ArrayList<TipoDispositivo> lista = new ArrayList<>();
        ArrayList<String> listaSQL = new ArrayList<>();
        int idTipoDispositivo;
        String modelo = "", nombre="", tipoComunicacion="";
        Categoria categoria = null;
        String sql = "SELECT idTipoDispositivo, modelo, nombre, tipoComunicacion, nombreCategoria FROM TiposDispositivos ";
        if(filtro!=null){
            sql+=filtro;
            sql+=" AND eliminado='N' ";
        }else{
            sql+=" WHERE eliminado='N' ";
        }
        listaSQL.add(sql);
        try{
            ResultSet rs = database.consultar(sql);
            while(rs.next()){
                idTipoDispositivo = rs.getInt("idTipoDispositivo");
                modelo = rs.getString("modelo");
                nombre = rs.getString("nombre");
                tipoComunicacion = rs.getString("tipoComunicacion");
                categoria = new Categoria(rs.getString("nombreCategoria"));
                TipoDispositivo td = new TipoDispositivo(idTipoDispositivo, modelo, nombre, tipoComunicacion, categoria);
                lista.add(td);
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
        ResultSet validarConsistencia= null;
        listaSQL.add("UPDATE TiposDispositivos SET eliminado='Y' WHERE idTipoDispositivo in(" +listaIdsStr+ ")");
        /*Validar que este tipo de dispositivo no exista en ningun paquete de suscripción*/
        validarConsistencia = database.consultar("SELECT * FROM TieneTP WHERE idTipoDispositivo in(" +listaIdsStr+ ") and eliminado = 'N' ");
        if(validarConsistencia.next()){
            validarConsistencia.close();
            registroConsola(listaSQL, "Baja", "Alguno de los Tipos de Dispositivos que usted desea borrar existe en algún Paquete.");
            throw new Exception("Alguno de los Tipos de Dispositivos que usted desea borrar existe en algún Paquete.");
        }
        validarConsistencia.close();
        /*Validar que este tipo de dispositivo no exista en ningun paquete de suscripción*/    
        /*Validar lista de IDs vacia*/
        if(listaIds.isEmpty()){
            registroConsola(listaSQL, "Baja", "ERROR: Lista de IDs llegó vacia al metodo borradoMultiplePorIds");
            return false;
        }
        /*Validar lista de IDs vacia*/
        
        listaSQL.add("UPDATE TieneTP set eliminado='Y' WHERE idTipoDispositivo in("+listaIdsStr+")");
        listaSQL.add("UPDATE TiposDispositivos set eliminado='Y' WHERE idTipoDispositivo in("+listaIdsStr+")");
        try{
            database.actualizarMultiple(listaSQL,"UPDATE");
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
