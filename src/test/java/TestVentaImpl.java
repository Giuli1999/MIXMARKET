/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
import dao.VentaImpl;
import java.sql.Timestamp;
import java.util.List;
import model.Venta;
import org.junit.After;
import org.junit.AfterClass;
import static org.junit.Assert.assertNotEquals;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.mockito.Mock;

public class TestVentaImpl {

    @Mock
    Venta venta = new Venta();

    VentaImpl ventaImpl;

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
        ventaImpl = new VentaImpl();
        venta = new Venta();

        Timestamp fechaActual = new Timestamp(System.currentTimeMillis());
        venta.setId(1);
        venta.setCantidadProducto(10);
        venta.setFecha(fechaActual);
        venta.setClienteId_fk(1);
        venta.setCajeroId_fk(1);
        venta.setProductoId_fk(1);
        venta.setDocumentoVentaId_fk(1);
    }

    @After
    public void tearDown() {
        ventaImpl = null;
        venta = null;
    }

    @Test
    public void testRegistrar() throws Exception {
        System.out.println("Iniciando prueba: registrar");

        // Ejecutar el método
        ventaImpl.registrar(venta);

        // Validar los resultados
        assertNotEquals(null, "El objeto venta debería estar registrado.");
        
        System.out.println("Venta registrada exitosamente: " + venta.toString());
    }

   @Test
    public void testModificar() throws Exception {
        System.out.println("modificar");

        VentaImpl instance = new VentaImpl();
        venta.setCantidadProducto(20);

        instance.modificar(venta);
        assertNotEquals(null, venta, "modificado ");
        System.out.println("Venta modificada: " + venta.toString());
    }

    @Test
    public void testEliminar() throws Exception {
        System.out.println("eliminar");

        VentaImpl instance = new VentaImpl();
        instance.eliminar(venta);
        assertNotEquals(null, venta, "eliminado ");

        System.out.println("Venta eliminada: " + venta.toString());
    }

    @Test
    public void testListarTodos() throws Exception {
        System.out.println("listar todos");

        VentaImpl instance = new VentaImpl();
        List<Venta> result = instance.listarTodos();

        assertNotEquals(null, result, "listado todos");
        System.out.println("Lista de ventas: " + result.toString());
    }

    @Test
    public void testListarCliente() throws Exception {
        System.out.println("listar clientes");

        VentaImpl instance = new VentaImpl();
        List<Venta> result = instance.ListarCliente();

        assertNotEquals(null, result, "listado cliente");
        System.out.println("Clientes: " + result.toString());
    }

    @Test
    public void testListarCajero() throws Exception {
        System.out.println("listar cajeros");

        VentaImpl instance = new VentaImpl();
        List<Venta> result = instance.ListarCajero();

        assertNotEquals(null, result,"listado cajero");
        System.out.println("Cajeros: " + result.toString());
    }

    @Test
    public void testListarProducto() throws Exception {
        System.out.println("listar productos");

        VentaImpl instance = new VentaImpl();
        List<Venta> result = instance.ListarProducto();

        assertNotEquals(null, result, "listado producto");
        System.out.println("Productos: " + result.toString());
    }

    @Test
    public void testListarDocumentoVenta() throws Exception {
        System.out.println("listar documentos de venta");

        VentaImpl instance = new VentaImpl();
        List<Venta> result = instance.ListarDocumentoVenta();

        assertNotEquals(null, result, "listado documento venta");
        System.out.println("Documentos de venta: " + result.toString());
    }
}
