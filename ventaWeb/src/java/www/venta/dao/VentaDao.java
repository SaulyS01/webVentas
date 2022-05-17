/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package www.venta.dao;

import java.util.List;
import www.venta.model.Venta;

public interface VentaDao {
    int create(Venta vent);
    int update(Venta vent);
    int delete(int id);
    Venta read(int id);
    List<Venta> readAll();
}
