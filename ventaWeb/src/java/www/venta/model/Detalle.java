/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package www.venta.model;

/**
 *
 * @author DELL
 */
public class Detalle {
    private int iddetalle = 0;
    private float precio = 0;
    private int cantidad = 0;
    private int idventa = 0;
    private int idproducto = 0;

    public Detalle(int iddetalle, float precio, int cantidad, int idventa, int idproducto) {
        this.iddetalle = iddetalle;
        this.precio = precio;
        this.cantidad = cantidad;
        this.idventa = idventa;
        this.idproducto = idproducto;
    }
    
    public Detalle() {
        
    }

    public int getIddetalle() {
        return iddetalle;
    }

    public void setIddetalle(int iddetalle) {
        this.iddetalle = iddetalle;
    }

    public float getPrecio() {
        return precio;
    }

    public void setPrecio(float precio) {
        this.precio = precio;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public int getIdventa() {
        return idventa;
    }

    public void setIdventa(int idventa) {
        this.idventa = idventa;
    }

    public int getIdproducto() {
        return idproducto;
    }

    public void setIdproducto(int idproducto) {
        this.idproducto = idproducto;
    }
    
    
}
