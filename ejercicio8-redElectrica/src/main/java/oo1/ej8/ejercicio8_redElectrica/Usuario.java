package oo1.ej8.ejercicio8_redElectrica;

import java.util.List;
import java.util.LinkedList;

public class Usuario {
	private String domicilio;
	private String nombre;
	private List<Consumo> consumos;
	private List<Factura> facturas;
	
	public Usuario(String nombre, String domicilio) {
		consumos = new LinkedList<Consumo>();
		facturas = new LinkedList<Factura>();
		this.nombre = nombre;
		this.domicilio = domicilio;
	}
	
	
	public String getNombre() {
		return nombre;
	}
	
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public String getDomicilio() {
		return domicilio;
	}
	
	public void setDomicilio(String domicilio) {
		this.domicilio = domicilio;
	}
	
	public List<Consumo> getConsumos() {
		return this.consumos;
	}
	
	public void agregarMedicion(Consumo medicion) {
		this.consumos.add(medicion);
	}
	
	public double ultimoConsumoActiva() {
		return this.consumos.get(this.consumos.size()-1).getConsumoEnergiaActiva();
	}
	
	public Factura facturarEnBaseA(double precioKWh) {
		Factura fact = new Factura(precioKWh, this.consumos.get(this.consumos.size() - 1), this);
		this.facturas.add(fact);
		return fact;
	}
	
}
