package DAO;


import java.sql.SQLException;



public interface DaoFactory {
	
	void insertar(String id, String nombre, String email ) throws SQLException;
	
	//void eliminar(T a);
	//void modificar(T a);
}
