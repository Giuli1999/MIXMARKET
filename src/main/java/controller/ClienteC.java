/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import dao.ClienteImpl;
import java.io.Serializable;
import java.sql.SQLException;
import java.util.List;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import model.Cliente;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author USUARIO
 */
@Named(value = "clienteC")
@SessionScoped  

public class ClienteC implements Serializable{
       private static final Logger LOGGER = LoggerFactory.getLogger(Cliente.class);
    private Cliente pro;
    private ClienteImpl dao;
    private List<Cliente> listPro;
    
    public ClienteC(){
        pro = new Cliente();
        dao = new ClienteImpl();
    }
    
    public void registrar() throws Exception{
        try {
            dao.registrar(pro);
            LOGGER.info("Registrado completo ");
            limpiar();
            listar();
        } catch (SQLException e) {
            LOGGER.error("el error al registrarC " + e);
        } catch (Exception e) {
            LOGGER.error("el error es registarC " + e);
        }
    }
    public void modificar() throws Exception {
        try {
            dao.modificar(pro);
            LOGGER.info("Modificado Correctamente");
        } catch (SQLException e) {
            LOGGER.error("error al modificarC " + e);
        }
    }

    public void eliminar() throws Exception {
        try {
            dao.eliminar(pro);
            LOGGER.info("eliminado correctamente");
        } catch (SQLException e) {
            LOGGER.error("Error al eliminarC " + e);
        }
    }

    public void limpiar() {
        pro = new Cliente();
    }

    public void listar() throws Exception {
        try {
            listPro = dao.listarTodos();
        } catch (SQLException e) {
            LOGGER.error("error al listarC " + e);
        }
    }

    public Cliente getPro() {
        return pro;
    }

    public void setPro(Cliente pro) {
        this.pro = pro;
    }

    public ClienteImpl getDao() {
        return dao;
    }

    public void setDao(ClienteImpl dao) {
        this.dao = dao;
    }

    public List<Cliente> getListPro() throws Exception {
          try{
           this.listPro=dao.listarTodos();
       }catch(SQLException e){
           LOGGER.error("error al listarC "+e);
       }
        return listPro;
    }

    public void setListPro(List<Cliente> listPro) {
        this.listPro = listPro;
    }
    
    
}
