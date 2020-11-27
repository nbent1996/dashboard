package TestingModelo;

import org.junit.Before;
import org.junit.Test;
import Modelo.Funciones;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
public class TestFunciones {
    
    public TestFunciones() {
    }

    @Before
    public void setUp(){
    
    }
    @Test
    public void testCadenaAleatoria(){
        String str1 = Funciones.generarCadenaAleatoria(1);
        String str2 = Funciones.generarCadenaAleatoria(10);
        String str3 = Funciones.generarCadenaAleatoria(0);
        assertEquals(1, str1.length());
        assertEquals(10, str2.length());
        assertEquals(0, str3.length());
        System.out.println(str1);
        System.out.println(str2);
        System.out.println(str3);
        
    }
    @Test
    public void testIsNumeric(){
        assertTrue(!Funciones.isNumeric("adsfadsfads"));
        assertTrue(Funciones.isNumeric(""));
        assertTrue(Funciones.isNumeric("1156651"));
    }
}
