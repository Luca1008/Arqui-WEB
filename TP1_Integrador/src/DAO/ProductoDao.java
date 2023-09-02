package DAO;

import java.sql.SQLException;
import java.util.List;

public interface ProductoDAO {
    public void insert(Long id, String nombre, float valor ) throws SQLException;

    public void update(Long id, String nombre, float valor ) throws SQLException;

    public void delete(int id);

    public Producto getById(int id);

    public List<Producto> getAll();
}
