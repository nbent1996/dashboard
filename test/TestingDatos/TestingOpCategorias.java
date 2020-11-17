package TestingDatos;

import Datos.OpCategoria;
import Modelo.Categoria;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class TestingOpCategorias {
    private OpCategoria op;
    public TestingOpCategorias() {
    }
    
    @BeforeAll
    public void setUp() {
        op = new OpCategoria("bentancor");
    }
    
    @Test
    public void testINSERT() throws Exception {
        assertEquals("NOERROR", op.insertar(new Categoria("Categoria1")).getTextoError());
        assertEquals("NOERROR", op.insertar(new Categoria("Categoria2")).getTextoError());
        assertEquals("NOERROR", op.insertar(new Categoria("Categoria3")).getTextoError());
    }
}
