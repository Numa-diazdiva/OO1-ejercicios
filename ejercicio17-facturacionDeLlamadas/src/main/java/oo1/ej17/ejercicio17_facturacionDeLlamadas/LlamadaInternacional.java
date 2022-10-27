package oo1.ej17.ejercicio17_facturacionDeLlamadas;

import java.time.LocalDateTime;

public class LlamadaInternacional extends Llamada {
	
	private TarifaPais pais;
	
	public LlamadaInternacional(LocalDateTime fechaYHora, double duracion, NroTelefono telefonoOrigen, NroTelefono telefonoDestino, TarifaPais pais) {
		super(fechaYHora, duracion, telefonoOrigen, telefonoDestino);
		this.pais = pais;
	}
	
	public double calcularCosto() {
		int hora = this.getFechaYHora().getHour();
		if (hora >= 8  && hora <= 20) {
			return this.getDuracion() * this.pais.getTarifaDiurna();
		}
		return this.getDuracion() * this.pais.getTarifaNocturna();
	}
}
