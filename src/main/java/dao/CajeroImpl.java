/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Cajero;

/**
 *
 * @author USUARIO
 */
public class CajeroImpl extends Coneccion implements ICRUD<Cajero> {

    @Override
    public void registrar(Cajero obj) throws Exception {
        String sql = "insert into Cajero (NAME_CASHIER, NUMBER_BOX) VALUES(?,?)";
        try ( PreparedStatement ps = this.getCn().prepareStatement(sql)) {
            ps.setString(1, obj.getName());
            ps.setInt(2, obj.getNumberBox());
            ps.execute();
            ps.close();
        } catch (Exception e) {
            Logger.getGlobal().log(Level.WARNING, "Error al Ingresar TRABAJADOR Dao {0} ", e.getMessage());
            e.printStackTrace();
        }
    }

    @Override
    public void modificar(Cajero obj) throws Exception {
        String sql = "update CAJERO set NAME_CASHIER=?, NUMBER_BOX=? WHERE ID=?";
        try {
            PreparedStatement ps = this.conectar().prepareStatement(sql);
            ps.setString(1, obj.getName());
            ps.setInt(2, obj.getNumberBox());
            ps.setInt(3, obj.getId());
            ps.executeUpdate();
            ps.close();
        } catch (Exception e) {
            Logger.getGlobal().log(Level.WARNING, "Error al modificar el CAJERO Dao {0} ", e.getMessage());
            e.printStackTrace();
        }
    }

    @Override
    public void eliminar(Cajero obj) throws Exception {
        String sql = "delete from CAJERO where ID=?";
        try {
            PreparedStatement ps = this.conectar().prepareStatement(sql);
            ps.setInt(1, obj.getId());
            ps.executeUpdate();
            ps.close();
        } catch (Exception e) {
            Logger.getGlobal().log(Level.WARNING, "Error al eliminar CAJERO Dao {0} ", e.getMessage());
            e.printStackTrace();
        }
    }

    @Override
    public List<Cajero> listarTodos() throws Exception {
        List<Cajero> listado = null;
        Cajero pro;
        ResultSet rs;
        String sql = "select ID, NAME_CASHIER, NUMBER_BOX from CAJERO";
        try {
            listado = new ArrayList();
            PreparedStatement ps = this.conectar().prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                pro = new Cajero();
                pro.setId(rs.getInt("ID"));
                pro.setName(rs.getString("NAME_CASHIER"));
                pro.setNumberBox(rs.getInt("NUMBER_BOX"));
                listado.add(pro);
            }
            rs.close();
            ps.close();
        } catch (Exception e) {
            Logger.getGlobal().log(Level.WARNING, "Error al listar CAJERO Dao {0} ", e.getMessage());
            e.printStackTrace();
        }
        return listado;
    }
}
