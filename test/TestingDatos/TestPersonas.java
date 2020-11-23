/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TestingDatos;

import Datos.OpPersona;
import Modelo.Empresa;
import Modelo.Operador;
import Modelo.Pais;
import Modelo.Persona;
import Modelo.Principal;
import Modelo.Secundario;
import Modelo.TipoDocumento;
import Modelo.TipoUsuario;
import java.sql.SQLException;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

/**
 *
 * @author nicol
 */
public class TestPersonas {
    private OpPersona op;
    public TestPersonas() {
    }

    @Before
    public void setUp(){
        this.op = new OpPersona("bentancor");
    }
    
    @Test
    public void testINSERT(){
        try {
            /*INSERT OPERADOR*/
            assertEquals("NOERROR", this.op.insertar(new Operador("hernandez_g", "hernandez_g", "Gabriel Hernandez",new Empresa("526283747346"), new Pais("URU"), new TipoUsuario("marketing"))).getTextoError());
            assertEquals("NOERROR", this.op.insertar(new Operador("medina", "medina", "Gabriel Medina",new Empresa("526283747346"), new Pais("URU"), new TipoUsuario("administrador"))).getTextoError());
            assertEquals("NOERROR", this.op.insertar(new Operador("gargano", "gargano", "Ivana Gargano",new Empresa("526283747346"), new Pais("URU"), new TipoUsuario("operador"))).getTextoError());

            /*INSERT PRINCIPAL*/
            assertEquals("NOERROR", this.op.insertar(new Principal("ZWeQFtdcA4", "Adrian Gambini",new Empresa("526283747346"), new Pais("URU"), -1,"gambini@gmail.com", "16432548", false, new TipoDocumento("CI-UYU"))).getTextoError());
            assertEquals("NOERROR", this.op.insertar(new Principal("e8m7665Af9", "Arturo Rodríguez",new Empresa("526283747346"), new Pais("URU"), -1,"rodriguezART@gmail.com", "14675232", false, new TipoDocumento("CI-UYU"))).getTextoError());
            assertEquals("NOERROR", this.op.insertar(new Principal("S6CYKAFyyR", "Gabriela Sanabria",new Empresa("526283747346"), new Pais("URU"), -1,"sanabriaGAB@gmail.com", "24563218", false, new TipoDocumento("CI-UYU"))).getTextoError());
            
            /*INSERT SECUNDARIO*/
            assertEquals("NOERROR", this.op.insertar(new Secundario("xTzXW5MQgu", "Guillermo Gambini", new Empresa("526283747346"),  new Pais("URU"), -1, "gambiniGUI@hotmail.com", new Principal("16432548"))).getTextoError());
            assertEquals("NOERROR", this.op.insertar(new Secundario("ATHr3AyFUn", "Patricia Rodríguez", new Empresa("526283747346"),  new Pais("URU"), -1, "rodriguezPAT@hotmail.com", new Principal("14675232"))).getTextoError());
            assertEquals("NOERROR", this.op.insertar(new Secundario("MZYRu5T6WX", "Claudio Ureta", new Empresa("526283747346"),  new Pais("URU"), -1, "uretaCLA@hotmail.com", new Principal("24563218"))).getTextoError());

        } catch (SQLException ex) {
            fail("Fallo en testINSERT");
        } catch (Exception ex) {
            fail("Fallo en testINSERT");
        }
    }
    @Test
    public void testSELECT(){
        
        try{
        //Seleccionando Operadores
             //Búsqueda de un operador
            assertTrue(this.op.buscar(" WHERE OperadoresDashboard.usuarioSistema='bentancor' ","Modelo.Operador").size()==1);                           
            //Búsqueda de todos los operadores
            assertTrue(!this.op.buscar(null, "Modelo.Operador").isEmpty());
            //Búsqueda sin resultados
            assertTrue(this.op.buscar(" WHERE clave='CLAVE INEXISTENTE' ", "Modelo.Operador").isEmpty());
        //Seleccionando Principales
            //Búsqueda de un principal
            assertTrue(this.op.buscar(" WHERE Principales.nroDocumento='14675232' ", "Modelo.Principal").size()==1);
            //Búsqueda de todos los principales
            assertTrue(!this.op.buscar(null, "Modelo.Principal").isEmpty());
            //Búsqueda sin resultados
            assertTrue(this.op.buscar(" WHERE Principales.nroDocumento='NRODOCUMENTO INEXISTENTE'", "Modelo.Principal").isEmpty());

        //Seleccionando Secundarios
            //Búsqueda de un secundario
            assertTrue(this.op.buscar(" WHERE Secundarios.nroCliente='11' ","Modelo.Secundario").size()==1);
            //Búsqueda de todos los secundarios
            assertTrue(!this.op.buscar(null, "Modelo.Secundario").isEmpty());
            //Búsqueda sin resultados
            assertTrue(this.op.buscar(" WHERE Secundarios.nroDocumento='NRODOCUMENTO INEXISTENTE'", "Modelo.Secundario").isEmpty());

        } catch (SQLException ex) {
            fail("Fallo en testSELECT");
        } catch (Exception ex) {
            fail("Fallo en testSELECT");
        }
    }
    @Test
    public void testUPDATE(){
            Operador oAnterior=new Operador("hernandez_n", "hernandez_n", "Nicolás Hernandez",new Empresa("526283747346"), new Pais("URU"), new TipoUsuario("marketing"));
            Principal pAnterior = new Principal("NBk88tRVnL", "Mar Benitez",new Empresa("526283747346"), new Pais("URU"), -1,"benitezMAR@gmail.com", "16432500", false, new TipoDocumento("CI-UYU"));
            Secundario sAnterior = new Secundario("dmKvRTFcZ8", "Mónica Bentancor", new Empresa("526283747346"),  new Pais("URU"), -1, "bentancorMON@hotmail.com", new Principal("16432500"));
            
            Operador o = oAnterior;
            //Modificaciones planteadas a Operador
            o.setUsuarioSistema("hernandez_na");
            o.setNombreCompleto("Nicolás Alejandro Hernandez");
            o.setClave("CLAVE NUEVA");
            o.getTipoUsuario().setNombre("administrador");
            
            Principal p = pAnterior;
            //Modificaciones Planteadas a Principal
            p.setNombreCompleto("María Benitez");
            p.setEmail("benitezMARIA@outlook.com");
            p.setServicioActivo(true);

            Secundario s = sAnterior;
            //Modificaciones planteadas a Secundario
            s.setNombreCompleto("Alejandra Bentancor");
            s.setEmail("bentancorALE@ort.edu.uy");
            s.getPrincipalAsociado().setNroDocumento("14675232"); //OTRO PRINCIPAL PROVISTO EN LA PRECARGA DE LA BASE DE DATOS
            try{
           /*INSERCIONES PREVIAS*/
           /*OPERADOR*/   this.op.insertar(oAnterior);
           /*PRINCIPAL*/  this.op.insertar(pAnterior);
           /*SECUNDARIO*/ this.op.insertar(sAnterior);
           Secundario sAnteriorConId = (Secundario) this.op.buscar(" WHERE Personas.usuarioSistema='dmKvRTFcZ8' ", "Modelo.Secundario").get(0);        

           
           //UPDATE A OPERADOR
           assertEquals("NOERROR", this.op.modificar(oAnterior, o).getTextoError());
           //UPDATE A PRINCIPAL
           assertEquals("NOERROR", this.op.modificar(pAnterior, p).getTextoError());
           //UPDATE A SECUNDARIO
           assertEquals("NOERROR", this.op.modificar(sAnteriorConId, s).getTextoError());
            } catch (SQLException ex) {
            fail("Fallo en testUPDATE");
        } catch (Exception ex) {
            fail("Fallo en testUPDATE");
        }
            
    }
    @Test
    public void testDELETE(){
        Principal p = new Principal("NBk88tRVnV", "Verónica Benitez",new Empresa("526283747346"), new Pais("URU"), -1,"benitezVER@gmail.com", "16432549", false, new TipoDocumento("CI-UYU"));
        try{
        //INSERCIONES PREVIAS
           /*OPERADOR*/   this.op.insertar(new Operador("hernandez_a", "hernandez_a", "Alberto Hernandez",new Empresa("526283747346"), new Pais("URU"), new TipoUsuario("marketing")));
           /*PRINCIPAL*/  this.op.insertar(p);
           /*SECUNDARIO*/ this.op.insertar(new Secundario("dmKvRTFcZ7", "Camila Bentancor", new Empresa("526283747346"),  new Pais("URU"), -1, "bentancorCAM@hotmail.com", new Principal("16432549")));
        
        //BORRANDO OPERADOR
        assertEquals("NOERROR", this.op.borrar(new Operador("hernandez_a")).getTextoError());
        //BORRANDO SECUNDARIO
            //AVERIGUANDO NRO CLIENTE DEL SECUNDARIO dmKvRTFcZ7
            Secundario s = (Secundario) this.op.buscar(" WHERE Personas.usuarioSistema='dmKvRTFcZ7' ", "Modelo.Secundario").get(0);        
        assertEquals("NOERROR", this.op.borrar(s).getTextoError());
        //BORRANDO PRINCIPAL
        
        assertEquals("NOERROR", this.op.borrar(p).getTextoError());

        } catch (SQLException ex) {
            fail("Fallo en testDELETE");
        } catch (Exception ex) {
            fail("Fallo en testDELETE");
        }
    }
    @Ignore
    public void testDELETEMULTIPLE(){
        /*NO IMPLEMENTADO EN EL OBJETO DAO*/
    }
    
}
