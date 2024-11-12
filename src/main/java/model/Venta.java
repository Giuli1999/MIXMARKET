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
    
    
}
