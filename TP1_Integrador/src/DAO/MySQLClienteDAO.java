package DAO;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;


public class MySQLClienteDAO implements UsuarioDAO{
	private Connection conn;
		public MySQLClienteDAO(Connection conn) {
		this.conn=conn;
	}
	@Override
	public void insertar(INT id, String nombre, String email ) throws SQLException {
		String table= "INSERT INTO Cliente(idCliente,email,nombre) VALUES (?, ?, ?)";
		PreparedStatement ps = conn.prepareStatement(insert);
		ps.setInt(1, id);
        ps.setString(2, nombre);
        ps.setInt(3, email);
		ps.executeUpdate();
        ps.close();
		conn.commit();
		
	}

	@Override
	public void delete(INT id) {
		
	}

	@Override
	public void update(INT id, String nombre, String email ) throws SQLException {
	
	}

	@Override
	public Usuario getById(INT id){

	}

	@Override
	public List<Usuario> getAll(){

	}

	

}
