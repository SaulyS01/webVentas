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
import www.venta.dao.DetalleDao;
import www.venta.model.Detalle;

/**
 *
 * @author DELL
 */
public class DetalleDaoTmpl implements DetalleDao{
    private PreparedStatement ps;
    private ResultSet rs;
    private Connection cx;
    
    @Override
    public int create(Detalle cl) {
        String SQL = "INSERT INTO detalle(precio, cantidad, idproducto, idventa) VALUES(?, ?, ?, ?)";
        int x = 0;
        try {
            cx = Conn.getConn();
            ps = cx.prepareStatement(SQL);
            ps.setFloat(1, cl.getPrecio());
            ps.setInt(2, cl.getCantidad());
            ps.setInt(3, cl.getIdproducto());
            ps.setInt(4, cl.getIdventa());
            
            x = ps.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Error: "+e);
        }
        return x;       
    }

    @Override
    public int update(Detalle cl) {
        String SQL = "UPDATE detalle SET precio=?, cantidad=?, idproducto=?, idventa=?  WHERE iddetalle=?";
        int x = 0;
        try {
            cx = Conn.getConn();
            ps = cx.prepareStatement(SQL);
            ps.setFloat(1, cl.getPrecio());
            ps.setInt(2, cl.getCantidad());
            ps.setInt(3, cl.getIdproducto());
            ps.setInt(4, cl.getIdventa());
            ps.setInt(5, cl.getIddetalle());
            
            x = ps.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Error: "+e);
        }
        return x;
    }

    @Override
    public int delete(int id) {
        String SQL = "DELETE FROM detalle WHERE iddetalle=?";
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
    public Detalle read(int id) {
        String SQL = "SELECT * FROM detalle WHERE iddetalle=?";
        Detalle cl = new Detalle();
        try {
            cx = Conn.getConn();
            ps = cx.prepareStatement(SQL);
            ps.setInt(1, id);
            rs = ps.executeQuery();
            while(rs.next()){
                cl.setIddetalle(rs.getInt("iddetalle"));
                cl.setPrecio(rs.getFloat("precio"));
                cl.setCantidad(rs.getInt("cantidad"));
                cl.setIdproducto(rs.getInt("idproducto"));
                cl.setIdventa(rs.getInt("idventa"));
            }
        } catch (SQLException e) {
            System.out.println("Error: "+e);
        }
        return cl;
    }

    @Override
    public List<Detalle> readAll() {
        String SQL = "SELECT * FROM detalle";
        List<Detalle> lista = new ArrayList<>();
        try {
            cx = Conn.getConn();
            ps = cx.prepareStatement(SQL);
            rs = ps.executeQuery();
            while(rs.next()){
                Detalle cl = new Detalle();
                cl.setIddetalle(rs.getInt("iddetalle"));
                cl.setPrecio(rs.getFloat("precio"));
                cl.setCantidad(rs.getInt("cantidad"));
                cl.setIdproducto(rs.getInt("idproducto"));
                cl.setIdventa(rs.getInt("idventa"));
                lista.add(cl);
            }
        } catch (SQLException e) {
            System.out.println("Error: "+e);
        }
        return lista;
    }
}
