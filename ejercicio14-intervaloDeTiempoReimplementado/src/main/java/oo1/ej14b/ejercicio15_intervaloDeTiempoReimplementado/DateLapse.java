package oo1.ej14b.ejercicio15_intervaloDeTiempoReimplementado;

import java.time.LocalDate;

public interface DateLapse {
	
	/**
	 * Retorna la fecha de inicio del rango
	 */
	public LocalDate getFrom();
	
	/**
	 * Retorna la fecha de fin del rango
	 */
	public LocalDate getTo();
	
	/**
	 * Retorna la cantidad de días entre la fecha from y la fecha to
	 */
	public int sizeInDays();
	
	/**
	 * "Recibe un objeto LocalDate y retorna true si la fecha está entre el from y el to del receptor y false en caso contrario
	 * @param other fecha a comprobar
	 */
	public boolean includesDate(LocalDate other);
}
