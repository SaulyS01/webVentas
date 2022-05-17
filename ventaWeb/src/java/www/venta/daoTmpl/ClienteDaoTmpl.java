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
import www.venta.dao.ClienteDao;
import www.venta.model.Cliente;

public class ClienteDaoTmpl implements ClienteDao{
    private PreparedStatement ps;
    private ResultSet rs;
    private Connection cx;
    
    @Override
    public int create(Cliente cl) {
        String SQL = "INSERT INTO cliente(nombres, apellidos, dni, direccion) VALUES(?, ?, ?, ?)";
        int x = 0;
        try {
            cx = Conn.getConn();
            ps = cx.prepareStatement(SQL);
            ps.setString(1, cl.getNombres());
            ps.setString(2, cl.getApellidos());
            ps.setString(3, cl.getDni());
            ps.setString(4, cl.getDireccion());
            
            x = ps.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Error: "+e);
        }
        return x;       
    }

    @Override
    public int update(Cliente cl) {
        String SQL = "UPDATE cliente SET nombres=?, apellidos=?, dni=?, direccion=?  WHERE idcliente=?";
        int x = 0;
        try {
            cx = Conn.getConn();
            ps = cx.prepareStatement(SQL);
            ps.setString(1, cl.getNombres());
            ps.setString(2, cl.getApellidos());
            ps.setString(3, cl.getDni());
            ps.setString(4, cl.getDireccion());
            ps.setInt(5, cl.getIdcliente());
            
            x = ps.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Error: "+e);
        }
        return x;
    }

    @Override
    public int delete(int id) {
        String SQL = "DELETE FROM cliente WHERE idcliente=?";
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
    public Cliente read(int id) {
        String SQL = "SELECT * FROM cliente WHERE idcliente=?";
        Cliente cl = new Cliente();
        try {
            cx = Conn.getConn();
            ps = cx.prepareStatement(SQL);
            ps.setInt(1, id);
            rs = ps.executeQuery();
            while(rs.next()){
                cl.setIdcliente(rs.getInt("idcliente"));
                cl.setNombres(rs.getString("nombres"));
                cl.setApellidos(rs.getString("apellidos"));
                cl.setDni(rs.getString("dni"));
                cl.setDireccion(rs.getString("direccion"));
            }
        } catch (SQLException e) {
            System.out.println("Error: "+e);
        }
        return cl;
    }

    @Override
    public List<Cliente> readAll() {
        String SQL = "SELECT * FROM cliente";
        List<Cliente> lista = new ArrayList<>();
        try {
            cx = Conn.getConn();
            ps = cx.prepareStatement(SQL);
            rs = ps.executeQuery();
            while(rs.next()){
                Cliente cl = new Cliente();
                cl.setIdcliente(rs.getInt("idcliente"));
                cl.setNombres(rs.getString("nombres"));
                cl.setApellidos(rs.getString("apellidos"));
                cl.setDni(rs.getString("dni"));                
                cl.setDireccion(rs.getString("direccion"));
                lista.add(cl);
            }
        } catch (SQLException e) {
            System.out.println("Error: "+e);
        }
        return lista;
    }
}
