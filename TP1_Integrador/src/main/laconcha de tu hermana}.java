package main;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;


public class Main {
	public static final String PRODUCTO_FILE = ".\\src\\dataset\\productos.csv";
	public static final String CLIENTE_FILE= ".\\src\\dataset\\clientes.csv";
	public static final String FACTURA_FILE= ".\\src\\dataset\\facturas.csv";
	public static final String FACTURA_PROD_FILE= ".\\src\\dataset\\facturas-productos.csv";
	
	public static void main(String[] args)throws FileNotFoundException, IOException {
		String driver = "com.mysql.cj.jdbc.Driver"; 
		String url = "jdbc:mysql://localhost:3306/integrador1";
		Conexion conn = new Conexion(driver, url);
	
		File productos =new File(PRODUCTO_FILE);
		File clientes =new File(CLIENTE_FILE);
		File facturas =new File(FACTURA_FILE);
		File facturasProductos =new File(FACTURA_PROD_FILE);
		
		CSVParser parser = CSVFormat.DEFAULT.withHeader().parse(new FileReader(productos));
				for(CSVRecord row: parser) {
					//ACA DEBERIAMOS LLAMAR AL DAO Y HACER EL INSERT DE CADA PRODUCTO
					//PRODUCTODAO.INSERT(row.get("idProducto",row.get("nombre",row.get("valor"))
				System.out.println(row.get("idProducto"));
				System.out.println(row.get("nombre"));
				System.out.println(row.get("valor"));
				}

	}

}
