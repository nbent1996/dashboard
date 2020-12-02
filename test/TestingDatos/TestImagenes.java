package TestingDatos;

import Datos.OpImagen;
import Modelo.Funciones;
import Modelo.Imagen;
import java.sql.SQLException;
import static org.junit.Assert.fail;
import org.junit.Before;
import org.junit.Test;
public class TestImagenes {
    private OpImagen op;
    public TestImagenes() {
    }
    
    @Before
    public void setUp(){
        this.op = new OpImagen("bentancor");
    }
    @Test
    public void testINSERT(){
        try{
            byte[] bytes = Funciones.getArrayBytes("C:\\Users\\nicol\\Desktop\\Proyecto\\dashboard\\web\\resources\\alfacomLogo.png");
            Imagen c = new Imagen(bytes);
            op.insertar(c);
        }catch(SQLException ex){
            fail("FALLO en testSELECT");

        }catch(Exception ex){
            fail("FALLO en testSELECT");
        }
    }
    @Test
    public void testSELECT(){
        
    }
    @Test
    public void testUPDATE(){
    
    }
    @Test
    public void testDELETE(){
    
    }
}
