package Datos;

import Modelo.Cliente;
import Modelo.Empresa;
import Modelo.Factura;
import Modelo.LogSistema;
import Modelo.Moneda;
import Modelo.QueryEjecutada;
import Modelo.Suscripcion;
import Resources.DTOs.DTOFechas;
import java.sql.SQLException;
import java.util.ArrayList;

public class OpFacturas implements IOperaciones<Factura> {

    
/*Estado*/
private static Database database;
private OpLogSistema logging;
/*Estado*/

/*Constructores*/
public OpFacturas(){
    this.database = Database.getInstancia();
    this.logging = new OpLogSistema();
}
/*Constructores*/

/*Comportamiento*/
@Override
    public void guardar(Factura cAnterior, Factura c) throws Exception, SQLException {
        if(cAnterior == null){
            insertar(c);
        }else{
            modificar(cAnterior, c);
        }
    }

    @Override
    public void insertar(Factura c) throws Exception, SQLException {
        ArrayList<String> listaSQL = new ArrayList<>();
        listaSQL.add("INSERT INTO Facturas (fechaVencimiento, periodoServicioInicio, periodoServicioFin, tipoRecibo, monto, codigo, nroCliente, identificacionTributaria) "
                + "values ('"+c.getFechaVencimiento().getFechaAStr(1)+"','"+c.getPeriodoServicioInicio().getFechaAStr(1)+"','"+c.getPeriodoServicioFin().getFechaAStr(1)+"','"+c.getTipoRecibo()+"',"
                        + "'"+c.getMonto()+"','"+c.getMonedaAsociada().getCodigo()+"','"+c.getClienteAsociado().getNroCliente()+"','"+c.getEmpresaAsociada().getIdentificacionTributaria()+"')");
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
    public void modificar(Factura cAnterior, Factura c) throws Exception, SQLException {
        ArrayList<String> listaSQL = new ArrayList<>();
        listaSQL.add("UPDATE Facturas SET fechaPago='"+c.getFechaPago().getFechaAStr(1)+"', monto='"+c.getMonto()+"' WHERE idFactura='"+cAnterior.getIdFactura()+"'");
        /*Actualizando facturas asociadas a la suscripcion solo si es necesario*/
        if(!c.getListaSuscripciones().isEmpty()){
            listaSQL.add("DELETE FROM GeneraSF WHERE idFactura='"+cAnterior.getIdFactura()+"'");
            for(Suscripcion s: c.getListaSuscripciones()){
                listaSQL.add("INSERT INTO GeneraSF (idSuscripcion, idFactura) values ('"+cAnterior.getIdFactura()+"','"+s.getIdSuscripcion()+"')");
            }
        }
        /*Actualizando facturas asociadas a la suscripcion solo si es necesario*/
        
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
    public void borrar(Factura c) throws Exception, SQLException {
        ArrayList<String> listaSQL = new ArrayList<>();     
        /*Borrar registros de tabla relacionaria entre la Suscripción y Factura (GeneraSF)*/
        if(!c.getListaSuscripciones().isEmpty()){
            for(Suscripcion s: c.getListaSuscripciones()){
                listaSQL.add("UPDATE GeneraSF SET eliminado='Y' WHERE idFactura='"+c.getIdFactura()+"'");
            }
        }
        /*Borrar registros de tabla relacionaria entre la Suscripción y Factura (GeneraSF)*/
        listaSQL.add("UPDATE Facturas SET eliminado='Y' WHERE idFactura='"+c.getIdFactura()+"'");
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
    public ArrayList<Factura> obtenerTodos() throws Exception, SQLException {
        return buscar(null,null);
    }

    @Override
    public ArrayList<Factura> buscar(String filtro, String extras) throws Exception, SQLException {
        ArrayList<Factura> lista = new ArrayList<>();
        int idFactura = -1;
        DTOFechas fechaPago, fechaEmision, fechaVencimiento, periodoServicioInicio, periodoServicioFin;
        int diaPago, mesPago, anioPago, diaEmision, mesEmision, anioEmision, diaVencimiento, mesVencimiento, anioVencimiento, diaPSI, mesPSI, anioPSI, diaPSF, mesPSF, anioPSF;
        double monto;
        String tipoRecibo;
        Cliente clienteAsociado;
        Moneda monedaAsociada;
        Empresa empresaAsociada;
        
        
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
