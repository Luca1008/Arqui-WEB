package DAO;

public interface FacturaDAO {
    public void insert(int id, INT idCliente ) throws SQLException;

    public void update(int id, INT idCliente) throws SQLException;

    public void delete(int id);

    public Factura getById(int id);

    public List<Factura> getAll();
}
