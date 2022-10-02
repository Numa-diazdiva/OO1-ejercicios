package oo1.ej8.ejercicio8_redElectrica;
import java.time.LocalDate;

public class Consumo {
	private LocalDate fecha;
	private double consumoEnergiaActiva;
	private double consumoEnergiaReactiva;
	
	public Consumo(double activa, double reactiva) {
		this.fecha = LocalDate.now();
		this.consumoEnergiaActiva = activa;
		this.consumoEnergiaReactiva = reactiva;
	}
	
	public LocalDate getFecha() {
		return this.fecha;
	}
	
	public double getConsumoEnergiaReactiva() {
		return this.consumoEnergiaReactiva;
	}
	
	public double getConsumoEnergiaActiva() {
		return this.consumoEnergiaActiva;
	}
	
	public double costoEnBaseA(double precioKWh) {
		return this.consumoEnergiaActiva * precioKWh;
	}
	
	public double factorDePotencia() {
		return this.consumoEnergiaActiva / Math.sqrt(Math.pow(this.consumoEnergiaReactiva, 2) + Math.pow(this.consumoEnergiaActiva, 2));
	}
	
}
