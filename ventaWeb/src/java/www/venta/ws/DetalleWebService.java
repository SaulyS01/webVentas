package www.venta.ws;

import java.util.List;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import www.venta.daoTmpl.DetalleDaoTmpl;
import www.venta.model.Detalle;

/**
 *
 * @author DELL
 */
@WebService(serviceName = "DetalleWebService")
public class DetalleWebService {

    DetalleDaoTmpl detalleDao = new DetalleDaoTmpl();
    @WebMethod(operationName = "crear")
    public int crear(@WebParam(name = "precio") float precio, @WebParam(name = "cantidad") int cantidad, 
            @WebParam(name = "idproducto") int idproducto, @WebParam(name = "idventa") int idventa) {
        return detalleDao.create(new  Detalle(0, precio, cantidad, idproducto, idventa));
    }

    @WebMethod(operationName = "editar")
    public int editar(@WebParam(name = "iddetalle") int iddetalle, @WebParam(name = "precio") float precio, @WebParam(name = "cantidad") int cantidad, 
            @WebParam(name = "idproducto") int idproducto, @WebParam(name = "idventa") int idventa) {
        return detalleDao.update(new Detalle(iddetalle, precio, cantidad, idproducto, idventa));
    }

    @WebMethod(operationName = "eliminar")
    public int eliminar(@WebParam(name = "iddetalle") int iddetalle) {
        return detalleDao.delete(iddetalle);
    }

    @WebMethod(operationName = "read")
    public Detalle read(@WebParam(name = "iddetalle") int iddetalle) {
        return detalleDao.read(iddetalle);
    }

    @WebMethod(operationName = "readAll")
    public List<Detalle> readAll() {
        return detalleDao.readAll();
    }
}
