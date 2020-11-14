package Datos;

import Modelo.Factura;
import Modelo.LogSistema;
import Modelo.QueryEjecutada;
import Modelo.Suscripcion;
import Resources.DTOs.DTOFechas;
import Resources.DTOs.Fecha;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class OpSuscripcion implements IOperaciones<Suscripcion> {
/*Estado*/
private static Database database;
private OpLogSistema logging;
/*Estado*/

/*Constructores*/
public OpSuscripcion(){
    this.database = Database.getInstancia();
    this.logging = new OpLogSistema();
}
/*Constructores*/

/*Comportamiento*/
 @Override
    public void guardar(Suscripcion cAnterior, Suscripcion c) throws Exception, SQLException {
        if(cAnterior == null){
            insertar(c);
        }else{
            modificar(cAnterior, c);
        }
    }

    @Override
    public void insertar(Suscripcion c) throws Exception, SQLException {
        ArrayList<String> listaSQL = new ArrayList<>();
        listaSQL.add("INSERT INTO Suscripciones (fechaInicio, tiempoContrato, fechaFin, activa) values "
                + "('"+c.getFechaInicio().getFechaAStr(1)+"','"+c.getTiempoContrato()+"','"+c.getFechaFin().getFechaAStr(1)+"','"+c.getActiva()+"')");
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
    public void modificar(Suscripcion cAnterior, Suscripcion c) throws Exception, SQLException {
        ArrayList<String> listaSQL = new ArrayList<>();
        String activaStr = "N";
        if(c.getActiva())
            activaStr="S";
        listaSQL.add("UPDATE Suscripciones SET fechaInicio='"+c.getFechaInicio().getFechaAStr(1)+"', tiempoContrato='"+c.getTiempoContrato()+"', fechaFin='"+c.getFechaFin().getFechaAStr(1)+"', activa='"+activaStr+"' WHERE idSuscripcion='"+cAnterior.getIdSuscripcion()+"'");
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
    public void borrar(Suscripcion c) throws Exception, SQLException {
        ArrayList<String> listaSQL = new ArrayList<>();
        listaSQL.add("UPDATE Suscripcion set eliminado='Y' WHERE idSuscripcion='"+c.getIdSuscripcion()+"'");
        try{
            database.actualizarMultiple(listaSQL,"UPDATE");
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
    public ArrayList<Suscripcion> obtenerTodos() throws Exception, SQLException {
        return buscar(null,null);
    }

    @Override
    public ArrayList<Suscripcion> buscar(String filtro, String extras) throws Exception, SQLException {
        ArrayList<Suscripcion> lista = new ArrayList<>();
        int idSuscripcion = -1;
        DTOFechas fechaInicio, fechaFin;
        int anioInicio, mesInicio, diaInicio, anioFin, mesFin, diaFin;
        float tiempoContrato;
        boolean activa;
        ArrayList<String> listaSQL = new ArrayList<>();
        String sql ="";
        sql = "SELECT day(fechaInicio) as 'diaInicio', month(fechaInicio) as 'mesInicio', year(fechaInicio) as 'anioInicio', "
                   + " tiempoContrato, activa, idSuscripcion, "
                +    " day(fechaFin) as 'diaFin', month(fechaFin) as 'mesFin', year(fechaFin) as 'anioFin' from Suscripciones ";
        if(filtro!=null){
            sql+= filtro;
            sql+=" AND Suscripciones.eliminado='N' ";
        }else{
            sql+=" WHERE Suscripciones.eliminado='N' ";
        }
        listaSQL.add(sql);
        try{
            ResultSet rs = database.consultar(sql);
            while(rs.next()){
                idSuscripcion = rs.getInt("idSuscripcion");
                diaInicio = rs.getInt("diaInicio");
                mesInicio = rs.getInt("mesInicio");
                anioInicio = rs.getInt("anioInicio");
                diaFin = rs.getInt("diaFin");
                mesFin = rs.getInt("mesFin");
                anioFin = rs.getInt("anioFin");
                tiempoContrato = rs.getFloat("tiempoContrato");
                String activaStr = rs.getString("activa");
                activa = false;
                if(activaStr.equals("S")){
                    activa = true;
                }
                fechaInicio = new DTOFechas(new Fecha(diaInicio, mesInicio, anioInicio));
                fechaFin = new DTOFechas(new Fecha(diaFin, mesFin, anioFin));
                Suscripcion s = new Suscripcion(idSuscripcion, fechaInicio, tiempoContrato,fechaFin, activa);
                lista.add(s);
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
        
        listaSQL.add("UPDATE GeneraSF set eliminado='Y' WHERE idSuscripcion in("+listaIdsStr+")");
        listaSQL.add("UPDATE Suscripcion set eliminado='Y' WHERE idSuscripcion in("+listaIdsStr+")");
        /*Validaciones*/
        if(listaIds.isEmpty()){
            registroConsola(listaSQL, "Baja", "ERROR: Lista de IDs llegó vacia al metodo borradoMultiplePorIds");
            return false;
        }
        /*Validaciones*/
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