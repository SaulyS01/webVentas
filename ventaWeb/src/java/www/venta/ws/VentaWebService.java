package www.venta.ws;

import java.util.Date;
import java.util.List;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import www.venta.daoTmpl.VentaDaoTmpl;
import www.venta.model.Venta;

@WebService(serviceName = "VentaWebService")

public class VentaWebService {

    VentaDaoTmpl ventaDao = new VentaDaoTmpl();
    @WebMethod(operationName = "crear")
    public int crear(@WebParam(name = "fecha") Date fecha, @WebParam(name = "tipodoc") String tipodoc, 
            @WebParam(name = "numdoc") String numdoc, @WebParam(name = "idcliente") int idcliente) {
        return ventaDao.create(new  Venta(0, (java.sql.Date) fecha, tipodoc, numdoc, idcliente));
    }

    @WebMethod(operationName = "editar")
    public int editar(@WebParam(name = "idventa") int idventa, @WebParam(name = "fecha") Date fecha, @WebParam(name = "tipodoc") String tipodoc, 
            @WebParam(name = "numdoc") String numdoc, @WebParam(name = "idcliente") int idcliente) {
        return ventaDao.update(new Venta(idventa, (java.sql.Date) fecha, tipodoc, numdoc, idcliente));
    }

    @WebMethod(operationName = "eliminar")
    public int eliminar(@WebParam(name = "idventa") int idventa) {
        return ventaDao.delete(idventa);
    }

    @WebMethod(operationName = "read")
    public Venta read(@WebParam(name = "idventa") int idventa) {
        return ventaDao.read(idventa);
    }

    @WebMethod(operationName = "readAll")
    public List<Venta> readAll() {
        return ventaDao.readAll();
    }
}
