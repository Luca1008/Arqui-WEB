package DAO;

import java.sql.SQLException;
import java.util.List;

public interface ProductoDAO {
    public void insert(int id, String nombre, float valor ) throws SQLException;

    public void update(int id, String nombre, float valor ) throws SQLException;

    public void delete(int id);

    public Producto getById(int id);

    public List<Producto> getAll();
}
