/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

import dao.TrabajadorImpl;
import java.util.List;
import model.Trabajador;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import static org.junit.Assert.assertNotEquals;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.mockito.Mock;

public class TestTrabajadorImpl {

    @Mock
    Trabajador trabajador = new Trabajador();

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
        trabajador.setId(1);
        trabajador.setName("Juan");
        trabajador.setLastName("Perez");
    }

    @After
    public void tearDown() {
    }

    @Test
    public void testRegistrar() throws Exception {
        System.out.println("registrar");

        TrabajadorImpl instance = new TrabajadorImpl();
        Trabajador nuevoTrabajador = new Trabajador();
        nuevoTrabajador.setId(6);
        nuevoTrabajador.setName("Carlos");
        nuevoTrabajador.setLastName("Lopez");

        instance.registrar(nuevoTrabajador);

       
        System.out.println(nuevoTrabajador.toString());
        System.out.println("id " + nuevoTrabajador.getId() + " name_trabajador " + nuevoTrabajador.getName()
                + " numero_caja " + nuevoTrabajador.getLastName());
    }

    @Test
    public void testModificar() throws Exception {
        System.out.println("modificar");

        TrabajadorImpl instance = new TrabajadorImpl();
        trabajador.setId(8);
        trabajador.setName("Jorge");
        trabajador.setLastName("Soto");

        instance.modificar(trabajador);

        Assert.assertEquals(8, trabajador.getId());
        Assert.assertEquals("Jorge", trabajador.getName());
        Assert.assertEquals("Soto", trabajador.getLastName());
        
        System.out.println("id " + trabajador.getId() + " name_trabajador " + trabajador.getName()
                + " numero_caja " + trabajador.getLastName());
    }

    @Test
    public void testEliminar() throws Exception {
        System.out.println("eliminar");

        TrabajadorImpl instance = new TrabajadorImpl();
        instance.eliminar(trabajador);

        System.out.println("Trabajador eliminado: " + trabajador.toString());
    }

    @Test
    public void testListar() throws Exception {
        System.out.println("listar");

        TrabajadorImpl instance = new TrabajadorImpl();
        List<Trabajador> result = instance.listarTodos();

        Assert.assertNotNull(result);
        System.out.println("Lista de trabajadores: " + result.toString());
    }
}
