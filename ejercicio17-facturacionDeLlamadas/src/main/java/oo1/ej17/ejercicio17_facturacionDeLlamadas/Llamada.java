package oo1.ej17.ejercicio17_facturacionDeLlamadas;

import java.time.LocalDateTime;

public abstract class Llamada {
	private LocalDateTime fechaYHora;
	private double duracion;
	private NroTelefono telefonoOrigen, telefonoDestino;
	
	public Llamada(LocalDateTime fechaYHora, double duracion, NroTelefono telefonoOrigen, NroTelefono telefonoDestino) {
		this.fechaYHora = fechaYHora;
		this.duracion = duracion;
		this.telefonoOrigen = telefonoOrigen;
		this.telefonoDestino = telefonoDestino;
	}

	public LocalDateTime getFechaYHora() {
		return fechaYHora;
	}

	public double getDuracion() {
		return duracion;
	}

	public NroTelefono getTelefonoOrigen() {
		return telefonoOrigen;
	}

	public NroTelefono getTelefonoDestino() {
		return telefonoDestino;
	}
	
	public abstract double calcularCosto();
}
