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
import www.venta.dao.VentaDao;
import www.venta.model.Venta;

public class VentaDaoTmpl implements VentaDao{
    private PreparedStatement ps;
    private ResultSet rs;
    private Connection cx;
    
    @Override
    public int create(Venta vent) {
        String SQL = "INSERT INTO venta(fecha, tipodoc, numdoc, idcliente) VALUES(?, ?, ?, ?)";
        int x = 0;
        try {
            cx = Conn.getConn();
            ps = cx.prepareStatement(SQL);
            ps.setDate(1, vent.getFecha());
            ps.setString(2, vent.getTipodoc());
            ps.setString(3, vent.getNumdoc());
            ps.setInt(4, vent.getIdcliente());
            x = ps.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Error: "+e);
        }
        return x;       
    }

    @Override
    public int update(Venta vent) {
        String SQL = "UPDATE venta SET fecha=?, tipodoc=?, numdoc=?, idcliente=? WHERE idventa=?";
        int x = 0;
        try {
            cx = Conn.getConn();
            ps = cx.prepareStatement(SQL);
            ps.setDate(1, vent.getFecha());
            ps.setString(2, vent.getTipodoc());
            ps.setString(3, vent.getNumdoc());
            ps.setInt(4, vent.getIdcliente());
            ps.setInt(5, vent.getIdventa());
            x = ps.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Error: "+e);
        }
        return x;
    }

    @Override
    public int delete(int id) {
        String SQL = "DELETE FROM venta WHERE idventa=?";
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
    public Venta read(int id) {
        String SQL = "SELECT * FROM venta WHERE idventa=?";
        Venta vent = new Venta();
        try {
            cx = Conn.getConn();
            ps = cx.prepareStatement(SQL);
            ps.setInt(1, id);
            rs = ps.executeQuery();
            while(rs.next()){
                vent.setFecha(rs.getDate("fecha"));
                vent.setTipodoc(rs.getString("tipodoc"));
                vent.setNumdoc(rs.getString("numdoc"));
                vent.setIdcliente(rs.getInt("idcliente"));
            }
        } catch (SQLException e) {
            System.out.println("Error: "+e);
        }
        return vent;
    }

    @Override
    public List<Venta> readAll() {
        String SQL = "SELECT * FROM venta";
        List<Venta> lista = new ArrayList<>();
        try {
            cx = Conn.getConn();
            ps = cx.prepareStatement(SQL);
            rs = ps.executeQuery();
            while(rs.next()){
                Venta vent = new Venta();
                vent.setIdventa(rs.getInt("idventa"));
                vent.setFecha(rs.getDate("fecha"));
                vent.setTipodoc(rs.getString("tipodoc"));
                vent.setNumdoc(rs.getString("numdoc"));
                vent.setIdcliente(rs.getInt("idcliente"));
                lista.add(vent);
            }
        } catch (SQLException e) {
            System.out.println("Error: "+e);
        }
        return lista;
    }
}
