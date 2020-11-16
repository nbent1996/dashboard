package Datos;

import Modelo.Empresa;
import Modelo.LogSistema;
import Modelo.Paquete;
import Modelo.QueryEjecutada;
import Modelo.TieneTP;
import Modelo.TipoDispositivo;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;

public class OpPaquete implements IOperaciones<Paquete> {

  
/*Estado*/
private static Database database;
private OpLogSistema logging;
/*Estado*/

/*Constructores*/
public OpPaquete(){
    this.database = Database.getInstancia();
    this.logging = new OpLogSistema();
}
/*Constructores*/

/*Comportamiento*/
  @Override
    public void guardar(Paquete cAnterior, Paquete c) throws Exception, SQLException {
        if(cAnterior == null){
            insertar(c);
        }else{
            modificar(cAnterior, c);
        }
    }

    @Override
    public void insertar(Paquete c) throws Exception, SQLException {
        ArrayList<String> listaSQL = new ArrayList<>();
        listaSQL.add("INSERT INTO Paquetes (costoBruto, identificacionTributaria) values ('"+c.getCostoBruto()+"','"+c.getEmpresaAsociada().getIdentificacionTributaria()+"') ");
        if(!c.getListaTieneTP().isEmpty()){
            for(TieneTP t: c.getListaTieneTP()){
                listaSQL.add("INSERT INTO TieneTP (idPaquete, idTipoDispositivo, cantidadDispositivos) values ('"+c.getIdPaquete()+"','"+t.getTipoDispositivo().getIdTipoDispositivo()+"','"+t.getCantidadDispositivos()+"') ");
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
    public void modificar(Paquete cAnterior, Paquete c) throws Exception, SQLException {
        ArrayList<String> listaSQL = new ArrayList<>();
        listaSQL.add("UPDATE Paquetes SET costoBruto='"+c.getCostoBruto()+"', identificacionTributaria='"+c.getEmpresaAsociada().getIdentificacionTributaria()+"' WHERE idPaquete = '"+c.getIdPaquete()+"' AND eliminado = 'N' ");
        /*Actualizando Tipos de Dispositivos asociados al Paquete solo si es necesario*/
        if(!listasSonIguales(c.getListaTieneTP(), cAnterior.getListaTieneTP())){
            listaSQL.add("DELETE FROM TieneTP WHERE idPaquete='"+cAnterior.getIdPaquete()+"' ");
            for(TieneTP t: c.getListaTieneTP()){
                listaSQL.add("INSERT INTO TieneTP (idPaquete, idTipoDispositivo, cantidadDispositivos) values ('"+c.getIdPaquete()+"','"+t.getTipoDispositivo().getIdTipoDispositivo()+"','"+t.getCantidadDispositivos()+"') ");
            }
        }
        /*Actualizando Tipos de Dispositivos asociados al Paquete solo si es necesario*/
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
    public void borrar(Paquete c) throws Exception, SQLException {
        ArrayList<String> listaSQL = new ArrayList<>();
        /*Borrar registros de tabla relacionaria entre el Paquete y el Tipo de Dispositivo (TieneTP)*/
        if(!c.getListaTieneTP().isEmpty()){
            for(TieneTP t: c.getListaTieneTP()){
                listaSQL.add("UPDATE TieneTP SET eliminado='Y' WHERE idPaquete='"+c.getIdPaquete()+"' ");
            }
        }
        /*Borrar registros de tabla relacionaria entre el Paquete y el Tipo de Dispositivo (TieneTP)*/
        listaSQL.add("UPDATE Paquetes SET eliminado='Y' WHERE idPaquete='"+c.getIdPaquete()+"' ");
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
    }

    @Override
    public ArrayList<Paquete> obtenerTodos() throws Exception, SQLException {
        return buscar(null,null);
    }

    @Override
    public ArrayList<Paquete> buscar(String filtro, String extras) throws Exception, SQLException {
        ArrayList<Paquete> lista = new ArrayList<>();
        int idPaquete = -1, idTipoDispositivo=-1, cantidadDispositivos;
        float costoBruto =-1;
        Empresa empresaAsociada = null;
        ArrayList<TieneTP> listaTieneTP = new ArrayList<>();
        String sql = "SELECT idPaquete, costoBruto, identificacionTributaria from Paquetes ";
        ArrayList<String> listaSQL = new ArrayList<>();
        if(filtro!=null){
            sql+=filtro;
            sql+=" AND eliminado = 'N' ";
        }else{
            sql+=" WHERE eliminado = 'N' ";
        }
        listaSQL.add(sql);
        
        try{
            ResultSet rs = database.consultar(sql);
            while(rs.next()){
                idPaquete = rs.getInt("idPaquete");
                costoBruto = rs.getFloat("costoBruto");
                empresaAsociada = new Empresa(rs.getString("identificacionTributaria"));
                ResultSet rsTieneTP = database.consultar("SELECT idPaquete, idTipoDispositivo, cantidadDispositivos from TieneTP WHERE idPaquete = '"+idPaquete+"' AND eliminado='N' ");
                listaTieneTP = new ArrayList<>();
                /*Cargando lista de tiene TP al paquete de turno en el ciclo*/
                while(rsTieneTP.next()){
                    cantidadDispositivos = rsTieneTP.getInt("cantidadDispositivos");
                    idTipoDispositivo = rsTieneTP.getInt("idTipoDispositivo");
                    listaTieneTP.add(new TieneTP(cantidadDispositivos,new TipoDispositivo(idTipoDispositivo)));
                }
                rsTieneTP.close();
                /*Cargando lista de tiene TP al paquete de turno en el ciclo*/
                lista.add(new Paquete(idPaquete, costoBruto,empresaAsociada, listaTieneTP));
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
        for (Integer i : listaIds) {
            listaIdsStr += i + " , ";
        }
        listaIdsStr = listaIdsStr.substring(0, (listaIdsStr.length() - 2));
        /*Armando listado de IDS para la Query*/
        ResultSet validarConsistencia = null;
        listaSQL.add("UPDATE Paquetes SET eliminado='Y' WHERE idPaquete in (" + listaIdsStr + ") ");

        /*Validar lista de IDs vacia*/
        if (listaIds.isEmpty()) {
            registroConsola(listaSQL, "Baja", "ERROR: Lista de IDs llegó vacia al metodo borradoMultiplePorIds");
            return false;
        }
        /*Validar lista de IDs vacia*/

        listaSQL.add("UPDATE TieneTP set eliminado='Y' WHERE idPaquete in(" + listaIdsStr + ")");
        listaSQL.add("UPDATE Paquetes set eliminado='Y' WHERE idPaquete in(" + listaIdsStr + ")");
        try {
            /*Validar que este Paquete no tenga registros en la tabla TieneTP (Relación TipoDispositivo-Paquete)*/
            validarConsistencia = database.consultar("SELECT * FROM TieneTP WHERE idPaquete in (" + listaIdsStr + ")");
            if (validarConsistencia.next()) {
                validarConsistencia.close();
                registroConsola(listaSQL, "Baja", "Alguno de los Paquetes que usted desea borrar está relacionado con algún Tipo de Dispositivo.");
                throw new Exception("Alguno de los Paquetes que usted desea borrar está relacionado con algún Tipo de Dispositivo.");
            }
            validarConsistencia.close();
            /*Validar que este Paquete no tenga registros en la tabla TieneTP (Relación TipoDispositivo-Paquete)*/
            database.actualizarMultiple(listaSQL, "UPDATE");
        } catch (SQLException ex) {
            registroConsola(listaSQL, "Baja", ex.getMessage());
            throw ex;
        } catch (Exception ex) {
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
    
        public boolean listasSonIguales(ArrayList<TieneTP> a, ArrayList<TieneTP> b) {
        // comprobar que tienen el mismo tamaño y que no son nulos
        if ((a.size() != b.size()) || (a == null && b != null) || (a != null && b == null)) {
            return false;
        }

        if (a == null && b == null) {
            return true;
        }

        // ordenar las ArrayList y comprobar que son iguales          
        Collections.sort(a);
        Collections.sort(b);
        return a.equals(b);
    }
/*Comportamiento*/

/*Getters y Setters*/

/*Getters y Setters*/
}
