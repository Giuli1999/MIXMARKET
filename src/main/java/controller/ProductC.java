/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import dao.ProductImpl;
import java.io.Serializable;
import java.sql.SQLException;
import java.util.List;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import model.Producto;

/**
 *
 * @author USUARIO
 */
@Named(value = "productC")
@SessionScoped  
public class ProductC implements Serializable {
    //instancias
    private static final Logger LOGGER = LoggerFactory.getLogger(ProductC.class); //instancia privada y no va a cambiar
    private Producto pro; //instanciando modelo
    private ProductImpl dao; //instanciando la implementación
    private List<Producto> listPro; //instanciando el modelo en una lista, para hacer una consulta de listas

    public ProductC() { //se ha generado el constructor
        pro = new Producto(); //se esta definiendo las instancias universales
        dao = new ProductImpl(); //se esta definiendo las instancias universales porque se unsara en todo el modelo
    }

    public void registrar() throws Exception { //es el metodo del controlador registrar
        try {
            dao.registrar(pro); //importando el metodo del implemen para que pueda ser consumido
            LOGGER.info("Registrado completo "); //es como un print
            limpiar(); //se va a limpiar el registro despues de ser implementado, para que no guarde informacion para el proximo listado
            listar(); //se va a listar los datos actualizados o registrados
        } catch (SQLException e) {
            LOGGER.error("el error al registrarC " + e);
        }catch(Exception e){
            LOGGER.error("el error es registarC "+e);
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

    public void limpiar() { //se esta jalando la variables 
        pro = new Producto(); //lo que hace es limpiar los datos que se encuentran en nuestro modelo
    }

    public void listar() throws Exception { //se encarga de listar los datos de la tabla producto
        try {
            listPro = dao.listarTodos(); //se esta asignando el resultado de la consulta a la variables listPro
        } catch (SQLException e) {
            LOGGER.error("error al listarC " + e);
        }
    }

    public Producto getPro() { //
        return pro;
    }

    public void setPro(Producto pro) {
        this.pro = pro;
    }

    public ProductImpl getDao() {
        return dao;
    }

    public void setDao(ProductImpl dao) {
        this.dao = dao;
    }

    public List<Producto> getListPro() throws Exception {//es el metodo generado por getter and setter
        try{
            this.listPro=dao.listarTodos(); //esta ejecusión sirve para actualizar los datos en la ejecusión 
        }catch(SQLException e){
            LOGGER.error("Error al listarC "+e);
        }
        return listPro;
    }

    public void setListPro(List<Producto> listPro) {
        this.listPro = listPro;
    }

}
