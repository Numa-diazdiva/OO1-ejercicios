package oo1.ej11.ejercicio11_elInversor;

import java.util.List;
import java.util.ArrayList;

public class Inversor {
	private String nombre;
	private List<Inversion> inversiones;
	
	public Inversor(String nombre) {
		inversiones = new ArrayList<Inversion>();
		this.nombre = nombre;
	}
	
	public String getNombre() {
		return this.nombre;
	}
	
	public List<Inversion> getInversiones() {
		return this.inversiones;
	}
	
	public void agregarInversion(Inversion inversion) {
		this.inversiones.add(inversion);
	}
	
	public double valorActual() {
		double valor = this.inversiones.stream().mapToDouble(inv -> inv.valorActual()).sum();
		return valor;
	}
	
}
