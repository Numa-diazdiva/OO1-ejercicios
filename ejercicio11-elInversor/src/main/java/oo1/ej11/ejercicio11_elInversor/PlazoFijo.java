package oo1.ej11.ejercicio11_elInversor;

import java.time.LocalDate;

public class PlazoFijo implements Inversion{
	LocalDate fechaDeConstitucion;
	double montoDepositado;
	double porcentajeDeInteresDiario;
	
	public PlazoFijo(double montoDepositado, double porcentajeDeInteresDiario) {
		this.fechaDeConstitucion = LocalDate.now();
		this.montoDepositado = montoDepositado;
		this.porcentajeDeInteresDiario = porcentajeDeInteresDiario;
	}
	
	public double getMontoDepositado() {
		return this.montoDepositado;
	}
	
	public double getPorcentajeDeInteresDiario() {
		return this.porcentajeDeInteresDiario;
	}
	
	public LocalDate getFechaDeConstitucion() {
		return this.fechaDeConstitucion;
	}
	
	// Este método no está en el diseño, es sólo para poder testear fechas distintas
	public void setFechaDeConstitucion(LocalDate fecha) {
		this.fechaDeConstitucion = fecha;
	}
	
	public double valorActual() {
		LocalDate hoy = LocalDate.now();
		long tiempoDias = hoy.toEpochDay() - this.fechaDeConstitucion.toEpochDay();
		return this.montoDepositado + (this.montoDepositado * this.porcentajeDeInteresDiario * tiempoDias);
	}
	
}
