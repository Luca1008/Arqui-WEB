package DAO;

import java.sql.SQLException;

public interface UsuarioDAO {


    public void insert(int id, String nombre, String email ) throws SQLException;

    public void update(int id, String nombre, String email ) throws SQLException;

    public void delete(int id);

    public Usuario getById(int id);

    public List<Usuario> getAll();


}
