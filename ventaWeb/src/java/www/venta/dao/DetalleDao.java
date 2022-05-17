/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package www.venta.dao;

import java.util.List;
import www.venta.model.Detalle;

/**
 *
 * @author DELL
 */
public interface DetalleDao {
    int create(Detalle vent);
    int update(Detalle vent);
    int delete(int id);
    Detalle read(int id);
    List<Detalle> readAll();
}
