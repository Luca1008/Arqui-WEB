package DAO;


import java.sql.SQLException;
import java.util.List;

import Entities.Factura;
import Entities.Producto;



public interface DAOFactory {
	
	
	void insertarUsuario (String id, String nombre, String email ) throws SQLException;
	void eliminarUsuario(int a);
	void modificarUsuario(int a);
	Usuario getByIdUsuario(int id);
	List<Usuario> getAllUsuario()

	void insertProducto(int id, String nombre, float valor ) throws SQLException;
    void updateProducto(int id, String nombre, float valor ) throws SQLException;
    void deleteProducto(int id);
    Producto getByIdProducto(int id);
	List<Producto> getAllProducto();

	void insertFactura(int id, INT idCliente ) throws SQLException;
    void updateFactura(int id, INT idCliente) throws SQLException;
    void deleteFactura(int id);
    Factura getByIdFactura(int id);
    List<Factura> getAllFactura();

	

}
