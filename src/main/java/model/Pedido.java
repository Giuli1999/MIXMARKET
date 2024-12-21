/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.sql.Date;
import java.sql.Timestamp;

/**
 *
 * @author USUARIO
 */
public class Pedido {
    private int id;
    private int cantidad;
    private Timestamp fecha;
    private int trabajadorId_fk;
    private int proveedorId_fk;
    private int productoId_fk;
    //trabajador
    private int trabajadorId;
    private String nombreTrabajador;
    //proveedor
    private int proveedorId;
    private String nombreProveedor;
    //producto
    private int productoId;
    private String nombreProducto;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public Timestamp getFecha() {
        return fecha;
    }

    public void setFecha(Timestamp fecha) {
        this.fecha = fecha;
    }

   
    public String getNombreTrabajador() {
        return nombreTrabajador;
    }

    public void setNombreTrabajador(String nombreTrabajador) {
        this.nombreTrabajador = nombreTrabajador;
    }

    public String getNombreProveedor() {
        return nombreProveedor;
    }

    public void setNombreProveedor(String nombreProveedor) {
        this.nombreProveedor = nombreProveedor;
    }

    public String getNombreProducto() {
        return nombreProducto;
    }

    public void setNombreProducto(String nombreProducto) {
        this.nombreProducto = nombreProducto;
    }

    public int getTrabajadorId_fk() {
        return trabajadorId_fk;
    }

    public void setTrabajadorId_fk(int trabajadorId_fk) {
        this.trabajadorId_fk = trabajadorId_fk;
    }

    public int getProveedorId_fk() {
        return proveedorId_fk;
    }

    public void setProveedorId_fk(int proveedorId_fk) {
        this.proveedorId_fk = proveedorId_fk;
    }

    public int getProductoId_fk() {
        return productoId_fk;
    }

    public void setProductoId_fk(int productoId_fk) {
        this.productoId_fk = productoId_fk;
    }

    public int getTrabajadorId() {
        return trabajadorId;
    }

    public void setTrabajadorId(int trabajadorId) {
        this.trabajadorId = trabajadorId;
    }

    public int getProveedorId() {
        return proveedorId;
    }

    public void setProveedorId(int proveedorId) {
        this.proveedorId = proveedorId;
    }

    public int getProductoId() {
        return productoId;
    }

    public void setProductoId(int productoId) {
        this.productoId = productoId;
    }         
}
