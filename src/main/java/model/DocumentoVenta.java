/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.sql.Timestamp;
import java.util.List;

/**
 *
 * @author USUARIO
 */
public class DocumentoVenta {
    private int id;
    private double cantidad;
    private Timestamp fecha;
    private String type;
    private String typeDetalle;
 //Boleta 
    private int idBolFac;
    private int numeroTicketBolFac;
    private int documentoVentaIdBolFac;
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getCantidad() {
        return cantidad;
    }

    public void setCantidad(double cantidad) {
        this.cantidad = cantidad;
    }

    public Timestamp getFecha() {
        return fecha;
    }

    public void setFecha(Timestamp fecha) {
        this.fecha = fecha;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getDocumentoVentaIdBolFac() {
        return documentoVentaIdBolFac;
    }

    public void setDocumentoVentaIdBolFac(int documentoVentaIdBolFac) {
        this.documentoVentaIdBolFac = documentoVentaIdBolFac;
    }

    public int getIdBolFac() {
        return idBolFac;
    }

    public void setIdBolFac(int idBolFac) {
        this.idBolFac = idBolFac;
    }

    public int getNumeroTicketBolFac() {
        return numeroTicketBolFac;
    }

    public void setNumeroTicketBolFac(int numeroTicketBolFac) {
        this.numeroTicketBolFac = numeroTicketBolFac;
    }

    public String getTypeDetalle() {
        return typeDetalle;
    }

    public void setTypeDetalle(String typeDetalle) {
        this.typeDetalle = typeDetalle;
    }
    
}
