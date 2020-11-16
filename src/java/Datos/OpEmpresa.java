package Datos;

import Modelo.Empresa;
import Modelo.Idioma;
import Modelo.LogSistema;
import Modelo.Pais;
import Modelo.QueryEjecutada;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class OpEmpresa implements IOperaciones<Empresa> {
/*Estado*/
private static Database database;
private OpLogSistema logging;
/*Estado*/

/*Constructores*/
public OpEmpresa(){
    this.database = Database.getInstancia();
    this.logging = new OpLogSistema();
}
/*Constructores*/

/*Comportamiento*/
 @Override
    public void guardar(Empresa cAnterior, Empresa c) throws Exception, SQLException {
        if(cAnterior == null){
            insertar(c);
        }else{
            modificar(cAnterior, c);
        }
    }

    @Override
    public void insertar(Empresa c) throws Exception, SQLException {
        ArrayList<String> listaSQL = new ArrayList<>();
        listaSQL.add("INSERT INTO Empresas (identificacionTributaria, nombre, razonSocial, impuestos, nombreIdioma, codigo) values "
                + "('"+c.getIdentificacionTributaria()+"','"+c.getNombre()+"','"+c.getRazonSocial()+"','"+c.getImpuestos()+"','"+c.getIdiomaAsociado().getNombre()+"','"+c.getPaisAsociado().getCodigo()+"') ");
        try{
        /*Validar que la identificacionTributaria no exista ya en el sistema.*/
        ResultSet validarConsistencia = database.consultar("SELECT * FROM Empresas WHERE identificacionTributaria='"+c.getIdentificacionTributaria()+"' ");
        if(validarConsistencia.next()){
            validarConsistencia.close();
            registroConsola(listaSQL, "Alta", "La identificación tributaria de la empresa ya existe en el sistema.");
            throw new Exception("La identificación tributaria de la empresa ya existe en el sistema.");
        }
        validarConsistencia.close();
        /*Validar que la identificacionTributaria no exista ya en el sistema.*/
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
    public void modificar(Empresa cAnterior, Empresa c) throws Exception, SQLException {
        ArrayList<String> listaSQL = new ArrayList<>();
        listaSQL.add("UPDATE Empresas SET nombre='"+c.getNombre()+"', razonSocial='"+c.getRazonSocial()+"', impuestos='"+c.getImpuestos()+"', nombreIdioma='"+c.getIdiomaAsociado().getNombre()+"', codigo='"+c.getPaisAsociado().getCodigo()+"' WHERE identificacionTributaria='"+c.getIdentificacionTributaria()+"' ");
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
    public void borrar(Empresa c) throws Exception, SQLException {
        ArrayList<String> listaSQL = new ArrayList<>();
        listaSQL.add("UPDATE Empresas SET eliminado='Y' WHERE identificacionTributaria='"+c.getIdentificacionTributaria()+"' ");
        try{
            /*Validaciones, que la empresa no tenga Facturas, Personas, Dispositivos o Paquetes asociados.*/
            ResultSet validarConsistencia = null;
            ArrayList<String> listaTablas = new ArrayList<>();
            listaTablas.add("Facturas");
            listaTablas.add("Personas");
            listaTablas.add("Dispositivos");
            listaTablas.add("Paquetes");
            for (String str : listaTablas) {
                validarConsistencia = database.consultar("SELECT * FROM "+str+" WHERE identificacionTributaria='" + c.getIdentificacionTributaria() + "' ");
                if (validarConsistencia.next()) {
                    validarConsistencia.close();
                    registroConsola(listaSQL, "Baja", "No se puede eliminar a la empresa porque hay "+str+" asociadas a la misma.");
                    throw new Exception("No se puede eliminar a la empresa porque hay "+str+" asociadas a la misma.");
                }
                validarConsistencia.close();
            }
            /*Validaciones, que la empresa no tenga Facturas, Personas, Dispositivos o Paquetes asociados.*/
            database.actualizarMultiple(listaSQL, "UPDATE");
        }catch(SQLException ex){
            registroConsola(listaSQL, "Baja", ex.getMessage());
            throw ex;
        }catch(Exception ex){
            registroConsola(listaSQL, "Baja", ex.getMessage());
            throw ex;
        }
    }

    @Override
    public ArrayList<Empresa> obtenerTodos() throws Exception, SQLException {
        return buscar(null,null);
    }

    @Override
    public ArrayList<Empresa> buscar(String filtro, String extras) throws Exception, SQLException {
        ArrayList<Empresa> lista = new ArrayList<>();
        ArrayList<String> listaSQL = new ArrayList<>();
        String identificacionTributaria = "", nombre = "", razonSocial="";
        float impuestos;
        Idioma idiomaAsociado;
        Pais paisAsociado;
        String sql = "SELECT identificacionTributaria, nombre, razonSocial, impuestos, nombreIdioma, codigo FROM Empresas ";
        if(filtro!=null){
            sql+=filtro;
            sql+=" AND eliminado='N' ";
        }else{
            sql+=" WHERE eliminado = 'N' ";
        }
        listaSQL.add(sql);
        
        try{
            ResultSet rs = database.consultar(sql);
            while(rs.next()){
                identificacionTributaria = rs.getString("identificacionTributaria");
                nombre = rs.getString("nombre");
                razonSocial = rs.getString("razonSocial");
                impuestos = rs.getFloat("impuestos");
                idiomaAsociado = new Idioma(rs.getString("nombreIdioma"));
                paisAsociado = new Pais(rs.getString("codigo"));
                lista.add(new Empresa(identificacionTributaria, nombre, razonSocial, impuestos, idiomaAsociado, paisAsociado));
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
