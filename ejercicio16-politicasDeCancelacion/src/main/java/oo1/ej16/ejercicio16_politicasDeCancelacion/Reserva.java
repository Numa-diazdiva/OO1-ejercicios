package main.java.oo1.ej16.ejercicio16_politicasDeCancelacion;

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
	
	public int solapamientoEnDias(LocalDate from, LocalDate to) {
		DateLapse otroPeriodo = new DateLapse(from, to);
		DateLapse span = this.periodo.overlapSpan(otroPeriodo);
		if (span != null) {
			return span.sizeInDays();
		}
		return 0;
	}
	
	public boolean estaOcurriendo() {
		return this.periodo.includesDate(LocalDate.now());
	}

	/**
	 * Calcula el tiempo restante para el inicio de la reserva.
	 * @param consulta
	 * @return tiempo restante en días (int).
	 */
	public int tiempoRestanteParaIniciar(LocalDate consulta) {
		int diasRestantes =  this.periodo.getFrom().compareTo(consulta);
		if (diasRestantes > 0) {
			return diasRestantes;
		}
		return 0;
	}
	
}
