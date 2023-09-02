package main;

import java.sql.Connection;
import java.sql.SQLException;

public class Helper {
	public static final String PRODUCTO_FILE = ".\\src\\dataset\\productos.csv";
	public static final String CLIENTE_FILE= ".\\src\\dataset\\clientes.csv";
	public static final String FACTURA_FILE= ".\\src\\dataset\\facturas.csv";
	public static final String FACTURA_PROD_FILE= ".\\src\\dataset\\facturas-productos.csv";
	
	public static void crearTablas(Connection conn) throws SQLException{
		String table= "CREATE TABLE Cliente("+
				"idCliente INT,"+
				"email VARCHAR(150),"+
				"nombre VARCHAR(500),"+
				"PRIMARY KEY (idCliente))";
		conn.prepareStatement(table).execute();
		conn.commit();
		
		table= "CREATE TABLE Producto("+
				"idProducto INT,"+
				"nombre VARCHAR(45),"+
				"valor float,"+
				"PRIMARY KEY (idProducto))";
		conn.prepareStatement(table).execute();
		conn.commit();
		table= "CREATE TABLE Factura("+
				"idCliente INT,"+
				"idFactura INT,"+
				"PRIMARY KEY (idFactura))";
		conn.prepareStatement(table).execute();
		conn.commit();
		table= "ALTER TABLE Factura ADD CONSTRAINT FK_fac_cliente"
				+ " FOREIGN KEY (idCliente)"
				+ " REFERENCES Cliente(idCliente)";
		conn.prepareStatement(table).execute();
		conn.commit();
		table= "CREATE TABLE Factura_Producto("+
				"idProducto INT,"+
				"idFactura INT,"+
				"cantidad INT)";
		conn.prepareStatement(table).execute();
		conn.commit();
		table= "ALTER TABLE Factura_Producto ADD CONSTRAINT FK_fac_prod_prod"
				+ " FOREIGN KEY (idProducto)"
				+ " REFERENCES Producto(idProducto)";
		conn.prepareStatement(table).execute();
		conn.commit();
		table= "ALTER TABLE Factura_Producto ADD CONSTRAINT FK_fac_prod_fac"
				+ " FOREIGN KEY (idFactura)"
				+ " REFERENCES Factura(idFactura);";
		conn.prepareStatement(table).execute();
		conn.commit();
			
	}
}
