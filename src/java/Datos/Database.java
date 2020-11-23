package Datos;

import java.sql.*;
import java.util.ArrayList;

public class Database {

    /*Atributos*/
    private static Database instancia;
    private static Connection conexion;
    private static Statement stmt;
    
//    /*TRABAJANDO CON RDS*/
      private static String user = "root";
      private static String pass = "alfacom48282020!";
      private static String url = "jdbc:mysql://alfacomplatform.cx3teiukxfae.us-east-1.rds.amazonaws.com:3306/alfacomPlatform"+"?user="+user+"&password="+pass;
//    /*TRABAJANDO CON RDS*/
    
    /*TRABAJANDO CON INSTANCIA LOCAL*/
//     private static String user = "root";
//     private static String pass = "48283674";
//     private static String url = "jdbc:mysql://localhost:3306/alfacomPlatform"+"?user="+user+"&password="+pass+"&useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";

//    /*TRABAJANDO CON INSTANCIA LOCAL*/
    

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
            String errorTexto = "Codigo de Error: " + codigo + " // Mensaje: " + ex.getMessage();
            System.out.println(errorTexto);
            if (codigo == 0) {
                throw new SQLException(errorTexto);
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
            throw ex;
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
                conexion.rollback();
                conectar(url);
                throw ex;
            } catch (Exception ex) {
                System.out.println(ex.getMessage());
                throw ex;
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
                conexion.rollback();
                conectar(url);
                throw ex;
            } catch (Exception ex) {
                System.out.println(ex.getMessage());
                throw ex;
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
    /*Setters y Getters*/


}
