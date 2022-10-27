package oo1.ej17.ejercicio17_facturacionDeLlamadas;

import java.time.LocalDateTime;

public class LlamadaInterurbana extends Llamada {
	private double costoConexion, distanciaKM;
	
	public LlamadaInterurbana(LocalDateTime fechaYHora, double duracion, NroTelefono telefonoOrigen, NroTelefono telefonoDestino, double distanciaKM) {
		super(fechaYHora, duracion, telefonoOrigen, telefonoDestino);
		this.distanciaKM = distanciaKM;
		this.costoConexion = 5;
	}
	
	public double calcularCosto() {
		double costoMinuto  = 2;
		if(this.distanciaKM >= 100) {
			if(this.distanciaKM <= 500) {
				costoMinuto = 2.5;	
			} else{
				costoMinuto = 3;
			}
		}
		return this.costoConexion + costoMinuto * this.getDuracion();
	}
}
