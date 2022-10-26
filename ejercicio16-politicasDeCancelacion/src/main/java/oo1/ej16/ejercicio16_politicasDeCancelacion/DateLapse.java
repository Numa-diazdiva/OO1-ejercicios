package main.java.oo1.ej16.ejercicio16_politicasDeCancelacion;

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
		// Checar el último caso (other contiene a this)
		return this.includesDate(anotherDateLapse.getTo()) || this.includesDate(anotherDateLapse.getFrom()) || anotherDateLapse.includesDate(this.from);
	}
	
	/**
	 * Devuelve un objeto DateLapse que representa el solapamiento entre éste período temporal y otro período enviado por parámetro.
	 * @param anotherDateLapse
	 * @return DateLape object if there is overlaping, null if not.
	 */
	//Incluir por solapamiento y listo
	public DateLapse overlapSpan(DateLapse anotherDateLapse) {
		if (this.overlaps(anotherDateLapse)) {
			DateLapse overlapSpan;
			if (this.includesDate(anotherDateLapse.getFrom())) {
				if (this.includesDate(anotherDateLapse.getTo())) {
					overlapSpan = anotherDateLapse;
				} else {
					overlapSpan = new DateLapse(anotherDateLapse.getFrom(), this.getTo());
				}
			} else if(this.includesDate(anotherDateLapse.getTo())) {
				overlapSpan = new DateLapse(this.getFrom(), anotherDateLapse.getTo());
			} else {
				overlapSpan = this;
			}
			return overlapSpan;
		}
		return null;
	}
	
	
}
