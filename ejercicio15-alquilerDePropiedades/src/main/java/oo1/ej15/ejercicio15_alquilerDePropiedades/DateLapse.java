package oo1.ej15.ejercicio15_alquilerDePropiedades;

import java.time.LocalDate;
import java.time.Period;

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
	 * Calcula el período entre from y to.
	 * @return objeto de tipo Period
	 */
	
	private Period periodo() {
		return Period.between(this.from, this.to);
	}
	
	/**
	 * Retorna la cantidad de días entre la fecha from y la fecha to
	 */
	public int sizeInDays() {
		//return this.from.until(to).getDays();
		return this.periodo().getDays();
	}
	
	/**
	 * "Recibe un objeto LocalDate y retorna true si la fecha está entre el from y el to del receptor y false en caso contrario
	 * @param other fecha a comprobar
	 */
	public boolean includesDate(LocalDate other) {
		//La opción comentada no incluye el mismo día.
		//return other.isAfter(this.from) && other.isBefore(this.to);
		return (other.compareTo(this.from) >=0) && other.compareTo(this.to) <= 0;
	}
	
	
	/**
	 * Consulta si el período especificada se solapa con el período representado por el DateLapse
	 * @param anotherDateLapse
	 * @return true si las fechas se solapa. False si las fechas no se solapan.
	 */
	public boolean overlaps(DateLapse anotherDateLapse) {
		return this.includesDate(anotherDateLapse.getTo()) || this.includesDate(anotherDateLapse.getFrom());
	}
	
	
}
