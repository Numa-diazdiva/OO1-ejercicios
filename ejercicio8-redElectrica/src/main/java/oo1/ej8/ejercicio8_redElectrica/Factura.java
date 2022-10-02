package oo1.ej8.ejercicio8_redElectrica;

import java.time.LocalDate;

public class Factura {
	private double montoEnergiaActiva;
	private double descuento;
	private LocalDate fecha;
	private Usuario usuario;
	
	
	public Factura(double precioKWh, Consumo consumo, Usuario usuario) {
		this.fecha = LocalDate.now();
		this.montoEnergiaActiva = consumo.getConsumoEnergiaActiva() * precioKWh;
		if (consumo.factorDePotencia() > 0.8) {
			this.descuento = 0.1;
		} else {
			this.descuento = 0;
		}
		this.usuario = usuario;
	}
	
	public double montoTotal() {
		return this.montoEnergiaActiva * (1 - this.descuento);
	}

	public LocalDate getFecha() {
		return fecha;
	}
	
	public double getDescuento() {
		return this.descuento;
	}
	
	public Usuario getUsuario() {
		return this.usuario;
	}
	
}
