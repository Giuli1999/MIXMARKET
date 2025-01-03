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
import model.Proveedor;

/**
 *
 * @author USUARIO
 */
public class ProveedorImpl extends Coneccion implements ICRUD<Proveedor> {

    @Override
    public void registrar(Proveedor obj) throws Exception {
        String sql = "insert into PROVEEDOR ( RUC_E, NAME_COMPANY) VALUES(?,?)";
        try ( PreparedStatement ps = this.conectar().prepareStatement(sql)) {
            ps.setInt(1, obj.getRuc());
            ps.setString(2, obj.getNameCompany());
            ps.execute();
            ps.close();
        } catch (Exception e) {
            Logger.getGlobal().log(Level.WARNING, "Error al Ingresar PROVEEDOR Dao {0} ", e.getMessage());
            e.printStackTrace();
        }
    }

    @Override
    public void modificar(Proveedor obj) throws Exception {
        String sql = "update PROVEEDOR set RUC_E=?, NAME_COMPANY=? where ID=?";
        try {
            PreparedStatement ps = this.conectar().prepareStatement(sql);
            ps.setInt(1, obj.getRuc());
            ps.setString(2, obj.getNameCompany());
            ps.setInt(3, obj.getId());
            ps.executeUpdate();
            ps.close();
        } catch (Exception e) {
            Logger.getGlobal().log(Level.WARNING, "Error al modificar el PROVEEDOR Dao {0} ", e.getMessage());
            e.printStackTrace();
        }
    }

    @Override
    public void eliminar(Proveedor obj) throws Exception {
        String sql = "delete from PROVEEDOR where ID=?";
        try {
            PreparedStatement ps = this.conectar().prepareStatement(sql);
            ps.setInt(1, obj.getId());
            ps.executeUpdate();
            ps.close();
        } catch (Exception e) {
            Logger.getGlobal().log(Level.WARNING, "Error al eliminar PROVEEDOR Dao {0} ", e.getMessage());
            e.printStackTrace();
        }
    }

    @Override
    public List<Proveedor> listarTodos() throws Exception {
        List<Proveedor> listado = null;
        Proveedor pro;
        ResultSet rs;
        String sql = "select ID, RUC_E, NAME_COMPANY from PROVEEDOR";
        try {
            listado = new ArrayList();
            PreparedStatement ps = this.conectar().prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                pro = new Proveedor();
                pro.setId(rs.getInt("ID"));
                pro.setRuc(rs.getInt("RUC_E"));
                pro.setNameCompany(rs.getString("NAME_COMPANY"));
                listado.add(pro);
            }
            rs.close();
            ps.close();
        } catch (Exception e) {
            Logger.getGlobal().log(Level.WARNING, "Error al listar PROVEEDOR Dao {0} ", e.getMessage());
            e.printStackTrace();
        }
        return listado;
    }
}


