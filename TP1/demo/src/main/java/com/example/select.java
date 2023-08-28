package main.java.com.example;

import java.lang.reflect.InvocationTargetException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class select {
    
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
            String select = "SELECT * FROM persona";
            PreparedStatement ps = conn.prepareStatement(select);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                System.out.println(rs.getInt(1)+" , "+rs.getString(2)+" , "+rs.getInt(3));
            }
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        

    }

}
