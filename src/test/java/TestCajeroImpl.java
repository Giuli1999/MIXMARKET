/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */


import dao.CajeroImpl;
import java.util.List;
import model.Cajero;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import static org.junit.Assert.assertNotEquals;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.mockito.Mock;



public class TestCajeroImpl {

    @Mock
    Cajero cajero = new Cajero();

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
        cajero.setId(1);
        cajero.setName("Juan Perez");
        cajero.setNumberBox(5);
    }

    @After
    public void tearDown() {
    }

    @Test
    public void testRegistrar() throws Exception {
        System.out.println("registrar");

        CajeroImpl instance = new CajeroImpl();
        Cajero nuevoCajero = new Cajero();
        nuevoCajero.setId(7);
        nuevoCajero.setName("Ana Gonzalez");
        nuevoCajero.setNumberBox(3);

        instance.registrar(nuevoCajero);

        System.out.println(nuevoCajero.toString());
        System.out.println("id " + nuevoCajero.getId() + " name_cajero " + nuevoCajero.getName()
                + " numero_caja " + nuevoCajero.getNumberBox());
    }

    @Test
    public void testModificar() throws Exception {
        System.out.println("modificar");

        CajeroImpl instance = new CajeroImpl();
        cajero.setId(9);
        cajero.setName("Juan Miguel");
        cajero.setNumberBox(8);

        instance.modificar(cajero);

        Assert.assertEquals(9, cajero.getId());
        Assert.assertEquals("Juan Miguel", cajero.getName());
        Assert.assertEquals(8, cajero.getNumberBox());
       
        System.out.println("id " + cajero.getId() + " name_cajero " + cajero.getName()
                + " numero_caja " + cajero.getNumberBox());
    }

    @Test
    public void testEliminar() throws Exception {
        System.out.println("eliminar");

        CajeroImpl instance = new CajeroImpl();
        instance.eliminar(cajero);

        System.out.println("Cajero eliminado: " + cajero.toString());
    }

    @Test
    public void testListar() throws Exception {
        System.out.println("listar");

        CajeroImpl instance = new CajeroImpl();
        List<Cajero> result = instance.listarTodos();

        Assert.assertNotNull(result);
        System.out.println("Lista de cajeros: " + result.toString());
    }
}