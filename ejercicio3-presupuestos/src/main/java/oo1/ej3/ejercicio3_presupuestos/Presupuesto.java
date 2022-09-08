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
	// Post pregunta: en este caso la idea del test era ver qué pasa si encadenamos métodos: cada uno se aplica al resultado
	// del anterior. Como consecuencia vemos que si apliqué el método fecha luego de instanciar un objeto de clase Presupuesto,
	// al querer aplicar el método encadenado "cliente", voy a estar haciéndolo sobre el tipo "void" si únicamente implementé un setter
	// que no devuelve nada. Por eso, para este ejercicio elijo devolver un objeto presupuesto en estos setters invocados desde el test original.
	
	public Presupuesto fecha(LocalDate fecha) {
		this.fecha = fecha;
		return this;
	}
	
	public Presupuesto cliente(String cliente) {
		this.cliente = cliente;
		return this;
	}
	
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
