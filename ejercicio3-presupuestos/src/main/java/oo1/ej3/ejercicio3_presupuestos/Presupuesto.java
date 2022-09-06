package oo1.ej3.ejercicio3_presupuestos;
import java.time.LocalDate;
import java.util.Vector;

public class Presupuesto {
	private LocalDate fecha;
	private String cliente;
	//Consultar uso de Vector
	private Vector<Item> items = new Vector<Item>();
	
	
	public Presupuesto(String cliente){
		this.fecha = LocalDate.now();
		this.cliente = cliente;
	}
	
	public Presupuesto() {}
	
	// Preguntar por estos métodos requeridos en el test. Variables públicas o este tipo de setters?
//	public void fecha(LocalDate fecha) {
//		this.fecha = fecha;
//	}
//	
//	public void cliente(String cliente) {
//		this.cliente = cliente;
//	}
	
	public LocalDate getFecha() {
		return fecha;
	}
	
	public String getCliente() {
		return cliente;
	}
	
	public void agregarItem(Item item) {
		this.items.add(item);
	}
	
	public double calcularTotal() {
		double total = 0; // inicializo o no inicializo nada?
		// Va esto así?
		
		for(int i = 0; i < this.items.size(); i++) {
			total += this.items.get(i).costo();
		}

		return total;
	}
	
}
