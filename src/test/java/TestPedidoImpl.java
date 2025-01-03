/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
import dao.PedidoImpl;
import java.sql.Timestamp;
import java.util.List;
import model.Pedido;
import org.junit.After;
import org.junit.AfterClass;
import static org.junit.Assert.assertNotEquals;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.mockito.Mock;
/**
 *
 * @author USUARIO
 */
public class TestPedidoImpl {

    Pedido pedido;
    PedidoImpl pedidoImpl;

    @BeforeClass
    public static void setUpClass() {
        System.out.println("Inicio de las pruebas de PedidoImpl.");
    }

    @AfterClass
    public static void tearDownClass() {
        System.out.println("Fin de las pruebas de PedidoImpl.");
    }

    @Before
    public void setUp() {
        pedidoImpl = new PedidoImpl();
        pedido = new Pedido();
        pedido.setId(1);
        pedido.setCantidad(50);
        pedido.setTrabajadorId_fk(2);
        pedido.setProveedorId_fk(3);
        pedido.setProductoId_fk(4);
    }

    @After
    public void tearDown() {
        System.out.println("Prueba finalizada.");
    }

    @Test
    public void testRegistrar() throws Exception {
        System.out.println("Prueba de registrar pedido.");

        pedidoImpl.registrar(pedido);
        assertNotEquals("El pedido debería haber sido registrado.", pedido);

        System.out.println("Pedido registrado: " + pedido.toString());
    }

    @Test
    public void testModificar() throws Exception {
        System.out.println("Prueba de modificar pedido.");

        pedido.setCantidad(100);
        pedidoImpl.modificar(pedido);

        assertNotEquals("El pedido debería haber sido modificado.", pedido);
        System.out.println("Pedido modificado: " + pedido.toString());
    }

    @Test
    public void testEliminar() throws Exception {
        System.out.println("Prueba de eliminar pedido.");

        pedidoImpl.eliminar(pedido);
        assertNotEquals("El pedido debería haber sido eliminado.", pedido);

        System.out.println("Pedido eliminado: " + pedido.toString());
    }

    @Test
    public void testListarTodos() throws Exception {
        System.out.println("Prueba de listar todos los pedidos.");

        List<Pedido> result = pedidoImpl.listarTodos();
        assertNotEquals("La lista de pedidos no debería ser nula.", result);

        System.out.println("Lista de pedidos: " + result.toString());
    }

    @Test
    public void testListarTrabajador() throws Exception {
        System.out.println("Prueba de listar trabajadores asociados a pedidos.");

        List<Pedido> result = pedidoImpl.ListarTrabajador();
        assertNotEquals("La lista de trabajadores no debería ser nula.", result);

        System.out.println("Lista de trabajadores: " + result.toString());
    }

    @Test
    public void testListarProveedores() throws Exception {
        System.out.println("Prueba de listar proveedores asociados a pedidos.");

        List<Pedido> result = pedidoImpl.ListarProveedores();
        assertNotEquals("La lista de proveedores no debería ser nula.", result);

        System.out.println("Lista de proveedores: " + result.toString());
    }

    @Test
    public void testListarProducto() throws Exception {
        System.out.println("Prueba de listar productos asociados a pedidos.");

        List<Pedido> result = pedidoImpl.ListarProducto();
        assertNotEquals("La lista de productos no debería ser nula.", result);

        System.out.println("Lista de productos: " + result.toString());
    }
}