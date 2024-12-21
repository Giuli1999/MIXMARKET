/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import dao.VentaImpl;
import java.io.Serializable;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import model.Venta;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


@Named(value = "ventaC")
@SessionScoped
public class VentaC implements Serializable{
    private static final Logger LOGGER = LoggerFactory.getLogger(VentaC.class);
    private Venta pro;
    private VentaImpl dao;
    private List<Venta> listVenta;
    private List<Venta> listCliente;
    private List<Venta> listCajero;
    private List<Venta> listProducto;
    private List<Venta> listDocumentoVenta;
    
    public VentaC() {
        pro = new Venta();
        dao = new VentaImpl();
    }
 public void registrar() throws Exception {
        try {
            dao.registrar(pro);
            LOGGER.info("Venta registrado correctamente");
            limpiar();
            listar();
        } catch (SQLException e) {
            LOGGER.error("Error al registrar Venta: " + e);
        } catch (Exception e) {
            LOGGER.error("Error genérico al registrar Venta: " + e);
        }
    }

    public void modificar() throws Exception {
        try {
            dao.modificar(pro);
            LOGGER.info("Venta modificado correctamente");
            listar();
        } catch (SQLException e) {
            LOGGER.error("Error al modificar Venta: " + e);
        } catch (Exception e) {
            LOGGER.error("Error genérico al modificar Venta: " + e);
        }
    }

    public void eliminar() throws Exception {
        try {
            dao.eliminar(pro);
            LOGGER.info("Venta eliminado correctamente");
            limpiar();
            listar();
        } catch (SQLException e) {
            LOGGER.error("Error al eliminar Venta: " + e);
        } catch (Exception e) {
            LOGGER.error("Error genérico al eliminar Venta: " + e);
        }
    }

    public void limpiar() {
        pro = new Venta();
    }

    public void listar() throws Exception {
        try {
            listVenta = dao.listarTodos();
        } catch (SQLException e) {
            LOGGER.error("Error al listar Ventas: " + e);
        } catch (Exception e) {
            LOGGER.error("Error genérico al listar Ventas: " + e);
        }
    }

    public Venta getPro() {
        return pro;
    }

    public void setPro(Venta pro) {
        this.pro = pro;
    }

    public VentaImpl getDao() {
        return dao;
    }

    public void setDao(VentaImpl dao) {
        this.dao = dao;
    }

    public List<Venta> getListVenta()throws Exception{
        try {
            this.listVenta = dao.listarTodos();
        } catch (SQLException e) {
            LOGGER.error("Error al obtener la lista de Ventas: " + e);
        } catch (Exception e) {
            LOGGER.error("Error genérico al obtener la lista de Ventas: " + e);
        }
        return listVenta;
    }

    public void setListVenta(List<Venta> listVenta) {
        this.listVenta = listVenta;
    }

    public List<Venta> getListCliente() {
        listCliente=new ArrayList<Venta>();
        try {
            listCliente = dao.ListarCliente();
        } catch (SQLException ex) {
            System.out.println("El error es "+ex.getMessage());
        } catch (Exception ex) {
            System.out.println("El error es "+ex.getMessage());
        }
        return listCliente;
    }

    public void setListCliente(List<Venta> listCliente) {
        this.listCliente = listCliente;
    }

    public List<Venta> getListCajero() {
        listCajero=new ArrayList<Venta>();
        try {
            listCajero = dao.ListarCajero();
        } catch (SQLException ex) {
            System.out.println("El error es "+ex.getMessage());
        } catch (Exception ex) {
            System.out.println("El error es "+ex.getMessage());
        }
        return listCajero;
    }

    public void setListCajero(List<Venta> listCajero) {
        this.listCajero = listCajero;
    }

    public List<Venta> getListProducto() {
        listProducto=new ArrayList<Venta>();
        try {
            listProducto = dao.ListarProducto();
        } catch (SQLException ex) {
            System.out.println("El error es "+ex.getMessage());
        } catch (Exception ex) {
            System.out.println("El error es "+ex.getMessage());
        }
        return listProducto;
    }

    public void setListProducto(List<Venta> listProducto) {
        this.listProducto = listProducto;
    }

    public List<Venta> getListDocumentoVenta() {
        listDocumentoVenta=new ArrayList<Venta>();
        try {
            listDocumentoVenta = dao.ListarDocumentoVenta();
        } catch (SQLException ex) {
            System.out.println("El error es "+ex.getMessage());
        } catch (Exception ex) {
            System.out.println("El error es "+ex.getMessage());
        }
        return listDocumentoVenta;
    }

    public void setListDocumentoVenta(List<Venta> listDocumentoVenta) {
        this.listDocumentoVenta = listDocumentoVenta;
    }
} 
