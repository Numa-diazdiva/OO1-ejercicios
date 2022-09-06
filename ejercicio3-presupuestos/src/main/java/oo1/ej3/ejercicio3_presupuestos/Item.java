package oo1.ej3.ejercicio3_presupuestos;

public class Item {
	private String detalle;
	private int cantidad;
	private double costoUnitario;
	
	public Item(String detalle, double costoUnitario, int cantidad) {
		this.detalle = detalle;
		this.cantidad = cantidad;
		this.costoUnitario = costoUnitario;
	}
	
	public Item() {}
	
	// Checar este tipo de setters
//	public void detalle(String detalle) {
//		this.detalle = detalle;
//	}
//	
//	public void cantidad(int cantidad) {
//		this.cantidad = cantidad;
//	}
//	
//	public void costoUnitario(double costoUnitario) {
//		this.costoUnitario = costoUnitario;
//	}
	
	public String getDetalle() {
		return this.detalle;
	}
	
	public int getCantidad() {
		return this.cantidad;
	}
	
	public double getCostoUnitario() {
		return this.costoUnitario;
	}
	
	public double costo() {
		return this.cantidad * this.costoUnitario;
	}
	
}
