
import dao.ProductImpl;
import java.util.List;
import model.Producto;
import org.junit.After;
import org.junit.AfterClass;
import static org.junit.Assert.assertNotEquals;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.mockito.Mock;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */

public class TestProducImpl {

    public TestProducImpl() {
    }
    @Mock
    Producto produc = new Producto();

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
        produc.setId(4);
        produc.setCantidad(6);
        produc.setName("leche");
        produc.setPrice(2);
    }

    @After
    public void tearDown() {
    }

    @Test
    public void testRegistrar() throws Exception {
        System.out.println("registrar");

        // Inicializar el objeto ProductImpl y el objeto produc
        ProductImpl instance = new ProductImpl();
        Producto produc = new Producto();
        produc.setId(4);
        produc.setName("leche");
        produc.setCantidad(6);
        produc.setPrice(2.0);

        // Llamar al método registrar
        instance.registrar(produc);

        // Verificar que el producto se registró correctamente
       // assertNotEquals(null, produc, "registrado ");

        // Imprimir información del producto
        System.out.println(produc.toString());
        System.out.println("id " + produc.getId() + " name_produc " + produc.getName()
                + " cantidad " + produc.getCantidad() + " precio " + produc.getPrice());
    }

    @Test
    public void testModificar() throws Exception {

        System.out.println("modificar");
        ProductImpl instance = new ProductImpl();
        instance.modificar(produc);
        assertNotEquals(null, produc, "modificado ");
        System.out.println("id " + produc.getId() + " name_produc " + produc.getName()
                + " cantidad " + produc.getCantidad() + " precio " + produc.getPrice());
    }

    /**
     * Test of eliminar method, of class ProductosImpl.
     */
    @Test
    public void testEliminar() throws Exception {

        System.out.println("eliminar");
        ProductImpl instance = new ProductImpl();
        instance.eliminar(produc);
        System.out.println("dato eliminado " + produc.toString());
    }

    /**
     * Test of listar method, of class ProductosImpl.
     */
    @Test
    public void testListar() throws Exception {
        System.out.println("listar");
        ProductImpl instance = new ProductImpl();
        List<Producto> expResult = null;
        List<Producto> result = instance.listarTodos();
        assertNotEquals(expResult, result);
        System.out.println("listar" + result.toString());
    }
}
