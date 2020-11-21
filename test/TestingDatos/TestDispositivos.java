package TestingDatos;

import Datos.OpDispositivo;
import Modelo.Dispositivo;
import Modelo.Empresa;
import Modelo.Principal;
import Modelo.TipoDispositivo;
import java.sql.SQLException;
import java.util.ArrayList;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;
import org.junit.Before;
import org.junit.Test;
public class TestDispositivos {
    private OpDispositivo op;

    public TestDispositivos() {
    }

    @Before
    public void setUp() {
        this.op = new OpDispositivo("bentancor");
    }

    @Test
    public void testINSERT() {
        try {
            assertEquals("NOERROR", this.op.insertar(new Dispositivo("R3NB54YQE9H2B44", "Nuevo", new TipoDispositivo(1),new Empresa("902.237.970-14"),null)).getTextoError());
            assertEquals("NOERROR", this.op.insertar(new Dispositivo("FZ7Q577PPXZFK8C", "Usado-OK", new TipoDispositivo(1),new Empresa("902.237.970-14"),null)).getTextoError());
            assertEquals("NOERROR", this.op.insertar(new Dispositivo("ZN7SXEVJPYP2XMX", "Usado-Reparar", new TipoDispositivo(1),new Empresa("189.68045.54-8"),new Principal(2))).getTextoError());
            assertEquals("NOERROR", this.op.insertar(new Dispositivo("5FAADVZRJBMKSVL", "Nuevo", new TipoDispositivo(1),new Empresa("189.68045.54-8"), new Principal(4))).getTextoError()); 
        } catch (SQLException ex) {
            fail("Fallo en testINSERT");
        } catch (Exception ex) {
            fail("Fallo en testINSERT");
        }

    }

    @Test
    public void testUPDATE() {
        try {
            ArrayList<Dispositivo> lista = new ArrayList<>();
            lista.add(new Dispositivo("R3NB54YQE9H2B44", "Nuevo", new TipoDispositivo(1),new Empresa("902.237.970-14"),null));
            lista.add(new Dispositivo("FZ7Q577PPXZFK8C", "Usado-OK", new TipoDispositivo(1),new Empresa("902.237.970-14"),null));
            lista.add(new Dispositivo("ZN7SXEVJPYP2XMX", "Usado-Reparar", new TipoDispositivo(1),new Empresa("189.68045.54-8"),new Principal(2)));
            lista.add(new Dispositivo("5FAADVZRJBMKSVL", "Nuevo", new TipoDispositivo(1),new Empresa("189.68045.54-8"), new Principal(4)));
            
            assertEquals("NOERROR", this.op.modificar(lista.get(0), new Dispositivo("R3NB54YQE9H2B44", "Nuevo", new TipoDispositivo(1),new Empresa("902.237.970-14"),new Principal(2))).getTextoError()); /*CAMBIA NROCLIENTE*/
            assertEquals("NOERROR", this.op.modificar(lista.get(1), new Dispositivo("FZ7Q577PPXZFK8C", "Usado-Reparar", new TipoDispositivo(1),new Empresa("902.237.970-14"),null)).getTextoError()); /*CAMBIA ESTADO*/
            assertEquals("NOERROR", this.op.modificar(lista.get(2), new Dispositivo("ZN7SXEVJPYP2XMX", "Usado-Reparar", new TipoDispositivo(2),new Empresa("189.68045.54-8"),new Principal(2))).getTextoError()); /*CAMBIA ID TIPO DISPOSITIVO*/
            assertEquals("NOERROR", this.op.modificar(lista.get(3), new Dispositivo("5FAADVZRJBMKSVL", "Usado-OK", new TipoDispositivo(3),new Empresa("189.68045.54-8"), new Principal(1))).getTextoError()); /*CAMBIA NROCLIENTE, ESTADO Y IDTIPODISPOSITIVO*/
            
        } catch (SQLException ex) {
            fail("Fallo en testUPDATE");
        } catch (Exception ex) {
            fail("Fallo en testUPDATE");
        }

    }

    @Test
    public void testDELETE() {
        try {
            ArrayList<Dispositivo> lista = new ArrayList<>();
            lista.add(new Dispositivo("R3NB54YQE9H2B44"));
            lista.add(new Dispositivo("FZ7Q577PPXZFK8C", "Usado-OK", new TipoDispositivo(1),new Empresa("902.237.970-14"),null));

            
            assertEquals("NOERROR", this.op.borrar(lista.get(0)).getTextoError());
            assertEquals("NOERROR", this.op.borrar(lista.get(1)).getTextoError()); /*BORRAMOS UN DISPOSITIVO CON TODOS LOS DATOS Y OTRO CON SOLO EL NRO DE SERIE*/
            
        } catch (SQLException ex) {
            fail("Fallo en testDELETE");
        } catch (Exception ex) {
            fail("Fallo en testDELETE");
        }

    }

    @Test
    public void testSELECT() {
        try {
            assertEquals(op.buscar(" WHERE identificacionTributaria='EMPRESA QUE NO EXISTE' ", null).size(), 0); /*BÚSQUEDA SIN RESULTADOS*/
            assertEquals(op.buscar(null, null).size(), 40); /*BÚSQUEDA DE TODO*/
            assertEquals(op.buscar(" WHERE identificacionTributaria='729.193.500-80' ", null).size(), 4); /*FILTRAMOS POR IDENTIFICACION TRIBUTARIA*/

        } catch (SQLException ex) {
            fail("Fallo en testSELECT");
        } catch (Exception ex) {
            fail("Fallo en testSELECT");
        }

    }

    @Test
    public void testDELETEMULTIPLE() {
        try {
            ArrayList<Dispositivo> lista = new ArrayList<>();
            ArrayList<String> listaStr = new ArrayList<>();
            lista.add(new Dispositivo("ZN7SXEVJPYP2XMX", "Usado-Reparar", new TipoDispositivo(1),new Empresa("189.68045.54-8"),new Principal(2)));
            lista.add(new Dispositivo("5FAADVZRJBMKSVL"));
            
            listaStr.add("ZN7SXEVJPYP2XMX");
            listaStr.add("5FAADVZRJBMKSVL");
            
            assertEquals("NOERROR", this.op.borradoMultiplePorIds(listaStr).getTextoError());
            
          } catch (SQLException ex) {
            fail("Fallo en testDELETEMULTIPLE");
        } catch (Exception ex) {
            fail("Fallo en testDELETEMULTIPLE");
        }

    }

}
