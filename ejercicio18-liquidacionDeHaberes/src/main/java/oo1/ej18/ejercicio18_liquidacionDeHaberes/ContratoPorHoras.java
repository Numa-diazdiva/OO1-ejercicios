package oo1.ej18.ejercicio18_liquidacionDeHaberes;

import java.time.LocalDate;

public class ContratoPorHoras extends Contrato {
	private LocalDate fechaFin;
	private double valorHora;
	private int horasPorMes;
	
	public ContratoPorHoras(LocalDate fechaFin, double valorHora, int horasPorMes, Empleado empleado) {
		super(empleado);
		this.fechaFin = fechaFin;
		this.valorHora = valorHora;
		this.horasPorMes = horasPorMes;
	}
	
	
	public boolean estaActivo() {
		return this.fechaFin.isAfter(LocalDate.now());
	}
	
	public double calcularMonto() {
		return this.valorHora * this.horasPorMes;
	}
	
	public boolean vence() {
		return true;
	}

}
