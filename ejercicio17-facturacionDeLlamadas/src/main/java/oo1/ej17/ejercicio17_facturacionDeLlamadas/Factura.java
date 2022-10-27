package oo1.ej17.ejercicio17_facturacionDeLlamadas;

import java.time.LocalDateTime;

public class Factura {
	private Cliente cliente;
	private LocalDateTime fechaDeFacturacion, fechaInicioPeriodo, fechaFinPeriodo;
	double montoTotal;
	
	public Factura (Cliente cliente, LocalDateTime fechaInicio, LocalDateTime fechaFin, double monto) {
		this.cliente = cliente;
		this.fechaDeFacturacion = LocalDateTime.now();
		this.fechaInicioPeriodo = fechaInicio;
		this.fechaFinPeriodo = fechaFin;
		this.montoTotal = monto;
	}

	public Cliente getCliente() {
		return cliente;
	}
	
	public LocalDateTime getFechaDeFacturacion() {
		return fechaDeFacturacion;
	}

	public LocalDateTime getFechaInicioPeriodo() {
		return fechaInicioPeriodo;
	}

	public LocalDateTime getFechaFinPeriodo() {
		return fechaFinPeriodo;
	}
	
	public double getMonto() {
		return this.montoTotal;
	}
}
