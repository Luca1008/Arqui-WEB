package DAO;


public class Factura_ProductoDao implements DAOFactory{

	public void insertar(String id, String nombre, String email ) {
		System.out.println(id +"-"+nombre+"-"+email);
		
	}

	@Override
	public void eliminar(Cliente a) {
		
	}

	@Override
	public void modificar(Cliente a) {
		
	}


	

}
