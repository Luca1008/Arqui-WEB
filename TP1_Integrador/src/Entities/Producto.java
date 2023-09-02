package Entities;

import java.util.Objects;

public class Producto {
	private Long idProducto;
	private String nombre;
	private float valor;
	public Producto(Long idProducto, String nombre, float valor) {
		super();
		this.idProducto = idProducto;
		this.nombre = nombre;
		this.valor = valor;
	}
	public int getIdProducto() {
		return idProducto;
	}
	public void setIdProducto(int idProducto) {
		this.idProducto = idProducto;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public float getValor() {
		return valor;
	}
	public void setValor(float valor) {
		this.valor = valor;
	}
	@Override
	public String toString() {
		return "Producto [idProducto=" + idProducto + ", nombre=" + nombre + ", valor=" + valor + "]";
	}
	@Override
	public int hashCode() {
		return Objects.hash(idProducto, nombre, valor);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Producto other = (Producto) obj;
		return idProducto == other.idProducto && Objects.equals(nombre, other.nombre)
				&& Float.floatToIntBits(valor) == Float.floatToIntBits(other.valor);
	}
	
	
	

}
