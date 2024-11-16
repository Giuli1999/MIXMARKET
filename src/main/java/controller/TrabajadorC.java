/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import dao.TrabajadorImpl;
import java.io.Serializable;
import java.sql.SQLException;
import java.util.List;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import model.Trabajador;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author USUARIO
 */
@Named(value = "trabajadorC")
@SessionScoped  
public class TrabajadorC implements Serializable{
    private static final Logger LOGGER = LoggerFactory.getLogger(Trabajador.class);
    private Trabajador pro;
    private TrabajadorImpl dao;
    private List<Trabajador> listPro;
    
    public TrabajadorC(){
        pro = new Trabajador();
        dao = new TrabajadorImpl();
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
        pro = new Trabajador();
    }

    public void listar() throws Exception {
        try {
            listPro = dao.listarTodos();
        } catch (SQLException e) {
            LOGGER.error("error al listarC " + e);
        }
    }

    public Trabajador getPro() {
        return pro;
    }

    public void setPro(Trabajador pro) {
        this.pro = pro;
    }

    public TrabajadorImpl getDao() {
        return dao;
    }

    public void setDao(TrabajadorImpl dao) {
        this.dao = dao;
    }

    public List<Trabajador> getListPro() throws Exception {
         try{
           this.listPro=dao.listarTodos();
       }catch(SQLException e){
           LOGGER.error("error al listarC "+e);
       }
        return listPro;
    }

    public void setListPro(List<Trabajador> listPro) {
        this.listPro = listPro;
    }
    
}
