package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Pedido;

/**
 *
 * @author USUARIO
 */
public class PedidoImpl extends Coneccion implements ICRUD<Pedido> {

    @Override
    public void registrar(Pedido obj) throws Exception {
        Timestamp fechaActual = new Timestamp(System.currentTimeMillis());
        String sql = "INSERT INTO PEDIDO (AMOUNT, TIME, TRABAJADOR_ID, PROVEEDOR_ID, PRODUCTO_ID) VALUES(?,?,?,?,?)";
        try (PreparedStatement ps = this.conectar().prepareStatement(sql)) {
            ps.setInt(1, obj.getCantidad());
            ps.setTimestamp(2, fechaActual);
            ps.setInt(3, obj.getTrabajadorId_fk());
            ps.setInt(4, obj.getProveedorId_fk());
            ps.setInt(5, obj.getProductoId_fk());
            ps.execute();
            ps.close();
        } catch (Exception e) {
            Logger.getGlobal().log(Level.WARNING, "Error al ingresar PEDIDO Dao {0}", e.getMessage());
            e.printStackTrace();
        }
    }

    @Override
    public void modificar(Pedido obj) throws Exception {
        Timestamp fechaActual = new Timestamp(System.currentTimeMillis());
        String sql = "UPDATE PEDIDO SET AMOUNT=?, TIME=?, TRABAJADOR_ID=?, PROVEEDOR_ID=?, PRODUCTO_ID=? WHERE ID=?";
        try (PreparedStatement ps = this.conectar().prepareStatement(sql)) {
            ps.setInt(1, obj.getCantidad());
            ps.setTimestamp(2, fechaActual);
            ps.setInt(3, obj.getTrabajadorId_fk());
            ps.setInt(4, obj.getProveedorId_fk());
            ps.setInt(5, obj.getProductoId_fk());
            ps.setInt(6, obj.getId());
            ps.executeUpdate();
            ps.close();
        } catch (Exception e) {
            Logger.getGlobal().log(Level.WARNING, "Error al modificar PEDIDO Dao {0}", e.getMessage());
            e.printStackTrace();
        }
    }

    @Override
    public void eliminar(Pedido obj) throws Exception {
        String sql = "DELETE FROM PEDIDO WHERE ID=?";
        try (PreparedStatement ps = this.conectar().prepareStatement(sql)) {
            ps.setInt(1, obj.getId());
            ps.executeUpdate();
            ps.close();
        } catch (Exception e) {
            Logger.getGlobal().log(Level.WARNING, "Error al eliminar PEDIDO Dao {0}", e.getMessage());
            e.printStackTrace();
        }
    }

    @Override
    public List<Pedido> listarTodos() throws Exception {
        List<Pedido> listado = null;
        Pedido pedido;
        ResultSet rs;
        String sql = "SELECT ID, AMOUNT, TIME, TRABAJADOR_ID, NOMBRE_TRABAJADOR, PROVEEDOR_ID, NAME_COMPANY, PRODUCTO_ID, NAME_PRODUC FROM PEDIDO_FULL";
        try {
            listado = new ArrayList<>();
            PreparedStatement ps = this.conectar().prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                pedido = new Pedido();
                pedido.setId(rs.getInt("ID"));
                pedido.setCantidad(rs.getInt("AMOUNT"));
                pedido.setFecha(rs.getTimestamp("TIME"));
                pedido.setTrabajadorId_fk(rs.getInt("TRABAJADOR_ID"));
                pedido.setNombreTrabajador(rs.getString("NOMBRE_TRABAJADOR"));
                pedido.setProveedorId_fk(rs.getInt("PROVEEDOR_ID"));
                pedido.setNombreProveedor(rs.getString("NAME_COMPANY"));
                pedido.setProductoId_fk(rs.getInt("PRODUCTO_ID"));
                pedido.setNombreProducto(rs.getString("NAME_PRODUC"));
                listado.add(pedido);
            }
            rs.close();
            ps.close();
        } catch (Exception e) {
            Logger.getGlobal().log(Level.WARNING, "Error al listar PEDIDO Dao {0}", e.getMessage());
            e.printStackTrace();
        }
        return listado;
    }
    public List<Pedido> ListarTrabajador() throws SQLException {
        List<Pedido> listadoA = null;
        Pedido per;
        ResultSet rs;
        String sql = "SELECT ID, CONCAT(NAME, ' ', LAST_NAME) AS NOMBRE FROM TRABAJADOR";
        try {
            listadoA = new ArrayList();
            PreparedStatement ps = this.conectar().prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                per = new Pedido();
                per.setTrabajadorId(rs.getInt("ID"));
                per.setNombreTrabajador(rs.getString("NOMBRE"));
                listadoA.add(per);
            }
            rs.close();
            ps.close();
        } catch (Exception e) {
            Logger.getGlobal().log(Level.WARNING, "Error al TRABAJADOR Dao {0} ", e.getMessage());
        }
        return listadoA;
    }
    public List<Pedido> ListarProveedores() throws SQLException {
        List<Pedido> listadoA = null;
        Pedido per;
        ResultSet rs;
        String sql = "SELECT ID, NAME_COMPANY FROM PROVEEDOR";
        try {
            listadoA = new ArrayList();
            PreparedStatement ps = this.conectar().prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                per = new Pedido();
                per.setProveedorId(rs.getInt("ID"));
                per.setNombreProveedor(rs.getString("NAME_COMPANY"));
                listadoA.add(per);
            }
            rs.close();
            ps.close();
        } catch (Exception e) {
            Logger.getGlobal().log(Level.WARNING, "Error al PROVEEDOR Dao {0} ", e.getMessage());
        }
        return listadoA;
    }
    public List<Pedido> ListarProducto() throws SQLException {
        List<Pedido> listadoA = null;
        Pedido per;
        ResultSet rs;
        String sql = "select ID, NAME_PRODUC FROM PRODUCTO";
        try {
            listadoA = new ArrayList();
            PreparedStatement ps = this.conectar().prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                per = new Pedido();
                per.setProductoId(rs.getInt("ID"));
                per.setNombreProducto(rs.getString("NAME_PRODUC"));
                listadoA.add(per);
            }
            rs.close();
            ps.close();
        } catch (Exception e) {
            Logger.getGlobal().log(Level.WARNING, "Error al PRODUCTO Dao {0} ", e.getMessage());
        }
        return listadoA;
    }
}
