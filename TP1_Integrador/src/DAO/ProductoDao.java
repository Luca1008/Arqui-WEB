package DAO;

import java.sql.SQLException;
import java.util.List;

public interface ProductoDAO {
    public void insert(INT id, String nombre, float valor ) throws SQLException;

    public void update(INT id, String nombre, float valor ) throws SQLException;

    public void delete(INT id);

    public Producto getById(INT id);

    public List<Producto> getAll();
}
