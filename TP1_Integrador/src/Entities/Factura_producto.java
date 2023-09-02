package Entities;

import java.util.Objects;

public class Factura_producto {
	private Long idFactura;
	private Long idproducto;
	private int cantidad;
	public Factura_producto(Long idFactura, Long idproducto, int cantidad) {
		super();
		this.idFactura = idFactura;
		this.idproducto = idproducto;
		this.cantidad = cantidad;
	}
	public int getIdFactura() {
		return idFactura;
	}
	public void setIdFactura(Long idFactura) {
		this.idFactura = idFactura;
	}
	public int getIdproducto() {
		return idproducto;
	}
	public void setIdproducto(Long idproducto) {
		this.idproducto = idproducto;
	}
	public int getCantidad() {
		return cantidad;
	}
	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}
	@Override
	public String toString() {
		return "Factura_producto [idFactura=" + idFactura + ", idproducto=" + idproducto + ", cantidad=" + cantidad
				+ "]";
	}
	@Override
	public int hashCode() {
		return Objects.hash(cantidad, idFactura, idproducto);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Factura_producto other = (Factura_producto) obj;
		return cantidad == other.cantidad && idFactura == other.idFactura && idproducto == other.idproducto;
	}
	
	
	

}
