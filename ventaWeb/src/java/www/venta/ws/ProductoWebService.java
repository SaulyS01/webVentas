package www.venta.ws;

import java.util.List;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import www.venta.daoTmpl.ProductoDaoTmpl;
import www.venta.model.Producto;

@WebService(serviceName = "ProductoWebService")
public class ProductoWebService {

    ProductoDaoTmpl productoDao = new ProductoDaoTmpl();
    @WebMethod(operationName = "crear")
    public int crear(@WebParam(name = "nomprod") String nomprod, @WebParam(name = "precio") 
            float precio, @WebParam(name = "stock") 
            int stock) {
        return productoDao.create(new  Producto(0, nomprod, precio, stock));
    }

    @WebMethod(operationName = "editar")
    public int editar(@WebParam(name = "idproducto") int idproducto, @WebParam(name = "nomprod") String nomprod, @WebParam(name = "precio") 
            float precio, @WebParam(name = "stock") 
            int stock) {
        return productoDao.update(new Producto(idproducto, nomprod, precio, stock));
    }

    @WebMethod(operationName = "eliminar")
    public int eliminar(@WebParam(name = "idproducto") int idproducto) {
        return productoDao.delete(idproducto);
    }

    @WebMethod(operationName = "read")
    public Producto read(@WebParam(name = "idproducto") int idproducto) {
        return productoDao.read(idproducto);
    }

    @WebMethod(operationName = "readAll")
    public List<Producto> readAll() {
        return productoDao.readAll();
    }
}
    