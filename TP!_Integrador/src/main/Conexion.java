package main;

import java.lang.reflect.InvocationTargetException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion {
	Connection conn=null;
	public Conexion(String driver, String url){
		try {
			Class.forName(driver).getDeclaredConstructor().newInstance();
		}catch (InstantiationException | IllegalAccessException | IllegalArgumentException | InvocationTargetException
				| NoSuchMethodException | SecurityException | ClassNotFoundException e) {
			e.printStackTrace();
			System.exit(1);
		}
		try {
			Connection conn = DriverManager.getConnection(url, "root", "");
			conn.setAutoCommit(false);
				if(conn!=null) {
					System.out.println("Se conecto a la BBDD");
					Helper.crearTablas(conn);
				}
			
			conn.setAutoCommit(true);
			conn.close();
		}catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	
	
}
