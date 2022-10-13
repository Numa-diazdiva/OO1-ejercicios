package oo1.ej15.ejercicio15_alquilerDePropiedades;

import java.time.LocalDate;

public class Reserva {
	private Usuario inquilino;
	private Propiedad propiedad;
	private DateLapse periodo;
	
	public Reserva(Usuario inquilino, Propiedad prop, LocalDate from, LocalDate to) {
		this.inquilino = inquilino;
		this.propiedad = prop;
		this.periodo = new DateLapse(from, to);
	}

	public DateLapse getPeriodo() {
		return periodo;
	}

	public Propiedad getPropiedad() {
		return propiedad;
	}

	public Usuario getInquilino() {
		return inquilino;
	}
	
	public boolean seSolapa(LocalDate from, LocalDate to) {
		DateLapse otroPeriodo = new DateLapse(from, to);
		return this.periodo.overlaps(otroPeriodo);
	}
	
	public boolean estaOcurriendo() {
		return this.periodo.includesDate(LocalDate.now());
	}
	
}
