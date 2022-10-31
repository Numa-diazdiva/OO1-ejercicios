package oo1.ej19.ejercicio19_MercadoDeObjetos;

public class Producto {
	private String nombre, descripcion;
	private double precio;
	private int cantidad;
	private Persona vendedor;
	
	public Producto(String nombre, String descripcion, double precio, int cantidad, Persona vendedor) {
		this.setNombre(nombre);
		this.setDescripcion(descripcion);
		this.setPrecio(precio);
		this.setCantidad(cantidad);
		this.vendedor = vendedor;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public double getPrecio() {
		return precio;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}

	public int getCantidad() {
		return cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}

	/**
	 * retira el stock solicitado para realizar compras
	 * @param cantidad
	 * @return true si había suficiente stock. False si la cantidad a retirar era mayor que el stock disponible.
	 */
	public boolean retirarItems(int cantidad) {
		if (this.cantidad >= cantidad) {
			this.cantidad -= cantidad;
			return true;
		}
		return false;
	}
	
	public Persona getVendedor() {
		return vendedor;
	}
	
}
