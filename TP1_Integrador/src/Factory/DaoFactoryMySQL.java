package Factory;

import java.sql.Connection;
import java.sql.SQLException;

import DAO.DAOFactory;
import DAO.MySQLClienteDAO;
import DAO.UsuarioDAO;


public class DaoFactoryMySQL implements DAOFactory {
    private static DaoFactoryMySQL instance; // Instancia única de la fábrica
    private Connection connection;

    // Constructor privado para evitar la creación de instancias desde fuera
    private JDBCDAOFactory(Connection connection) {
        this.connection = connection;
    }

    // Método estático para obtener la instancia única de la fábrica
    public static synchronized DaoFactoryMySQL getInstance(Connection connection) {
        if (instance == null) {
            instance = new DaoFactoryMySQL(connection);
        }
        return instance;
    }
    @Override
    public void insertarUsuario (String id, String nombre, String email ) throws SQLException{
        
    }

    @Override
    public UsuarioDAO getUsuarioDAO() {
        return new MySQLClienteDAO(connection);
    }
    
}
