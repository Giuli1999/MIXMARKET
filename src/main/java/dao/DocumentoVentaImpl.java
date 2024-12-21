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
import java.util.Arrays;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Boleta;
import model.DocumentoVenta;

/**
 *
 * @author USUARIO
 */
public class DocumentoVentaImpl extends Coneccion implements ICRUD<DocumentoVenta> {

    @Override
    public void registrar(DocumentoVenta obj) throws Exception {
        Boleta boleta = new Boleta();
        Timestamp fechaActual = new Timestamp(System.currentTimeMillis());
        String sql = "insert into DOCUMENTO_VENTA (AMOUNT, TIME, TYPE) VALUES (?,?,?)";
        try ( PreparedStatement ps = this.conectar().prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS)) {
            ps.setDouble(1, obj.getCantidad());
            ps.setTimestamp(2, fechaActual);
            ps.setString(3, obj.getType());
            ps.execute();
            ResultSet sa = ps.getGeneratedKeys();
            if (obj.getType().equals("B")) {
                if (sa.next()) {
                    System.out.println("impr " + sa.getLong(1));
                    obj.setDocumentoVentaIdBolFac((int) sa.getLong(1));
                    boleta(obj);
                }
            } else if (obj.getType().equals("F")) {
                if (sa.next()) {
                    System.out.println("impr " + sa.getLong(1));
                    obj.setDocumentoVentaIdBolFac((int) sa.getLong(1));
                    factura(obj);
                }
            }
            ps.close();
        } catch (Exception e) {
            Logger.getGlobal().log(Level.WARNING, "Error al registrar el DOCUMENTO VENTA Dao{0}", e.getMessage());
            e.printStackTrace();
        }
    }

    public void boleta(DocumentoVenta obj) {
        String sql = "insert into BOLETA (NUMBER_TICKET, DOCUMENTO_VENTA_ID) VALUES (?,?)";
        try ( PreparedStatement ps = this.getCn().prepareStatement(sql)) {
            ps.setInt(1, obj.getNumeroTicketBolFac());
            ps.setInt(2, obj.getDocumentoVentaIdBolFac());
            ps.execute();
            ps.close();
        } catch (Exception e) {
            Logger.getGlobal().log(Level.WARNING, "Error al registrar la BOLETA Dao{0}", e.getMessage());
            e.printStackTrace();
        }
    }

    public void factura(DocumentoVenta obj) {
        String sql = "insert into FACTURA (SERIE, DOCUMENTO_VENTA_ID) VALUES (?,?)";
        try ( PreparedStatement ps = this.getCn().prepareStatement(sql)) {
            ps.setInt(1, obj.getNumeroTicketBolFac());
            ps.setInt(2, obj.getDocumentoVentaIdBolFac());
            ps.execute();
            ps.close();
        } catch (Exception e) {
            Logger.getGlobal().log(Level.WARNING, "Error al registrar la FACTURA Dao{0}", e.getMessage());
            e.printStackTrace();
        }
    }

    @Override
    public void modificar(DocumentoVenta obj) throws Exception {
        Timestamp fechaActual = new Timestamp(System.currentTimeMillis());
        String sql = "update DOCUMENTO_VENTA set AMOUNT=?, TIME=?  where ID=?";
        try {
            PreparedStatement ps = this.conectar().prepareStatement(sql);
            ps.setDouble(1, obj.getCantidad());
            ps.setTimestamp(2, fechaActual);
            ps.setInt(3, obj.getId());
            ps.executeUpdate();
            ps.close();
        } catch (Exception e) {
            Logger.getGlobal().log(Level.WARNING, "error al modificar el DOCUMENTO VENTA Dao{0}", e.getMessage());
            e.printStackTrace();
        }
    }

    @Override
    public void eliminar(DocumentoVenta obj) throws Exception {
        String sql = "delete from DOCUMENTO_VENTA where ID=?";
        try {
            PreparedStatement ps = this.conectar().prepareStatement(sql);
            ps.setInt(1, obj.getId());
            ps.executeUpdate();
            ps.close();
        } catch (Exception e) {
            Logger.getGlobal().log(Level.WARNING, "error al eliminar el DOCUMENTO VENTA Dao{0}", e.getMessage());
            e.printStackTrace();
        }
    }

    @Override
    public List<DocumentoVenta> listarTodos() throws Exception {
        List<DocumentoVenta> listado = null;
        DocumentoVenta pro;
        ResultSet rs;
        String sql = "select ID_Documento_Venta, Amount, Time, Tipo_Documento, ID_Documento_Adicional, Numero_Documento_Adicional from VENTA_BOLETA";
        try {
            listado = new ArrayList<>();
            PreparedStatement ps = this.conectar().prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                pro = new DocumentoVenta();
                pro.setId(rs.getInt("ID_Documento_Venta"));
                pro.setCantidad(rs.getDouble("Amount"));
                pro.setFecha(rs.getTimestamp("Time"));
                pro.setType(rs.getString("Tipo_Documento"));
                pro.setIdBolFac(rs.getInt("ID_Documento_Adicional"));
                pro.setNumeroTicketBolFac(rs.getInt("Numero_Documento_Adicional")); // Elimina el espacio extra en el nombre
                listado.add(pro);
            }
            rs.close();
            ps.close();
        } catch (Exception e) {
            Logger.getGlobal().log(Level.WARNING, "Error al listar general DOCUMENTO VENTAs", e);
            throw e; // Re-lanzar la excepción para que sea manejada en un nivel superior si es necesario
        }
        return listado;
    }
}
