/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package www.venta.dao;

import java.util.List;
import www.venta.model.Cliente;

public interface ClienteDao {
    int create(Cliente vent);
    int update(Cliente vent);
    int delete(int id);
    Cliente read(int id);
    List<Cliente> readAll();
}
