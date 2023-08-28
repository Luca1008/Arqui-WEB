package BaseDeDatos;

import java.lang.reflect.InvocationTargetException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Insert {
	public static void main(String[] args) {
		//new EmbeddedDriver();
		
		String driver = "com.mysql.cj.jdbc.Driver"; 
		try {
			Class.forName(driver).getDeclaredConstructor().newInstance();
		} catch (InstantiationException | IllegalAccessException | IllegalArgumentException | InvocationTargetException
				| NoSuchMethodException | SecurityException | ClassNotFoundException e) {
			e.printStackTrace();
			System.exit(1);
		}
		
		String uri = "jdbc:mysql://localhost:3306/exampleDB";
		try {
			Connection conn = DriverManager.getConnection(uri, "root", "");
			conn.setAutoCommit(false);
			
			addPerson(conn, 1, "Flor", 20);
			addPerson(conn, 2, "Gonza", 30);
			
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return;
	}
	
	private static void addPerson(Connection conn, int id, String name, int years) throws SQLException {
		String insert = "INSERT INTO persona (id, nombre, edad) VALUES(?, ?, ?)";
		PreparedStatement ps = conn.prepareStatement(insert);
		ps.setInt(1,  id);
		ps.setString(2, name);
		ps.setInt(3, years);
		ps.executeUpdate();
		ps.close();
		conn.commit();
		
	}
}
