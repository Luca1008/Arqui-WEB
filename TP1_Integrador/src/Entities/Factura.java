package Entities;

import java.util.Objects;

public class Factura {
	private INT idFactura;
	private INT idCliente;
	public Factura(INT idFactura, INT idCliente) {
		super();
		this.idFactura = idFactura;
		this.idCliente = idCliente;
	}
	public int getIdFactura() {
		return idFactura;
	}
	public void setIdFactura(int idFactura) {
		this.idFactura = idFactura;
	}
	public int getIdCliente() {
		return idCliente;
	}
	public void setIdCliente(int idCliente) {
		this.idCliente = idCliente;
	}
	@Override
	public String toString() {
		return "Factura [idFactura=" + idFactura + ", idCliente=" + idCliente + "]";
	}
	@Override
	public int hashCode() {
		return Objects.hash(idCliente, idFactura);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Factura other = (Factura) obj;
		return idCliente == other.idCliente && idFactura == other.idFactura;
	}
	
	
}
