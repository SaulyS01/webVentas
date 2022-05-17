/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package www.venta.dao;

import java.util.List;
import www.venta.model.Producto;

public interface ProductoDao {
    int create(Producto vent);
    int update(Producto vent);
    int delete(int id);
    Producto read(int id);
    List<Producto> readAll();
}
