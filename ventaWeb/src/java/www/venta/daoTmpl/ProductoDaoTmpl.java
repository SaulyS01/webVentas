/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package www.venta.daoTmpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import www.venta.config.Conn;
import www.venta.dao.ProductoDao;
import www.venta.model.Producto;

public class ProductoDaoTmpl implements ProductoDao{
    private PreparedStatement ps;
    private ResultSet rs;
    private Connection cx;
    
    @Override
    public int create(Producto prod) {
        String SQL = "INSERT INTO producto(nomprod, precio, stock) VALUES(?, ?, ?)";
        int x = 0;
        try {
            cx = Conn.getConn();
            ps = cx.prepareStatement(SQL);
            ps.setString(1, prod.getNomprod());
            ps.setFloat(2, prod.getPrecio());
            ps.setInt(3, prod.getStock());
            x = ps.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Error: "+e);
        }
        return x;       
    }

    @Override
    public int update(Producto prod) {
        String SQL = "UPDATE producto SET nomprod=?, precio=?, stock=?  WHERE idproducto=?";
        int x = 0;
        try {
            cx = Conn.getConn();
            ps = cx.prepareStatement(SQL);
            ps.setString(1, prod.getNomprod());
            ps.setFloat(2, prod.getPrecio());
            ps.setInt(3, prod.getStock());
            ps.setInt(4, prod.getIdproducto());
            x = ps.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Error: "+e);
        }
        return x;
    }

    @Override
    public int delete(int id) {
        String SQL = "DELETE FROM producto WHERE idproducto=?";
        int x = 0;
        try {
            cx = Conn.getConn();
            ps = cx.prepareStatement(SQL);
            ps.setInt(1, id);
            x = ps.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Error: "+e);
        }
        return x;
    }
    
    @Override
    public Producto read(int id) {
        String SQL = "SELECT * FROM producto WHERE idproducto=?";
        Producto prod = new Producto();
        try {
            cx = Conn.getConn();
            ps = cx.prepareStatement(SQL);
            ps.setInt(1, id);
            rs = ps.executeQuery();
            while(rs.next()){
                prod.setIdproducto(rs.getInt("idproducto"));
                prod.setNomprod(rs.getString("nombre"));
                prod.setPrecio(rs.getFloat("precio"));
                prod.setStock(rs.getInt("stock"));
            }
        } catch (SQLException e) {
            System.out.println("Error: "+e);
        }
        return prod;
    }

    @Override
    public List<Producto> readAll() {
        String SQL = "SELECT * FROM producto";
        List<Producto> lista = new ArrayList<>();
        try {
            cx = Conn.getConn();
            ps = cx.prepareStatement(SQL);
            rs = ps.executeQuery();
            while(rs.next()){
                Producto prod = new Producto();
                prod.setIdproducto(rs.getInt("idproducto"));
                prod.setNomprod(rs.getString("nombre"));
                prod.setPrecio(rs.getFloat("precio"));
                prod.setStock(rs.getInt("stock"));
                lista.add(prod);
            }
        } catch (SQLException e) {
            System.out.println("Error: "+e);
        }
        return lista;
    }
}
