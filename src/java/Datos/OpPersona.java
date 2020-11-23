package Datos;

import Modelo.Empresa;
import Modelo.LogSistema;
import Modelo.Operador;
import Modelo.Pais;
import Modelo.Persona;
import Modelo.Principal;
import Modelo.QueryEjecutada;
import Modelo.Secundario;
import Modelo.TipoDocumento;
import Modelo.TipoUsuario;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class OpPersona implements IOperaciones<Persona, String> {

    
/*Estado*/
private static Database database;
private OpLogSistema logging;
private String usuarioSistema;
/*Estado*/

/*Constructores*/
public OpPersona(String usuarioSistema){
    this.database = Database.getInstancia();
    this.logging = new OpLogSistema();
    this.usuarioSistema = usuarioSistema;
}
/*Constructores*/

/*Comportamiento*/
@Override
    public LogSistema guardar(Persona cAnterior, Persona c) throws Exception, SQLException {
        if(cAnterior == null){
            return insertar(c);
        }else{
            return modificar(cAnterior, c);
        }
    }

    @Override
    public LogSistema insertar(Persona c) throws Exception, SQLException {
        ArrayList<String> listaSQLSinAI = new ArrayList<>(); /*SIN AUTOINCREMENTAL*/
        ArrayList<String> listaSQLConAI = new ArrayList<>(); /*CON AUTOINCREMENTAL*/
        ArrayList<String> listaCompleta = new ArrayList<>(); /*LISTA CON TODAS LAS SQL PARA LOGGING*/
        String sqlA = "INSERT INTO Personas (usuarioSistema, nombreCompleto, codigo, identificacionTributaria) values "
                + "('"+c.getUsuarioSistema()+"','"+c.getNombreCompleto()+"','"+c.getPaisResidencia().getCodigo()+"','"+c.getEmpresaAsociada().getIdentificacionTributaria()+"')";
        listaSQLSinAI.add(sqlA);
        listaCompleta.add(sqlA);
        String sqlB1, sqlB2, sqlC1, sqlC2, sqlD;
        switch(c.getClass().getName()){
            case "Modelo.Principal":
            Principal principal = (Principal) c;
            sqlB1= " INSERT INTO Clientes (email, usuarioSistema) values ('"+principal.getEmail()+"','"+principal.getUsuarioSistema()+"') ";
            sqlB2 = "INSERT INTO Principales (nroDocumento, servicioActivo, usuarioSistema, nroCliente, codDocumento) values "
                    + "('"+principal.getNroDocumento()+"','N','"+principal.getUsuarioSistema()+"',?,'"+principal.getTipoDocumento().getCodDocumento()+"')";
            listaSQLConAI.add(sqlB1);
            listaSQLConAI.add(sqlB2);
            listaCompleta.add(sqlB1);
            listaCompleta.add(sqlB2);
            break;
            case "Modelo.Secundario":
            Secundario secundario = (Secundario) c;
            sqlC1 = "INSERT INTO Clientes (email, usuarioSistema) values ('"+secundario.getEmail()+"','"+secundario.getUsuarioSistema()+"')";
            sqlC2 = "INSERT INTO Secundarios (nroCliente, nroDocumento) values (?,'"+secundario.getPrincipalAsociado().getNroDocumento()+"')";
            listaSQLConAI.add(sqlC1);
            listaSQLConAI.add(sqlC2);
            listaCompleta.add(sqlC1);
            listaCompleta.add(sqlC2);
            break;
            case "Modelo.Operador":
            Operador operador = (Operador) c;
            sqlD = "INSERT INTO OperadoresDashboard (usuarioSistema, clave, nombre) values "
                    + "('"+operador.getUsuarioSistema()+"',SHA('"+operador.getClave()+"'),'"+operador.getTipoUsuario().getNombre()+"')";
            listaSQLSinAI.add(sqlD);
            listaCompleta.add(sqlD);
            break;
        }
        try{
        if(!listaSQLSinAI.isEmpty()){
        database.actualizarMultiple(listaSQLSinAI, "UPDATE");
        }
        if(!listaSQLConAI.isEmpty()){
        database.actualizarMultiple(listaSQLConAI, "INSERT");
        }
        
        }catch(SQLException ex){
            registroConsola(this.usuarioSistema, listaCompleta, "Alta", ex.getMessage());
            throw ex;
        }catch(Exception ex){
            registroConsola(this.usuarioSistema, listaCompleta, "Alta", ex.getMessage());
            throw ex;
        }
        return registroConsola(this.usuarioSistema, listaCompleta, "Alta", "NOERROR");
    }

    @Override
    public LogSistema modificar(Persona cAnterior, Persona c) throws Exception, SQLException {
        ArrayList<String> listaSQL = new ArrayList<>();
        String sqlA, sqlB, sqlC, sqlD;
        try {
            ResultSet validarDependencias = null;
            /*Validar consistencia de los datos tabla Personas*/
            if(!cAnterior.getUsuarioSistema().equals(c.getUsuarioSistema())){ //Si el usuario cambió se valida la no existencia en la base
            validarDependencias = database.consultar("SELECT * FROM Personas WHERE Personas.usuarioSistema='" + c.getUsuarioSistema() + "' ");
            if (validarDependencias.next()) {
                validarDependencias.close();
                registroConsola(this.usuarioSistema, listaSQL, "Modificación", "El usuario que usted desea asignar ya está en uso en el sistema.");
                throw new Exception("El usuario que usted desea asignar ya está en uso en el sistema.");
            }
            validarDependencias.close();
            }
            /*Validar consistencia de los datos tabla Personas*/
            switch (c.getClass().getName()) {
                case "Modelo.Operador":
                    Operador operador = (Operador) c;
                    sqlA = "UPDATE Personas, OperadoresDashboard SET Personas.usuarioSistema='" + c.getUsuarioSistema() + "', Personas.nombreCompleto='" + c.getNombreCompleto() + "' , OperadoresDashboard.usuarioSistema='" + operador.getUsuarioSistema() + "', OperadoresDashboard.clave = SHA('"+operador.getClave()+"'), OperadoresDashboard.nombre='"+operador.getTipoUsuario().getNombre()+"'  WHERE Personas.usuarioSistema = OperadoresDashboard.usuarioSistema AND Personas.usuarioSistema='" + cAnterior.getUsuarioSistema() + "'";
                    /*No se valida la no repetición del usuarioSistema porque ya fue validado desde la tabla Personas*/
                    listaSQL.add(sqlA);
                    break;
                case "Modelo.Principal":
                    Principal principal = (Principal) c;
                    String servicioActivo = "N";
                    if (principal.getServicioActivo()) {
                        servicioActivo = "S";
                    }
                    sqlA = "UPDATE Personas, Clientes, Principales SET Personas.nombreCompleto='" + c.getNombreCompleto() + "' ,Clientes.email ='"+principal.getEmail()+"', Principales.servicioActivo='" + servicioActivo + "' where Personas.usuarioSistema = Clientes.usuarioSistema AND Clientes.usuarioSistema = Principales.usuarioSistema AND Principales.nroDocumento='" + principal.getNroDocumento() + "' and Principales.usuarioSistema='" + principal.getUsuarioSistema() + "'";
                    /*Validar que el nuevo nroDocumento no exista en el sistema ahora.*/
//                    validarDependencias = database.consultar("SELECT * FROM Principales WHERE Principales.nroDocumento='" + principal.getNroDocumento() + "' and Principales.usuarioSistema='" + principal.getUsuarioSistema() + "'");
//                    if (validarDependencias.next()) {
//                        validarDependencias.close();
//                        registroConsola(this.usuarioSistema, listaSQL, "Modificación", "El número de documento que usted desea asignar ya está en uso en el sistema.");
//                        throw new Exception("El número de documento que usted desea asignar ya está en uso en el sistema.");
//                    }VALIDACION NECESARIA POR SI EN ALGUN MOMENTO SE DESEA PODER MODFIICAR EL NRODOCUMENTO.
//                    validarDependencias.close();
                    /*Validar que el nuevo nroDocumento no exista en el sistema ahora.*/

                    listaSQL.add(sqlA);
                    break;

                case "Modelo.Secundario":
                    Secundario secundario = (Secundario) c;
                    Secundario sAnterior = (Secundario) cAnterior;
                    sqlA = "UPDATE Personas, Clientes, Secundarios SET Personas.nombreCompleto='"+secundario.getNombreCompleto()+"', Clientes.email='"+secundario.getEmail()+"', Secundarios.nroDocumento='"+secundario.getPrincipalAsociado().getNroDocumento()+"' where Personas.usuarioSistema = Clientes.usuarioSistema AND Clientes.nroCliente = Secundarios.nroCliente AND Secundarios.nroCliente='"+sAnterior.getNroCliente()+"' ";
                    /*No se valida la no repetición del usuarioSistema porque ya fue validado desde la tabla Personas*/
                    listaSQL.add(sqlA);
                    break;

        }
        database.actualizarMultiple(listaSQL, "UPDATE");
        }catch(SQLException ex){
            registroConsola(this.usuarioSistema, listaSQL, "Modificación", ex.getMessage());
            throw ex;
        }catch(Exception ex){
            registroConsola(this.usuarioSistema, listaSQL, "Modificación", ex.getMessage());
            throw ex;
        }
        return registroConsola(this.usuarioSistema, listaSQL, "Modificación", "NOERROR");    
    }

    @Override
    public LogSistema borrar(Persona c) throws Exception, SQLException {
        ArrayList<String> listaSQL = new ArrayList<>();
        String sqlA, sqlB, sqlC, sqlD;
        switch(c.getClass().getName()){
            case "Modelo.Operador":
                Operador operador = (Operador) c;
                sqlA = "UPDATE Personas SET eliminado='Y' WHERE usuarioSistema='"+c.getUsuarioSistema()+"'";
                sqlB = "UPDATE OperadoresDashboard SET eliminado='Y' WHERE usuarioSistema='"+operador.getUsuarioSistema()+"'";
                listaSQL.add(sqlA);
                listaSQL.add(sqlB);
            break;
            case "Modelo.Principal":
                Principal principal = (Principal) c;
                sqlA = "UPDATE Personas, Clientes, Principales SET Personas.eliminado='Y', Clientes.eliminado='Y', Principales.eliminado='Y' WHERE Personas.usuarioSistema=Clientes.usuarioSistema AND Clientes.usuarioSistema = Principales.usuarioSistema AND Principales.nroDocumento ='"+principal.getNroDocumento()+"' " ;
                listaSQL.add(sqlA);
            break;
            
            case "Modelo.Secundario":
                Secundario secundario = (Secundario) c;  
                sqlD = "UPDATE Personas, Clientes, Secundarios SET Personas.eliminado='Y', Clientes.eliminado='Y', Secundarios.eliminado='Y' WHERE Personas.usuarioSistema=Clientes.usuarioSistema AND Clientes.nroCliente = Secundarios.nroCliente AND Secundarios.nroCliente='"+secundario.getNroCliente()+"'";
                listaSQL.add(sqlD);
            break;

        }
        try{
        database.actualizarMultiple(listaSQL, "UPDATE");
        }catch(SQLException ex){
            registroConsola(this.usuarioSistema, listaSQL, "Baja", ex.getMessage());
            throw ex;
        }catch(Exception ex){
            registroConsola(this.usuarioSistema, listaSQL, "Baja", ex.getMessage());
            throw ex;
        }
        return registroConsola(this.usuarioSistema, listaSQL, "Baja", "NOERROR");
    }

    @Override
    public ArrayList<Persona> obtenerTodos() throws Exception, SQLException {
        throw new UnsupportedOperationException("No implementado.");
    }

    @Override
    public ArrayList<Persona> buscar(String filtro, String extras) throws Exception, SQLException {
        /*En el String extras se deberá almacenar el tipo de persona sobre el cual se quiere hacer búsqueda, OPCIONES POSIBLES: Modelo.Operador, Modelo.Principal, Modelo.Secundario*/
        ArrayList<Persona> personas = new ArrayList<>();
        String usuarioSistema, nombreCompleto, codigo, identificacionTributaria; /*Tabla Persona*/
        String nombreTipoUsuario; /*Tabla OperadoresDashboard*/
        String nroCliente, email; /*Tabla Cliente*/
        String nroDocumento, servicioActivo, codDocumento; /*Tabla Principales*/
        String nroDocumentoPrincipal; /*Tabla Secundarios*/
        String sqlA ="", sqlB="", sqlC="";
        ResultSet rs = null;
        ArrayList<String> listaSQL = new ArrayList<>();
        try{
            
            switch (extras) {
                case "Modelo.Operador":
                    sqlA = "SELECT Personas.usuarioSistema, Personas.nombreCompleto, Personas.codigo, Personas.identificacionTributaria, OperadoresDashboard.nombre from Personas, OperadoresDashboard ";
                    if (filtro != null) {
                        sqlA += filtro;
                        sqlA += " AND Personas.usuarioSistema = OperadoresDashboard.usuarioSistema AND Personas.eliminado='N' AND OperadoresDashboard.eliminado='N' ";
                    } else {
                        sqlA += " WHERE Personas.usuarioSistema = OperadoresDashboard.usuarioSistema  AND Personas.eliminado='N' AND OperadoresDashboard.eliminado='N' ";
                    }
                    rs = database.consultar(sqlA);
                    while(rs.next()){
                        usuarioSistema = rs.getString("usuarioSistema");
                        nombreCompleto = rs.getString("nombreCompleto");
                        codigo = rs.getString("codigo");
                        identificacionTributaria = rs.getString("identificacionTributaria");
                        nombreTipoUsuario = rs.getString("nombre");
                        personas.add(new Operador("", usuarioSistema, nombreCompleto, new Empresa(identificacionTributaria),new Pais(codigo),new TipoUsuario(nombreTipoUsuario)));
                    }
                    rs.close();
                    listaSQL.add(sqlA);
                    break;
                case "Modelo.Principal":
                    sqlB = "SELECT Personas.usuarioSistema, Personas.nombreCompleto, Personas.codigo, Personas.identificacionTributaria, Principales.nroDocumento, Principales.nroCliente, Principales.servicioActivo, Principales.codDocumento, Clientes.email from Personas, Principales, Clientes ";
                    if (filtro != null) {
                        sqlB += filtro;
                        sqlB += " AND Personas.usuarioSistema = Principales.usuarioSistema AND Principales.nroCliente = Clientes.nroCliente AND Personas.eliminado='N' AND Principales.eliminado='N' ";
                    } else {
                        sqlB += " WHERE Personas.usuarioSistema = Principales.usuarioSistema AND Principales.nroCliente = Clientes.nroCliente AND Personas.eliminado='N' AND Principales.eliminado='N' ";
                    }
                    rs=database.consultar(sqlB);
                    while(rs.next()){
                        usuarioSistema = rs.getString("usuarioSistema");
                        nombreCompleto = rs.getString("nombreCompleto");
                        codigo = rs.getString("codigo");
                        identificacionTributaria = rs.getString("identificacionTributaria");
                        nroDocumento = rs.getString("nroDocumento");
                        servicioActivo = rs.getString("servicioActivo");
                        codDocumento =  rs.getString("codDocumento");
                        nroCliente = rs.getString("nroCliente");
                        email = rs.getString("email");
                        int nroC = Integer.parseInt(nroCliente);
                        boolean servActivo = false;
                        if(servicioActivo.equals("S"))
                            servActivo = true;
                        personas.add(new Principal(usuarioSistema, nombreCompleto, new Empresa(identificacionTributaria), new Pais(codigo), nroC, email, nroDocumento, servActivo, new TipoDocumento(codDocumento)));
                    }
                    rs.close();
                    listaSQL.add(sqlB);
                    break;
                case "Modelo.Secundario":
                    sqlC = "SELECT Personas.usuarioSistema, Personas.nombreCompleto, Personas.codigo, Personas.identificacionTributaria, Secundarios.nroDocumento, Secundarios.nroCliente, Clientes.email from Personas, Clientes, Secundarios ";
                    if (filtro != null) {
                        sqlC += filtro;
                        sqlC += " AND Personas.usuarioSistema = Clientes.usuarioSistema AND Clientes.nroCliente = Secundarios.nroCliente AND Personas.eliminado='N' AND Secundarios.eliminado='N' ";
                    } else {
                        sqlC += " WHERE Personas.usuarioSistema = Clientes.usuarioSistema AND Clientes.nroCliente = Secundarios.nroCliente AND Personas.eliminado='N' AND Secundarios.eliminado='N' ";
                    }
                    rs=database.consultar(sqlC);
                    while(rs.next()){
                        usuarioSistema = rs.getString("usuarioSistema");
                        nombreCompleto = rs.getString("nombreCompleto");
                        codigo = rs.getString("codigo");
                        identificacionTributaria = rs.getString("identificacionTributaria");
                        nroDocumentoPrincipal = rs.getString("nroDocumento");
                        nroCliente = rs.getString("nroCliente");
                        email = rs.getString("Clientes.email");
                        int nroC = Integer.parseInt(nroCliente);
                        personas.add(new Secundario(usuarioSistema, nombreCompleto, new Empresa(identificacionTributaria), new Pais(codigo), nroC, email, new Principal(nroDocumentoPrincipal)));
                    }
                    rs.close();
                    listaSQL.add(sqlC);
                    break;
            }
        }
        catch(SQLException ex){
            registroConsola(this.usuarioSistema, listaSQL, "Búsqueda", ex.getLocalizedMessage());
            throw ex;
        }
        catch(Exception ex){
            registroConsola(this.usuarioSistema, listaSQL, "Búsqueda", ex.getLocalizedMessage());
            throw ex;
        }
        return personas;
    }

    @Override
    public LogSistema borradoMultiplePorIds(ArrayList<String> listaIds) throws Exception, SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
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
