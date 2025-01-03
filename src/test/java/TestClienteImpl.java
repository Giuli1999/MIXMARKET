/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

import dao.ClienteImpl;
import java.util.List;
import model.Cliente;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import static org.junit.Assert.assertNotEquals;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.mockito.Mock;





public class TestClienteImpl {

    @Mock
    Cliente cliente = new Cliente();

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
        cliente.setId(1);
        cliente.setNameCustomer("Pedro");
        cliente.setLastName("Gonzalez");
    }

    @After
    public void tearDown() {
    }

    @Test
    public void testRegistrar() throws Exception {
        System.out.println("registrar");

        ClienteImpl instance = new ClienteImpl();
        Cliente nuevoCliente = new Cliente();
        nuevoCliente.setId(5);
        nuevoCliente.setNameCustomer("Maria");
        nuevoCliente.setLastName("Lopez");

        instance.registrar(nuevoCliente);

        System.out.println(nuevoCliente.toString());
        System.out.println("id " + nuevoCliente.getId() + " name_cliente " + nuevoCliente.getNameCustomer()
                + " apellido_cliente " + nuevoCliente.getLastName());
    }

    @Test
    public void testModificar() throws Exception {
        System.out.println("modificar");

        ClienteImpl instance = new ClienteImpl();
        cliente.setId(8);
        cliente.setNameCustomer("Pamela");
        cliente.setLastName("Paredes");

        instance.modificar(cliente);

        Assert.assertEquals(8, cliente.getId());
        Assert.assertEquals("Pamela", cliente.getNameCustomer());
        Assert.assertEquals("Paredes", cliente.getLastName());
       
        System.out.println("id " + cliente.getId() + " name_cliente " + cliente.getNameCustomer()
                + " apellido_cliente " + cliente.getLastName());
    }

    @Test
    public void testEliminar() throws Exception {
        System.out.println("eliminar");

        ClienteImpl instance = new ClienteImpl();
        instance.eliminar(cliente);

        System.out.println("Cliente eliminado: " + cliente.toString());
    }

    @Test
    public void testListar() throws Exception {
        System.out.println("listar");

        ClienteImpl instance = new ClienteImpl();
        List<Cliente> result = instance.listarTodos();

        Assert.assertNotNull(result);
        System.out.println("Lista de clientes: " + result.toString());
    }
}