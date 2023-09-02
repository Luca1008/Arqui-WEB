package DAO;

public interface FacturaDAO {
    public void insert(Long id, Long idCliente ) throws SQLException;

    public void update(Long id, Long idCliente) throws SQLException;

    public void delete(Long id);

    public Factura getById(Long id);

    public List<Factura> getAll();
}
