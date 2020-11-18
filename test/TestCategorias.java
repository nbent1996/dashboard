/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import Datos.OpCategoria;
import Modelo.Categoria;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class TestCategorias {
    private OpCategoria op;
    public TestCategorias() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @After
    public void tearDown() {
    }
    
    @Before
    public void setUp() {
        op = new OpCategoria("bentancor");
    }
    
    @Test
    public void testINSERT() throws Exception {
        setUp();
        
        assertEquals("NOERROR", op.insertar(new Categoria("Categoria1")).getTextoError());
        assertEquals("NOERROR", op.insertar(new Categoria("Categoria2")).getTextoError());
        assertEquals("NOERROR", op.insertar(new Categoria("Categoria3")).getTextoError());
    }
}
