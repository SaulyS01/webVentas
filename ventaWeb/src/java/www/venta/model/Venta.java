/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package www.venta.model;

import java.sql.Date;

/**
 *
 * @author DELL
 */
public class Venta {
   
    private int idventa = 0;
    private Date fecha = null;
    private String tipodoc = "";
    private String numdoc = "";
    private int idcliente = 0;

    public Venta(int idventa, Date fecha, String tipodoc, String numdoc, int idcliente) {
        this.idventa = idventa;
        this.fecha = fecha;
        this.tipodoc = tipodoc;
        this.numdoc = numdoc;
        this.idcliente = idcliente;
    }
    
    public Venta() {
        
    }
    
    public int getIdventa() {
        return idventa;
    }

    public void setIdventa(int idventa) {
        this.idventa = idventa;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getTipodoc() {
        return tipodoc;
    }

    public void setTipodoc(String tipodoc) {
        this.tipodoc = tipodoc;
    }

    public String getNumdoc() {
        return numdoc;
    }

    public void setNumdoc(String numdoc) {
        this.numdoc = numdoc;
    }

    public int getIdcliente() {
        return idcliente;
    }

    public void setIdcliente(int idcliente) {
        this.idcliente = idcliente;
    }
}
