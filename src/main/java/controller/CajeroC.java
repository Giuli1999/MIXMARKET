/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import dao.CajeroImpl;
import java.io.Serializable;
import java.sql.SQLException;
import java.util.List;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import model.Cajero;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author USUARIO
 */
@Named(value = "cajeroC")
@SessionScoped
public class CajeroC implements Serializable {

    private static final Logger LOGGER = LoggerFactory.getLogger(Cajero.class);
    private Cajero pro;
    private CajeroImpl dao;
    private List<Cajero> listPro;

    public CajeroC() {
        pro = new Cajero();
        dao = new CajeroImpl();
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
        pro = new Cajero();
    }

    public void listar() throws Exception {
        try {
            listPro = dao.listarTodos();
        } catch (SQLException e) {
            LOGGER.error("error al listarC " + e);
        }
    }

    public Cajero getPro() {
        return pro;
    }

    public void setPro(Cajero pro) {
        this.pro = pro;
    }

    public CajeroImpl getDao() {
        return dao;
    }

    public void setDao(CajeroImpl dao) {
        this.dao = dao;
    }

    public List<Cajero> getListPro() throws Exception {
        try {
            this.listPro = dao.listarTodos();
        } catch (SQLException e) {
            LOGGER.error("error al listarC " + e);
        }
        return listPro;
    }

    public void setListPro(List<Cajero> listPro) {
        this.listPro = listPro;
    }
}
