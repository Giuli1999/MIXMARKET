/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

import dao.ProveedorImpl;
import java.util.List;
import model.Proveedor;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import static org.junit.Assert.assertNotEquals;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.mockito.Mock;



public class TestProveedorImpl {

    @Mock
    Proveedor proveedor = new Proveedor();

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
        proveedor.setId(1);
        proveedor.setRuc(12345678);
        proveedor.setNameCompany("Comercial Miriam");
    }

    @After
    public void tearDown() {
    }

    @Test
    public void testRegistrar() throws Exception {
        System.out.println("registrar");

        ProveedorImpl instance = new ProveedorImpl();
        Proveedor nuevoProveedor = new Proveedor();
        nuevoProveedor.setId(9);
        nuevoProveedor.setRuc(87654321);
        nuevoProveedor.setNameCompany("Distribuidora ISN");

        instance.registrar(nuevoProveedor);

       
        System.out.println(nuevoProveedor.toString());
        System.out.println("id " + nuevoProveedor.getId() + " ruc_empresa " + nuevoProveedor.getRuc()
                + " nombre_empresa " + nuevoProveedor.getNameCompany());
    }

    @Test
    public void testModificar() throws Exception {
        System.out.println("modificar");

        ProveedorImpl instance = new ProveedorImpl();
        proveedor.setId(2);
        proveedor.setRuc(11223344);
        proveedor.setNameCompany("Coca_Cola");

        instance.modificar(proveedor);

        Assert.assertEquals(2, proveedor.getId());
        Assert.assertEquals(11223344, proveedor.getRuc());
        Assert.assertEquals("Coca_Cola", proveedor.getNameCompany());
        
        System.out.println("id " + proveedor.getId() + " ruc_empresa " + proveedor.getRuc()
                + " nombre_empresa " + proveedor.getNameCompany());
    }

    @Test
    public void testEliminar() throws Exception {
        System.out.println("eliminar");

        ProveedorImpl instance = new ProveedorImpl();
        instance.eliminar(proveedor);

        System.out.println("Proveedor eliminado: " + proveedor.toString());
    }

    @Test
    public void testListar() throws Exception {
        System.out.println("listar");

        ProveedorImpl instance = new ProveedorImpl();
        List<Proveedor> result = instance.listarTodos();

        Assert.assertNotNull(result);
        System.out.println("Lista de proveedores: " + result.toString());
    }
}
