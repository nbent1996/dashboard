package TestingDatos;

import Datos.OpTipoDocumento;
import Modelo.TipoDocumento;
import java.sql.SQLException;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.fail;
import static org.junit.Assert.*;

public class TestTiposDocumento {
    private OpTipoDocumento op;
    public TestTiposDocumento() {
    }
    
    @Before
    public void setUp() {
        op = new OpTipoDocumento("bentancor");
    }

    @Test
    public void testSELECT(){
        
        try{       
        /*Búsqueda de un tipo documento*/
        assertTrue(op.buscar(" WHERE nombreDocumento = 'Cédula de Ciudadanía Colombiana' ",null).size()==1 );
        
        /*Búsqueda de tipo documento que no existe*/
        assertTrue(op.buscar(" WHERE nombreDocumento = 'TIPO DOCUMENTO QUE NO EXISTE' ",null).isEmpty());
        
        /*Búsqueda de todos los tipos documento*/
        assertTrue(!op.buscar(null,null).isEmpty() ); 
        
        }catch(SQLException ex){
            fail("FALLO en testSELECT");

        }catch(Exception ex){
            fail("FALLO en testSELECT");
        }
    }
}
