package packeage1;

import java.lang.reflect.InvocationTargetException;
import java.sql.Connection;
import java.sql.DriverManager;
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
        Connection connection = DriverManager.getConnection(uri);
    }
}
