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
import model.Cliente;
/**
 *
 * @author USUARIO
 */
public class ClienteImpl extends Coneccion implements ICRUD<Cliente> {
    
@Override
    public void registrar(Cliente obj) throws Exception {
        String sql = "insert into CLIENTE (NAME_CUSTOMER, LAST_NAME) VALUES(?,?)";
        try ( PreparedStatement ps = this.conectar().prepareStatement(sql)) {
            ps.setString(1, obj.getNameCustomer());
            ps.setString(2, obj.getLastName());
            ps.execute();
            ps.close();
        } catch (Exception e) {
            Logger.getGlobal().log(Level.WARNING, "Error al Ingresar CLIENTE Dao {0} ", e.getMessage());
            e.printStackTrace();
        }
    }

    @Override
    public void modificar(Cliente obj) throws Exception {
        String sql = "update CLIENTE set NAME_CUSTOMER=?, LAST_NAME=? where ID=?";
        try {
            PreparedStatement ps = this.conectar().prepareStatement(sql);
            ps.setString(1, obj.getNameCustomer());
            ps.setString(2, obj.getLastName());
            ps.setInt(3, obj.getId());
            ps.executeUpdate();
            ps.close();
        }catch(Exception e){
         Logger.getGlobal().log(Level.WARNING, "Error al modificar el CLIENTE Dao {0} ", e.getMessage());
            e.printStackTrace();
        }
    }
    @Override
    public void eliminar(Cliente obj) throws Exception{
        String sql = "delete from CLIENTE where ID=?";
        try{
            PreparedStatement ps = this.conectar().prepareStatement(sql);
            ps.setInt(1, obj.getId());
            ps.executeUpdate();
            ps.close();
        }catch(Exception e){
            Logger.getGlobal().log(Level.WARNING, "Error al eliminar CLIENTE Dao {0} ", e.getMessage());
            e.printStackTrace();
        }
    }
    @Override
    public List<Cliente> listarTodos() throws Exception{
        List<Cliente> listado=null;
        Cliente pro;
        ResultSet rs;
        String sql ="select ID, NAME_CUSTOMER, LAST_NAME from CLIENTE";
         try {
            listado = new ArrayList();
            PreparedStatement ps = this.conectar().prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                pro = new Cliente();
                pro.setId(rs.getInt("ID"));
                pro.setNameCustomer(rs.getString("NAME_CUSTOMER"));
                pro.setLastName(rs.getString("LAST_NAME"));
                listado.add(pro);
            }
            rs.close();
            ps.close();
        } catch (Exception e) {
            Logger.getGlobal().log(Level.WARNING, "Error al listar CLIENTE Dao {0} ", e.getMessage());
            e.printStackTrace();
        }
        return listado;
    }
}

