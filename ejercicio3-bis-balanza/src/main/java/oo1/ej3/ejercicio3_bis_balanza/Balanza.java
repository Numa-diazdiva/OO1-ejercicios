package oo1.ej3.ejercicio3_bis_balanza;
import java.util.LinkedList;

public class Balanza {

	private LinkedList<Producto> productos = new LinkedList<Producto>();
	
	public Balanza(){
		this.ponerEnCero();
	}
	
	public void ponerEnCero(){
		this.productos = new LinkedList<Producto>();
	}
	
	public void agregarProducto(Producto producto){
		productos.add(producto);
	}
	
	public Ticket emitirTicket(){
		Ticket ticket = new Ticket(this.getCantidadDeProductos(), this.getPrecioTotal(), this.getPesoTotal(), this.getProductos());
		return ticket;
	}
	
	public int getCantidadDeProductos(){
		return this.productos.size();
	}
	
	public double getPrecioTotal(){
		double precioTotal = 0;
		for(int i = 0; i < this.getCantidadDeProductos(); i++) {
			precioTotal += productos.get(i).getPrecio();
		}
		return precioTotal;
	}
	
	public double getPesoTotal(){
		double pesoTotal = 0;
		for(int i = 0; i < this.getCantidadDeProductos(); i++) {
			pesoTotal += productos.get(i).getPeso();
		}
		return pesoTotal;
	}
	
	public LinkedList<Producto> getProductos(){
		return this.productos;
	}


}
