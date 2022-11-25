package oo1.extra.EnergiaFinal2018;

import java.util.ArrayList;
import java.util.List;

public abstract class Cliente {
	private List<Medicion> mediciones;
	private String nombre;
	private String direccion;
	
	public Cliente(String nombre, String direccion) {
		this.nombre = nombre;
		this.direccion = direccion;
		this.mediciones = new ArrayList<Medicion>();
	}
	
	public void registrarMedicion(Medicion medicion) {
		this.mediciones.add(medicion);
	}
	
	public abstract double calcularMontoAFacturar(Fecha fecha, Tarifario tarifario);
	
	public abstract double descuento(Medicion medicion, double porcentajeDescuento, double monto);
	
	public Medicion buscarMedicion(Fecha fecha) {
		return this.mediciones.stream().filter(m -> m.delLaFecha(fecha)).findFirst().orElse(null);
	}

	public String getNombre() {
		return nombre;
	}

	public String getDireccion() {
		return direccion;
	}
	
}
