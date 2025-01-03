/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Venta;

/**
 *
 * @author USUARIO
 */
public class VentaImpl extends Coneccion implements ICRUD<Venta>{
    @Override
    public void registrar(Venta obj) throws Exception {
        Timestamp fechaActual = new Timestamp(System.currentTimeMillis());
        obj.setFecha(fechaActual);
        String sql = "INSERT INTO VENTA (AMOUNT_PRODUC, TIME, CLIENTE_ID, CAJERO_ID, PRODUCTO_ID, DOCUMENTO_VENTA_ID) VALUES(?,?,?,?,?,?)";
        try (PreparedStatement ps = this.conectar().prepareStatement(sql)) {
            ps.setInt(1, obj.getCantidadProducto());
            ps.setTimestamp(2, obj.getFecha());
            ps.setInt(3, obj.getClienteId_fk());
            ps.setInt(4, obj.getCajeroId_fk());
            ps.setInt(5, obj.getProductoId_fk());
            ps.setInt(6, obj.getDocumentoVentaId_fk());
            ps.execute();
            ps.close();
        } catch (SQLException e) {
            Logger.getGlobal().log(Level.WARNING, "Error al ingresar VENTA Dao {0}", e.getMessage());
            e.printStackTrace();
        }
    }
    @Override
    public void modificar(Venta obj) throws Exception {
        Timestamp fechaActual = new Timestamp(System.currentTimeMillis());
        String sql = "UPDATE VENTA SET AMOUNT_PRODUC=?, TIME=?, CLIENTE_ID=?, CAJERO_ID=?, PRODUCTO_ID=?, DOCUMENTO_VENTA_ID=? WHERE ID=?";
        try (PreparedStatement ps = this.conectar().prepareStatement(sql)) {
            ps.setInt(1, obj.getCantidadProducto());
            ps.setTimestamp(2, fechaActual);
            ps.setInt(3, obj.getClienteId_fk());
            ps.setInt(4, obj.getCajeroId_fk());
            ps.setInt(5, obj.getProductoId_fk());
            ps.setInt(6, obj.getDocumentoVentaId_fk());
            ps.setInt(7, obj.getId());
            ps.executeUpdate();
            ps.close();
        } catch (Exception e) {
            Logger.getGlobal().log(Level.WARNING, "Error al modificar VENTA Dao {0}", e.getMessage());
            e.printStackTrace();
        }
    }
     @Override
    public void eliminar(Venta obj) throws Exception {
        String sql = "DELETE FROM VENTA WHERE ID=?";
        try (PreparedStatement ps = this.conectar().prepareStatement(sql)) {
            ps.setInt(1, obj.getId());
            ps.executeUpdate();
            ps.close();
        } catch (Exception e) {
            Logger.getGlobal().log(Level.WARNING, "Error al eliminar VENTA Dao {0}", e.getMessage());
            e.printStackTrace();
        }
    }
     @Override
    public List<Venta> listarTodos() throws Exception {
        List<Venta> listado = null;
        Venta venta;
        ResultSet rs;
        String sql = "SELECT ID, AMOUNT_PRODUC, TIME, CLIENTE_ID, NOMBRE_CLIENTE, CAJERO_ID, NOMBRE_CAJERO, PRODUCTO_ID, NAME_PRODUC, DOCUMENTO_VENTA_ID FROM VENTA_FULL";
        try {
            listado = new ArrayList<>();
            PreparedStatement ps = this.conectar().prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                venta = new Venta();
                venta.setId(rs.getInt("ID"));
                venta.setCantidadProducto(rs.getInt("AMOUNT_PRODUC"));
                venta.setFecha(rs.getTimestamp("TIME"));
                venta.setClienteId_fk(rs.getInt("CLIENTE_ID"));
                venta.setNombreCliente(rs.getString("NOMBRE_CLIENTE"));
                venta.setCajeroId_fk(rs.getInt("CAJERO_ID"));
                venta.setNombreCajero(rs.getString("NOMBRE_CAJERO"));
                venta.setProductoId_fk(rs.getInt("PRODUCTO_ID"));
                venta.setNombreProducto(rs.getString("NAME_PRODUC"));
                venta.setDocumentoVentaId_fk(rs.getInt("DOCUMENTO_VENTA_ID"));
                listado.add(venta);
            }
            rs.close();
            ps.close();
        } catch (Exception e) {
            Logger.getGlobal().log(Level.WARNING, "Error al listar VENTA Dao {0}", e.getMessage());
            e.printStackTrace();
        }
        return listado;
    }
     public List<Venta> ListarCliente() throws SQLException {
        List<Venta> listadoA = null;
        Venta ven;
        ResultSet rs;
        String sql = "SELECT ID, CONCAT(NAME_CUSTOMER, ' ', LAST_NAME) AS NOMBRE FROM CLIENTE";
        try {
            listadoA = new ArrayList();
            PreparedStatement ps = this.conectar().prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                ven = new Venta();
                ven.setClienteId(rs.getInt("ID"));
                ven.setNombreCliente(rs.getString("NOMBRE"));
                listadoA.add(ven);
            }
            rs.close();
            ps.close();
        } catch (Exception e) {
            Logger.getGlobal().log(Level.WARNING, "Error al listar CLIENTE Dao {0} ", e.getMessage());
        }
        return listadoA;
    }
     public List<Venta> ListarCajero() throws SQLException {
        List<Venta> listadoA = null;
        Venta ven;
        ResultSet rs;
        String sql = "SELECT ID, NAME_CASHIER AS NOMBRE_CAJERO FROM CAJERO";
        try {
            listadoA = new ArrayList();
            PreparedStatement ps = this.conectar().prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                ven = new Venta();
                ven.setCajeroId(rs.getInt("ID"));
                ven.setNombreCajero(rs.getString("NOMBRE_CAJERO"));
                listadoA.add(ven);
            }
            rs.close();
            ps.close();
        } catch (Exception e) {
            Logger.getGlobal().log(Level.WARNING, "Error al listar CAJERO Dao {0} ", e.getMessage());
        }
        return listadoA;
    }
    public List<Venta> ListarProducto() throws SQLException {
        List<Venta> listadoA = null;
        Venta ven;
        ResultSet rs;
        String sql = "select ID, NAME_PRODUC FROM PRODUCTO";
        try {
            listadoA = new ArrayList();
            PreparedStatement ps = this.conectar().prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                ven = new Venta();
                ven.setProductoId(rs.getInt("ID"));
                ven.setNombreProducto(rs.getString("NAME_PRODUC"));
                listadoA.add(ven);
            }
            rs.close();
            ps.close();
        } catch (Exception e) {
            Logger.getGlobal().log(Level.WARNING, "Error al listar PRODUCTO Dao {0} ", e.getMessage());
        }
        return listadoA;
    }
 public List<Venta> ListarDocumentoVenta() throws SQLException {
        List<Venta> listadoA = null;
        Venta ven;
        ResultSet rs;
        String sql = "select ID FROM DOCUMENTO_VENTA";
        try {
            listadoA = new ArrayList();
            PreparedStatement ps = this.conectar().prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                ven = new Venta();
                ven.setDocumentoVentaId(rs.getInt("ID"));
                listadoA.add(ven);
            }
            rs.close();
            ps.close();
        } catch (Exception e) {
            Logger.getGlobal().log(Level.WARNING, "Error al listar DOCUMENTO VENTA Dao {0} ", e.getMessage());
        }
        return listadoA;
    }
}
