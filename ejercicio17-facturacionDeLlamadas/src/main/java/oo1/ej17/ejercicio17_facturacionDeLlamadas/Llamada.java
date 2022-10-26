package oo1.ej17.ejercicio17_facturacionDeLlamadas;

import java.time.LocalDate;

public class Llamada {
	private LocalDate fecha;
	private double duracion;
	private NroTelefono telefonoOrigen, telefonoDestino;
	
	public Llamada(LocalDate fecha, double duracion, NroTelefono telefonoOrigen, NroTelefono telefonoDestino) {
		this.fecha = fecha;
		this.duracion = duracion;
		this.telefonoOrigen = telefonoOrigen;
		this.telefonoDestino = telefonoDestino;
	}
	
	
}
