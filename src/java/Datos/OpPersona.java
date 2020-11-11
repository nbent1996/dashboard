package Datos;

import Modelo.Operador;
import Modelo.Persona;
import Modelo.Principal;
import Modelo.Secundario;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class OpPersona implements IOperaciones<Persona> {

    
/*Estado*/
private static Database database;
/*Estado*/

/*Constructores*/
public OpPersona(){
    this.database = Database.getInstancia();
}
/*Constructores*/

/*Comportamiento*/
@Override
    public void guardar(Persona cAnterior, Persona c) throws Exception, SQLException {
        if(cAnterior == null){
            insertar(c);
        }else{
            modificar(cAnterior, c);
        }
    }

    @Override
    public void insertar(Persona c) throws Exception, SQLException {
        ArrayList<String> listaSQL = new ArrayList<>();
        String sqlA = "INSERT INTO Personas (usuarioSistema, nombreCompleto, codigo, identificacionTributaria) values "
                + "('"+c.getUsuarioSistema()+"','"+c.getNombreCompleto()+"','"+c.getPaisResidencia().getCodigo()+"','"+c.getEmpresaAsociada().getIdentificacionTributaria()+"')";
        listaSQL.add(sqlA);
        String sqlB, sqlC, sqlD;
        switch(c.getClass().getName()){
            case "Principal":
            Principal principal = (Principal) c;
            sqlB = "INSERT INTO Principales (nroDocumento, servicioActivo, usuarioSistema, nroCliente, codDocumento) values "
                    + "('"+principal.getNroDocumento()+"','N','"+principal.getUsuarioSistema()+"','"+principal.getNroCliente()+"','"+principal.getTipoDocumento().getCodDocumento()+"')";
            listaSQL.add(sqlB);
            break;
            case "Secundario":
            Secundario secundario = (Secundario) c;
            sqlC = "INSERT INTO Secundarios (nroCliente, nroDocumento) values ('"+secundario.getNroCliente()+"','"+secundario.getPrincipalAsociado().getNroDocumento()+"')";
            listaSQL.add(sqlC);
            break;
            case "Operador":
            Operador operador = (Operador) c;
            sqlD = "INSERT INTO OperadoresDashboard (usuarioSistema, clave, nombre) values "
                    + "('"+operador.getUsuarioSistema()+"',SHA('"+operador.getClave()+"'),'"+operador.getTipoUsuario().getNombre()+"')";
            listaSQL.add(sqlD);
            break;
        }
        database.actualizarMultiple(listaSQL, "INSERT");
        registroConsola(listaSQL, "Alta", "NOERROR");
    }

    @Override
    public void modificar(Persona cAnterior, Persona c) throws Exception, SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void borrar(Persona c) throws Exception, SQLException {
        ResultSet validarDependencias = null;
        ArrayList<String> listaSQL = new ArrayList<>();
        String sqlA, sqlB, sqlC, sqlD, sqlE;
        sqlA = "UPDATE Personas SET eliminado='Y' where usuarioSistema='"+c.getUsuarioSistema()+"'";
        switch(c.getClass().getName()){
            case "Operador":
                Operador operador = (Operador) c;
                sqlB = "UPDATE OperadoresDashboard SET eliminado='Y' where usuarioSistema='"+operador.getUsuarioSistema()+"'";
            break;
            case "Principal":
                Principal principal = (Principal) c;
                sqlC = "UPDATE Principales SET eliminado='Y' where nroDocumento='"+principal.getNroDocumento()+"'";
            break;
            
            case "Secundario":
                Secundario secundario = (Secundario) c;
                sqlD = "UPDATE Secundarios SET eliminado='Y' where "
            break;

        }
    }

    @Override
    public ArrayList<Persona> obtenerTodos() throws Exception, SQLException {
        return buscar(null, null);
    }

    @Override
    public ArrayList<Persona> buscar(String filtro, String extras) throws Exception, SQLException {
        ArrayList<Persona> personas = new ArrayList<>();
        return null;
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
    public void registroConsola(ArrayList<String> listaSQL, String operacion, String textoError) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
/*Comportamiento*/

/*Getters y Setters*/

/*Getters y Setters*/
}
