package ar.edu.unlp.info.oo1.ejercicio2_balanza;
import java.time.LocalDate;

public class Ticket{
	private LocalDate fecha;
	private int cantidadDeProductos;
	private double precioTotal;
	private double pesoTotal;
	
	public Ticket(int cantidad, double precio, double peso){
		this.fecha = LocalDate.now();
		this.setCantidadDeProductos(cantidad);
		this.setPrecioTotal(precio);
		this.setPesoTotal(peso);
	}
	
	public void setCantidadDeProductos(int cant){
		this.cantidadDeProductos = cant;
	}
	
	public void setPrecioTotal(double precio){
		this.precioTotal = precio;
	}
	
	public void setPesoTotal(double peso){
		this.pesoTotal = peso;
	}
	
	public int getCantidadDeProductos(){
		return this.cantidadDeProductos;
	}
	
	public double getPrecioTotal(){
		return this.precioTotal;
	}
	
	public double getPesoTotal(){
		return this.pesoTotal;
	}
	
	public LocalDate getFecha(){
		return this.fecha;
	}
	
	public double impuesto(){
		return this.getPrecioTotal() * 0.21;
	}
	
}