/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author USUARIO
 */
public class Factura {
    private int id;
    private int serie;
    private int documentoVentaId;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getSerie() {
        return serie;
    }

    public void setSerie(int serie) {
        this.serie = serie;
    }

    public int getDocumentoVentaId() {
        return documentoVentaId;
    }

    public void setDocumentoVentaId(int documentoVentaId) {
        this.documentoVentaId = documentoVentaId;
    }
    
    
}
