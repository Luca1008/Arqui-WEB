package DAO;


import java.sql.Connection;
import java.sql.SQLException;


public class ClienteDao implements DaoFactory{
	private Connection conn;
		public ClienteDao(Connection conn) {
		this.conn=conn;
	}
	@Override
	public void insertar(String id, String nombre, String email ) throws SQLException {
		String table= "INSERT INTO Cliente(idCliente,email,nombre) VALUES ("+id+ ",'" +nombre+"','"+email+"')";
		conn.prepareStatement(table).execute();
		conn.commit();
		
	}

	//@Override
	//public void eliminar(Cliente a) {
		// TODO Auto-generated method stub
		
//	}

	//@Override
	//public void modificar(Cliente a) {
		// TODO Auto-generated method stub
		
	//}

	

}
