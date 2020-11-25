package TestingDatos;

import Datos.OpSuscripcion;
import Modelo.Suscripcion;
import Resources.DTOs.DTOFechas;
import Resources.DTOs.Fecha;
import java.sql.SQLException;
import java.util.ArrayList;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;
import org.junit.Before;
import org.junit.Test;

public class TestSuscripciones {
    
    private OpSuscripcion op;
    public TestSuscripciones() {
    }
    
    @Before
    public void setUp(){
        this.op = new OpSuscripcion("bentancor");
    }
    
    @Test
    public void testINSERT(){
        try{
            Suscripcion s1 = new Suscripcion(new DTOFechas(new Fecha(24,11,2020)), 1, new DTOFechas(new Fecha(1,1,1970)),true);
            Suscripcion s2 = new Suscripcion(new DTOFechas(new Fecha(23,11,2020)), 0.5F, new DTOFechas(new Fecha(1,1,1970)),true);
            Suscripcion s3 = new Suscripcion(new DTOFechas(new Fecha(25,11,2020)), 2, new DTOFechas(new Fecha(1,1,1970)),true);
            Suscripcion s4 = new Suscripcion(new DTOFechas(new Fecha(30,10,2020)), 1.5F, new DTOFechas(new Fecha(1,1,1970)),true);

            
            assertEquals("NOERROR", this.op.insertar(s1).getTextoError());
            assertEquals("NOERROR", this.op.insertar(s2).getTextoError());
            assertEquals("NOERROR", this.op.insertar(s3).getTextoError());
            assertEquals("NOERROR", this.op.insertar(s4).getTextoError());

            
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
            Suscripcion s1 = new Suscripcion(new DTOFechas(new Fecha(23,11,2020)), 1, new DTOFechas(new Fecha(1,1,1970)),true);
            Suscripcion s2 = new Suscripcion(new DTOFechas(new Fecha(19,11,2018)), 2, new DTOFechas(new Fecha(20,11,2020)),false);
            Suscripcion s3 = new Suscripcion(new DTOFechas(new Fecha(24,11,2019)), 1, new DTOFechas(new Fecha(25,11,2020)),false);
            Suscripcion s4 = new Suscripcion(new DTOFechas(new Fecha(29,10,2020)), 1.5F, new DTOFechas(new Fecha(1,1,1970)),true);
            this.op.insertar(s1);
            this.op.insertar(s2);
            this.op.insertar(s3);
            this.op.insertar(s4);
    
            //Búsqueda de una suscripción
            String activaStr = "S";
            if(!s1.getActiva()){
                activaStr = "N";
            }
            assertTrue(this.op.buscar(" WHERE fechaInicio='"+s1.getFechaInicio().getFechaAStr(1)+"' AND tiempoContrato='"+s1.getTiempoContrato()+"' AND fechaFin='"+s1.getFechaFin().getFechaAStr(1) +"' AND activa = '"+activaStr+"' ", null).size()==1);
            //Búsqueda de todas las suscripciones
            assertTrue(!this.op.buscar(null,null).isEmpty());
            //Búsqueda sin resultados
            assertTrue(this.op.buscar(" WHERE fechaInicio='2050-02-02' ", null).isEmpty());
            
        } catch (SQLException ex) {
            fail("Fallo en testSELECT");
        } catch (Exception ex) {
            fail("Fallo en testSELECT");
        }
    }
    @Test
    public void testUPDATE(){
        try{
             //INSERCIONES PREVIAS
            Suscripcion s1Anterior = new Suscripcion(new DTOFechas(new Fecha(15,11,2020)), 1, new DTOFechas(new Fecha(1,1,1970)),true);
            Suscripcion s2Anterior = new Suscripcion(new DTOFechas(new Fecha(15,11,2018)), 2, new DTOFechas(new Fecha(20,11,2020)),false);
            this.op.insertar(s1Anterior);
            this.op.insertar(s2Anterior);
            
            //UBICANDO LOS ID ANTERIORES
            String activaStrS1 = "S";
            if (!s1Anterior.getActiva()) {
                activaStrS1 = "N";
            }
            String activaStrS2 = "S";
            if (!s2Anterior.getActiva()) {
                activaStrS2 = "N";
            }
            
            s1Anterior = this.op.buscar(" WHERE fechaInicio='"+s1Anterior.getFechaInicio().getFechaAStr(1)+"' AND tiempoContrato='"+s1Anterior.getTiempoContrato()+"' AND fechaFin='"+s1Anterior.getFechaFin().getFechaAStr(1) +"' AND activa = '"+activaStrS1+"' ",null).get(0);
            s2Anterior = this.op.buscar("WHERE fechaInicio='"+s2Anterior.getFechaInicio().getFechaAStr(1)+"' AND tiempoContrato='"+s2Anterior.getTiempoContrato()+"' AND fechaFin='"+s2Anterior.getFechaFin().getFechaAStr(1) +"' AND activa = '"+activaStrS2+"' ",null).get(0);

            //Modificaciones Planteadas
            Suscripcion s1 = s1Anterior;
            Suscripcion s2 = s2Anterior;
            s1.setActiva(false);
            s1.setFechaFin(new DTOFechas(new Fecha(27,11,2020)));
            s1.setTiempoContrato(0);
            
            s2.setFechaInicio(new DTOFechas(new Fecha(22,12,2018)));
            s2.setFechaFin(new DTOFechas(new Fecha(1,1,1970)));
            s2.setTiempoContrato(4);
            s2.setActiva(true);
            
            //PROBANDO UPDATE DE SUSCRIPCIONES
            assertEquals("NOERROR", this.op.modificar(s1Anterior, s1).getTextoError());
            assertEquals("NOERROR", this.op.modificar(s2Anterior, s2).getTextoError());
            
            
        } catch (SQLException ex) {
            fail("Fallo en testUPDATE");
        } catch (Exception ex) {
            fail("Fallo en testUPDATE");
        }
    }
    @Test
    public void testDELETE(){
        try{
           //INSERCIONES PREVIAS
            Suscripcion s1 = new Suscripcion(new DTOFechas(new Fecha(26,11,2020)), 1, new DTOFechas(new Fecha(1,1,1970)),true);
            Suscripcion s2 = new Suscripcion(new DTOFechas(new Fecha(22,11,2018)), 2, new DTOFechas(new Fecha(20,11,2020)),false);
            this.op.insertar(s1);
            this.op.insertar(s2);
            
            //UBICANDO LOS ID DE SUSCRIPCION
            String activaStrS1 = "S";
            if (!s1.getActiva()) {
                activaStrS1 = "N";
            }
            String activaStrS2 = "S";
            if (!s2.getActiva()) {
                activaStrS2 = "N";
            }
            
            s1 = this.op.buscar(" WHERE fechaInicio='"+s1.getFechaInicio().getFechaAStr(1)+"' AND tiempoContrato='"+s1.getTiempoContrato()+"' AND fechaFin='"+s1.getFechaFin().getFechaAStr(1) +"' AND activa = '"+activaStrS1+"' ",null).get(0);
            s2 = this.op.buscar("WHERE fechaInicio='"+s2.getFechaInicio().getFechaAStr(1)+"' AND tiempoContrato='"+s2.getTiempoContrato()+"' AND fechaFin='"+s2.getFechaFin().getFechaAStr(1) +"' AND activa = '"+activaStrS2+"' ",null).get(0);

            
            //PROBANDO BORRADO
            assertEquals("NOERROR", this.op.borrar(s1).getTextoError());
            assertEquals("NOERROR", this.op.borrar(s2).getTextoError());

        
        } catch (SQLException ex) {
            fail("Fallo en testDELETE");
        } catch (Exception ex) {
            fail("Fallo en testDELETE");
        }
    }
    @Test
    public void testDELETEMULTIPLE(){
        try{
        //INSERCIONES PREVIAS
            Suscripcion s1 = new Suscripcion(new DTOFechas(new Fecha(26,11,2020)), 1, new DTOFechas(new Fecha(1,1,1970)),true);
            Suscripcion s2 = new Suscripcion(new DTOFechas(new Fecha(22,11,2018)), 2, new DTOFechas(new Fecha(20,11,2020)),false);
            this.op.insertar(s1);
            this.op.insertar(s2);
            
            //UBICANDO LOS ID DE SUSCRIPCION
            String activaStrS1 = "S";
            if (!s1.getActiva()) {
                activaStrS1 = "N";
            }
            String activaStrS2 = "S";
            if (!s2.getActiva()) {
                activaStrS2 = "N";
            }
            
            s1 = this.op.buscar(" WHERE fechaInicio='"+s1.getFechaInicio().getFechaAStr(1)+"' AND tiempoContrato='"+s1.getTiempoContrato()+"' AND fechaFin='"+s1.getFechaFin().getFechaAStr(1) +"' AND activa = '"+activaStrS1+"' ",null).get(0);
            s2 = this.op.buscar("WHERE fechaInicio='"+s2.getFechaInicio().getFechaAStr(1)+"' AND tiempoContrato='"+s2.getTiempoContrato()+"' AND fechaFin='"+s2.getFechaFin().getFechaAStr(1) +"' AND activa = '"+activaStrS2+"' ",null).get(0);

            
            //PROBANDO BORRADO MULTIPLE
            ArrayList<Integer> listaIds = new ArrayList<>();
            listaIds.add(s1.getIdSuscripcion());
            listaIds.add(s2.getIdSuscripcion());
            
            assertEquals("NOERROR", this.op.borradoMultiplePorIds(listaIds).getTextoError());
            
        } catch (SQLException ex) {
            fail("Fallo en testDELETEMULTIPLE");
        } catch (Exception ex) {
            fail("Fallo en testDELETEMULTIPLE");
        }
    }
    

}
