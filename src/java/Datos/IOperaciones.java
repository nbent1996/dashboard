package Datos;
import java.sql.SQLException;
import java.util.ArrayList;
public interface IOperaciones <T> {
    public void guardar (T cAnterior, T c) throws Exception, SQLException;
    public void insertar (T c)throws Exception, SQLException;
    public void modificar (T cAnterior, T c)throws Exception, SQLException;
    public void borrar(T c)throws Exception, SQLException;
    public ArrayList<T> obtenerTodos()throws Exception, SQLException;
    public ArrayList<T> buscar(String filtro, String extras)throws Exception, SQLException;
    public boolean existsAllID(ArrayList<Integer> lista) throws Exception, SQLException;
    public boolean borradoMultiplePorIds(ArrayList<Integer> listaIds) throws Exception, SQLException;
    public void registroConsola(ArrayList<String> listaSQL, String operacion, String textoError);
}
