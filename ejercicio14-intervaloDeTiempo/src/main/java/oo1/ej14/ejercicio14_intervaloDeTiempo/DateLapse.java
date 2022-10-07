package oo1.ej14.ejercicio14_intervaloDeTiempo;

import java.time.LocalDate;

public class DateLapse {
	private LocalDate from;
	private LocalDate to;
	
	public DateLapse(LocalDate from, LocalDate to) {
		this.from = from;
		this.to = to;
	}
	
	/**
	 * Retorna la fecha de inicio del rango
	 */
	public LocalDate getFrom() {
		return from;
	}
	
	/**
	 * Retorna la fecha de fin del rango
	 */
	public LocalDate getTo() {
		return to;
	}
	
	/**
	 * Retorna la cantidad de días entre la fecha from y la fecha to
	 */
	public int sizeInDays() {
		return this.from.until(to).getDays();
	}
	
	/**
	 * "Recibe un objeto LocalDate y retorna true si la fecha está entre el from y el to del receptor y false en caso contrario
	 * @param other fecha a comprobar
	 */
	public boolean includesDate(LocalDate other) {
		return true;
	}
	
	
}
