package DAO;

import java.sql.SQLException;

public interface UsuarioDAO {


    public void insert(Long id, String nombre, String email ) throws SQLException;

    public void update(Long id, String nombre, String email ) throws SQLException;

    public void delete(Long id);

    public Usuario getById(Long id);

    public List<Usuario> getAll();


}
