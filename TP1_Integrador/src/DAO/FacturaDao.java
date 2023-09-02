package DAO;

public interface FacturaDAO {
    public void insert(INT id, INT idCliente ) throws SQLException;

    public void update(INT id, INT idCliente) throws SQLException;

    public void delete(INT id);

    public Factura getById(INT id);

    public List<Factura> getAll();
}
