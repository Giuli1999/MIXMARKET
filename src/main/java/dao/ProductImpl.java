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
import model.Producto;

/**
 *
 * @author USUARIO
 */
public class ProductImpl extends Coneccion implements ICRUD<Producto> {

    @Override
    public void registrar(Producto obj) throws Exception {
        String sql = "insert into PRODUCTO ( NAME_PRODUC, PRICE, AMOUNT) VALUES(?,?,?)";
        try ( PreparedStatement ps = this.conectar().prepareStatement(sql)) {
             ps.setString(1, obj.getName());
             ps.setDouble(2, obj.getPrice());
             ps.setInt(3, obj.getCantidad());
             ps.execute();
             ps.close();
        } catch (Exception e) {
            Logger.getGlobal().log(Level.WARNING, "Error al Ingresar PRODUCTO Dao {0} ", e.getMessage());
            e.printStackTrace();
        }

    }

    @Override
    public void modificar(Producto obj) throws Exception {
       String sql="update PRODUCTO set NAME_PRODUC=?, PRICE=?, AMOUNT=? where ID=?";
       try{
           PreparedStatement ps = this.conectar().prepareStatement(sql);
             ps.setString(1, obj.getName());
             ps.setDouble(2, obj.getPrice());
             ps.setInt(3, obj.getCantidad());
             ps.setInt(4, obj.getId());
             ps.executeUpdate();
             ps.close();
       }catch(Exception e){
           Logger.getGlobal().log(Level.WARNING, "Error al modificar PRODUCTO Dao {0} ", e.getMessage());
            e.printStackTrace();
       }
       
    }

    @Override
    public void eliminar(Producto obj) throws Exception {
        String sql="delete from PRODUCTO where ID=?";
        try{
             PreparedStatement ps = this.conectar().prepareStatement(sql);
             ps.setInt(1, obj.getId());
             ps.executeUpdate();
             ps.close();
        }catch(Exception e){
             Logger.getGlobal().log(Level.WARNING, "Error al eliminar PRODUCTO Dao {0} ", e.getMessage());
            e.printStackTrace();
        }
    }

    @Override
    public List<Producto> listarTodos() throws Exception {
       List<Producto> listado=null;
       Producto pro;
       ResultSet rs;
       String sql="select ID, NAME_PRODUC, PRICE, AMOUNT from PRODUCTO";
       try{
           listado=new ArrayList();
           PreparedStatement ps = this.conectar().prepareStatement(sql);
           rs=ps.executeQuery();
           while (rs.next()){
               pro=new Producto();
               pro.setId(rs.getInt("ID"));
               pro.setName(rs.getString("NAME_PRODUC"));
               pro.setPrice(rs.getDouble("PRICE"));
               pro.setCantidad(rs.getInt("AMOUNT"));
               listado.add( pro);
           }
           rs.close();
           ps.close();
       }catch(Exception e){
           Logger.getGlobal().log(Level.WARNING, "Error al listar PRODUCTO Dao {0} ", e.getMessage());
            e.printStackTrace();
       }
       return listado; 
    }

}
