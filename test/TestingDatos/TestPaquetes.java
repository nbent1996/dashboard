package TestingDatos;

import Datos.OpPaquete;
import Modelo.Empresa;
import Modelo.Paquete;
import Modelo.TieneTP;
import Modelo.TipoDispositivo;
import java.sql.SQLException;
import java.util.ArrayList;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;
import org.junit.Before;
import org.junit.Test;

public class TestPaquetes {
    private OpPaquete op;
    public TestPaquetes() {
    }
    
    @Before
    public void setUp(){
        this.op = new OpPaquete("bentancor");
    }
    
    @Test
    public void testINSERT(){
        try{
            ArrayList<TieneTP> listaTieneTPp1 = new ArrayList<>();
            listaTieneTPp1.add(new TieneTP(5, new TipoDispositivo(3)));
            listaTieneTPp1.add(new TieneTP(2, new TipoDispositivo(2)));
            listaTieneTPp1.add(new TieneTP(1, new TipoDispositivo(1)));

            Paquete p1 = new Paquete(350, new Empresa("526283747346"), listaTieneTPp1);
            Paquete p2 = new Paquete(250, new Empresa("526283747346"));
            Paquete p3 = new Paquete(400, new Empresa("526283747346"));
            
            /*INSERCIONES DE PRUEBA*/
           assertEquals("NOERROR", this.op.insertar(p1).getTextoError());
           assertEquals("NOERROR", this.op.insertar(p2).getTextoError());
           assertEquals("NOERROR", this.op.insertar(p3).getTextoError());
        
        } catch (SQLException ex) {
            fail("Fallo en testINSERT");
        } catch (Exception ex) {
            fail("Fallo en testINSERT");
        }
    }
    @Test
    public void testSELECT(){
        try{
        //INSERCIONES PREVIAS
        ArrayList<TieneTP> listaTieneTPp2 = new ArrayList<>();
        listaTieneTPp2.add(new TieneTP(4, new TipoDispositivo(3)));
        listaTieneTPp2.add(new TieneTP(1, new TipoDispositivo(2)));
        listaTieneTPp2.add(new TieneTP(2, new TipoDispositivo(1)));
        Paquete p1 = new Paquete(350, new Empresa("729.193.500-80"));
        Paquete p2 = new Paquete(351, new Empresa("729.193.500-80"), listaTieneTPp2);
        this.op.insertar(p1);
        this.op.insertar(p2);
        
        //obtener los id de los paquetes insertados
        p1 = this.op.buscar(" WHERE identificacionTributaria='729.193.500-80' AND costo='350' ", null).get(0);
        p2 = this.op.buscar(" WHERE identificacionTributaria='729.193.500-80' AND costo='351' ", null).get(0);
       
        /*Búsqueda de un paquete sin lista TieneTP*/
        Paquete p1b = this.op.buscar(" WHERE idPaquete='"+p1.getIdPaquete()+"' ", null).get(0);
        assertTrue((this.op.buscar(" WHERE idPaquete='"+p1.getIdPaquete()+"' ", null).size()==1 && p1b.getListaTieneTP().isEmpty()));
        /*Búsqueda de un paquete con lista TieneTP*/
        Paquete p2b = this.op.buscar(" WHERE idPaquete='"+p2.getIdPaquete()+"' ", null).get(0);
        assertTrue((this.op.buscar(" WHERE idPaquete='"+p2.getIdPaquete()+"' ", null).size()==1 && p2b.getListaTieneTP().size()==3));
        /*Búsqueda de todos los paquetes*/
        assertTrue(!this.op.buscar(null,null).isEmpty());
        /*Búsqueda sin resultados*/
        assertTrue(this.op.buscar(" WHERE identificacionTributaria='IDENTIFICACION TRIBUTARIA INEXISTENTE'",null).isEmpty());

        } catch (SQLException ex) {
            fail("Fallo en testSELECT");
        } catch (Exception ex) {
            fail("Fallo en testSELECT");
        }
    }
    @Test
    public void testUPDATE(){
    
    }
    @Test
    public void testDELETE(){
    
    }
    @Test
    public void testDELETEMULTIPLE(){
    
    }
}
