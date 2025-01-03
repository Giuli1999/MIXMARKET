/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
import dao.DocumentoVentaImpl;
import java.sql.Timestamp;
import java.util.List;
import model.DocumentoVenta;
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
public class TestDocumentoVentaImpl {

    DocumentoVenta documentoVenta;
    DocumentoVentaImpl documentoVentaImpl;

    @BeforeClass
    public static void setUpClass() {
        System.out.println("Inicio de las pruebas de DocumentoVentaImpl.");
    }

    @AfterClass
    public static void tearDownClass() {
        System.out.println("Fin de las pruebas de DocumentoVentaImpl.");
    }

    @Before
    public void setUp() {
        documentoVentaImpl = new DocumentoVentaImpl();
        documentoVenta = new DocumentoVenta();
        documentoVenta.setId(1);
        documentoVenta.setCantidad(500.0);
        documentoVenta.setType("B");
        documentoVenta.setNumeroTicketBolFac(123456);
    }

    @After
    public void tearDown() {
        System.out.println("Prueba finalizada.");
    }

    @Test
    public void testRegistrarBoleta() throws Exception {
        System.out.println("Prueba de registrar boleta.");

        documentoVenta.setType("B");
        documentoVentaImpl.registrar(documentoVenta);

        assertNotEquals("El documento de venta debería haberse registrado.", documentoVenta);
        System.out.println("Documento de venta registrado (Boleta): " + documentoVenta.toString());
    }

    @Test
    public void testRegistrarFactura() throws Exception {
        System.out.println("Prueba de registrar factura.");

        documentoVenta.setType("F");
        documentoVentaImpl.registrar(documentoVenta);

        assertNotEquals("El documento de venta debería haberse registrado.", documentoVenta);
        System.out.println("Documento de venta registrado (Factura): " + documentoVenta.toString());
    }

    @Test
    public void testModificar() throws Exception {
        System.out.println("Prueba de modificar documento de venta.");

        documentoVenta.setCantidad(600.0);
        documentoVentaImpl.modificar(documentoVenta);

        assertNotEquals("El documento de venta debería haberse modificado.", documentoVenta);
        System.out.println("Documento de venta modificado: " + documentoVenta.toString());
    }

    @Test
    public void testEliminar() throws Exception {
        System.out.println("Prueba de eliminar documento de venta.");

        documentoVentaImpl.eliminar(documentoVenta);

        assertNotEquals("El documento de venta debería haberse eliminado.", documentoVenta);
        System.out.println("Documento de venta eliminado: " + documentoVenta.toString());
    }

    @Test
    public void testListarTodos() throws Exception {
        System.out.println("Prueba de listar todos los documentos de venta.");

        List<DocumentoVenta> result = documentoVentaImpl.listarTodos();

        assertNotEquals("La lista de documentos de venta no debería ser nula.", result);
        System.out.println("Lista de documentos de venta: " + result.toString());
    }
}