/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package www.venta.model;

public class Producto {
    private int idproducto = 0;
    private String nomprod = "";
    private float precio = 0;
    private int stock = 0;
    
    public Producto(int idproducto, String nomprod, float precio, int stock) {
        this.idproducto = idproducto;
        this.nomprod = nomprod;
        this.precio = precio;
        this.stock = stock;
    }
    
    public Producto() {
        
    }

    public int getIdproducto() {
        return idproducto;
    }

    public void setIdproducto(int idproducto) {
        this.idproducto = idproducto;
    }

    public String getNomprod() {
        return nomprod;
    }

    public void setNomprod(String nomprod) {
        this.nomprod = nomprod;
    }

    public float getPrecio() {
        return precio;
    }

    public void setPrecio(float precio) {
        this.precio = precio;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    
}
