/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Domain;

import Repository.RepositoryCliente;
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
public class ClienteTest {

    static RepositoryCliente repositoryCliente = new RepositoryCliente();

    public ClienteTest() {
    }

    @BeforeClass
    public static void setUpClass() {
        
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
        repositoryCliente.Add(new Cliente(111, "elias", repositoryCliente));
        repositoryCliente.Add(new Cliente(112, "juan", repositoryCliente));
        repositoryCliente.Add(new Cliente(113, "jose", repositoryCliente));
        repositoryCliente.Add(new Cliente(114, "pedro", repositoryCliente));
    }

    @After
    public void tearDown() {
    }

    @Test
    public void testCrear() {
        // TODO review the generated test code and remove the default call to fail.
        Cliente instance = new Cliente(111, "elias", repositoryCliente);
        boolean expResult = new ClienteResponse("Cliente registrado Correctamente", true).getEstado();
        //ClienteResponse result = instance.Registrar();
        boolean result = instance.Registrar().getEstado();
        assertEquals(expResult, result);

    }

}
