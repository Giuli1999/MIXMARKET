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
import model.Trabajador;

/**
 *
 * @author USUARIO
 */
public class TrabajadorImpl extends Coneccion implements ICRUD<Trabajador> {

    @Override
    public void registrar(Trabajador obj) throws Exception {
        String sql = "insert into TRABAJADOR (NAME, LAST_NAME) VALUES(?,?)";
        try ( PreparedStatement ps = this.conectar().prepareStatement(sql)) {
            ps.setString(1, obj.getName());
            ps.setString(2, obj.getLastName());
            ps.execute();
            ps.close();
        } catch (Exception e) {
            Logger.getGlobal().log(Level.WARNING, "Error al Ingresar TRABAJADOR Dao {0} ", e.getMessage());
            e.printStackTrace();
        }
    }

    @Override
    public void modificar(Trabajador obj) throws Exception {
        String sql = "update TRABAJADOR set NAME=?, LAST_NAME=? where ID=?";
        try {
            PreparedStatement ps = this.conectar().prepareStatement(sql);
            ps.setString(1, obj.getName());
            ps.setString(2, obj.getLastName());
            ps.setInt(3, obj.getId());
            ps.executeUpdate();
            ps.close();
        }catch(Exception e){
         Logger.getGlobal().log(Level.WARNING, "Error al modificar el TRABAJADOR Dao {0} ", e.getMessage());
            e.printStackTrace();
        }
    }
    @Override
    public void eliminar(Trabajador obj) throws Exception{
        String sql = "delete from TRABAJADOR where ID=?";
        try{
            PreparedStatement ps = this.conectar().prepareStatement(sql);
            ps.setInt(1, obj.getId());
            ps.executeUpdate();
            ps.close();
        }catch(Exception e){
            Logger.getGlobal().log(Level.WARNING, "Error al eliminar TRABAJADOR Dao {0} ", e.getMessage());
            e.printStackTrace();
        }
    }
    @Override
    public List<Trabajador> listarTodos() throws Exception{
        List<Trabajador> listado=null;
        Trabajador pro;
        ResultSet rs;
        String sql ="select ID, NAME, LAST_NAME from TRABAJADOR";
         try {
            listado = new ArrayList();
            PreparedStatement ps = this.conectar().prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                pro = new Trabajador();
                pro.setId(rs.getInt("ID"));
                pro.setName(rs.getString("NAME"));
                pro.setLastName(rs.getString("LAST_NAME"));
                listado.add(pro);
            }
            rs.close();
            ps.close();
        } catch (Exception e) {
            Logger.getGlobal().log(Level.WARNING, "Error al listar TRABAJADOR Dao {0} ", e.getMessage());
            e.printStackTrace();
        }
        return listado;
    }
}
