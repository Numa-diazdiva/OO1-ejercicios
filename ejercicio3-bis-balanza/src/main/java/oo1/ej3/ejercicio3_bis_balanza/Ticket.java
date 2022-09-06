package oo1.ej3.ejercicio3_bis_balanza;
import java.time.LocalDate;
import java.util.LinkedList;

public class Ticket{
	private LocalDate fecha;
	private int cantidadDeProductos;
	private double precioTotal;
	private double pesoTotal;
	private LinkedList<Producto> productos = new LinkedList<Producto>();
	
	public Ticket(int cantidad, double precio, double peso, LinkedList<Producto> productos){
		//checar el seteo con los setters (preguntar)
		this.fecha = LocalDate.now();
		this.setCantidadDeProductos(cantidad);
		this.setPrecioTotal(precio);
		this.setPesoTotal(peso);
		this.productos = productos;
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
	
	public LinkedList<Producto> getProductos(){
		return productos;		
	}
	
	public double impuesto(){
		return this.getPrecioTotal() * 0.21;
	}
	
}