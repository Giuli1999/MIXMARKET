/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.sql.Timestamp;

/**
 *
 * @author USUARIO
 */
public class Venta {
    private int id;
    private int cantidadProducto;
    private Timestamp fecha;
    private int clienteId;
    private int cajeroId;
    private int productoId;
    private int documentoVentaId;
    //cliente
    private int clienteId_fk;
    private String nombreCliente;
    //cajero
    private int cajeroId_fk;
    private String nombreCajero;
    //producto
    private int productoId_fk;
    private String nombreProducto;
    //documento_venta
    private int documentoVentaId_fk;
   
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCantidadProducto() {
        return cantidadProducto;
    }

    public void setCantidadProducto(int cantidadProducto) {
        this.cantidadProducto = cantidadProducto;
    }

    public Timestamp getFecha() {
        return fecha;
    }

    public void setFecha(Timestamp fecha) {
        this.fecha = fecha;
    }

    public int getClienteId() {
        return clienteId;
    }

    public void setClienteId(int clienteId) {
        this.clienteId = clienteId;
    }

    public int getCajeroId() {
        return cajeroId;
    }

    public void setCajeroId(int cajeroId) {
        this.cajeroId = cajeroId;
    }

    public int getProductoId() {
        return productoId;
    }

    public void setProductoId(int productoId) {
        this.productoId = productoId;
    }

    public int getDocumentoVentaId() {
        return documentoVentaId;
    }

    public void setDocumentoVentaId(int documentoVentaId) {
        this.documentoVentaId = documentoVentaId;
    }

    public int getClienteId_fk() {
        return clienteId_fk;
    }

    public void setClienteId_fk(int clienteId_fk) {
        this.clienteId_fk = clienteId_fk;
    }

    public String getNombreCliente() {
        return nombreCliente;
    }

    public void setNombreCliente(String nombreCliente) {
        this.nombreCliente = nombreCliente;
    }

    public int getCajeroId_fk() {
        return cajeroId_fk;
    }

    public void setCajeroId_fk(int cajeroId_fk) {
        this.cajeroId_fk = cajeroId_fk;
    }

    public String getNombreCajero() {
        return nombreCajero;
    }

    public void setNombreCajero(String nombreCajero) {
        this.nombreCajero = nombreCajero;
    }

    public int getProductoId_fk() {
        return productoId_fk;
    }

    public void setProductoId_fk(int productoId_fk) {
        this.productoId_fk = productoId_fk;
    }

    public String getNombreProducto() {
        return nombreProducto;
    }

    public void setNombreProducto(String nombreProducto) {
        this.nombreProducto = nombreProducto;
    }

    public int getDocumentoVentaId_fk() {
        return documentoVentaId_fk;
    }

    public void setDocumentoVentaId_fk(int documentoVentaId_fk) {
        this.documentoVentaId_fk = documentoVentaId_fk;
    }
    
    
}
