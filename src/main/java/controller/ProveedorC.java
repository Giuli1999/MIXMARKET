/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import dao.ProveedorImpl;
import java.io.Serializable;
import java.sql.SQLException;
import java.util.List;
import model.Proveedor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author USUARIO
 */
public class ProveedorC implements Serializable {

    private static final Logger LOGGER = LoggerFactory.getLogger(ProveedorC.class);
    private Proveedor pro;
    private ProveedorImpl dao;
    private List<Proveedor> listPro;

    public ProveedorC() {
        pro = new Proveedor();
        dao = new ProveedorImpl();
    }

    public void registrar() throws Exception {
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
            LOGGER.info("Modificaco Correctamente");
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
        pro = new Proveedor();
    }

    public void listar() throws Exception {
        try {
            listPro = dao.listarTodos();
        } catch (SQLException e) {
            LOGGER.error("error al listarC " + e);
        }
    }

    public Proveedor getPro() {
        return pro;
    }

    public void setPro(Proveedor pro) {
        this.pro = pro;
    }

    public ProveedorImpl getDao() {
        return dao;
    }

    public void setDao(ProveedorImpl dao) {
        this.dao = dao;
    }

    public List<Proveedor> getListPro() {
        return listPro;
    }

    public void setListPro(List<Proveedor> listPro) {
        this.listPro = listPro;
    }
    
    

}
