

package controller;

import dao.PedidoImpl;
import java.io.Serializable;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import model.Pedido;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author USUARIO
 */
@Named(value = "pedidoC")
@SessionScoped
public class PedidoC implements Serializable {
    private static final Logger LOGGER = LoggerFactory.getLogger(PedidoC.class);
    private Pedido pro;
    private PedidoImpl dao;
    private List<Pedido> listPedido;
    private List<Pedido> listTrabajador;
    private List<Pedido> listProveedor;
    private List<Pedido> listProducto;

    public PedidoC() {
        pro = new Pedido();
        dao = new PedidoImpl();
    }

    public void registrar() throws Exception {
        try {
            dao.registrar(pro);
            LOGGER.info("Pedido registrado correctamente");
            limpiar();
            listar();
        } catch (SQLException e) {
            LOGGER.error("Error al registrar Pedido: " + e);
        } catch (Exception e) {
            LOGGER.error("Error genérico al registrar Pedido: " + e);
        }
    }

    public void modificar() throws Exception {
        try {
            dao.modificar(pro);
            LOGGER.info("Pedido modificado correctamente");
            listar();
        } catch (SQLException e) {
            LOGGER.error("Error al modificar Pedido: " + e);
        } catch (Exception e) {
            LOGGER.error("Error genérico al modificar Pedido: " + e);
        }
    }

    public void eliminar() throws Exception {
        try {
            dao.eliminar(pro);
            LOGGER.info("Pedido eliminado correctamente");
            limpiar();
            listar();
        } catch (SQLException e) {
            LOGGER.error("Error al eliminar Pedido: " + e);
        } catch (Exception e) {
            LOGGER.error("Error genérico al eliminar Pedido: " + e);
        }
    }

    public void limpiar() {
        pro = new Pedido();
    }

    public void listar() throws Exception {
        try {
            listPedido = dao.listarTodos();
        } catch (SQLException e) {
            LOGGER.error("Error al listar Pedidos: " + e);
        } catch (Exception e) {
            LOGGER.error("Error genérico al listar Pedidos: " + e);
        }
    }

 
    public PedidoImpl getDao() {
        return dao;
    }

    public void setDao(PedidoImpl dao) {
        this.dao = dao;
    }

    public List<Pedido> getListPedido() throws Exception {
        try {
            this.listPedido = dao.listarTodos();
        } catch (SQLException e) {
            LOGGER.error("Error al obtener la lista de Pedidos: " + e);
        } catch (Exception e) {
            LOGGER.error("Error genérico al obtener la lista de Pedidos: " + e);
        }
        return listPedido;
    }

    public void setListPedido(List<Pedido> listPedido) {
        this.listPedido = listPedido;
    }

    public Pedido getPro() {
        return pro;
    }

    public void setPro(Pedido pro) {
        this.pro = pro;
    }

    public List<Pedido> getListTrabajador() {
        listTrabajador=new ArrayList<Pedido>();
        try {
            listTrabajador = dao.ListarTrabajador();
        } catch (SQLException ex) {
            System.out.println("El error es "+ex.getMessage());
        } catch (Exception ex) {
            System.out.println("El error es "+ex.getMessage());
        }
        return listTrabajador;
    }

    public void setListTrabajador(List<Pedido> listTrabajador) {
        this.listTrabajador = listTrabajador;
    }

    public List<Pedido> getListProveedor() {
        listProveedor=new ArrayList<Pedido>();
        try {
            listProveedor = dao.ListarProveedores();
        } catch (SQLException ex) {
            System.out.println("El error es "+ex.getMessage());
        } catch (Exception ex) {
            System.out.println("El error es "+ex.getMessage());
        }
        return listProveedor;
    }

    public void setListProveedor(List<Pedido> listProveedor) {
        this.listProveedor = listProveedor;
    }

    public List<Pedido> getListProducto() {
        listProducto=new ArrayList<Pedido>();
        try {
            listProducto = dao.ListarProducto();
        } catch (SQLException ex) {
            System.out.println("El error es "+ex.getMessage());
        } catch (Exception ex) {
            System.out.println("El error es "+ex.getMessage());
        }
        return listProducto;
    }

    public void setListProducto(List<Pedido> listProducto) {
        this.listProducto = listProducto;
    }
}
