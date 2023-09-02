package DAO;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;


public class ClienteDao implements DaoFactory{
	private Connection conn;
		public ClienteDao(Connection conn) {
		this.conn=conn;
	}
	@Override
	public void insertar(String id, String nombre, String email ) throws SQLException {
		String table= "INSERT INTO Cliente(idCliente,email,nombre) VALUES (?, ?, ?)";
		PreparedStatement ps = conn.prepareStatement(insert);
		ps.setInt(1, id);
        ps.setString(2, nombre);
        ps.setInt(3, email);
		ps.executeUpdate();
        ps.close();
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
