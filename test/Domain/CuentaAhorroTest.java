/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Domain;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author geile
 */
public class CuentaAhorroTest {

    public CuentaAhorroTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

    /**
     * Test of Consignar method, of class CuentaAhorro.
     */
    @Test
    public void testConsignar() {
        System.out.println("Consignar");
        double valor = 0.0;
        String ciudad = "";
        Date fecha = null;
        CuentaAhorro instance = new CuentaAhorro();
        String expResult = "";
        String result = instance.Consignar(valor, ciudad, fecha);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of Retirar method, of class CuentaAhorro.
     */
    @Test
    public void testRetirar() {
        System.out.println("Retirar");
        double valor = 0.0;
        String ciudad = "";
        Date fecha = null;
        CuentaAhorro instance = new CuentaAhorro();
        String expResult = "";
        String result = instance.Retirar(valor, ciudad, fecha);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of Crear method, of class CuentaAhorro.
     */
    @Test
    public void testCrearSinSaldoInicial() {
        System.out.println("Crear");
        CuentaAhorro instance = new CuentaAhorro();
        instance.setNumeroTarjeta(123455);
        SimpleDateFormat formatter = new SimpleDateFormat("dd-MMM-yyyy");
        String dateInString = "7-Jun-2013";
        Date date = null;
        try {

            date = formatter.parse(dateInString);
            System.out.println(date);
            System.out.println(formatter.format(date));

        } catch (ParseException e) {
            e.printStackTrace();
        }
        instance.setFechaVencimiento(date);
        instance.setSaldoMaximo(1000000);
        
        String expResult = "El saldo incial debe ser mayor a cero";
        String result = instance.Crear();
        assertEquals(expResult, result);
    }
    
    /**
     * Test of Crear method, of class CuentaAhorro.
     */
    @Test
    public void testCrear() {
        System.out.println("Crear");
        CuentaAhorro instance = new CuentaAhorro();
        instance.setNumeroTarjeta(123455);
        SimpleDateFormat formatter = new SimpleDateFormat("dd-MMM-yyyy");
        String dateInString = "7-Jun-2013";
        Date date = null;
        try {

            date = formatter.parse(dateInString);
            System.out.println(date);
            System.out.println(formatter.format(date));

        } catch (ParseException e) {
            e.printStackTrace();
        }
        instance.setFechaVencimiento(date);
        instance.setSaldoMaximo(1000000);
        instance.setSaldo(100000);
        
        String expResult = "Registro Exitoso";
        String result = instance.Crear();
        assertEquals(expResult, result);
    }

    /**
     * Test of Consultar method, of class CuentaAhorro.
     */
    @Test
    public void testConsultar() {
        System.out.println("Consultar");
        CuentaAhorro instance = new CuentaAhorro();
        String expResult = "";
        String result = instance.Consultar();
        assertEquals(expResult, result);
    }

}
