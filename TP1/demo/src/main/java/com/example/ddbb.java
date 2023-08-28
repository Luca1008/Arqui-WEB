package com.example;

import java.lang.reflect.InvocationTargetException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ddbb {
    
    public static void main(String[] args) throws SQLException {
        String driver = "org.apache.derby.jdbc.EmbeddedDriver";
        
        try {
            Class.forName(driver).getDeclaredConstructor().newInstance();
        } catch (InstantiationException | IllegalAccessException | IllegalArgumentException | InvocationTargetException
                | NoSuchMethodException | SecurityException | ClassNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            System.exit(1);
        }

        String uri = "jdbc:derby:MyderbyDb;create=true";

        try {
            Connection conn = DriverManager.getConnection(uri);
            //createTables(conn);
            addPersona(conn, 5, "Juan", 20);
            addPersona(conn, 7, "Paula", 30);
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        

    }

    private static void createTables (Connection conn) throws SQLException{
            String table = "CREATE TABLE persona( id INT PRIMARY KEY, nombre VARCHAR(500), edad INT )";
            conn.prepareStatement(table).execute();
            conn.commit();
        }

    private static void addPersona(Connection conn, int id, String name, int edad) throws SQLException{
        String insert = "INSERT INTO persona (id, nombre, edad) VALUES (?, ?, ?)";
        PreparedStatement ps = conn.prepareStatement(insert);
        ps.setInt(1, id);
        ps.setString(2, name);
        ps.setInt(3, edad);
       // ps.setInt(3, edad);
        ps.executeUpdate();
        ps.close();
        conn.commit();
    }


}
