package oo1.ej17.ejercicio17_facturacionDeLlamadas;

import java.time.LocalDateTime;

public class LlamadaLocal extends Llamada{
	
	private double costoPorMinuto;
	
	public LlamadaLocal(LocalDateTime fechaYHora, double duracion, NroTelefono telefonoOrigen, NroTelefono telefonoDestino) {
		super(fechaYHora, duracion, telefonoOrigen, telefonoDestino);
		this.costoPorMinuto = 1;
	}
	
	// Hago protegida a la duración en la superclase? O utilizo getter para accederla?
	public double calcularCosto() {
		return this.getDuracion() * this.costoPorMinuto;
	}
	
}
