package DAO;

import java.sql.SQLException;

public interface UsuarioDAO {


    public void insert(INT id, String nombre, String email ) throws SQLException;

    public void update(INT id, String nombre, String email ) throws SQLException;

    public void delete(INT id);

    public Usuario getById(INT id);

    public List<Usuario> getAll();


}
