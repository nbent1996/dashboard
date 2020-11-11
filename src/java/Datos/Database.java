package Datos;

import java.sql.*;
import java.util.ArrayList;

public class Database {

    /*Atributos*/
    private static Database instancia;
    private static Connection conexion;
    private static Statement stmt;
    private static String user = "administrador";
    private static String pass = "39475109";
    //private static String url= "jdbc:mysql://192.168.0.99:3306" + "/binstalaciones" + "?user=" + user + "&password=" + pass;
    private static String url = "jdbc:mysql://localhost/barometricaColon"+"?user="+user+"&password="+pass;
    private static String ejecucion = "";
    /*Atributos*/
 /*Constructores*/

 /*Constructores*/
 /*Comportamiento*/
    public static Database getInstancia() {
        if (instancia == null) {
            instancia = new Database();
        }
        return instancia;
    }

    public void conectar(String url) throws SQLException {
        try {
            conexion = DriverManager.getConnection(url);
            conexion.setAutoCommit(false);
            stmt = conexion.createStatement();
        } catch (SQLException ex) {
            int codigo = ex.getErrorCode();
            String errorTexto = "Codigo de Error: " + codigo;
            System.out.println(errorTexto);
            System.out.println("Error en: " + this.getClass());

            if (codigo == 0) {
                throw new SQLException("No hay conexión con el servidor.");
            }
        }
    }

    public void desconectar() {
        try {
            if (conexion != null) {
                conexion.close();
                conexion=null;
                stmt=null;
                
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public int actualizar(String sql) throws SQLException {
        try {
            conectar(url);
            return stmt.executeUpdate(sql);
        } catch (SQLException ex) {
            String error = "Error de actualizacion con la consulta: " + sql + " - " + ex.getMessage();
            System.out.println(error);
            return -1;
        } finally {
            if (conexion != null && !conexion.isClosed()) {
                conexion.close();
            }
        }
    }

    public boolean actualizarMultiple(ArrayList<String> sql, String modoQuery) throws SQLException {
        conectar(url);
        String error = "";
        int idGenerado = -1;
        conexion.setAutoCommit(false);
        for (int i = 0; i <= sql.size() - 1; i++) {
            String sentencia = sql.get(i);
            try {
                if (modoQuery.equals("INSERT")) {
                    if (!sentencia.contains("?") && !"".equals(sentencia)) {
                        PreparedStatement psConId = conexion.prepareStatement(sentencia, Statement.RETURN_GENERATED_KEYS);
                        psConId.executeUpdate();
                        ResultSet generatedKeys = psConId.getGeneratedKeys();
                        generatedKeys.next();
                        idGenerado = generatedKeys.getInt(1);
                    } else {
                        PreparedStatement ps = conexion.prepareStatement(sentencia);
                        ps.setInt(1, idGenerado);
                        ps.executeUpdate();
                    }
                }
                if (modoQuery.equals("UPDATE") || modoQuery.equals("DELETE")) {
                    stmt.executeUpdate(sentencia);
                }
            } catch (SQLException ex) {
                error = "Error de actualizacion con la consulta: " + sentencia + " - " + ex.getMessage();
                error = error.replace("'", "");
                System.out.println(error);
                conexion.rollback();
                conectar(url);
                actualizar("INSERT INTO LogErrores (textoError) values ('" + error + "')");
                return false;
            } catch (Exception ex) {
                System.out.println(ex.getMessage());
                return false;
            }
        }
        conexion.commit();
        if (conexion != null && !conexion.isClosed()) {
            conexion.close();
        }
        return true;

    }

    public boolean actualizarMultiple(ArrayList<String> sql, String modoQuery, String clave) throws SQLException {
        conectar(url);
        String error = "";
        conexion.setAutoCommit(false);
        for (int i = 0; i <= sql.size() - 1; i++) {
            String sentencia = sql.get(i);
            try {
                if (modoQuery.equals("INSERT")) {
                    if (!sentencia.contains("?")) {
                        PreparedStatement psConId = conexion.prepareStatement(sentencia);
                        psConId.executeUpdate();
                    } else {
                        PreparedStatement ps = conexion.prepareStatement(sentencia);
                        ps.setString(1, clave);
                        ps.executeUpdate();
                    }
                }
                if (modoQuery.equals("UPDATE") || modoQuery.equals("DELETE")) {
                    stmt.executeUpdate(sentencia);
                }

            } catch (SQLException ex) {
                error = "Error de actualizacion con la consulta: " + sentencia + " - " + ex.getMessage();
                error = error.replace("'", "");
                System.out.println(error);
                conexion.rollback();
                conectar(url);
                actualizar("INSERT INTO LogErrores (textoError) values ('" + error + "')");
                return false;
            } catch (Exception ex) {
                System.out.println(ex.getMessage());
                return false;
            }

        }
        conexion.commit();
        if (conexion != null && !conexion.isClosed()) {
            conexion.close();
        }
        return true;
    }

    public ResultSet consultar(String sql) throws Exception, SQLException {
        try {
            conectar(url);
            ResultSet rs = stmt.executeQuery(sql);
            return rs;
        } catch (SQLException ex) {
            String errorTexto = "Error de consulta: " + sql + " - " + ex.getMessage();
            System.out.println(errorTexto);
            errorTexto = errorTexto.replace("'", "");
            actualizar("INSERT INTO LogErrores (textoError) values ('" + errorTexto + "')");
            throw ex;
        }
        
    }

    /*Comportamiento*/
 /*Setters y Getters*/
    public static Connection getConexion() {
        return conexion;
    }

    public static String getUrl() {
        return url;
    }

    public static String getUser() {
        return user;
    }

    public static String getPass() {
        return pass;
    }

    public static String getEjecucion() {
        return ejecucion;
    }

    public static void setEjecucion(String ejecucion) {
        Database.ejecucion = ejecucion;
    }    
    /*Setters y Getters*/


}
