package ar.edu.unlp.info.oo1.ejercicio2_balanza;

public class Balanza {

	private int cantidadDeProductos;
	private double precioTotal;
	private double pesoTotal;
	
	public Balanza(){
		this.ponerEnCero();
	}
	
	public void ponerEnCero(){
		this.cantidadDeProductos = 0;
		this.precioTotal = 0;
		this.pesoTotal = 0;
	}
	
	public void agregarProducto(Producto producto){
		double peso = producto.getPeso();
		double precio = producto.getPrecio();
		this.incrementCantidadProductos();
		this.acumularPrecioTotal(precio);
		this.acumularPesoTotal(peso);
	}
	
	public Ticket emitirTicket(){
		Ticket ticket = new Ticket(this.getCantidadDeProductos(), this.getPrecioTotal(), this.getPesoTotal());
		return ticket;
	}
	
	private void incrementCantidadProductos(){
		this.cantidadDeProductos++;
	}
	
	private void acumularPrecioTotal(double precio){
		this.precioTotal += precio;
	}
	
	private void acumularPesoTotal(double peso){
		this.pesoTotal += peso;
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


}
