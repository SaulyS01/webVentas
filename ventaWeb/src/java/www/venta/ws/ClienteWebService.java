/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/WebServices/WebService.java to edit this template
 */
package www.venta.ws;

import java.util.List;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import www.venta.daoTmpl.ClienteDaoTmpl;
import www.venta.model.Cliente;


@WebService(serviceName = "ClienteWebService")
public class ClienteWebService {

    ClienteDaoTmpl clienteDao = new ClienteDaoTmpl();
    @WebMethod(operationName = "crear")
    public int crear(@WebParam(name = "nombres") String nombres, @WebParam(name = "apellidos") 
            String apellidos, @WebParam(name = "dni") 
            String dni, @WebParam(name = "direccion") 
            String direccion) {
        return clienteDao.create(new  Cliente(0, nombres, apellidos, dni, direccion));
    }

    @WebMethod(operationName = "editar")
    public int editar(@WebParam(name = "idcliente") int idcliente, @WebParam(name = "nombres") String nombres, @WebParam(name = "apellidos") 
            String apellidos, @WebParam(name = "dni") 
            String dni, @WebParam(name = "direccion") 
            String direccion) {
        return clienteDao.update(new Cliente(idcliente, nombres, apellidos, dni, direccion));
    }

    @WebMethod(operationName = "eliminar")
    public int eliminar(@WebParam(name = "idcliente") int idcliente) {
        return clienteDao.delete(idcliente);
    }

    @WebMethod(operationName = "read")
    public Cliente read(@WebParam(name = "idcliente") int idcliente) {
        return clienteDao.read(idcliente);
    }

    @WebMethod(operationName = "readAll")
    public List<Cliente> readAll() {
        return clienteDao.readAll();
    }
}
