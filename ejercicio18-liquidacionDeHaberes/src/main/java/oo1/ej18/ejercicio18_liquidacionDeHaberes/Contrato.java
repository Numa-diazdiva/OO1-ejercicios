package oo1.ej18.ejercicio18_liquidacionDeHaberes;

import java.time.LocalDate;

public abstract class Contrato {
	private LocalDate fechaInicio;
	private Empleado empleado;
	
	public Contrato(Empleado empleado) {
		this.fechaInicio = LocalDate.now();
		this.empleado = empleado;
	}
	
	public abstract double calcularMonto();
	
	public abstract boolean estaActivo();
	
	public abstract boolean vence();

	public LocalDate getFechaInicio() {
		return fechaInicio;
	}

	public Empleado getEmpleado() {
		return empleado;
	}
	
}
